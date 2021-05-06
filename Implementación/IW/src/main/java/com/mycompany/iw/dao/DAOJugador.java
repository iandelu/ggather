package com.mycompany.iw;

public class DAOJugador {
    
    public DAOJugador(){

    }

    public DAOContacto(Properties sqlproperties,String url, String usuario, String password) {
		this.sql_properties = sqlproperties;
		this.url = url;
		this.usuario = usuario;
		this.password = password;
	}

    public static DAOContacto getInstance() throws ClassNotFoundException, IOException, SQLException {
        if(instance == null) {
            instance = new DAOContacto();
        }
        return instance;
    }

    public 
}