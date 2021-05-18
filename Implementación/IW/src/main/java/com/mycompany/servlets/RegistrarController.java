/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import com.mycompany.iw.Jugador;
import com.mycompany.iw.mysql.MySQLDaoManager;
import com.mycompany.iw.mysql.MySQLJugadorDAO;
import java.sql.Date;
import javax.servlet.http.HttpSession;

/**
 *
 * @author crist
 */
public class RegistrarController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrarController() {
        super();
        // TODO Auto-generated constructor stub
    }
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher disparador = null;
        HttpSession session = request.getSession();
        Jugador jugador = (Jugador) session.getAttribute("Jugador");
        try{
            
             MySQLDaoManager daoManager = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
             boolean login = jugador != null && !jugador.getEmail().equals("");
             String nextPage = "/View/register.jsp";
             String usuario = request.getParameter("usuario");
             String nombre = request.getParameter("nombre");
             String apellidos = request.getParameter("apellidos");
             Date fechaNacimiento = Jugador.setFechaString(request.getParameter("fechanacimiento"));
             int telefono = Integer.parseInt(request.getParameter("telefono"));
             String email = request.getParameter("email");
             String password = request.getParameter("pass");
             
             Jugador jugadorAux = new Jugador();
             jugadorAux.setUsuario(usuario);
             jugadorAux.setNombre(nombre);
             jugadorAux.setApellidos(apellidos);
             jugadorAux.setFechaNacimiento(fechaNacimiento);
             jugadorAux.setTelefono(telefono);
             jugadorAux.setEmail(email);
             jugadorAux.setContraseña(password);
             
             daoManager.getJugadorDAO().insertar(jugadorAux);
             
             nextPage = "/View/mainMenuLogged.jsp";
             disparador = request.getRequestDispatcher(nextPage);
             
             
             
        }catch(Exception e){
            
        }
        
        disparador.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
