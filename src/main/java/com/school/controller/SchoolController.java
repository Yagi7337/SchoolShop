package com.school.controller;

import java.util.Collection;

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
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	private SchoolShopService schoolShopService;

	/**
	 * Get child by id from DB
	 * 
	 * @param id
	 * @return
	 */
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Child surchById(@PathVariable("id") int id) {
		return schoolShopService.surchById(id);
	}

//	/**
//	 * Update information about bike in DB
//	 * 
//	 * @param child
//	 * @return
//	 */
//	@RequestMapping(value = "/update", method = RequestMethod.PUT)
//	public String updateChild(@RequestBody Child children) {
//		this.schoolShopService.updateChild(children);
//		return "Child was update";
//	}

//	/**
//	 * Information about all bikes in DB
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/information/{page}", method = RequestMethod.GET)
//	public Collection<Bike> informationAboutBikes(@PathVariable("page") int page) {
//		return bikeShopService.informationAboutBikes(page);
//	}
//
//	/**
//	 * Remove bike by id
//	 * 
//	 * @return
//	 */
//	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
//	public String removeBike(@PathVariable("id") int id) {
//		bikeShopService.removeBike(id);
//		return "Bike " + id + " was delete";
//	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createChild(@RequestBody Child children) {
		schoolShopService.createChild(children);
		return "Child was created";
	}
}
