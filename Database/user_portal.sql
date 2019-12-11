/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.0.45-community-nt : Database - user_portal
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`user_portal` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `user_portal`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(50) NOT NULL auto_increment,
  `firstName` varchar(50) default NULL,
  `lastName` varchar(50) default NULL,
  `address` varchar(50) default NULL,
  `phone` varchar(200) default NULL,
  `email` varchar(50) default NULL,
  `birthDate` varchar(50) default NULL,
  `pass` varchar(50) default NULL,
  `age` int(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;

/*Data for the table `user` */

insert  into `user`(`id`,`firstName`,`lastName`,`address`,`phone`,`email`,`birthDate`,`pass`,`age`) values (21,'Md Omar','Faruq','Feni','01626768530','faruq@gmail.com','1997-06-28','ZmFydXE=',22),(22,'Foyzul','Haque','Feni','34535353543','rana@gmail.com','1998-11-03','MTEyMjMz',21),(23,'Saberul','Haque','Feni','1234567890','arif@gmail.com','1998-06-02','YXJpZg==',21);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
