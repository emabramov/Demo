-- MySQL dump 10.13  Distrib 8.0.15, for Linux (x86_64)
--
-- Host: localhost    Database: skillbox
-- ------------------------------------------------------
-- Server version	8.0.15
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Courses`
--

DROP TABLE IF EXISTS `Courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Courses` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `duration` int(10) unsigned DEFAULT NULL COMMENT '   ',
  `type` enum('DESIGN','PROGRAMMING','MARKETING','MANAGEMENT','BUSINESS') NOT NULL COMMENT ' :  /  /  / ',
  `description` varchar(500) DEFAULT NULL,
  `teacher_id` int(10) unsigned DEFAULT NULL COMMENT '  ,   ',
  `students_count` int(10) unsigned DEFAULT NULL COMMENT '   ',
  `price` int(10) unsigned DEFAULT NULL COMMENT '   ',
  `price_per_hour` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_idx` (`teacher_id`),
  CONSTRAINT `teacher` FOREIGN KEY (`teacher_id`) REFERENCES `Teachers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Courses`
--

LOCK TABLES `Courses` WRITE;
/*!40000 ALTER TABLE `Courses` DISABLE KEYS */;
INSERT INTO `Courses` VALUES (1,'Python: Programming beginner to advanced',10,'PROGRAMMING','We present to your attention a chic course Python: Programming beginner to advanced',1,99,189600,18960),(2,'Mobile Developer: Programming beginner to advanced',10,'PROGRAMMING','We present to your attention a chic course Mobile Developer: Programming beginner to advanced',2,99,138000,13800),(3,'Java-Developer',5,'PROGRAMMING','We present to your attention a chic course Java-Developer',10,176,78000,15600),(4,'PHP-Developer from 0 to PRO',3,'PROGRAMMING','We present to your attention a chic course PHP-Developer from 0 to PRO',4,275,40000,13333.3),(5,'Python-Developer',4,'PROGRAMMING','We present to your attention a chic course Python-Developer',10,396,60000,15000),(6,'Frontend-Developer',9,'PROGRAMMING','We present to your attention a chic course Frontend-Developer',20,1100,80000,8888.89),(7,'Mobile Developer PRO',12,'PROGRAMMING','We present to your attention a chic course Mobile Developer PRO',7,99,10000,833.333),(8,'Programmer 1C-Bitrix',18,'PROGRAMMING','We present to your attention a chic course Programmer 1C-Bitrix',8,176,2000,111.111),(9,'С#-Developer: Programming beginner to advanced',30,'PROGRAMMING','We present to your attention a chic course С#-Developer: Programming beginner to advanced',9,275,4000,133.333),(10,'Data Scientist from 0 to PRO',9,'PROGRAMMING','We present to your attention a chic course Data Scientist from 0 to PRO',10,396,100000,11111.1),(11,'Data Analyst with Python',3,'PROGRAMMING','We present to your attention a chic course Data Analyst with Python',11,1100,8000,2666.67),(12,'Web-Design from 0 to PRO',10,'DESIGN','We present to your attention a chic course Web-Design from 0 to PRO',12,99,40613,4061.3),(13,'Advertising graphics',10,'DESIGN','We present to your attention a chic course Advertising graphics',13,99,17100,1710),(14,'UX-Design',5,'DESIGN','We present to your attention a chic course UX-Design',14,176,42750,8550),(15,'Interface Animation',3,'DESIGN','We present to your attention a chic course Interface Animation',10,275,85500,28500),(16,'Interior design from 0 to PRO',4,'DESIGN','We present to your attention a chic course Interior design from 0 to PRO',16,396,128250,32062.5),(17,'Graphic Designer from 0 to PRO',9,'DESIGN','We present to your attention a chic course Graphic Designer from 0 to PRO',20,1100,171000,19000),(18,'Mobile App Design',12,'DESIGN','We present to your attention a chic course Mobile App Design',18,99,21375,1781.25),(19,'Promotional sites from Red Collar',18,'DESIGN','We present to your attention a chic course Promotional sites from Red Collar',19,176,4275,237.5),(20,'Sketching for designers',30,'DESIGN','We present to your attention a chic course Sketching for designers',20,275,8550,285),(21,'Photoshop from beginner to advanced',9,'DESIGN','We present to your attention a chic course Photoshop from beginner to advanced',21,396,213750,23750),(22,'Sound-design',3,'DESIGN','We present to your attention a chic course Sound-design',22,1100,17100,5700),(23,'Cinema4D',10,'DESIGN','We present to your attention a chic course Cinema4D',23,99,40613,4061.3),(24,'Sketch',10,'DESIGN','We present to your attention a chic course Sketch',24,99,17100,1710),(25,'Figma',5,'DESIGN','We present to your attention a chic course Figma',25,176,42750,8550),(26,'Internet marketer from Ingate',3,'MARKETING','We present to your attention a chic course Internet marketer from Ingate',26,275,48000,16000),(27,'SMM-Marketer A to Z',4,'MARKETING','We present to your attention a chic course SMM-Marketer A to Z',27,396,72000,18000),(28,'Performance-marketing',9,'MARKETING','We present to your attention a chic course Performance-marketing',28,1100,96000,10666.7),(29,'Internet Marketer A to Z',12,'MARKETING','We present to your attention a chic course Internet Marketer A to Z',46,99,12000,1000),(30,'Instagram Promotion',18,'MARKETING','We present to your attention a chic course Instagram Promotion',47,176,2400,133.333),(31,'End-to-end analytics',30,'MARKETING','We present to your attention a chic course End-to-end analytics',48,275,4800,160),(32,'Targetologist A to Z',9,'MARKETING','We present to your attention a chic course Targetologist A to Z',49,396,120000,13333.3),(33,'UX-Analyst',3,'MARKETING','We present to your attention a chic course UX-Analyst',25,1100,9600,3200),(34,'Reputation management',3,'MARKETING','We present to your attention a chic course Reputation management',25,99,12000,4000),(35,'How to make YouTube content',3,'MARKETING','We present to your attention a chic course How to make YouTube content',35,176,2400,800),(36,'SEO specialist',5,'MARKETING','We present to your attention a chic course SEO specialist',36,275,4800,960),(37,'Viral marketing',4,'MARKETING','We present to your attention a chic course Viral marketing',37,396,120000,30000),(38,'CRM marketer',5,'MARKETING','We present to your attention a chic course CRM marketer',38,1100,9600,1920),(39,'How to open a web studio',10,'MANAGEMENT','We present to your attention a chic course How to open a web studio',39,99,10000,1000),(40,'How to open a beauty salon',12,'MANAGEMENT','We present to your attention a chic course How to open a beauty salon',40,176,2000,166.667),(41,'Team management',12,'MANAGEMENT','We present to your attention a chic course Team management',41,275,4000,333.333),(42,'Digital Project Management',12,'MANAGEMENT','We present to your attention a chic course Digital Project Management',42,396,100000,8333.33),(43,'Excel',55,'MANAGEMENT','We present to your attention a chic course Excel',43,1100,8000,145.455),(44,'Online Course Producer',5,'MANAGEMENT','We present to your attention a chic course Online Course Producer',44,99,10000,2000),(45,'Product management',3,'MANAGEMENT','We present to your attention a chic course Product management',45,176,2000,666.667),(46,'SQL',2,'DESIGN',NULL,2,NULL,8550,4275);
/*!40000 ALTER TABLE `Courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Students`
--

DROP TABLE IF EXISTS `Students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Students` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT ' ',
  `age` int(10) unsigned DEFAULT NULL COMMENT ' ',
  `registration_date` datetime NOT NULL COMMENT ' ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Students`
--

LOCK TABLES `Students` WRITE;
/*!40000 ALTER TABLE `Students` DISABLE KEYS */;
INSERT INTO `Students` VALUES (1,'Arias Cameron',18,'2016-01-01 00:00:00'),(2,'Conrad Christian',19,'2016-01-08 00:00:00'),(3,'Spears Chloe',20,'2016-01-15 00:00:00'),(4,'Noble Catherine',21,'2016-01-22 00:00:00'),(5,'Hickman Dominic',22,'2016-01-29 00:00:00'),(6,'McFarland Fred',23,'2016-02-05 00:00:00'),(7,'Hebert Henry',24,'2016-02-12 00:00:00'),(8,'Pennington Nicholas',25,'2016-02-19 00:00:00'),(9,'House Nicole',26,'2016-02-26 00:00:00'),(10,'Howe Patricia',27,'2016-03-04 00:00:00'),(11,'Frost Patrick',28,'2016-03-11 00:00:00'),(12,'Schaefer Thomas',29,'2016-03-18 00:00:00'),(13,'Buckley William',30,'2016-03-25 00:00:00'),(14,'Abbott Walter',31,'2016-04-01 00:00:00'),(15,'Middleton Ronald',32,'2016-04-08 00:00:00'),(16,'Glass Simon',33,'2016-04-15 00:00:00'),(17,'Bradshaw Zachary',34,'2016-04-22 00:00:00'),(18,'Leblanc Zoe',35,'2016-04-29 00:00:00'),(19,'Livingston Vanessa',36,'2016-05-06 00:00:00'),(20,'Nielsen Sophia',37,'2016-05-13 00:00:00'),(21,'Weeks Olivia',38,'2016-05-20 00:00:00'),(22,'Dorsey Oscar',39,'2016-05-27 00:00:00'),(23,'Morse Peter',40,'2016-06-03 00:00:00'),(24,'Knapp Malcolm',41,'2016-06-10 00:00:00'),(25,'Mora Lucas',42,'2016-06-17 00:00:00'),(26,'Gillespie Lillian',43,'2016-06-24 00:00:00'),(27,'Calhoun Kimberly',18,'2016-07-01 00:00:00'),(28,'Ellison Jane',19,'2016-07-08 00:00:00'),(29,'Sellers John',20,'2016-07-15 00:00:00'),(30,'Hardin Jacob',21,'2016-07-22 00:00:00'),(31,'Lowery Jeremiah',22,'2016-07-29 00:00:00'),(32,'Stark Jennifer',23,'2016-08-05 00:00:00'),(33,'Rangel Harry',24,'2016-08-12 00:00:00'),(34,'Hendricks Geoffrey',25,'2016-08-19 00:00:00'),(35,'Moon Ethan',26,'2016-08-26 00:00:00'),(36,'Sexton Danielle',27,'2016-09-02 00:00:00'),(37,'Herman Colin',28,'2016-09-09 00:00:00'),(38,'Melendez Daniel',29,'2016-09-16 00:00:00'),(39,'Rocha Dorothy',30,'2016-09-23 00:00:00'),(40,'Browning Bruce',31,'2016-09-30 00:00:00'),(41,'Kerr Carl',32,'2016-10-07 00:00:00'),(42,'Bullock Bridjet',33,'2016-10-14 00:00:00'),(43,'Solomon Barbara',34,'2016-10-21 00:00:00'),(44,'Meadows Angelina',35,'2016-10-28 00:00:00'),(45,'Escobar Alexa',36,'2016-11-04 00:00:00'),(46,'Stein Alejandro',37,'2016-11-11 00:00:00'),(47,'Strong Alfred',38,'2016-11-18 00:00:00'),(48,'Berger Adrian',39,'2016-11-25 00:00:00'),(49,'Leach Ashton',40,'2016-12-02 00:00:00'),(50,'Barrera Danielle',41,'2016-12-09 00:00:00'),(51,'Winters Alexandra',18,'2016-12-16 00:00:00'),(52,'Valenzuela Brooke',19,'2016-12-23 00:00:00'),(53,'Santana David',20,'2016-12-30 00:00:00'),(54,'Lam Celia',21,'2017-01-06 00:00:00'),(55,'Nolan Carlos',22,'2017-01-13 00:00:00'),(56,'Roach Julian',23,'2017-01-20 00:00:00'),(57,'Villanueva Joyce',24,'2017-01-27 00:00:00'),(58,'Hurst Jessica',25,'2017-02-03 00:00:00'),(59,'Merritt Jake',26,'2017-02-10 00:00:00'),(60,'Prince Gregory',27,'2017-02-17 00:00:00'),(61,'Woodard Evelyn',28,'2017-02-24 00:00:00'),(62,'Jacobson Herbert',29,'2017-03-03 00:00:00'),(63,'Shannon Edward',30,'2017-03-10 00:00:00'),(64,'English Florence',31,'2017-03-17 00:00:00'),(65,'Barry Francis',32,'2017-03-24 00:00:00'),(66,'Snow Miles',33,'2017-03-31 00:00:00'),(67,'Stafford Megan',34,'2017-04-07 00:00:00'),(68,'Vance Madeline',35,'2017-04-14 00:00:00'),(69,'Eaton Nathan',36,'2017-04-21 00:00:00'),(70,'Tanner Rodrigo',37,'2017-04-28 00:00:00'),(71,'Mercado Rosalind',38,'2017-05-05 00:00:00'),(72,'Blackwell Samantha',39,'2017-05-12 00:00:00'),(73,'Andrade Sebastian',40,'2017-05-19 00:00:00'),(74,'Khan Virginia',41,'2017-05-26 00:00:00'),(75,'Macias Tyler',42,'2017-06-02 00:00:00'),(76,'Keith Wyatt',43,'2017-06-09 00:00:00'),(77,'Ibarra Xavier',18,'2017-06-16 00:00:00'),(78,'Hobbs Violet',19,'2017-06-23 00:00:00'),(79,'Gilmore Susan',20,'2017-06-30 00:00:00'),(80,'Beard Trinity',21,'2017-07-07 00:00:00'),(81,'Suarez Rita',22,'2017-07-14 00:00:00'),(82,'Humphrey Oswald',23,'2017-07-21 00:00:00'),(83,'Rich Peter',24,'2017-07-28 00:00:00'),(84,'Johns Philip',25,'2017-08-04 00:00:00'),(85,'Harrell Margaret',26,'2017-08-11 00:00:00'),(86,'Berg Matthew',27,'2017-08-18 00:00:00'),(87,'Booth Maya',28,'2017-08-25 00:00:00'),(88,'Kane Leonora',29,'2017-09-01 00:00:00'),(89,'Melton Landon',30,'2017-09-08 00:00:00'),(90,'Boyer Kevin',31,'2017-09-15 00:00:00'),(91,'Parrish Jesus',32,'2017-09-22 00:00:00'),(92,'Hancock Jaden',33,'2017-09-29 00:00:00'),(93,'Dalton Josephine',34,'2017-10-06 00:00:00'),(94,'Camacho Katelyn',35,'2017-10-13 00:00:00'),(95,'Shields Lorna',36,'2017-10-20 00:00:00'),(96,'Trevino Ian',37,'2017-10-27 00:00:00'),(97,'Bond Herbert',38,'2017-11-03 00:00:00'),(98,'Villarreal Gavin',39,'2017-11-10 00:00:00'),(99,'Grimes Gordon',40,'2017-11-17 00:00:00'),(100,'Grimes Hailey',41,'2017-11-24 00:00:00');
/*!40000 ALTER TABLE `Students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subscriptions`
--

DROP TABLE IF EXISTS `Subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Subscriptions` (
  `student_id` int(10) unsigned NOT NULL,
  `course_id` int(10) unsigned NOT NULL,
  `subscription_date` datetime NOT NULL,
  UNIQUE KEY `unq` (`student_id`,`course_id`),
  KEY `course_idx` (`course_id`),
  CONSTRAINT `course` FOREIGN KEY (`course_id`) REFERENCES `Courses` (`id`),
  CONSTRAINT `student` FOREIGN KEY (`student_id`) REFERENCES `Students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subscriptions`
--

LOCK TABLES `Subscriptions` WRITE;
/*!40000 ALTER TABLE `Subscriptions` DISABLE KEYS */;
INSERT INTO `Subscriptions` VALUES (1,2,'2018-01-01 00:00:00'),(1,10,'2018-04-11 00:00:00'),(2,1,'2018-01-02 00:00:00'),(2,11,'2018-04-12 00:00:00'),(3,2,'2018-01-03 00:00:00'),(3,12,'2018-04-13 00:00:00'),(4,3,'2018-01-04 00:00:00'),(4,13,'2018-04-14 00:00:00'),(5,4,'2018-01-05 00:00:00'),(5,14,'2018-04-15 00:00:00'),(6,5,'2018-01-06 00:00:00'),(6,15,'2018-04-16 00:00:00'),(7,6,'2018-01-07 00:00:00'),(7,16,'2018-04-17 00:00:00'),(8,7,'2018-01-08 00:00:00'),(8,17,'2018-04-18 00:00:00'),(9,8,'2018-01-09 00:00:00'),(9,18,'2018-04-19 00:00:00'),(10,9,'2018-01-10 00:00:00'),(10,19,'2018-04-20 00:00:00'),(11,10,'2018-01-11 00:00:00'),(11,20,'2018-04-21 00:00:00'),(12,11,'2018-01-12 00:00:00'),(12,21,'2018-04-22 00:00:00'),(13,12,'2018-01-13 00:00:00'),(13,22,'2018-04-23 00:00:00'),(14,13,'2018-01-14 00:00:00'),(14,23,'2018-04-24 00:00:00'),(15,14,'2018-01-15 00:00:00'),(15,24,'2018-04-25 00:00:00'),(16,15,'2018-01-16 00:00:00'),(16,25,'2018-04-26 00:00:00'),(17,16,'2018-01-17 00:00:00'),(17,26,'2018-04-27 00:00:00'),(18,17,'2018-01-18 00:00:00'),(18,27,'2018-04-28 00:00:00'),(19,18,'2018-01-19 00:00:00'),(19,28,'2018-04-29 00:00:00'),(20,19,'2018-01-20 00:00:00'),(20,29,'2018-04-30 00:00:00'),(21,20,'2018-01-21 00:00:00'),(21,30,'2018-05-01 00:00:00'),(22,21,'2018-01-22 00:00:00'),(22,31,'2018-05-02 00:00:00'),(23,22,'2018-01-23 00:00:00'),(23,32,'2018-05-03 00:00:00'),(24,23,'2018-01-24 00:00:00'),(24,33,'2018-05-04 00:00:00'),(25,24,'2018-01-25 00:00:00'),(25,34,'2018-05-05 00:00:00'),(26,25,'2018-01-26 00:00:00'),(26,35,'2018-05-06 00:00:00'),(27,26,'2018-01-27 00:00:00'),(27,36,'2018-05-07 00:00:00'),(28,27,'2018-01-28 00:00:00'),(28,37,'2018-05-08 00:00:00'),(29,28,'2018-01-29 00:00:00'),(29,38,'2018-05-09 00:00:00'),(30,29,'2018-01-30 00:00:00'),(30,39,'2018-05-10 00:00:00'),(31,30,'2018-01-31 00:00:00'),(31,40,'2018-05-11 00:00:00'),(32,31,'2018-02-01 00:00:00'),(32,41,'2018-05-12 00:00:00'),(33,32,'2018-02-02 00:00:00'),(33,42,'2018-05-13 00:00:00'),(34,33,'2018-02-03 00:00:00'),(34,43,'2018-05-14 00:00:00'),(35,34,'2018-02-04 00:00:00'),(35,44,'2018-05-15 00:00:00'),(36,35,'2018-02-05 00:00:00'),(36,45,'2018-05-16 00:00:00'),(37,1,'2018-05-17 00:00:00'),(37,36,'2018-02-06 00:00:00'),(38,2,'2018-05-18 00:00:00'),(38,37,'2018-02-07 00:00:00'),(39,3,'2018-05-19 00:00:00'),(39,38,'2018-02-08 00:00:00'),(40,4,'2018-05-20 00:00:00'),(40,39,'2018-02-09 00:00:00'),(41,5,'2018-05-21 00:00:00'),(41,40,'2018-02-10 00:00:00'),(42,6,'2018-05-22 00:00:00'),(42,20,'2018-07-20 00:00:00'),(42,31,'2018-09-14 00:00:00'),(42,41,'2018-02-11 00:00:00'),(43,7,'2018-05-23 00:00:00'),(43,21,'2018-07-21 00:00:00'),(43,32,'2018-09-15 00:00:00'),(43,42,'2018-02-12 00:00:00'),(44,8,'2018-05-24 00:00:00'),(44,22,'2018-07-22 00:00:00'),(44,33,'2018-09-16 00:00:00'),(44,43,'2018-02-13 00:00:00'),(45,9,'2018-05-25 00:00:00'),(45,23,'2018-07-23 00:00:00'),(45,34,'2018-09-17 00:00:00'),(45,44,'2018-02-14 00:00:00'),(46,10,'2018-05-26 00:00:00'),(46,24,'2018-07-24 00:00:00'),(46,35,'2018-09-18 00:00:00'),(46,45,'2018-02-15 00:00:00'),(47,1,'2018-02-16 00:00:00'),(47,11,'2018-05-27 00:00:00'),(47,25,'2018-07-25 00:00:00'),(48,2,'2018-02-17 00:00:00'),(48,12,'2018-05-28 00:00:00'),(48,26,'2018-07-26 00:00:00'),(48,37,'2018-09-20 00:00:00'),(49,3,'2018-02-18 00:00:00'),(49,13,'2018-05-29 00:00:00'),(49,27,'2018-07-27 00:00:00'),(49,38,'2018-09-21 00:00:00'),(50,4,'2018-02-19 00:00:00'),(50,14,'2018-05-30 00:00:00'),(50,28,'2018-07-28 00:00:00'),(50,39,'2018-09-22 00:00:00'),(51,5,'2018-02-20 00:00:00'),(51,15,'2018-05-31 00:00:00'),(51,29,'2018-07-29 00:00:00'),(51,40,'2018-09-23 00:00:00'),(52,6,'2018-02-21 00:00:00'),(52,16,'2018-06-01 00:00:00'),(52,30,'2018-07-30 00:00:00'),(52,41,'2018-09-24 00:00:00'),(53,7,'2018-02-22 00:00:00'),(53,17,'2018-06-02 00:00:00'),(53,31,'2018-07-31 00:00:00'),(53,42,'2018-09-25 00:00:00'),(54,8,'2018-02-23 00:00:00'),(54,18,'2018-06-03 00:00:00'),(54,32,'2018-08-01 00:00:00'),(54,43,'2018-09-26 00:00:00'),(55,9,'2018-02-24 00:00:00'),(55,19,'2018-06-04 00:00:00'),(55,33,'2018-08-02 00:00:00'),(55,44,'2018-09-27 00:00:00'),(56,10,'2018-02-25 00:00:00'),(56,20,'2018-06-05 00:00:00'),(56,34,'2018-08-03 00:00:00'),(56,45,'2018-09-28 00:00:00'),(57,11,'2018-02-26 00:00:00'),(57,21,'2018-06-06 00:00:00'),(57,30,'2018-09-13 00:00:00'),(57,35,'2018-08-04 00:00:00'),(57,36,'2018-09-19 00:00:00'),(58,12,'2018-02-27 00:00:00'),(58,22,'2018-06-07 00:00:00'),(58,36,'2018-08-05 00:00:00'),(59,13,'2018-02-28 00:00:00'),(59,23,'2018-06-08 00:00:00'),(59,37,'2018-08-06 00:00:00'),(60,14,'2018-03-01 00:00:00'),(60,24,'2018-06-09 00:00:00'),(60,38,'2018-08-07 00:00:00'),(61,15,'2018-03-02 00:00:00'),(61,25,'2018-06-10 00:00:00'),(61,39,'2018-08-08 00:00:00'),(62,16,'2018-03-03 00:00:00'),(62,26,'2018-06-11 00:00:00'),(62,40,'2018-08-09 00:00:00'),(63,17,'2018-03-04 00:00:00'),(63,27,'2018-06-12 00:00:00'),(63,41,'2018-08-10 00:00:00'),(64,18,'2018-03-05 00:00:00'),(64,28,'2018-06-13 00:00:00'),(64,42,'2018-08-11 00:00:00'),(65,19,'2018-03-06 00:00:00'),(65,29,'2018-06-14 00:00:00'),(65,43,'2018-08-12 00:00:00'),(66,20,'2018-03-07 00:00:00'),(66,30,'2018-06-15 00:00:00'),(66,44,'2018-08-13 00:00:00'),(67,21,'2018-03-08 00:00:00'),(67,31,'2018-06-16 00:00:00'),(67,45,'2018-08-14 00:00:00'),(68,1,'2018-08-15 00:00:00'),(68,22,'2018-03-09 00:00:00'),(68,32,'2018-06-17 00:00:00'),(69,2,'2018-08-16 00:00:00'),(69,23,'2018-03-10 00:00:00'),(69,33,'2018-06-18 00:00:00'),(70,3,'2018-08-17 00:00:00'),(70,24,'2018-03-11 00:00:00'),(70,34,'2018-06-19 00:00:00'),(71,4,'2018-08-18 00:00:00'),(71,25,'2018-03-12 00:00:00'),(71,35,'2018-06-20 00:00:00'),(72,5,'2018-08-19 00:00:00'),(72,26,'2018-03-13 00:00:00'),(72,36,'2018-06-21 00:00:00'),(73,6,'2018-08-20 00:00:00'),(73,27,'2018-03-14 00:00:00'),(73,37,'2018-06-22 00:00:00'),(74,7,'2018-08-21 00:00:00'),(74,28,'2018-03-15 00:00:00'),(74,38,'2018-06-23 00:00:00'),(75,8,'2018-08-22 00:00:00'),(75,29,'2018-03-16 00:00:00'),(75,39,'2018-06-24 00:00:00'),(76,9,'2018-08-23 00:00:00'),(76,30,'2018-03-17 00:00:00'),(76,40,'2018-06-25 00:00:00'),(77,10,'2018-08-24 00:00:00'),(77,31,'2018-03-18 00:00:00'),(77,41,'2018-06-26 00:00:00'),(78,11,'2018-08-25 00:00:00'),(78,32,'2018-03-19 00:00:00'),(78,42,'2018-06-27 00:00:00'),(79,12,'2018-08-26 00:00:00'),(79,33,'2018-03-20 00:00:00'),(79,43,'2018-06-28 00:00:00'),(80,13,'2018-08-27 00:00:00'),(80,34,'2018-03-21 00:00:00'),(80,44,'2018-06-29 00:00:00'),(81,14,'2018-08-28 00:00:00'),(81,35,'2018-03-22 00:00:00'),(81,45,'2018-06-30 00:00:00'),(82,1,'2018-07-01 00:00:00'),(82,15,'2018-08-29 00:00:00'),(82,36,'2018-03-23 00:00:00'),(83,2,'2018-07-02 00:00:00'),(83,16,'2018-08-30 00:00:00'),(83,37,'2018-03-24 00:00:00'),(84,3,'2018-07-03 00:00:00'),(84,17,'2018-08-31 00:00:00'),(84,38,'2018-03-25 00:00:00'),(85,4,'2018-07-04 00:00:00'),(85,18,'2018-09-01 00:00:00'),(85,39,'2018-03-26 00:00:00'),(86,5,'2018-07-05 00:00:00'),(86,19,'2018-09-02 00:00:00'),(86,40,'2018-03-27 00:00:00'),(87,6,'2018-07-06 00:00:00'),(87,20,'2018-09-03 00:00:00'),(87,41,'2018-03-28 00:00:00'),(88,7,'2018-07-07 00:00:00'),(88,21,'2018-09-04 00:00:00'),(88,42,'2018-03-29 00:00:00'),(89,8,'2018-07-08 00:00:00'),(89,22,'2018-09-05 00:00:00'),(89,43,'2018-03-30 00:00:00'),(90,9,'2018-07-09 00:00:00'),(90,23,'2018-09-06 00:00:00'),(90,44,'2018-03-31 00:00:00'),(91,10,'2018-07-10 00:00:00'),(91,24,'2018-09-07 00:00:00'),(91,45,'2018-04-01 00:00:00'),(92,1,'2018-04-02 00:00:00'),(92,11,'2018-07-11 00:00:00'),(92,25,'2018-09-08 00:00:00'),(93,2,'2018-04-03 00:00:00'),(93,12,'2018-07-12 00:00:00'),(93,26,'2018-09-09 00:00:00'),(94,3,'2018-04-04 00:00:00'),(94,13,'2018-07-13 00:00:00'),(94,27,'2018-09-10 00:00:00'),(95,4,'2018-04-05 00:00:00'),(95,14,'2018-07-14 00:00:00'),(95,28,'2018-09-11 00:00:00'),(96,5,'2018-04-06 00:00:00'),(96,15,'2018-07-15 00:00:00'),(96,29,'2018-09-12 00:00:00'),(97,6,'2018-04-07 00:00:00'),(97,16,'2018-07-16 00:00:00'),(98,7,'2018-04-08 00:00:00'),(98,17,'2018-07-17 00:00:00'),(99,8,'2018-04-09 00:00:00'),(99,18,'2018-07-18 00:00:00'),(100,9,'2018-04-10 00:00:00'),(100,19,'2018-07-19 00:00:00');
/*!40000 ALTER TABLE `Subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Teachers`
--

DROP TABLE IF EXISTS `Teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Teachers` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '  \n',
  `salary` int(10) unsigned DEFAULT NULL COMMENT '  ',
  `age` int(10) unsigned DEFAULT NULL COMMENT ' ',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Teachers`
--

LOCK TABLES `Teachers` WRITE;
/*!40000 ALTER TABLE `Teachers` DISABLE KEYS */;
INSERT INTO `Teachers` VALUES (1,'Peck Isaiah',10000,18),(2,'Fitzpatrick Gabriel',20000,19),(3,'Randolph Louis',30000,20),(4,'Cantu Marisa',5000,21),(5,'Villa Ralph',2000,22),(6,'Michael Rachel',3000,23),(7,'Michael Sylvia',4000,24),(8,'Donovan Winifred',6000,25),(9,'Boyle Zoe',7500,26),(10,'Mayer Seth',8500,27),(11,'Walls Roger',10000,28),(12,'Giles Ralph',20000,29),(13,'Zuniga Owen',30000,30),(14,'Pineda Paige',5000,31),(15,'Mays Penelope',2000,32),(16,'McMillan Olivia',3000,33),(17,'Crosby Abraham',4000,34),(18,'Hurley Allison',6000,35),(19,'Frederick Brandon',7500,36),(20,'Ayers Jeffery',8500,37),(21,'Case Connor',10000,38),(22,'Bentley Caroline',20000,39),(23,'Shepard Francis',30000,40),(24,'Everett Antonio',5000,41),(25,'Dunlap Fred',2000,42),(26,'McMahon Danielle',3000,43),(27,'Bender Oswald',4000,18),(28,'Hahn Nathan',6000,19),(29,'Harding Miguel',7500,20),(30,'Acevedo Cecilia',8500,21),(31,'Raymond Nora',10000,22),(32,'Blackburn Arianna',20000,23),(33,'Duffy Amber',30000,24),(34,'Landry Devin',5000,25),(35,'Dougherty Monica',2000,26),(36,'Bautista Neil',3000,27),(37,'Shah Matthew',4000,28),(38,'Potts Evelyn',6000,29),(39,'Valentine Christian',7500,30),(40,'Vaughan Thomas',8500,31),(41,'Avery Sierra',10000,32),(42,'Herring Curtis',20000,33),(43,'Clements Roger',30000,34),(44,'Bean Gerld',5000,35),(45,'Lynn Ethan',2000,36),(46,'Benton Ralph',3000,37),(47,'Blevins Steven',4000,38),(48,'Moses Dorothy',6000,39),(49,'Blanchard Fred',7500,40),(50,'Rivers Christopher',8500,41);
/*!40000 ALTER TABLE `Teachers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-22 16:54:13
