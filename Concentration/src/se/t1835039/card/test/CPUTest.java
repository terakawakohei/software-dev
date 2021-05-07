package se.t1835039.card.test;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import se.t1835039.card.entity.CPU;
import se.t1835039.card.entity.Card;
import se.t1835039.card.entity.CardDeck;
import se.t1835039.card.entity.CheatStrategy;
import se.t1835039.card.entity.NeverForgetStrategy;
import se.t1835039.card.entity.NormalStrategy;
import se.t1835039.card.entity.RandomStrategy;

public class CPUTest extends TestCase {

	private CPU weakCPU, normalCPU, strongCPU;

	private CardDeck deck = new CardDeck();
	private List<Card> table = new ArrayList<Card>();
	private List<Integer> opened = new ArrayList<Integer>();

	protected void setUp() throws Exception {

		weakCPU = new CPU("weakCPU1", new RandomStrategy(), new RandomStrategy());
		normalCPU = new CPU("normalCPU2", new NeverForgetStrategy(), new NormalStrategy());
		strongCPU = new CPU("strongCPU", new NeverForgetStrategy(), new CheatStrategy());

		deck.createFullDeck();
		deck.shuffle();
		for (Card c : deck.getAllCards()) {
			table.add(c);
			opened.add(0);//最初は全て伏せた状態（0）に設定
		}

	}

	protected void tearDown() throws Exception {

	}

	public void testSelectFirstCard() {
		//カードを選んだ結果、52枚のうちどれかを決定してほしい
		//要素数52のリストのインデックスとして使用するので、0以上51以下の数字である必要がある

		assertTrue(0 <= weakCPU.selectFirstCard(opened, table) && 51 >= weakCPU.selectFirstCard(opened, table));
		assertTrue(0 <= normalCPU.selectFirstCard(opened, table) && 51 >= weakCPU.selectFirstCard(opened, table));
		assertTrue(0 <= strongCPU.selectFirstCard(opened, table) && 51 >= weakCPU.selectFirstCard(opened, table));
	}

	public void testSelectSecondCard() {
		//カードを選んだ結果、52枚のうちどれかを決定してほしい
		//要素数52のリストのインデックスとして使用するので、0以上51以下の数字である必要がある

		assertTrue(0 <= weakCPU.selectSecondCard(opened, table) && 51 >= weakCPU.selectSecondCard(opened, table));
		assertTrue(0 <= normalCPU.selectSecondCard(opened, table) && 51 >= weakCPU.selectSecondCard(opened, table));
		assertTrue(0 <= strongCPU.selectSecondCard(opened, table) && 51 >= weakCPU.selectSecondCard(opened, table));

	}

}
