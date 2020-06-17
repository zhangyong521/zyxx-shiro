/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : 127.0.0.1:3306
 Source Schema         : zyxx_shiro

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 17/06/2020 15:50:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录设备',
  `code` int(11) NULL DEFAULT NULL COMMENT '状态码',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1 正常 2 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (1, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-15 15:54:45', 'Chrome -- Windows 10', 200, 'OK', 1);
INSERT INTO `login_log` VALUES (2, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-15 15:57:29', 'Chrome -- Windows 10', 200, 'OK', 1);
INSERT INTO `login_log` VALUES (3, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-15 15:59:14', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (4, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-15 17:05:21', 'Internet Explorer 11 -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (5, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-15 17:05:47', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (6, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-15 17:51:04', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (7, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-15 18:04:12', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (8, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 09:37:52', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (9, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 11:24:54', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (10, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 12:44:45', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (11, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 13:24:34', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (12, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 14:18:33', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (13, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 14:35:54', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (14, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 17:21:17', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (15, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 17:25:35', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (16, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-16 19:57:44', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (17, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 09:21:57', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (18, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 09:59:46', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (19, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:32:26', 'Chrome 8 -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (20, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:33:56', 'Chrome Mobile -- Android 1.x', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (21, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:35:33', 'Chrome 65 -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (22, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:35:55', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (23, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:38:34', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (24, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:39:20', 'Chrome Mobile -- Android 1.x', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (25, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:39:52', 'Chrome 8 -- Windows 7', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (26, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:42:56', 'Chrome 8 -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (27, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:45:37', 'Chrome 8 -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (28, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 10:50:20', 'Chrome Mobile -- Android 1.x', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (29, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 11:15:44', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (30, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 11:26:10', 'Chrome Mobile -- Android Mobile', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (31, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 11:32:53', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (32, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 11:38:28', 'Chrome 8 -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (33, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 12:38:24', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (34, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 14:36:13', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (35, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 14:38:40', 'Chrome -- Windows 10', 200, '登录成功', 1);
INSERT INTO `login_log` VALUES (36, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-06-17 14:38:59', 'Chrome -- Windows 10', 200, '登录成功', 1);

-- ----------------------------
-- Table structure for map_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `map_role_resource`;
CREATE TABLE `map_role_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '菜单/按钮ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 285 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色资源关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_role_resource
-- ----------------------------
INSERT INTO `map_role_resource` VALUES (105, 2, 1);
INSERT INTO `map_role_resource` VALUES (106, 2, 4);
INSERT INTO `map_role_resource` VALUES (107, 2, 12);
INSERT INTO `map_role_resource` VALUES (108, 2, 13);
INSERT INTO `map_role_resource` VALUES (109, 2, 14);
INSERT INTO `map_role_resource` VALUES (110, 2, 15);
INSERT INTO `map_role_resource` VALUES (111, 2, 16);
INSERT INTO `map_role_resource` VALUES (112, 2, 3);
INSERT INTO `map_role_resource` VALUES (113, 2, 11);
INSERT INTO `map_role_resource` VALUES (114, 3, 2);
INSERT INTO `map_role_resource` VALUES (115, 3, 7);
INSERT INTO `map_role_resource` VALUES (116, 3, 25);
INSERT INTO `map_role_resource` VALUES (117, 3, 26);
INSERT INTO `map_role_resource` VALUES (118, 3, 8);
INSERT INTO `map_role_resource` VALUES (119, 3, 27);
INSERT INTO `map_role_resource` VALUES (120, 3, 28);
INSERT INTO `map_role_resource` VALUES (121, 3, 9);
INSERT INTO `map_role_resource` VALUES (122, 3, 3);
INSERT INTO `map_role_resource` VALUES (123, 3, 11);
INSERT INTO `map_role_resource` VALUES (124, 4, 4);
INSERT INTO `map_role_resource` VALUES (125, 4, 12);
INSERT INTO `map_role_resource` VALUES (126, 4, 13);
INSERT INTO `map_role_resource` VALUES (127, 4, 14);
INSERT INTO `map_role_resource` VALUES (128, 4, 15);
INSERT INTO `map_role_resource` VALUES (129, 4, 16);
INSERT INTO `map_role_resource` VALUES (130, 5, 1);
INSERT INTO `map_role_resource` VALUES (131, 5, 4);
INSERT INTO `map_role_resource` VALUES (132, 5, 12);
INSERT INTO `map_role_resource` VALUES (153, 8, 1);
INSERT INTO `map_role_resource` VALUES (154, 8, 4);
INSERT INTO `map_role_resource` VALUES (155, 8, 12);
INSERT INTO `map_role_resource` VALUES (156, 8, 13);
INSERT INTO `map_role_resource` VALUES (157, 8, 14);
INSERT INTO `map_role_resource` VALUES (158, 8, 16);
INSERT INTO `map_role_resource` VALUES (159, 9, 4);
INSERT INTO `map_role_resource` VALUES (160, 9, 12);
INSERT INTO `map_role_resource` VALUES (161, 9, 13);
INSERT INTO `map_role_resource` VALUES (162, 9, 14);
INSERT INTO `map_role_resource` VALUES (163, 9, 15);
INSERT INTO `map_role_resource` VALUES (164, 9, 16);
INSERT INTO `map_role_resource` VALUES (165, 9, 30);
INSERT INTO `map_role_resource` VALUES (166, 9, 31);
INSERT INTO `map_role_resource` VALUES (167, 10, 4);
INSERT INTO `map_role_resource` VALUES (168, 10, 12);
INSERT INTO `map_role_resource` VALUES (169, 10, 13);
INSERT INTO `map_role_resource` VALUES (170, 10, 14);
INSERT INTO `map_role_resource` VALUES (171, 10, 15);
INSERT INTO `map_role_resource` VALUES (172, 10, 16);
INSERT INTO `map_role_resource` VALUES (173, 10, 30);
INSERT INTO `map_role_resource` VALUES (174, 10, 31);
INSERT INTO `map_role_resource` VALUES (175, 11, 5);
INSERT INTO `map_role_resource` VALUES (176, 11, 17);
INSERT INTO `map_role_resource` VALUES (177, 11, 18);
INSERT INTO `map_role_resource` VALUES (178, 11, 19);
INSERT INTO `map_role_resource` VALUES (179, 11, 20);
INSERT INTO `map_role_resource` VALUES (180, 12, 6);
INSERT INTO `map_role_resource` VALUES (181, 12, 21);
INSERT INTO `map_role_resource` VALUES (182, 12, 22);
INSERT INTO `map_role_resource` VALUES (183, 12, 23);
INSERT INTO `map_role_resource` VALUES (184, 12, 24);
INSERT INTO `map_role_resource` VALUES (185, 13, 7);
INSERT INTO `map_role_resource` VALUES (186, 13, 25);
INSERT INTO `map_role_resource` VALUES (187, 13, 26);
INSERT INTO `map_role_resource` VALUES (188, 13, 32);
INSERT INTO `map_role_resource` VALUES (189, 14, 7);
INSERT INTO `map_role_resource` VALUES (190, 14, 25);
INSERT INTO `map_role_resource` VALUES (191, 14, 26);
INSERT INTO `map_role_resource` VALUES (192, 14, 32);
INSERT INTO `map_role_resource` VALUES (193, 14, 8);
INSERT INTO `map_role_resource` VALUES (194, 14, 27);
INSERT INTO `map_role_resource` VALUES (195, 14, 28);
INSERT INTO `map_role_resource` VALUES (196, 15, 2);
INSERT INTO `map_role_resource` VALUES (197, 15, 9);
INSERT INTO `map_role_resource` VALUES (198, 16, 4);
INSERT INTO `map_role_resource` VALUES (199, 16, 12);
INSERT INTO `map_role_resource` VALUES (200, 16, 13);
INSERT INTO `map_role_resource` VALUES (201, 16, 14);
INSERT INTO `map_role_resource` VALUES (202, 16, 15);
INSERT INTO `map_role_resource` VALUES (203, 16, 16);
INSERT INTO `map_role_resource` VALUES (204, 16, 30);
INSERT INTO `map_role_resource` VALUES (205, 16, 31);
INSERT INTO `map_role_resource` VALUES (206, 17, 3);
INSERT INTO `map_role_resource` VALUES (207, 17, 10);
INSERT INTO `map_role_resource` VALUES (208, 17, 11);
INSERT INTO `map_role_resource` VALUES (215, 7, 1);
INSERT INTO `map_role_resource` VALUES (216, 7, 4);
INSERT INTO `map_role_resource` VALUES (217, 7, 12);
INSERT INTO `map_role_resource` VALUES (218, 7, 13);
INSERT INTO `map_role_resource` VALUES (219, 7, 14);
INSERT INTO `map_role_resource` VALUES (220, 7, 15);
INSERT INTO `map_role_resource` VALUES (221, 7, 16);
INSERT INTO `map_role_resource` VALUES (246, 1, 1);
INSERT INTO `map_role_resource` VALUES (247, 1, 4);
INSERT INTO `map_role_resource` VALUES (248, 1, 12);
INSERT INTO `map_role_resource` VALUES (249, 1, 13);
INSERT INTO `map_role_resource` VALUES (250, 1, 14);
INSERT INTO `map_role_resource` VALUES (251, 1, 15);
INSERT INTO `map_role_resource` VALUES (252, 1, 16);
INSERT INTO `map_role_resource` VALUES (253, 1, 5);
INSERT INTO `map_role_resource` VALUES (254, 1, 17);
INSERT INTO `map_role_resource` VALUES (255, 1, 18);
INSERT INTO `map_role_resource` VALUES (256, 1, 19);
INSERT INTO `map_role_resource` VALUES (257, 1, 20);
INSERT INTO `map_role_resource` VALUES (258, 1, 6);
INSERT INTO `map_role_resource` VALUES (259, 1, 21);
INSERT INTO `map_role_resource` VALUES (260, 1, 22);
INSERT INTO `map_role_resource` VALUES (261, 1, 23);
INSERT INTO `map_role_resource` VALUES (262, 1, 24);
INSERT INTO `map_role_resource` VALUES (263, 1, 7);
INSERT INTO `map_role_resource` VALUES (264, 1, 25);
INSERT INTO `map_role_resource` VALUES (265, 1, 26);
INSERT INTO `map_role_resource` VALUES (266, 1, 8);
INSERT INTO `map_role_resource` VALUES (267, 1, 27);
INSERT INTO `map_role_resource` VALUES (268, 1, 28);
INSERT INTO `map_role_resource` VALUES (269, 1, 2);
INSERT INTO `map_role_resource` VALUES (270, 1, 9);
INSERT INTO `map_role_resource` VALUES (271, 1, 3);
INSERT INTO `map_role_resource` VALUES (272, 1, 10);
INSERT INTO `map_role_resource` VALUES (273, 1, 11);
INSERT INTO `map_role_resource` VALUES (274, 18, 11);
INSERT INTO `map_role_resource` VALUES (275, 18, 3);
INSERT INTO `map_role_resource` VALUES (276, 18, 10);
INSERT INTO `map_role_resource` VALUES (277, 18, 12);
INSERT INTO `map_role_resource` VALUES (278, 19, 12);
INSERT INTO `map_role_resource` VALUES (279, 19, 13);
INSERT INTO `map_role_resource` VALUES (280, 19, 14);
INSERT INTO `map_role_resource` VALUES (281, 19, 15);
INSERT INTO `map_role_resource` VALUES (282, 19, 16);
INSERT INTO `map_role_resource` VALUES (283, 19, 30);
INSERT INTO `map_role_resource` VALUES (284, 19, 31);

-- ----------------------------
-- Table structure for map_user_role
-- ----------------------------
DROP TABLE IF EXISTS `map_user_role`;
CREATE TABLE `map_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_user_role
-- ----------------------------
INSERT INTO `map_user_role` VALUES (6, 4, 8);
INSERT INTO `map_user_role` VALUES (7, 4, 7);
INSERT INTO `map_user_role` VALUES (8, 4, 5);
INSERT INTO `map_user_role` VALUES (9, 6, 2);
INSERT INTO `map_user_role` VALUES (10, 6, 3);
INSERT INTO `map_user_role` VALUES (13, 8, 2);
INSERT INTO `map_user_role` VALUES (14, 8, 1);
INSERT INTO `map_user_role` VALUES (17, 7, 2);
INSERT INTO `map_user_role` VALUES (18, 7, 1);
INSERT INTO `map_user_role` VALUES (19, 7, 3);
INSERT INTO `map_user_role` VALUES (20, 9, 2);
INSERT INTO `map_user_role` VALUES (21, 1, 1);
INSERT INTO `map_user_role` VALUES (22, 1, 2);
INSERT INTO `map_user_role` VALUES (23, 1, 3);
INSERT INTO `map_user_role` VALUES (24, 10, 16);
INSERT INTO `map_user_role` VALUES (25, 11, 2);
INSERT INTO `map_user_role` VALUES (26, 12, 2);
INSERT INTO `map_user_role` VALUES (27, 13, 4);
INSERT INTO `map_user_role` VALUES (28, 14, 16);
INSERT INTO `map_user_role` VALUES (29, 15, 18);

-- ----------------------------
-- Table structure for mysql_dump
-- ----------------------------
DROP TABLE IF EXISTS `mysql_dump`;
CREATE TABLE `mysql_dump`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `port` int(11) NULL DEFAULT NULL COMMENT '端口',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备份路径',
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备份文件名',
  `uuid_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '随机文件名',
  `database_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库名',
  `default_character_set` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '字符编码',
  `is_compact` tinyint(4) NULL DEFAULT 0 COMMENT '压缩模式',
  `is_comments` tinyint(4) NULL DEFAULT 0 COMMENT '注释信息',
  `is_complete_insert` tinyint(4) NULL DEFAULT 0 COMMENT '使用完整的insert语句',
  `is_lock_tables` tinyint(4) NOT NULL DEFAULT 0 COMMENT '备份前，锁定所有数据库表',
  `is_no_create_db` tinyint(4) NULL DEFAULT 0 COMMENT '禁止生成创建数据库语句',
  `is_force` tinyint(4) NULL DEFAULT 0 COMMENT '当出现错误时仍然继续备份操作',
  `is_add_drop_database` tinyint(4) NULL DEFAULT 0 COMMENT '每个数据库创建之前添加drop数据库语句',
  `is_add_drop_table` tinyint(4) NULL DEFAULT 0 COMMENT '每个数据库创建之前添加drop数据库语句',
  `is_specify_table` tinyint(4) NULL DEFAULT NULL COMMENT '是否指定备份表',
  `specify_table` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '指定标明，多个使用\" \"隔开',
  `command` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终执行的命令',
  `remarks` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1正常 2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mysql_dump
-- ----------------------------
INSERT INTO `mysql_dump` VALUES (1, '127.0.0.1', 0, 'root', '123456', '/default/2020/06/12/64133230_b94b_4c5a_b197_ae569c3d1720.sql', 'seaui_shiro 测试', '64133230_b94b_4c5a_b197_ae569c3d1720', 'seaui_shiro', 'utf8', 0, 0, 0, 0, 0, 0, 0, 0, 0, NULL, 'cmd /c D:/Workspace/IDEAWorkspace/seaui-shiro/mysqldump -h127.0.0.1 -P3306 -uroot -p123456 --default-character-set=utf8 --compact --force --add-drop-database --add-drop-table --databases seaui_shiro --result-file=D:/Workspace/IDEAWorkspace/seaui-shiro/mysqldump-static/default/2020/06/12//64133230_b94b_4c5a_b197_ae569c3d1720.sql', '', '2020-06-12 15:07:01', 2);
INSERT INTO `mysql_dump` VALUES (2, '127.0.0.1', 3306, 'root', '123456', '/default/2020/06/12/e7b6ec18_1529_4499_ad34_2ccdc884b38a.sql', '测试', 'e7b6ec18_1529_4499_ad34_2ccdc884b38a', 'seaui_shiro', 'utf8', 1, 0, 0, 0, 0, 1, 1, 1, 0, NULL, 'cmd /c D:/Workspace/IDEAWorkspace/seaui-shiro/mysqldump -h127.0.0.1 -P3306 -uroot -p123456 --default-character-set=utf8 --compact --force --add-drop-database --add-drop-table --databases seaui_shiro --result-file=D:/Workspace/IDEAWorkspace/seaui-shiro/mysqldump-static/default/2020/06/12//e7b6ec18_1529_4499_ad34_2ccdc884b38a.sql', '', '2020-06-12 15:39:31', 1);

-- ----------------------------
-- Table structure for mysql_recover
-- ----------------------------
DROP TABLE IF EXISTS `mysql_recover`;
CREATE TABLE `mysql_recover`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dump_id` int(11) NOT NULL COMMENT '备份文件id',
  `ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip地址',
  `port` int(11) NULL DEFAULT NULL COMMENT '端口',
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `database_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数据库名',
  `is_create_db` tinyint(4) NULL DEFAULT NULL COMMENT '是否创建新库',
  `command` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '最终执行的命令',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) NULL DEFAULT NULL COMMENT '状态 1正常 2删除',
  PRIMARY KEY (`id`, `dump_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for resource_info
-- ----------------------------
DROP TABLE IF EXISTS `resource_info`;
CREATE TABLE `resource_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `pid` int(11) NULL DEFAULT 0 COMMENT '父级ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由地址',
  `component` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件地址',
  `perms` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '0 未使用 1 菜单 2 按钮 3 链接',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `create_user` int(11) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1 正常 2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_info
-- ----------------------------
INSERT INTO `resource_info` VALUES (1, 0, '系统管理', '/system', '/system', 'system', 1, 'shopping', 1, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (2, 0, '系统监控', '/monitor', '/montir', 'log', 1, 'skill', 2, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (3, 0, '项目文档', '/document', '/document', 'document', 1, 'tree-table', 3, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (4, 1, '用户管理', '/system/user-info/index', '/system/user-info/index', 'system:userInfo:list', 1, 'language', 4, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (5, 1, '角色管理', '/system/role-info/index', '/system/role-info/index', 'system:roleInfo:list', 1, 'message', 5, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (6, 1, '菜单管理', '/system/resource-info/index', '/system/resource-info/index', 'system:resourceInfo:list', 1, 'list', 6, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (7, 1, '系统日志', '/system/system-log/index', '/system/system-log/index', 'system:systemLog:list', 1, 'message', 7, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (8, 1, '登录日志', '/system/login-log/index', '/system/login-log/index', 'system:loginLog:list', 1, 'pdf', 8, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (9, 2, '数据监控', 'druid', 'druid', 'druid', 1, NULL, 9, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (10, 3, 'Swagger API', 'document/swagger', 'document/swagger', 'swagger', 1, NULL, 10, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (11, 3, 'GitHub 源码', 'document/github', 'document/github', 'github', 1, NULL, 11, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (12, 4, '新增用户', '/system/user-info/add', '/system/user-info/UserInfoAdd', 'system:userInfo:add', 2, NULL, 12, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (13, 4, '更新用户', '/system/user-info/update', '/system/user-info/UserInfoUpdate', 'system:userInfo:update', 2, NULL, 13, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (14, 4, '删除用户', '', '', 'system:userInfo:delete', 2, NULL, 14, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (15, 4, '查询用户', '', '', 'system:userInfo:select', 2, NULL, 15, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (16, 4, '查看用户', NULL, NULL, 'userInfo:detail', 2, NULL, 16, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (17, 5, '新增角色', NULL, NULL, 'roleInfo:add', 2, NULL, 17, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (18, 5, '更新角色', NULL, NULL, 'roleInfo:update', 2, NULL, 18, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (19, 5, '删除角色', NULL, NULL, 'roleInfo:delete', 2, NULL, 19, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (20, 5, '查询角色', NULL, NULL, 'roleInfo:select', 2, NULL, 20, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (21, 6, '新增权限', NULL, NULL, 'resourceInfo:add', 2, NULL, 21, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (22, 6, '更新权限', NULL, NULL, 'resourceInfo:update', 2, NULL, 22, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (23, 6, '删除权限', NULL, NULL, 'resourceInfo:delete', 2, NULL, 23, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (24, 6, '查询权限', NULL, NULL, 'resourceInfo:select', 2, NULL, 24, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (25, 7, '删除日志', NULL, NULL, 'systemLog:delete', 2, NULL, 1, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (26, 7, '查询日志', NULL, NULL, 'systemLog:select', 2, NULL, 26, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (27, 8, '删除日志', NULL, NULL, 'loginLog:delete', 2, NULL, 27, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (28, 8, '查询日志', NULL, NULL, 'loginLog:select', 2, NULL, 28, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (30, 4, '导入用户', '', '', 'system:userInfo:import', 2, '', 30, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (31, 4, '导出用户', '', '', 'system:userInfo:export', 2, '', 31, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (32, 7, '导出日志', '', '', 'system:systemLog:export', 2, '', 27, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `resource_info` VALUES (33, 0, '啊', '啊', NULL, '啊', 2, '啊', 0, 1, '2020-06-16 17:21:30', 1);
INSERT INTO `resource_info` VALUES (34, 33, '哎哎', '哎哎', NULL, '哎哎', 1, '哎哎', 0, 1, '2020-06-16 17:27:02', 1);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `create_user` int(11) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1 正常 2删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, 'admin', '超级管理员', 0, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `role_info` VALUES (2, 'system', '系统管理员', 0, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `role_info` VALUES (3, 'monitor', '系统监控员', 0, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `role_info` VALUES (4, 'test', '测试', 0, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `role_info` VALUES (5, 'tigger', '测试001', 0, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `role_info` VALUES (7, 'boom', '测试002', 0, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `role_info` VALUES (8, 'dom', '测试003', 0, 0, '2020-04-04 14:28:53', 1);
INSERT INTO `role_info` VALUES (16, 'aaa', '啊啊啊', 0, 0, '2020-04-04 16:20:56', 1);
INSERT INTO `role_info` VALUES (17, 'fff', '发发发', 0, 0, '2020-04-04 16:55:27', 1);
INSERT INTO `role_info` VALUES (18, 'ggg', '滚滚滚', 0, 0, '2020-04-04 17:00:07', 1);
INSERT INTO `role_info` VALUES (19, 'aaaa', '打法撒旦法', 0, 1, '2020-06-16 15:09:14', 1);

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NULL DEFAULT 0 COMMENT '操作用户id',
  `operation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `time` int(11) NULL DEFAULT 0 COMMENT '耗时(毫秒)',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作参数',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作设备',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `status` int(2) NULL DEFAULT NULL COMMENT '状态(1正常，2删除)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_log
-- ----------------------------
INSERT INTO `system_log` VALUES (1, 0, '更新角色', 24, 'cn.tellsea.sunday.system.controller.RoleInfoController.update()', '{\"roleInfo\":{\"description\":\"滚滚滚\",\"id\":18,\"limit\":0,\"name\":\"ggg\",\"page\":0,\"resourceIds\":\"3,10,11\",\"sort\":0}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-04-04 19:09:17', 1);
INSERT INTO `system_log` VALUES (2, 0, '更新角色', 75, 'cn.tellsea.sunday.system.controller.RoleInfoController.update()', '{\"roleInfo\":{\"description\":\"滚滚滚\",\"id\":18,\"limit\":0,\"name\":\"ggg\",\"page\":0,\"resourceIds\":\"3,10,11\",\"sort\":0}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-04-05 09:16:56', 1);
INSERT INTO `system_log` VALUES (3, 0, '更新角色', 138, 'cn.tellsea.sunday.system.controller.RoleInfoController.update()', '{\"roleInfo\":{\"description\":\"超级管理员\",\"id\":1,\"limit\":0,\"name\":\"admin\",\"page\":0,\"resourceIds\":\"1,4,12,13,14,15,16,5,17,18,19,20,6,21,22,23,24,7,25,26,8,27,28,2,9,3,10,11\",\"sort\":0}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-04-18 13:32:08', 1);
INSERT INTO `system_log` VALUES (4, 0, '更新菜单', 12, 'cn.tellsea.sunday.system.controller.ResourceInfoController.update()', '{\"resourceInfo\":{\"component\":\"/system\",\"icon\":\"shopping\",\"id\":1,\"limit\":0,\"name\":\"系统管理\",\"page\":0,\"perms\":\"system\",\"pid\":0,\"sort\":1,\"type\":1,\"url\":\"/system\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-04-18 13:33:32', 1);
INSERT INTO `system_log` VALUES (5, 1, '新增角色', 41, 'com.zyxx.system.controller.UserInfoController.save()', '{\"userInfo\":{\"createTime\":\"2020-06-15 16:32:14\",\"id\":12,\"limit\":0,\"nickName\":\"撒旦法撒旦\",\"page\":0,\"phone\":\"17666666666\",\"roleIds\":\"2\",\"sex\":2,\"status\":1,\"userName\":\"似懂非懂是\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-15 16:32:14', 1);
INSERT INTO `system_log` VALUES (6, 1, '新增角色', 39, 'com.zyxx.system.controller.UserInfoController.save()', '{\"userInfo\":{\"createTime\":\"2020-06-16 15:06:22\",\"id\":13,\"limit\":0,\"nickName\":\"第三方\",\"page\":0,\"phone\":\"18666666666\",\"roleIds\":\"4\",\"sex\":1,\"status\":1,\"userName\":\"大幅度\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-16 15:06:23', 1);
INSERT INTO `system_log` VALUES (7, 1, '新增角色', 35, 'com.zyxx.system.controller.UserInfoController.save()', '{\"userInfo\":{\"createTime\":\"2020-06-16 15:08:31\",\"createUser\":1,\"id\":14,\"limit\":0,\"nickName\":\"调度\",\"page\":0,\"phone\":\"18777777777\",\"roleIds\":\"16\",\"sex\":1,\"status\":1,\"userName\":\"的\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-16 15:08:31', 1);
INSERT INTO `system_log` VALUES (8, 1, '新增角色', 23, 'com.zyxx.system.controller.RoleInfoController.save()', '{\"roleInfo\":{\"createTime\":\"2020-06-16 15:09:14\",\"createUser\":1,\"description\":\"打法撒旦法\",\"id\":19,\"limit\":0,\"name\":\"aaaa\",\"page\":0,\"resourceIds\":\"12,13,14,15,16,30,31\",\"sort\":0,\"status\":1}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-16 15:09:14', 1);
INSERT INTO `system_log` VALUES (9, 1, '新增菜单', 7, 'com.zyxx.system.controller.ResourceInfoController.save()', '{\"resourceInfo\":{\"createTime\":\"2020-06-16 17:21:29\",\"createUser\":1,\"icon\":\"啊\",\"id\":33,\"limit\":0,\"name\":\"啊\",\"page\":0,\"perms\":\"啊\",\"pid\":0,\"sort\":0,\"status\":1,\"type\":1,\"url\":\"啊\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-16 17:21:30', 1);
INSERT INTO `system_log` VALUES (10, 1, '更新菜单', 19, 'com.zyxx.system.controller.ResourceInfoController.update()', '{\"resourceInfo\":{\"icon\":\"啊\",\"id\":33,\"limit\":0,\"name\":\"啊\",\"page\":0,\"perms\":\"啊\",\"sort\":0,\"type\":2,\"url\":\"啊\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-16 17:21:38', 1);
INSERT INTO `system_log` VALUES (11, 1, '新增菜单', 10, 'com.zyxx.system.controller.ResourceInfoController.save()', '{\"resourceInfo\":{\"createTime\":\"2020-06-16 17:27:02\",\"createUser\":1,\"icon\":\"哎哎\",\"id\":34,\"limit\":0,\"name\":\"哎哎\",\"page\":0,\"perms\":\"哎哎\",\"pid\":33,\"sort\":0,\"status\":1,\"type\":1,\"url\":\"哎哎\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-16 17:27:02', 1);
INSERT INTO `system_log` VALUES (12, 1, '新增用户', 48, 'com.zyxx.system.controller.UserInfoController.save()', '{\"userInfo\":{\"avatar\":\"/user_info/2020/06/17/27698129-c36f-4c6d-90b0-899252e5f771.jpg\",\"createTime\":\"2020-06-17 11:35:05\",\"createUser\":1,\"id\":15,\"limit\":0,\"nickName\":\"a\",\"page\":0,\"phone\":\"19888888888\",\"roleIds\":\"18\",\"sex\":2,\"status\":1,\"userName\":\"a\"}}', '127.0.0.1', '0|0|0|内网IP|内网IP', 'CHROME -- WINDOWS_10', '2020-06-17 11:35:05', 1);

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户，登录名，不可更改',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐值',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sex` int(1) NULL DEFAULT 0 COMMENT '性别 1男 2女',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_user` int(11) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_times` int(11) NULL DEFAULT 0 COMMENT '登录次数',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1 正常 2 禁用 3删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'Tellsea', '超级管理员', 'a994fef0ddad5f9eed20804e7b18f559', 'VKqvum8YW0xNaTDFbrcijhTG6wUP5xAZ', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2562372298,495845374&fm=26&gp=0.jpg', '18386474459', 1, 'I am Iron Man', 1, '2019-06-21 16:16:30', 12, '2019-12-20 10:15:58', 1);
INSERT INTO `user_info` VALUES (2, 'system', '系统管理员', '44eb196feb810ee770047cc34da66133', 'V1D9h266hLYqYfF5DnZCjlJKyG3Gx36c', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3041599764,2432042915&fm=26&gp=0.jpg', '15836541252', 1, '我不想打字', 1, '2019-12-24 17:07:19', 0, NULL, 1);
INSERT INTO `user_info` VALUES (3, 'monitor', '系统监控员', '221605ef8256bb0cfbbfa5fb7688eaf1', '2HI9EdHJjSYsfyqSdbWlXZRxJNXvFnrE', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=584948523,1006436504&fm=26&gp=0.jpg', '15356521441', 2, '中二病晚期', 1, '2019-12-24 17:17:17', 0, NULL, 2);
INSERT INTO `user_info` VALUES (4, 'testAdd', 'testAdd', '123456', NULL, 'http://img3.imgtn.bdimg.com/it/u=2688095354,2019872825&fm=26&gp=0.jpg', '18675455444', 2, '测试新增', 0, NULL, 0, NULL, 1);
INSERT INTO `user_info` VALUES (5, 'test', 'test', NULL, NULL, 'http://img3.imgtn.bdimg.com/it/u=2730021372,1817015653&fm=26&gp=0.jpg', '18777777777', 1, NULL, 0, '2020-05-28 10:44:19', 0, NULL, 1);
INSERT INTO `user_info` VALUES (6, 'test', 'test', NULL, NULL, 'http://img3.imgtn.bdimg.com/it/u=2730021372,1817015653&fm=26&gp=0.jpg', '18766666666', 1, NULL, 0, '2020-05-28 11:11:48', 0, NULL, 1);
INSERT INTO `user_info` VALUES (7, 'superman1', '超管1', NULL, NULL, 'http://img3.imgtn.bdimg.com/it/u=2730021372,1817015653&fm=26&gp=0.jpg', '19386666667', 1, NULL, 0, '2020-05-31 15:35:43', 0, NULL, 1);
INSERT INTO `user_info` VALUES (8, 'superman', '超管', NULL, NULL, 'http://img3.imgtn.bdimg.com/it/u=2730021372,1817015653&fm=26&gp=0.jpg', '19386666666', 1, NULL, 0, '2020-05-31 15:36:55', 0, NULL, 1);
INSERT INTO `user_info` VALUES (9, 'test', 'test', NULL, NULL, NULL, '18777777777', 1, NULL, 0, '2020-06-15 10:42:04', 0, NULL, 1);
INSERT INTO `user_info` VALUES (10, '士大夫撒发', '撒旦法师打发', NULL, NULL, NULL, '18777777777', 1, NULL, 0, '2020-06-15 16:26:16', 0, NULL, 1);
INSERT INTO `user_info` VALUES (11, '是否第三方', '啥打法上', NULL, NULL, NULL, '17666666666', 1, NULL, 0, '2020-06-15 16:27:00', 0, NULL, 1);
INSERT INTO `user_info` VALUES (12, '似懂非懂是', '撒旦法撒旦', NULL, NULL, NULL, '17666666666', 2, NULL, 0, '2020-06-15 16:32:14', 0, NULL, 1);
INSERT INTO `user_info` VALUES (13, '大幅度', '第三方', NULL, NULL, NULL, '18666666666', 1, NULL, 0, '2020-06-16 15:06:23', 0, NULL, 1);
INSERT INTO `user_info` VALUES (14, '的', '调度', NULL, NULL, NULL, '18777777777', 1, NULL, 1, '2020-06-16 15:08:31', 0, NULL, 1);
INSERT INTO `user_info` VALUES (15, 'a', 'a', NULL, NULL, '/user_info/2020/06/17/27698129-c36f-4c6d-90b0-899252e5f771.jpg', '19888888888', 2, NULL, 1, '2020-06-17 11:35:05', 0, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
