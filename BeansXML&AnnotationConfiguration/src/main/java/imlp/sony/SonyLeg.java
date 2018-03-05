package imlp.sony;

import org.springframework.stereotype.Component;

import interfaces.Leg;

@Component
public class SonyLeg implements Leg {

	@Override
	public void go() {
		System.out.println("Sony Leg");

	}

}
