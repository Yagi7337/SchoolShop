package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.components.entity.Child;
import com.school.components.interface_i.ISchoolShop;

@Service
public class SchoolShopService {
	@Autowired
	public ISchoolShop iSchoolShop;

	public Child surchById(int id) {
		return iSchoolShop.surchByID(id);
	}

	public void createChild(Child child) {
		iSchoolShop.createChild(child);
	}

	public void deleteById(int id) {
		iSchoolShop.deleteById(id);
	}

	public void updateChild(Child child) {
		iSchoolShop.updateChild(child);
	}
}