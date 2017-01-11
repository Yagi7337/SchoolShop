package com.school.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
public class SchoolShopDao implements ISchoolShop {

	/**
	 * variable to work with the base
	 */
	@Autowired
	private JdbcTemplate jdbc;

	public static class workingWithRowMap implements RowMapper<Child> {

		/**
		 * copy data from DB to student
		 */
		public Child mapRow(ResultSet rs, int rowNum) throws SQLException {
			Child children = new Child();
			children.setId(rs.getInt(1));
			children.setName(rs.getString(2));
			children.setSurname(rs.getString(3));

			return children;
		}

	}

	/**
	 * Looking information about bike by id
	 * 
	 * @param id
	 * @return bike
	 */
	public Child surchByID(int id) {
		final String SQL = "SELECT * FROM bike WHERE id=?";
		Child children = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return children;
	}

	public void updateBike(Child children) {
		final String SQL = "UPDATE bike SET name=?, mark=? WHERE id=?";
		final int id = children.getId();
		final String name = children.getName();
		final String surname = children.getSurname();

		jdbc.update(SQL, new Object[] { id, name, surname });
	}
	
}