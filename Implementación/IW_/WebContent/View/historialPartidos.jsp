<!DOCTYPE html>
<html lang="en">
<%@ page import = "com.mycompany.iw.Partido" %>
<%@ page import = "com.mycompany.iw.Pista" %>
<%@ page import = "com.mycompany.iw.Jugador" %>
<%@ page import = "com.mycompany.iw.mysql.MySQLDaoManager" %>
<%@ page import = "java.util.List" %>

<%@page import = "com.mycompany.iw.javabean.JugadorBean" %>
<jsp:useBean id="jugadorBean" class = "com.mycompany.iw.javabean.JugadorBean" scope="session"/>
<head>
	<title>Historial de partidos</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="back" type="image/jpg" href="images/backgrounds/loginBack.jpg"/>
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


 
<body>

	<div class="limiter">
		<div class="container-menuPerfil">
			<div class="wrap-menuPerfil">
                
					<span class="login100-form-title">
					<BR>	Historial de partidos
					</span>

                    
					
                    <div class="search2-page__cards">
       
        
                        <div>
                            <article class="card">
                                <a class="card__header-link" >
                                 
                                </a>
                                <header class="card__header" style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones16.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                 <h1>Partido de @LUISANERI ></h1>
                    			 <h2> PADEL </h2>
                                 </header>
                                <div class="card_body">
                                    <div class="card_address">
                                        <div class="card_Adress_street">
                                         <span class="focus-input100"></span>
                                         <i class="fa fa-calendar" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 25/05/2021 </span>
                                            <i class="fa fa-clock-o" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 19:00</span>
                                             
                                       </div>
                                    </div>
                                    <div class="slots">
                                     <a>
                                         <div><button class="partido-btn" onclick="location.href='partido.jsp'">
                                             Ver Detalles
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
                                <header class="card__header" style="background-image: url(&quot;https://www.javea.com/wp-content/uploads/2020/09/pista-basket-camping-javea.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                 <h1>Partido de @JUANILLO ></h1>
                    			 <h2> BALONCESTO </h2>
                                 </header>
                                <div class="card_body">
                                    <div class="card_address">
                                        <div class="card_Adress_street">
                                         <span class="focus-input100"></span>
                                         <i class="fa fa-calendar" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 25/05/2021 </span>
                                            <i class="fa fa-clock-o" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 19:00</span>
                                             
                                       </div>
                                    </div>
                                    <div class="slots">
                                     <a>
                                         <div><button class="partido-btn" onclick="location.href='partido.jsp'">
                                             Ver Detalles
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
                                <header class="card__header" style="background-image: url(&quot;https://urbancolex.com/wp-content/uploads/2019/03/cancha-de-baloncesto-1024x576.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                 <h1>Partido de @JULIAN ></h1>
                    			 <h2> BALONCESTO </h2>
                                 </header>
                                <div class="card_body">
                                    <div class="card_address">
                                        <div class="card_Adress_street">
                                         <span class="focus-input100"></span>
                                         <i class="fa fa-calendar" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 25/05/2021 </span>
                                            <i class="fa fa-clock-o" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 19:00</span>
                                             
                                       </div>
                                    </div>
                                    <div class="slots">
                                     <a>
                                         <div><button class="partido-btn" onclick="location.href='partido.jsp'">
                                             Ver Detalles
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
                                <header class="card__header" style="background-image: url(&quot;https://lh3.googleusercontent.com/proxy/UqjYewLlQqL1yntPrWbL1ZRW2qowy5PoUXc9hfTXvg72cmHxNBlscqpn6q-DKOPlnutIOk1LEJFLNxHWtKud3dFjxITDZVX12qagXPMDikWXlfbh3o-etzmwhZMu_lmYg2fzVlCZTEizIQXfdi2AsaQcvvNTAdQXpnjqjtyMVxb8LwmkVxKR&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                 <h1>Partido de @ELKIKE ></h1>
                    			 <h2> FUTBOL </h2>
                                 </header>
                                <div class="card_body">
                                    <div class="card_address">
                                        <div class="card_Adress_street">
                                         <span class="focus-input100"></span>
                                         <i class="fa fa-calendar" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 25/05/2021 </span>
                                            <i class="fa fa-clock-o" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 19:00</span>
                                             
                                       </div>
                                    </div>
                                    <div class="slots">
                                     <a>
                                         <div><button class="partido-btn" onclick="location.href='partido.jsp'">
                                             Ver Detalles
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
                                <header class="card__header" style="background-image: url(&quot;https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones16.jpg&quot;); margin-top: -5px; width: 101%; margin-left: -2px;">
                                 <h1>Partido de @PEPILLO ></h1>
                    			 <h2> PADEL </h2>
                                 </header>
                                <div class="card_body">
                                    <div class="card_address">
                                        <div class="card_Adress_street">
                                         <span class="focus-input100"></span>
                                         <i class="fa fa-calendar" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 25/05/2021 </span>
                                            <i class="fa fa-clock-o" aria-hidden="true"></i>
                                            <span style="color: rgb(80, 75, 75); font-size: 14px; margin-left: 2px;"> 19:00</span>
                                             
                                       </div>
                                    </div>
                                    <div class="slots">
                                     <a>
                                         <div><button class="partido-btn" onclick="location.href='partidoHistorial.jsp'">
                                             Ver Detalles
                                         </button>
                 
                                         </div>
                                     </a>
                 
                                    </div>
                                </div>
                            </article>
                        </div>
                        

		
					<div class="text-center p-t-30">
						<a class="txt2" onclick="location.href='menuPerfil.jsp'">
							Volver al mi perfil
							<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
						</a>
					</div>
				
			</div>
		</div>
	</div>

	
	

	
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>