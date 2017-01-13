package com.school.components.entity;

public class Child {
	private int id;
	private String name;
	private String surname;
	private float age;
	private float price;
	private int id_sell;

	public Child() {
	}

	public Child(int id, String name, String surname, float age, float price, int id_sell) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.price = price;
		this.id_sell = id_sell;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId_sell() {
		return id_sell;
	}

	public void setId_sell(int id_sell) {
		this.id_sell = id_sell;
	}
}
