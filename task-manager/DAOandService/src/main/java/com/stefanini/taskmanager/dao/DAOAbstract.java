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
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * 
 * @author DCUCICOV
 *
 * @param <T>
 */
public abstract class DAOAbstract<T> implements DAOInterface<T> {

	Logger logger = Logger.getLogger(DAOAbstract.class);

	private Class<T> entityClazz;

	/**
	 * Creates a connection with the database
	 * 
	 * @return connection to the database
	 */
	public Connection getConnection() {
		return DataBaseConnection.getConnection();
	}

	/**
	 * Gets the table name from the database
	 * 
	 * @return table name
	 */
	public String getTableName() {
		return entityClazz.getName().replace("com.stefanini.taskmanager.domain.", "").toLowerCase() + "s";
	}

	/**
	 * Determines the generic type of the entity
	 */
	public DAOAbstract() {
		ParameterizedType t = (ParameterizedType) this.getClass().getGenericSuperclass();
		entityClazz = (Class) t.getActualTypeArguments()[0];
		BasicConfigurator.configure();
	}

	@Override
	public List<T> getAll() {

		Field fields[] = entityClazz.getDeclaredFields();
		String columns = " ";
		for (Field field : fields) {
			field.setAccessible(true);
			columns += field.getName() + ",";
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += " ";
		String sql = "SELECT" + columns + " FROM users." + getTableName() + ";";
		ResultSet result = null;
		try {
			Statement stmt = getConnection().createStatement();
			result = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			logger.error(e1.getMessage());
		}
		List<T> entity = new ArrayList<T>();
		T t = null;
		try {
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
				} catch (IllegalArgumentException e) {
					logger.error(e.getMessage());
				} catch (NoSuchMethodException e) {
					logger.error(e.getMessage());
				} catch (SecurityException e) {
					logger.error(e.getMessage());
				} catch (InstantiationException e) {
					logger.error(e.getMessage());
				} catch (IllegalAccessException e) {
					logger.error(e.getMessage());
				} catch (InvocationTargetException e) {
					logger.error(e.getMessage());
				}
				entity.add(t);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return entity;
	}

	@Override
	public List<T> getAllWithId(int id) {

		Field fields[] = entityClazz.getDeclaredFields();
		String columns = " ";
		for (Field field : fields) {
			field.setAccessible(true);
			columns += field.getName() + ",";
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += " ";
		String sql = "SELECT" + columns + " FROM users." + getTableName() + " WHERE id=" + id + " ;";

		ResultSet result = null;
		try {
			Statement stmt = getConnection().createStatement();
			result = stmt.executeQuery(sql);
		} catch (SQLException e1) {
			logger.error(e1.getMessage());
		}
		List<T> entity = new ArrayList<T>();
		T t = null;
		try {
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
				} catch (InvocationTargetException e) {
					logger.error(e.getMessage());

				} catch (NoSuchMethodException e) {
					logger.error(e.getMessage());

				} catch (SecurityException e) {
					logger.error(e.getMessage());

				} catch (InstantiationException e) {
					logger.error(e.getMessage());

				} catch (IllegalAccessException e) {
					logger.error(e.getMessage());

				} catch (IllegalArgumentException e) {
					logger.error(e.getMessage());

				}
				entity.add(t);
			}
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return entity;
	}

	@Override
	public void put(T entity) {

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

			try {
				Object value = field.get(entity);
				if (field.getType().getName().equals("int")) {
					values += value + ",";
				} else if (field.getType().getName().equals("java.lang.String")) {
					values += "'" + value + "',";
				}
			} catch (IllegalArgumentException e) {
				logger.error(e.getMessage());
			} catch (IllegalAccessException e) {
				logger.error(e.getMessage());
			}

		}
		values = values.substring(0, values.length() - 1);
		values += ") ";
		String insert = "INSERT INTO users." + getTableName() + " \n" + values + ";";

		Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
			stmt.executeUpdate(insert);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public T get(String userName) {
		Field fields[] = entityClazz.getDeclaredFields();

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

		String sql = "SELECT " + columns + "\r\n 	FROM users." + getTableName() + "\r\n	WHERE userName = '"
				+ userName + "';";

		T entity = null;

		try {
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

						field.set(entity, fieldValue);
					}

				} catch (NoSuchMethodException e) {
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
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entity;
	}

	@Override
	public T get(int id) {
		Field fields[] = entityClazz.getDeclaredFields();

		String columns = " ";
		for (Field field : fields) {
			columns += field.getName() + ",";
		}
		columns = columns.substring(0, columns.length() - 1);
		columns += " ";

		String sql = "SELECT " + columns + "\r\n 	FROM users." + getTableName() + "\r\n	WHERE id=" + id + ";";

		T entity = null;

		try {
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
						field.set(entity, fieldValue);
					}

				} catch (NoSuchMethodException e) {
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
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return entity;
	}

	@Override
	public void remove(int id) {
		String sql = "DELETE FROM users." + getTableName() + " \r\n 	WHERE id= '" + id + "' ;";

		Statement stmt = null;
		try {
			stmt = getConnection().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}

	}
}