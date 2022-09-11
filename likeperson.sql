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

 Date: 11/09/2022 14:15:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for likeperson
-- ----------------------------
DROP TABLE IF EXISTS `likeperson`;
CREATE TABLE `likeperson`  (
  `topicid` int NOT NULL,
  `commentid` int NOT NULL,
  `username` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of likeperson
-- ----------------------------
INSERT INTO `likeperson` VALUES (1, 1, 'tom');
INSERT INTO `likeperson` VALUES (3, 1, 'jim');
INSERT INTO `likeperson` VALUES (3, 1, 'marry');
INSERT INTO `likeperson` VALUES (1, 1, 'marry');
INSERT INTO `likeperson` VALUES (1, 1, 'jim');
INSERT INTO `likeperson` VALUES (1, 1, 'luli');

SET FOREIGN_KEY_CHECKS = 1;
