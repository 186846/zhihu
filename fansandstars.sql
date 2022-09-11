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

 Date: 11/09/2022 14:15:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fansandstars
-- ----------------------------
DROP TABLE IF EXISTS `fansandstars`;
CREATE TABLE `fansandstars`  (
  `starname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `fanname` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fansandstars
-- ----------------------------
INSERT INTO `fansandstars` VALUES ('tom', 'jim');
INSERT INTO `fansandstars` VALUES ('tom', 'luli');
INSERT INTO `fansandstars` VALUES ('marray', 'tom');
INSERT INTO `fansandstars` VALUES ('jim', 'tom');

SET FOREIGN_KEY_CHECKS = 1;
