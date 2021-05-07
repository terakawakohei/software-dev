package se.t1835039.janken.app;

import se.t1835039.janken.entity.InvincibleStrategy;
import se.t1835039.janken.entity.Player;
import se.t1835039.janken.util.KeyBoard;

public class Menu {
	/**
	 * ジャンケンゲームのインターフェース部分.設定を入力し、終了時に結果を保存する
	 * @author Kohei Terakawa
	 *
	 */

	private RPSGame game = new RPSGame();

	public Menu() {

	}

	public void startSetting() {
		System.out.println("■じゃんけんゲームアプリを起動します．");
		System.out.print("名前を入力してください :");
		String playerName = KeyBoard.inputString();

		if (playerName.equals("")) {
			playerName = "名無しユーザ";
		}

		inputParticipantsNum();

		inputMatchNum();

		game.addPlayer(playerName);
		System.out.println("○新しいユーザ「" + playerName + "」さんを作成しました．");

		for (int cpuNum = 1; cpuNum <= game.getParticipantsNum() - 1; cpuNum++) {

			game.addPlayer("CPU" + cpuNum,new InvincibleStrategy());
			System.out.println("○新しいCPU「CPU" + cpuNum + "」さんを作成しました．");
		}

		//参加者を全員表示
		for (Player p : game.getPlayerList()) {
			System.out.println("○「" + p.getName() + "」さんをゲームに登録しました．");
		}

		System.out.println("○じゃんけん回数を " + game.getMatchNum() + " 回にセットしました．");
	}

	public void inputParticipantsNum() {
		System.out.print("何人で遊びますか？(2以上の整数) :");
		int participants = KeyBoard.inputNumber();

		if (participants < 2) {
			System.out.println("2以上の整数を入力してください");
			inputParticipantsNum();
		} else
			game.setParticipantsNum(participants);

	}

	public void inputMatchNum() {
		System.out.print("何回戦しますか？(1以上の整数) :");
		int matchNum = KeyBoard.inputNumber();

		if (matchNum < 1) {
			System.out.println("1以上の整数を入力してください");
			inputMatchNum();
		} else
			game.setMatchNum(matchNum);

	}

	public RPSGame getGame() {
		return game;
	}

	public void setGame(RPSGame game) {
		this.game = game;
	}

}
