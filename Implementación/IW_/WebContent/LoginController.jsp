<%-- 
    Document   : LoginController
    Created on : 11-may-2021, 2:03:14
    Author     : crist
--%>

<%@page import="com.mycompany.iw.mysql.MySQLDaoManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mycompany.iw.Jugador" %>
<%@ page import="com.mycompany.iw.daos.JugadorDao" %>
<%@ page import="com.mycompany.iw.mysql.MySQLJugadorDAO" %>

<jsp:useBean id = "Jugador" scope = "session" class = "com.mycompany.iw.Jugador"></jsp:useBean>
<%@page import="java.io.InputStream" %>

<%
    String nextPage = "Vistas_v1/mainMenu.html";
    String mensajeNextPage = "";
    
    if(Jugador == null || Jugador.getEmail().equals("")){
        
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        
        if(email != null){
            
            Jugador jugador = new Jugador();
            
            Connection conn = null;
            Class.forName("com.mysql.jdbc.Driver");
            MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
            
            jugador.setEmail(email);
            Jugador jugadorAux = man.getJugadorDAO().buscarJugadorPorEmail(jugador);
            
            if(jugadorAux != null && jugadorAux.getContraseña().equals(password)){
                //Jugador valido
                
%>
<jsp:setProperty property = "email" value = "<%=email%>" name = "Jugador"/>
<jsp:setProperty property = "password" value = "<%=password%>" name = "Jugador"/>

<%
            }
        }
    }





%>