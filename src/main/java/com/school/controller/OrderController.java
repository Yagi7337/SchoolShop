package com.school.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.school.components.entity.Order;
import com.school.components.entity.Seller;
import com.school.service.OrderService;

@RestController
@RequestMapping("/school/order")
public class OrderController {
	@Autowired
	private OrderService orderService;

	/**
	 * Get all orders from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/{page}", method = RequestMethod.GET)
	public Collection<Order> infoAboutAllOrder(@PathVariable("page") int page) {
		return orderService.infoAboutAllOrder(page);
	}
	
	/**
	 * Get all sellers from DB
	 * 
	 * @return
	 */
	@RequestMapping(value = "/view_count/{id}", method = RequestMethod.GET)
	public Order searchByIdSeller(@PathVariable("id") int id) {
		return orderService.infoAboutCountOfChildById(id);
	}
	
}
