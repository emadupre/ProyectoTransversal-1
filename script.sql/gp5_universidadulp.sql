-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-10-2025 a las 00:34:40
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gp5_universidadulp`
--
CREATE DATABASE IF NOT EXISTS `gp5_universidadulp` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gp5_universidadulp`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrativo`
--

CREATE TABLE `administrativo` (
  `id_administrativo` int(11) NOT NULL,
  `dni` int(11) DEFAULT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telefono` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administrativo`
--

INSERT INTO `administrativo` (`id_administrativo`, `dni`, `nombre`, `apellido`, `email`, `password`, `telefono`) VALUES
(1, 27889567, 'Karina', 'Villalobos', 'karina_villalobos@ulp.com.ar', 'kari2188', 2665484655),
(2, 25548987, 'Jose', 'Peralta', 'peraltita2024@ulp.com.ar', 'jose2554', 2665545879),
(3, 21225414, 'Andrés', 'Gonzalez', 'gonzalo_andi@ulp.com.ar', 'Andi2122', 2657536653),
(4, 35658458, 'Marina', 'Saez', 'saezito2324@ulp.com.ar', 'Mari3565', 2664558877);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id_alumno` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id_alumno`, `dni`, `email`, `password`, `nombre`, `apellido`, `fecha_nacimiento`, `estado`, `fecha_creacion`) VALUES
(1, 40298592, 'ema.dupre@gmail.com', 'mantecosa123', 'Jesus Emanuel', 'García', '1998-06-28', 1, '2025-09-30 06:20:25'),
(2, 45750462, 'achucarrogonza8@gmail.com', 'holaquehace44', 'Gonzalo', 'Achucarro', '2004-09-04', 1, '2025-09-30 06:20:25'),
(3, 41721827, 'jose.bossa.3@gmail.com', 'lagalletaquepela123', 'Josa', 'Bossa', '1999-01-19', 1, '2025-09-30 06:20:25'),
(4, 41596734, 'enzofet1998@gmail.com', 'alohaloquitas', 'Enzo', 'Fet', '1998-10-23', 1, '2025-09-30 06:20:25'),
(5, 43426456, 'naiaraayelen129@gmail.com', 'lupitapita', 'Naiara', 'Bongiovanni', '2001-06-07', 1, '2025-09-30 06:20:25'),
(6, 23498345, 'clau_bonisoni@gmail.com', 'tengo20', 'Claudia', 'Bonisoni', '2000-08-10', 1, '2025-10-01 22:59:43');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificaciones`
--

CREATE TABLE `calificaciones` (
  `id_calificacion` int(11) NOT NULL,
  `id_inscripcion` int(11) NOT NULL,
  `id_administrativo` int(11) NOT NULL,
  `tipo_evaluacion` varchar(50) NOT NULL,
  `calificacion` decimal(5,2) NOT NULL,
  `fecha_actualizacion` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `calificaciones`
--

INSERT INTO `calificaciones` (`id_calificacion`, `id_inscripcion`, `id_administrativo`, `tipo_evaluacion`, `calificacion`, `fecha_actualizacion`) VALUES
(1, 1, 3, 'Lección oral', 9.00, '2025-10-12 23:29:29'),
(2, 3, 1, 'Final', 8.00, '2025-10-12 23:30:49'),
(3, 6, 1, 'Parcial', 8.52, '2025-09-11 00:19:21'),
(4, 10, 1, 'Parcial', 7.53, '2025-09-12 00:45:21'),
(5, 2, 1, 'Parcial', 8.52, '2025-07-11 00:28:34'),
(6, 13, 1, 'Parcial', 9.00, '2025-10-13 00:29:52');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `id_inscripcion` int(11) NOT NULL,
  `id_alumno` int(11) NOT NULL,
  `id_materia` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `fechainscripcion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`id_inscripcion`, `id_alumno`, `id_materia`, `estado`, `fechainscripcion`) VALUES
(1, 4, 3, 1, '2025-10-12 22:41:14'),
(2, 4, 1, 1, '2025-10-12 22:41:23'),
(3, 4, 2, 1, '2025-10-12 22:41:36'),
(4, 4, 4, 0, '2025-10-12 22:41:45'),
(6, 1, 1, 1, '2025-07-01 15:20:15'),
(7, 1, 2, 1, '2025-07-01 15:25:35'),
(8, 1, 3, 1, '2025-07-01 15:37:00'),
(9, 2, 1, 1, '2025-07-01 18:15:15'),
(10, 2, 2, 1, '2025-07-01 19:20:00'),
(11, 2, 3, 1, '2025-07-01 19:45:10'),
(12, 3, 1, 1, '2025-07-01 23:16:01'),
(13, 3, 2, 1, '2025-07-06 00:17:08'),
(14, 3, 3, 1, '2025-10-05 00:17:32'),
(15, 5, 1, 1, '2025-07-01 12:16:01'),
(16, 5, 2, 1, '2025-07-01 12:36:25'),
(17, 5, 3, 1, '2025-07-01 12:48:58'),
(18, 6, 1, 1, '2025-07-01 14:54:01'),
(19, 6, 2, 1, '2025-07-01 15:00:00'),
(20, 6, 3, 1, '2025-07-01 15:04:01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `materia`
--

CREATE TABLE `materia` (
  `id_materia` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `codigo_materia` varchar(20) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `materia`
--

INSERT INTO `materia` (`id_materia`, `nombre`, `descripcion`, `codigo_materia`, `estado`) VALUES
(1, 'Laboratorio de programación I', 'Java Swing, SQL', '5236', 1),
(2, 'Programación web I', 'HTML, CSS, JS.\r\nDOM Y BOM.', '7894', 1),
(3, 'Administración de base de datos', 'Algebra relacional y SQL.', '4895', 1),
(4, 'Estructura de Datos y Algoritmos', 'Concepto de Tipo Abstracto de Datos (TDA). Algoritmos de\r\nordenamiento y búsqueda TDA lineales', '9415', 0),
(5, 'Ingeniería de Software', 'Introducción: Ingeniería del software. Etapas del ciclo de vida del\r\ndesarrollo. Lenguaje Unificado del modelado (UML)', 'A494', 1),
(6, 'Laboratorio de Programación II', ' Introducción al Desarrollo Web Moderno. Arquitecturas de\r\naplicaciones web. Conceptos básicos: Frontend vs. Backend. Modelo-Vista-Controlador\r\n(MVC)', 'B7894', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  ADD PRIMARY KEY (`id_administrativo`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id_alumno`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD PRIMARY KEY (`id_calificacion`),
  ADD KEY `id_inscripcion` (`id_inscripcion`),
  ADD KEY `id_administrativo` (`id_administrativo`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`id_inscripcion`),
  ADD KEY `idMateria` (`id_materia`) USING BTREE,
  ADD KEY `idAlumno` (`id_alumno`) USING BTREE;

--
-- Indices de la tabla `materia`
--
ALTER TABLE `materia`
  ADD PRIMARY KEY (`id_materia`),
  ADD UNIQUE KEY `codigo_materia` (`codigo_materia`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrativo`
--
ALTER TABLE `administrativo`
  MODIFY `id_administrativo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id_alumno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  MODIFY `id_calificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `id_inscripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `materia`
--
ALTER TABLE `materia`
  MODIFY `id_materia` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD CONSTRAINT `id_administrativo` FOREIGN KEY (`id_administrativo`) REFERENCES `administrativo` (`id_administrativo`),
  ADD CONSTRAINT `id_inscripcion` FOREIGN KEY (`id_inscripcion`) REFERENCES `inscripcion` (`id_inscripcion`) ON DELETE CASCADE;

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`id_alumno`) REFERENCES `alumno` (`id_alumno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`id_materia`) REFERENCES `materia` (`id_materia`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
