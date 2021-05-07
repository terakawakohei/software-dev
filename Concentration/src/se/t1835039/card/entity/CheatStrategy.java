package se.t1835039.card.entity;

import java.util.List;
import java.util.Map;

/**
 * 　※※※※※２枚目にめくるカードを選ぶ戦略※※※※※
 *
 * １枚目にめくったカード(firstOpenedCardNumber,firstOpenedCardIndex)をみて、そのカードを場から選んでめくる
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public class CheatStrategy implements Strategy {
	/**
	 * めくるカードを決める
	 *
	 * @param opened 場のカードがめくられているなら1,伏せられているなら0が入っている、tableのindexと関連している
	 * @param table 場に並べられているカードの情報、openedのindexと関連している
	 * @param acquirableCards すでにめくられていて、プレイヤに確認されたカードの情報
	 * @param firstOpenedCardNumber １枚目にめくられたカードの数字
	 * @param firstOpenedCardIndex　１枚目にめくられたカードのindex
	 * @return めくったカードの、場におけるindex
	 */
	public int selectCard(List<Integer> opened, List<Card> table, Map<Integer, Integer> acquirableCards,
			int firstOpenedCardNumber, int firstOpenedCardIndex) {

		int resultIndex;
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getNumber() == firstOpenedCardNumber && firstOpenedCardIndex != i && opened.get(i) == 0) {
				//１枚目にめくったカードと同じ数字、かつ同じ位置のカードでない、かつすでにめくられていないものを探す

				resultIndex = table.indexOf(table.get(i));
				return resultIndex;
			}

		}
		return 0;
	}

}
