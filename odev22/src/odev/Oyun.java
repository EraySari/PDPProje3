package odev;

import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Oyun {
	
	Scanner scanner = new Scanner(System.in);

	public void savasSonucu(Koloni kazanan, Koloni kaybeden) {
		
		int popFark;
		
		if(kazanan.getSonuc() == kaybeden.getSonuc()) {
			popFark = 500;
		}else {
			popFark = kazanan.getSonuc() - kaybeden.getSonuc();
		}
		
		   
		   int kaybedenPop = kaybeden.getPop();
		   int popFarkOran = popFark/10;
		  
		   kaybeden.setPop(kaybedenPop - (kaybedenPop*popFarkOran/100) + 1);
		   kaybeden.setStok(kaybeden.getStok() - (kaybedenPop*popFarkOran/100));
		   kazanan.setStok(kazanan.getStok() + (kaybedenPop*popFarkOran/100));
		   

		   kazanan.setWin(kazanan.getWin()+1);
		   kaybeden.setLost(kaybeden.getLost()+1);
	}
	
	public void koloniSil(Koloni elenen) {
		elenen.setPop(0);
		elenen.setStok(0);
		elenen.setWin(0);
		elenen.setLost(0);
	}
	
	public void sonucYazdir(Koloni[] koloni,int koloniSayisi,int tur) {

	    	   System.out.println("-------------------------------------------------------");
	           System.out.println("Tur Sayisi:"+tur);
	           System.out.println("Koloni   Populasyon   Yemek Stogu   Kazanma   Kaybetme");
	           for(int i=0;i<koloniSayisi;i++ ) {
	           	System.out.println(koloni[i]);
	           }
	           System.out.println("\n-------------------------------------------------------");
	}
	
	
	public void basla() { 

        int koloniSayisi = 0;
        int tur =0;
        int elenen = 0;
		
		System.out.println("Populasyonlari girin:");
		String pops = scanner.nextLine();
        String[] popsStrArray = pops.split(" ");
        int[] popsIntArray = new int[popsStrArray.length];

        for (int i = 0; i < popsStrArray.length; i++) {
        	popsIntArray[i] = Integer.parseInt(popsStrArray[i]);
            koloniSayisi++;
        }
        
        Koloni [] koloniler = new Koloni[koloniSayisi];
		Taktik1 taktik1 = new Taktik1();
        Taktik2 taktik2 = new Taktik2();
        Uretim1 uret1 = new Uretim1();
        Uretim2 uret2 = new Uretim2();
        
        for (int i = 0; i < koloniSayisi; i++) {       	
        	koloniler[i]=new Koloni(popsIntArray[i],(34+i)); 
        }
        Random random = new Random();
       
       while(elenen + 1 < koloniSayisi) {
    	   
    	   sonucYazdir(koloniler, koloniSayisi,tur);
    	      	   
    	   for(int i =0 ; i<koloniSayisi-1 ; i++) {
        	   for(int j=i+1 ; j<koloniSayisi ; j++) {
        		   

        		   if(koloniler[i].getPop() == 0 || koloniler[j].getPop() == 0) {
        			   continue;
        		   }       		     		
        		   
        		   koloniler[i].setSonuc(taktik1.Savas());
        		   koloniler[j].setSonuc(taktik2.Savas());
        		   	   
        		   if(koloniler[i].getSonuc()>koloniler[j].getSonuc()) savasSonucu(koloniler[i],koloniler[j]);
        		   else if(koloniler[i].getSonuc()<koloniler[j].getSonuc()) savasSonucu(koloniler[j],koloniler[i]);
        		   else {
        			   			   
        			   if(koloniler[i].getPop() > koloniler[j].getPop()) savasSonucu(koloniler[i],koloniler[j]);
        			   else if(koloniler[i].getPop() > koloniler[j].getPop()) savasSonucu(koloniler[j],koloniler[i]);
        			   else {
            			   int randomKazanan = random.nextInt(2);	   
            			   if(randomKazanan == 0) savasSonucu(koloniler[i],koloniler[j]);
            			   else if(randomKazanan == 1) savasSonucu(koloniler[i],koloniler[j]);
        			   }			   
        		   }
        	   }	   
    	   }  	   
    	   	   
    	 //tur sonu ekleme - cikarma
    	   for(int c =0;c<koloniSayisi;c++) {       		   
    		   if(koloniler[c].getPop() != 0 && koloniler[c].getStok() != 0){
        		   
    			   int randomUret;
    			   if(random.nextInt(2) == 0)	randomUret = uret1.Uret();
    			   else {
    				   randomUret = uret2.Uret();
    			   }
    			   
        		   koloniler[c].setStok(koloniler[c].getStok()+randomUret);

    			   int populasyon = koloniler[c].getPop();
    			   int yemekStok = koloniler[c].getStok() - populasyon*2;
    			   koloniler[c].setPop(populasyon + (populasyon*20/100));		   
    			   koloniler[c].setStok(yemekStok);
        		   
        		   if(koloniler[c].getPop() <= 0 || koloniler[c].getStok() <= 0)	elenen++;
    		   }
    		   
    		   if(koloniler[c].getPop() <= 0 || koloniler[c].getStok() <=0 ) koloniSil(koloniler[c]);		   		 
    	   }
        	   
        tur++;  
       }
               
       sonucYazdir(koloniler, koloniSayisi,tur);
	}
}
