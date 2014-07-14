CREATE DATABASE  IF NOT EXISTS `ready` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ready`;
-- MySQL dump 10.13  Distrib 5.6.13, for osx10.6 (i386)
--
-- Host: 127.0.0.1    Database: ready
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `t_admin_user`
--

DROP TABLE IF EXISTS `t_admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin_user` (
  `adminid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `effective` int(11) NOT NULL DEFAULT '1',
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`adminid`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin_user`
--

LOCK TABLES `t_admin_user` WRITE;
/*!40000 ALTER TABLE `t_admin_user` DISABLE KEYS */;
INSERT INTO `t_admin_user` VALUES (1,'sa','1234',0,'kouhongyu@163.com22'),(6,'test','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(19,'test2','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(20,'test03','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(21,'test04','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(22,'test05','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(23,'test06','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(24,'test07','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(25,'test08','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(26,'test09','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(27,'test10','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(28,'test11','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(29,'test12','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(30,'test13','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(31,'test14','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(32,'test15','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(33,'test16','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(34,'test17','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(35,'test18','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(36,'test19','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(37,'test20','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(38,'test21','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(39,'test22','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(40,'test23','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(41,'test24','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(42,'test25','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(43,'test26','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com'),(44,'test27','098f6bcd4621d373cade4e832627b4f6',1,'test@163.com');
/*!40000 ALTER TABLE `t_admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_role`
--

DROP TABLE IF EXISTS `t_permission_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_role` (
  `roleid` bigint(20) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(100) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `rolename_UNIQUE` (`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_role`
--

LOCK TABLES `t_permission_role` WRITE;
/*!40000 ALTER TABLE `t_permission_role` DISABLE KEYS */;
INSERT INTO `t_permission_role` VALUES (1,'aaa');
/*!40000 ALTER TABLE `t_permission_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_role_Method`
--

DROP TABLE IF EXISTS `t_permission_role_Method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_role_Method` (
  `methodid` bigint(20) NOT NULL,
  `roleid` bigint(20) NOT NULL,
  UNIQUE KEY `un_PERMISSION_ROLE_ACTION` (`methodid`,`roleid`),
  KEY `fk_PERMISSION_ROLE_ACTION_roleid` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_role_Method`
--

LOCK TABLES `t_permission_role_Method` WRITE;
/*!40000 ALTER TABLE `t_permission_role_Method` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_permission_role_Method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_role_menu`
--

DROP TABLE IF EXISTS `t_permission_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_role_menu` (
  `menuid` bigint(20) NOT NULL,
  `roleid` bigint(20) NOT NULL,
  UNIQUE KEY `un_PERMISSION_ROLE_MENU_menuid_roleid` (`menuid`,`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_role_menu`
--

LOCK TABLES `t_permission_role_menu` WRITE;
/*!40000 ALTER TABLE `t_permission_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_permission_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_user_menu`
--

DROP TABLE IF EXISTS `t_permission_user_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_user_menu` (
  `adminid` bigint(20) NOT NULL,
  `menuid` bigint(20) NOT NULL,
  UNIQUE KEY `un_PERMISSION_USER_MENU` (`adminid`,`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_user_menu`
--

LOCK TABLES `t_permission_user_menu` WRITE;
/*!40000 ALTER TABLE `t_permission_user_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_permission_user_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_user_method`
--

DROP TABLE IF EXISTS `t_permission_user_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_user_method` (
  `adminid` bigint(20) NOT NULL,
  `methodid` bigint(20) NOT NULL,
  UNIQUE KEY `un_PERMISSION_USER_ACTION` (`adminid`,`methodid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_user_method`
--

LOCK TABLES `t_permission_user_method` WRITE;
/*!40000 ALTER TABLE `t_permission_user_method` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_permission_user_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_permission_user_role`
--

DROP TABLE IF EXISTS `t_permission_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission_user_role` (
  `ADMINID` bigint(20) NOT NULL,
  `ROLEID` bigint(20) NOT NULL,
  UNIQUE KEY `un_pur_adminid_roleid` (`ROLEID`,`ADMINID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission_user_role`
--

LOCK TABLES `t_permission_user_role` WRITE;
/*!40000 ALTER TABLE `t_permission_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_permission_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resource_menu`
--

DROP TABLE IF EXISTS `t_resource_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_resource_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `menucode` varchar(200) NOT NULL,
  `text` varchar(100) NOT NULL,
  `url` varchar(1000) DEFAULT '',
  `effective` int(11) NOT NULL DEFAULT '1',
  `parameter` varchar(500) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `menucode_UNIQUE` (`menucode`)
) ENGINE=InnoDB AUTO_INCREMENT=10020 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resource_menu`
--

LOCK TABLES `t_resource_menu` WRITE;
/*!40000 ALTER TABLE `t_resource_menu` DISABLE KEYS */;
INSERT INTO `t_resource_menu` VALUES (1,'1001','系统管理',NULL,1,'','系统管理，只有sa才有的权限'),(2,'10011001','权限管理',NULL,1,'',''),(3,'100110011001','资源',NULL,1,'','权限的基本单元,菜单和Action'),(4,'1001100110011001','菜单','/manage/permission/editResourceMenu.action',1,'',''),(5,'1001100110011002','方法','3',1,NULL,NULL),(1000,'1000','测试页面','/test/test.action',1,'?testInfo=UUUU',''),(10015,'100110011002','角色','10001',1,'',''),(10016,'100110011003','用户','/manage/permission/adminUserList.action',1,'','');
/*!40000 ALTER TABLE `t_resource_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_resource_method`
--

DROP TABLE IF EXISTS `t_resource_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_resource_method` (
  `methodid` bigint(20) NOT NULL AUTO_INCREMENT,
  `methodname` varchar(100) NOT NULL,
  `methodpath` varchar(200) NOT NULL,
  `effective` int(11) NOT NULL DEFAULT '1',
  `description` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`methodid`),
  UNIQUE KEY `actionname_UNIQUE` (`methodname`),
  UNIQUE KEY `actionpath_UNIQUE` (`methodpath`)
) ENGINE=InnoDB AUTO_INCREMENT=10041 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_resource_method`
--

LOCK TABLES `t_resource_method` WRITE;
/*!40000 ALTER TABLE `t_resource_method` DISABLE KEYS */;
INSERT INTO `t_resource_method` VALUES (1,'html-1','/test/html_1.action',1,NULL),(2,'html-2','/test/html_2.action',1,NULL),(3,'action资源编辑','/manage/permission/editResourceAction.action',1,NULL),(4,'菜单资源编辑','/manage/permission/editResourceMenu.action',1,''),(1000,'测试Action','/test/test.action',1,NULL),(10001,'角色列表','/manage/permission/editRoleList.action',1,'角色编辑列表'),(10009,'d','d',1,'d'),(10040,'管理员用户编辑','/manage/permission/editAdminUser.action',1,'');
/*!40000 ALTER TABLE `t_resource_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_test`
--

DROP TABLE IF EXISTS `t_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_test` (
  `testid` int(11) NOT NULL AUTO_INCREMENT,
  `testname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`testid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_test`
--

LOCK TABLES `t_test` WRITE;
/*!40000 ALTER TABLE `t_test` DISABLE KEYS */;
INSERT INTO `t_test` VALUES (1,'tt_name'),(2,'tt_name');
/*!40000 ALTER TABLE `t_test` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-07-14 19:16:28
