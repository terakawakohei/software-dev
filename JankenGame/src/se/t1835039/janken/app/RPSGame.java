package se.t1835039.janken.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import se.t1835039.janken.entity.Player;
import se.t1835039.janken.entity.Strategy;
import se.t1835039.janken.util.KeyBoard;

public class RPSGame {
	/**
	 * ジャンケンを行う部分.勝敗の判定などを行う
	 * @author Kohei Terakawa
	 *
	 */

	private int matchNum;
	private int participantsNum;
	private ArrayList<Player> players = new ArrayList<Player>();

	public RPSGame() {

	}

	public void match() {

		//playersの先頭がユーザーになる
		Player player = new Player();
		player = players.get(0);

		System.out.println("■じゃんけんゲームを開始します．" + matchNum + "回戦です．");

		for (int i = 1; i <= matchNum; i++) {
			System.out.println("--------------      第" + i + "回戦      --------------");

			inputHand();

			System.out.println("＃＃＃＃＃＃＃じゃんけん，ぽん！！＃＃＃＃＃＃＃");

			//手の表示

			System.out.println("■" + player.getName() + "さんの手は，" + player.getOwnHand().getHand());

			for (int cpuNum = 1; cpuNum <= participantsNum - 1; cpuNum++) {

				System.out.println("■CPU" + cpuNum + "さんの手は，" + players.get(cpuNum).getOwnHand().getHand());

			}

			//勝負の判定
			judge(players);

		}
		//最終的な結果を表示
		showFinalResult(players);

	}

	public void judge(ArrayList<Player> players) {

		Map<Integer, String> allHands = new HashMap<Integer, String>();

		ArrayList<String> winner = new ArrayList<String>();
		ArrayList<String> loser = new ArrayList<String>();

		int counter = 0;

		for (Player p : players) {

			if (p.getOwnHand().getHand().equals("グー")) {
				allHands.put(counter, "グー");
			} else if (p.getOwnHand().getHand().equals("チョキ")) {
				allHands.put(counter, "チョキ");
			} else if (p.getOwnHand().getHand().equals("パー")) {
				allHands.put(counter, "パー");
			}

			counter++;
		}

		if (allHands.containsValue("グー") && allHands.containsValue("チョキ") && allHands.containsValue("パー")) {//全て異なる手でのあいこ
			System.out.println("引き分け！");

			for (Player p : players) {
				p.addDraw();
			}

		} else if (allHands.containsValue("グー") && allHands.containsValue("チョキ")) {//グーで勝つ時

			for (Player p : players) {
				if (p.getOwnHand().getHand().equals("グー")) {
					winner.add(p.getName());
					p.addWin();
				} else {
					loser.add(p.getName());
					p.addLose();
				}
			}

			System.out.println("勝ち手は、グー");

			showResult(winner, loser);

		} else if (allHands.containsValue("チョキ") && allHands.containsValue("パー")) {//チョキで勝つ時

			for (Player p : players) {
				if (p.getOwnHand().getHand().equals("チョキ")) {
					winner.add(p.getName());
					p.addWin();
				} else {
					loser.add(p.getName());
					p.addLose();
				}
			}

			System.out.println("勝ち手は、チョキ");

			showResult(winner, loser);

		} else if (allHands.containsValue("パー") && allHands.containsValue("グー")) {//パーで勝つ時

			for (Player p : players) {
				if (p.getOwnHand().getHand().equals("パー")) {
					winner.add(p.getName());
					p.addWin();
				} else {
					loser.add(p.getName());
					p.addLose();
				}
			}
			System.out.println("勝ち手は、パー");

			showResult(winner, loser);
		} else {//全員同じ手になってのあいこ
			System.out.println("引き分け！");

			for (Player p : players) {
				p.addDraw();
			}
		}

	}

	public void inputHand() {
		System.out.print("◎" + players.get(0).getName() + "さんの手を入力してください[0:グー　1:チョキ　2:パー]：");

		int handNum = KeyBoard.inputNumber();
		if (handNum < 0 || 2 < handNum) {
			System.out.println("[0:グー　1:チョキ　2:パー]のいずれかを入力してください");
			inputHand();
		} else {

			players.get(0).decideHand(handNum);

			for (int cpuNum = 1; cpuNum <= participantsNum - 1; cpuNum++) {

				System.out.println("○CPU" + cpuNum + "が手を決めています．");
				players.get(cpuNum).decideByStrategy(handNum);
			}
		}

	}

	public void showResult(ArrayList<String> winner, ArrayList<String> loser) {

		System.out.println("○勝ち：");
		for (String w : winner)
			System.out.print(w + "さん,");
		System.out.println();

		System.out.println("○負け：");
		for (String l : loser)
			System.out.print(l + "さん,");
		System.out.println();

	}

	public void showFinalResult(ArrayList<Player> players) {
		System.out.println("-------- 総合成績 ---------");

		for (Player p : players) {
			System.out.println(
					"#" + p.getName() + "さんの対戦成績 :" + p.getWin() + "勝" + p.getLose() + "敗" + p.getDraw() + "分");
		}

	}

	public void addPlayer(String name) {
		Player p = new Player();

		p.setName(name);


		players.add(p);
	}

	public void addPlayer(String name,Strategy strategy) {

		Player p = new Player(name,strategy);




		players.add(p);
	}

	public ArrayList<Player> getPlayerList() {
		return players;
	}

	public void setMatchNum(int matchNum) {
		this.matchNum = matchNum;
	}

	public void setParticipantsNum(int participants) {
		this.participantsNum = participants;
	}

	public int getMatchNum() {
		return matchNum;
	}

	public int getParticipantsNum() {
		return participantsNum;
	}

}
