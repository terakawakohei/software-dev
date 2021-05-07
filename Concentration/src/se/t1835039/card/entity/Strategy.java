package se.t1835039.card.entity;

import java.util.List;
import java.util.Map;

/**
 *
 * CPUがめくるカードを決めるための戦略
 *
 * @author Kohei Terakawa
 * @version 0.1, 2020-07-03
 * @since JDK1.8
 */

public interface Strategy {
	/**
	 * めくるカードを決める
	 *
	 * @param opened 場のカードがめくられているなら1,伏せられているなら0が入っている、tableのindexと関連している
	 * @param table 場に並べられているカードの情報、openedのindexと関連している
	 * @param acquirableCards すでにめくられていて、プレイヤに確認されたカードの情報
	 * @param firstOpenedCardNumber １枚目にめくられたカードの数字
	 * @param firstOpenedCardIndex　１枚目にめくられたカードのindex
	 * @return　めくったカードの、場におけるindex
	 */
	public abstract int selectCard(List<Integer> opened,List<Card> table,Map<Integer,Integer> acquirableCards,int firstOpenedCardNumber,int firstOpenedCardIndex);
}
