/*
SQLyog Ultimate v12.5.1 (64 bit)
MySQL - 5.7.22-log : Database - medical_inventory
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`businessassistant` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `businessassistant`;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` INT(11),
  `firstname` VARCHAR(100) NOT NULL,
  `lastname` VARCHAR(100) NOT NULL,
  `username` VARCHAR(40) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `password` VARCHAR(500) NOT NULL,
  `phone` VARCHAR(100) NOT NULL,
  `address` TEXT NOT NULL,
  `active` BIT(1) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `roles` */

DROP TABLE IF EXISTS `roles`;

CREATE TABLE `roles` (
  `id` INT(11),
  `name` VARCHAR(50) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `user_roles` */

DROP TABLE IF EXISTS `user_roles`;

CREATE TABLE `user_roles` (
  `id` INT(11),
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `customers` */

DROP TABLE IF EXISTS `customers`;

CREATE TABLE `customers` (
  `id` INT(11),
  `fullname` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(100) DEFAULT NULL,
  `email` VARCHAR(40) DEFAULT NULL,
  `address` TEXT DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` INT(11),
  `unit_id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `bn_name` VARCHAR(100) NOT NULL,
  `purchase_price` DOUBLE NOT NULL,
  `sale_price` DOUBLE NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `types` */

DROP TABLE IF EXISTS `types`;

CREATE TABLE `types` (
  `id` INT(11),
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(500) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `units` */

DROP TABLE IF EXISTS `units`;

CREATE TABLE `units` (
  `id` INT(11),
  `name` VARCHAR(100) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `product_types` */

DROP TABLE IF EXISTS `product_types`;

CREATE TABLE `product_types` (
  `id` INT(11),
  `product_id` INT(11) NOT NULL,
  `type_id` INT(11) NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
