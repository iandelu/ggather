<!DOCTYPE html>
<html lang="en">
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


<%
   
   
	List<Partido> partidos = (List<Partido>) session.getAttribute("partidos");

	Class.forName("com.mysql.jdbc.Driver");
	MySQLDaoManager man = new MySQLDaoManager("ggather.zapto.org", "java", "1234", "aplicacion");

	
%> 
<header id="main-header">
            
    <a id="logo-header" href="../mainMenu.jsp">
    <span class="header-pic"><img src="images/icons/logo3.png"></span>
        <span class="site-name">GGather</span>
    </a> 

    <nav>
        <ul>
            <li><a href="mainMenu.jsp">Inicio</a></li>
            <li><a href="home.jsp">Crear Partido</a></li>
            <li><a href="home.jsp"  >Acceder</a></li>
        </ul>
    </nav>

</header>

<body>

    <div class="search2-page__cards">
        <%
        
        for(int i = 0; i < pistas.size(); i++){

    	%>
    	   <div>
            <article class="card">
                <a class="card__header-link" >
                
               </a>
               <header class="card__header" style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones16.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                <h1>Partido de <%=man.getJugadorDAO().obtener(partidos.get(i).getCreador()).getUsuario() %></h1>
                    <h2><%man.getPistaDAO().obtener(partidos.get(i).getPistaPartido())%> </h2>
                </header>
               <div class="card_body">
                    <div class="card_address">
                        <div class="card_Adress_street">
                            
                            <h10 style="color: rgb(80, 75, 75);"><%man.getClubDAO().obtener(man.getPistaDAO().obtener(partidos.get(i).getPistaPartido()).getClub()).getLocalizacion()%></h1>
                            
                        </div>
                    </div>
                    <div class="slots">
                     <a id="2021-05-15T17:00:00" role="button" class="button button--filled" tabindex="0">
                         <div><%man.getReservaDAO().obtener(partidos.get(i).getReserva()).getHoraInicio()%></div></a>
 
                    </div>
                </div>
           </article>
           <%
        }
       %> 
    </div>

    
</body>