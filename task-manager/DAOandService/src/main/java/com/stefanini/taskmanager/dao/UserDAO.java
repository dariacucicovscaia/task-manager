package com.stefanini.taskmanager.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.stefanini.taskmanager.domain.User;

public class UserDAO extends DAOAbstractImpl<User> implements IUserDAO {

	@Override
	public User get(String userName) {
		Field fields[] = new User().getClass().getDeclaredFields();

		String columns = " ";
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getType().getName().equals("int")) {
				columns += "" + field.getName() + ",";
			} else if (field.getType().getName().equals("java.lang.String")) {
				columns += " " + field.getName() + ",";
			}
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += " ";

		String sql = "SELECT " + columns + "\r\n 	FROM users.users \r\n	WHERE userName = '" + userName + "';";

		User entity = null;

		try {
			Statement stmt = getConnection().createStatement();
			ResultSet result = stmt.executeQuery(sql);

			if (result.next()) {

				try {
					Constructor constr = new User().getClass().getConstructor();
					entity = (User) constr.newInstance();
					for (Field field : fields) {
						field.setAccessible(true);

						String fieldName = field.getName();
						Object fieldValue = result.getObject(fieldName);

						field.set(entity, fieldValue);
					}

				} catch (NoSuchMethodException | IllegalAccessException | InstantiationException
						| IllegalArgumentException | InvocationTargetException | SQLException | SecurityException e) {

					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entity;
	}
}
