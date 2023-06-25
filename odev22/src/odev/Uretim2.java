package odev;

import java.util.Random;

public class Uretim2 extends Uretim {
	
	public Uretim2() {
		
	}
	

	@Override
	public int Uret() {
		
		Random random = new Random();
        int uretSayi2 = random.nextInt(10) + 1;
       
		return uretSayi2;
	}

}
