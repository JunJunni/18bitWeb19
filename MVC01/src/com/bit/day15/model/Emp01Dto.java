package com.bit.day15.model;

import java.sql.Date;

public class Emp01Dto { //data transfer object
//Ä¸½¶È­È¯´Ù. 
	private int sabun;
	private String name;
	private Date ddate;
	private int sal;
	
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDdate() {
		return ddate;
	}
	public void setDdate(Date ddate) {
		this.ddate = ddate;
	}
	public int getsal() {
		return sal;
	}
	public void setsal(int sal) {
		this.sal = sal;
	}

}
