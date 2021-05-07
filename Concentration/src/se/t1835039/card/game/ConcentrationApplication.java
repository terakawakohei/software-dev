package se.t1835039.card.game;

import se.t1835039.card.entity.CPU;
import se.t1835039.card.entity.CheatStrategy;
import se.t1835039.card.entity.NeverForgetStrategy;
import se.t1835039.card.entity.NormalStrategy;
import se.t1835039.card.entity.Player;
import se.t1835039.card.entity.RandomStrategy;
import se.t1835039.card.entity.User;

/**
 * 神経衰弱ゲームアプリ
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public class ConcentrationApplication {
	/*** 神経衰弱ゲームアプリ*/
	private ConcentrationGame game = new ConcentrationGame();

	public ConcentrationApplication() {

	}

	/**
	 * アプリを開始する
	 */
	public void startApp() {
		System.out.println("神経衰弱を始めます");

		initialize();//初期設定をして

		doGame();//ゲーム開始
	}

	/**
	 * 神経衰弱の初期設定をする
	 */
	public void initialize() {
		System.out.println("初期設定をします");

		System.out.print("名前を入力してください :");
		String userName = KeyBoard.inputString();

		//ユーザの登録
		User user = new User(userName);
		game.addPlayer(user);

		System.out.print("何人のCPUと戦いますか？ :");
		int cpuNum = KeyBoard.inputNumber();

		//強さ選択
		System.out.println("CPUのつよさを選択してください");

		//難易度に応じたCPUを登録
		for (int i = 1; i <= cpuNum; i++) {

			int level;
			do {
				System.out.print("よわい : 1 / ふつう : 2 / 最強 : 3  →");
				level = KeyBoard.inputNumber();
			} while (level < 1 || level > 3);

			if (level == 1) {
				//１枚目をランダム、２枚目もランダムに選ぶ
				CPU cpu = new CPU("CPU" + i, new RandomStrategy(), new RandomStrategy());
				game.addPlayer(cpu);
			} else if (level == 2) {
				//１枚目はすでにめくられたカードをめくり、２枚目は1/2の確率で正解をめくる
				CPU cpu = new CPU("CPU" + i, new NeverForgetStrategy(), new NormalStrategy());
				game.addPlayer(cpu);
			} else if (level == 3) {
				//１枚目はすでにめくられたカードをめくり、２枚目は正解のカードを必ずめくる
				CPU cpu = new CPU("CPU" + i, new NeverForgetStrategy(), new CheatStrategy());
				game.addPlayer(cpu);
			}

		}

		for (Player p : game.getPlayers()) {
			System.out.println(p.getName());
		}
		System.out.println("が参加しました");

	}

	/**
	 * 神経衰弱を行う
	 */
	public void doGame() {
		game.startGame();
	}
}
