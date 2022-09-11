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

 Date: 11/09/2022 14:15:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `topicid` int NOT NULL,
  `commentid` int NOT NULL,
  `username` varchar(700) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `comment` varchar(700) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (3, 1, 'luli', 'bsjhdsgyuagfuLKD');
INSERT INTO `comment` VALUES (3, 2, 'tom', 'bsjhdsgyuagfuLKD');
INSERT INTO `comment` VALUES (1, 1, 'jim', '你这个要学会适当的放松，这样能减轻你的心理负担，才能安静下来解决自己的感情问题。');
INSERT INTO `comment` VALUES (3, 3, 'tom', 'bsjhdsgyuagfuLKD');
INSERT INTO `comment` VALUES (1, 2, 'tom', 'bsjhdsgyuagfuLKD');

SET FOREIGN_KEY_CHECKS = 1;
