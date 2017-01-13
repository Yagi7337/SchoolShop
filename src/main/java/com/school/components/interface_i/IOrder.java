package com.school.components.interface_i;

import java.util.Collection;

import com.school.components.entity.Order;

public interface IOrder {
	
	Collection<Order> infoAboutAllOrder(int page);

	public Order infoAboutCountOfChildById(int id);
}
