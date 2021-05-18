<!DOCTYPE html>
<html lang="es">
<head>
	<title>Login</title>
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
						Mi Perfil
					</span>

                    
                    <div class="menuPerfil-pic js-tilt" data-tilt>
                        <img  src="images/icons/mankuco.PNG" alt="IMG">
                    </div>
					
					<div class="Datos">
                  	  	<div class= "wrap-input100">
                      		  <span class=Datos-User>Usuario: </span>
								Mankuco
                  		  </div> 
						
                    
                  		  <div class= "wrap-input100">
							<span class=Datos-User>Nombre: </span>
							 Manuel De la Cueva 
                  		  </div>

                  		  <div class= "wrap-input100">
							<span class=Datos-User>Email: </span> 
							manudelacuev@gmail.com
                   		 </div>

							<div class= "wrap-input100">
                     		   <span class=Datos-User>Valoraciones </span>
								<div>
								<span class="focus-input100"></span>
									<i class="fa fa-star" aria-hidden="true" style="color: gold;"></i>
									<i class="fa fa-star" aria-hidden="true" style="color: gold;"></i>
									<i class="fa fa-star" aria-hidden="true" style="color: gold;" ></i>
									<i class="fa fa-star-half" aria-hidden="true" style="color: gold;" ></i>
								</span>
								</div>

							</div>

							<div class= "wrap-input100">

								<span class=Datos-User>Nivel </span>
								<div>
									<span class="nivel"> <br> Padel: </span> 
									Profesional
									<br>
								</div>

								<div>
									<span class="nivel"> <br> Futbol: </span> 
									Principiante
									<br>
								</div>

								<div>
									<span class="nivel"> <br> Baloncesto: </span> 
									Principiante
									<br>
								</div>

							</div>
					</div>		
                    
    
                    <div class="container-menuPerfil-form-btn">

						<div>
						<button class="login100-form-btn">
							Mis partidos
						</button>
						</div>
						
						<div>
						<button class="login100-form-btn" onclick="location.href='editarPerfil.jsp'">						
								Editar Perfil
						</button>
						
						</div>

 
					</div>
					

					<div class="text-center p-t-30">
						<a class="txt2" onclick="location.href='mainMenuLogged.jsp'">
							Volver al menú principal
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