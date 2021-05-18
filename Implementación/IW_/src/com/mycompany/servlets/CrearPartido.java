package com.mycompany.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
		// TODO Auto-generated method stub
		
		String nextPage = "Vistas_v1/mainMenu.jsp";
        Jugador jugador = (Jugador)request.getSession().getAttribute("Jugador");
         RequestDispatcher disparador = null;
         HttpSession objsesion = request.getSession();
        //ServletContext application = getServletContext();
        
            
            
            try{
                
                //Connection conn = null;    
                //Class.forName("com.mysql.jdbc.Driver");
                MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
                
                
                
                Long creador = jugador.getId();
                Club club = new Club();
                Pista pista = new Pista();
                Partido partido = new Partido();
                
                String localidad = request.getParameter("localidad");
                String deporte = request.getParameter("deporte");
                
                Long dep;
                if(deporte == "1") dep =(long) 1;
                if(deporte == "2") dep = (long)2;
                if(deporte == "3") dep = (long)3;
                
               /* List<Pista> pistas = man.getPistaDAO().obtenerTodos();
                List<Club> clubes = man.getClubDAO().obtenerTodos();
                List<Partido> partidos = man.getPartidoDAO().obtenerTodos();
                List<Pista> aux = new ArrayList<>();
                List<Partido> auxpartidos = new ArrayList<>();
                
                for(int i = 0; i < clubes.size(); i++){
                    for(int j = 0; j < pistas.size(); j++){
                        if(clubes.get(i).getId() == pistas.get(j).getClub() && clubes.get(i).getLocalizacion() == localidad && pistas.get(j).getDeporte() == dep){
                            aux.add(pistas.get(j));
                        }
                    }
                }
                
                for(int i = 0; i < aux.size(); i++){
                    for(int j = 0; j < partidos.size(); j++){
                        if(aux.get(i).getId() == partidos.get(j).getPistaPartido()){
                            auxpartidos.add(partidos.get(j));
                        }
                    }
                }*/
                
                List<Pista> pistas = man.getPistaDAO().buscarPista(localizacion, dep);
                
                //Crea un objeto de una lista con todos los partidos para que el jsp pueda recogerlo
                objsesion.setAttribute("partidos", auxpartidos);
                
                 }catch(Exception e){
            
                     }
        
        disparador.forward(request, response);
        response.sendRedirect("busquedaPartidos.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
