package se.t1835039.card.test;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;
import se.t1835039.card.entity.Card;
import se.t1835039.card.entity.CardDeck;

public class CardDeckTest extends TestCase {
	// すべてのテストメソッドで用いるカードのインスタンス
	private Card spadeA, diamond10, heartQ, clubK, spade5, diamondA, heartA, clubA, joker;

	private CardDeck deck = new CardDeck();

	protected void setUp() throws Exception {
		// いくつかテスト用のカードインスタンスを作っておく．
		spadeA = new Card(0, 1); // スペードA
		diamond10 = new Card(1, 10); // ダイヤ10
		heartQ = new Card(2, 12); // ハートQ
		clubK = new Card(3, 13); // クラブK
		spade5 = new Card(0, 5); // スペード5
		diamondA = new Card(1, 1); // ダイヤA
		heartA = new Card(2, 1); // ハートA
		clubA = new Card(3, 1); // クラブA
		joker = new Card(-1, 0); // ジョーカー
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateFullDeck() {
		deck.createFullDeck();
		int counter = 0;
		for (Card c : deck.getAllCards())
			counter++;
		assertEquals(52, counter); // フルデッキは52枚のはず
	}

	public void testClear() {
		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);
		deck.addCard(spade5);

		deck.clear();
		int counter = 0;
		for (Card c : deck.getAllCards())
			counter++;

		assertEquals(0, counter);
	}

	public void testShuffle() {
		ArrayList<String> cardName = new ArrayList<String>(Arrays.asList("spadeA", "diamond10", "heartQ", "clubK",
				"spade5", "diamondA", "heartA", "clubA", "joker"));

		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);
		deck.addCard(spade5);
		deck.addCard(diamondA);
		deck.addCard(heartA);
		deck.addCard(clubA);
		deck.addCard(joker);

		deck.shuffle();

		ArrayList<String> cardNameAfterShuffle = new ArrayList<String>();

		for (Card c : deck.getAllCards())
			cardNameAfterShuffle.add(c.toString());

		//絵柄がshuffle後も完全に一致していたなら、テスト失敗とみなす
		assertNotSame(cardName, cardNameAfterShuffle);
	}

	public void testAddCardCard() {

		deck.addCard(spadeA);

		assertEquals("スペードA", deck.getAllCards().get(0).toString());
	}

	public void testAddCardIntCard() {

		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);
		deck.addCard(spade5);
		deck.addCard(diamondA);
		deck.addCard(heartA);
		deck.addCard(clubA);
		deck.addCard(joker);

		deck.addCard(7, spadeA);

		assertEquals("スペードA", deck.getAllCards().get(6).toString());
	}

	public void testTakeCard() {
		deck.addCard(spadeA);
		deck.addCard(diamond10);

		//取得した一番上のカードは、spadeA
		assertEquals("スペードA", deck.takeCard().toString());

		//取得後のデッキの一番上は、spadeAではない
		assertFalse(deck.getAllCards().get(0).toString().equals("スペードA"));

	}

	public void testTakeCardInt() {
		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);

		//取得した3番目のカードは、heartQ
		assertEquals("ハートQ", deck.takeCard(3).toString());

		//取得後のデッキの3番目のカードは、heartQではない
		assertFalse(deck.getAllCards().get(2).toString().equals("ハートQ"));

	}

	public void testSeeCard() {
		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);

		//3番目のカードは、heartQ
		assertEquals("ハートQ", deck.seeCard(3).toString());
		//デッキの3番目のカードは、heartQのまま
		assertTrue(deck.getAllCards().get(2).toString().equals("ハートQ"));
	}

	public void testSerachCard() {
		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);

		//3番目のカードは、heartQ
		assertEquals(3, deck.searchCard(2, 12));
	}

	public void testIsEnmpty() {
		//デッキは初期状態で空になっている
		assertEquals(true, deck.IsEnmpty());
	}

	public void testSize() {
		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);

		assertEquals(4, deck.size());
	}

	//	public void testShowAllCards() {
	//		fail("まだ実装されていません");
	//	}

	public void testGetAllCards() {
		deck.addCard(spadeA);
		deck.addCard(diamond10);
		deck.addCard(heartQ);
		deck.addCard(clubK);

		assertEquals(4, deck.getAllCards().size());
	}

}
