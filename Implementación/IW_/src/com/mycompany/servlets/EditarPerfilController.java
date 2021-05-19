package com.mycompany.servlets;

import java.io.IOException;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.javabean.JugadorBean;
import com.mycompany.iw.mysql.MySQLDaoManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Servlet implementation class EditarPerfilController
 */
@WebServlet("/EditarPerfilController")
public class EditarPerfilController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public EditarPerfilController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
        JugadorBean jugadorBean = (JugadorBean) session.getAttribute("jugadorBean");
		
		try{
            Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager daoManager = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            String nextPage = "/View/editarPerfil.jsp";
            
            String usuario = request.getParameter("usuario");
            String nombre = request.getParameter("nombre");
            String apellidos = request.getParameter("apellidos");
            String fechaNacimiento = request.getParameter("fechanacimiento");
            long telefono = Integer.parseInt(request.getParameter("telefono"));
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            
            Jugador jugadorActual = (Jugador) session.getAttribute("jugador");
            
           
            Jugador jugadorAux = new Jugador( usuario,  nombre,  apellidos,  email, telefono, password,  Date.valueOf(fechaNacimiento), 0);
            jugadorAux.setId(jugadorActual.getId());

            
            
            
            daoManager.getJugadorDAO().modificar(jugadorAux);
            session.setAttribute("jugador", jugadorAux);
            
            //nextPage = "/View/menuPerfil.jsp";
            
            
            
		} catch(Exception e) {
			
		}
		
		response.sendRedirect("/IW_/View/menuPerfil.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
