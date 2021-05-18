package com.mycompany.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.Partido;
import com.mycompany.iw.mysql.MySQLDaoManager;

/**
 * Servlet implementation class busquedaPartidosController
 */

public class busquedaPartidosController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public busquedaPartidosController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try{
			
            Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager daoManager = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            String nextPage = "/View/login.jsp";
            String fecha = request.getParameter("fecha");
            String localidad = request.getParameter("localidad");
            Long deporte = Long.parseLong(request.getParameter("deporte"));
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            LocalDate localDate = LocalDate.parse(fecha, formatter);
           
            List<Partido> partidos = daoManager.getPartidoDAO().buscarPartidos(deporte, localidad, localDate);
            
            
            
    	}catch(Exception e) {
    		
    	}
    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
