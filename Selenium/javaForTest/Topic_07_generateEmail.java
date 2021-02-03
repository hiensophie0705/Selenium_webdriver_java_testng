package javaForTest;

public class Topic_07_generateEmail {

	public String generateEmail() {
		Random rand = new Random();
		return "donald" + rand.nextInt(9999) + "@github.io";
	}
	}
}
