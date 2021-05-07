package se.t1835039.janken.entity;

public class Player {
	/**
	 * じゃんけんに参加するプレイヤー
	 * @author Kohei Terakawa
	 *
	 */
	private String name;
	private Hand ownHand = new Hand();
	private int win;
	private int lose;
	private int draw;

	 private Strategy strategy;

	 public Player() {

	 }

	public Player(String name,Strategy strategy) {

		this.name=name;
		this.strategy=strategy;

		win = 0;
		lose = 0;
		draw = 0;

	}

	public void decideHand(int num) {

		ownHand.selectHand(num);

	}

	public void decideByStrategy(int playerHandNum) {

		if (strategy instanceof InvincibleStrategy) {
			ownHand.selectHand(strategy.getHand(playerHandNum));
		}else ownHand.selectHand(strategy.getHand(0));



	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Hand getOwnHand() {
		return ownHand;
	}

	public void setOwnHand(Hand ownHand) {
		this.ownHand = ownHand;
	}

	public int getWin() {
		return win;
	}

	public void addWin() {
		this.win++;
	}

	public int getLose() {
		return lose;
	}

	public void addLose() {
		this.lose++;
	}

	public int getDraw() {
		return draw;
	}

	public void addDraw() {
		this.draw++;
	}

}
