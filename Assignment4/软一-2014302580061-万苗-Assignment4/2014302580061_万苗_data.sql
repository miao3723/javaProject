-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: assignment
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `2014302580061_professor_info`
--

DROP TABLE IF EXISTS `2014302580061_professor_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `2014302580061_professor_info` (
  `id` smallint(6) NOT NULL AUTO_INCREMENT,
  `teachername` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `introduction` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `2014302580061_professor_info`
--

LOCK TABLES `2014302580061_professor_info` WRITE;
/*!40000 ALTER TABLE `2014302580061_professor_info` DISABLE KEYS */;
INSERT INTO `2014302580061_professor_info` VALUES (5,'Micha Hofri','hofri@wpi.edu','Professor, Computer Science'),(11,'Neil T. Heffernan','nth@wpi.edu','Director Learning Sciences & Technologies Professor, Computer Science Affiliated with: Interactive Media & Game Development Learning Sciences and Technologies'),(13,'Charles Rich','rich@wpi.edu','Professor, Computer Science Affiliated with: Interactive Media & Game Development Learning Sciences and Technologies Robotics Engineering'),(15,'David C. Brown','dcb@wpi.edu','Professor, Computer Science Affiliated with: Learning Sciences and Technologies Mechanical Engineering Professor, Mechanical Engineering Associated Faculty, Learning Sciences'),(17,'Joshua D. Guttman','guttman@wpi.edu','Professor, Computer Science Affiliated with: Cybersecurity'),(28,'Robert W. Lindeman','gogo@wpi.edu','Director, Interactive Media & Game Development Associate Professor, Computer Science Affiliated with: Interactive Media & Game Development Learning Sciences and Technologies Robotics Engineering Director, Human Interaction in Virtual Environments (HIVE) Lab Director, Japan Project Center'),(30,'Mohamed Eltabakh','meltabakh@wpi.edu','Assistant Professor, Computer Science Affiliated with: Bioinformatics and Computational Biology Data Science'),(31,'Carolina Ruiz','ruiz@wpi.edu','Associate Professor, Computer Science Affiliated with: Bioinformatics and Computational Biology Data Science Learning Sciences and Technologies'),(32,'Elke Angelika Rundensteiner','rundenst@wpi.edu','Director of Data Science Professor, Computer Science Affiliated with: Bioinformatics and Computational Biology Data Science'),(35,'Kathi Fisler','kfisler@wpi.edu','Professor, Computer Science Affiliated with: Cybersecurity Learning Sciences and Technologies London IQP Center, D12 (advisor) Zurich IQP Center, A15 (advisor)'),(44,'Krishna Kumar Venkatasubramanian','kven@wpi.edu','Assistant Professor, Computer Science Affiliated with: Cybersecurity'),(45,'Joseph Beck','josephbeck@wpi.edu','Associate Professor, Computer Science Affiliated with: Learning Sciences and Technologies'),(47,'Emmanuel O. Agu','emmanuel@wpi.edu','Associate Professor, Computer Science Affiliated with: Bioinformatics and Computational Biology Interactive Media & Game Development Coordinator, Mobile Graphics Research Group'),(48,'Mark Claypool','claypool@wpi.edu','Professor, Computer Science Affiliated with: Interactive Media & Game Development'),(49,'Candace L. Sidner','sidner@wpi.edu','Research Professor, Computer Science Affiliated with: Robotics Engineering'),(52,'Bob Kinicki','rek@wpi.edu','Professor, Computer Science Affiliated with: Bioinformatics and Computational Biology Electrical & Computer Engineering'),(53,'Craig A. Shue','cshue@wpi.edu','Assistant Professor, Computer Science Affiliated with: Cybersecurity Co-Director, MITRE Project Center'),(55,'Craig Wills','cew@wpi.edu','Department Head Professor, Computer Science Affiliated with: Cybersecurity'),(56,'George T. Heineman','heineman@wpi.edu','Associate Professor, Computer Science Affiliated with: Learning Sciences and Technologies'),(58,'David Finkel','dfinkel@wpi.edu','Professor, Computer Science Affiliated with: Interactive Media & Game Development Associate Department Head, Computer Science Director, Microsoft Project Center Director, Silicon Valley Project Center'),(66,'Gary F. Pollice','gpollice@wpi.edu','Professor, Computer Science'),(67,'Dmitry Berenson','dberenson@wpi.edu','Assistant Professor, Computer Science Affiliated with: Professor, Robotics Engineering'),(68,'Sonia Chernova','soniac@wpi.edu','Assistant Professor, Computer Science'),(69,'Michael A. Gennert','michaelg@wpi.edu','Director, Robotics Engineering Professor, Computer Science Affiliated with: Electrical & Computer Engineering'),(70,'Charles Rich','rich@wpi.edu','Professor, Computer Science Affiliated with: Interactive Media & Game Development Learning Sciences and Technologies Robotics Engineering'),(73,'Daniel J. Dougherty','dd@wpi.edu','Professor, Computer Science Affiliated with: Cybersecurity');
/*!40000 ALTER TABLE `2014302580061_professor_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-19  9:01:23
