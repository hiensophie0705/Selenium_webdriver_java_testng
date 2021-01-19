package javaForTest;

public class Topic_04_Getter_Setter {
	String carName;//biến toàn cục
	
	public static void main(String[] args) {
		//todo auto-generated method stub
		Topic_04_Getter_Setter topic = new Topic_04_Getter_Setter();
		
		topic.setCarName("toyota camry");
		System.out.println(topic.getCarName());
		
		topic.setCarName("Mazda 3");
		System.out.println(topic.getCarName());
		
	}
	
	//Lấy ra dữ liệu của 1 biến(getter)
	public String getCarName() {
		return this.carName;
	}
	//Gán dữ liệu mới vào cho biến(setter)
	public void setCarName(String car) {
		carName = car;
	}
	//this: lấy biến toàn cục
	//k dun this: biến cục bộ
}
