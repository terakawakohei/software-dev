package se.t1835039.card.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import se.t1835039.card.entity.Card;
import se.t1835039.card.entity.CardDeck;
import se.t1835039.card.entity.Player;
import se.t1835039.card.entity.User;

/**
 * 神経衰弱ゲームクラス
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public class ConcentrationGame {

	/*** 参加プレイヤーリスト*/
	private List<Player> players = new ArrayList<Player>();
	/*** 場に存在するカード*/
	private List<Card> table = new ArrayList<Card>();
	/*** 場のカードがめくられているかどうかを保存する
	 * tableのindexに対応して、伏せられたカードは0,めくられたカードは1が入る*/
	private List<Integer> opened = new ArrayList<Integer>();
	/** * 神経衰弱に用いるカードデッキ */
	private CardDeck deck = new CardDeck();

	public ConcentrationGame() {

	}

	/**
	 * プレイヤを追加する
	 * @param player　神経衰弱に参加するプレイヤ
	 */
	public void addPlayer(Player player) {
		players.add(player);

	}

	/**
	 * 全プレイヤのリストを取得する
	 * @return　全プレイヤのリスト
	 */
	public List<Player> getPlayers() {
		return players;
	}

	/**
	 * ゲームを開始する.場のカードが全てめくられるまで、全員の手番を繰り返す
	 */
	public void startGame() {
		//52枚のカードデッキを生成
		deck.createFullDeck();
		//シャッフルしてランダムな順番にする
		deck.shuffle();

		//場（table）にカードを並べる
		for (Card c : deck.getAllCards()) {
			table.add(c);
			opened.add(0);//最初は全て伏せた状態（0）に設定
		}

		//いったん表示
		showAllCards();

		//場のカードが全てめくられる(openedが全て1になる)まで繰り返す
		while (!(checkAllOpened())) {
			doOneTurn();
		}

		System.out.println("ゲーム終了!!");

		showResult();

	}

	/**
	 * 全員の手番を回す
	 */
	public void doOneTurn() {

		for (Player p : players) {

			//めくるカードが残っているかチェック.残っていないならゲーム終了
			if (checkAllOpened())
				break;

			//１枚目のカードをめくる
			int firstCardIndex;

			//最初にめくるカードの位置（firstCardIndex,openedのインデックスにあたる）を決定
			do {
				firstCardIndex = p.selectFirstCard(opened, table);
			} while (firstCardIndex == -1);

			//めくるカードが確定

			//めくるカードの場所(index)を1にする
			opened.set(firstCardIndex, 1);

			//めくるカードの数字を取り出す(めくる場所=tableのインデックス)
			int firstOpenedNumber = table.get(firstCardIndex).getNumber();
			//１枚目にめくったカードを記憶しておく
			p.storeFirstOpenedCard(firstOpenedNumber, firstCardIndex);

			System.out.println(p.getName() + "が一枚目に" + firstCardIndex + "の" + firstOpenedNumber + "をめくりました");
			showAllCards();

			//めくってプレイヤーに数字が確認されたことを記録
			p.storeAcquirableCard(firstCardIndex, firstOpenedNumber);

			//ここまでで１枚目の開示が終了、次に２枚目

			//２枚目のカードをめくる
			int secondCardIndex;

			//２枚目にめくるカードの位置（secondCardIndex,openedのインデックスにあたる）を決定
			do {
				secondCardIndex = p.selectSecondCard(opened, table);
			} while (secondCardIndex == -1);
			//めくるカードが確定

			//めくるカードの場所(index)を1にする

			//めくるカードの数字を取り出す(めくる場所=tableのインデックス)
			int secondOpenedNumber = table.get(secondCardIndex).getNumber();

			System.out.println(p.getName() + "が二枚目に" + secondCardIndex + "の" + secondOpenedNumber + "をめくりました");

			//２枚目にめくったカードの数字が１枚目のカードと一致するか確かめる

			if (p.IsSameFirstCardNum(secondOpenedNumber)) {
				//一致した時

				//成功処理
				p.succeed(opened, secondOpenedNumber, secondCardIndex);
				showAllCards();

				//めくられたので、プレイヤーに確認された(めくられる可能性のある)カードから削除
				p.deleteAcquirableCard(firstCardIndex, firstOpenedNumber);
				p.deleteAcquirableCard(secondCardIndex, secondOpenedNumber);

			} else {
				//一致しなかった時

				//いったんカードをめくって表示する
				opened.set(secondCardIndex, 1);
				showAllCards();

				//めくってプレイヤーに確認されたことを記録
				p.storeAcquirableCard(secondCardIndex, secondOpenedNumber);

				//失敗処理
				p.failed(opened, firstCardIndex, secondCardIndex);
			}

			//ユーザなら、場の様子を確認する猶予を与える
			if (p instanceof User) {

				int endUserTurn;
				do {
					System.out.print("次のターンにすすむ → 1を入力 :");
					endUserTurn = KeyBoard.inputNumber();
				} while (endUserTurn != 1);

			} else
				//CPUなら、すぐ次のプレイヤへ
				System.out.println(p.getName() + "のターン終了");
			System.out.println("----------------------------------------");
			showAllCards();
			System.out.println("----------------------------------------");

		}

	}

	/**
	 * 場のカードの状況を見せる.
	 * openedが0になっているカードは伏せる.1のカードは開示.
	 */
	public void showAllCards() {
		System.out.println("");

		//場に52枚のカードを8行7列で表示させる
		//7枚表示したら改行する
		int br = 1;

		//何行目の表示をしているか管理
		int column = 1;

		//列の表示ガイド
		System.out.println("|__|列|_1|_2|_3|_4|_5|_6|_7|");
		System.out.println("|行|__|--|--|--|--|--|--|--|");
		System.out.print("|_" + column + "|--");

		for (int i = 0; i < opened.size(); i++) {

			if (opened.get(i) == 0) {
				//カードが裏（0）の状態の時
				System.out.print("| *");

			} else if (opened.get(i) == 1) {
				//カードが表（openedが1）の状態の時

				//きれいに表示させるため、カードの数字が一桁の場合空白文字を入れる
				int cardNum = table.get(i).getNumber();

				if (cardNum < 10)
					System.out.print("| " + cardNum);
				else
					System.out.print("|" + cardNum);
			}

			br++;

			if (br == 8) {
				//8列めは表示しない
				System.out.println("|");
				br = 1;

				//行の表示ガイド
				column++;

				System.out.print("|_" + column + "|--");

			}
		}
		System.out.println("|");
		System.out.println("");

	}

	/**
	 * 全員の取得カードの枚数から順位を発表する
	 */
	public void showResult() {
		System.out.println("-----------------成績発表----------------");

		//プレイヤの名前とそのプレイヤの取得カードの枚数をいれる
		//カード枚数から順位づけの計算をするをするために用いる
		Map<String, Integer> result = new HashMap<String, Integer>();

		//全員の取得カードを表示し、resultに値を入れる
		for (Player p : players) {
			System.out.println("----------------------------------------");
			p.showCards();

			result.put(p.getName(), p.getOwnCardNum());

			System.out.println("----------------------------------------");
		}

		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(result.entrySet());

		//  比較関数Comparatorを使用して降順にする
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			//compareを使用して値を比較する
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				//降順
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});

		//これで、獲得カードの降順に並べ替えたlist_entries<名前、獲得カード>が得られた

		System.out.println("-----------------順位発表----------------");

		int order = 1;
		int tie = list_entries.get(0).getValue();

		for (Entry<String, Integer> entry : list_entries) {

			if (tie == entry.getValue()) {
				System.out.println(order + "位 : " + entry.getKey() + "   :" + entry.getValue() + "枚");
				tie = entry.getValue();
			} else {
				order++;
				System.out.println(order + "位 : " + entry.getKey() + "   :" + entry.getValue() + "枚");
				tie = entry.getValue();

			}

		}

		System.out.println("-------------------------------------");
	}

	/**
	 * 場でのカードの指定(何行目、何列)をopenedでのindexに変換する
	 * @param column 選ぶ場のカードの行
	 * @param row 選ぶカードの列
	 * @return　選ぶカードのopenedでのindex
	 */
	public static int ConvertIndex(int column, int row) {
		if (column == 1)
			return row - 1;
		else
			return 7 * (column - 1) + (row) - 1;

	}

	/**
	 * 場のカードが全てめくられたかどうか確認する
	 * @return 真偽値（全てめくられていたらtrue）
	 */
	public boolean checkAllOpened() {
		int sum = 0;
		for (int l : opened) {
			sum += l;
		}
		if (sum == table.size())
			return true;
		else
			return false;
	}

}
