package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.components.entity.Child;
import com.school.components.interface_i.IChild;

@Service
public class ChildService {
	@Autowired
	public IChild iSchoolShop;

	public Child searchByIdChild(int id) {
		return iSchoolShop.searchByIdChild(id);
	}

	public void addChild(Child child) {
		iSchoolShop.addChild(child);
	}

	public void deleteByIdChild(int id) {
		iSchoolShop.deleteByIdChild(id);
	}

	public void updateChild(Child child) {
		iSchoolShop.updateChild(child);
	}
}