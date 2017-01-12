package com.school.dao;

import com.school.entity.Child;

public interface ISchoolShop {
	public Child surchByID(int id);
	public void createChild(Child children);
	public void deleteById(int id);
}