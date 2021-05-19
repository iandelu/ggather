package com.mycompany.servlets;

import java.io.IOException;
import java.sql.SQLException;

import com.mycompany.iw.mysql.MySQLDaoManager;
import java.util.List;
import java.util.ArrayList;
import com.mycompany.iw.*;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.javabean.JugadorBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class verHistorialController
 */
@WebServlet("/verHistorialController")
public class verHistorialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public verHistorialController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		Jugador jugador = (Jugador) session.getAttribute("jugador");
		System.out.println(jugador.getEmail());

		try {
			
			Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            List<Partido> partidos = man.getPartidoDAO().getHistorial(jugador.getId());
			session.setAttribute("partidos", partidos);

            
            
		}catch(DAOException | SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("IW_/View/historialPartidos.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
	}

}
