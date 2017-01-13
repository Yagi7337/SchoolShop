package com.school.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.components.entity.Child;
import com.school.components.entity.Seller;
import com.school.service.SellerService;

@RestController
@RequestMapping("/school/seller")
public class SellerController {
	@Autowired
	private SellerService sellerService;

	/**
	 * Get seller by id from DB
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public Seller searchByIdSeller(@PathVariable("id") int id) {
		return sellerService.searchByIdSeller(id);
	}

	/**
	 * Get all sellers from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/information/{page}", method = RequestMethod.GET)
	public Collection<Seller> infoAboutSeller(@PathVariable("page") int page) {
		return sellerService.infoAboutSeller(page);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String addSeller(@RequestBody Seller seller) {
		sellerService.addSeller(seller);
		return "Seller was created";
	}
}
