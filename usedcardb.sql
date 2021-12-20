/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : 127.0.0.1:3306
 Source Schema         : usedcardb

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 20/12/2021 12:42:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for car_information
-- ----------------------------
DROP TABLE IF EXISTS `car_information`;
CREATE TABLE `car_information`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `year` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `mileage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `body_style` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `color` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `transmission` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `engine_type` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_model_id` int(0) NULL DEFAULT NULL,
  `created` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `updated` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_information
-- ----------------------------
INSERT INTO `car_information` VALUES (2, 'Audi A3 Premium', '2015', '12,345', '1234567', 'Pickup', 'Pink', 'Automatic', 'Rotary', 'Used 2019 Audi A3 Premium with FWD, Keyless Entry, Fog Lights, Leather Seats, Heated ...', 1, '2021-12-21 04:18:54', '2021-12-20 12:18:54');
INSERT INTO `car_information` VALUES (3, 'Ford F-350 sport-L', '2012', '300,000', '233333', 'Pickup', 'white', 'Manual', '12 Cyl', 'This is a old pickup....', 3, '2021-12-21 04:18:42', '2021-12-20 12:18:43');
INSERT INTO `car_information` VALUES (4, '2010 Audi A4 Premium 40', '2010', '123,232', '123323123', 'SUV', 'black', 'Automatic', '6 Cyl', 'Nice Car！！！！！！！！！！！！！！！！', 7, '2021-12-21 04:19:04', '2021-12-20 12:19:05');
INSERT INTO `car_information` VALUES (5, 'Audi A3 Premium Plus', '2020', '34433', '234343', 'Coupe', 'white', 'Automatic', 'Rotary', 'Used 2019 Audi A3 Premium with FWD, Keyless Entry, Fog Lights, Leather Seats, Heated ...', 1, '2021-12-21 04:09:23', '2021-12-20 12:09:23');
INSERT INTO `car_information` VALUES (6, '2012 Toyota Camry LE', '2012', '$6,558', '23000', 'Sedan', 'blue', 'Unspecified', 'Unspecified', 'unspecified', 9, '2021-12-20 12:23:03', NULL);

-- ----------------------------
-- Table structure for car_make
-- ----------------------------
DROP TABLE IF EXISTS `car_make`;
CREATE TABLE `car_make`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `model_count` int(0) NULL DEFAULT NULL,
  `created` datetime(0) NULL DEFAULT NULL,
  `updated` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_make
-- ----------------------------
INSERT INTO `car_make` VALUES (1, 'Audi', 'Germany', 'Audi is a German automotive manufacturer of luxury vehicles headquartered in Ingolstadt, Bavaria, Germany. As a subsidiary of its parent company, the Volkswagen Group, Audi produces vehicles in nine production facilities worldwide.', 3, '2021-12-12 14:40:38', '2021-12-20 03:40:49');
INSERT INTO `car_make` VALUES (2, 'BMW', 'Germany', 'Bayerische Motoren Werke AG, commonly referred to as BMWis a German multinational corporate manufacturer of luxury vehicles and motorcycles headquartered in Munich, Bavaria, Germany. ', 0, '2021-12-11 21:36:42', '2021-12-20 03:43:31');
INSERT INTO `car_make` VALUES (3, 'Ford', 'United States', 'Ford Motor Company (commonly known as Ford) is an American multinational automobile manufacturer headquartered in Dearborn, Michigan, United States. It was founded by Henry Ford and incorporated on June 16, 1903. ', 1, '2021-12-12 19:28:12', '2021-12-20 03:45:15');
INSERT INTO `car_make` VALUES (6, 'Honda', 'Japan', 'Honda Motor Company, Ltd. is a Japanese public multinational conglomerate manufacturer of automobiles, motorcycles, and power equipment, headquartered in Minato, Tokyo, Japan.', 0, '2021-12-20 03:46:31', NULL);
INSERT INTO `car_make` VALUES (7, 'Hyundai ', 'South Korean', ' The largest member of the chaebol, Hyundai Motor Company, has a controlling stake in Kia Corporation, and they are the largest and second largest car manufacturers in the country respectively.', 0, '2021-12-20 03:47:59', NULL);
INSERT INTO `car_make` VALUES (8, 'Nissan', 'Japan', 'Nissan Motor Co., Ltd. (Japanese: 日産自動車株式会社) (trading as Nissan Motor Corporation and often shortened to Nissan)[a] is a Japanese multinational automobile manufacturer headquartered in Nishi-ku, Yokohama, Japan. ', 0, '2021-12-20 03:49:00', NULL);
INSERT INTO `car_make` VALUES (9, 'Toyota ', 'Japan', 'Toyota Motor Corporation is a Japanese multinational automotive manufacturer headquartered in Toyota City, Aichi, Japan. It was founded by Kiichiro Toyoda and incorporated on August 28, 1937.', 1, '2021-12-20 03:50:31', NULL);
INSERT INTO `car_make` VALUES (10, 'Volkswagen', 'Germany', 'Volkswagen is a German motor vehicle manufacturer headquartered in Wolfsburg, Lower Saxony, Germany. ', 0, '2021-12-20 03:52:28', NULL);

-- ----------------------------
-- Table structure for car_model
-- ----------------------------
DROP TABLE IF EXISTS `car_model`;
CREATE TABLE `car_model`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `car_make_id` int(0) NULL DEFAULT NULL,
  `car_count` int unsigned NULL,
  `created` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `updated` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of car_model
-- ----------------------------
INSERT INTO `car_model` VALUES (1, 'Audi A3', 'The Audi A3 is a subcompact executive/small family car (Euro NCAP)/C-segment (European Commission) manufactured and marketed since the 1990s', 1, 2, '2021-12-21 04:13:56', '2021-12-20 11:58:27');
INSERT INTO `car_model` VALUES (3, 'Ford F-350', 'If you pull a large trailer with your Ford Super Duty,  an enhanced version of available BLIS...', 3, 1, '2021-12-21 04:02:35', '2021-12-20 12:02:35');
INSERT INTO `car_model` VALUES (4, 'Audi R8', 'As Audi\'s top model, the R8 sports car boasts a howling 602-hp V-10 engine just behind its snug two-seat cabin. It shares a lot with the Lamborghini Huracán', 1, 0, '2021-12-21 04:13:56', '2021-12-20 12:03:41');
INSERT INTO `car_model` VALUES (7, 'Audi A4', 'The Audi A4 is a subcompact executive/small family car (Euro NCAP)/C-segment (European Commission) manufactured and marketed since the 1990s', 1, 1, '2021-12-21 03:59:07', '2021-12-20 11:59:08');
INSERT INTO `car_model` VALUES (9, 'Camry', 'The Toyota Camry is an automobile sold internationally by the Japanese manufacturer...', 9, 1, '2021-12-21 04:23:02', NULL);

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(0) NULL DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `perms` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(0) NOT NULL COMMENT '类型     0：目录   1：菜单   2：按钮',
  `orderNum` int(0) NULL DEFAULT NULL COMMENT '排序',
  `created` datetime(0) NULL DEFAULT NULL,
  `updated` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES (1, 0, 'System Manage', '', NULL, 'sys:manage', 0, 1, '2021-11-27 18:58:18', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (2, 1, 'User Manage', '/sys/users', 'sys/User', 'sys:user:list', 1, 10, '2021-12-19 01:19:26', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (3, 1, 'Role Manage', '/sys/roles', 'sys/Role', 'sys:role:list', 1, 20, '2021-12-19 01:20:43', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (4, 1, 'Menu Manage', '/sys/menus', 'sys/Menu', 'sys:menu:list', 1, 30, '2021-12-19 01:22:08', NULL);
INSERT INTO `sys_menu` VALUES (5, 0, 'Car Manage', '', NULL, 'car:manage', 0, 2, '2021-12-19 11:34:09', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (7, 3, 'Save Role', '', NULL, 'sys:role:save', 2, 21, '2021-12-19 01:20:55', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (9, 2, 'Save User', NULL, NULL, 'sys:user:save', 2, 11, '2021-12-19 01:19:33', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (10, 2, 'Update User', NULL, NULL, 'sys:user:update', 2, 12, '2021-12-19 01:19:39', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (11, 2, 'Delete User', NULL, NULL, 'sys:user:delete', 2, 13, '2021-12-19 01:19:45', NULL);
INSERT INTO `sys_menu` VALUES (12, 2, 'Assign Role', NULL, NULL, 'sys:user:role', 2, 14, '2021-12-19 01:19:50', NULL);
INSERT INTO `sys_menu` VALUES (13, 2, 'Reset Password', NULL, NULL, 'sys:user:repass', 2, 15, '2021-12-19 01:19:55', NULL);
INSERT INTO `sys_menu` VALUES (14, 3, 'Update Role', NULL, NULL, 'sys:role:update', 2, 22, '2021-12-19 01:21:00', NULL);
INSERT INTO `sys_menu` VALUES (15, 3, 'Delete Role', NULL, NULL, 'sys:role:delete', 2, 23, '2021-12-19 01:21:05', NULL);
INSERT INTO `sys_menu` VALUES (16, 3, 'Assign Permission', NULL, NULL, 'sys:role:perm', 2, 24, '2021-12-19 01:21:43', NULL);
INSERT INTO `sys_menu` VALUES (17, 4, 'Save Menu', NULL, NULL, 'sys:menu:save', 2, 31, '2021-12-19 01:22:17', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (18, 4, 'Update Menu', NULL, NULL, 'sys:menu:update', 2, 32, '2021-12-19 01:22:23', '2021-11-27 18:58:18');
INSERT INTO `sys_menu` VALUES (19, 4, 'Delete Menu', NULL, NULL, 'sys:menu:delete', 2, 33, '2021-12-19 01:22:29', NULL);
INSERT INTO `sys_menu` VALUES (28, 5, 'Car Make', '/car/make', 'car/Make', 'car:make:list', 1, 200, '2021-12-12 21:37:15', NULL);
INSERT INTO `sys_menu` VALUES (30, 28, 'Update Make', '', NULL, 'car:make:update', 2, 202, '2021-12-19 01:39:14', NULL);
INSERT INTO `sys_menu` VALUES (31, 28, 'Delete Make', '', NULL, 'car:make:delete', 2, 201, '2021-12-19 01:39:17', NULL);
INSERT INTO `sys_menu` VALUES (32, 28, 'Save Make', '', NULL, 'car:make:save', 2, 203, '2021-12-19 01:39:07', NULL);
INSERT INTO `sys_menu` VALUES (33, 5, 'Car Model', '/car/model', 'car/Model', 'car:model:list', 1, 300, '2021-12-12 21:36:45', NULL);
INSERT INTO `sys_menu` VALUES (34, 33, 'Save Model', NULL, NULL, 'car:model:save', 2, 303, '2021-12-12 21:28:52', NULL);
INSERT INTO `sys_menu` VALUES (35, 33, 'Update Model', NULL, NULL, 'car:model:update', 2, 302, '2021-12-12 21:28:39', NULL);
INSERT INTO `sys_menu` VALUES (36, 33, 'Delete Model', NULL, NULL, 'car:model:delete', 2, 301, '2021-12-12 21:28:45', NULL);
INSERT INTO `sys_menu` VALUES (37, 5, 'Car Information', '/car/information', 'car/Information', 'car:information:list', 1, 400, '2021-12-17 17:01:47', NULL);
INSERT INTO `sys_menu` VALUES (38, 37, 'Save Information', '', NULL, 'car:information:save', 2, 403, '2021-12-20 12:25:56', NULL);
INSERT INTO `sys_menu` VALUES (39, 37, 'Update Information', NULL, NULL, 'car:information:update', 2, 402, '2021-12-17 17:05:30', NULL);
INSERT INTO `sys_menu` VALUES (40, 37, 'Delete Information', NULL, NULL, 'car:information:delete', 2, 401, '2021-12-17 17:06:02', NULL);

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `created` datetime(0) NULL DEFAULT NULL,
  `updated` datetime(0) NULL DEFAULT NULL,
  `status` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `name`(`name`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES (3, 'Normal User', 'normal', 'The user can check user and role page, operate car page.', '2021-11-27 18:58:18', '2021-11-27 18:58:18', 1);
INSERT INTO `sys_role` VALUES (6, 'Administrator', 'admin', 'The system administrator has the highest rights by default', '2021-11-27 18:58:18', '2021-12-20 12:25:07', 1);

-- ----------------------------
-- Table structure for sys_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(0) NOT NULL,
  `menu_id` bigint(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 401 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES (155, 2, 3);
INSERT INTO `sys_role_menu` VALUES (340, 6, 1);
INSERT INTO `sys_role_menu` VALUES (341, 6, 2);
INSERT INTO `sys_role_menu` VALUES (342, 6, 9);
INSERT INTO `sys_role_menu` VALUES (343, 6, 10);
INSERT INTO `sys_role_menu` VALUES (344, 6, 11);
INSERT INTO `sys_role_menu` VALUES (345, 6, 12);
INSERT INTO `sys_role_menu` VALUES (346, 6, 13);
INSERT INTO `sys_role_menu` VALUES (347, 6, 3);
INSERT INTO `sys_role_menu` VALUES (348, 6, 7);
INSERT INTO `sys_role_menu` VALUES (349, 6, 14);
INSERT INTO `sys_role_menu` VALUES (350, 6, 15);
INSERT INTO `sys_role_menu` VALUES (351, 6, 16);
INSERT INTO `sys_role_menu` VALUES (352, 6, 4);
INSERT INTO `sys_role_menu` VALUES (353, 6, 17);
INSERT INTO `sys_role_menu` VALUES (354, 6, 18);
INSERT INTO `sys_role_menu` VALUES (355, 6, 19);
INSERT INTO `sys_role_menu` VALUES (356, 6, 5);
INSERT INTO `sys_role_menu` VALUES (357, 6, 28);
INSERT INTO `sys_role_menu` VALUES (358, 6, 31);
INSERT INTO `sys_role_menu` VALUES (359, 6, 30);
INSERT INTO `sys_role_menu` VALUES (360, 6, 32);
INSERT INTO `sys_role_menu` VALUES (361, 6, 33);
INSERT INTO `sys_role_menu` VALUES (362, 6, 36);
INSERT INTO `sys_role_menu` VALUES (363, 6, 35);
INSERT INTO `sys_role_menu` VALUES (364, 6, 34);
INSERT INTO `sys_role_menu` VALUES (365, 6, 37);
INSERT INTO `sys_role_menu` VALUES (366, 6, 40);
INSERT INTO `sys_role_menu` VALUES (367, 6, 39);
INSERT INTO `sys_role_menu` VALUES (368, 6, 38);
INSERT INTO `sys_role_menu` VALUES (385, 3, 1);
INSERT INTO `sys_role_menu` VALUES (386, 3, 2);
INSERT INTO `sys_role_menu` VALUES (387, 3, 3);
INSERT INTO `sys_role_menu` VALUES (388, 3, 4);
INSERT INTO `sys_role_menu` VALUES (389, 3, 5);
INSERT INTO `sys_role_menu` VALUES (390, 3, 28);
INSERT INTO `sys_role_menu` VALUES (391, 3, 31);
INSERT INTO `sys_role_menu` VALUES (392, 3, 30);
INSERT INTO `sys_role_menu` VALUES (393, 3, 32);
INSERT INTO `sys_role_menu` VALUES (394, 3, 33);
INSERT INTO `sys_role_menu` VALUES (395, 3, 36);
INSERT INTO `sys_role_menu` VALUES (396, 3, 35);
INSERT INTO `sys_role_menu` VALUES (397, 3, 34);
INSERT INTO `sys_role_menu` VALUES (398, 3, 37);
INSERT INTO `sys_role_menu` VALUES (399, 3, 40);
INSERT INTO `sys_role_menu` VALUES (400, 3, 39);
INSERT INTO `sys_role_menu` VALUES (401, 3, 38);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `created` datetime(0) NULL DEFAULT NULL,
  `updated` datetime(0) NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `UK_USERNAME`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 'admin', '$2a$10$GZm0TnztL96fmBsq.DJ.ZeT26MXJHlKRxV0EIHBgVOrE8IAWtgTfu', '123@qq.com', '2021-11-27 18:58:18', '2021-12-20 12:24:34', '12345678900');
INSERT INTO `sys_user` VALUES (2, 'Tom', '$2a$10$Ksg9QpAssLuQXx39w7gcIu2a0emZfidtg69hkPaK.VAIzbgVPrBz.', 'tom@gmail.com', '2021-11-27 18:58:18', '2021-12-20 02:37:50', '12345678900');
INSERT INTO `sys_user` VALUES (3, 'Jerry', '$2a$10$lJoIGvf/9lLyseRzzneHEeCVzXmfeZhf5Dzm09lNAwwzGPTP1XdaW', 'user@gmail.com', '2021-11-21 16:39:07', '2021-12-20 12:23:44', '12345678900');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(0) NOT NULL,
  `role_id` bigint(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES (13, 2, 3);
INSERT INTO `sys_user_role` VALUES (17, 3, 6);
INSERT INTO `sys_user_role` VALUES (18, 1, 6);

SET FOREIGN_KEY_CHECKS = 1;
