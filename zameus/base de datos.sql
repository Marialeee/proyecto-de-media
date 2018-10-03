CREATE DATABASE animal;

CREATE TABLE `animal`.`usuarios` (
  `idusuarios` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `nacimiento` VARCHAR(10) NULL,
  `cedula` VARCHAR(15) NULL,
  `telefono` VARCHAR(10) NULL,
  `edad` VARCHAR(2) NULL,
  PRIMARY KEY (`idusuarios`));