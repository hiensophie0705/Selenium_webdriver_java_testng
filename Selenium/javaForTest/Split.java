package javaForTest;

public class Split {
	public static void main(String[] args) {
		String oldUrl = "http://the-internet.herokuapp.com/basic_auth";
		
		String urlValue[] = oldUrl.split("//");
		//http:
		//the-internet.herokuapp.com/basic_auth
		System.out.println(urlValue[0]);
		System.out.println(urlValue[1]);
	}
}
