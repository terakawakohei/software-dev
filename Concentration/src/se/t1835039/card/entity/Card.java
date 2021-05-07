package se.t1835039.card.entity;

/**
 * 汎用的なトランプのカードのクラス.絵柄、数字をもつ.
 * 絵柄については、整数でそれぞれ0（スペード）, 1（ダイヤ）, 2（ハート）, 3（クラブ）と表現される.
 * 数字については、1～13のいずれかである．外部表現として，1=A(エース), 11=J(ジャック), 12=Q(クィーン), 13=K(キング)と表示されることもある
 *
 * @author Kohei Terakawa
 *  @version 0.1, 2020-07-03
 * @since JDK1.8
 *
 */

public class Card {
	/**絵柄*/
	private int suit;
	/**数字*/
	private int number;

	/**
	 * 絵柄、数字を指定してカードインスタンスを生成する
	 *
	 * @param suit 絵柄
	 * @param number 数字
	 */
	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
	}

	/**
	 * 絵柄（整数）を取得する
	 *
	 * @return　絵柄
	 */
	public int getSuit() {
		return suit;
	}

	/**
	 * 数字（整数）を取得する
	 *
	 * @return　数字
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * カード情報を整数表現(インデクス)に変換する
	 *
	 * 整数表現とは，[[ スペード1の13まで, ダイヤ1の13まで, ハート1の13まで, クラブ1の13まで]]を，この順番に，0から51までの通し番号をつけたもの．また，ジョーカーの整数表現は，-1である．
	 * @return 整数表現
	 */
	public int toIndex() {
		if (suit == -1)
			return -1;
		return 13 * suit + number - 1;

	}

	/**
	 * カード情報を文字列表現に変換する.
	 *
	 * 文字列表現とは，絵柄文字列と数字文字列を連接したものである．
	 * 絵柄文字列："スペード", "ダイヤ", "ハート", "クラブ", "ジョーカー" のいずれか．
	 * 数字文字列："A", "2", "3", "4", ..., "10", "J", "Q", "K" のいずれか．
	 *
	 * 例： "スペード9", "ハートA", "ダイヤQ"など．ジョーカーは数字文字列なしで，"ジョーカー"とする
	 *
	 * @return 文字列表現
	 */
	public String toString() {

		String suitString;

		switch (suit) {
		case 0:
			suitString = "スペード";
			break;
		case 1:
			suitString = "ダイヤ";
			break;
		case 2:
			suitString = "ハート";
			break;
		case 3:
			suitString = "クラブ";

			break;
		case -1:
			suitString = "ジョーカー";

			break;

		default: {
			suitString = "";
		}
		}

		String numberString;

		switch (number) {
		case 1:
			numberString = "A";
			break;
		case 11:
			numberString = "J";
			break;
		case 12:
			numberString = "Q";
			break;
		case 13:
			numberString = "K";

			break;

		default: {
			numberString = Integer.toString(number);
			break;
		}
		}

		if (suitString.equals("ジョーカー")) {
			return "ジョーカー";
		} else
			return suitString + numberString;

	}

	/**
	 * カード情報を画面に出力する操作.画面には、toString()で得られた文字列をそのまま表示する.
	 *
	 */
	public void show() {

		System.out.println(toString());

	}

	/**
	 * 絵柄（0-3）と数字（1-13）を与えると，対応するカードの整数表現を返す
	 *
	 * @param suit 絵柄
	 * @param number　数字
	 * @return　整数表現
	 */
	public static int getIndex(int suit, int number) {
		if (suit == -1)
			return -1;
		return 13 * suit + number - 1;

	}

	/**
	 * 絵柄（0-3）と数字（1-13）を与えると，対応するカードの文字列表現を返す.
	 *
	 * @param suit 絵柄
	 * @param number　数字
	 * @return　文字列表現
	 */
	public static String getString(int suit, int number) {

		String suitString;

		switch (suit) {
		case 0:
			suitString = "スペード";
			break;
		case 1:
			suitString = "ダイヤ";
			break;
		case 2:
			suitString = "ハート";
			break;
		case 3:
			suitString = "クラブ";

			break;
		case -1:
			suitString = "ジョーカー";

			break;

		default: {
			suitString = "";
		}
		}

		String numberString;

		switch (number) {
		case 1:
			numberString = "A";
			break;
		case 11:
			numberString = "J";
			break;
		case 12:
			numberString = "Q";
			break;
		case 13:
			numberString = "K";

			break;

		default: {
			numberString = Integer.toString(number);
			break;
		}
		}

		if (suitString.equals("ジョーカー")) {
			return "ジョーカー";
		} else
			return suitString + numberString;

	}

}
