package com.mycompany.servlets;

import java.io.IOException;

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
 * Servlet implementation class LoginPropietarioController
 */

public class LoginPropietarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginPropietarioController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
        PropietarioBean propietarioBean = (PropietarioBean) request.getSession().getAttribute("PropietarioBean");
        
        	
        	try{
                Class.forName("com.mysql.jdbc.Driver");
                MySQLDaoManager daoManager = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
                
                String nextPage = "/View/login.jsp";
                String email = request.getParameter("email");
                String password = request.getParameter("pass");
               
                Club clubAux = daoManager.getClubDAO().buscarClubPorEmail(email);
                
            
                if(clubAux != null && clubAux.getContraseña().equals(password)) {
                	
                	//jugador valido
                	session.setAttribute("club", clubAux);
                	response.sendRedirect("/IW_/View/Dashboard/pages/dashboard.jsp");
                }
                else if(clubAux == null || !clubAux.getContraseña().equals(password)){
                	
                	response.sendRedirect("/IW_/View/loginPropietario.jsp");
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
