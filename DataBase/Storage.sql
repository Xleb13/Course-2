-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: storage
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id_customer` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `payment_details` varchar(45) NOT NULL,
  `date_of_birthday` date NOT NULL,
  `gender` varchar(7) NOT NULL,
  PRIMARY KEY (`id_customer`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Михал Палыч','798026742','old_young@outlook.com','1846521251','1968-02-11','Male'),(2,'Жак Фреско','791523541','scincebr@gmail.com','275945216','1999-07-22','Male'),(3,'Марко Поло','928341058','mark2@gmial.com','1452142545','1980-01-30','Male'),(4,'Николаевич','2434052','nikola777@yandex.ru','1465192546965','1967-12-28','Male'),(57,'GigachadBigFloppa','79205460893','BigFloppa@yandex.ru','1452142545','1999-11-11','Male');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `price` int NOT NULL,
  `categories` varchar(45) NOT NULL,
  `count` int NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Видеокарта Asus GTX 1650 4Gb',17650,'PCcomponents',13),(2,'Процессор AMD 5 2600 OEM',8250,'PCcomponents',4),(3,'Apple Iphone 14 256gb',74200,'SmartPhones',22),(4,'OnePlus 10Pro 256Gb',60990,'SmartPhones',17),(5,'Робот пылесос Xiaomi',13750,'Appilance',6),(6,'Камера видеонаблюдения',1820,'ProtectiveSystem',42),(7,'Дисплей Redmi note 11',7200,'SpareParts',8),(8,'Двигатель для стиральной машины Bosh 1782',11250,'SpareParts',3),(10,'Palit Nvidia RTX 4090 16GB',99000,'PCcomponents',100),(11,'Xiaomi Redmi Note 11Pro 256/8 Gb',17250,'SmartPhones',42);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stockworkers`
--

DROP TABLE IF EXISTS `stockworkers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stockworkers` (
  `id_worker` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone_numbers` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `job_title` varchar(45) NOT NULL,
  PRIMARY KEY (`id_worker`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stockworkers`
--

LOCK TABLES `stockworkers` WRITE;
/*!40000 ALTER TABLE `stockworkers` DISABLE KEYS */;
INSERT INTO `stockworkers` VALUES (1,'Семен','791524563','worker12@yande.ru','Менеджер'),(2,'Александр','742974163','oldsanya@mail.ru','Зам.директора');
/*!40000 ALTER TABLE `stockworkers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `categories` varchar(45) NOT NULL,
  `count` int NOT NULL,
  `id_supplier` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,'Видеокарта Asus GTX 1650 4Gb','PCcomponents',250,1),(2,'Процессор AMD 5 2600 OEM','PCcomponents',35,1),(3,'Apple Iphone 14 256gb','SmartPhones',145,2),(4,'OnePlus 10Pro 256Gb','SmartPhones',25,2),(5,'Робот пылесос Xiaomi','Appilance',44,3),(6,'Камера видеонаблюдения','ProtectiveSystem',785,3),(7,'Дисплей Redmi note 11','SpareParts',45,2),(8,'Двигатель для стиральной машины Bosh 1782','SpareParts',24,2),(9,'Palit Nvidia RTX 4090 16GB','PCcomponents',452,1),(10,'Xiaomi Redmi Note 11Pro 256/8 Gb','SmartPhones',120,2),(11,'Бибки','Appilance',0,2),(12,'asidjao;ijdoa','Appilance',95,3);
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id_supplier` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `phone_number` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `payment_details` varchar(45) NOT NULL,
  `INN` varchar(45) NOT NULL,
  `OGRN` varchar(45) NOT NULL,
  PRIMARY KEY (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (1,'ОАО Outbreaks','749523210','outbreaks_iw@gmail.com','534641035','367621972','103162820'),(2,'OAO Worktech','749552321','worktech@yandex.ru','456123467','546126342','426264561'),(3,'Пал Мамонтыч','79805553535','netouge@bk.com','7915 1235 2142 6245','14525545','464542');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'storage'
--

--
-- Dumping routines for database 'storage'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-27 14:09:57
