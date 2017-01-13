package com.school.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.components.entity.Order;
import com.school.components.entity.Seller;
import com.school.components.interface_i.IOrder;

@Service
public class OrderService {
	@Autowired
	private IOrder iOrder;

	public Collection<Order> infoAboutAllOrder(int page) {
		return iOrder.infoAboutAllOrder(page);
	}
		
	public Order infoAboutCountOfChildById(int id) {
		return iOrder.infoAboutCountOfChildById(id);
	}
}
