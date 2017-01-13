package com.school.components.interface_i;

import java.util.Collection;

import com.school.components.entity.Child;

public interface IChild {
	public Child searchByIdChild(int id);
	
	Collection<Child> infoAboutChildren(int page);

	public void addChild(Child child);
	
	public void deleteByIdChild(int id);

	public void updateChild(Child child);
}