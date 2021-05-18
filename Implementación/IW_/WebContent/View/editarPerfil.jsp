<!DOCTYPE html>
<html lang="en">
<head>
	<title>EditarPerfil</title>
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
		<div class="container-registro">
			<div class="wrap-registro">
               
				<form class="registro-form validate-form">
					<span class="login100-form-title">
						Editar Perfil
					</span>

					<div class="editarPerfil-pic js-tilt" data-tilt>
                        <img  src="images/icons/mankuco.PNG" alt="IMG">
						<input class="fotoP" type="file" accept="image/png, image/jpeg" name=mankuco>
                    </div>
					
					<div><br></div>

                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir un nombre de usuario válido">
						<input class="input100" type="text" name="usuario" placeholder="Mankuco">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Debes introducir un nombre válido">
						<input class="input100" type="text" name="nombre" placeholder="Manuel">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir unos apellidos válidos">
						<input class="input100" type="text" name="apellidos" placeholder="De la Cueva Coca">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-user" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Debes introducir una fecha válida">
						<input class="input100" type="date" name="fechanacimiento" placeholder="04/11/2000">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-calendar" aria-hidden="true"></i>
						</span>
					</div>

                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir un número válido">
						<input class="input100" type="tel" name="telefono" placeholder="666777888">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-phone" aria-hidden="true"></i>
						</span>
					</div>

                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir un email válido: ejemplo@gmail.com">
						<input class="input100" type="email" name="email" placeholder="manudelacuev@gmail.com">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Es necesario una contraseña valida">
						<input class="input100" type="password" name="pass" placeholder="**********">
						<span class="focus-input100"></span>
						<span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
					</div>
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Guardar cambios
						</button>
					</div>
                    
                    <div class="text-center p-t-30 ">
                        <a onclick="location.href='../mainMenu.jsp'">
                            Volver al inicio
                            <i class="fa fa-long-arrow-left m-l-5" aria-hidden="true"></i>
                        </a>
					</div>	

				</form>
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