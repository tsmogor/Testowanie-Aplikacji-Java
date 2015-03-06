package zad03;

public class LiczbaRzymska {

	private int podanaLiczba;
	
	LiczbaRzymska(int liczba){	
		this.podanaLiczba=liczba;
	}
	
	
	public static final int[] arabskie = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
	public static final String[] rzymskie = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
	
	public String toString() {
	    String rzymskaZapis = "";

	    if (podanaLiczba < 1 || podanaLiczba > 3999) {
	        System.out.println(podanaLiczba + " <-- Nie ma takiej liczby rzymskiej");
	        return null;
	    }

	    while (podanaLiczba > 0) {
	        int pasujacaRzymska = 0;
	        for (int i=0; i < arabskie.length; i++) {
	            if (podanaLiczba >= arabskie[i]) {
	            	pasujacaRzymska = i;
	            }
	        }
	        rzymskaZapis = rzymskaZapis + rzymskie[pasujacaRzymska];
	        podanaLiczba = podanaLiczba - arabskie[pasujacaRzymska];
	    }

	    return rzymskaZapis;       
	}	
	
}
