package se.t1835039.janken.entity;

public class InvincibleStrategy implements Strategy{

	public int getHand(int playerHandNum) {
		if(playerHandNum==0)return 2;
		if(playerHandNum==1)return 0;
		if(playerHandNum==2)return 1;

		return 0;
	}

}
