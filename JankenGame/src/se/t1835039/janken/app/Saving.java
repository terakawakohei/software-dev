package se.t1835039.janken.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import se.t1835039.janken.entity.Player;

public class Saving {

	private RPSGame game = new RPSGame();
	private String fileName;

	public Saving() {

	}

	public Saving(RPSGame game) {
		this.game = game;
	}

	public void saveResult() {

		Player player = new Player();
		player = game.getPlayerList().get(0);

		System.out.println("■" + player.getName() + "さんの対戦成績をファイルに追記します．");

		//現在日時の取得
		Date d = new Date();

		//書式の作成
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		System.out.println(sdf.format(d) + "," + player.getName() + "," + game.getParticipantsNum() + ","
				+ game.getMatchNum() + "," + player.getWin() + "," + player.getLose() + "," + player.getDraw());

		try {

			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));

			pw.println(sdf.format(d) + "," + player.getName() + "," + game.getParticipantsNum() + ","
					+ game.getMatchNum() + "," + player.getWin() + "," + player.getLose() + "," + player.getDraw());

			pw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("完了しました.");
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
