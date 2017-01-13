package com.school.components.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.school.components.entity.Child;
import com.school.components.interface_i.IChild;

/**
 * Class for working with db MySQL
 * 
 * @author school
 * 
 */
@Repository
public class ChildDao implements IChild {

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
			child.setAge(rs.getFloat(4));
			child.setPrice(rs.getFloat(5));
			child.setId_sell(rs.getInt(6));

			return child;
		}
	}

	/**
	 * Looking information about child by id
	 * 
	 * @param id
	 * @return child
	 */
	public Child searchByIdChild(int id) {
		final String SQL = "SELECT * FROM child WHERE id=?";
		Child child = jdbc.queryForObject(SQL, new workingWithRowMap(), id);
		return child;
	}
	
	/**
	 * Select all information about children
	 */
	public Collection<Child> infoAboutChildren(int page) {
		page *= 3;
		final String SQL = "SELECT * FROM child LIMIT 3 offset ?";
		List<Child> children = jdbc.query(SQL, new workingWithRowMap(), page);
		return children;
	}

	public void addChild(Child child) {
		final String SQL = "INSERT INTO child (name, surname, age, price, id_sell) values (?, ?, ?, ?, ?) ";
		final String name = child.getName();
		final String surname = child.getSurname();
		final float age = child.getAge();
		final float price = child.getPrice();
		final int id_sell = child.getId_sell();

		jdbc.update(SQL, new Object[] { name, surname, age, price, id_sell });
	}

	/**
	 * Delete child by id
	 * 
	 * @param id
	 */
	public void deleteByIdChild(int id) {
		final String SQL = "DELETE FROM child WHERE id=?";
		jdbc.update(SQL, id);
	}

	/**
	 * Update information about child by id
	 * 
	 * @param child
	 */

	public void updateChild(Child child) {
		final String SQL = "UPDATE child SET name=?, surname=?, age=?, price=?, id_sell=? WHERE id=?";
		final int id = child.getId();
		final String name = child.getName();
		final String surname = child.getSurname();
		final float age = child.getAge();
		final float price = child.getPrice();
		final int id_sell = child.getId_sell();

		jdbc.update(SQL, new Object[] { name, surname, age, price, id_sell, id });
	}

}