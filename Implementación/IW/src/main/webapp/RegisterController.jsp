<%-- 
    Document   : RegisterController
    Created on : 10-may-2021, 0:12:13
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

if(Jugador != null && !Jugador.getEmail().equals("")){
    
    nextPage = "Vistas_v1/mainMenu.html";
    mensajeNextPage = "Ya estas logado";
    
}
else{
    
    nextPage = "Vistas_v1/register.html";
    String email = request.getParameter("email");
    String password = request.getParameter("pass");
    
    if(email != null){
        
        String usuario = request.getParameter("usuario");
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        Date fechaNacimiento = Jugador.setFechaString(request.getParameter("fechanacimiento"));
        int telefono = Integer.parseInt(request.getParameter("telefono"));
        email = request.getParameter("email");
        password = request.getParameter("pass");
        
        Connection conn = null;
        Class.forName("com.mysql.jdbc.Driver");
        MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
        Jugador jugador = new Jugador(usuario, nombre, apellidos, email, telefono, password, fechaNacimiento, 0);
        man.getJugadorDAO().insertar(jugador);
        
        %>
        <jsp:setProperty property = "email" value = "<%=email%>" name = "Jugador" />
        <jsp:setProperty property = "password" value = "<%=password%>" name = "Jugador" />
        
        <%
            nextPage = "Vistas_v1/mainMenu.html";
            mensajeNextPage = "";
    }
    
}

%>
<jsp:forward page = "<%=nextPage%>">
    <jsp:param value = "<%=mensajeNextPage%>" name = "message" />
</jsp:forward>



























