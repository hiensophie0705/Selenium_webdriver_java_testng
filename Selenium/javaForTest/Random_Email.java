package javaForTest;

import java.util.Random;

public class Random_Email {
	public static void main(String[] args) {
		
		//java class
		Random rand = new Random();
		
		System.out.println(rand.nextInt(999999));
		System.out.println(rand.nextInt(999999));
		System.out.println(rand.nextInt(999999));
		System.out.println(rand.nextInt(999999));
		//Random mail( ngẫu nhiên)
		//format: prefix +random +postfix(webmail server:@hotmail....)
		
		System.out.println("autotesting" + rand.nextInt(999999) + "@hotmail.com");
		System.out.println("autotesting" + rand.nextInt(999999) + "@gmail.com");
		System.out.println("autotesting" + rand.nextInt(999999) + "@live.com");
		
		
		
	}
}
