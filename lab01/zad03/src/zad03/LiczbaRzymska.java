package zad03;

public class LiczbaRzymska {

	private int arabic;
	
	LiczbaRzymska(int liczba){	
		this.arabic=liczba;
	}
	
	
	public static final int[] decimal = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
	public static final String[] letters = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
	
	public String toString() {
	    String roman = "";

	    if (arabic < 1 || arabic > 3999) {
	        System.out.println(arabic + " <-- Nie ma takiej liczby rzymskiej");
	        return null;
	    }

	    while (arabic > 0) {
	        int maxFound = 0;
	        for (int i=0; i < decimal.length; i++) {
	            if (arabic >= decimal[i]) {
	                maxFound = i;
	            }
	        }
	        roman += letters[maxFound];
	        arabic -= decimal[maxFound];
	    }

	    return roman;       
	}	
	
}
