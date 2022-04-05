package com.agence.frota.sfbean.aop.aspect;

import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.agence.frota.dto.GenericResponse;
import com.agence.frota.dto.GenericResponse.GenericResponseAttribute;

@Aspect
@Component
public class DataIntegrityViolationExceptionAspect {

	@Around("@annotation(com.agence.frota.sfbean.aop.annotations.DataIntegrityViolationJoinPoint)")
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable {
		try {
			return joinpoint.proceed();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new GenericResponse(409,
					"Unique Constraint violation!", Set.of(new GenericResponseAttribute("Error", "Error"))));
		} 
	}
}
