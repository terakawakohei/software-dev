package se.t1835039.card.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 　※※※※※1枚目にめくるカードを選ぶ戦略※※※※※
 *
 * すでにめくられて、プレイヤが確認したカード(acquirableCards)の中から選び出す
 * acquirableCardsがない場合はランダムに選び出す
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public class NeverForgetStrategy implements Strategy {
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
		////acquirableCardsから一枚目を選ぶ
		//acquirableCardsに入っている最初のカードのindexを取得
		List<Integer> acquirableCardsList = new ArrayList<>(acquirableCards.values());

		if (acquirableCardsList.size() > 0)
			return acquirableCardsList.get(0);
		else {
			//acquirableCardsに値がない場合はランダムに一枚目を選び出す
			Random random = new Random();
			int randomIndex;

			//openされていない(openedの値が0)indexを生成するまで繰り返す
			do {
				randomIndex = random.nextInt(52);
			} while (opened.get(randomIndex) == 1);

			return randomIndex;
		}

	}

}
