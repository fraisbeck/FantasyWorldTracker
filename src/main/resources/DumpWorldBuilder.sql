CREATE DATABASE  IF NOT EXISTS `worldbuilder` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `worldbuilder`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: worldbuilder
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `continents`
--

DROP TABLE IF EXISTS `continents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `continents` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `name` varchar(45) NOT NULL,
                              `world_id` int NOT NULL,
                              PRIMARY KEY (`id`),
                              KEY `idworlds_idx` (`world_id`),
                              CONSTRAINT `world_id` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `continents`
--

LOCK TABLES `continents` WRITE;
/*!40000 ALTER TABLE `continents` DISABLE KEYS */;
INSERT INTO `continents` VALUES (1,'Marquet',2),(2,'Wildemount',2),(3,'Aeor',2),(4,'Klahan',1),(5,'Placon',1),(6,'Atayend',1),(7,'Candia',3),(8,'Auegfort',3);
/*!40000 ALTER TABLE `continents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventories`
--

DROP TABLE IF EXISTS `inventories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventories` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `shop_id` int NOT NULL,
                               `item_id` int NOT NULL,
                               `quantity` int NOT NULL,
                               `price` int NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `iditems_idx` (`item_id`),
                               KEY `idshops_idx` (`shop_id`),
                               CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `items` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                               CONSTRAINT `shop_id` FOREIGN KEY (`shop_id`) REFERENCES `shops` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventories`
--

LOCK TABLES `inventories` WRITE;
/*!40000 ALTER TABLE `inventories` DISABLE KEYS */;
INSERT INTO `inventories` VALUES (1,8,1,2,100),(2,8,2,1,500),(3,8,3,3,600),(4,8,5,1,750),(5,8,8,2,400),(6,2,9,1,500),(7,2,6,1,860),(8,2,3,2,750),(9,2,8,3,950),(10,2,9,1,250),(11,5,7,2,100),(12,5,4,6,500),(13,9,4,9,200),(14,9,7,15,100),(15,10,2,1,100),(16,10,1,3,500),(17,10,3,1,450),(18,10,9,2,350),(19,10,3,1,1000);
/*!40000 ALTER TABLE `inventories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL COMMENT 'name of the item',
                         `rarity` varchar(45) NOT NULL COMMENT 'the rarity of the item',
                         `category` varchar(45) NOT NULL COMMENT 'the catagory of item it is listed as',
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=194 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'Shortsword','Uncommon','Shortsword'),(2,'Warhammer + 1','Rare','Mace'),(3,'Shield of Arrow Catching','Rare','Shield'),(4,'Diamond','Epic','Gemstone'),(5,'Razors Edge','Epic','Longsword'),(6,'Spike','Wonderous','Longsword'),(7,'Ruby','Uncommon','Gemstone'),(8,'Tower Shield of Heaven','Legendary','Shield'),(9,'Glimmering Robe','Uncommon','Robe');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `name` varchar(45) NOT NULL COMMENT 'name of the location',
                             `region_id` int NOT NULL COMMENT 'the region the location is in',
                             `world_id` int NOT NULL,
                             PRIMARY KEY (`id`),
                             KEY `regionId_idx` (`region_id`),
                             KEY `world_id_idx` (`world_id`),
                             CONSTRAINT `region_id` FOREIGN KEY (`region_id`) REFERENCES `regions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                             CONSTRAINT `world_id_location` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,'Moongulf',2,2),(2,'Goldvalley',3,1),(3,'Faypond',4,1),(4,'Bayshell',4,1),(5,'Kilburn',1,2),(6,'Limegate',7,2),(7,'Brinehelm',6,1);
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owners`
--

DROP TABLE IF EXISTS `owners`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `owners` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `first_name` varchar(45) NOT NULL,
                          `last_name` varchar(45) NOT NULL,
                          `profession` varchar(45) NOT NULL,
                          `world_id` int NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `world_id_owner_idx` (`world_id`),
                          CONSTRAINT `world_id_owner` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=198 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owners`
--

LOCK TABLES `owners` WRITE;
/*!40000 ALTER TABLE `owners` DISABLE KEYS */;
INSERT INTO `owners` VALUES (1,'Pyrravyn','Zinlynn','Enchanter',1),(2,'Druindar','Quidan','Jewler',2),(3,'Orist','Fentris','Smith',1),(4,'Cody','Trixster','Enchanter',3),(5,'Gibson','Zinlynn','Smith',2),(6,'Smebbniss','Orion','Jewler',2),(7,'Tulbeg','Lucielle','Enchanter',2),(8,'Jebebnast','Cobbelpot','Smith',2);
/*!40000 ALTER TABLE `owners` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `regions`
--

DROP TABLE IF EXISTS `regions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `regions` (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `name` varchar(45) NOT NULL,
                           `continent_id` int NOT NULL,
                           `world_id` int NOT NULL,
                           PRIMARY KEY (`id`),
                           KEY `idcontinent_idx` (`continent_id`),
                           KEY `world_id_regions_idx` (`world_id`),
                           CONSTRAINT `continent_id` FOREIGN KEY (`continent_id`) REFERENCES `continents` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                           CONSTRAINT `world_id_regions` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=191 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regions`
--

LOCK TABLES `regions` WRITE;
/*!40000 ALTER TABLE `regions` DISABLE KEYS */;
INSERT INTO `regions` VALUES (1,'Segra',2,2),(2,'Othua',2,2),(3,'Dral Gror',5,1),(4,'Prainia',4,1),(5,'Ubluasia',7,3),(6,'Butrus',4,1),(7,'Eglus',1,2);
/*!40000 ALTER TABLE `regions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shops`
--

DROP TABLE IF EXISTS `shops`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shops` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `name` varchar(45) NOT NULL COMMENT 'the name of the shop',
                         `shopcategory` varchar(45) NOT NULL COMMENT 'what type of shop this location is',
                         `location_id` int NOT NULL COMMENT 'where the shop is located',
                         `owner_id` int NOT NULL COMMENT 'who owns this shop.',
                         `world_id` int NOT NULL,
                         PRIMARY KEY (`id`),
                         KEY `idowner_idx` (`owner_id`),
                         KEY `location_id_idx` (`location_id`),
                         KEY `world_id_idx` (`world_id`),
                         CONSTRAINT `location_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                         CONSTRAINT `owner_id` FOREIGN KEY (`owner_id`) REFERENCES `owners` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
                         CONSTRAINT `world_id_shops` FOREIGN KEY (`world_id`) REFERENCES `worlds` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=195 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='list of all shops in your world';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shops`
--

LOCK TABLES `shops` WRITE;
/*!40000 ALTER TABLE `shops` DISABLE KEYS */;
INSERT INTO `shops` VALUES (1,'The Rare Quill','Magic',3,4,1),(2,'The Mirror Image','Magic',4,1,1),(3,'The Best Defense','Armory',3,3,1),(4,'Home Sewn','Tailor',7,3,2),(5,'The Broken Stone','Jewlery',5,2,2),(6,'Basic Coin','General',1,2,2),(7,'Patches and Buttons','Tailor',5,5,2),(8,'Steel and Mortar','Armory',1,5,2),(9,'Forevery Gems','Jewlery',6,6,2),(10,'The Enchanted Arcanum','Magic',6,7,2),(11,'Angered Anvil','Armory',6,8,2),(12,'Osiria','Jewlery',6,6,2);
/*!40000 ALTER TABLE `shops` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(45) NOT NULL,
                        `last_name` varchar(45) NOT NULL,
                        `user_name` varchar(45) NOT NULL,
                        `password` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Jennifer','Scott','jscott','first'),(2,'Joe','Louise','jlouise','second'),(3,'Katie','Fiora','kfiroa','third');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worlds`
--

DROP TABLE IF EXISTS `worlds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `worlds` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `name` varchar(45) NOT NULL,
                          `user_id` int NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `user_id_idx` (`user_id`),
                          CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worlds`
--

LOCK TABLES `worlds` WRITE;
/*!40000 ALTER TABLE `worlds` DISABLE KEYS */;
INSERT INTO `worlds` VALUES (1,'Ultaria',1),(2,'Exandria',1),(3,'Spire',3);
/*!40000 ALTER TABLE `worlds` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-14 18:18:41
