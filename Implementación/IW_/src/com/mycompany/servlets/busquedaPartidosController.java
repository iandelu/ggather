package com.mycompany.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.mysql.MySQLDaoManager;

/**
 * Servlet implementation class busquedaPartidosController
 */
@WebServlet("/busquedaPartidosController")
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
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
           
            Jugador jugadorAux = daoManager.getJugadorDAO().buscarJugadorPorEmail(email);
            
            
            if(jugadorAux != null && jugadorAux.getContraseña().equals(password)) {
            	
            	//jugador valido
            	session.setAttribute("jugador", jugadorAux);
            	response.sendRedirect("/IW_/View/mainMenuLogged.jsp");
            }
            else if(jugadorAux == null || !jugadorAux.getContraseña().equals(password)){
            	
            	response.sendRedirect("/IW_/View/login.jsp");
            }
            
            
            
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
