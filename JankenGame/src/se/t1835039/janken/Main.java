package se.t1835039.janken;

import se.t1835039.janken.app.Menu;
import se.t1835039.janken.app.RPSGame;
import se.t1835039.janken.app.Saving;

public class Main {

	public static void main(String[] args) {
		Menu mn = new Menu();
		RPSGame rps = new RPSGame();

		mn.setGame(rps);
		mn.startSetting();

		rps.match();

		Saving s = new Saving(rps);
		s.setFileName("result.csv");
		s.saveResult();

	}
}
