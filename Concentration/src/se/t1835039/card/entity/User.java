package se.t1835039.card.entity;

import java.util.List;

import se.t1835039.card.game.ConcentrationGame;
import se.t1835039.card.game.KeyBoard;

/**
 * 　神経衰弱のユーザプレイヤ.ユーザがキーボードからめくるカードを選択する
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public class User extends Player {

	public User() {
		super();
	}

	public User(String name) {
		super(name);
	}

	/**
	 * ユーザがめくるカードを選ぶ．
	 */
	@Override
	public int selectFirstCard(List<Integer> opened, List<Card> table) {

		System.out.println("めくるカードを指定してください ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		int column, row;
		do {
			System.out.print("１枚目 : 行 (1〜8行) →");
			column = KeyBoard.inputNumber();
		} while (column < 1 || column > 8);

		do {
			System.out.print("１枚目 : 列 (1〜7列) →");
			row = KeyBoard.inputNumber();
		} while (row < 1 || row > 7 || (column == 8 && row > 3));

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		int cardIndex = ConcentrationGame.ConvertIndex(column, row);

		boolean CardIsOpened = checkOpened(opened, cardIndex);

		if (CardIsOpened) {
			System.out.println("すでに開示されているカードです");
			return -1;
		} else
			return cardIndex;

	}

	/**
	 * ユーザがめくるカードを選ぶ．
	 */
	@Override
	public int selectSecondCard(List<Integer> opened, List<Card> table) {

		System.out.println("めくるカードを指定してください ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		int column, row;
		do {
			System.out.print("１枚目 : 行 (1〜8行) →");
			column = KeyBoard.inputNumber();
		} while (column < 1 || column > 8);

		do {
			System.out.print("１枚目 : 列 (1〜7列) →");
			row = KeyBoard.inputNumber();
		} while (row < 1 || row > 7 || (column == 8 && row > 3));

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		int cardIndex = ConcentrationGame.ConvertIndex(column, row);

		boolean CardIsOpened = checkOpened(opened, cardIndex);

		if (CardIsOpened) {
			System.out.println("すでに開示されているカードです");
			return -1;
		} else
			return cardIndex;

	}

}
