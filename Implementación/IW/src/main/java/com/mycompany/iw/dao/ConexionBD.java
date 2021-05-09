package com.mycompany.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConexionBD {
	
	public ConexionBD(){
		
	}

	public Connection getConnection(String url, String usuario, String password) throws Exception {
		
		Connection con = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,usuario,password);
			
		} catch (final Exception e) {
			
			System.out.println(e);
		}
		
		return con;
	}
}
