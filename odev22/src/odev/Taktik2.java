package odev;

import java.util.Random;

public class Taktik2 extends Taktik {
	
	public Taktik2() {
		
	}

	@Override
	public int Savas() {
		
		Random random = new Random();
        int savasSayi2 = random.nextInt(1000) ;
		
		return savasSayi2;
	}

}
