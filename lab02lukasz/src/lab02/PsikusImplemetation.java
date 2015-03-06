package lab02;

import java.util.Random;

public class PsikusImplemetation implements Psikus {

	@Override
	public Integer cyfrokrad(Integer liczba) {
		
		Random generator = new Random();
		int losowa = generator.nextInt(1000);	
		
		
		String liczbaString = Integer.toString(liczba);	
		
		int length = liczbaString.length();	
		
		if(length>1){
		
			StringBuilder sb = new StringBuilder(liczbaString);
			sb.deleteCharAt(losowa % length);
			String resultString = sb.toString();
		
			int nowaLiczba = Integer.parseInt(resultString); 
		
			return nowaLiczba;
		}
		else{
			
			return null;
		}
	}

	@Override
	public Integer hultajchochla(Integer liczba) throws NieudanyPsikusException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer nieksztaltek(Integer liczba) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String [ ] args)
	{
		PsikusImplemetation ps = new PsikusImplemetation();

	}

}
