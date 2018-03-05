package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import impl.robot.T1000;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ap = new AnnotationConfigApplicationContext(T1000.class);

		T1000 t1000 = (T1000) ap.getBean("model1");
		t1000.action();

	}

}
