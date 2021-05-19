<!DOCTYPE html>
<html lang="es">
<head>
	<title>Home Propietario</title>
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
		<div class="container-home-propietario">
			<div class="wrap-home">

                  <span class="home-form-title">
                      GGather Propietario
                    </span>

				    <div class="home-pic js-tilt" data-tilt>
					    <img style="margin-left:40px; margin-bottom:15px; " src="images/icons/logoAzul.png" alt="IMG">
			    	</div>
	
					<div class="container-home-form-btn">
						<button  class="login100-form-btn-propietario" onclick="location.href='loginPropietario.jsp'">
							Inicia Sesión
						</button>
					</div>

                    <div class="container-home-form-btn">
						<button class="login100-form-btn-propietario" onclick="location.href='registerPropietario.jsp'">
							Regístrate
						</button>
					</div>

					<div class="text-center p-t-30">
                        <a onclick="location.href='../../IW_/home.jsp'">
                            Volver al home
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