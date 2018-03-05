package impl.robot;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import interfaces.Hand;
import interfaces.Head;
import interfaces.Leg;

@Configuration
@ComponentScan({ "*" })
public class T1000 extends BaseModel implements InitializingBean, DisposableBean {

	private String color;
	private int year;
	private boolean sound;

	public T1000() {
		super();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public T1000 model1() {
		return new T1000();
	}

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public T1000 model2() {
		return new T1000("Black", 2018, true);
	}

	public T1000(String color, int year, boolean sound) {
		super();
		this.color = color;
		this.year = year;
		this.sound = sound;
	}

	/*
	 * public T1000(Hand hand, Head head, Leg leg) { super(hand, head, leg); }
	 */

	public T1000(Hand hand, Head head, Leg leg, String color, int year, boolean sound) {
		// super(hand, head, leg);
		this.color = color;
		this.year = year;
		this.sound = sound;
	}

	@Override
	public void action() {
		if (getHand() != null)
			getHand().catchSmth();
		else
			System.out.println("null");
		if (getHead() != null)
			getHead().calc();
		else
			System.out.println("null");
		if (getLeg() != null)
			getLeg().go();
		else
			System.out.println("null");
		System.out.println(color + " " + year + " " + sound);
	}

	@Override
	public void dance() {
		System.out.println("T1000 is dancing");

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public boolean isSound() {
		return sound;
	}

	public void setSound(boolean sound) {
		this.sound = sound;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("init");

	}

	@Override
	public void destroy() throws Exception {
		System.out.println("destroy");
	}

}
