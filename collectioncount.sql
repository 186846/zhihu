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

 Date: 11/09/2022 14:14:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collectioncount
-- ----------------------------
DROP TABLE IF EXISTS `collectioncount`;
CREATE TABLE `collectioncount`  (
  `topicid` int NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `count` int NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of collectioncount
-- ----------------------------
INSERT INTO `collectioncount` VALUES (1, 'tom', 3);
INSERT INTO `collectioncount` VALUES (2, 'jim', 1);
INSERT INTO `collectioncount` VALUES (3, 'marray', 1);
INSERT INTO `collectioncount` VALUES (4, 'marry', 4);

SET FOREIGN_KEY_CHECKS = 1;
