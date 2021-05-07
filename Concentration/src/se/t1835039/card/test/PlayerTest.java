package se.t1835039.card.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import se.t1835039.card.entity.Card;
import se.t1835039.card.entity.CardDeck;
import se.t1835039.card.entity.User;

public class PlayerTest extends TestCase {
	private User user1;

	private CardDeck deck = new CardDeck();
	private List<Card> table = new ArrayList<Card>();
	private List<Integer> opened = new ArrayList<Integer>();

	protected void setUp() throws Exception {

		user1 = new User("user1");

		//すでに4と11のカードを獲得しているとする
		user1.storeOwnCard(4);
		user1.storeOwnCard(11);

		//31の位置にある9のカードを最初にめくったとする
		user1.storeFirstOpenedCard(9, 31);

		deck.createFullDeck();
		deck.shuffle();
		for (Card c : deck.getAllCards()) {
			table.add(c);
			opened.add(0);//最初は全て伏せた状態（0）に設定
		}
	}

	protected void tearDown() throws Exception {

	}

	public void testCheckOpened() {
		//全てのカードは伏せられた状態なので

		assertEquals(false, user1.checkOpened(opened, 21));
	}

	public void testIsSameFirstCardNum() {
		assertEquals(true, user1.IsSameFirstCardNum(9));
	}

	public void testGetName() {
		assertEquals("user1", user1.getName());
	}

	public void testGetOwnCardNum() {
		//4と11が2枚ずつ、計4枚のカードを持っているはず

		assertEquals(4, user1.getOwnCardNum());
	}

}
