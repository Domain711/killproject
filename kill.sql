/*
Navicat MySQL Data Transfer

Source Server         : 本地库
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : kill

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-03-19 09:19:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL DEFAULT '',
  `price` double(10,0) NOT NULL DEFAULT '0',
  `description` varchar(255) NOT NULL DEFAULT '',
  `sales` int(11) NOT NULL DEFAULT '0',
  `img_url` varchar(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
INSERT INTO `item` VALUES ('12', 'iPhonex', '5220', '新版手机', '4', 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone/compare/iphone-compare-models-201809?wid=282&hei=383&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1535588384763');
INSERT INTO `item` VALUES ('13', 'iphone8', '4500', '革命性变革手机', '3', 'https://store.storeimages.cdn-apple.com/8756/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone8/select/iphone8-select-2019-family?wid=882&amp;hei=1058&amp;fmt=jpeg&amp;qlt=80&amp;op_usm=0.5,0.5&amp;.v=1550795431127');

-- ----------------------------
-- Table structure for item_stock
-- ----------------------------
DROP TABLE IF EXISTS `item_stock`;
CREATE TABLE `item_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `stock` int(11) NOT NULL DEFAULT '0',
  `item_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_stock
-- ----------------------------
INSERT INTO `item_stock` VALUES ('10', '91', '12');
INSERT INTO `item_stock` VALUES ('11', '193', '13');

-- ----------------------------
-- Table structure for order_info
-- ----------------------------
DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` varchar(36) NOT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  `item_id` int(11) NOT NULL DEFAULT '0',
  `item_price` double NOT NULL DEFAULT '0',
  `amount` int(11) NOT NULL DEFAULT '0',
  `order_amount` double NOT NULL DEFAULT '0',
  `promo_id` int(11) DEFAULT '0' COMMENT '秒杀活动id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_info
-- ----------------------------
INSERT INTO `order_info` VALUES ('2019031500000000', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031500000100', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031500000200', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031500000300', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031500000400', '11', '13', '4500', '1', '4500', '0');
INSERT INTO `order_info` VALUES ('2019031500000500', '11', '13', '4500', '1', '4500', '0');
INSERT INTO `order_info` VALUES ('2019031500000600', '11', '13', '4500', '1', '4500', '0');
INSERT INTO `order_info` VALUES ('2019031500000700', '13', '13', '4500', '1', '4500', '0');
INSERT INTO `order_info` VALUES ('2019031600000800', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031600000900', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031600001000', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031600001100', '11', '13', '4500', '1', '4500', '0');
INSERT INTO `order_info` VALUES ('2019031600001200', '11', '13', '4500', '1', '4500', '0');
INSERT INTO `order_info` VALUES ('2019031800001300', '11', '12', '5220', '1', '5220', '0');
INSERT INTO `order_info` VALUES ('2019031800001400', '11', '12', '3000', '1', '3000', '1');
INSERT INTO `order_info` VALUES ('2019031800001500', '11', '13', '4500', '1', '4500', '0');

-- ----------------------------
-- Table structure for promo_info
-- ----------------------------
DROP TABLE IF EXISTS `promo_info`;
CREATE TABLE `promo_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `promo_name` varchar(60) NOT NULL DEFAULT '' COMMENT '秒杀活动名称',
  `start_time` datetime NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀开始时间',
  `item_id` int(11) NOT NULL DEFAULT '0' COMMENT '秒杀商品',
  `promo_price` double(10,0) NOT NULL DEFAULT '0' COMMENT '秒杀价格',
  `end_time` datetime DEFAULT '0000-00-00 00:00:00' COMMENT '秒杀结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of promo_info
-- ----------------------------
INSERT INTO `promo_info` VALUES ('1', 'iPhone8 秒杀抢购', '2019-03-18 14:41:17', '12', '3000', '2019-03-18 16:19:31');

-- ----------------------------
-- Table structure for sequence_info
-- ----------------------------
DROP TABLE IF EXISTS `sequence_info`;
CREATE TABLE `sequence_info` (
  `name` varchar(20) NOT NULL,
  `current_value` int(11) NOT NULL DEFAULT '0',
  `step` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence_info
-- ----------------------------
INSERT INTO `sequence_info` VALUES ('order_info', '16', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) NOT NULL COMMENT '用户姓名',
  `gender` int(11) NOT NULL DEFAULT '0' COMMENT '0 男性 1女性',
  `age` int(11) NOT NULL COMMENT '用户年龄',
  `telphone` varchar(11) NOT NULL COMMENT '手机号',
  `register_mode` varchar(255) NOT NULL COMMENT '注册模式 ',
  `third_party_id` varchar(64) DEFAULT NULL COMMENT '第三方登录',
  PRIMARY KEY (`id`),
  UNIQUE KEY `telphone_unique_index` (`telphone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('11', 'test', '1', '21', '13645368414', 'byphone', null);
INSERT INTO `user_info` VALUES ('13', 'tomcat', '2', '22', '13645368415', 'byphone', null);

-- ----------------------------
-- Table structure for user_password
-- ----------------------------
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `encrpt_password` varchar(128) NOT NULL DEFAULT '' COMMENT '用户密码',
  `user_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_password
-- ----------------------------
INSERT INTO `user_password` VALUES ('4', 'e10adc3949ba59abbe56e057f20f883e', '11');
INSERT INTO `user_password` VALUES ('5', 'e10adc3949ba59abbe56e057f20f883e', '13');
