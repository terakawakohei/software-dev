package se.t1835039.card.entity;

public class Main {
	public static void main(String[] args) {
		CardDeck cd = new CardDeck();

		System.out.println("== 1. フルデッキを作ります．==");
		cd.createFullDeck();

		System.out.println("== ジョーカーも追加します．==");
		Card j = new Card(-1, 0);
		cd.addCard(9, j);

		System.out.println("== 2. シャッフルします．==");
		cd.shuffle();

		cd.showAllCards();

		System.out.println("== 3. 上から何枚か取ってみます．");

		cd.takeCard().show();
		cd.takeCard().show();
		cd.takeCard().show();

		System.out.println("現在のデッキの枚数は，" + cd.size() + "枚です．");
		System.out.println("上から3番目のカードは，" + cd.seeCard(3) + "です．");

		cd.showAllCards();

		System.out.println("ジョーカーの場所 : " + cd.searchCard(-1, 0));

		System.out.println("== 4. 空デッキにします");

		cd.clear();

		System.out.println("デッキが空かどうか : " + cd.IsEnmpty());

	}

}
