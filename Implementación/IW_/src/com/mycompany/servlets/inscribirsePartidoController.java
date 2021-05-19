package com.mycompany.servlets;

import java.io.IOException;
import java.sql.Date;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.Partido;
import com.mycompany.iw.javabean.JugadorBean;
import com.mycompany.iw.mysql.MySQLDaoManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class inscribirsePartidoController
 */
@WebServlet("/inscribirsePartidoController")
public class inscribirsePartidoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public inscribirsePartidoController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
        Jugador jugadorAUX = (Jugador) session.getAttribute("jugador");
        Partido partidoActual = (Partido) session.getAttribute("partidoActual");
        
		try{
            Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            String nextPage = "/View/editarPerfil.jsp";
            
            
            man.getPartidoDAO().inscribirsePartido(jugadorAUX, partidoActual);            
            
            
            
            //nextPage = "/View/menuPerfil.jsp";
            
            
            
		} catch(Exception e) {
			
		}
		
		response.sendRedirect("/IW_/View/partidoPendiente.jsp");
	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
