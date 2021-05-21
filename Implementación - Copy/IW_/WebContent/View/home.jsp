<!DOCTYPE html>
<html lang="es">
<head>
	<title>Home</title>
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
		<div class="container-home">
			<div class="wrap-home">

                  <span class="home-form-title">
                      Bienvenido a 
                    </span>

				    <div class="home-pic js-tilt" data-tilt>
					    <img src="images/icons/Logo.PNG" alt="IMG">
			    	</div>
	
					<div class="container-home-form-btn">
						<button class="home-form-btn" onclick="location.href='login.jsp'">
							Inicia Sesión
						</button>
					</div>

                    <div class="container-home-form-btn">
						<button class="home-form-btn" onclick="location.href='register.jsp'">
							Regístrate
						</button>
					</div>

                    <div class="container-home-form-btn">
						<button class="home-form-btn-invitado" onclick="location.href='homePropietario.jsp'">
							Soy propietario
						</button>
					</div>

					<div class="text-center p-t-30">
                        <a onclick="location.href='../../IW_/mainMenu.jsp'">
                            Volver al menú principal
                            <i class="fa fa-long-arrow-left m-l-5" aria-hidden="true"></i>
                        </a>
					</div>

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