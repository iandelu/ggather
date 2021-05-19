<!DOCTYPE html>
<html lang="es">
<%@ page import = "com.mycompany.iw.Partido" %>
<%@ page import = "com.mycompany.iw.Pista" %>
<%@ page import = "com.mycompany.iw.Reserva" %>
<%@ page import = "com.mycompany.iw.mysql.MySQLDaoManager" %>
<%@ page import = "java.time.LocalDate" %>
<%@ page import = "java.time.format.DateTimeFormatter" %>
<%@ page import = "java.time.*" %>
<%@ page import = "java.util.List" %>

<head>
	<title>Historial</title>
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
            
    <a id="logo-header" href="mainMenu.html">
    <span class="header-pic"><img src="images/icons/logo3.png"></span>
        <span class="site-name">GGather</span>
    </a> 

    <nav>
        <ul>
            <li><a href="mainMenu.html">Inicio</a></li>
            <li><a href="home.html">Crear Partido</a></li>
            <li><a href="home.html"  >Acceder</a></li>
        </ul>
    </nav>

</header>

<%
   
	Pista pistaActual = (Pista) session.getAttribute("pistaActual");

	Class.forName("com.mysql.jdbc.Driver");
	MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
	
	
%> 

<body>
    
    <div class="limiter">
		<div class="container-menuPerfil">
			<div class="wrap-menuPerfil">
                    
                    <header class="card__header" style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones16.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                        <h1><%=man.getClubDAO().obtener(pistaActual.getClub()).getNombreClub()%></h1>
                        <h2><%= man.getPistaDAO().nombreDeporte(pistaActual.getDeporte()) %></h2>
                        <span class="focus-icon"> </span>
                        <i  style="left:590px; top:20px; color: red;" class="fa fa-map-pin" aria-hidden="true"></i>
                        <h1 style="left: 610px;">Pista <%=pistaActual.getId() %></h1>
                        </header>
                        
                        <form class="registro-form validate-form" method="post" action="/IW_/CalcularHorasController">
                            <span class="login100-form-title">
                                <br>Reservar Pista <%=pistaActual.getId() %> <br><br> <h6>Selecciona el dia para tu reserva</h6>
                            </span>
        
                            <div class="wrap-input100 validate-input" data-validate = "Debes introducir un número valido">
                                <input  min="2021-05-19" class="input100" type="date" name="diaReserva" placeholder="Dia">
                                <span class="focus-input100"></span>
                                <span class="symbol-input100">
                                    <i class="fa fa-calendar" aria-hidden="true"></i>
                                </span>
                             
                            </div>
        					
        			
        					
        					
        					
        					
                      
                            <div class="container-login100-form-btn">
                                <button class="login100-form-btn">
                                    Siguiente
                                </button>
                            </div>
                            
                            <div class="text-center p-t-30">
                                
                        </form>


                          
                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3149.1416034215736!2d-4.804544449583729!3d37.88037101375157!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd6d20a9d7928149%3A0xfc1bd9bfb662f945!2sOpen%20Arena!5e0!3m2!1ses!2ses!4v1621208247761!5m2!1ses!2ses" width="800" height="225" style="border:0;" allowfullscreen="" loading="lazy" ></iframe>   
					
                   
				
			</div>
            
		</div>

	</div>

</body>

<script src="js/main.js"></script>


