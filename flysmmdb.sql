CREATE DATABASE  IF NOT EXISTS `flysmmdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `flysmmdb`;
-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: flysmmdb
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (10,'via turati','11','20090','Milano','Italia'),(11,'via adige','4','20145','Legnano','Italia'),(12,'boiuhuo','yubhuhy','ohoihui','bhjbjk','jbnjikbi'),(13,'ciao','45','20124','Carate','Italia'),(14,'tuirr','74','20120','carate','Italia'),(15,'via pippo','21','12014','Milano','Italia'),(16,'jvkuv','hjbkhb','bhkh','bh','hbj'),(17,'hbjb','hjbkk','g','guyg','uygu'),(18,'zxcvb','ssdfg','sdfg','asdfg','qwert'),(19,'bhjbj','bhbk','jvbhjvbhgv','iugviyviuv','iuyviuy'),(20,'iuhuio','hiuoh','bnkjnjkb','lkjblkjblkb','lblkjk');
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
INSERT INTO `aircraft` VALUES (1,'A380',270,45,'Airbus'),(2,'737',270,45,'Boeing'),(3,'A320',250,44,'Airbus'),(4,'777',300,50,'Boeing'),(5,'175',280,40,'Embraer'),(6,'ATR72',190,30,'Nostrum'),(7,'ATR42',90,20,'Nostrum'),(8,'BOMBARDIER',200,50,'Embraer'),(9,'717',100,15,'Boeing'),(10,'787',400,80,'Boeing');
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
INSERT INTO `airport` VALUES ('EDBG','Burg Airport','Burg','Germany',1),('EDCB','Ballenstedt Airport','Ballenstedt','Germany',1),('EDCK','Koethen Airport','Koethen','Germany',1),('EDCL','Klietz-Scharlibbe Airport','Scharlibbe','Germany',1),('EDCO','Obermehler-Schlotheim Airport','Obermehler','Germany',1),('EDHB','Grube Airport','Grube','Germany',1),('EDHC','Luechow-Rehbeck Airport','Luechow','Germany',1),('EDHM','Hartenholm Airport','Hasenmoor','Germany',1),('EDKL','Leverkusen Airport','Leverkusen','Germany',-1),('EDKN','Wipperfuerth-Neye Airport','Wipperfuerth','Germany',1),('EDKO','Brilon Hochsauerlandkreis Airport','Brilon','Germany',1),('EDLB','Borkenberge Airport','Duelmen','Germany',1),('EDLH','Hamm-Lippewiesen Airport','Hamm','Germany',1),('EDLT','Muenster-Telgte Airport','Muenster','Germany',1),('EDOJ','Luesse Airport','Luesse','Germany',1),('EDRA','Bad Neuenahr-Ahrweiler Airport','Bad Neuenahr','Germany',1),('EDRF','Bad Duerkheim Airport','Bad Duerkheim','Germany',1),('EDRV','Wershofen Eifel','Wershofen','Germany',1),('EDVC','Celle-Arloh Airport','Celle','Germany',1),('EDVH','Hodenhagen Airport','Hodenhagen','Germany',1),('EDVR','Rinteln Airport','Rinteln','Germany',1),('EDVS','Salzgitter Druette Airport','Salzgitter','Germany',1),('EDVU','Uelzen Airport','Uelzen','Germany',1),('EDVW','Hameln Pyrmont Airport','Bad Pyrmont','Germany',1),('EDVY','Porta Westfalica Airport','Bad Oeynhausen','Germany',1),('EDWC','Damme Airport','Damme','Germany',1),('EDWH','Oldenburg Hatten Airport','Oldenburg','Germany',1),('EDWK','Karlshoefen Airport','Karlshoefen','Germany',1),('EDWO','Osnabrueck-Atterheide Airport','Osnabrueck','Germany',1),('EDWQ','Ganderkesee Atlas Airfield Airport','Ganderkesee','Germany',1),('EDXI','Nienburg-Holzbalge Airport','Nienburg Weser','Germany',1),('EDXM','St. Michaelisdonn Airport','Sankt Michaelisdonn','Germany',1),('EDXN','Nordholz Spieka Airport','Cuxhaven','Germany',1),('EDXO','St. Peter-Ording Airport','Sankt Peter-Ording','Germany',1),('EDXQ','Rotenburg Wuemme Airport','Rotenburg Wuemme','Germany',1),('EKTD','Toender Airport','Toender','Denmark',1),('GCHI','Hierro','Hierro','Spain',0),('GCLA','La Palma','Santa Cruz De La Palma','Spain',0),('GCLP','Gran Canaria','Gran Canaria','Spain',0),('GCRR','Lanzarote','Las Palmas','Spain',0),('GCTS','Tenerife Sur','Tenerife','Spain',0),('GCXO','Tenerife Norte','Tenerife','Spain',0),('GEML','Melilla','Melilla','Spain',0),('GFLL','Freetown Lungi','Freetown','Sierra Leone',0),('GGCF','Cufar','Cufar','Guinea-Bissau',0),('K62S','Christmas Valley Airport','Christmas Valley','United States',-8),('KBDN','Bend Municipal Airport','Bend','United States',-8),('KBNO','Burns Municipal Airport','Burns','United States',-8),('KCKC','Grand Marais Cook County Airport','Grand Marais','United States',-6),('KCKF','Crisp County Cordele Airport','Cordele','United States',-4),('KHIO','Portland Hillsboro','Hillsboro','United States',-8),('KOMN','Ormond Beach municipal Airport','Ormond Beach','United States',-5),('KTTD','Portland Troutdale','Troutdale','United States',-8),('LIBA','Amendola','Amendola','Italy',1),('LIBC','Crotone','Crotone','Italy',1),('LIBD','Bari','Bari','Italy',1),('LIBF','Gino Lisa','Foggia','Italy',1),('LIBG','Grottaglie','Grottaglie','Italy',1),('LIBN','Lecce','Lecce','Italy',1),('LIBP','Pescara','Pescara','Italy',1),('LIBR','Casale','Brindisi','Italy',1),('LIBV','Gioia Del Colle','Gioia Del Colle','Italy',1),('LICA','Lamezia Terme','Lamezia','Italy',1),('LICC','Catania Fontanarossa','Catania','Italy',1),('LICD','Lampedusa','Lampedusa','Italy',1),('LICG','Pantelleria','Pantelleria','Italy',1),('LICJ','Palermo','Palermo','Italy',1),('LICP','Boccadifalco','Palermo','Italy',1),('LICR','Reggio Calabria','Reggio Calabria','Italy',1),('LICT','Trapani Birgi','Trapani','Italy',1),('LICZ','Sigonella','Sigonella','Italy',1),('LIEA','Alghero','Alghero','Italy',1),('LIED','Decimomannu','Decimomannu','Italy',1),('LIEE','Elmas','Cagliari','Italy',1),('LIEO','Olbia Costa Smeralda','Olbia','Italy',1),('LIET','Tortoli','Tortoli','Italy',1),('LIMA','Aeritalia','Turin','Italy',1),('LIMB','Bresso','Milano','Italy',1),('LIMC','Malpensa','Milano','Italy',1),('LIME','Bergamo Orio Al Serio','Bergamo','Italy',1),('LIMF','Torino','Torino','Italy',1),('LIMG','Albenga','Albenga','Italy',1),('LIMJ','Genova Sestri','Genoa','Italy',1),('LIML','Linate','Milan','Italy',1),('LIMN','Cameri','Cameri','Italy',1),('LIMP','Parma','Parma','Italy',1),('LIMS','Piacenza','Piacenza','Italy',1),('LIMZ','Levaldigi','Levaldigi','Italy',1),('LIPA','Aviano Ab','Aviano','Italy',1),('LIPB','Bolzano','Bolzano','Italy',1),('LIPC','Cervia','Cervia','Italy',1),('LIPE','Bologna','Bologna','Italy',1),('LIPH','Treviso','Treviso','Italy',1),('LIPI','Rivolto','Rivolto','Italy',1),('LIPK','Forli','Forli','Italy',1),('LIPL','Ghedi','Ghedi','Italy',1),('LIPN','Verona Boscomantico','Verona','Italy',1),('LIPO','Montichiari','Montichiari','Italy',1),('LIPQ','Ronchi Dei Legionari','Ronchi De Legionari','Italy',1),('LIPR','Rimini','Rimini','Italy',1),('LIPS','Istrana','Treviso','Italy',1),('LIPT','Vicenza','Vicenza','Italy',1),('LIPU','Padova','Padova','Italy',1),('LIPX','Villafranca','Villafranca','Italy',1),('LIPZ','Venezia Tessera','Venice','Italy',1),('LIQS','Ampugnano','Siena','Italy',1),('LIRA','Ciampino','Rome','Italy',1),('LIRE','Pratica Di Mare','Pratica Di Mare','Italy',1),('LIRF','Fiumicino','Rome','Italy',1),('LIRG','Guidonia','Guidonia','Italy',1),('LIRJ','Marina Di Campo','Marina Di Campo','Italy',1),('LIRL','Latina','Latina','Italy',1),('LIRM','Grazzanise','Grazzanise','Italy',1),('LIRN','Capodichino','Naples','Italy',1),('LIRP','Pisa','Pisa','Italy',1),('LIRQ','Firenze','Firenze','Italy',1),('LIRS','Grosseto','Grosseto','Italy',1),('LIRU','Urbe','Rome','Italy',1),('LIRV','Viterbo','Viterbo','Italy',1),('LIRZ','Perugia','Perugia','Italy',1),('NK39','One Police Plaza Heliport','New York','United States',-5),('OAKS','FOB Salerno','Khost','Afghanistan',5),('SBAA','Conceicao Do Araguaia','Conceicao Do Araguaia','Brazil',-3),('SBAF','Campo Delio Jardim De Mattos','Rio De Janeiro','Brazil',-3),('SBAM','Amapa','Amapa','Brazil',-3),('SBAQ','Araraquara','Araracuara','Brazil',-3),('SBAR','Santa Maria','Aracaju','Brazil',-3),('SBAS','Assis','Assis','Brazil',-3),('SBAT','Alta Floresta','Alta Floresta','Brazil',-4),('SBAU','Aracatuba','Aracatuba','Brazil',-3),('SBBE','Val De Cans Intl','Belem','Brazil',-3),('SBBG','Comandante Gustavo Kraemer','Bage','Brazil',-3),('SBBH','Pampulha Carlos Drummond De Andrade','Belo Horizonte','Brazil',-3),('SBBI','Bacacheri','Curitiba','Brazil',-3),('SBBQ','Major Brigadeiro Doorgal Borges','Barbacena','Brazil',-3),('SBBR','Presidente Juscelino Kubitschek','Brasilia','Brazil',-3),('SBBU','Bauru','Bauru','Brazil',-3),('SBBV','Boa Vista','Boa Vista','Brazil',-4),('SBBW','Barra Do Garcas','Barra Do Garcas','Brazil',-3),('SBCA','Cascavel','Cascavel','Brazil',-3),('SBCC','Cachimbo','Itaituba','Brazil',-4),('SBCF','Tancredo Neves Intl','Belo Horizonte','Brazil',-3),('SBCG','Campo Grande','Campo Grande','Brazil',-4),('SBCH','Chapeco','Chapeco','Brazil',-3),('SBCI','Carolina','Carolina','Brazil',-3),('SBCM','Forquilhinha','Criciuma','Brazil',-3),('SBCO','Canoas','Porto Alegre','Brazil',-3),('SBCP','Bartolomeu Lisandro','Campos','Brazil',-3),('SBCR','Corumba Intl','Corumba','Brazil',-4),('SBCT','Afonso Pena','Curitiba','Brazil',-3),('SBCV','Caravelas','Caravelas','Brazil',-3),('SBCX','Campo Dos Bugres','Caxias Do Sul','Brazil',-3),('SBCY','Marechal Rondon','Cuiaba','Brazil',-4),('SBCZ','Cruzeiro do Sul','Cruzeiro do Sul','Brazil',-5),('SBDN','Presidente Prudente','President Prudente','Brazil',-3),('SBEG','Eduardo Gomes Intl','Manaus','Brazil',-4),('SBEK','Jacareacanga','Jacare-acanga','Brazil',-4),('SBES','Sao Pedro Da Aldeia','Sao Pedro Da Aldeia','Brazil',-3),('SBFI','Cataratas Intl','Foz Do Iguacu','Brazil',-3),('SBFL','Hercilio Luz','Florianopolis','Brazil',-3),('SBFN','Fernando De Noronha','Fernando Do Noronha','Brazil',-2),('SBFT','Fronteira','Fronteira','Brazil',-3),('SBFU','Furnas','Alpinopolis','Brazil',-3),('SBFZ','Pinto Martins Intl','Fortaleza','Brazil',-3),('SBGL','Galeao Antonio Carlos Jobim','Rio De Janeiro','Brazil',-3),('SBGM','Guajara Mirim','Guajara-mirim','Brazil',-4),('SBGO','Santa Genoveva','Goiania','Brazil',-3),('SBGP','Embraer Unidade Gaviao Peixoto','Macae','Brazil',-3),('SBGR','Guarulhos Gov Andre Franco Montouro','Sao Paulo','Brazil',-3),('SBGW','Guaratingueta','Guaratingueta','Brazil',-3),('SBHT','Altamira','Altamira','Brazil',-3),('SBIC','Itacoatiara','Itaituba','Brazil',-4),('SBIH','Itaituba','Itaituba','Brazil',-4),('SBIL','Ilheus','Ilheus','Brazil',-3),('SBIP','Usiminas','Ipatinga','Brazil',-3),('SBIT','Hidroeletrica','Itumbiara','Brazil',-3),('SBIZ','Prefeito Renato Moreira','Imperatriz','Brazil',-3),('SBJC','Julio Cesar','Belem','Brazil',-3),('SBJF','Francisco De Assis','Juiz De Fora','Brazil',-3),('SBJP','Presidente Castro Pinto','Joao Pessoa','Brazil',-3),('SBJV','Lauro Carneiro De Loyola','Joinville','Brazil',-3),('SBKG','Presidente Joao Suassuna','Campina Grande','Brazil',-3),('SBKP','Viracopos','Campinas','Brazil',-3),('SBLJ','Lages','Lajes','Brazil',-3),('SBLN','Lins','Lins','Brazil',-3),('SBLO','Londrina','Londrina','Brazil',-3),('SBLP','Bom Jesus Da Lapa','Bom Jesus Da Lapa','Brazil',-3),('SBLS','Lagoa Santa','Lagoa Santa','Brazil',-3),('SBMA','Maraba','Maraba','Brazil',-3),('SBMD','Monte Dourado','Almeirim','Brazil',-3),('SBMG','Regional De Maringa Silvio Name Junior','Maringa','Brazil',-3),('SBMK','Mario Ribeiro','Montes Claros','Brazil',-3),('SBMN','Ponta Pelada','Manaus','Brazil',-4),('SBMO','Zumbi Dos Palmares','Maceio','Brazil',-3),('SBMQ','Macapa','Macapa','Brazil',-3),('SBMS','Dix Sept Rosado','Mocord','Brazil',-3),('SBMT','Marte','Sao Paulo','Brazil',-3),('SBMY','Manicore','Manicore','Brazil',-4),('SBNF','Ministro Victor Konder Intl','Navegantes','Brazil',-3),('SBNM','Santo Angelo','Santo Angelo','Brazil',-3),('SBNT','Augusto Severo','Natal','Brazil',-3),('SBOI','Oiapoque','Oioiapoque','Brazil',-3),('SBPA','Salgado Filho','Porto Alegre','Brazil',-3),('SBPB','Prefeito Doutor Joao Silva Filho','Parnaiba','Brazil',-3),('SBPC','Pocos De Caldas','Pocos De Caldas','Brazil',-3),('SBPF','Lauro Kurtz','Passo Fundo','Brazil',-3),('SBPK','Pelotas','Pelotas','Brazil',-3),('SBPL','Senador Nilo Coelho','Petrolina','Brazil',-3),('SBPN','Porto Nacional','Porto Nacional','Brazil',-3),('SBPP','Ponta Pora','Ponta Pora','Brazil',-4),('SBPV','Governador Jorge Teixeira De Oliveira','Porto Velho','Brazil',-4),('SBRB','Plácido de Castro','Rio Branco','Brazil',-5),('SBRF','Guararapes Gilberto Freyre Intl','Recife','Brazil',-3),('SBRG','Rio Grande','Rio Grande','Brazil',-3),('SBRJ','Santos Dumont','Rio De Janeiro','Brazil',-3),('SBRP','Leite Lopes','Ribeirao Preto','Brazil',-3),('SBSC','Santa Cruz','Rio De Janeiro','Brazil',-3),('SBSJ','Professor Urbano Ernesto Stumpf','Sao Jose Dos Campos','Brazil',-3),('SBSL','Marechal Cunha Machado Intl','Sao Luis','Brazil',-3),('SBSP','Congonhas','Sao Paulo','Brazil',-3),('SBSR','Sao Jose Do Rio Preto','Sao Jose Do Rio Preto','Brazil',-3),('SBST','Base Aerea De Santos','Santos','Brazil',-3),('SBSV','Deputado Luis Eduardo Magalhaes','Salvador','Brazil',-3),('SBTB','Trombetas','Oriximina','Brazil',-4),('SBTE','Senador Petronio Portella','Teresina','Brazil',-3),('SBTF','Tefe','Tefe','Brazil',-4),('SBTK','Tarauaca','Tarauaca','Brazil',-5),('SBTL','Telemaco Borba','Telemaco Borba','Brazil',-3),('SBTS','Tirios','Obidos Tirios','Brazil',-4),('SBTT','Tabatinga','Tabatinga','Brazil',-4),('SBTU','Tucurui','Tucurui','Brazil',-3),('SBUA','Sao Gabriel Da Cachoeira','Sao Gabriel','Brazil',-4),('SBUF','Paulo Afonso','Paulo Alfonso','Brazil',-3),('SBUG','Rubem Berta','Uruguaiana','Brazil',-3),('SBUL','Ten Cel Av Cesar Bombonato','Uberlandia','Brazil',-3),('SBUP','Urubupunga','Castilho','Brazil',-3),('SBUR','Uberaba','Uberaba','Brazil',-3),('SBVG','Major Brigadeiro Trompowsky','Varginha','Brazil',-3),('SBVH','Vilhena','Vilhena','Brazil',-4),('SBVT','Goiabeiras','Vitoria','Brazil',-3),('SBYA','Iauarete','Iauarete','Brazil',-4),('SBYS','Campo Fontenelle','Piracununga','Brazil',-3),('VYNT','NAYPYITAW','NAYPYITAW','Burma',7);
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
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book`
--

LOCK TABLES `book` WRITE;
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
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
INSERT INTO `flight` VALUES ('LIMC','SBAF','adsci','2017-09-22','07:11:00','2017-09-22','08:11:00',8,3711,6),('LIRF','LIMC','amtfd','2017-09-22','07:11:00','2017-09-22','08:11:00',8,500,69),('GCRR','LIMC','bkbil','2017-08-29','13:05:00','2017-08-29','15:05:00',6,900,96),('GCRR','LIMC','bnklu','2017-08-24','23:28:00','2017-08-25','10:28:00',7,900,91),('LIRF','LIMC','coser','2017-03-02','19:56:00','2017-03-02','20:56:00',7,500,72),('EDKL','EDRV','dolor','2017-09-22','07:11:00','2017-09-22','08:11:00',8,1064,64),('LIMC','LIRF','eiuod','2017-03-02','15:56:00','2017-03-02','18:56:00',7,500,17),('LIMC','LIRF','elidt','2017-03-02','19:56:00','2017-03-02','20:56:00',7,500,74),('LIMC','GCRR','hbibj','2017-06-05','19:05:00','2017-06-05','19:05:00',10,900,63),('EDRV','EDKL','ipsum','2017-03-02','19:56:00','2017-03-02','20:56:00',7,1064,8),('LIMC','LIRF','kbukb','2017-06-23','16:51:00','2017-06-23','17:51:00',2,500,81),('LIMC','LIRF','lorem','2017-07-21','09:07:00','2017-07-21','10:07:00',4,500,48),('LIRF','LIMC','mhuhn','2017-09-22','07:11:00','2017-09-22','08:11:00',8,500,66),('LIMC','LIRF','mlkml','2017-09-10','19:32:00','2017-09-11','10:32:00',1,500,16),('LIMC','LIRF','ndinj','2017-06-23','12:51:00','2017-06-23','14:51:00',2,500,81),('LIRF','LIMC','njmhd','2017-03-02','19:56:00','2017-03-02','20:56:00',7,500,7),('LIMC','GCRR','nniou','2017-03-31','23:44:00','2017-04-01','05:44:00',9,900,85),('LIMC','LIRF','nuhmp','2017-08-04','22:14:00','2017-08-05','11:14:00',5,500,8),('LIMC','GCRR','sedrw','2017-09-22','08:13:00','2017-09-22','10:11:00',8,900,68),('LIRF','LIMC','sinkt','2017-03-02','19:56:00','2017-03-02','20:56:00',7,500,37),('LIMC','LIRF','tepor','2017-09-22','07:12:00','2017-09-22','10:12:00',8,500,63);
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
INSERT INTO `price` VALUES ('adsci','2017-09-22',8,7,'C',10,NULL,160),('amtfd','2017-09-22',8,4,'A',8,NULL,69),('bkbil','2017-08-29',6,3,'C',4,NULL,96),('bnklu','2017-08-24',7,9,'B',4,NULL,191),('coser','2017-03-02',7,8,'C',9,NULL,72),('dolor','2017-09-22',8,9,'B',2,NULL,164),('eiuod','2017-03-02',7,5,'B',3,NULL,17),('elidt','2017-03-02',7,5,'B',2,NULL,74),('hbibj','2017-06-05',10,10,'A',2,NULL,163),('ipsum','2017-03-02',7,3,'A',6,NULL,80),('kbukb','2017-06-23',2,3,'A',6,NULL,81),('lorem','2017-07-21',4,6,'A',1,NULL,48),('mhuhn','2017-09-22',8,7,'C',2,NULL,66),('mlkml','2017-09-10',1,1,'A',1,NULL,16),('ndinj','2017-06-23',2,5,'C',4,NULL,81),('njmhd','2017-03-02',7,3,'B',1,NULL,70),('nniou','2017-03-31',9,10,'B',8,NULL,185),('nuhmp','2017-08-04',5,2,'B',3,NULL,80),('sedrw','2017-09-22',8,6,'A',2,NULL,68),('sinkt','2017-03-02',7,4,'B',5,NULL,79),('tepor','2017-09-22',8,4,'C',7,NULL,63);
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
INSERT INTO `seat` VALUES (1,'A','Base',1),(1,'A','Base',2),(1,'A','Base',3),(1,'A','Base',4),(1,'A','Base',5),(1,'A','Base',6),(1,'A','Base',7),(1,'A','Base',8),(1,'A','Base',9),(1,'A','Base',10),(1,'B','Base',1),(1,'B','Base',2),(1,'B','Base',3),(1,'B','Base',4),(1,'B','Base',5),(1,'B','Base',6),(1,'B','Base',7),(1,'B','Base',8),(1,'B','Base',9),(1,'B','Base',10),(1,'C','Base',1),(1,'C','Base',2),(1,'C','Base',3),(1,'C','Base',4),(1,'C','Base',5),(1,'C','Base',6),(1,'C','Base',7),(1,'C','Base',8),(1,'C','Base',9),(1,'C','Base',10),(2,'A','Base',1),(2,'A','Base',2),(2,'A','Base',3),(2,'A','Base',4),(2,'A','Base',5),(2,'A','Base',6),(2,'A','Base',7),(2,'A','Base',8),(2,'A','Base',9),(2,'A','Base',10),(2,'B','Base',1),(2,'B','Base',2),(2,'B','Base',3),(2,'B','Base',4),(2,'B','Base',5),(2,'B','Base',6),(2,'B','Base',7),(2,'B','Base',8),(2,'B','Base',9),(2,'B','Base',10),(2,'C','Base',1),(2,'C','Base',2),(2,'C','Base',3),(2,'C','Base',4),(2,'C','Base',5),(2,'C','Base',6),(2,'C','Base',7),(2,'C','Base',8),(2,'C','Base',9),(2,'C','Base',10),(3,'A','Base',1),(3,'A','Base',2),(3,'A','Base',3),(3,'A','Base',4),(3,'A','Base',5),(3,'A','Base',6),(3,'A','Base',7),(3,'A','Base',8),(3,'A','Base',9),(3,'A','Base',10),(3,'B','Base',1),(3,'B','Base',2),(3,'B','Base',3),(3,'B','Base',4),(3,'B','Base',5),(3,'B','Base',6),(3,'B','Base',7),(3,'B','Base',8),(3,'B','Base',9),(3,'B','Base',10),(3,'C','Base',1),(3,'C','Base',2),(3,'C','Base',3),(3,'C','Base',4),(3,'C','Base',5),(3,'C','Base',6),(3,'C','Base',7),(3,'C','Base',8),(3,'C','Base',9),(3,'C','Base',10),(4,'A','Base',1),(4,'A','Base',2),(4,'A','Base',3),(4,'A','Base',4),(4,'A','Base',5),(4,'A','Base',6),(4,'A','Base',7),(4,'A','Base',8),(4,'A','Base',9),(4,'A','Base',10),(4,'B','Base',1),(4,'B','Base',2),(4,'B','Base',3),(4,'B','Base',4),(4,'B','Base',5),(4,'B','Base',6),(4,'B','Base',7),(4,'B','Base',8),(4,'B','Base',9),(4,'B','Base',10),(4,'C','Base',1),(4,'C','Base',2),(4,'C','Base',3),(4,'C','Base',4),(4,'C','Base',5),(4,'C','Base',6),(4,'C','Base',7),(4,'C','Base',8),(4,'C','Base',9),(4,'C','Base',10),(5,'A','Base',1),(5,'A','Base',2),(5,'A','Base',3),(5,'A','Base',4),(5,'A','Base',5),(5,'A','Base',6),(5,'A','Base',7),(5,'A','Base',8),(5,'A','Base',9),(5,'A','Base',10),(5,'B','Base',1),(5,'B','Base',2),(5,'B','Base',3),(5,'B','Base',4),(5,'B','Base',5),(5,'B','Base',6),(5,'B','Base',7),(5,'B','Base',8),(5,'B','Base',9),(5,'B','Base',10),(5,'C','Base',1),(5,'C','Base',2),(5,'C','Base',3),(5,'C','Base',4),(5,'C','Base',5),(5,'C','Base',6),(5,'C','Base',7),(5,'C','Base',8),(5,'C','Base',9),(5,'C','Base',10),(6,'A','Premium',1),(6,'A','Premium',2),(6,'A','Premium',3),(6,'A','Premium',4),(6,'A','Premium',5),(6,'A','Premium',6),(6,'A','Premium',7),(6,'A','Premium',8),(6,'A','Premium',9),(6,'A','Premium',10),(6,'B','Premium',1),(6,'B','Premium',2),(6,'B','Premium',3),(6,'B','Premium',4),(6,'B','Premium',5),(6,'B','Premium',6),(6,'B','Premium',7),(6,'B','Premium',8),(6,'B','Premium',9),(6,'B','Premium',10),(6,'C','Premium',1),(6,'C','Premium',2),(6,'C','Premium',3),(6,'C','Premium',4),(6,'C','Premium',5),(6,'C','Premium',6),(6,'C','Premium',7),(6,'C','Premium',8),(6,'C','Premium',9),(6,'C','Premium',10),(7,'A','Premium',1),(7,'A','Premium',2),(7,'A','Premium',3),(7,'A','Premium',4),(7,'A','Premium',5),(7,'A','Premium',6),(7,'A','Premium',7),(7,'A','Premium',8),(7,'A','Premium',9),(7,'A','Premium',10),(7,'B','Premium',1),(7,'B','Premium',2),(7,'B','Premium',3),(7,'B','Premium',4),(7,'B','Premium',5),(7,'B','Premium',6),(7,'B','Premium',7),(7,'B','Premium',8),(7,'B','Premium',9),(7,'B','Premium',10),(7,'C','Premium',1),(7,'C','Premium',2),(7,'C','Premium',3),(7,'C','Premium',4),(7,'C','Premium',5),(7,'C','Premium',6),(7,'C','Premium',7),(7,'C','Premium',8),(7,'C','Premium',9),(7,'C','Premium',10),(8,'A','Premium',1),(8,'A','Premium',2),(8,'A','Premium',3),(8,'A','Premium',4),(8,'A','Premium',5),(8,'A','Premium',6),(8,'A','Premium',7),(8,'A','Premium',8),(8,'A','Premium',9),(8,'A','Premium',10),(8,'B','Premium',1),(8,'B','Premium',2),(8,'B','Premium',3),(8,'B','Premium',4),(8,'B','Premium',5),(8,'B','Premium',6),(8,'B','Premium',7),(8,'B','Premium',8),(8,'B','Premium',9),(8,'B','Premium',10),(8,'C','Premium',1),(8,'C','Premium',2),(8,'C','Premium',3),(8,'C','Premium',4),(8,'C','Premium',5),(8,'C','Premium',6),(8,'C','Premium',7),(8,'C','Premium',8),(8,'C','Premium',9),(8,'C','Premium',10),(9,'A','Premium',1),(9,'A','Premium',2),(9,'A','Premium',3),(9,'A','Premium',4),(9,'A','Premium',5),(9,'A','Premium',6),(9,'A','Premium',7),(9,'A','Premium',8),(9,'A','Premium',9),(9,'A','Premium',10),(9,'B','Premium',1),(9,'B','Premium',2),(9,'B','Premium',3),(9,'B','Premium',4),(9,'B','Premium',5),(9,'B','Premium',6),(9,'B','Premium',7),(9,'B','Premium',8),(9,'B','Premium',9),(9,'B','Premium',10),(9,'C','Premium',1),(9,'C','Premium',2),(9,'C','Premium',3),(9,'C','Premium',4),(9,'C','Premium',5),(9,'C','Premium',6),(9,'C','Premium',7),(9,'C','Premium',8),(9,'C','Premium',9),(9,'C','Premium',10),(10,'A','Premium',1),(10,'A','Premium',2),(10,'A','Premium',3),(10,'A','Premium',4),(10,'A','Premium',5),(10,'A','Premium',6),(10,'A','Premium',7),(10,'A','Premium',8),(10,'A','Premium',9),(10,'A','Premium',10),(10,'B','Premium',1),(10,'B','Premium',2),(10,'B','Premium',3),(10,'B','Premium',4),(10,'B','Premium',5),(10,'B','Premium',6),(10,'B','Premium',7),(10,'B','Premium',8),(10,'B','Premium',9),(10,'B','Premium',10),(10,'C','Premium',1),(10,'C','Premium',2),(10,'C','Premium',3),(10,'C','Premium',4),(10,'C','Premium',5),(10,'C','Premium',6),(10,'C','Premium',7),(10,'C','Premium',8),(10,'C','Premium',9),(10,'C','Premium',10);
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

-- Dump completed on 2017-02-25 17:10:47
