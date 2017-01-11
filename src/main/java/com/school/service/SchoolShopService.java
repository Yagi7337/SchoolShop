package com.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.dao.ISchoolShop;
import com.school.entity.Child;

@Service
public class SchoolShopService {
	
	@Autowired
	private ISchoolShop iSchoolShop;

	public Child surchById(int id) {
		return iSchoolShop.surchByID(id);
	}

//	public void updateBike(Child children) {
//		iSchoolShop.updateBike(children);
//	}
}