package se.t1835039.janken.entity;
import java.util.Random;

public class RandomStrategy implements Strategy{

	public int getHand(int playerHandNum) {
		Random random = new Random();
		int randomNum = random.nextInt(3);

		return randomNum;
    }

}
