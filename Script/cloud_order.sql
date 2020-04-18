/*
Navicat MySQL Data Transfer

Source Server         : 120.24.163.146
Source Server Version : 80018
Source Host           : 120.24.163.146:3306
Source Database       : cloud_order

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-04-18 18:43:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `order_no` varchar(30) DEFAULT NULL COMMENT '订单号',
  `order_state` int(5) DEFAULT '0' COMMENT '订单状态  0:待付款,1:待发货,2:待收货,3:已完成,4:已取消',
  `order_amount` double(11,2) DEFAULT NULL COMMENT '订单金额',
  `pay_amount` double(11,2) DEFAULT NULL COMMENT '支付金额',
  `order_count` int(11) DEFAULT NULL COMMENT '商品数量',
  `pay_time` datetime DEFAULT NULL COMMENT '支付时间',
  `coupon_id` varchar(200) DEFAULT NULL COMMENT '优惠券id，如果有',
  `goods_id` varchar(200) DEFAULT NULL COMMENT '商品id（多个商品时用,隔开）',
  `sku_id` varchar(200) DEFAULT NULL COMMENT 'skuid(多个时用,隔开)',
  `create_time` datetime DEFAULT NULL COMMENT '下单时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('00000000001', '1', 'ae9f2df86ffe88d4', '0', '5399.00', '5399.00', '1', null, null, '1', '1', '2020-04-15 17:59:38', '2020-04-15 17:59:38');

-- ----------------------------
-- Table structure for `undo_log`
-- ----------------------------
DROP TABLE IF EXISTS `undo_log`;
CREATE TABLE `undo_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `branch_id` bigint(20) NOT NULL,
  `xid` varchar(100) NOT NULL,
  `context` varchar(128) NOT NULL,
  `rollback_info` longblob NOT NULL,
  `log_status` int(11) NOT NULL,
  `log_created` datetime NOT NULL,
  `log_modified` datetime NOT NULL,
  `ext` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
