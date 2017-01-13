package com.school.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.components.entity.Child;
import com.school.components.interface_i.ISchoolShop;

/**
 * Class for working with db MySQL
 * 
 * @author school
 * 
 */
@Repository
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
	
	public void createChild(Child child) {
		final String SQL = "INSERT INTO child (name, surname) values (?, ?) ";
		final String name = child.getName();
		final String surname = child.getSurname();

		jdbc.update(SQL, new Object[] { name, surname });
	}
	
	/**
	 * Delete child by id
	 * 
	 * @param id
	 */
	public void deleteById(int id) {
		final String SQL = "DELETE FROM child WHERE id=?";
		jdbc.update(SQL, id);
	}
	
	/**
	 * Update information about child by id
	 * 
	 * @param child
	 */
	
	public void updateChild(Child child){
		final String SQL = "UPDATE child SET name=?, surname=? WHERE id=?";
		final int id = child.getId();
		final String name = child.getName();
		final String surname = child.getSurname();

		jdbc.update(SQL, new Object[] { name, surname, id });
	}
	
}