<!DOCTYPE html>
<html lang="en">
<%@ page import = "com.mycompany.iw.Partido" %>
<%@ page import = "com.mycompany.iw.Pista" %>
<%@ page import = "com.mycompany.iw.Jugador" %>
<%@ page import = "com.mycompany.iw.mysql.MySQLDaoManager" %>
<%@ page import = "java.util.List" %>
<head>
	<title>Partidos</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
   
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>

<header id="main-header">
            
    <a id="logo-header" href="mainMenuLogged.jsp">
    <span class="header-pic"><img src="images/icons/logo3.png"></span>
        <span class="site-name">GGather</span>
    </a> 

    <nav>
        <ul>
            <li><a href="mainMenuLogged.jsp">Inicio</a></li>
            <li><a href="crearPartido.jsp">Crear Partido</a></li>
        </ul>
    </nav>

</header>
<%
   
	Partido partidoActual = (Partido) session.getAttribute("partidoActual");
	List<Jugador> jugadoresPartido = (List<Jugador>) session.getAttribute("jugadoresPartido");

	Class.forName("com.mysql.jdbc.Driver");
	MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
	String foto = man.getJugadorDAO().obtenerFotoPerfil(man.getJugadorDAO().obtener(partidoActual.getCreador()).getId());
	
%>
<body>
    
    <div class="limiter">
		<div class="container-menuPerfil">
			<div class="wrap-menuPerfil">
                    
                    
                    <header class="card__header" style="background-image: url(<% out.println(foto);%>); margin-top: -5px; width: 101%; margin-left: -2px;">
                        <h1>Partido de @<%= man.getJugadorDAO().obtener(partidoActual.getCreador()).getUsuario() %></h1>
                        <h2> <%= man.getPistaDAO().nombreDeporte(man.getPistaDAO().obtener(partidoActual.getPistaPartido()).getDeporte())%></h2>
                        <span class="focus-icon"> </span>
                        <i  style="left:630px; top:20px;" class="fa fa-user" aria-hidden="true"></i>
                        <h1 style="left: 650px;">2/4</h1>
                        </header>
                    
                  		  <div class= "wrap-input100">
							<br><span class=Datos-User>Jugadores: </span>
							
                                    <br><i  style="left:630px; top:20px; color:rgb(10, 139, 5);"  class="fa fa-user"  aria-hidden="true" onclick="location.href='menuPerfil.html'"></i> 
                                    Mankuco
                                    <br><i  style="left:630px; top:20px; color:rgb(10, 139, 5);" class="fa fa-user" aria-hidden="true" onclick="location.href='menuPerfil.html'" ></i> 
                                    ElPaco 
                                    <br><i  style="left:630px; top:20px; color:rgb(139, 5, 5);" class="fa fa-user" aria-hidden="true"></i>
                                    
                                    <br><i  style="left:630px; top:20px; color:rgb(139, 5, 5);" class="fa fa-user" aria-hidden="true"></i>
                  		    </div>

                              <div>
                                <span class=Datos-User>Fecha:  <br></span>
                              <i class="fa fa-calendar" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> <%=man.getReservaDAO().obtener(partidoActual.getReserva()).getFecha()%> </span>
                                        </div>

                              <div class= "wrap-input100" style="left: 400px; bottom:130px">
                     		   <span class=Datos-User>Nivel Partido </span>
								<div>
                                    Principiante
								</div>
							</div>


                              <div class= "wrap-input100" style="bottom:50px">
                                <i  style="left:630px; top:20px; color:rgb(96, 96, 97);" class="fa fa-clock-o" aria-hidden="true"></i>
                     		   <span class=Datos-User > Hora Inicio </span>
								<div>
                                    <%=man.getReservaDAO().obtener(partidoActual.getReserva()).getHoraInicio()%>
								</div>
                                

                                <div class= "wrap-input100" style="bottom:80px">
                                    
                                    <br><span class=Datos-User style="margin-left: 400px;"><i  style="left:630px; top:20px; color:rgb(96, 96, 97);" class="fa fa-clock-o" aria-hidden="true"></i> Hora Fin </span>
                                    <div style="margin-left: 400px;">
                                        <%=man.getReservaDAO().obtener(partidoActual.getReserva()).getHoraFin()%>
                                    </div>
							</div>

                            


                            
            
                  		  <div class= "wrap-input100">
                            <i  style="left:630px; top:20px; color:rgb(61, 61, 61);"  class="fa fa-map"  aria-hidden="true" onclick="location.href='menuPerfil.html'"></i>
							<span class=Datos-User>Club: </span> 
							 <%= man.getClubDAO().obtener(man.getPistaDAO().obtener(partidoActual.getPistaPartido()).getClub()).getNombreClub()%>

							<%String googleLink = man.getClubDAO().obtenerGoogle(man.getClubDAO().obtener(man.getPistaDAO().obtener(partidoActual.getPistaPartido()).getClub()).getId()); %>
                            <iframe src="<%out.println(googleLink); %>" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" ></iframe>
                   		 </div>
                            <br>
                            <form method="post" action="/IW_/inscribirsePartidoController">
                            	<div><button class="partido-btn" onclick="location.href='partido.html'">
                                ¡Unirme al partido!
                                
                            </button>
    
					</div> </form>
                    
				
			</div>
            
		</div>
	</div>

</body>