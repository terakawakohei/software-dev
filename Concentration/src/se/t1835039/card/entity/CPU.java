package se.t1835039.card.entity;

import java.util.List;

/**
 * 　神経衰弱のCPUプレイヤ.持っているStrategyによってめくるカードを決める
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public class CPU extends Player {
	/**１枚目にめくるカードを選ぶ戦略*/
	protected Strategy firstStrategy;
	/**２枚目にめくるカードを選ぶ戦略*/
	protected Strategy secondStrategy;

	public CPU() {
		super();
	}

	/**
	 * 名前と１枚目、２枚目にめくるカードの戦略を指定してCPUプレイヤを作成する
	 * @param name 名前
	 * @param firstStrategy 1枚目にめくるカードを選ぶ戦略
	 * @param secondStrategy 2枚目にめくるカードを選ぶ戦略
	 */
	public CPU(String name, Strategy firstStrategy, Strategy secondStrategy) {
		super(name);
		this.firstStrategy = firstStrategy;
		this.secondStrategy = secondStrategy;
	}

	/**
	 * １枚目にCPUがめくるカードを選ぶ
	 */
	@Override
	public int selectFirstCard(List<Integer> opened, List<Card> table) {

		return firstStrategy.selectCard(opened, table, acquirableCards, firstOpenedCardNumber, firstOpenedCardIndex);

	}

	/**
	 * ２枚目にCPUがめくるカードを選ぶ
	 */
	@Override
	public int selectSecondCard(List<Integer> opened, List<Card> table) {

		return secondStrategy.selectCard(opened, table, acquirableCards, firstOpenedCardNumber, firstOpenedCardIndex);
	}

}
