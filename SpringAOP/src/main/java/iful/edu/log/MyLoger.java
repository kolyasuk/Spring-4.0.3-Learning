package iful.edu.log;

import java.util.Map;
import java.util.Set;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyLoger {

	// advice
	@Pointcut("execution(* iful.edu.interfaces.Manager.*(..))")
	private void meth() {
	}

	// advice
	@Pointcut("@annotation(iful.edu.annotation.ShowResult)")
	private void showResult() {
	}

	// advice
	@Pointcut("@annotation(iful.edu.annotation.ShowTime)")
	private void showTime() {

	}

	@Around("meth() && showTime() && execution(java.util.Map *(..))")
	public Object watchTime(ProceedingJoinPoint point) {
		long startTime = System.currentTimeMillis();

		System.out.println("Method Strt - " + point.getSignature().toString());

		Object out = null;

		try {
			out = point.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}

		long time = System.currentTimeMillis() - startTime;
		System.out.println("Method End - " + point.getSignature().toShortString() + ", time:" + time);

		return out;
	}

	@AfterReturning(pointcut = "meth() && showResult() && execution(java.util.Map *(String)) && args(path)", returning = "obj")
	public void printMap(Object obj, String path) {
		for (Map.Entry<String, Integer> x : ((Map<String, Integer>) obj).entrySet()) {
			System.out.println(x.getKey() + " - " + x.getValue());
		}

	}

	@AfterReturning(pointcut = "meth() && showResult()  && execution(java.util.Set *(String)) && args(path)", returning = "obj")
	public void printSet(Object obj, String path) {
		System.out.println(path);
		for (String x : (Set<String>) obj) {
			System.out.println(x);
		}
	}

}
