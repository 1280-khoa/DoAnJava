-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: doanjava
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `nhapkhothietbi`
--

DROP TABLE IF EXISTS `nhapkhothietbi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhapkhothietbi` (
  `MaTB` int NOT NULL,
  `TenTB` varchar(30) DEFAULT NULL,
  `GiaMua` float DEFAULT NULL,
  `GiaBan` float DEFAULT NULL,
  `SoLuong` int DEFAULT NULL,
  `NgaySanXuat` date DEFAULT NULL,
  `NgayNhap` date DEFAULT NULL,
  `NhaCungCap` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`MaTB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhapkhothietbi`
--

LOCK TABLES `nhapkhothietbi` WRITE;
/*!40000 ALTER TABLE `nhapkhothietbi` DISABLE KEYS */;
INSERT INTO `nhapkhothietbi` VALUES (111,'Máy Khoan',1600000,2000000,10,'2012-05-25','2021-06-30','TNHH Nguyễn Thành Nam'),(123,'Máy Cưa',50000,50000,35,'2019-02-22','2020-12-20','TNHH Máy Móc Thành Phát'),(125,'Đinh',15000,15000,110,'2021-12-02','2022-01-15','Hà Nội'),(128,'Máy Hàn',800000,1000000,0,'2017-09-24','2019-04-05','Vật Liệu Xây Dựng TPHCM');
/*!40000 ALTER TABLE `nhapkhothietbi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-04 22:17:03
