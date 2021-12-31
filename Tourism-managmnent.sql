/*
SQLyog Community v9.30 
MySQL - 5.6.25-log : Database - tourism-management
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tourism-management` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tourism-management`;

/*Table structure for table `T_BOOKING` */

DROP TABLE IF EXISTS `T_BOOKING`;

CREATE TABLE `T_BOOKING` (
  `ID` bigint(20) NOT NULL,
  `BOOKING_ID` varchar(225) DEFAULT NULL,
  `USER_NAME` varchar(225) DEFAULT NULL,
  `PK_ID` bigint(20) DEFAULT NULL,
  `PK_NAME` varchar(225) DEFAULT NULL,
  `TO_DATE` date DEFAULT NULL,
  `FROM_DATE` date DEFAULT NULL,
  `B_DATE` date DEFAULT NULL,
  `STATUS` varchar(225) DEFAULT NULL,
  `CREATED_BY` varchar(225) DEFAULT NULL,
  `MODIFIED_BY` varchar(225) DEFAULT NULL,
  `CREATED_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `T_BOOKING` */

insert  into `T_BOOKING`(`ID`,`BOOKING_ID`,`USER_NAME`,`PK_ID`,`PK_NAME`,`TO_DATE`,`FROM_DATE`,`B_DATE`,`STATUS`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,'BKID5610048','Hariom Mukati',1,'PK1','2021-01-31','2021-02-02','2021-01-30','Processing','Hari@gmail.com','Hari@gmail.com','2021-01-30 23:19:41','2021-01-30 23:19:41');

/*Table structure for table `T_ENQUIRIES` */

DROP TABLE IF EXISTS `T_ENQUIRIES`;

CREATE TABLE `T_ENQUIRIES` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(225) DEFAULT NULL,
  `EMAIL` varchar(225) DEFAULT NULL,
  `MOBILE_NO` varchar(225) DEFAULT NULL,
  `SUBJECT` varchar(225) DEFAULT NULL,
  `DESCRIPTION` varchar(225) DEFAULT NULL,
  `CREATED_BY` varchar(225) DEFAULT NULL,
  `MODIFIED_BY` varchar(225) DEFAULT NULL,
  `CREATED_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `T_ENQUIRIES` */

insert  into `T_ENQUIRIES`(`ID`,`NAME`,`EMAIL`,`MOBILE_NO`,`SUBJECT`,`DESCRIPTION`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,'Hari','Hari@gmail.com','9685456589','bnkibibi','bubvsidfbvisb','root','root','2021-01-20 12:24:09','2021-01-20 12:24:09');

/*Table structure for table `T_ISSUES` */

DROP TABLE IF EXISTS `T_ISSUES`;

CREATE TABLE `T_ISSUES` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(225) DEFAULT NULL,
  `MOBILE_NO` varchar(225) DEFAULT NULL,
  `EMAIL_ID` varchar(225) DEFAULT NULL,
  `ISSUES` varchar(225) DEFAULT NULL,
  `DESCRIPTION` varchar(225) DEFAULT NULL,
  `CREATED_BY` varchar(225) DEFAULT NULL,
  `MODIFIED_BY` varchar(225) DEFAULT NULL,
  `CREATED_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `T_ISSUES` */

insert  into `T_ISSUES`(`ID`,`NAME`,`MOBILE_NO`,`EMAIL_ID`,`ISSUES`,`DESCRIPTION`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,'Hariom','Hariom@gmail.com','9685456585',NULL,'dovnswv','Hari@gmail.com','Hari@gmail.com','2021-01-22 11:15:31','2021-01-22 11:15:31');

/*Table structure for table `t_package` */

DROP TABLE IF EXISTS `t_package`;

CREATE TABLE `t_package` (
  `ID` bigint(20) NOT NULL,
  `NAME` varchar(225) DEFAULT NULL,
  `TYPE` varchar(225) DEFAULT NULL,
  `LOCATION` varchar(225) DEFAULT NULL,
  `FEATURE` varchar(225) DEFAULT NULL,
  `PRICE` varchar(225) DEFAULT NULL,
  `DETAIL` varchar(225) DEFAULT NULL,
  `IMAGE` varchar(225) DEFAULT NULL,
  `CREATED_BY` varchar(225) DEFAULT NULL,
  `MODIFIED_BY` varchar(225) DEFAULT NULL,
  `CREATED_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_package` */

insert  into `t_package`(`ID`,`NAME`,`TYPE`,`LOCATION`,`FEATURE`,`PRICE`,`DETAIL`,`IMAGE`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,'PK1','dkbvkids','lvdfobvfoe','vbdefiobvofr','25320','sfhvihdfsovhboivhfoihvo','PK1624111.jpg','Admin@gmail.com','Admin@gmail.com','2021-01-08 15:08:54','2021-01-22 11:54:48'),(2,'Pk2','fvefv','vdsfvds','fsdvfds','60320','csvdsf','Pk2136949.jpg','Admin@gmail.com','Admin@gmail.com','2021-01-22 11:46:48','2021-01-22 11:55:06');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `ID` bigint(20) NOT NULL,
  `FIRST_NAME` varchar(225) DEFAULT NULL,
  `LAST_NAME` varchar(225) DEFAULT NULL,
  `LOGIN` varchar(225) DEFAULT NULL,
  `PASSWORD` varchar(225) DEFAULT NULL,
  `MOBILE_NO` varchar(225) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `GENDER` varchar(225) DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  `CREATED_BY` varchar(225) DEFAULT NULL,
  `MODIFIED_BY` varchar(225) DEFAULT NULL,
  `CREATED_DATETIME` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MODIFIED_DATETIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`ID`,`FIRST_NAME`,`LAST_NAME`,`LOGIN`,`PASSWORD`,`MOBILE_NO`,`DOB`,`GENDER`,`ROLE_ID`,`CREATED_BY`,`MODIFIED_BY`,`CREATED_DATETIME`,`MODIFIED_DATETIME`) values (1,'Admin','Admin','Admin@gmail.com','Admin@123','9685456658','2021-01-05',NULL,1,'root','root','2021-01-05 14:29:42','2021-01-05 14:09:59'),(2,'Hariom','Mukati','Hari@gmail.com','Hari@123','9685456585','2021-01-06',NULL,2,'root','root','2021-01-06 12:07:34','2021-01-06 12:07:34');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
