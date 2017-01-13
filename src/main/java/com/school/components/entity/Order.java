package com.school.components.entity;

import java.sql.Date;

public class Order {
	private int id_order;
	private int id_seller;
	private int id_child;
	private String date_order;
	
	public int getId_order() {
		return id_order;
	}
	public void setId_order(int id_order) {
		this.id_order = id_order;
	}
	public int getId_seller() {
		return id_seller;
	}
	public void setId_seller(int id_seller) {
		this.id_seller = id_seller;
	}
	public int getId_child() {
		return id_child;
	}
	public void setId_child(int id_child) {
		this.id_child = id_child;
	}
	public String getDate_order() {
		return date_order;
	}
	public void setDate_order(String date_order) {
		this.date_order = date_order;
	}
}
