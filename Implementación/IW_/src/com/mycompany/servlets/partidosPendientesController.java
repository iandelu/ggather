package com.mycompany.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class partidosPendientesController
 */
@WebServlet("/partidosPendientesController")
public class partidosPendientesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public partidosPendientesController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
        JugadorBean jugadorBean = (JugadorBean) session.getAttribute("jugadorBean");
        
        try {
        	
        	Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            List<Partido> partidos = man.getPartidoDAO().getHistorial(jugadorBean.getId());
			session.setAttribute("partidos", partidos);
			
        }catch(Exception e) {
    		
    	}
	}

}
