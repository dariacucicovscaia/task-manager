package com.stefanini.taskmanager.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	   private static Connection con = null;
	   
	    static
	    {
	        String url = "jdbc:mysql:// localhost:3306/public";
	        String user = "root";
	        String pass = "d@r1@Cuc1covscAIA";
	        try {
	         //   Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(url, user, pass);
	        }
	        catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    public static Connection getConnection()
	    {
	        return con;
	    }
}
