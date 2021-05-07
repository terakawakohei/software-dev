package se.t1835039.janken.entity;

import java.util.ArrayList;

public class Hand {

	/**
	 * じゃんけんに登場する手
	 * @author Kohei Terakawa
	 *
	 */

	private ArrayList<String> hand = new ArrayList<String>();
	private String nowHand;

	public Hand() {
		hand.add("グー");
		hand.add("チョキ");
		hand.add("パー");

	}

	public void selectHand(int num) {
		nowHand = hand.get(num);
	}



	public String getHand() {
		return nowHand;
	}

}
