package webdriver;

public class Sample {
//khai bao bien(global- toan cuc)
//bien- Variable
//thuoc tinh-property
	String address;
	
	//Action
	//Ham-function
	//Phuong thuc-method
	public void setAddressName(String newAddress) {
		//bien cuc bo: newAddress
		address = newAddress;
		}
	
	//get
	public String getAddressName() {
		//call function
		//call variable
		setAddressName("");
		 
		//Reference to variable
		System.out.println(address);
		return address;
		}
	
}
