package javaForTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Topic_01_Data_Type {
	public static void main(String[] args) {
		//Kiểu dữ liệu kí tự
		char a = 'A';
		
		//Kiểu dữ liệu số nguyên (dương/âm)
		byte first_num = -15;
		short second_num = 15456;
		int third_num = 46883;
		long fourth_num = 652365;
		
		//Kiểu dữ liệu số thực
		float fifth_num = 145.69F;
		double six_num = 3482.44D;
		
		//Kiểu dữ liệu booleam(true/false)
		boolean status = true;
		status = false;
		
		//Kiểu dữ liệu chuỗi(số, chữ, đặc biệt..)
		String fullName = "Nguyen Van A";
		
		//Kiểu Array(cố định)
		String[] addresses = {"Ha Noi", "Ho Chi Minh", "Da Nang"};
		int[] prices = {20000, 50000, 100000};
		
		//Kiểu Class
		//Topic_03_Data_Types topic_03 = new Topic_03_Data_Types();
		
		//Kiểu object(javascript executor)
		
		//Kiểu collection(ArrayList/HashMap)
		//Chứa trùng
		List<String> address = new ArrayList<String>();
		address.add("Ho Chi Minh");
		address.add("Ha Noi");
		address.add("Da Nang");
		address.add("Da Nang");
		
		//Không chứa trùng
		Set<String> add = new HashSet<String>();
		add.add("Ho Chi Minh");
		add.add("Ha Noi");
		add.add("Da Nang");
		add.add("Da Nang");

	}
	
	

}
