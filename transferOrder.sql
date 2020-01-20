-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: transferOrder
-- ------------------------------------------------------
-- Server version	8.0.18

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

--
-- Table structure for table `adminuser`
--

DROP TABLE IF EXISTS `adminuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adminuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `adminUser` varchar(20) NOT NULL,
  `password` char(68) NOT NULL,
  `perm` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `adminuser_adminUser_uindex` (`adminUser`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminuser`
--

LOCK TABLES `adminuser` WRITE;
/*!40000 ALTER TABLE `adminuser` DISABLE KEYS */;
INSERT INTO `adminuser` VALUES (1,'admin','{bcrypt}$2a$10$kGiuLyN//iXEixL1YCHGsOgePeQ5Ss3LttvqsUnd9XVyM5sXarksi','ROLE_admin,ROLE_base,ROLE_service,ROLE_check'),(2,'base_li','{bcrypt}$2a$10$VdK5//OGZkiLt7XV8euD7Oiu.fr0GOW6328NH1TeHs3YiTP7d801i','ROLE_base'),(3,'serveice_zhang','{bcrypt}$2a$10$WSnO4pkM4SevkIESLKs7IO6M/.Iwf8nY0ewjakqneCYlYhroFNDVi','ROLE_service'),(4,'check_chen','{bcrypt}$2a$10$RE.3Ub0HPxk0wPD8JgbcJeeL16s4fBOcae7Sc.ejRSfSfe7QGP11e','ROLE_check'),(6,'check_sun','{bcrypt}$2a$10$DMsxvxJJXoPKKS9Al/ydEu3KxLBHwFPNpdc2YLlIz2cAxf9kOsmge','ROLE_check'),(12,'service_hu','{bcrypt}$2a$10$h02TPuqGMaSGhbgXXI.r0./JZYYYHDk34g/VZnh9VutTni3nl771C','ROLE_admin,ROLE_base,ROLE_service,ROLE_check');
/*!40000 ALTER TABLE `adminuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `NameZh` varchar(50) NOT NULL,
  `NameEn` varchar(50) NOT NULL,
  `nameSp` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `blankId` char(16) NOT NULL,
  `blank` varchar(20) DEFAULT NULL,
  `companyCode` int(8) DEFAULT NULL,
  `province` char(5) NOT NULL,
  `city` char(20) NOT NULL,
  UNIQUE KEY `client_pk` (`companyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('大连什么公司','dalianshenme','大神','123@163.com','1234569632587523','中国银行',12345678,'辽宁','大连'),('北京海运','baijinghaiyun','北海运','33@bei.com','1234567891234567','中国银行',32165487,'北京','北京'),('大连那啥公司','daliannasha','大拿','124@163.com','1234569632588763','中国银行',12345668,'辽宁','大连'),('上海的公司','shgs','上攻','e@e.com','1234564876452341','汇丰银行',12343212,'上海','上海'),('中国第一公司','chinano1','中一','12@cn.cn','1234567891234589','中国建设银行',58746932,'北京','北京'),('张策公司','zcc','zhangce','ce@edu.cn','1234567891234567','中国银行',85697423,'河北','保定');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contactman`
--

DROP TABLE IF EXISTS `contactman`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contactman` (
  `name` varchar(10) DEFAULT NULL,
  `title` varchar(10) DEFAULT NULL,
  `phone` char(11) DEFAULT NULL,
  `tax` int(7) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `company` int(8) NOT NULL,
  `employeeId` int(6) NOT NULL,
  PRIMARY KEY (`company`,`employeeId`),
  CONSTRAINT `contactman_client_companyCode_fk` FOREIGN KEY (`company`) REFERENCES `client` (`companyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contactman`
--

LOCK TABLES `contactman` WRITE;
/*!40000 ALTER TABLE `contactman` DISABLE KEYS */;
INSERT INTO `contactman` VALUES ('胜利','大中华负责人','13232325656',685479,'12@cn.cn',12343212,198657),('前二','董事长','13835352626',875421,'123@123.com',12343212,362541),('汉姆','财务','18282829563',778854,'lais@gmail.com',12345668,665541),('王十二','秘书','13838465987',884563,'qwe@de.cn',12345668,665542),('王二','经理','12654896562',663725,'22@163.com',32165487,123456),('赵武','经理','13232325678',256484,'2233@162.com',32165487,362541),('十三娘','总监','13236528547',1236547,'12@12.com',58746932,188745),('张策','CEO','15133229977',152643,'zcc@edu.cn',85697423,100001);
/*!40000 ALTER TABLE `contactman` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `forder`
--

DROP TABLE IF EXISTS `forder`;
/*!50001 DROP VIEW IF EXISTS `forder`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `forder` AS SELECT 
 1 AS `NameZh`,
 1 AS `orderId`,
 1 AS `sprovince`,
 1 AS `scity`,
 1 AS `rprovince`,
 1 AS `rcity`,
 1 AS `sphone`,
 1 AS `semail`,
 1 AS `receive`,
 1 AS `rphone`,
 1 AS `remail`,
 1 AS `check`,
 1 AS `send`,
 1 AS `time`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `good`
--

DROP TABLE IF EXISTS `good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `good` (
  `goodID` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `expiry` int(3) DEFAULT NULL,
  `temperature` int(3) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `mass` int(5) DEFAULT NULL,
  `packages` varchar(10) DEFAULT NULL,
  `length` int(4) DEFAULT NULL,
  `width` int(4) DEFAULT NULL,
  `height` int(4) DEFAULT NULL,
  `unit` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`goodID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `good`
--

LOCK TABLES `good` WRITE;
/*!40000 ALTER TABLE `good` DISABLE KEYS */;
INSERT INTO `good` VALUES (1,'苹果',180,25,'水果',5,'箱子',50,50,20,'kg'),(4,'梨',120,25,'水果',6,'箱子',50,25,25,'kg'),(6,'床',999999,25,'家具',200,'货车',300,200,100,'m'),(7,'手机',99999,20,'数码',500,'盒子',30,10,1,'cm'),(8,'羽绒服',9999,30,'其他',60,'15',100,50,60,'cm'),(9,'电脑',730,20,'数码',2,'箱',50,40,2,'cm'),(10,'skII',180,15,'美妆',180,'盒子',20,10,11,'ml'),(11,'鼠标',999,25,'数码',250,'盒子',10,5,5,'g');
/*!40000 ALTER TABLE `good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `orderId` char(10) NOT NULL,
  `client` int(8) NOT NULL,
  `send` varchar(10) NOT NULL,
  `sphone` char(11) NOT NULL DEFAULT '',
  `semail` varchar(20) DEFAULT NULL,
  `sprovince` char(5) NOT NULL,
  `scity` char(8) NOT NULL,
  `receive` varchar(10) NOT NULL,
  `rphone` char(11) NOT NULL DEFAULT '',
  `remail` varchar(20) DEFAULT NULL,
  `rprovince` char(5) NOT NULL,
  `rcity` char(8) DEFAULT NULL,
  `time` date NOT NULL,
  `check` longtext,
  PRIMARY KEY (`orderId`),
  UNIQUE KEY `order_orderId_uindex` (`orderId`),
  KEY `order_client_companyCode_fk` (`client`),
  CONSTRAINT `order_client_companyCode_fk` FOREIGN KEY (`client`) REFERENCES `client` (`companyCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES ('a2ed18c8',12345668,'三十九','18723654987','15326@kk.com','北京','北京','九十七','19739393737','sdy@mail.com','河南','郑州市','2019-12-24','提交'),('b60366c7',12345668,'三三','12231231232','we@wewewe.cn','山西','太原','陈十八','15252525252','sdy@mail.com','四川','成都','2019-12-24',NULL),('cd372d8c',85697423,'二十七','12334523412','15326@kk.com','北京','北京','八十八','18888888888','88@88.com','河南','安阳市','2019-12-25',NULL),('cebafbfc',32165487,'找潜力','12334523412','15326@kk.com','陕西','咸阳','孙六六','12334234121','wwwwe@we.com','四川','成都','2019-12-24','未通过'),('dbf27036',12345678,'刘六','13838383833','12@li.com','北京','北京','陈十八','15252525252','we@we.com','河南','郑州市','2019-12-21','审核'),('e7744233',12345678,'二十七','13838383833','12@li.com','辽宁','旅顺','张思','15252525252','we@we.com','西藏','呼和浩特','2019-12-24','审核'),('ff47403a',12343212,'as','12334523412','15326@kk.com','贵州','铜仁地区','九十七','12423421232','wwwwe@we.com','北京','北京','2019-12-25',NULL),('sd123124',12343212,'sas','sdas','das','sdasd','dasd','das','adsas','vsd','sad','dasd','2019-12-25',NULL),('sf123123',12345678,'老王','12365488567','123@qw.com','辽宁','大连','李氏','13832266544','li@mial.com','上海','上海','2019-12-25','审核');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_good`
--

DROP TABLE IF EXISTS `order_good`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_good` (
  `orderID` char(10) NOT NULL,
  `goodID` int(10) NOT NULL,
  `num` int(5) DEFAULT NULL,
  UNIQUE KEY `order-good_pk` (`orderID`,`goodID`),
  KEY `order_good_good_goodID_fk` (`goodID`),
  CONSTRAINT `order-good_order_orderId_fk` FOREIGN KEY (`orderID`) REFERENCES `order` (`orderId`),
  CONSTRAINT `order_good_good_goodID_fk` FOREIGN KEY (`goodID`) REFERENCES `good` (`goodID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_good`
--

LOCK TABLES `order_good` WRITE;
/*!40000 ALTER TABLE `order_good` DISABLE KEYS */;
INSERT INTO `order_good` VALUES ('a2ed18c8',4,3333),('cd372d8c',10,4),('cebafbfc',1,11),('cebafbfc',11,222),('dbf27036',6,15),('e7744233',1,3),('sf123123',4,5),('sf123123',7,99);
/*!40000 ALTER TABLE `order_good` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `forder`
--

/*!50001 DROP VIEW IF EXISTS `forder`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `forder` AS select `client`.`NameZh` AS `NameZh`,`order`.`orderId` AS `orderId`,`order`.`sprovince` AS `sprovince`,`order`.`scity` AS `scity`,`order`.`rprovince` AS `rprovince`,`order`.`rcity` AS `rcity`,`order`.`sphone` AS `sphone`,`order`.`semail` AS `semail`,`order`.`receive` AS `receive`,`order`.`rphone` AS `rphone`,`order`.`remail` AS `remail`,`order`.`check` AS `check`,`order`.`send` AS `send`,`order`.`time` AS `time` from (`client` join `order`) where (`client`.`companyCode` = `order`.`client`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-25 22:45:59
