<!DOCTYPE html>
<html lang="es">
<head>
	<title>Login</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<body style="overflow-x:hidden; overflow-y:hidden"></body>
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
<body>
	<div class="limiter">
		<div class="container-crearPartido">

			<video class=video  loop autoplay muted>
				<source src="videos/basket_1.mp4" type="video/mp4">
			</video>

			<div class="wrap-crearPartido">
				
				

				<form class="login100-form validate-form" action="/IW_/CrearPartido" method = "post">
					<span class="crearPartido-form-title">
						¡Crea un Partido!
					</span>


                    <div class="wrap-input100" > 
                             <select name = "localidad" class="input100" >
								
                                 <option  disabled selected> Localidad </option>
                                      
                                         <option value="Cordoba">Córdoba</option> 
                                          <option value="Malaga">Málaga</option> 
                                         <option value="Sevilla">Sevilla</option>        
                            </select>
							<span class="focus-input100"></span>
							<span class="symbol-input100">
								<i class="fa fa-map" aria-hidden="true"></i>		
                    </div>        
				 

                    <div class="wrap-input100" >
                                <select name = "deporte" class="input100">
                                 <option id=deporte selected value="0"> Deporte </option>
                                     
                                        <option value="1">Pádel</option> 
                                        <option value="2">Fútbol 11</option> 
                                        <option value="3">Fútbol 7</option> 
                         
                                    
                                </select>
								<span class="focus-input100"></span>
								<span class="symbol-input100">
									<i class="fa fa-soccer-ball-o" aria-hidden="true"></i>
                    </div>             
							
					
						<div class="container-crearPartido-form-btn">
							<button class="crearPartido-form-btn">
								Crear
							</button>
						</div>

						<div class="text-center p-t-30">
							<a style="color:#ffffff" class="volver" onclick="location.href='mainMenuLogged.jsp'">
								Volver al menu
								<i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
							</a>
						</div>
					</form>
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