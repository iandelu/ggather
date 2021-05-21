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
import com.mycompany.iw.Partido;
import com.mycompany.iw.Jugador;
import com.mycompany.iw.mysql.MySQLDaoManager;
import com.mycompany.iw.daos.PartidoDAO;
import com.mycompany.iw.mysql.MySQLPartidoDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
/**
 *
 * @author crist
 */
public class CrearPartido extends HttpServlet {

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
        
        String nextPage = "Vistas_v1/mainMenu.html";
        Jugador jugador = (Jugador)request.getSession().getAttribute("Jugador");
        ServletContext application = getServletContext();
        
        if(jugador == null || jugador.getEmail().equals("")){
            
            nextPage = "Vistas_v1/mainMenu.html";
        }
        else{
            
            nextPage = "Vistas_v1/crearPartido.html";
            
            try{
                
                Connection conn = null;    
                Class.forName("com.mysql.jdbc.Driver");
                MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
                Partido partido = new Partido();
                Long creador = jugador.getId();
                
                
            }catch(ClassNotFoundException | SQLException ex){
                
                System.out.println(ex);
            }
            
            
            
            
            
        }
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
