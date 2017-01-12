package com.school.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;

import com.school.entity.Child;

/**
 * Class for working with db MySQL
 * 
 * @author school
 * 
 */
@Repository("BikeDao")
public class SchoolShopDao implements ISchoolShop {

	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Child> {

		/**
		 * copy data from DB to child
		 */
		public Child mapRow(ResultSet rs, int rowNum) throws SQLException {
			Child child = new Child();
			child.setId(rs.getInt(1));
			child.setName(rs.getString(2));
			child.setSurname(rs.getString(3));

			return child;
		}

	}

	/**
	 * Looking information about child by id
	 * 
	 * @param id
	 * @return child
	 */
	public Child surchByID(int id) {
		final String SQL = "SELECT * FROM child WHERE id=?";
		Child child = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return child;
	}

//	public void updateBike(Child children) {
//		final String SQL = "UPDATE bike SET name=?, mark=? WHERE id=?";
//		final int id = children.getId();
//		final String name = children.getName();
//		final String surname = children.getSurname();
//
//		jdbc.update(SQL, new Object[] { id, name, surname });
//	}
	
}