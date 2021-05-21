package com.mycompany.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class CalcularHorasController
 */
@WebServlet("/CalcularHorasController")
public class CalcularHorasController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CalcularHorasController() {
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
			
			Pista pistaActual = (Pista) session.getAttribute("pistaActual");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        	String date = request.getParameter("diaReserva");

        	LocalDate localDate = LocalDate.parse(date, formatter);
			List<Reserva> reservas = man.getReservaDAO().obtenerReservasDia(localDate, pistaActual.getId());
			
			LocalTime horaInicio = pistaActual.getHorarioInicio();
			LocalTime horaFin = pistaActual.getHorarioFin();
			List<LocalTime> horasOcupadas = new ArrayList<LocalTime>();
			List<LocalTime> horasLibres = new ArrayList<LocalTime>();
			LocalTime aux = horaInicio;
			
			for(int i = 0; i< reservas.size(); i++){
				horasOcupadas.add(reservas.get(i).getHoraInicio());
			}
			
			for(int i = horaInicio.getHour(); i< horaFin.getHour(); i++){
				horasLibres.add(aux);
				aux = LocalTime.of(aux.getHour()+1, 00);
				
			}
			
			for(int i = 0 ; i<horasLibres.size(); i++){
				for(int j = 0; j< horasOcupadas.size(); j++){
					if(horasLibres.get(i).getHour() == horasOcupadas.get(j).getHour()){
						horasLibres.remove(i);
					}
				}
			}
			
			session.setAttribute("diaReserva", localDate);
			session.setAttribute("horasLibres", horasLibres);
			
		} catch (ClassNotFoundException | SQLException | DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("/IW_/View/pista.jsp");
        
        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
