package com.mycompany.iw;

import java.util.Properties;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStream;

public class ConexionBD {
	
	//private String url,usuario,password;
        private String driver = "com.mysql.jdbc.Driver";
        private String url = "jdbc:mysql://http://ggather.zapto.org/ggather"
        private String usuario = "root";
        private String password = "";        
	
	public ConexionBD(){
		
	}
	/*
	public ConexionBD(String url, String usuario, String password) {
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}
	*/
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
