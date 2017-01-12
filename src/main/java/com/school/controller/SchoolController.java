package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.components.entity.Child;
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

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Child surchById(@PathVariable("id") int id) {
		return schoolShopService.surchById(id);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createChild(@RequestBody Child children) {
		schoolShopService.createChild(children);
		return "Child was created";
	}

	/**
	 * Delete child by id
	 * 
	 * @return
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String deleteById(@PathVariable("id") int id) {
		schoolShopService.deleteById(id);
		return "Child " + id + " was delete";
	}

	/**
	 * Update information about child in DB
	 * 
	 * @param child
	 * @return
	 */
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateBike(@RequestBody Child child) {
		this.schoolShopService.updateChild(child);
		return "Child was update";
	}
}
