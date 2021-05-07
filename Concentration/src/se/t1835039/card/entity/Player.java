package se.t1835039.card.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 　神経衰弱のプレイヤークラス
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public abstract class Player {

	public Player() {

	}

	/**名前*/
	protected String name;
	/**１枚目にめくったカードの数字*/
	protected int firstOpenedCardNumber;
	/**１枚目にめくったカードのindex*/
	protected int firstOpenedCardIndex;
	/**獲得したカード*/
	protected List<Integer> ownCards = new ArrayList<Integer>();
	/**
	 * プレイヤによってめくられ、数字が公開されたカードの情報
	 * （獲得できる可能性のあるカード）
	 */
	public static Map<Integer, Integer> acquirableCards = new HashMap<Integer, Integer>();

	/**
	 * 名前を指定してプレイヤを作成する
	 * @param name 名前
	 */
	public Player(String name) {
		this.name = name;
	}

	/**
	 * １枚目にめくるカードを選ぶ
	 *
	 * @param opened 場のカードがめくられているなら1,伏せられているなら0が入っている、tableのindexと関連している
	 * @param table 場に並べられているカードの情報、openedのindexと関連している
	 * @return めくったカードの、場におけるindex
	 */
	public abstract int selectFirstCard(List<Integer> opened, List<Card> table); //定義は子クラスに任せる

	/**
	 * ２枚目にめくるカードを選ぶ
	 *
	 * @param opened 場のカードがめくられているなら1,伏せられているなら0が入っている、tableのindexと関連している
	 * @param table 場に並べられているカードの情報、openedのindexと関連している
	 * @return めくったカードの、場におけるindex
	 */
	public abstract int selectSecondCard(List<Integer> opened, List<Card> table); //定義は子クラスに任せる

	/**
	 * 場にあるカードがすでにめくられているかどうかチェックする
	 * @param opened 場のカードがめくられているなら1,伏せられているなら0が入っている、
	 * @param index めくるカードの位置
	 * @return 真偽値(めくられているならtrue)
	 */
	public boolean checkOpened(List<Integer> opened, int index) {
		if (opened.get(index) == 1) {
			return true;
		} else
			return false;
	}

	/**
	 * 受け取った数字が、最初にめくったカードの数字と同じかどうかチェックする
	 * @param cardNumber ２枚目にめくったカードの数字
	 * @return 真偽値（同じならtrue）
	 */
	public boolean IsSameFirstCardNum(int cardNumber) {
		if (firstOpenedCardNumber == cardNumber) {
			return true;
		} else
			return false;
	}

	/**
	 * プレイヤの持つ獲得カードを表示
	 */
	public void showCards() {
		System.out.println(name + "の獲得カード");

		for (int c : ownCards) {
			System.out.print("[" + c + "]" + "×2,");
		}
		System.out.println();

		System.out.println("計" + getOwnCardNum() + "枚");
	}

	/**
	 * めくったカードの数字が一致した時の処理
	 *
	 * @param opened　場のカードがめくられているなら1,伏せられているなら0が入っている、
	 * @param secondOpenedNumber　２枚目にめくられたカードの数字
	 * @param secondCardIndex ２枚目にめくられたカードのindex
	 */
	public void succeed(List<Integer> opened, int secondOpenedNumber, int secondCardIndex) {

		//裏返すカードの場所(index)を1にする
		opened.set(secondCardIndex, 1);

		System.out.println("一致！！" + secondOpenedNumber + "を二枚獲得");

		//獲得したカードを保存
		storeOwnCard(secondOpenedNumber);
	}

	/**
	 * めくったカードの数字が一致しなかった時の処理
	 * @param opened　場のカードがめくられているなら1,伏せられているなら0が入っている、
	 * @param firstCardIndex １枚目にめくられたカードのindex
	 * @param secondCardIndex ２枚目にめくられたカードのindex
	 */
	public void failed(List<Integer> opened, int firstCardIndex, int secondCardIndex) {

		System.out.println("残念...");
		//１枚目、２枚目ともに裏返したカードを元に戻す
		opened.set(firstCardIndex, 0);
		opened.set(secondCardIndex, 0);
	}

	/**
	 * 名前を取得する
	 *
	 * @return 名前
	 */
	public String getName() {
		return name;
	}

	/**
	 * 獲得カードの枚数を返す
	 * @return 獲得カード枚数
	 */
	public int getOwnCardNum() {
		return ownCards.size() * 2;
	}

	/**
	 * １枚目にめくったカードを記憶しておく
	 * @param cardNumber めくったカードの数字
	 * @param cardIndex めくったカードのindex
	 */
	public void storeFirstOpenedCard(int cardNumber, int cardIndex) {
		firstOpenedCardNumber = cardNumber;
		firstOpenedCardIndex = cardIndex;

	}

	/**
	 * 獲得したカードの数字を保存する
	 * @param cardNumber 獲得したカードの数字
	 */
	public void storeOwnCard(int cardNumber) {
		ownCards.add(cardNumber);
	}

	/**
	 * プレイヤがめくったカード（プレイヤに数字が確認されたカード）を記憶しておく
	 * @param cardNumber めくったカードの数字
	 * @param index めくったカードのindex
	 */
	public void storeAcquirableCard(int cardNumber, int index) {
		acquirableCards.put(index, cardNumber);
	}

	/**
	 * プレイヤがすでにめくったカードの中から、プレイヤに獲得されたものを削除する
	 * @param cardNumber プレイヤに獲得されたカードの数字
	 * @param index　プレイヤに獲得されたカードのindex
	 */
	public void deleteAcquirableCard(int cardNumber, int index) {
		acquirableCards.remove(index, cardNumber);
	}

	/**
	 * プレイヤに数字が確認されたカードの情報を渡す
	 * @return プレイヤに確認されたカードの情報
	 */
	public Map<Integer, Integer> getAcquirableCard() {
		return acquirableCards;
	}

}
