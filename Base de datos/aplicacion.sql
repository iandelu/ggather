-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-05-2021 a las 11:58:28
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aplicacion`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

CREATE TABLE `amigos` (
  `idAmigos` int(11) NOT NULL,
  `amigo1` int(11) NOT NULL,
  `amigo2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `club`
--

CREATE TABLE `club` (
  `idClub` int(11) NOT NULL,
  `alta` tinyint(1) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `email` varchar(45) NOT NULL,
  `localizacion` varchar(45) NOT NULL,
  `nombreClub` varchar(45) NOT NULL,
  `nombrePropietario` varchar(45) NOT NULL,
  `telefono` int(11) NOT NULL,
  `googleLink` varchar(350) DEFAULT NULL,
  `fotoClub` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `club`
--

INSERT INTO `club` (`idClub`, `alta`, `contraseña`, `email`, `localizacion`, `nombreClub`, `nombrePropietario`, `telefono`, `googleLink`, `fotoClub`) VALUES
(12, 1, '1234', 'email', 'Cordoba', 'Club', 'Propietario', 123, 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3149.1416034215736!2d-4.804544449583729!3d37.88037101375157!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd6d20a9d7928149%3A0xfc1bd9bfb662f945!2sOpen%20Arena!5e0!3m2!1ses!2ses!4v1621208247761!5m2!1ses!2ses', 'https://openarena.es/wp-content/uploads/2019/05/open_arena_instalaciones8.jpg'),
(13, 1, '1234', 'email@uco.es', 'Localizacion', 'Hola', 'Propietario', 123, '', 'https://padeladdict.com/wp-content/uploads/2012/12/historia-del-padel-portada.jpg'),
(14, 1, 'pistas', 'pistasfigueroa@gmail.com', 'Cordoba', 'Figueroa CF', 'Cristian RONALDO', 85834934, 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d196.79551041489304!2d-4.802425822869693!3d37.89003937047433!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd6cdf51e5e2becf%3A0x2f434015201dd324!2sCLUB%20FIGUEROA!5e0!3m2!1sen!2ses!4v1621452036206!5m2!1sen!2ses', 'https://padelworldpress.es/wp-content/uploads/2020/01/Captura-de-pantalla-2020-01-24-a-las-11.40.02.png'),
(453, 1, '1234', 'ucodeporte@uco.es', 'Cordoba', 'Ucodeporte', 'José Carlos Gómez Villamandos', 957218000, 'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50379.49914079753!2d-4.7966531141025195!3d37.89026081292712!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0xd6d20b07d170833%3A0x166cff37f228a37c!2sUcodeporte!5e0!3m2!1ses!2ses!4v1621458193901!5m2!1ses!2ses', 'https://www.puentegenil.es/sites/default/files/alcaldemiguel_0.jpg'),
(454, 1, '1234', 'luisaneri@uco.es', 'Cordoba', 'valdeolleros', 'Luis Aneri', 601162261, NULL, NULL),
(455, 1, '1234', 'deporteuco@uco.es', 'Cordoba', 'ucodeporte', 'Luis Aneri ', 601160060, NULL, NULL),
(456, 1, '1234', 'pruebauco@uco.es', 'Cordoba', 'PadelUcoViernes', 'Luis Aneri', 601160060, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `deportes`
--

CREATE TABLE `deportes` (
  `idDeporte` int(11) NOT NULL,
  `nombreDeporte` varchar(45) NOT NULL,
  `numeroJugadores` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `deportes`
--

INSERT INTO `deportes` (`idDeporte`, `nombreDeporte`, `numeroJugadores`) VALUES
(1, 'Pádel', 4),
(2, 'Fútbol11', 22),
(3, 'Fútbol7', 14);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `idJugador` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `telefono` double NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `valoracionMedia` decimal(10,0) NOT NULL,
  `fotoPerfil` varchar(255) NOT NULL DEFAULT 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`idJugador`, `usuario`, `nombre`, `apellidos`, `email`, `contraseña`, `telefono`, `fechaNacimiento`, `valoracionMedia`, `fotoPerfil`) VALUES
(1, 'cristianito', 'cristian', 'Gonzalez', 'cristian@uco.es', 'asssss', 606066600, '2013-05-15', '10', 'https://as.com/masdeporte/imagenes/2017/12/19/polideportivo/1513718387_098331_1513718461_noticia_normal.jpg'),
(3, 'Luis', 'ass', 'aag', 'luisaneri@uco.es', '1234', 12345, '2021-05-08', '601160060', 'https://avatars.githubusercontent.com/u/48674592?v=4'),
(43, 'yunesss00', 'Youness', 'Bettahi Berdai', 'i82bebey@gmail.com', '1234', 658843282, '2000-12-23', '0', 'https://laverdadnoticias.com/__export/1610483922437/sites/laverdad/img/2021/01/12/jujutsu_kaisen_anime_episodio_16.jpg_2065693783.jpg'),
(432, 'jesusBRuiz', 'Jesus', 'Bueno', 'jesus@uco.es', '1234', 657342354, '1999-05-14', '0', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(433, 'i82andel', 'luis', 'Aneri', 'i82andel@uco.es', '1234', 0, '2010-01-06', '601160060', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(435, 'jesuusbueno', 'Jesus', 'Bueno', 'jesuusbueno@gmail.com', '2345', 123, '2021-04-28', '12346', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(436, 'Carmenmgc00', 'Carmen María', 'Gomez Carmona', 'maliunkin2@gmail.com', 'mailiunkin1', 0, '2000-07-20', '634331632', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(437, 'Antonio', 'Antonio ', 'Raso', 'i02rafea@uco.es', '1234', 5, '1999-12-11', '67658223', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(438, 'porfa', 'porfa', 'porfa', 'hola@hola.com', '1234', 612432695, '2021-05-14', '612432695', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(439, 'da', 'ad', 'ad', 'a@uco.es', 'aaa', 5, '2021-05-13', '111111111', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(441, 'manolin', 'Manolito', 'Gafotas', 'manudelacuev@gmail.com', '12345', 5, '2021-05-05', '610876543', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(442, 'asd', 'asd', 'asd', 'asdasd@uco.es', '1234', 123456789, '2021-05-01', '665656656', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png'),
(443, 'DavidGModificado', 'David', 'GuijoMod', 'dguijo@uco.es', '1234', 601160060, '2021-03-17', '601160060', 'https://e7.pngegg.com/pngimages/323/705/png-clipart-user-profile-get-em-cardiovascular-disease-zingah-avatar-miscellaneous-white.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `niveles`
--

CREATE TABLE `niveles` (
  `idNivel` int(11) NOT NULL,
  `idDeporte` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  `nivel` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partidos`
--

CREATE TABLE `partidos` (
  `idPartido` int(11) NOT NULL,
  `idCreador` int(11) NOT NULL,
  `idPista` int(11) NOT NULL,
  `idReserva` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `nivelPartido` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partidos`
--

INSERT INTO `partidos` (`idPartido`, `idCreador`, `idPista`, `idReserva`, `estado`, `nivelPartido`) VALUES
(3, 3, 4, 2, 'PENDIENTE', '1600'),
(7, 3, 4, 2, 'PENDIENTE', '1600'),
(8, 3, 4, 2, 'PENDIENTE', '1600'),
(213, 432, 11, 7, 'COMPLETADO', '6'),
(2344, 43, 8, 5, 'COMPLETADO', '8'),
(7567, 1, 312, 5, 'PENDIENTE', '4'),
(4234324, 1, 3123, 2, 'PENDIENTE', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `partido_jugadores`
--

CREATE TABLE `partido_jugadores` (
  `idPartidoJugadores` int(11) NOT NULL,
  `idPartido` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  `equipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `partido_jugadores`
--

INSERT INTO `partido_jugadores` (`idPartidoJugadores`, `idPartido`, `idJugador`, `equipo`) VALUES
(1, 3, 3, 1),
(2, 7, 3, 1),
(3, 8, 3, 1),
(4, 2344, 3, 1),
(5, 3, 3, 1),
(6, 2344, 3, 1),
(7, 2344, 437, 1),
(8, 2344, 3, 1),
(9, 8, 439, 1),
(10, 8, 439, 1),
(11, 3, 3, 1),
(12, 7, 441, 1),
(13, 2344, 442, 1),
(14, 3, 443, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pistas`
--

CREATE TABLE `pistas` (
  `idPista` int(11) NOT NULL,
  `idClub` int(11) NOT NULL,
  `idDeporte` int(11) NOT NULL,
  `horarioInicio` time NOT NULL,
  `horarioFin` time NOT NULL,
  `puntuacionMedia` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pistas`
--

INSERT INTO `pistas` (`idPista`, `idClub`, `idDeporte`, `horarioInicio`, `horarioFin`, `puntuacionMedia`) VALUES
(4, 12, 1, '09:00:00', '21:00:00', '5'),
(5, 12, 2, '16:00:00', '21:00:00', '5'),
(6, 12, 1, '16:00:00', '18:00:00', '5'),
(7, 12, 1, '16:00:00', '18:00:00', '5'),
(8, 12, 1, '16:00:00', '18:00:00', '5'),
(9, 12, 1, '16:00:00', '18:00:00', '5'),
(10, 12, 1, '16:00:00', '18:00:00', '5'),
(11, 14, 1, '16:00:00', '18:00:00', '5'),
(12, 14, 1, '09:00:00', '21:00:00', '5'),
(312, 453, 2, '10:00:00', '22:00:00', '0'),
(3123, 453, 2, '10:00:00', '22:00:00', '0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `precios`
--

CREATE TABLE `precios` (
  `idPrecio` int(11) NOT NULL,
  `idClub` int(11) NOT NULL,
  `idDeporte` int(11) NOT NULL,
  `mañanaTarde` varchar(10) NOT NULL,
  `precioHora` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `precios`
--

INSERT INTO `precios` (`idPrecio`, `idClub`, `idDeporte`, `mañanaTarde`, `precioHora`) VALUES
(2, 12, 1, 'MAÑANA', '15'),
(3, 12, 1, 'MAÑANA', '15'),
(4, 12, 1, 'MAÑANA', '15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntuaciones`
--

CREATE TABLE `puntuaciones` (
  `idPuntuacion` int(11) NOT NULL,
  `idPista` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  `puntuacion` int(11) NOT NULL,
  `comentario` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `puntuaciones`
--

INSERT INTO `puntuaciones` (`idPuntuacion`, `idPista`, `idJugador`, `puntuacion`, `comentario`) VALUES
(2, 4, 1, 1, 'comentario');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservas`
--

CREATE TABLE `reservas` (
  `idReservas` int(11) NOT NULL,
  `idPistas` int(11) NOT NULL,
  `horaInicio` time NOT NULL,
  `horarioFin` time NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `reservas`
--

INSERT INTO `reservas` (`idReservas`, `idPistas`, `horaInicio`, `horarioFin`, `fecha`) VALUES
(2, 4, '11:00:00', '12:00:00', '2021-05-20'),
(3, 4, '13:00:00', '14:00:00', '2021-05-20'),
(4, 4, '16:00:00', '17:00:00', '2021-05-20'),
(5, 4, '12:00:00', '13:00:00', '2021-05-20'),
(6, 4, '17:00:00', '18:00:00', '2021-05-19'),
(7, 4, '14:00:00', '15:00:00', '2021-05-19'),
(32423, 3123, '11:00:00', '12:00:00', '2021-05-20'),
(3133123, 312, '12:00:00', '13:00:00', '2021-05-20'),
(3133124, 11, '17:00:00', '18:00:00', '2021-05-20'),
(3133125, 6, '16:00:00', '17:00:00', '2021-05-20'),
(3133126, 4, '18:00:00', '19:00:00', '2021-05-19'),
(3133127, 11, '16:00:00', '17:00:00', '2021-05-20'),
(3133128, 11, '16:00:00', '17:00:00', '2021-05-21'),
(3133129, 8, '17:00:00', '18:00:00', '2021-05-30'),
(3133130, 3123, '11:00:00', '12:00:00', '2021-05-26'),
(3133131, 7, '17:00:00', '18:00:00', '2021-05-22'),
(3133132, 7, '17:00:00', '18:00:00', '2021-05-29'),
(3133133, 7, '16:00:00', '17:00:00', '2021-05-22');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `resultados`
--

CREATE TABLE `resultados` (
  `idResultados` int(11) NOT NULL,
  `idJugadorPoniente` int(11) NOT NULL,
  `idPartido` int(11) NOT NULL,
  `resultados` varchar(45) NOT NULL,
  `mvp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `resultados`
--

INSERT INTO `resultados` (`idResultados`, `idJugadorPoniente`, `idPartido`, `resultados`, `mvp`) VALUES
(2, 1, 3, 'resultado', 1),
(3, 1, 3, 'resultado', 1),
(4, 1, 3, 'resultado', 1),
(5, 1, 3, 'resultado', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarjetas`
--

CREATE TABLE `tarjetas` (
  `idTarjeta` int(11) NOT NULL,
  `idJugador` int(11) NOT NULL,
  `idJugadorAmonestador` int(11) NOT NULL,
  `motivo` varchar(45) NOT NULL,
  `comentario` text NOT NULL,
  `tipoTarjeta` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tarjetas`
--

INSERT INTO `tarjetas` (`idTarjeta`, `idJugador`, `idJugadorAmonestador`, `motivo`, `comentario`, `tipoTarjeta`) VALUES
(2, 1, 1, 'motivo', 'comentario', 'tipo'),
(3, 1, 1, 'motivo', 'comentario', 'tipo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoraciones_jugadores`
--

CREATE TABLE `valoraciones_jugadores` (
  `idValoracionesJugadores` int(11) NOT NULL,
  `idJugadorValorado` int(11) NOT NULL,
  `usuarioValorador` int(11) NOT NULL,
  `comentario` text NOT NULL,
  `puntuacion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `valoraciones_jugadores`
--

INSERT INTO `valoraciones_jugadores` (`idValoracionesJugadores`, `idJugadorValorado`, `usuarioValorador`, `comentario`, `puntuacion`) VALUES
(2, 1, 3, 'comentario', 3),
(3, 1, 3, 'comentario', 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `amigos`
--
ALTER TABLE `amigos`
  ADD PRIMARY KEY (`idAmigos`),
  ADD KEY `amigos/jugadores2` (`amigo2`),
  ADD KEY `amigos/jugadores1` (`amigo1`);

--
-- Indices de la tabla `club`
--
ALTER TABLE `club`
  ADD PRIMARY KEY (`idClub`);

--
-- Indices de la tabla `deportes`
--
ALTER TABLE `deportes`
  ADD PRIMARY KEY (`idDeporte`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`idJugador`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `usuario` (`usuario`);

--
-- Indices de la tabla `niveles`
--
ALTER TABLE `niveles`
  ADD PRIMARY KEY (`idNivel`),
  ADD KEY `niveles/jugador` (`idJugador`),
  ADD KEY `niveles/deporte` (`idDeporte`);

--
-- Indices de la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD PRIMARY KEY (`idPartido`),
  ADD KEY `partidos/jugador` (`idCreador`),
  ADD KEY `partidos/pista` (`idPista`),
  ADD KEY `partidos/reservas` (`idReserva`);

--
-- Indices de la tabla `partido_jugadores`
--
ALTER TABLE `partido_jugadores`
  ADD PRIMARY KEY (`idPartidoJugadores`),
  ADD KEY `partidoJugadores/jugadores` (`idJugador`),
  ADD KEY `partidoJugadores/partido` (`idPartido`);

--
-- Indices de la tabla `pistas`
--
ALTER TABLE `pistas`
  ADD PRIMARY KEY (`idPista`),
  ADD KEY `pistas/club` (`idClub`),
  ADD KEY `pistas/deporte` (`idDeporte`);

--
-- Indices de la tabla `precios`
--
ALTER TABLE `precios`
  ADD PRIMARY KEY (`idPrecio`),
  ADD KEY `precio/deporte` (`idDeporte`),
  ADD KEY `precio/club` (`idClub`);

--
-- Indices de la tabla `puntuaciones`
--
ALTER TABLE `puntuaciones`
  ADD PRIMARY KEY (`idPuntuacion`),
  ADD KEY `puntuaciones/pistas` (`idPista`);

--
-- Indices de la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD PRIMARY KEY (`idReservas`),
  ADD KEY `reservas/pistas` (`idPistas`);

--
-- Indices de la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD PRIMARY KEY (`idResultados`),
  ADD KEY `resultados/jugador` (`idJugadorPoniente`),
  ADD KEY `resultados/partido` (`idPartido`),
  ADD KEY `resultadosmvp/jugador` (`mvp`);

--
-- Indices de la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD PRIMARY KEY (`idTarjeta`),
  ADD KEY `tarjetas/jugador` (`idJugador`),
  ADD KEY `tarjetas/jugador2` (`idJugadorAmonestador`);

--
-- Indices de la tabla `valoraciones_jugadores`
--
ALTER TABLE `valoraciones_jugadores`
  ADD PRIMARY KEY (`idValoracionesJugadores`),
  ADD KEY `valoraciones/jugadores` (`usuarioValorador`),
  ADD KEY `valoraciones/jugadores2` (`idJugadorValorado`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `amigos`
--
ALTER TABLE `amigos`
  MODIFY `idAmigos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `club`
--
ALTER TABLE `club`
  MODIFY `idClub` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=457;

--
-- AUTO_INCREMENT de la tabla `deportes`
--
ALTER TABLE `deportes`
  MODIFY `idDeporte` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `idJugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=444;

--
-- AUTO_INCREMENT de la tabla `niveles`
--
ALTER TABLE `niveles`
  MODIFY `idNivel` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `partidos`
--
ALTER TABLE `partidos`
  MODIFY `idPartido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4234325;

--
-- AUTO_INCREMENT de la tabla `partido_jugadores`
--
ALTER TABLE `partido_jugadores`
  MODIFY `idPartidoJugadores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `pistas`
--
ALTER TABLE `pistas`
  MODIFY `idPista` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3124;

--
-- AUTO_INCREMENT de la tabla `precios`
--
ALTER TABLE `precios`
  MODIFY `idPrecio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `puntuaciones`
--
ALTER TABLE `puntuaciones`
  MODIFY `idPuntuacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `reservas`
--
ALTER TABLE `reservas`
  MODIFY `idReservas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3133134;

--
-- AUTO_INCREMENT de la tabla `resultados`
--
ALTER TABLE `resultados`
  MODIFY `idResultados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  MODIFY `idTarjeta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `valoraciones_jugadores`
--
ALTER TABLE `valoraciones_jugadores`
  MODIFY `idValoracionesJugadores` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `amigos`
--
ALTER TABLE `amigos`
  ADD CONSTRAINT `amigos/jugadores1` FOREIGN KEY (`amigo1`) REFERENCES `jugadores` (`idJugador`),
  ADD CONSTRAINT `amigos/jugadores2` FOREIGN KEY (`amigo2`) REFERENCES `jugadores` (`idJugador`);

--
-- Filtros para la tabla `niveles`
--
ALTER TABLE `niveles`
  ADD CONSTRAINT `niveles/deporte` FOREIGN KEY (`idDeporte`) REFERENCES `deportes` (`idDeporte`),
  ADD CONSTRAINT `niveles/jugador` FOREIGN KEY (`idJugador`) REFERENCES `jugadores` (`idJugador`);

--
-- Filtros para la tabla `partidos`
--
ALTER TABLE `partidos`
  ADD CONSTRAINT `partidos/jugador` FOREIGN KEY (`idCreador`) REFERENCES `jugadores` (`idJugador`),
  ADD CONSTRAINT `partidos/pista` FOREIGN KEY (`idPista`) REFERENCES `pistas` (`idPista`),
  ADD CONSTRAINT `partidos/reservas` FOREIGN KEY (`idReserva`) REFERENCES `reservas` (`idReservas`);

--
-- Filtros para la tabla `partido_jugadores`
--
ALTER TABLE `partido_jugadores`
  ADD CONSTRAINT `partidoJugadores/jugadores` FOREIGN KEY (`idJugador`) REFERENCES `jugadores` (`idJugador`),
  ADD CONSTRAINT `partidoJugadores/partido` FOREIGN KEY (`idPartido`) REFERENCES `partidos` (`idPartido`);

--
-- Filtros para la tabla `pistas`
--
ALTER TABLE `pistas`
  ADD CONSTRAINT `pistas/club` FOREIGN KEY (`idClub`) REFERENCES `club` (`idClub`),
  ADD CONSTRAINT `pistas/deporte` FOREIGN KEY (`idDeporte`) REFERENCES `deportes` (`idDeporte`);

--
-- Filtros para la tabla `precios`
--
ALTER TABLE `precios`
  ADD CONSTRAINT `precio/club` FOREIGN KEY (`idClub`) REFERENCES `club` (`idClub`),
  ADD CONSTRAINT `precio/deporte` FOREIGN KEY (`idDeporte`) REFERENCES `deportes` (`idDeporte`);

--
-- Filtros para la tabla `puntuaciones`
--
ALTER TABLE `puntuaciones`
  ADD CONSTRAINT `puntuaciones/pistas` FOREIGN KEY (`idPista`) REFERENCES `pistas` (`idPista`);

--
-- Filtros para la tabla `reservas`
--
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas/pistas` FOREIGN KEY (`idPistas`) REFERENCES `pistas` (`idPista`);

--
-- Filtros para la tabla `resultados`
--
ALTER TABLE `resultados`
  ADD CONSTRAINT `resultados/jugador` FOREIGN KEY (`idJugadorPoniente`) REFERENCES `jugadores` (`idJugador`),
  ADD CONSTRAINT `resultados/partido` FOREIGN KEY (`idPartido`) REFERENCES `partidos` (`idPartido`),
  ADD CONSTRAINT `resultadosmvp/jugador` FOREIGN KEY (`mvp`) REFERENCES `jugadores` (`idJugador`);

--
-- Filtros para la tabla `tarjetas`
--
ALTER TABLE `tarjetas`
  ADD CONSTRAINT `tarjetas/jugador` FOREIGN KEY (`idJugador`) REFERENCES `jugadores` (`idJugador`),
  ADD CONSTRAINT `tarjetas/jugador2` FOREIGN KEY (`idJugadorAmonestador`) REFERENCES `jugadores` (`idJugador`);

--
-- Filtros para la tabla `valoraciones_jugadores`
--
ALTER TABLE `valoraciones_jugadores`
  ADD CONSTRAINT `valoraciones/jugadores` FOREIGN KEY (`usuarioValorador`) REFERENCES `jugadores` (`idJugador`),
  ADD CONSTRAINT `valoraciones/jugadores2` FOREIGN KEY (`idJugadorValorado`) REFERENCES `jugadores` (`idJugador`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
