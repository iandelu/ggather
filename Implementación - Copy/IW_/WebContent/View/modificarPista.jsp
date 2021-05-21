<!DOCTYPE html>
<html lang="es">
<jsp:useBean id="jugadorBean" class = "com.mycompany.iw.javabean.JugadorBean" scope="session"/>
<head>
	<title>Modificar Pista</title>
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
               
				<form class="registro-form validate-form" method="post" action="/IW_/EditarPerfilController">
					<span class="login100-form-title">
						Modificar pista 5
					</span>

					<div class="editarPerfil-pic js-tilt" data-tilt>
                        <img  src="https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones16.jpg" alt="IMG">
						
                    </div>
					
					<div><br></div>
                    <span class=Datos-User>Deporte </span>
                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir una hora valida">
                        <input list="DeportesDisponibles" class="input100" type="text" name="Hora Inicio" placeholder="Cambiar Deporte">
                        <span class="focus-input100"></span>
                        <span class="symbol-input100">
                            <i class="fa fa-futbol-o" aria-hidden="true"></i>
                        </span>
                    </div>


                    <datalist id="DeportesDisponibles">

                        <option value="Futbol 11">
                      
                        <option value="Baloncesto">
                      
                        <option value="Padel">
                      
                      
                      </datalist>

                    <span class=Datos-User>Hora Apertura </span>
                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir unos apellidos válidos">
                         
						<input class="input100" type="time" name="apellidos" placeholder="De la Cueva Coca">
					</div>

                    <span class=Datos-User>Hora Cierre </span>
                    <div class="wrap-input100 validate-input" data-validate = "Debes introducir unos apellidos válidos">
                         
						<input class="input100" type="time" name="apellidos" placeholder="De la Cueva Coca">
					</div>

                


					
					
					<div class="container-login100-form-btn">
						<button class="login100-form-btn">
							Guardar cambios
						</button>
					</div>
                    
                    <div class="text-center p-t-30 ">
                        <a onclick="location.href='menuPerfil.jsp'">
                            Volver al Dashboard
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