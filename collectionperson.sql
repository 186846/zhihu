/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : login

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 11/09/2022 14:14:52
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collectionperson
-- ----------------------------
DROP TABLE IF EXISTS `collectionperson`;
CREATE TABLE `collectionperson`  (
  `topicid` int NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collectionperson
-- ----------------------------
INSERT INTO `collectionperson` VALUES (1, 'jim');
INSERT INTO `collectionperson` VALUES (3, 'tom');
INSERT INTO `collectionperson` VALUES (4, 'jim');
INSERT INTO `collectionperson` VALUES (2, 'jim');
INSERT INTO `collectionperson` VALUES (2, 'tom');
INSERT INTO `collectionperson` VALUES (4, 'tom');

SET FOREIGN_KEY_CHECKS = 1;
