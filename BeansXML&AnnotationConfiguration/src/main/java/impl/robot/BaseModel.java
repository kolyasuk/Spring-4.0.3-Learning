package impl.robot;

import javax.inject.Inject;

import interfaces.Hand;
import interfaces.Head;
import interfaces.Leg;
import interfaces.Robot;

public abstract class BaseModel implements Robot {

	@Inject
	private Hand hand;
	@Inject
	private Head head;
	@Inject
	private Leg leg;

	/*
	 * public BaseModel() { System.out.println("Base model"); }
	 * 
	 * public BaseModel(Hand hand, Head head, Leg leg) {
	 * System.out.println("Base model"); this.hand = hand; this.head = head;
	 * this.leg = leg; }
	 */
	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Head getHead() {
		return head;
	}

	public void setHead(Head head) {
		this.head = head;
	}

	public Leg getLeg() {
		return leg;
	}

	public void setLeg(Leg leg) {
		this.leg = leg;
	}
}
