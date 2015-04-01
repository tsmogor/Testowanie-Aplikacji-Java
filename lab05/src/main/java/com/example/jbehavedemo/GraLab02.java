package com.example.jbehavedemo;

import java.util.LinkedList;
import java.util.Random;
import java.util.Random;



public class GraLab02{

	private Integer liczba;
	
	
	public void setliczba(Integer liczba) {
		this.liczba = liczba;
	}

	public int getliczba() {
		return liczba;
	}
	
	
	public Integer cyfrokrad() {
		
		Random generator = new Random();
		int losowa = generator.nextInt(1000);	
		
		
		String liczbaString = Integer.toString(liczba);	
		
		int length = liczbaString.length();	
		if(liczba<0 && length>2){
			StringBuilder sb = new StringBuilder(liczbaString);
			
			int kasowana = generator.nextInt(1000) % length;
			while(kasowana == 0){
				kasowana = generator.nextInt(1000) % length;
			}
			if(kasowana!=0){
				sb.deleteCharAt(kasowana);
			}
			
			String resultString = sb.toString();
		
			int nowaLiczba = Integer.parseInt(resultString); 
		
			return nowaLiczba;
		}
		
		else if(length>1 && liczba>9){
		
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


	public Integer hultajchochla() throws NieudanyPsikusException {
		Random generator = new Random();
		int losowa = generator.nextInt(1000);	
		int losowa2 = generator.nextInt(1000);
		
		String liczbaString = Integer.toString(liczba);	
		
		int length = liczbaString.length();	
		
		if(liczba<0 && length>2){
			StringBuilder sb = new StringBuilder(liczbaString); 
			int pierwszaLosowa = losowa % length;
			
			while(pierwszaLosowa == 0){
				pierwszaLosowa = generator.nextInt(1000) % length;
			}
			
			char temp = sb.charAt(pierwszaLosowa); 

			int drugaLosowa = losowa2 % length; 
			
			
			
			while(pierwszaLosowa == drugaLosowa || drugaLosowa == 0){
				drugaLosowa = generator.nextInt(1000) % length;
			}
			char temp2 = sb.charAt(drugaLosowa); 

			sb.setCharAt(pierwszaLosowa, temp2);
			sb.setCharAt(drugaLosowa, temp);
			String resultString = sb.toString();
		
			int nowaLiczba = Integer.parseInt(resultString); 
		
			return nowaLiczba;
			
		}
		
		else if(length>1 && liczba>9){
		
			StringBuilder sb = new StringBuilder(liczbaString); 
			int pierwszaLosowa = losowa % length;
			char temp = sb.charAt(pierwszaLosowa); 

			int drugaLosowa = losowa2 % length; 
			while(pierwszaLosowa == drugaLosowa){
				drugaLosowa = generator.nextInt(1000) % length;
			}
			char temp2 = sb.charAt(drugaLosowa); 

			sb.setCharAt(pierwszaLosowa, temp2);
			sb.setCharAt(drugaLosowa, temp);
			String resultString = sb.toString();
		
			int nowaLiczba = Integer.parseInt(resultString); 
		
			return nowaLiczba;
		}
		else{
			
			throw new NieudanyPsikusException();
		}
	}


	public Integer nieksztaltek() {
		
		Random generator = new Random();
			
		String liczbaString = Integer.toString(liczba);	
		StringBuilder sb = new StringBuilder(liczbaString);
		
		if(!(liczbaString.contains("3") || liczbaString.contains("6") || liczbaString.contains("7"))){
			return liczba;
		}
		
		else{
			int length = liczbaString.length();	
			int losowa = generator.nextInt(1000) % length;

			char temp = sb.charAt(losowa);
		
			while(temp != '3' && temp != '6' && temp != '7' ){
				losowa = generator.nextInt(1000) % length;
				temp = sb.charAt(losowa);
			}
			if(temp == '3'){
				sb.setCharAt(losowa, '8');
			}
			else if(temp == '6'){
				sb.setCharAt(losowa, '9');		
			}
			else if(temp == '7'){
				sb.setCharAt(losowa, '1');
			}
			
		}
		
		String resultString = sb.toString();
		
		int nowaLiczba = Integer.parseInt(resultString); 
		
		return nowaLiczba;


	}
	
	public static void main(String [ ] args) throws NieudanyPsikusException
	{

	}

}
