package se.t1835039.card.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 汎用的なトランプのカードデッキのクラス.複数のトランプカードから構成される.
 * デッキはかならずしも５２枚（フルデッキ(Full Deck)と呼ぶ）＋ジョーカーとは限らない．
 * デッキにあるカードは，上から順に番号づけされる（１番目のカード，２番目のカード，．．．）

 *
 * @author Kohei Terakawa
 *
 */

public class CardDeck {
	/**
	 * デッキに存在するカード
	 */
	private ArrayList<Card> cards = new ArrayList<Card>();

	/**
	 * 空のCardDeckインスタンスを生成.
	 * カードデッキは，生成した瞬間には「空デッキ（カードが一枚もない状態）」である．
	 */
	public CardDeck() {

	}

	/**
	 * 自らをフルデッキ(52枚)にする
	 */
	public void createFullDeck() {

		for (int s = 0; s <= 3; s++) {
			for (int n = 1; n <= 13; n++) {
				Card c = new Card(s, n);
				cards.add(c);
			}

		}

	}

	/**
	 * デッキを空にする
	 */
	public void clear() {

		cards.clear();

	}

	/**
	 * デッキをシャッフルし、カードの順番を混ぜる
	 */
	public void shuffle() {

		Collections.shuffle(cards);

	}

	/**
	 * デッキの一番最後に，任意のカードを追加する
	 *
	 * @param card カード
	 */
	public void addCard(Card card) {

		cards.add(card);

	}

	/**
	 * デッキの i 番目に，任意のカードを追加する
	 *
	 * @param i　上から数えた時に、カードを追加する番号（１番目のカード，２番目のカード，．．．）
	 * @param card　カード
	 */
	public void addCard(int i, Card card) {

		cards.add(i - 1, card);

	}

	/**
	 * デッキの一番上の（１番目の）カードを取る
	 *
	 * @return　カード
	 */
	public Card takeCard() {

		Card c = cards.get(0);

		cards.remove(0);

		return c;

	}

	/**
	 * デッキの i 番目から，カードを抜き取る
	 *
	 * @param i　上から数えた時に、抜き取るカードが存在する番号（１番目のカード，２番目のカード，．．．）
	 * @return　カード
	 */
	public Card takeCard(int i) {

		Card c = cards.get(i - 1);

		cards.remove(i - 1);

		return c;

	}

	/**
	 * デッキのi番目にあるカードを見る
	 *
	 * @param i　上から数えた時に、見るカードが存在する番号（１番目のカード，２番目のカード，．．．）
	 * @return　カード
	 */
	public Card seeCard(int i) {

		return cards.get(i - 1);

	}

	/**
	 * 絵柄suitと番号numberを与えて，そのカードがデッキの何番目にあるかを調べる
	 *
	 * @param suit　絵柄
	 * @param number　数字
	 * @return　探しているカードがデッキの上から数えた時の番号
	 */
	public int searchCard(int suit, int number) {

		for (int i = 0; i < cards.size(); i++) {
			if (cards.get(i).getSuit() == suit && cards.get(i).getNumber() == number) {
				return i + 1;
			}

		}

		return 0;

	}

	/**
	 * 現在のデッキが空かどうか判定する
	 * @return 真偽値
	 */
	public boolean IsEnmpty() {

		return cards.isEmpty();

	}

	/**
	 * 現在デッキにあるカード枚数を返す
	 *
	 * @return　カード枚数
	 */
	public int size() {

		return cards.size();

	}

	/**
	 * 現在のすべてのカードを画面に表示する
	 */
	public void showAllCards() {

		System.out.println("------------現在の山を表示します．-----------");

		for (int i = 0; i < cards.size(); i++) {
			System.out.print((i + 1) + "番目のカード : ");
			cards.get(i).show();
		}

		System.out.println("------------ここまで-----------");

	}

	/**
	 * 現在デッキにある全てのカードを返す
	 *
	 * @return　カードのリスト(List<Card>)
	 */
	public List<Card> getAllCards() {

		return cards;

	}

}
