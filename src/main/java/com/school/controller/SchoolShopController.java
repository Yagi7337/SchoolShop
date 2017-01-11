package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.entity.Child;
import com.school.service.SchoolShopService;

@RestController
@RequestMapping("/zvi")
public class SchoolShopController {
	@Autowired
	private SchoolShopService schoolShopService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Child surchById(@PathVariable("id") int id) {
		return schoolShopService.surchById(id);
	}

//	@RequestMapping(value = "/update", method = RequestMethod.PUT)
//	public String updateBike(@RequestBody Bike bike) {
//		this.bikeShopService.updateBike(bike);
//		return "Bike was update";
//	}
}
