package com.school.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.components.entity.Order;
import com.school.components.entity.Seller;
import com.school.components.interface_i.IOrder;
import com.school.components.service.SellerDao.workingWithRowMap;

@Repository
public class OrderDao implements IOrder {
	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Order> {
		/**
		 * copy data from DB to order
		 */
		public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
			Order order = new Order();
			order.setId_order(rs.getInt(1));
			order.setId_seller(rs.getInt(2));
			order.setId_child(rs.getInt(3));
			order.setDate_order(rs.getString(4));

			return order;
		}
	}
	
	public Collection<Order> infoAboutAllOrder(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM order_table LIMIT 3 offset ?";
		List<Order> order = jdbc.query(SQL, new workingWithRowMap(), page);
		return order;
	}
	
	/**
	 * Looking information about count of child by seller id
	 * 
	 * @param id
	 * @return order
	 */
	public Order infoAboutCountOfChildById(int id) {
		final String SQL = "SELECT * from seller WHERE id_order=?";
		Order order = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return order;
	}

}
