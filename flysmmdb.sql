CREATE DATABASE  IF NOT EXISTS `flysmmdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `flysmmdb`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: flysmmdb
-- ------------------------------------------------------
-- Server version	5.7.17-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `idAddress` int(11) NOT NULL AUTO_INCREMENT,
  `Street` varchar(45) DEFAULT NULL,
  `Street_number` varchar(45) DEFAULT NULL,
  `CAP` varchar(45) DEFAULT NULL,
  `City` varchar(45) DEFAULT NULL,
  `Country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idAddress`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'turati','2','20025','legnano','italia'),(2,'via Roma','50','20090','Milano','Italy'),(8,'wsg','65','26425','swdkgbl','sdlgjns');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aircraft`
--

DROP TABLE IF EXISTS `aircraft`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aircraft` (
  `ID_aircraft` int(11) NOT NULL,
  `Model` varchar(45) DEFAULT NULL,
  `Seat_Number` int(11) DEFAULT NULL,
  `Weight_Bound` int(11) DEFAULT NULL,
  `Constructor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_aircraft`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aircraft`
--

LOCK TABLES `aircraft` WRITE;
/*!40000 ALTER TABLE `aircraft` DISABLE KEYS */;
INSERT INTO `aircraft` VALUES (1,'A380',270,45,'Airbus'),(2,'737',270,45,'Boeing');
/*!40000 ALTER TABLE `aircraft` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `airport`
--

DROP TABLE IF EXISTS `airport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `airport` (
  `ICAO` varchar(4) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  `Timezone` int(11) NOT NULL,
  PRIMARY KEY (`ICAO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport`
--

LOCK TABLES `airport` WRITE;
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` VALUES ('1','malpensa','milano','ita',1),('2','fiumicino','roma','ita',1);
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baggage`
--

DROP TABLE IF EXISTS `baggage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baggage` (
  `ID_Baggage` varchar(45) NOT NULL,
  `Weight` int(11) NOT NULL,
  `Price_baggage` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_Baggage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baggage`
--

LOCK TABLES `baggage` WRITE;
/*!40000 ALTER TABLE `baggage` DISABLE KEYS */;
INSERT INTO `baggage` VALUES ('Huge',10,10),('None',0,0),('Normal',5,5),('Sport',3,4);
/*!40000 ALTER TABLE `baggage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book` (
  `User_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IdBook` varchar(45) NOT NULL,
  `Payed` int(1) NOT NULL,
  `Expired` int(1) NOT NULL,
  `Booking_date` datetime NOT NULL,
  `Passenger_Fiscal_code` varchar(16) NOT NULL,
  `Flight_Flight_ID` varchar(5) NOT NULL,
  `Flight_Departure_Date` date NOT NULL,
  `Flight_Airplane_ID` int(11) NOT NULL,
  `Total_Price` float DEFAULT NULL,
  PRIMARY KEY (`User_ID`,`IdBook`,`Flight_Flight_ID`,`Flight_Departure_Date`,`Flight_Airplane_ID`),
  KEY `fk_User_has_Flight_User1_idx` (`User_ID`),
  KEY `fk_Book_Passenger1_idx` (`Passenger_Fiscal_code`),
  KEY `fk_Book_Flight1_idx` (`Flight_Flight_ID`,`Flight_Departure_Date`,`Flight_Airplane_ID`),
  CONSTRAINT `fk_Book_Flight1` FOREIGN KEY (`Flight_Flight_ID`, `Flight_Departure_Date`) REFERENCES `flight` (`Flight_ID`, `Departure_Date`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Book_Passenger1` FOREIGN KEY (`Passenger_Fiscal_code`) REFERENCES `passenger` (`Fiscal_code`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Flight_User1` FOREIGN KEY (`User_ID`) REFERENCES `customer` (`ID_Customer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` VALUES (123,'12mh51123lbs',0,0,'2017-02-22 00:00:00','lbsjdbl','mh51','2017-01-27',1,55),(123,'12mh51123sdg',0,0,'2017-02-22 00:00:00','sdgjlnsg','mh51','2017-01-27',1,55),(123,'12mh51123sdk',0,0,'2017-02-22 00:00:00','sdklgsl','mh51','2017-01-27',1,55),(123,'12mh51123sjd',0,0,'2017-02-22 00:00:00','sjdnbsjbvk','mh51','2017-01-27',1,60),(123,'21mh54123lbs',0,0,'2017-02-22 00:00:00','lbsjdbl','mh54','2017-02-27',2,405),(123,'21mh54123sdg',0,0,'2017-02-22 00:00:00','sdgjlnsg','mh54','2017-02-27',2,405),(123,'21mh54123sdk',0,0,'2017-02-22 00:00:00','sdklgsl','mh54','2017-02-27',2,405),(123,'21mh54123sjd',0,0,'2017-02-22 00:00:00','sjdnbsjbvk','mh54','2017-02-27',2,410);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `ID_Customer` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Surname` varchar(45) DEFAULT NULL,
  `Address_idAddress` int(11) NOT NULL,
  `Date_of_birth` date DEFAULT NULL,
  `Fidelity_Points` int(11) DEFAULT NULL,
  `Type_of_customers` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `Phone_NO` varchar(45) DEFAULT NULL,
  `Date_start_fidelity` date DEFAULT NULL,
  `Date_last_book` date DEFAULT NULL,
  `Date_start_Unfidelity` date DEFAULT NULL,
  `State_fidelity` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ID_Customer`),
  KEY `fk_customer_Address1_idx` (`Address_idAddress`),
  CONSTRAINT `fk_customer_Address1` FOREIGN KEY (`Address_idAddress`) REFERENCES `address` (`idAddress`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (121,'luca','lorusso',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(122,'Andrea','Biaggi',2,'1995-10-27',NULL,'customer.Customer','biaggi.jack@gmail.com','mattonella','3339553735',NULL,NULL,NULL,NULL),(123,'Andrea','Biaggi',8,'1995-10-27',NULL,'Customer State','b@g','aabc','3276925853',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `flight` (
  `Departure_ICAO` varchar(4) NOT NULL,
  `Arrival_ICAO` varchar(4) NOT NULL,
  `Flight_ID` varchar(5) NOT NULL,
  `Departure_Date` date NOT NULL,
  `Departure_Time` time NOT NULL,
  `Arrival_Date` date NOT NULL,
  `Arrival_Time` time NOT NULL,
  `Aircraft_ID_aircraft` int(11) NOT NULL,
  `Distance` int(11) DEFAULT NULL,
  `Seat_Remaining` int(11) DEFAULT NULL,
  PRIMARY KEY (`Flight_ID`,`Departure_Date`,`Aircraft_ID_aircraft`),
  KEY `fk_Airport_has_Airport_Airport1_idx` (`Arrival_ICAO`),
  KEY `fk_Airport_has_Airport_Airport_idx` (`Departure_ICAO`),
  KEY `fk_Flight_Aircraft1_idx` (`Aircraft_ID_aircraft`),
  CONSTRAINT `fk_Airport_has_Airport_Airport` FOREIGN KEY (`Departure_ICAO`) REFERENCES `airport` (`ICAO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Airport_has_Airport_Airport1` FOREIGN KEY (`Arrival_ICAO`) REFERENCES `airport` (`ICAO`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Flight_Aircraft1` FOREIGN KEY (`Aircraft_ID_aircraft`) REFERENCES `aircraft` (`ID_aircraft`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight`
--

LOCK TABLES `flight` WRITE;
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` VALUES ('1','2','mh51','2017-01-27','08:00:00','2017-01-27','08:55:00',1,600,1),('1','2','mh52','2017-01-27','15:30:00','2017-01-27','16:25:00',2,600,30),('1','2','mh53','2017-01-27','10:30:00','2017-01-27','11:25:00',1,600,10),('2','1','mh54','2017-02-27','14:00:00','2017-02-27','14:55:00',2,600,40);
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `passenger` (
  `Fiscal_code` varchar(16) NOT NULL DEFAULT 'nnn',
  `Name` varchar(45) NOT NULL,
  `Surname` varchar(45) NOT NULL,
  `Birth_date` date NOT NULL,
  `ID_code` varchar(45) NOT NULL,
  `Type_ID` varchar(45) NOT NULL,
  `Baggage_ID_Baggage` varchar(45) NOT NULL,
  PRIMARY KEY (`Fiscal_code`),
  KEY `fk_Passenger_Baggage1_idx` (`Baggage_ID_Baggage`),
  CONSTRAINT `fk_Passenger_Baggage1` FOREIGN KEY (`Baggage_ID_Baggage`) REFERENCES `baggage` (`ID_Baggage`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passenger`
--

LOCK TABLES `passenger` WRITE;
/*!40000 ALTER TABLE `passenger` DISABLE KEYS */;
INSERT INTO `passenger` VALUES ('lbsjdbl','jònsvd','jsnldbg','1999-02-11','sdrhae','Identity card','Normal'),('sadkjbak','sghk','sdjbk','1995-01-22','sdjbsgl','Identity card','Normal'),('sdghsah','andrea','Biaggi','1966-03-04','sdguhsak','Identity card','Normal'),('sdgjlnsg','Andrea','Biaggi','1995-10-27','sdgbjk','Identity card','Normal'),('sdgsgqqf','acjdvf','svs','2000-01-01','swgjkbwdkgsb','Identity card','Sport'),('sdklgsl','sgshl','ssdlghsl','2011-02-22','sgnls','Identity card','Normal'),('sjdnbsjbvk','sdhgs','skjgshgls','1966-03-04','ssdgsg','Identity card','Huge'),('v','a','v','2000-01-01','vcwku','Identity card','Normal');
/*!40000 ALTER TABLE `passenger` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_methods`
--

DROP TABLE IF EXISTS `payment_methods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment_methods` (
  `Customer_id_customer` int(11) NOT NULL AUTO_INCREMENT,
  `No_card` int(11) NOT NULL,
  `Owner` varchar(45) NOT NULL,
  `CVV` varchar(45) NOT NULL,
  `Expire` date NOT NULL,
  PRIMARY KEY (`Customer_id_customer`,`No_card`),
  KEY `fk_Payment_methods_User1_idx` (`Customer_id_customer`),
  CONSTRAINT `fk_Payment_methods_User1` FOREIGN KEY (`Customer_id_customer`) REFERENCES `customer` (`ID_Customer`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_methods`
--

LOCK TABLES `payment_methods` WRITE;
/*!40000 ALTER TABLE `payment_methods` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_methods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `flight_Flight_ID` varchar(5) NOT NULL,
  `flight_Departure_Date` date NOT NULL,
  `flight_Aircraft_ID_aircraft` int(11) NOT NULL,
  `seat_Row` int(11) NOT NULL,
  `seat_Seat` varchar(45) NOT NULL,
  `seat_Aircraft_ID_aircraft` int(11) NOT NULL,
  `promotion_IdPromo` int(11) DEFAULT NULL,
  `amount` float DEFAULT NULL,
  PRIMARY KEY (`flight_Flight_ID`,`flight_Departure_Date`,`flight_Aircraft_ID_aircraft`,`seat_Row`,`seat_Seat`,`seat_Aircraft_ID_aircraft`),
  KEY `fk_flight_has_seat_seat1_idx` (`seat_Row`,`seat_Seat`,`seat_Aircraft_ID_aircraft`),
  KEY `fk_flight_has_seat_flight1_idx` (`flight_Flight_ID`,`flight_Departure_Date`,`flight_Aircraft_ID_aircraft`),
  KEY `fk_flight_has_seat_promotion1_idx` (`promotion_IdPromo`),
  CONSTRAINT `fk_flight_has_seat_flight1` FOREIGN KEY (`flight_Flight_ID`, `flight_Departure_Date`, `flight_Aircraft_ID_aircraft`) REFERENCES `flight` (`Flight_ID`, `Departure_Date`, `Aircraft_ID_aircraft`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_has_seat_promotion1` FOREIGN KEY (`promotion_IdPromo`) REFERENCES `promotion` (`IdPromo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_flight_has_seat_seat1` FOREIGN KEY (`seat_Row`, `seat_Seat`, `seat_Aircraft_ID_aircraft`) REFERENCES `seat` (`Row`, `Seat`, `Aircraft_ID_aircraft`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
INSERT INTO `price` VALUES ('mh51','2017-01-27',1,1,'A',1,1,20),('mh51','2017-01-27',1,1,'B',1,1,50),('mh51','2017-01-27',1,2,'A',1,1,32),('mh51','2017-01-27',1,2,'B',1,1,80),('mh52','2017-01-27',2,1,'A',2,NULL,40),('mh52','2017-01-27',2,1,'B',2,NULL,40),('mh52','2017-01-27',2,2,'A',2,NULL,90),('mh52','2017-01-27',2,2,'B',2,NULL,90),('mh54','2017-02-27',2,1,'A',2,NULL,400);
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `promotion` (
  `IdPromo` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) DEFAULT NULL,
  `Expire_Date` date DEFAULT NULL,
  `Discount_rate` int(11) DEFAULT NULL,
  `Start_Date` date DEFAULT NULL,
  `Fidelity` tinyint(1) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `promo_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`IdPromo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion`
--

LOCK TABLES `promotion` WRITE;
/*!40000 ALTER TABLE `promotion` DISABLE KEYS */;
INSERT INTO `promotion` VALUES (1,'winter\'s wind','2018-01-01',40,'2017-01-27',0,'aua','flight');
/*!40000 ALTER TABLE `promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registrer`
--

DROP TABLE IF EXISTS `registrer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registrer` (
  `Code_prenotazione` int(11) NOT NULL,
  `ID_payment` varchar(45) DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Code_prenotazione`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registrer`
--

LOCK TABLES `registrer` WRITE;
/*!40000 ALTER TABLE `registrer` DISABLE KEYS */;
/*!40000 ALTER TABLE `registrer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `Row` int(11) NOT NULL,
  `Seat` varchar(45) NOT NULL,
  `Tariff` varchar(45) NOT NULL,
  `Aircraft_ID_aircraft` int(11) NOT NULL,
  PRIMARY KEY (`Row`,`Seat`,`Aircraft_ID_aircraft`),
  KEY `fk_Seat_Aircraft1_idx` (`Aircraft_ID_aircraft`),
  CONSTRAINT `fk_Seat_Aircraft1` FOREIGN KEY (`Aircraft_ID_aircraft`) REFERENCES `aircraft` (`ID_aircraft`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,'A','base',1),(1,'A','base',2),(1,'B','base',1),(1,'B','base',2),(1,'C','base',1),(1,'C','base',2),(1,'D','base',1),(1,'D','base',2),(1,'E','base',1),(1,'E','base',2),(1,'F','base',1),(1,'F','base',2),(2,'A','premium',1),(2,'A','premium',2),(2,'B','premium',1),(2,'B','premium',2),(2,'C','premium',1),(2,'C','premium',2),(2,'D','premium',1),(2,'D','premium',2),(2,'E','premium',1),(2,'E','premium',2),(2,'F','premium',1),(2,'F','premium',2);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-22 17:20:12
