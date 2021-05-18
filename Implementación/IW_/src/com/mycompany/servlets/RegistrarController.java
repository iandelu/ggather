package com.mycompany.servlets;

import java.io.IOException;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.mysql.MySQLDaoManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

public class RegistrarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//RequestDispatcher disparador = null;
        HttpSession session = request.getSession();
        Jugador jugador = (Jugador) session.getAttribute("Jugador");
        try{
             Class.forName("com.mysql.jdbc.Driver");
             MySQLDaoManager daoManager = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
             boolean login = jugador != null && !jugador.getEmail().equals("");
             String nextPage = "/View/register.jsp";
             String usuario = request.getParameter("usuario");
             String nombre = request.getParameter("nombre");
             String apellidos = request.getParameter("apellidos");
            // Date fechaNacimiento = Jugador.setFechaString(request.getParameter("fechanacimiento"));
             int telefono = Integer.parseInt(request.getParameter("telefono"));
             String email = request.getParameter("email");
             String password = request.getParameter("pass");
  
             Jugador jugadorAux = new Jugador( usuario,  nombre,  apellidos,  email, telefono, password,  new Date(2000,9,13), 0);

             
             daoManager.getJugadorDAO().insertar(jugadorAux);
             
             nextPage = "/View/mainMenuLogged.jsp";
             
            // disparador = request.getRequestDispatcher(nextPage);
            // disparador.include(request, response);
             
        }catch(Exception e){
            
        }
        
        //disparador.forward(request, response);
        response.sendRedirect("/IW_/View/mainMenuLogged.jsp");

             
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


