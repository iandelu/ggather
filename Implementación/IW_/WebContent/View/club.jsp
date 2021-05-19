<!DOCTYPE html>
<html lang="en">
<%@ page import = "com.mycompany.iw.Club" %>
<%@ page import = "com.mycompany.iw.mysql.MySQLDaoManager" %>
<%
	Club clubActual = (Club) session.getAttribute("clubActual");
	Class.forName("com.mysql.jdbc.Driver");
	MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");
	
%>
<head>
	<title>Club</title>
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


<body>
    
    <div class="limiter">
		<div class="container-partido">
			<div class="wrap-menuPerfil">
                    <% String foto = man.getClubDAO().obtenerFotoClub(clubActual.getId());%>
                    <header class="card__header" style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones30.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                        <h1 style="bottom:120px; color: rgb(0, 114, 6);"  ><%= clubActual.getNombreClub() %></h1> 
                       
                    </header>
                
                    <div class= "wrap-input100">
                        <br><span class=Datos-User>Contacto: </span>
                        
                                <br><i  style="left:630px; top:20px; color:rgb(104, 105, 104);"  class="fa fa-phone"  aria-hidden="true" onclick="location.href='menuPerfil.html'"></i> 
                                 <%= clubActual.getTelefono() %>
                                <br><i  style="left:630px; top:20px; color:rgb(104, 105, 104);" class="fa fa-envelope" aria-hidden="true" onclick="location.href='menuPerfil.html'" ></i> 
                                 <%= clubActual.getEmail()%>
               
                          </div> 
                            
                  		  <div class= "wrap-input100">
                           <br> <i  style="left:630px; top:20px; color:rgb(61, 61, 61);"  class="fa fa-map"  aria-hidden="true" onclick="location.href='menuPerfil.html'"></i>
							<span class=Datos-User>Localizacion: <%= clubActual.getLocalizacion() %></span> 
							 
							 <%String googleLink = man.getClubDAO().obtenerGoogle(clubActual.getId()); %>

                            <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3149.1416034215736!2d-4.804544449583729!3d37.88037101375157!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd6d20a9d7928149%3A0xfc1bd9bfb662f945!2sOpen%20Arena!5e0!3m2!1ses!2ses!4v1621208247761!5m2!1ses!2ses" width="600" height="450" style="border:0;" allowfullscreen="" loading="lazy" ></iframe>
                   		 </div>
                            <br>

                            <div class= "wrap-input100">
                                 <span class=Datos-User>Deportes: </span> 

                            <div class="search2-page__cards">
                            <div>
                                <article class="card">
                                    <a class="card__header-link" >
                                     
                                    </a>
                                    <header class="card__header" style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_padel1.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                    
                                    
                                     </header>
                                    <div class="card_body">
                                        <div class="card_address">
                                            <div class="card_Adress_street">
                                                <span class="deporte-text" style="color: rgb(13, 99, 38); font-size: 20px; margin-left: 2px;"> <br> PÁDEL</span>
                                                <span class="deporte-text" style="color: rgb(50, 121, 161); font-size: 14px; margin-left: 2px;"> <br>15 PISTAS DE CRISTAL DISPONIBLES </span>
                                                 
                                            </div>
                                        </div>
                                        <div class="slots">
                                         <a>
                                             <div><button class="partido-btn" onclick="location.href='partido.html'">
                                                  ¡Crear Partido!
                                             </button>
                     
                                             </div>
                                         </a>
                     
                                        </div>
                                    </div>
                                </article>
                            </div> 

                            <div>
                                <article class="card">
                                    <a class="card__header-link" >
                                     
                                    </a>
                                    <header class="card__header" style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones14.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                    
                                    
                                     </header>
                                    <div class="card_body">
                                        <div class="card_address">
                                            <div class="card_Adress_street">
                                                <span class="deporte-text" style="color: rgb(13, 99, 38); font-size: 20px; margin-left: 2px;"> <br> FÚTBOL 11</span>
                                                <span class="deporte-text" style="color: rgb(50, 121, 161); font-size: 14px; margin-left: 2px;"> <br>2 CAMPOS DE CESPED DISPONIBLES </span>
                                                 
                                            </div>
                                        </div>
                                        <div class="slots">
                                         <a>
                                             <div><button class="partido-btn" onclick="location.href='partido.html'">
                                                  ¡Crear Partido!
                                             </button>
                     
                                             </div>
                                         </a>
                     
                                        </div>
                                    </div>
                                </article>
                            </div> 

                            <div>
                                <article class="card">
                                    <a class="card__header-link" >
                                     
                                    </a>
                                    <header class="card__header" style="background-image: url(&quot;https://s1.lanzadigital.com/wp-content/uploads/2020/06/Pistas-de-baloncesto-1-scaled.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                    
                                    
                                     </header>
                                    <div class="card_body">
                                        <div class="card_address">
                                            <div class="card_Adress_street">
                                                <span class="deporte-text" style="color: rgb(13, 99, 38); font-size: 20px; margin-left: 2px;"> <br> BALONCESTO</span>
                                                <span class="deporte-text" style="color: rgb(50, 121, 161); font-size: 14px; margin-left: 2px;"> <br>3 CANCHAS DISPONIBLES </span>
                                                 
                                            </div>
                                        </div>
                                        <div class="slots">
                                         <a>
                                             <div><button class="partido-btn" onclick="location.href='partido.html'">
                                                  ¡Crear Partido!
                                             </button>
                     
                                             </div>
                                         </a>
                     
                                        </div>
                                    </div>
                                </article>
                            </div> 

                            </div>

                            
                            
			</div>		

				
		</div>
            
	</div>
	

</body>