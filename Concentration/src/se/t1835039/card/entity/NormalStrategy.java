package se.t1835039.card.entity;

import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 　※※※※※２枚目にめくるカードを選ぶ戦略※※※※※
 *
 * 1/2の確率で、２枚目にめくるカードの戦略をCheatStrategyかRondomStrategyにする
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public class NormalStrategy implements Strategy {
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

		//以下CheatStrategyの内容(CheatStrategyでのselectCardをimportするなり利用したいが、良い方法がわからない...)
		int resultCheatIndex = 0;
		for (int i = 0; i < table.size(); i++) {
			if (table.get(i).getNumber() == firstOpenedCardNumber && firstOpenedCardIndex != i && opened.get(i) == 0) {
				resultCheatIndex = table.indexOf(table.get(i));
				break;
			}

		}

		//以下RondomStrategyの内容(RondomStrategyでのselectCardをimportするなり利用したいが、良い方法がわからない...)
		Random random = new Random();
		int resultRandomIndex;

		//openされていない(openedの値が0)indexを生成するまで繰り返す
		do {
			resultRandomIndex = random.nextInt(52);
		} while (opened.get(resultRandomIndex) == 1);

		//1/2の確率でCheatまたはRandomを選択

		double decisionStrategy = random.nextInt(100);

		if (decisionStrategy / 100 > 0.7)
			return resultCheatIndex;
		else
			return resultRandomIndex;

	}
}
