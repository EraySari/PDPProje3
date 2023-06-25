package odev;

import java.util.Random;

public class Taktik1 extends Taktik {
	
	public Taktik1() {
		
	}

	@Override
	public int Savas() {
		
		Random random = new Random();
        int savasSayi1 = random.nextInt(1000);
		return savasSayi1;
	}

}
