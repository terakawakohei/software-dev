package se.t1835039.card.test;

import junit.framework.TestCase;
import se.t1835039.card.game.ConcentrationGame;

public class ConcentrationGameTest extends TestCase {

	private ConcentrationGame game;

	protected void setUp() throws Exception {
		game = new ConcentrationGame();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testConvertIndex() {
		//一行目、七列目の場のカードのindexは6
		assertEquals(6, ConcentrationGame.ConvertIndex(1, 7));

		//4行目、3列目の場のカードのindexは23
		assertEquals(23, ConcentrationGame.ConvertIndex(4, 3));
	}

}
