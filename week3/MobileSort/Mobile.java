import java.io.*;

public  class Mobile {

	private String mobileName;
	private int price;
	private int ram;
	private String processor;
	
	public Mobile(String mobileName,int price, int ram, String processor){
		this.mobileName = mobileName;
		this.price = price;
		this.ram = ram;
		this.processor = processor;
	}
	
	public String getMobileName() {
		return mobileName;
	}
	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public long getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

}
