package odev;

public class Koloni {
	
	private char symbol;
	private int pop;
	private int stok;
	private int win;
	private int lost;
	private int sonuc;
	
	public Koloni(int pop,int symbol) {
		this.symbol = (char)symbol;
		this.pop=pop;
		this.stok = pop*pop;
		this.win = 0;
		this.lost=0;
		this.sonuc = 0;
	}

	@Override
	public String toString() {
		
		String yazdir;
		if(this.getPop() == 0 || this.getStok() == 0) {
			yazdir = " "+symbol + "\t   " + "--" + " \t\t  " + "--" + "\t  \t" +"--" + "  \t" + "--" ;
		}else {
			yazdir = " "+symbol + "\t   " + pop + " \t\t  " + stok + "\t  \t" +win + "  \t" + lost ;
		}
		
		return yazdir;
	}

	public int getPop() {
		return pop;
	}

	public void setPop(int pop) {
		this.pop = pop;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}
	
	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getSonuc() {
		return sonuc;
	}

	public void setSonuc(int sayi) {
		this.sonuc = sayi;
	}
	
	
	
	
	
	
	
	
	
	

	

}
