package tn.esprit.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class NameAspect {
	@AfterReturning("execution(* tn.esprit.spring.services.*.ajouter*(..))")
	public void logMethodExit1(JoinPoint joinPoint) throws Throwable {
		// String name = joinPoint.getSignature().getName();
		log.info("Gestion match: ajout réaliser avec succès");
	}
}
