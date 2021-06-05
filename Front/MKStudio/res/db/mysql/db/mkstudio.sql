SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE IF NOT EXISTS `espacio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `descripcion` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

INSERT INTO `espacio` VALUES(1, 'Insonirizada', 'Sala insonorizada con cabina 2.4');
INSERT INTO `espacio` VALUES(4, 'Insonirizada 2.0', 'Cara rural');

CREATE TABLE IF NOT EXISTS `material` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `descripcion` text NOT NULL,
  `marca` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

INSERT INTO `material` VALUES(1, 'Pack 1', 'Microfono, Midi', 'Focusrite');
INSERT INTO `material` VALUES(7, 'Pack 2', 'Microfono, Teclado', 'Microfono, Teclado');

CREATE TABLE IF NOT EXISTS `reserva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `fecha` date NOT NULL,
  `descripcion` text NOT NULL,
  `usuario` int(11) NOT NULL,
  `espacio` text NOT NULL,
  `material` text NOT NULL,
  `aprobado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario` (`usuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

INSERT INTO `reserva` VALUES(4, 'Cancion Burrito Sabanero', '2021-06-18', 'Remix con Ozuna', 2, '4', '1', 1);
INSERT INTO `reserva` VALUES(7, 'sad', '2021-06-06', 'dsads', 2, '1', '7', 1);

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text NOT NULL,
  `password` text NOT NULL,
  `email` text NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `telefono` int(9) NOT NULL,
  `rol` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

INSERT INTO `usuario` VALUES(1, 'admin', 'admin', 'admin', '2021-06-01', 666777888, 'admin');
INSERT INTO `usuario` VALUES(2, 'user', 'user', 'user', '2021-06-01', 666777888, 'user');
INSERT INTO `usuario` VALUES(3, 'lolo', 'lolo', 'lolo', '2021-06-03', 123, 'user');
INSERT INTO `usuario` VALUES(4, 'Nico', 'nico', 'nico', '2021-06-03', 123123123, 'user');


ALTER TABLE `reserva`
  ADD CONSTRAINT `reserva_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
