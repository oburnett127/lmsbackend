/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `lms` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `lms`;
DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
                           `accountid` int NOT NULL AUTO_INCREMENT,
                           `email` varchar(100) NOT NULL,
                           `phone` varchar(10) NOT NULL,
                           `first_name` varchar(20) NOT NULL,
                           `last_name` varchar(20) NOT NULL,
                           `password` varchar(30) NOT NULL,
                           `is_admin` bit(1) NOT NULL,
                           `is_author` bit(1) NOT NULL,
                           PRIMARY KEY (`accountid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'fake@fakeemail.com','ralph','jones','123',_binary '\0');
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
                        `accountid` int NOT NULL,
                        `productid` int NOT NULL,
                        PRIMARY KEY (`accountid`,`productid`),
                        KEY `cart_product_id_fk` (`productid`),
                        CONSTRAINT `cart_account_accountid_fk` FOREIGN KEY (`accountid`) REFERENCES `account` (`accountid`),
                        CONSTRAINT `cart_product_id_fk` FOREIGN KEY (`productid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (1,1);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'coffee maker','makes good stuff','20.99',5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase` (
                            `purchaseid` int NOT NULL AUTO_INCREMENT,
                            `accountid` int NOT NULL,
                            `purchase_date` varchar(8) NOT NULL,
                            `bill_first_name` varchar(50) NOT NULL,
                            `bill_last_name` varchar(50) NOT NULL,
                            `billing_address` varchar(100) NOT NULL,
                            `credit_card_expdate` varchar(4) NOT NULL,
                            `credit_card_pin` varchar(3) NOT NULL,
                            `credit_card_num` varchar(16) NOT NULL,
                            `credit_card_name` varchar(100) NOT NULL,
                            PRIMARY KEY (`purchaseid`),
                            KEY `purchase_account_accountid_fk` (`accountid`),
                            CONSTRAINT `purchase_account_accountid_fk` FOREIGN KEY (`accountid`) REFERENCES `account` (`accountid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;
DROP TABLE IF EXISTS `purchasedetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchasedetails` (
                                   `purchaseid` int NOT NULL,
                                   `productid` varchar(10) NOT NULL,
                                   `quantity` varchar(10) NOT NULL,
                                   PRIMARY KEY (`purchaseid`,`productid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `purchasedetails` WRITE;
/*!40000 ALTER TABLE `purchasedetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchasedetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;