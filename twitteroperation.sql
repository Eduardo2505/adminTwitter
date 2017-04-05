-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 05-04-2017 a las 17:42:10
-- Versión del servidor: 5.7.9-log
-- Versión de PHP: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `twitteroperation`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuenta`
--

DROP TABLE IF EXISTS `cuenta`;
CREATE TABLE IF NOT EXISTS `cuenta` (
  `idcuenta` int(11) NOT NULL AUTO_INCREMENT,
  `id` bigint(20) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `AccessToken` varchar(450) DEFAULT NULL,
  `AccessTokenSecret` varchar(450) DEFAULT NULL,
  `ConsumerKey` varchar(450) DEFAULT NULL,
  `ConsumerSecret` varchar(450) DEFAULT NULL,
  `registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idcuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cuenta`
--

INSERT INTO `cuenta` (`idcuenta`, `id`, `usuario`, `AccessToken`, `AccessTokenSecret`, `ConsumerKey`, `ConsumerSecret`, `registro`) VALUES
(1, 757675111411359744, 'las_unitas', '757675111411359744-i5ohbHEwSOwgJtDYIB4LwG7sV8vFGo0', 'LZT9WBRp9Tync3fp5pww4t6neb8the92Py2QAs8yUDw0D', 'gBY9q1YimpELH3Kr04T9nQaNS', 'E8WnDMWnjn2WMGqHcg2w2POrhGllMxucgTO0D26Q9MgeYXzUiO', '2017-04-05 17:31:23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `followers`
--

DROP TABLE IF EXISTS `followers`;
CREATE TABLE IF NOT EXISTS `followers` (
  `idFollowers` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` bigint(20) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `idcuenta` int(11) NOT NULL,
  `registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFollowers`),
  KEY `fk_Followers_cuenta_idx` (`idcuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `friends`
--

DROP TABLE IF EXISTS `friends`;
CREATE TABLE IF NOT EXISTS `friends` (
  `idFriends` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` bigint(20) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `idcuenta` int(11) NOT NULL,
  `registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idFriends`),
  KEY `fk_Friends_cuenta1_idx` (`idcuenta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrobusqueda`
--

DROP TABLE IF EXISTS `registrobusqueda`;
CREATE TABLE IF NOT EXISTS `registrobusqueda` (
  `idRegistrobusqueda` bigint(20) NOT NULL AUTO_INCREMENT,
  `palabra` varchar(450) DEFAULT NULL,
  `idcuenta` int(11) NOT NULL,
  `registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idRegistrobusqueda`),
  KEY `fk_registro_cuenta1_idx` (`idcuenta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `registrobusqueda`
--

INSERT INTO `registrobusqueda` (`idRegistrobusqueda`, `palabra`, `idcuenta`, `registro`) VALUES
(1, 'desayuno', 1, '2017-04-05 17:31:57'),
(2, 'desayuno', 1, '2017-04-05 17:36:36');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `search`
--

DROP TABLE IF EXISTS `search`;
CREATE TABLE IF NOT EXISTS `search` (
  `idsearch` bigint(20) NOT NULL AUTO_INCREMENT,
  `id` bigint(20) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL,
  `idregistro` bigint(20) NOT NULL,
  `registro` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usuario` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idsearch`),
  KEY `fk_search_registro1_idx` (`idregistro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `followers`
--
ALTER TABLE `followers`
  ADD CONSTRAINT `fk_Followers_cuenta` FOREIGN KEY (`idcuenta`) REFERENCES `cuenta` (`idcuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `friends`
--
ALTER TABLE `friends`
  ADD CONSTRAINT `fk_Friends_cuenta1` FOREIGN KEY (`idcuenta`) REFERENCES `cuenta` (`idcuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `registrobusqueda`
--
ALTER TABLE `registrobusqueda`
  ADD CONSTRAINT `fk_registro_cuenta1` FOREIGN KEY (`idcuenta`) REFERENCES `cuenta` (`idcuenta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `search`
--
ALTER TABLE `search`
  ADD CONSTRAINT `fk_search_registro1` FOREIGN KEY (`idregistro`) REFERENCES `registrobusqueda` (`idRegistrobusqueda`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
