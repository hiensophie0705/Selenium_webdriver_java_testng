package javaForTest;

public class Topic_02_Split {
	public static void main(String[] args) {
		String oldUrl = "http://the-internet.herokuapp.com/basic_auth";
		
		String urlValue[] = oldUrl.split("//");
		//http:
		//the-internet.herokuapp.com/basic_auth
		System.out.println(urlValue[0]);
		System.out.println(urlValue[1]);
		
		String likes = "1,938 likes";
		
		String likeNumber = likes.split("")[0].replace(",","");
		System.out.println(likeNumber);
		
		int likeNumbers = Integer.parseInt(likeNumber);
		System.out.println(likeNumbers);
	}
}
