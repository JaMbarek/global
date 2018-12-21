/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50724
Source Host           : 192.168.204.10:3306
Source Database       : ApolloConfigDB

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-21 18:41:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for App
-- ----------------------------
DROP TABLE IF EXISTS `App`;
CREATE TABLE `App` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `Name` varchar(500) NOT NULL DEFAULT 'default' COMMENT '应用名',
  `OrgId` varchar(32) NOT NULL DEFAULT 'default' COMMENT '部门Id',
  `OrgName` varchar(64) NOT NULL DEFAULT 'default' COMMENT '部门名字',
  `OwnerName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerName',
  `OwnerEmail` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ownerEmail',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId` (`AppId`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Name` (`Name`(191))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='应用表';

-- ----------------------------
-- Records of App
-- ----------------------------
INSERT INTO `App` VALUES ('1', 'SampleApp', 'Sample App', 'TEST1', '样例部门1', 'apollo', 'apollo@acme.com', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `App` VALUES ('2', 'system', 'system', 'TEST1', '样例部门1', 'admin', 'liuxianglei@m-chain.com', '\0', 'apollo', '2018-12-21 03:47:56', 'apollo', '2018-12-21 03:47:56');
INSERT INTO `App` VALUES ('3', 'user', 'user', 'TEST1', '样例部门1', 'admin', 'liuxianglei@m-chain.com', '\0', 'apollo', '2018-12-21 05:31:06', 'apollo', '2018-12-21 05:31:06');

-- ----------------------------
-- Table structure for AppNamespace
-- ----------------------------
DROP TABLE IF EXISTS `AppNamespace`;
CREATE TABLE `AppNamespace` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Name` varchar(32) NOT NULL DEFAULT '' COMMENT 'namespace名字，注意，需要全局唯一',
  `AppId` varchar(32) NOT NULL DEFAULT '' COMMENT 'app id',
  `Format` varchar(32) NOT NULL DEFAULT 'properties' COMMENT 'namespace的format类型',
  `IsPublic` bit(1) NOT NULL DEFAULT b'0' COMMENT 'namespace是否为公共',
  `Comment` varchar(64) NOT NULL DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_AppId` (`AppId`),
  KEY `Name_AppId` (`Name`,`AppId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='应用namespace定义';

-- ----------------------------
-- Records of AppNamespace
-- ----------------------------
INSERT INTO `AppNamespace` VALUES ('1', 'application', 'SampleApp', 'properties', '\0', 'default app namespace', '\0', '', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `AppNamespace` VALUES ('2', 'application', 'system', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2018-12-21 03:47:59', 'apollo', '2018-12-21 03:47:59');
INSERT INTO `AppNamespace` VALUES ('3', 'application', 'user', 'properties', '\0', 'default app namespace', '\0', 'apollo', '2018-12-21 05:31:07', 'apollo', '2018-12-21 05:31:07');

-- ----------------------------
-- Table structure for Audit
-- ----------------------------
DROP TABLE IF EXISTS `Audit`;
CREATE TABLE `Audit` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `EntityName` varchar(50) NOT NULL DEFAULT 'default' COMMENT '表名',
  `EntityId` int(10) unsigned DEFAULT NULL COMMENT '记录ID',
  `OpName` varchar(50) NOT NULL DEFAULT 'default' COMMENT '操作类型',
  `Comment` varchar(500) DEFAULT NULL COMMENT '备注',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8mb4 COMMENT='日志审计表';

-- ----------------------------
-- Records of Audit
-- ----------------------------
INSERT INTO `Audit` VALUES ('1', 'App', '2', 'INSERT', null, '\0', 'apollo', '2018-12-21 03:47:59', null, '2018-12-21 03:47:59');
INSERT INTO `Audit` VALUES ('2', 'AppNamespace', '2', 'INSERT', null, '\0', 'apollo', '2018-12-21 03:47:59', null, '2018-12-21 03:47:59');
INSERT INTO `Audit` VALUES ('3', 'Cluster', '2', 'INSERT', null, '\0', 'apollo', '2018-12-21 03:48:00', null, '2018-12-21 03:48:00');
INSERT INTO `Audit` VALUES ('4', 'Namespace', '2', 'INSERT', null, '\0', 'apollo', '2018-12-21 03:48:00', null, '2018-12-21 03:48:00');
INSERT INTO `Audit` VALUES ('5', 'Item', '2', 'INSERT', null, '\0', 'apollo', '2018-12-21 03:49:20', null, '2018-12-21 03:49:20');
INSERT INTO `Audit` VALUES ('6', 'Release', '2', 'INSERT', null, '\0', 'apollo', '2018-12-21 03:50:01', null, '2018-12-21 03:50:01');
INSERT INTO `Audit` VALUES ('7', 'ReleaseHistory', '2', 'INSERT', null, '\0', 'apollo', '2018-12-21 03:50:01', null, '2018-12-21 03:50:01');
INSERT INTO `Audit` VALUES ('8', 'Item', '3', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:18:47', null, '2018-12-21 04:18:47');
INSERT INTO `Audit` VALUES ('9', 'Release', '3', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:19:12', null, '2018-12-21 04:19:12');
INSERT INTO `Audit` VALUES ('10', 'ReleaseHistory', '3', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:19:12', null, '2018-12-21 04:19:12');
INSERT INTO `Audit` VALUES ('11', 'Item', '4', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:20:02', null, '2018-12-21 04:20:02');
INSERT INTO `Audit` VALUES ('12', 'Item', '5', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:20:10', null, '2018-12-21 04:20:10');
INSERT INTO `Audit` VALUES ('13', 'Item', '6', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:20:16', null, '2018-12-21 04:20:16');
INSERT INTO `Audit` VALUES ('14', 'Release', '4', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:20:29', null, '2018-12-21 04:20:29');
INSERT INTO `Audit` VALUES ('15', 'ReleaseHistory', '4', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:20:29', null, '2018-12-21 04:20:29');
INSERT INTO `Audit` VALUES ('16', 'Item', '5', 'UPDATE', null, '\0', 'apollo', '2018-12-21 04:22:47', null, '2018-12-21 04:22:47');
INSERT INTO `Audit` VALUES ('17', 'Release', '5', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:22:50', null, '2018-12-21 04:22:50');
INSERT INTO `Audit` VALUES ('18', 'ReleaseHistory', '5', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:22:50', null, '2018-12-21 04:22:50');
INSERT INTO `Audit` VALUES ('19', 'Item', '5', 'UPDATE', null, '\0', 'apollo', '2018-12-21 04:27:24', null, '2018-12-21 04:27:24');
INSERT INTO `Audit` VALUES ('20', 'Release', '6', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:27:34', null, '2018-12-21 04:27:34');
INSERT INTO `Audit` VALUES ('21', 'ReleaseHistory', '6', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:27:34', null, '2018-12-21 04:27:34');
INSERT INTO `Audit` VALUES ('22', 'Item', '5', 'UPDATE', null, '\0', 'apollo', '2018-12-21 04:28:42', null, '2018-12-21 04:28:42');
INSERT INTO `Audit` VALUES ('23', 'Release', '7', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:28:49', null, '2018-12-21 04:28:49');
INSERT INTO `Audit` VALUES ('24', 'ReleaseHistory', '7', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:28:49', null, '2018-12-21 04:28:49');
INSERT INTO `Audit` VALUES ('25', 'Item', '5', 'UPDATE', null, '\0', 'apollo', '2018-12-21 04:36:43', null, '2018-12-21 04:36:43');
INSERT INTO `Audit` VALUES ('26', 'Release', '8', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:37:01', null, '2018-12-21 04:37:01');
INSERT INTO `Audit` VALUES ('27', 'ReleaseHistory', '8', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:37:01', null, '2018-12-21 04:37:01');
INSERT INTO `Audit` VALUES ('28', 'Item', '7', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:38:10', null, '2018-12-21 04:38:10');
INSERT INTO `Audit` VALUES ('29', 'Release', '9', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:38:13', null, '2018-12-21 04:38:13');
INSERT INTO `Audit` VALUES ('30', 'ReleaseHistory', '9', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:38:13', null, '2018-12-21 04:38:13');
INSERT INTO `Audit` VALUES ('31', 'Item', '7', 'UPDATE', null, '\0', 'apollo', '2018-12-21 04:39:52', null, '2018-12-21 04:39:52');
INSERT INTO `Audit` VALUES ('32', 'Release', '10', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:40:04', null, '2018-12-21 04:40:04');
INSERT INTO `Audit` VALUES ('33', 'ReleaseHistory', '10', 'INSERT', null, '\0', 'apollo', '2018-12-21 04:40:04', null, '2018-12-21 04:40:04');
INSERT INTO `Audit` VALUES ('34', 'Item', '5', 'UPDATE', null, '\0', 'apollo', '2018-12-21 05:01:27', null, '2018-12-21 05:01:27');
INSERT INTO `Audit` VALUES ('35', 'Release', '11', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:01:50', null, '2018-12-21 05:01:50');
INSERT INTO `Audit` VALUES ('36', 'ReleaseHistory', '11', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:01:50', null, '2018-12-21 05:01:50');
INSERT INTO `Audit` VALUES ('37', 'Item', '7', 'UPDATE', null, '\0', 'apollo', '2018-12-21 05:05:13', null, '2018-12-21 05:05:13');
INSERT INTO `Audit` VALUES ('38', 'Item', '5', 'UPDATE', null, '\0', 'apollo', '2018-12-21 05:05:19', null, '2018-12-21 05:05:19');
INSERT INTO `Audit` VALUES ('39', 'Release', '12', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:05:22', null, '2018-12-21 05:05:22');
INSERT INTO `Audit` VALUES ('40', 'ReleaseHistory', '12', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:05:22', null, '2018-12-21 05:05:22');
INSERT INTO `Audit` VALUES ('41', 'Item', '5', 'UPDATE', null, '\0', 'apollo', '2018-12-21 05:07:06', null, '2018-12-21 05:07:06');
INSERT INTO `Audit` VALUES ('42', 'Item', '7', 'UPDATE', null, '\0', 'apollo', '2018-12-21 05:07:10', null, '2018-12-21 05:07:10');
INSERT INTO `Audit` VALUES ('43', 'Release', '13', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:07:12', null, '2018-12-21 05:07:12');
INSERT INTO `Audit` VALUES ('44', 'ReleaseHistory', '13', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:07:12', null, '2018-12-21 05:07:12');
INSERT INTO `Audit` VALUES ('45', 'Item', '2', 'DELETE', null, '\0', 'apollo', '2018-12-21 05:09:26', null, '2018-12-21 05:09:26');
INSERT INTO `Audit` VALUES ('46', 'Item', '3', 'DELETE', null, '\0', 'apollo', '2018-12-21 05:09:30', null, '2018-12-21 05:09:30');
INSERT INTO `Audit` VALUES ('47', 'Item', '4', 'DELETE', null, '\0', 'apollo', '2018-12-21 05:09:32', null, '2018-12-21 05:09:32');
INSERT INTO `Audit` VALUES ('48', 'Item', '5', 'DELETE', null, '\0', 'apollo', '2018-12-21 05:09:34', null, '2018-12-21 05:09:34');
INSERT INTO `Audit` VALUES ('49', 'Item', '6', 'DELETE', null, '\0', 'apollo', '2018-12-21 05:09:36', null, '2018-12-21 05:09:36');
INSERT INTO `Audit` VALUES ('50', 'Item', '7', 'DELETE', null, '\0', 'apollo', '2018-12-21 05:09:38', null, '2018-12-21 05:09:38');
INSERT INTO `Audit` VALUES ('51', 'Release', '14', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:09:42', null, '2018-12-21 05:09:42');
INSERT INTO `Audit` VALUES ('52', 'ReleaseHistory', '14', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:09:42', null, '2018-12-21 05:09:42');
INSERT INTO `Audit` VALUES ('53', 'Item', '8', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:19:48', null, '2018-12-21 05:19:48');
INSERT INTO `Audit` VALUES ('54', 'Item', '9', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:20:19', null, '2018-12-21 05:20:19');
INSERT INTO `Audit` VALUES ('55', 'Item', '10', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:20:33', null, '2018-12-21 05:20:33');
INSERT INTO `Audit` VALUES ('56', 'Item', '11', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:20:52', null, '2018-12-21 05:20:52');
INSERT INTO `Audit` VALUES ('57', 'Item', '12', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:21:47', null, '2018-12-21 05:21:47');
INSERT INTO `Audit` VALUES ('58', 'Item', '13', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:21:59', null, '2018-12-21 05:21:59');
INSERT INTO `Audit` VALUES ('59', 'Item', '14', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:22:12', null, '2018-12-21 05:22:12');
INSERT INTO `Audit` VALUES ('60', 'Item', '15', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:22:24', null, '2018-12-21 05:22:24');
INSERT INTO `Audit` VALUES ('61', 'Item', '16', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:22:35', null, '2018-12-21 05:22:35');
INSERT INTO `Audit` VALUES ('62', 'Item', '17', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:22:45', null, '2018-12-21 05:22:45');
INSERT INTO `Audit` VALUES ('63', 'Item', '18', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:22:55', null, '2018-12-21 05:22:55');
INSERT INTO `Audit` VALUES ('64', 'Item', '19', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:23:04', null, '2018-12-21 05:23:04');
INSERT INTO `Audit` VALUES ('65', 'Release', '15', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:24:36', null, '2018-12-21 05:24:36');
INSERT INTO `Audit` VALUES ('66', 'ReleaseHistory', '15', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:24:36', null, '2018-12-21 05:24:36');
INSERT INTO `Audit` VALUES ('67', 'App', '3', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:31:07', null, '2018-12-21 05:31:07');
INSERT INTO `Audit` VALUES ('68', 'AppNamespace', '3', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:31:07', null, '2018-12-21 05:31:07');
INSERT INTO `Audit` VALUES ('69', 'Cluster', '3', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:31:07', null, '2018-12-21 05:31:07');
INSERT INTO `Audit` VALUES ('70', 'Namespace', '3', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:31:07', null, '2018-12-21 05:31:07');
INSERT INTO `Audit` VALUES ('71', 'Release', '16', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:31:18', null, '2018-12-21 05:31:18');
INSERT INTO `Audit` VALUES ('72', 'ReleaseHistory', '16', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:31:18', null, '2018-12-21 05:31:18');
INSERT INTO `Audit` VALUES ('73', 'Item', '20', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:32:34', null, '2018-12-21 05:32:34');
INSERT INTO `Audit` VALUES ('74', 'Item', '21', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:32:46', null, '2018-12-21 05:32:46');
INSERT INTO `Audit` VALUES ('75', 'Item', '22', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:32:56', null, '2018-12-21 05:32:56');
INSERT INTO `Audit` VALUES ('76', 'Item', '23', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:33:09', null, '2018-12-21 05:33:09');
INSERT INTO `Audit` VALUES ('77', 'Item', '24', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:33:21', null, '2018-12-21 05:33:21');
INSERT INTO `Audit` VALUES ('78', 'Item', '25', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:33:31', null, '2018-12-21 05:33:31');
INSERT INTO `Audit` VALUES ('79', 'Item', '26', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:33:39', null, '2018-12-21 05:33:39');
INSERT INTO `Audit` VALUES ('80', 'Item', '27', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:33:49', null, '2018-12-21 05:33:49');
INSERT INTO `Audit` VALUES ('81', 'Item', '28', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:33:57', null, '2018-12-21 05:33:57');
INSERT INTO `Audit` VALUES ('82', 'Item', '29', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:34:06', null, '2018-12-21 05:34:06');
INSERT INTO `Audit` VALUES ('83', 'Item', '30', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:34:15', null, '2018-12-21 05:34:15');
INSERT INTO `Audit` VALUES ('84', 'Item', '31', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:34:24', null, '2018-12-21 05:34:24');
INSERT INTO `Audit` VALUES ('85', 'Release', '17', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:34:27', null, '2018-12-21 05:34:27');
INSERT INTO `Audit` VALUES ('86', 'ReleaseHistory', '17', 'INSERT', null, '\0', 'apollo', '2018-12-21 05:34:27', null, '2018-12-21 05:34:27');

-- ----------------------------
-- Table structure for Cluster
-- ----------------------------
DROP TABLE IF EXISTS `Cluster`;
CREATE TABLE `Cluster` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Name` varchar(32) NOT NULL DEFAULT '' COMMENT '集群名字',
  `AppId` varchar(32) NOT NULL DEFAULT '' COMMENT 'App id',
  `ParentClusterId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '父cluster',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT '' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_AppId_Name` (`AppId`,`Name`),
  KEY `IX_ParentClusterId` (`ParentClusterId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='集群';

-- ----------------------------
-- Records of Cluster
-- ----------------------------
INSERT INTO `Cluster` VALUES ('1', 'default', 'SampleApp', '0', '\0', '', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `Cluster` VALUES ('2', 'default', 'system', '0', '\0', 'apollo', '2018-12-21 03:48:00', 'apollo', '2018-12-21 03:48:00');
INSERT INTO `Cluster` VALUES ('3', 'default', 'user', '0', '\0', 'apollo', '2018-12-21 05:31:07', 'apollo', '2018-12-21 05:31:07');

-- ----------------------------
-- Table structure for Commit
-- ----------------------------
DROP TABLE IF EXISTS `Commit`;
CREATE TABLE `Commit` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ChangeSets` longtext NOT NULL COMMENT '修改变更集',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `NamespaceName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'namespaceName',
  `Comment` varchar(500) DEFAULT NULL COMMENT '备注',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `AppId` (`AppId`(191)),
  KEY `ClusterName` (`ClusterName`(191)),
  KEY `NamespaceName` (`NamespaceName`(191))
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COMMENT='commit 历史表';

-- ----------------------------
-- Records of Commit
-- ----------------------------
INSERT INTO `Commit` VALUES ('1', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"redis.port\",\"value\":\"6073\",\"lineNum\":1,\"id\":2,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 03:49:19\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 03:49:19\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 03:49:20', 'apollo', '2018-12-21 03:49:20');
INSERT INTO `Commit` VALUES ('2', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"name\",\"value\":\"lxl\",\"lineNum\":2,\"id\":3,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:18:46\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:18:47\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:18:47', 'apollo', '2018-12-21 04:18:47');
INSERT INTO `Commit` VALUES ('3', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"custom.id\",\"value\":\"10000\",\"lineNum\":3,\"id\":4,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:01\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:20:01\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:20:02', 'apollo', '2018-12-21 04:20:02');
INSERT INTO `Commit` VALUES ('4', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:20:10\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:20:10', 'apollo', '2018-12-21 04:20:10');
INSERT INTO `Commit` VALUES ('5', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"custom.status\",\"value\":\"1\",\"lineNum\":5,\"id\":6,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:16\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:20:16\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:20:16', 'apollo', '2018-12-21 04:20:16');
INSERT INTO `Commit` VALUES ('6', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:20:10\"},\"newItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl2\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:22:47\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:22:47', 'apollo', '2018-12-21 04:22:47');
INSERT INTO `Commit` VALUES ('7', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl2\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:22:47\"},\"newItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl4\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:27:24\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:27:24', 'apollo', '2018-12-21 04:27:24');
INSERT INTO `Commit` VALUES ('8', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl4\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:27:24\"},\"newItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:28:41\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:28:42', 'apollo', '2018-12-21 04:28:42');
INSERT INTO `Commit` VALUES ('9', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:28:42\"},\"newItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl1111\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:36:42\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:36:43', 'apollo', '2018-12-21 04:36:43');
INSERT INTO `Commit` VALUES ('10', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:38:10\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:38:10', 'apollo', '2018-12-21 04:38:10');
INSERT INTO `Commit` VALUES ('11', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:38:10\"},\"newItem\":{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name1111\",\"comment\":\"\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:39:52\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 04:39:52', 'apollo', '2018-12-21 04:39:52');
INSERT INTO `Commit` VALUES ('12', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl1111\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:36:43\"},\"newItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:01:27\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:01:27', 'apollo', '2018-12-21 05:01:27');
INSERT INTO `Commit` VALUES ('13', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name1111\",\"comment\":\"\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 04:39:52\"},\"newItem\":{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name1111222\",\"comment\":\"\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:05:12\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:05:13', 'apollo', '2018-12-21 05:05:13');
INSERT INTO `Commit` VALUES ('14', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:01:27\"},\"newItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl111222\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:05:19\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:05:19', 'apollo', '2018-12-21 05:05:19');
INSERT INTO `Commit` VALUES ('15', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl111222\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:05:19\"},\"newItem\":{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:07:05\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:07:06', 'apollo', '2018-12-21 05:07:06');
INSERT INTO `Commit` VALUES ('16', '{\"createItems\":[],\"updateItems\":[{\"oldItem\":{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name1111222\",\"comment\":\"\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:05:13\"},\"newItem\":{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name\",\"comment\":\"\",\"lineNum\":6,\"id\":7,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:07:10\"}}],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:07:10', 'apollo', '2018-12-21 05:07:10');
INSERT INTO `Commit` VALUES ('17', '{\"createItems\":[],\"updateItems\":[],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"redis.port\",\"value\":\"6073\",\"lineNum\":1,\"id\":2,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 03:49:20\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:09:26\"}]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:09:26', 'apollo', '2018-12-21 05:09:26');
INSERT INTO `Commit` VALUES ('18', '{\"createItems\":[],\"updateItems\":[],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"name\",\"value\":\"lxl\",\"lineNum\":2,\"id\":3,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:18:47\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:09:29\"}]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:09:30', 'apollo', '2018-12-21 05:09:30');
INSERT INTO `Commit` VALUES ('19', '{\"createItems\":[],\"updateItems\":[],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"custom.id\",\"value\":\"10000\",\"lineNum\":3,\"id\":4,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:01\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:09:31\"}]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:09:32', 'apollo', '2018-12-21 05:09:32');
INSERT INTO `Commit` VALUES ('20', '{\"createItems\":[],\"updateItems\":[],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"custom.name\",\"value\":\"lxl\",\"comment\":\"\",\"lineNum\":4,\"id\":5,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:09:34\"}]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:09:34', 'apollo', '2018-12-21 05:09:34');
INSERT INTO `Commit` VALUES ('21', '{\"createItems\":[],\"updateItems\":[],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"custom.status\",\"value\":\"1\",\"lineNum\":5,\"id\":6,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:20:16\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:09:36\"}]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:09:36', 'apollo', '2018-12-21 05:09:36');
INSERT INTO `Commit` VALUES ('22', '{\"createItems\":[],\"updateItems\":[],\"deleteItems\":[{\"namespaceId\":2,\"key\":\"ccc.name\",\"value\":\"test-name\",\"comment\":\"\",\"lineNum\":6,\"id\":7,\"isDeleted\":true,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 04:38:10\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:09:38\"}]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:09:38', 'apollo', '2018-12-21 05:09:38');
INSERT INTO `Commit` VALUES ('23', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.datasource.username\",\"value\":\"root\",\"lineNum\":1,\"id\":8,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:19:47\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:19:47\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:19:48', 'apollo', '2018-12-21 05:19:48');
INSERT INTO `Commit` VALUES ('24', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.datasource.url\",\"value\":\"jdbc:mysql://cloud.db.com:3306/system?useUnicode\\u003dtrue\\u0026characterEncoding\\u003dutf8\\u0026autoReconnect\\u003dtrue\\u0026failOverReadOnly\\u003dfalse\",\"lineNum\":2,\"id\":9,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:20:19\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:20:19\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:20:19', 'apollo', '2018-12-21 05:20:19');
INSERT INTO `Commit` VALUES ('25', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.datasource.password\",\"value\":\"root\",\"lineNum\":3,\"id\":10,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:20:33\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:20:33\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:20:33', 'apollo', '2018-12-21 05:20:33');
INSERT INTO `Commit` VALUES ('26', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.host\",\"value\":\"cloud.db.com\",\"lineNum\":4,\"id\":11,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:20:52\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:20:52\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:20:52', 'apollo', '2018-12-21 05:20:52');
INSERT INTO `Commit` VALUES ('27', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.password\",\"value\":\"admin123\",\"lineNum\":5,\"id\":12,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:21:47\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:21:47\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:21:47', 'apollo', '2018-12-21 05:21:47');
INSERT INTO `Commit` VALUES ('28', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.port\",\"value\":\"6379\",\"lineNum\":6,\"id\":13,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:21:59\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:21:59\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:21:59', 'apollo', '2018-12-21 05:21:59');
INSERT INTO `Commit` VALUES ('29', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.database\",\"value\":\"0\",\"lineNum\":7,\"id\":14,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:22:11\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:22:11\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:22:12', 'apollo', '2018-12-21 05:22:12');
INSERT INTO `Commit` VALUES ('30', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.timeout\",\"value\":\"3000\",\"lineNum\":8,\"id\":15,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:22:23\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:22:23\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:22:24', 'apollo', '2018-12-21 05:22:24');
INSERT INTO `Commit` VALUES ('31', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.lettuce.pool.max-idle\",\"value\":\"8\",\"lineNum\":9,\"id\":16,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:22:34\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:22:34\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:22:35', 'apollo', '2018-12-21 05:22:35');
INSERT INTO `Commit` VALUES ('32', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.lettuce.pool.min-idle\",\"value\":\"0\",\"lineNum\":10,\"id\":17,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:22:45\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:22:45\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:22:45', 'apollo', '2018-12-21 05:22:45');
INSERT INTO `Commit` VALUES ('33', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.lettuce.pool.max-wait\",\"value\":\"-1\",\"lineNum\":11,\"id\":18,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:22:54\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:22:54\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:22:55', 'apollo', '2018-12-21 05:22:55');
INSERT INTO `Commit` VALUES ('34', '{\"createItems\":[{\"namespaceId\":2,\"key\":\"spring.redis.lettuce.pool.max-active\",\"value\":\"8\",\"lineNum\":12,\"id\":19,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:23:04\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:23:04\"}],\"updateItems\":[],\"deleteItems\":[]}', 'system', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:23:04', 'apollo', '2018-12-21 05:23:04');
INSERT INTO `Commit` VALUES ('35', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.datasource.url\",\"value\":\"jdbc:mysql://cloud.db.com:3306/user?useUnicode\\u003dtrue\\u0026characterEncoding\\u003dutf8\\u0026autoReconnect\\u003dtrue\\u0026failOverReadOnly\\u003dfalse\",\"lineNum\":1,\"id\":20,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:32:34\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:32:34\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:32:34', 'apollo', '2018-12-21 05:32:34');
INSERT INTO `Commit` VALUES ('36', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.datasource.username\",\"value\":\"root\",\"lineNum\":2,\"id\":21,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:32:46\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:32:46\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:32:46', 'apollo', '2018-12-21 05:32:46');
INSERT INTO `Commit` VALUES ('37', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.datasource.password\",\"value\":\"root\",\"lineNum\":3,\"id\":22,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:32:55\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:32:55\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:32:56', 'apollo', '2018-12-21 05:32:56');
INSERT INTO `Commit` VALUES ('38', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.host\",\"value\":\"cloud.db.com\",\"lineNum\":4,\"id\":23,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:33:09\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:33:09\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:33:09', 'apollo', '2018-12-21 05:33:09');
INSERT INTO `Commit` VALUES ('39', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.password\",\"value\":\"admin123\",\"lineNum\":5,\"id\":24,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:33:21\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:33:21\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:33:21', 'apollo', '2018-12-21 05:33:21');
INSERT INTO `Commit` VALUES ('40', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.port\",\"value\":\"6379\",\"lineNum\":6,\"id\":25,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:33:30\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:33:30\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:33:31', 'apollo', '2018-12-21 05:33:31');
INSERT INTO `Commit` VALUES ('41', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.database\",\"value\":\"0\",\"lineNum\":7,\"id\":26,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:33:39\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:33:39\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:33:39', 'apollo', '2018-12-21 05:33:39');
INSERT INTO `Commit` VALUES ('42', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.timeout\",\"value\":\"3000\",\"lineNum\":8,\"id\":27,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:33:48\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:33:48\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:33:49', 'apollo', '2018-12-21 05:33:49');
INSERT INTO `Commit` VALUES ('43', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.lettuce.pool.max-idle\",\"value\":\"8\",\"lineNum\":9,\"id\":28,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:33:57\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:33:57\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:33:57', 'apollo', '2018-12-21 05:33:57');
INSERT INTO `Commit` VALUES ('44', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.lettuce.pool.min-idle\",\"value\":\"0\",\"lineNum\":10,\"id\":29,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:34:06\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:34:06\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:34:06', 'apollo', '2018-12-21 05:34:06');
INSERT INTO `Commit` VALUES ('45', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.lettuce.pool.max-wait\",\"value\":\"-1\",\"lineNum\":11,\"id\":30,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:34:15\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:34:15\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:34:15', 'apollo', '2018-12-21 05:34:15');
INSERT INTO `Commit` VALUES ('46', '{\"createItems\":[{\"namespaceId\":3,\"key\":\"spring.redis.lettuce.pool.max-active\",\"value\":\"8\",\"lineNum\":12,\"id\":31,\"isDeleted\":false,\"dataChangeCreatedBy\":\"apollo\",\"dataChangeCreatedTime\":\"2018-12-21 05:34:23\",\"dataChangeLastModifiedBy\":\"apollo\",\"dataChangeLastModifiedTime\":\"2018-12-21 05:34:24\"}],\"updateItems\":[],\"deleteItems\":[]}', 'user', 'default', 'application', null, '\0', 'apollo', '2018-12-21 05:34:24', 'apollo', '2018-12-21 05:34:24');

-- ----------------------------
-- Table structure for GrayReleaseRule
-- ----------------------------
DROP TABLE IF EXISTS `GrayReleaseRule`;
CREATE TABLE `GrayReleaseRule` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `AppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Cluster Name',
  `NamespaceName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Namespace Name',
  `BranchName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'branch name',
  `Rules` varchar(16000) DEFAULT '[]' COMMENT '灰度规则',
  `ReleaseId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '灰度对应的release',
  `BranchStatus` tinyint(2) DEFAULT '1' COMMENT '灰度分支状态: 0:删除分支,1:正在使用的规则 2：全量发布',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Namespace` (`AppId`,`ClusterName`,`NamespaceName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='灰度规则表';

-- ----------------------------
-- Records of GrayReleaseRule
-- ----------------------------

-- ----------------------------
-- Table structure for Instance
-- ----------------------------
DROP TABLE IF EXISTS `Instance`;
CREATE TABLE `Instance` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `AppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `DataCenter` varchar(64) NOT NULL DEFAULT 'default' COMMENT 'Data Center Name',
  `Ip` varchar(32) NOT NULL DEFAULT '' COMMENT 'instance ip',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_UNIQUE_KEY` (`AppId`,`ClusterName`,`Ip`,`DataCenter`),
  KEY `IX_IP` (`Ip`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='使用配置的应用实例';

-- ----------------------------
-- Records of Instance
-- ----------------------------
INSERT INTO `Instance` VALUES ('1', 'system', 'default', '', '192.168.204.1', '2018-12-21 04:02:57', '2018-12-21 04:02:57');

-- ----------------------------
-- Table structure for InstanceConfig
-- ----------------------------
DROP TABLE IF EXISTS `InstanceConfig`;
CREATE TABLE `InstanceConfig` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `InstanceId` int(11) unsigned DEFAULT NULL COMMENT 'Instance Id',
  `ConfigAppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Config App Id',
  `ConfigClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Config Cluster Name',
  `ConfigNamespaceName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'Config Namespace Name',
  `ReleaseKey` varchar(64) NOT NULL DEFAULT '' COMMENT '发布的Key',
  `ReleaseDeliveryTime` timestamp NULL DEFAULT NULL COMMENT '配置获取时间',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_UNIQUE_KEY` (`InstanceId`,`ConfigAppId`,`ConfigNamespaceName`),
  KEY `IX_ReleaseKey` (`ReleaseKey`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Valid_Namespace` (`ConfigAppId`,`ConfigClusterName`,`ConfigNamespaceName`,`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COMMENT='应用实例的配置信息';

-- ----------------------------
-- Records of InstanceConfig
-- ----------------------------
INSERT INTO `InstanceConfig` VALUES ('1', '1', 'system', 'default', 'application', '20181221052436-0dfd9cfae8aff1af', '2018-12-21 05:24:37', '2018-12-21 04:02:56', '2018-12-21 05:24:37');

-- ----------------------------
-- Table structure for Item
-- ----------------------------
DROP TABLE IF EXISTS `Item`;
CREATE TABLE `Item` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `NamespaceId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '集群NamespaceId',
  `Key` varchar(128) NOT NULL DEFAULT 'default' COMMENT '配置项Key',
  `Value` longtext NOT NULL COMMENT '配置项值',
  `Comment` varchar(1024) DEFAULT '' COMMENT '注释',
  `LineNum` int(10) unsigned DEFAULT '0' COMMENT '行号',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_GroupId` (`NamespaceId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COMMENT='配置项目';

-- ----------------------------
-- Records of Item
-- ----------------------------
INSERT INTO `Item` VALUES ('1', '1', 'timeout', '100', 'sample timeout配置', '1', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `Item` VALUES ('2', '2', 'redis.port', '6073', null, '1', '', 'apollo', '2018-12-21 03:49:20', 'apollo', '2018-12-21 05:09:26');
INSERT INTO `Item` VALUES ('3', '2', 'name', 'lxl', null, '2', '', 'apollo', '2018-12-21 04:18:47', 'apollo', '2018-12-21 05:09:30');
INSERT INTO `Item` VALUES ('4', '2', 'custom.id', '10000', null, '3', '', 'apollo', '2018-12-21 04:20:01', 'apollo', '2018-12-21 05:09:32');
INSERT INTO `Item` VALUES ('5', '2', 'custom.name', 'lxl', '', '4', '', 'apollo', '2018-12-21 04:20:10', 'apollo', '2018-12-21 05:09:34');
INSERT INTO `Item` VALUES ('6', '2', 'custom.status', '1', null, '5', '', 'apollo', '2018-12-21 04:20:16', 'apollo', '2018-12-21 05:09:36');
INSERT INTO `Item` VALUES ('7', '2', 'ccc.name', 'test-name', '', '6', '', 'apollo', '2018-12-21 04:38:10', 'apollo', '2018-12-21 05:09:38');
INSERT INTO `Item` VALUES ('8', '2', 'spring.datasource.username', 'root', null, '1', '\0', 'apollo', '2018-12-21 05:19:48', 'apollo', '2018-12-21 05:19:48');
INSERT INTO `Item` VALUES ('9', '2', 'spring.datasource.url', 'jdbc:mysql://cloud.db.com:3306/system?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false', null, '2', '\0', 'apollo', '2018-12-21 05:20:19', 'apollo', '2018-12-21 05:20:19');
INSERT INTO `Item` VALUES ('10', '2', 'spring.datasource.password', 'root', null, '3', '\0', 'apollo', '2018-12-21 05:20:33', 'apollo', '2018-12-21 05:20:33');
INSERT INTO `Item` VALUES ('11', '2', 'spring.redis.host', 'cloud.db.com', null, '4', '\0', 'apollo', '2018-12-21 05:20:52', 'apollo', '2018-12-21 05:20:52');
INSERT INTO `Item` VALUES ('12', '2', 'spring.redis.password', 'admin123', null, '5', '\0', 'apollo', '2018-12-21 05:21:47', 'apollo', '2018-12-21 05:21:47');
INSERT INTO `Item` VALUES ('13', '2', 'spring.redis.port', '6379', null, '6', '\0', 'apollo', '2018-12-21 05:21:59', 'apollo', '2018-12-21 05:21:59');
INSERT INTO `Item` VALUES ('14', '2', 'spring.redis.database', '0', null, '7', '\0', 'apollo', '2018-12-21 05:22:12', 'apollo', '2018-12-21 05:22:12');
INSERT INTO `Item` VALUES ('15', '2', 'spring.redis.timeout', '3000', null, '8', '\0', 'apollo', '2018-12-21 05:22:24', 'apollo', '2018-12-21 05:22:24');
INSERT INTO `Item` VALUES ('16', '2', 'spring.redis.lettuce.pool.max-idle', '8', null, '9', '\0', 'apollo', '2018-12-21 05:22:35', 'apollo', '2018-12-21 05:22:35');
INSERT INTO `Item` VALUES ('17', '2', 'spring.redis.lettuce.pool.min-idle', '0', null, '10', '\0', 'apollo', '2018-12-21 05:22:45', 'apollo', '2018-12-21 05:22:45');
INSERT INTO `Item` VALUES ('18', '2', 'spring.redis.lettuce.pool.max-wait', '-1', null, '11', '\0', 'apollo', '2018-12-21 05:22:55', 'apollo', '2018-12-21 05:22:55');
INSERT INTO `Item` VALUES ('19', '2', 'spring.redis.lettuce.pool.max-active', '8', null, '12', '\0', 'apollo', '2018-12-21 05:23:04', 'apollo', '2018-12-21 05:23:04');
INSERT INTO `Item` VALUES ('20', '3', 'spring.datasource.url', 'jdbc:mysql://cloud.db.com:3306/user?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false', null, '1', '\0', 'apollo', '2018-12-21 05:32:34', 'apollo', '2018-12-21 05:32:34');
INSERT INTO `Item` VALUES ('21', '3', 'spring.datasource.username', 'root', null, '2', '\0', 'apollo', '2018-12-21 05:32:46', 'apollo', '2018-12-21 05:32:46');
INSERT INTO `Item` VALUES ('22', '3', 'spring.datasource.password', 'root', null, '3', '\0', 'apollo', '2018-12-21 05:32:56', 'apollo', '2018-12-21 05:32:56');
INSERT INTO `Item` VALUES ('23', '3', 'spring.redis.host', 'cloud.db.com', null, '4', '\0', 'apollo', '2018-12-21 05:33:09', 'apollo', '2018-12-21 05:33:09');
INSERT INTO `Item` VALUES ('24', '3', 'spring.redis.password', 'admin123', null, '5', '\0', 'apollo', '2018-12-21 05:33:21', 'apollo', '2018-12-21 05:33:21');
INSERT INTO `Item` VALUES ('25', '3', 'spring.redis.port', '6379', null, '6', '\0', 'apollo', '2018-12-21 05:33:31', 'apollo', '2018-12-21 05:33:31');
INSERT INTO `Item` VALUES ('26', '3', 'spring.redis.database', '0', null, '7', '\0', 'apollo', '2018-12-21 05:33:39', 'apollo', '2018-12-21 05:33:39');
INSERT INTO `Item` VALUES ('27', '3', 'spring.redis.timeout', '3000', null, '8', '\0', 'apollo', '2018-12-21 05:33:49', 'apollo', '2018-12-21 05:33:49');
INSERT INTO `Item` VALUES ('28', '3', 'spring.redis.lettuce.pool.max-idle', '8', null, '9', '\0', 'apollo', '2018-12-21 05:33:57', 'apollo', '2018-12-21 05:33:57');
INSERT INTO `Item` VALUES ('29', '3', 'spring.redis.lettuce.pool.min-idle', '0', null, '10', '\0', 'apollo', '2018-12-21 05:34:06', 'apollo', '2018-12-21 05:34:06');
INSERT INTO `Item` VALUES ('30', '3', 'spring.redis.lettuce.pool.max-wait', '-1', null, '11', '\0', 'apollo', '2018-12-21 05:34:15', 'apollo', '2018-12-21 05:34:15');
INSERT INTO `Item` VALUES ('31', '3', 'spring.redis.lettuce.pool.max-active', '8', null, '12', '\0', 'apollo', '2018-12-21 05:34:24', 'apollo', '2018-12-21 05:34:24');

-- ----------------------------
-- Table structure for Namespace
-- ----------------------------
DROP TABLE IF EXISTS `Namespace`;
CREATE TABLE `Namespace` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'Cluster Name',
  `NamespaceName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'Namespace Name',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId_ClusterName_NamespaceName` (`AppId`(191),`ClusterName`(191),`NamespaceName`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_NamespaceName` (`NamespaceName`(191))
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='命名空间';

-- ----------------------------
-- Records of Namespace
-- ----------------------------
INSERT INTO `Namespace` VALUES ('1', 'SampleApp', 'default', 'application', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `Namespace` VALUES ('2', 'system', 'default', 'application', '\0', 'apollo', '2018-12-21 03:48:00', 'apollo', '2018-12-21 03:48:00');
INSERT INTO `Namespace` VALUES ('3', 'user', 'default', 'application', '\0', 'apollo', '2018-12-21 05:31:07', 'apollo', '2018-12-21 05:31:07');

-- ----------------------------
-- Table structure for NamespaceLock
-- ----------------------------
DROP TABLE IF EXISTS `NamespaceLock`;
CREATE TABLE `NamespaceLock` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `NamespaceId` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '集群NamespaceId',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT 'default' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  `IsDeleted` bit(1) DEFAULT b'0' COMMENT '软删除',
  PRIMARY KEY (`Id`),
  UNIQUE KEY `IX_NamespaceId` (`NamespaceId`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='namespace的编辑锁';

-- ----------------------------
-- Records of NamespaceLock
-- ----------------------------

-- ----------------------------
-- Table structure for Release
-- ----------------------------
DROP TABLE IF EXISTS `Release`;
CREATE TABLE `Release` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `ReleaseKey` varchar(64) NOT NULL DEFAULT '' COMMENT '发布的Key',
  `Name` varchar(64) NOT NULL DEFAULT 'default' COMMENT '发布名字',
  `Comment` varchar(256) DEFAULT NULL COMMENT '发布说明',
  `AppId` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `NamespaceName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'namespaceName',
  `Configurations` longtext NOT NULL COMMENT '发布配置',
  `IsAbandoned` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否废弃',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `AppId_ClusterName_GroupName` (`AppId`(191),`ClusterName`(191),`NamespaceName`(191)),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_ReleaseKey` (`ReleaseKey`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='发布';

-- ----------------------------
-- Records of Release
-- ----------------------------
INSERT INTO `Release` VALUES ('1', '20161009155425-d3a0749c6e20bc15', '20161009155424-release', 'Sample发布', 'SampleApp', 'default', 'application', '{\"timeout\":\"100\"}', '\0', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `Release` VALUES ('2', '20181221035000-0dfd9cfae8aff1a2', '20181221164951-release', '第一次发布', 'system', 'default', 'application', '{\"redis.port\":\"6073\"}', '\0', '\0', 'apollo', '2018-12-21 03:50:00', 'apollo', '2018-12-21 03:50:00');
INSERT INTO `Release` VALUES ('3', '20181221041911-0dfd9cfae8aff1a3', '20181221171909-release', '', 'system', 'default', 'application', '{\"redis.port\":\"6073\",\"name\":\"lxl\"}', '\0', '\0', 'apollo', '2018-12-21 04:19:12', 'apollo', '2018-12-21 04:19:12');
INSERT INTO `Release` VALUES ('4', '20181221042028-0dfd9cfae8aff1a4', '20181221172027-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"custom.name\":\"lxl\"}', '\0', '\0', 'apollo', '2018-12-21 04:20:29', 'apollo', '2018-12-21 04:20:29');
INSERT INTO `Release` VALUES ('5', '20181221042250-0dfd9cfae8aff1a5', '20181221172249-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"custom.name\":\"lxl2\"}', '\0', '\0', 'apollo', '2018-12-21 04:22:50', 'apollo', '2018-12-21 04:22:50');
INSERT INTO `Release` VALUES ('6', '20181221042733-0dfd9cfae8aff1a6', '20181221172732-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"custom.name\":\"lxl4\"}', '\0', '\0', 'apollo', '2018-12-21 04:27:34', 'apollo', '2018-12-21 04:27:34');
INSERT INTO `Release` VALUES ('7', '20181221042849-0dfd9cfae8aff1a7', '20181221172848-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"custom.name\":\"lxl\"}', '\0', '\0', 'apollo', '2018-12-21 04:28:49', 'apollo', '2018-12-21 04:28:49');
INSERT INTO `Release` VALUES ('8', '20181221043701-0dfd9cfae8aff1a8', '20181221173700-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"custom.name\":\"lxl1111\"}', '\0', '\0', 'apollo', '2018-12-21 04:37:01', 'apollo', '2018-12-21 04:37:01');
INSERT INTO `Release` VALUES ('9', '20181221043812-0dfd9cfae8aff1a9', '20181221173811-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"ccc.name\":\"test-name\",\"custom.name\":\"lxl1111\"}', '\0', '\0', 'apollo', '2018-12-21 04:38:13', 'apollo', '2018-12-21 04:38:13');
INSERT INTO `Release` VALUES ('10', '20181221044003-0dfd9cfae8aff1aa', '20181221174002-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"ccc.name\":\"test-name1111\",\"custom.name\":\"lxl1111\"}', '\0', '\0', 'apollo', '2018-12-21 04:40:04', 'apollo', '2018-12-21 04:40:04');
INSERT INTO `Release` VALUES ('11', '20181221050150-0dfd9cfae8aff1ab', '20181221180149-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"ccc.name\":\"test-name1111\",\"custom.name\":\"lxl\"}', '\0', '\0', 'apollo', '2018-12-21 05:01:50', 'apollo', '2018-12-21 05:01:50');
INSERT INTO `Release` VALUES ('12', '20181221050521-0dfd9cfae8aff1ac', '20181221180520-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"ccc.name\":\"test-name1111222\",\"custom.name\":\"lxl111222\"}', '\0', '\0', 'apollo', '2018-12-21 05:05:22', 'apollo', '2018-12-21 05:05:22');
INSERT INTO `Release` VALUES ('13', '20181221050712-0dfd9cfae8aff1ad', '20181221180711-release', '', 'system', 'default', 'application', '{\"custom.id\":\"10000\",\"redis.port\":\"6073\",\"custom.status\":\"1\",\"name\":\"lxl\",\"ccc.name\":\"test-name\",\"custom.name\":\"lxl\"}', '\0', '\0', 'apollo', '2018-12-21 05:07:12', 'apollo', '2018-12-21 05:07:12');
INSERT INTO `Release` VALUES ('14', '20181221050941-0dfd9cfae8aff1ae', '20181221180940-release', '', 'system', 'default', 'application', '{}', '\0', '\0', 'apollo', '2018-12-21 05:09:42', 'apollo', '2018-12-21 05:09:42');
INSERT INTO `Release` VALUES ('15', '20181221052436-0dfd9cfae8aff1af', '20181221182431-release', '', 'system', 'default', 'application', '{\"spring.redis.password\":\"admin123\",\"spring.redis.database\":\"0\",\"spring.redis.lettuce.pool.max-idle\":\"8\",\"spring.redis.lettuce.pool.min-idle\":\"0\",\"spring.redis.lettuce.pool.max-active\":\"8\",\"spring.datasource.username\":\"root\",\"spring.datasource.url\":\"jdbc:mysql://cloud.db.com:3306/system?useUnicode\\u003dtrue\\u0026characterEncoding\\u003dutf8\\u0026autoReconnect\\u003dtrue\\u0026failOverReadOnly\\u003dfalse\",\"spring.redis.host\":\"cloud.db.com\",\"spring.redis.port\":\"6379\",\"spring.redis.timeout\":\"3000\",\"spring.redis.lettuce.pool.max-wait\":\"-1\",\"spring.datasource.password\":\"root\"}', '\0', '\0', 'apollo', '2018-12-21 05:24:36', 'apollo', '2018-12-21 05:24:36');
INSERT INTO `Release` VALUES ('16', '20181221053117-90999cfae8aff1b0', '20181221183115-release', '', 'user', 'default', 'application', '{}', '\0', '\0', 'apollo', '2018-12-21 05:31:18', 'apollo', '2018-12-21 05:31:18');
INSERT INTO `Release` VALUES ('17', '20181221053426-90999cfae8aff1b1', '20181221183425-release', '', 'user', 'default', 'application', '{\"spring.redis.password\":\"admin123\",\"spring.redis.database\":\"0\",\"spring.redis.lettuce.pool.max-idle\":\"8\",\"spring.redis.lettuce.pool.min-idle\":\"0\",\"spring.redis.lettuce.pool.max-active\":\"8\",\"spring.datasource.username\":\"root\",\"spring.datasource.url\":\"jdbc:mysql://cloud.db.com:3306/user?useUnicode\\u003dtrue\\u0026characterEncoding\\u003dutf8\\u0026autoReconnect\\u003dtrue\\u0026failOverReadOnly\\u003dfalse\",\"spring.redis.host\":\"cloud.db.com\",\"spring.redis.port\":\"6379\",\"spring.redis.timeout\":\"3000\",\"spring.redis.lettuce.pool.max-wait\":\"-1\",\"spring.datasource.password\":\"root\"}', '\0', '\0', 'apollo', '2018-12-21 05:34:27', 'apollo', '2018-12-21 05:34:27');

-- ----------------------------
-- Table structure for ReleaseHistory
-- ----------------------------
DROP TABLE IF EXISTS `ReleaseHistory`;
CREATE TABLE `ReleaseHistory` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `AppId` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'AppID',
  `ClusterName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'ClusterName',
  `NamespaceName` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'namespaceName',
  `BranchName` varchar(32) NOT NULL DEFAULT 'default' COMMENT '发布分支名',
  `ReleaseId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '关联的Release Id',
  `PreviousReleaseId` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '前一次发布的ReleaseId',
  `Operation` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '发布类型，0: 普通发布，1: 回滚，2: 灰度发布，3: 灰度规则更新，4: 灰度合并回主分支发布，5: 主分支发布灰度自动发布，6: 主分支回滚灰度自动发布，7: 放弃灰度',
  `OperationContext` longtext NOT NULL COMMENT '发布上下文信息',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_Namespace` (`AppId`,`ClusterName`,`NamespaceName`,`BranchName`),
  KEY `IX_ReleaseId` (`ReleaseId`),
  KEY `IX_DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COMMENT='发布历史';

-- ----------------------------
-- Records of ReleaseHistory
-- ----------------------------
INSERT INTO `ReleaseHistory` VALUES ('1', 'SampleApp', 'default', 'application', 'default', '1', '0', '0', '{}', '\0', 'apollo', '2018-12-16 21:20:15', 'apollo', '2018-12-16 21:20:15');
INSERT INTO `ReleaseHistory` VALUES ('2', 'system', 'default', 'application', 'default', '2', '0', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 03:50:01', 'apollo', '2018-12-21 03:50:01');
INSERT INTO `ReleaseHistory` VALUES ('3', 'system', 'default', 'application', 'default', '3', '2', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:19:12', 'apollo', '2018-12-21 04:19:12');
INSERT INTO `ReleaseHistory` VALUES ('4', 'system', 'default', 'application', 'default', '4', '3', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:20:29', 'apollo', '2018-12-21 04:20:29');
INSERT INTO `ReleaseHistory` VALUES ('5', 'system', 'default', 'application', 'default', '5', '4', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:22:50', 'apollo', '2018-12-21 04:22:50');
INSERT INTO `ReleaseHistory` VALUES ('6', 'system', 'default', 'application', 'default', '6', '5', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:27:34', 'apollo', '2018-12-21 04:27:34');
INSERT INTO `ReleaseHistory` VALUES ('7', 'system', 'default', 'application', 'default', '7', '6', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:28:49', 'apollo', '2018-12-21 04:28:49');
INSERT INTO `ReleaseHistory` VALUES ('8', 'system', 'default', 'application', 'default', '8', '7', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:37:01', 'apollo', '2018-12-21 04:37:01');
INSERT INTO `ReleaseHistory` VALUES ('9', 'system', 'default', 'application', 'default', '9', '8', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:38:13', 'apollo', '2018-12-21 04:38:13');
INSERT INTO `ReleaseHistory` VALUES ('10', 'system', 'default', 'application', 'default', '10', '9', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 04:40:04', 'apollo', '2018-12-21 04:40:04');
INSERT INTO `ReleaseHistory` VALUES ('11', 'system', 'default', 'application', 'default', '11', '10', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 05:01:50', 'apollo', '2018-12-21 05:01:50');
INSERT INTO `ReleaseHistory` VALUES ('12', 'system', 'default', 'application', 'default', '12', '11', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 05:05:22', 'apollo', '2018-12-21 05:05:22');
INSERT INTO `ReleaseHistory` VALUES ('13', 'system', 'default', 'application', 'default', '13', '12', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 05:07:12', 'apollo', '2018-12-21 05:07:12');
INSERT INTO `ReleaseHistory` VALUES ('14', 'system', 'default', 'application', 'default', '14', '13', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 05:09:42', 'apollo', '2018-12-21 05:09:42');
INSERT INTO `ReleaseHistory` VALUES ('15', 'system', 'default', 'application', 'default', '15', '14', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 05:24:36', 'apollo', '2018-12-21 05:24:36');
INSERT INTO `ReleaseHistory` VALUES ('16', 'user', 'default', 'application', 'default', '16', '0', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 05:31:18', 'apollo', '2018-12-21 05:31:18');
INSERT INTO `ReleaseHistory` VALUES ('17', 'user', 'default', 'application', 'default', '17', '16', '0', '{\"isEmergencyPublish\":false}', '\0', 'apollo', '2018-12-21 05:34:27', 'apollo', '2018-12-21 05:34:27');

-- ----------------------------
-- Table structure for ReleaseMessage
-- ----------------------------
DROP TABLE IF EXISTS `ReleaseMessage`;
CREATE TABLE `ReleaseMessage` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `Message` varchar(1024) NOT NULL DEFAULT '' COMMENT '发布的消息内容',
  `DataChange_LastTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`),
  KEY `IX_Message` (`Message`(191))
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='发布消息';

-- ----------------------------
-- Records of ReleaseMessage
-- ----------------------------
INSERT INTO `ReleaseMessage` VALUES ('14', 'system+default+application', '2018-12-21 05:24:36');
INSERT INTO `ReleaseMessage` VALUES ('15', 'user+default+application', '2018-12-21 05:31:18');
INSERT INTO `ReleaseMessage` VALUES ('16', 'user+default+application', '2018-12-21 05:34:27');

-- ----------------------------
-- Table structure for ServerConfig
-- ----------------------------
DROP TABLE IF EXISTS `ServerConfig`;
CREATE TABLE `ServerConfig` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Key` varchar(64) NOT NULL DEFAULT 'default' COMMENT '配置项Key',
  `Cluster` varchar(32) NOT NULL DEFAULT 'default' COMMENT '配置对应的集群，default为不针对特定的集群',
  `Value` varchar(2048) NOT NULL DEFAULT 'default' COMMENT '配置项值',
  `Comment` varchar(1024) DEFAULT '' COMMENT '注释',
  `IsDeleted` bit(1) NOT NULL DEFAULT b'0' COMMENT '1: deleted, 0: normal',
  `DataChange_CreatedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT '创建人邮箱前缀',
  `DataChange_CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `DataChange_LastModifiedBy` varchar(32) DEFAULT '' COMMENT '最后修改人邮箱前缀',
  `DataChange_LastTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
  PRIMARY KEY (`Id`),
  KEY `IX_Key` (`Key`),
  KEY `DataChange_LastTime` (`DataChange_LastTime`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='配置服务自身配置';

-- ----------------------------
-- Records of ServerConfig
-- ----------------------------
INSERT INTO `ServerConfig` VALUES ('1', 'eureka.service.url', 'default', 'http://localhost:8080/eureka/', 'Eureka服务Url，多个service以英文逗号分隔', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `ServerConfig` VALUES ('2', 'namespace.lock.switch', 'default', 'false', '一次发布只能有一个人修改开关', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `ServerConfig` VALUES ('3', 'item.value.length.limit', 'default', '20000', 'item value最大长度限制', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `ServerConfig` VALUES ('4', 'config-service.cache.enabled', 'default', 'false', 'ConfigService是否开启缓存，开启后能提高性能，但是会增大内存消耗！', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
INSERT INTO `ServerConfig` VALUES ('5', 'item.key.length.limit', 'default', '128', 'item key 最大长度限制', '\0', 'default', '2018-12-16 21:20:15', '', '2018-12-16 21:20:15');
