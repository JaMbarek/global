/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50724
Source Host           : 192.168.204.10:3306
Source Database       : user

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2018-12-13 19:02:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_account_id` bigint(20) NOT NULL COMMENT '账户id',
  `real_name` varchar(255) DEFAULT NULL COMMENT '真是姓名',
  `register_date` datetime NOT NULL COMMENT '注册日期',
  `last_login_date` datetime DEFAULT NULL COMMENT '上次登录日期',
  `last_login_ip` varchar(255) DEFAULT NULL COMMENT '上次登录ip',
  `status` int(2) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
