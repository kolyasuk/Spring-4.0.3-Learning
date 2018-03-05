package imlp.sony;

import org.springframework.stereotype.Component;

import interfaces.Head;

@Component
public class SonyHead implements Head {

	String color;

	@Override
	public void calc() {
		System.out.println("Sony Head " + this.getColor());

	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
