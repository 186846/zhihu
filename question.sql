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

 Date: 11/09/2022 14:16:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question`  (
  `topicid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(700) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(700) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`topicid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES (1, 'tom', '你好！');
INSERT INTO `question` VALUES (2, 'jim', '你好，能问个问题吗？我在感情上遇到了问题，请问能有什么办法吗？');
INSERT INTO `question` VALUES (3, 'marray', '你好，很高兴见到你。');
INSERT INTO `question` VALUES (4, 'marry', '你好，很高兴见到你。');
INSERT INTO `question` VALUES (5, 'tom', '你好，很高兴见到你。');

SET FOREIGN_KEY_CHECKS = 1;
