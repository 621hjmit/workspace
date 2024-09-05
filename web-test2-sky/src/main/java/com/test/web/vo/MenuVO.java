package com.test.web.vo;

public class MenuVO {
	
	private int miNum;
	private String miName;
	private int miPrice;
	private String miPath;
	
	public String getMiPath() {
		return miPath;
	}
	public void setMiPath(String miPath) {
		this.miPath = miPath;
	}
	public int getMiNum() {
		return miNum;
	}
	public void setMiNum(int miNum) {
		this.miNum = miNum;
	}
	public String getMiName() {
		return miName;
	}
	public void setMiName(String miName) {
		this.miName = miName;
	}
	
	public int getMiPrice() {
		return miPrice;
	}
	public void setMiPrice(int miPrice) {
		this.miPrice = miPrice;
	}
	
	@Override
	public String toString() {
		return "MenuVO [miNum=" + miNum + ", miName=" + miName + ", miPrice=" + miPrice + ", miPath=" + miPath + "]";
	}
	public MenuVO(int miNum, String miName, int miPrice, String miPath) {
		super();
		this.miNum = miNum;
		this.miName = miName;
		this.miPrice = miPrice;
		this.miPath = miPath;
	}
	public MenuVO(int miNum, String miName, int miPrice) {
		super();
		this.miNum = miNum;
		this.miName = miName;
		this.miPrice = miPrice;
	}
	public MenuVO(String miName, int miPrice) {
		super();
		this.miName = miName;
		this.miPrice = miPrice;
	}
	public MenuVO() {
		super();
	}
	
}
