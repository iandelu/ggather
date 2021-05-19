package com.mycompany.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mycompany.iw.Club;
import com.mycompany.iw.Jugador;
import com.mycompany.iw.Partido;
import com.mycompany.iw.Pista;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.mysql.MySQLDaoManager;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CrearPartido
 */
@WebServlet("/CrearPartido")
public class CrearPartido extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CrearPartido() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
         
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession(false);
        System.out.println("Hola");
       

               
               //Connection conn = null;    
               //Class.forName("com.mysql.jdbc.Driver");
					try {
						Class.forName("com.mysql.jdbc.Driver");
		                MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");

               
               
					System.out.println("Hola");
               //Long creador = jugador.getId();
               Club club = new Club();
               Pista pista = new Pista();
               Partido partido = new Partido();
               
               String localidad = request.getParameter("localidad");
               String deporte = request.getParameter("deporte");
               
               Long dep = null;
               if(deporte == "1") dep =(long) 1;
               if(deporte == "2") dep = (long)2;
               if(deporte == "3") dep = (long)3;
               
               
              
               System.out.println("Hola");
              
					List <Pista> pistas = man.getPistaDAO().buscarPista(localidad, dep);
					session.setAttribute("pistas", pistas);
					
					} catch (DAOException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

               
               //Crea un objeto de una lista con todos los partidos para que el jsp pueda recogerlo
               
       
       //disparador.forward(request, response);
           
           
       response.sendRedirect("/IW_/View/mostrarPistas.jsp");
	}

}
