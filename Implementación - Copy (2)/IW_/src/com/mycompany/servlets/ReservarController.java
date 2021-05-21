package com.mycompany.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.mycompany.iw.Pista;
import com.mycompany.iw.Reserva;
import com.mycompany.iw.daos.DAOException;
import com.mycompany.iw.mysql.MySQLDaoManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class ReservarController
 */
@WebServlet("/ReservarController")
public class ReservarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ReservarController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
			
			
			String horaInicio = (String) request.getParameter("Hora Inicio");
			System.out.println(horaInicio);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
			LocalTime date = LocalTime.parse(horaInicio, formatter);
			LocalTime horaFin = LocalTime.of(date.getHour()+1, 0);
			
			
			LocalDate diaReserva = (LocalDate) session.getAttribute("diaReserva");
			
			Pista pistaActual = (Pista) session.getAttribute("pistaActual");
			Reserva reserva = new Reserva();
			
			
			reserva.setPista(pistaActual.getId());
			reserva.setFecha(diaReserva);
			reserva.setHoraInicio(date);
			reserva.setHoraFin(horaFin);
			
			man.getReservaDAO().insertar(reserva);
			
			response.sendRedirect("/IW_/View/mainMenuLogged.jsp");
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
