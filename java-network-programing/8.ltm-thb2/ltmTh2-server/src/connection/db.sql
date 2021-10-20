/**
 * Author:  nddmanh
 * Created: Oct 21, 2021
 */

-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: localhost    Database: th2-ltm
-- ------------------------------------------------------
-- Server version	8.0.24

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `congnhan`
--

DROP TABLE IF EXISTS `congnhan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `congnhan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `hoten` varchar(50) NOT NULL,
  `namsinh` varchar(50) NOT NULL,
  `gioitinh` varchar(50) NOT NULL,
  `quequanid` int NOT NULL,
  `hs` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `quequanid` (`quequanid`),
  CONSTRAINT `congnhan_ibfk_1` FOREIGN KEY (`quequanid`) REFERENCES `quequan` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `congnhan`
--

LOCK TABLES `congnhan` WRITE;
/*!40000 ALTER TABLE `congnhan` DISABLE KEYS */;
INSERT INTO `congnhan` VALUES (1,'Manh','2000','Nam',1,'1'),(2,'manh1','1222','Nu',4,'2'),(3,'nam','2222','Nam',2,'12'),(4,'Long','1444','Nam',3,'12'),(5,'Thanh','2333','Nam',3,'123'),(6,'Long22','123','Nam',4,'1222223');
/*!40000 ALTER TABLE `congnhan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quequan`
--

DROP TABLE IF EXISTS `quequan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quequan` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tinh` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quequan`
--

LOCK TABLES `quequan` WRITE;
/*!40000 ALTER TABLE `quequan` DISABLE KEYS */;
INSERT INTO `quequan` VALUES (1,'Ha Noi'),(2,'Thai Binh'),(3,'Nam Dinh'),(4,'Ha Nam');
/*!40000 ALTER TABLE `quequan` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-21  1:55:06
