package odev;

import java.util.Random;

public class Uretim1 extends Uretim {
	
	public Uretim1() {
		
	}

	@Override
	public int Uret() {

		Random random = new Random();
        int uretSayi1 = random.nextInt(10) + 1;
		return uretSayi1;
	}

}
