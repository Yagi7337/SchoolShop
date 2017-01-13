package com.school.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.components.entity.Seller;
import com.school.components.interface_i.ISeller;

@Repository
public class SellerDao implements ISeller{
	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Seller> {
		/**
		 * copy data from DB to seller
		 */
		public Seller mapRow(ResultSet rs, int rowNum) throws SQLException {
			Seller seller = new Seller();
			seller.setId(rs.getInt(1));
			seller.setName(rs.getString(2));
			seller.setSurname(rs.getString(3));
			seller.setPosition(rs.getString(4));

			return seller;
		}
	}

	/**
	 * Looking information about seller by id
	 * 
	 * @param id
	 * @return seller
	 */
	public Seller searchByIdSeller(int id) {
		final String SQL = "SELECT * FROM seller WHERE id=?";
		Seller seller = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return seller;
	}
	
	/**
	 * Select all information about seller
	 */
	public Collection<Seller> infoAboutSeller(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM seller LIMIT 3 offset ?";
		List<Seller> seller = jdbc.query(SQL, new workingWithRowMap(), page);
		return seller;
	}

	public void addSeller(Seller seller) {
		final String SQL = "INSERT INTO seller (name, surname, position) values (?, ?, ?) ";
		final String name = seller.getName();
		final String surname = seller.getSurname();
		final String position = seller.getPosition();

		jdbc.update(SQL, new Object[] { name, surname, position });
	}

}
