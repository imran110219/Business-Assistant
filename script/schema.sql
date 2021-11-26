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
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
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
  `full_name` VARCHAR(100) NOT NULL,
  `phone` VARCHAR(100) DEFAULT NULL,
  `email` VARCHAR(40) DEFAULT NULL,
  `address` TEXT DEFAULT NULL
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

/*Table structure for table `products` */

DROP TABLE IF EXISTS `products`;

CREATE TABLE `products` (
  `id` INT(11),
  `unit_id` INT(11) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `bn_name` VARCHAR(100) NOT NULL,
  `purchase_price` DOUBLE NOT NULL,
  `sale_price` DOUBLE NOT NULL,
  `percentage` DOUBLE NOT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `expenses` */

DROP TABLE IF EXISTS `expenses`;

CREATE TABLE `expenses` (
  `id` VARCHAR(15),
  `user_id` INT(11) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `purpose` VARCHAR(100) DEFAULT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `purchases` */

DROP TABLE IF EXISTS `purchases`;

CREATE TABLE `purchases` (
  `id` INT(11),
  `expense_id` INT(11) NOT NULL,
  `product_id` INT(11) NOT NULL,
  `unit_id` INT(11) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `unit_price` DOUBLE DEFAULT NULL,
  `total` DOUBLE NOT NULL,
  `expiry_datetime` DATETIME DEFAULT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `stocks` */

DROP TABLE IF EXISTS `stocks`;

CREATE TABLE `stocks` (
  `id` INT(11),
  `purchase_id` INT(11) NOT NULL,
  `unit_id` INT(11) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `incomes` */

DROP TABLE IF EXISTS `incomes`;

CREATE TABLE `incomes` (
  `id` INT(11),
  `user_id` INT(11) NOT NULL,
  `customer_id` INT(11) NOT NULL,
  `seller_id` INT(11) DEFAULT NULL,
  `total` DOUBLE NOT NULL,
  `delivery_cost` DOUBLE NOT NULL,
  `discount` DOUBLE NOT NULL,
  `payable` DOUBLE NOT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `seller_commissions` */

DROP TABLE IF EXISTS `seller_commissions`;

CREATE TABLE `seller_commissions` (
  `id` INT(11),
  `seller_id` INT(11) NOT NULL,
  `product_id` INT(11) NOT NULL,
  `amount` DOUBLE NOT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `sales` */

DROP TABLE IF EXISTS `sales`;

CREATE TABLE `sales` (
  `id` INT(11),
  `income_id` INT(11) NOT NULL,
  `stock_id` INT(11) NOT NULL,
  `unit_id` INT(11) NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `unit_price` DOUBLE NOT NULL,
  `discount` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*Table structure for table `working_hours` */

DROP TABLE IF EXISTS `working_hours`;

CREATE TABLE `working_hours` (
  `id` INT(11),
  `worker_id` INT(11) NOT NULL,
  `hour` DOUBLE NOT NULL,
  `purpose` VARCHAR(100) DEFAULT NULL,
  `datetime` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=INNODB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
