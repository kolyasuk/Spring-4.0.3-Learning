package imlp.sony;

import javax.inject.Named;

import interfaces.Hand;

@Named
public class SonyHand implements Hand {

	@Override
	public void catchSmth() {
		System.out.println("Sony Hand");
	}

}
