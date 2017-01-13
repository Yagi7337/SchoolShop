package com.school.components.interface_i;

import com.school.components.entity.Child;

public interface ISchoolShop {
	public Child surchByID(int id);

	public void createChild(Child child);

	public void deleteById(int id);

	public void updateChild(Child child);
}