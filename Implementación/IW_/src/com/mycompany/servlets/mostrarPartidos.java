package com.mycompany.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.mycompany.iw.Partido;
import com.mycompany.iw.Pista;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.mysql.MySQLDaoManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class mostrarPartidos
 */
@WebServlet("/mostrarPartidos")
public class mostrarPartidos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public mostrarPartidos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession(false);
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
			
			String id = (String) request.getParameter("partido");
			System.out.println(id);
			Long Id = Long.parseLong(id);
			
			Partido partido = new Partido();
			
			partido = man.getPartidoDAO().obtener(Id);
			
			
			session.setAttribute("partidoActual", partido);
			
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/IW_/View/partido.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
