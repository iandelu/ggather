package com.mycompany.servlets;

import java.io.IOException;
import java.sql.Date;

import com.mycompany.iw.Club;
import com.mycompany.iw.Jugador;
import com.mycompany.iw.javabean.JugadorBean;
import com.mycompany.iw.javabean.PropietarioBean;
import com.mycompany.iw.mysql.MySQLDaoManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrarPropietarioController
 */
public class RegistrarPropietarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegistrarPropietarioController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
        PropietarioBean propietario = (PropietarioBean) request.getSession().getAttribute("PropietarioBean");
        
        	try{
             Class.forName("com.mysql.jdbc.Driver");
             MySQLDaoManager daoManager = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
       
             String nextPage = "/View/register.jsp";
             String nombreClub = request.getParameter("nombreClub");
             String nombrePropietario = request.getParameter("nombrePropietario");
             String localizacion = request.getParameter("localidad");
            // Date fechaNacimiento = Jugador.setFechaString(request.getParameter("fechanacimiento"));
             Long telefono = Long.parseLong(request.getParameter("telefono"));
             String email = request.getParameter("email");
             String password = request.getParameter("pass");
             
             Club clubAux = new Club(nombreClub, localizacion, email, password, telefono, nombrePropietario, false);
             
             
             daoManager.getClubDAO().insertar(clubAux);
             
             nextPage = "/View/mainMenuLogged.jsp";
             
            // disparador = request.getRequestDispatcher(nextPage);
            // disparador.include(request, response);
             
        }catch(Exception e){
            
        }
        
        //disparador.forward(request, response);
        response.sendRedirect("/IW_/View/homePropietario.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
