package com.stefanini.taskmanager.dao;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOAbstract<T> implements DAOInterface<T> {

	private Class<T> entityClazz;

	public Connection getConnection() {
		return DataBaseConnection.getConnection();
	}

	public String getTableName() {
		return entityClazz.getName().replace("com.stefanini.taskmanager.service.", "").toLowerCase() + "s";
	}

	public DAOAbstract() throws SQLException {
		// determine T
		ParameterizedType t = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClazz = (Class) t.getActualTypeArguments()[0];

	}

	@Override
	public List<T> getAll() throws SQLException {
		Field fields[] = entityClazz.getDeclaredFields();
		String columns = " ";
		for (Field field : fields) {
			field.setAccessible(true);
			columns += field.getName() + ",";
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += " ";
		String sql = "SELECT" + columns + " FROM public." + getTableName() + ";";
		Statement stmt = getConnection().createStatement();
		ResultSet result = stmt.executeQuery(sql);
		List<T> entity = new ArrayList<T>();
		T t = null;
		while (result.next()) {
			try {
				Constructor constr = entityClazz.getConstructor();
				t = (T) constr.newInstance();
				for (Field field : fields) {
					field.setAccessible(true);
					String fieldName = field.getName();
					Object fieldValue = result.getObject(fieldName);
					field.set(t, fieldValue);
				}
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			entity.add(t);
		}
		return entity;
	}

	public void put(T entity) throws SQLException {
		Field[] fields = entityClazz.getDeclaredFields();
	
		String columns = "(";
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getType().getName().equals("int")) {
				columns += "" + field.getName() + ",";
			} else if (field.getType().getName().equals("java.lang.String")) {
				columns += "'" + field.getName() + "',";
			}
			// columns += "\'" + field.getName() + "\',";
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += ")";

		String values = "VALUES (";
		for (Field field : fields) {
			Object value = null;
			field.setAccessible(true);
			try {
				value = field.get(entity);

			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (field.getType().getName().equals("java.util.UUID")) {
				values += "'" + value + "',";
			} else if (field.getType().getName().equals("java.lang.String")) {
				values += "'" + value + "',";
			}
			

		}
		values = values.substring(0, values.length() - 1);
		values += ") ";
		String insert = "INSERT INTO public." + getTableName() + " \n" + values + ";";

		Statement stmt = getConnection().createStatement();
		
		stmt.executeUpdate(insert);

	}

	@Override
	public T get(String userName) throws SQLException {
		Field fields[] = entityClazz.getDeclaredFields();

		String columns = " ";
		for (Field field : fields) {
			field.setAccessible(true);
			if (field.getType().getName().equals("int")) {
				columns += "" + field.getName() + ",";
			} else if (field.getType().getName().equals("java.lang.String")) {
				columns += "'" + field.getName() + "',";
			}
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += " ";

		String sql = "SELECT " + columns + "\r\n 	FROM public." + getTableName() + "\r\n	WHERE userName = '"
				+ userName + "';";

		T entity = null;
		Statement stmt = getConnection().createStatement();
		ResultSet result = stmt.executeQuery(sql);

		if (result.next()) {

			try {
				Constructor constr = entityClazz.getConstructor();
				entity = (T) constr.newInstance();
				for (Field field : fields) {
					field.setAccessible(true);
					String fieldName = field.getName();
					Object fieldValue = result.getObject(fieldName);

					// System.out.println(fieldValue + " "+ fieldName);
					field.set(entity, fieldValue);
				}

			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return entity;
	}

	public void remove(String username) throws SQLException {
		String sql = "DELETE FROM public." + getTableName() + " \r\n 	WHERE userName= '" + username + "' ;";

		Statement stmt = getConnection().createStatement();
		stmt.executeUpdate(sql);

	}

}
