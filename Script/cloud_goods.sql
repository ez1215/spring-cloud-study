/*
Navicat MySQL Data Transfer

Source Server         : 120.24.163.146
Source Server Version : 80018
Source Host           : 120.24.163.146:3306
Source Database       : cloud_goods

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-04-18 18:43:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '主键',
  `goods_name` varchar(200) DEFAULT NULL COMMENT '商品名',
  `goods_img` varchar(200) DEFAULT NULL COMMENT '商品图片',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `sale_count` int(11) DEFAULT '0' COMMENT '销量',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('00000000001', 'Apple iPhone 11 (A2223)', 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/80220/18/9892/163090/5d78089cEda2f9674/da3b18358e68cfca.jpg', '100', '1', '2020-04-12 19:00:40', '2020-04-12 19:00:42');

-- ----------------------------
-- Table structure for `t_goods_attr`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attr`;
CREATE TABLE `t_goods_attr` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `attr_name` varchar(20) DEFAULT NULL COMMENT '属性名',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_goods_attr
-- ----------------------------
INSERT INTO `t_goods_attr` VALUES ('00000000001', '颜色', '1');
INSERT INTO `t_goods_attr` VALUES ('00000000002', '版本', '2');
INSERT INTO `t_goods_attr` VALUES ('00000000003', '方式', '3');

-- ----------------------------
-- Table structure for `t_goods_attr_val`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_attr_val`;
CREATE TABLE `t_goods_attr_val` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '属性名id',
  `attr_id` int(11) DEFAULT NULL COMMENT '属性id',
  `attr_val` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品属性值',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品属性值表';

-- ----------------------------
-- Records of t_goods_attr_val
-- ----------------------------
INSERT INTO `t_goods_attr_val` VALUES ('00000000001', '1', '黑色');
INSERT INTO `t_goods_attr_val` VALUES ('00000000002', '1', '白色');
INSERT INTO `t_goods_attr_val` VALUES ('00000000003', '1', '红色');
INSERT INTO `t_goods_attr_val` VALUES ('00000000004', '1', '黄色');
INSERT INTO `t_goods_attr_val` VALUES ('00000000005', '1', '绿色');
INSERT INTO `t_goods_attr_val` VALUES ('00000000006', '1', '紫色');
INSERT INTO `t_goods_attr_val` VALUES ('00000000007', '2', '64GB');
INSERT INTO `t_goods_attr_val` VALUES ('00000000008', '2', '128GB');
INSERT INTO `t_goods_attr_val` VALUES ('00000000009', '2', '256GB');
INSERT INTO `t_goods_attr_val` VALUES ('00000000010', '3', '公开版');

-- ----------------------------
-- Table structure for `t_goods_sku`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods_sku`;
CREATE TABLE `t_goods_sku` (
  `id` int(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  `image` varchar(500) DEFAULT NULL COMMENT '商品图片',
  `title` varchar(500) DEFAULT NULL COMMENT '商品展示名称',
  `price` double(11,2) DEFAULT NULL COMMENT '价格',
  `attr_id` varchar(200) DEFAULT NULL COMMENT '属性id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品sku表';

-- ----------------------------
-- Records of t_goods_sku
-- ----------------------------
INSERT INTO `t_goods_sku` VALUES ('00000000001', '1', '0', 'https://img10.360buyimg.com/n1/s450x450_jfs/t1/117823/12/695/224831/5e8efacaEb4d9a241/2f2ca5de28c6ed56.jpg', 'Apple iPhone 11 (A2223) 64GB 黑色 移动联通电信4G手机 双卡双待', '5499.00', '1:1,2:7,3:10', '2020-04-15 22:04:18', '2020-04-16 10:48:26');
INSERT INTO `t_goods_sku` VALUES ('00000000002', '1', '2', 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/93799/6/18036/223294/5e8efaf7E60d3a1a6/8bb9dbf59bc9f265.jpg', 'Apple iPhone 11 (A2223) 64GB 白色 移动联通电信4G手机 双卡双待', '5499.00', '1:2,2:7,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000003', '1', '3', 'https://img14.360buyimg.com/n1/s450x450_jfs/t1/100093/3/18034/253852/5e8efb2eE62f4d1e9/9bca664ff863a1a4.jpg', 'Apple iPhone 11 (A2223) 64GB 红色 移动联通电信4G手机 双卡双待', '5499.00', '1:3,2:7,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000004', '1', '4', 'https://img11.360buyimg.com/n1/s450x450_jfs/t1/112850/25/659/240414/5e8efb45E6a37bd4a/7125d93cd9904bc8.jpg', 'Apple iPhone 11 (A2223) 64GB 黄色 移动联通电信4G手机 双卡双待', '5499.00', '1:4,2:7,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000005', '1', '5', 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/103924/2/17933/245132/5e8efb63Ef83e4fc6/ab2123f119f5c0b6.jpg', 'Apple iPhone 11 (A2223) 64GB 紫色 移动联通电信4G手机 双卡双待', '5499.00', '1:5,2:7,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000006', '1', '6', 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/97131/14/18002/241197/5e8efb7dE968b965f/e15cb4eca78f4cef.jpg', 'Apple iPhone 11 (A2223) 64GB 绿色 移动联通电信4G手机 双卡双待', '5499.00', '1:6,2:7,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000007', '1', '7', 'https://img10.360buyimg.com/n1/s450x450_jfs/t1/117823/12/695/224831/5e8efacaEb4d9a241/2f2ca5de28c6ed56.jpg', 'Apple iPhone 11 (A2223) 128GB 黑色 移动联通电信4G手机 双卡双待', '5999.00', '1:1,2:8,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000008', '1', '8', 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/93799/6/18036/223294/5e8efaf7E60d3a1a6/8bb9dbf59bc9f265.jpg', 'Apple iPhone 11 (A2223) 128GB 白色 移动联通电信4G手机 双卡双待', '5999.00', '1:2,2:8,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000009', '1', '9', 'https://img14.360buyimg.com/n1/s450x450_jfs/t1/100093/3/18034/253852/5e8efb2eE62f4d1e9/9bca664ff863a1a4.jpg', 'Apple iPhone 11 (A2223) 128GB 红色 移动联通电信4G手机 双卡双待', '5999.00', '1:3,2:8,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000010', '1', '10', 'https://img11.360buyimg.com/n1/s450x450_jfs/t1/112850/25/659/240414/5e8efb45E6a37bd4a/7125d93cd9904bc8.jpg', 'Apple iPhone 11 (A2223) 128GB 黄色 移动联通电信4G手机 双卡双待', '5999.00', '1:4,2:8,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000011', '1', '11', 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/103924/2/17933/245132/5e8efb63Ef83e4fc6/ab2123f119f5c0b6.jpg', 'Apple iPhone 11 (A2223) 128GB 紫色 移动联通电信4G手机 双卡双待', '5999.00', '1:5,2:8,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000012', '1', '12', 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/97131/14/18002/241197/5e8efb7dE968b965f/e15cb4eca78f4cef.jpg', 'Apple iPhone 11 (A2223) 128GB 绿色 移动联通电信4G手机 双卡双待', '5999.00', '1:6,2:8,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000013', '1', '13', 'https://img10.360buyimg.com/n1/s450x450_jfs/t1/117823/12/695/224831/5e8efacaEb4d9a241/2f2ca5de28c6ed56.jpg', 'Apple iPhone 11 (A2223) 256GB 黑色 移动联通电信4G手机 双卡双待', '6799.00', '1:1,2:9,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000014', '1', '14', 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/93799/6/18036/223294/5e8efaf7E60d3a1a6/8bb9dbf59bc9f265.jpg', 'Apple iPhone 11 (A2223) 256GB 白色 移动联通电信4G手机 双卡双待', '6799.00', '1:2,2:9,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000015', '1', '15', 'https://img14.360buyimg.com/n1/s450x450_jfs/t1/100093/3/18034/253852/5e8efb2eE62f4d1e9/9bca664ff863a1a4.jpg', 'Apple iPhone 11 (A2223) 256GB 红色 移动联通电信4G手机 双卡双待', '6799.00', '1:3,2:9,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000016', '1', '16', 'https://img11.360buyimg.com/n1/s450x450_jfs/t1/112850/25/659/240414/5e8efb45E6a37bd4a/7125d93cd9904bc8.jpg', 'Apple iPhone 11 (A2223) 256GB 黄色 移动联通电信4G手机 双卡双待', '6799.00', '1:4,2:9,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000017', '1', '17', 'https://img13.360buyimg.com/n1/s450x450_jfs/t1/103924/2/17933/245132/5e8efb63Ef83e4fc6/ab2123f119f5c0b6.jpg', 'Apple iPhone 11 (A2223) 256GB 紫色 移动联通电信4G手机 双卡双待', '6799.00', '1:5,2:9,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');
INSERT INTO `t_goods_sku` VALUES ('00000000018', '1', '18', 'https://img12.360buyimg.com/n1/s450x450_jfs/t1/97131/14/18002/241197/5e8efb7dE968b965f/e15cb4eca78f4cef.jpg', 'Apple iPhone 11 (A2223) 256GB 绿色 移动联通电信4G手机 双卡双待', '6799.00', '1:6,2:9,3:10', '2020-04-15 22:04:18', '2020-04-15 22:04:20');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of undo_log
-- ----------------------------
