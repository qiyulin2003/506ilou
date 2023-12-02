/*
 Navicat MySQL Data Transfer

 Source Server         : localhost123
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 127.0.0.1:3306
 Source Schema         : dzgw

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 27/11/2023 19:09:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dzgw
-- ----------------------------
DROP TABLE IF EXISTS `dzgw`;
CREATE TABLE `dzgw`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `gwbz` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公文备注',
  `gwurl` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公文地址',
  `user_id` int NULL DEFAULT NULL COMMENT '创建id',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int NULL DEFAULT 0 COMMENT '公文状态',
  `del_flag` int NULL DEFAULT 0 COMMENT '是否删除',
  `file_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公文文件id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of dzgw
-- ----------------------------
INSERT INTO `dzgw` VALUES (10, '234234', '0495B80B12617AE2224F81E50C44B478DCC429FD40E758A6663C29CCDB815ED00959641535C5E9CB748028BA71920F6939422551F7C777F51FAD6C9F88D9168239EAD1B07E0412AD1B23A14C7543173CB46AA635E78FF258B2DC4D4326ECE41C17A5E678330F221A2E2CD068DE903F8C67C6', 101, '2023-11-26 12:34:40', 0, 0, '61d441fabe054c409ae80e760706d13c');

-- ----------------------------
-- Table structure for gwfile
-- ----------------------------
DROP TABLE IF EXISTS `gwfile`;
CREATE TABLE `gwfile`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `filepath` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `filename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `fileurl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gwfile
-- ----------------------------
INSERT INTO `gwfile` VALUES ('61d441fabe054c409ae80e760706d13c', 'D://dzgw//20231126//', '结婚礼金.txt', 'D://dzgw//20231126//结婚礼金.txt', '2023-11-26 12:34:39');

-- ----------------------------
-- Table structure for gz
-- ----------------------------
DROP TABLE IF EXISTS `gz`;
CREATE TABLE `gz`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户名称',
  `base_gz` float NULL DEFAULT NULL COMMENT '基本工资',
  `jt` float NULL DEFAULT NULL COMMENT '交通补贴',
  `qj` float NULL DEFAULT NULL COMMENT '请假扣除',
  `cd` float NULL DEFAULT NULL COMMENT '迟到早退',
  `jb` float NULL DEFAULT NULL COMMENT '加班补贴',
  `cc` float NULL DEFAULT NULL COMMENT '出差补贴',
  `rc` float NULL DEFAULT NULL COMMENT '人才补贴',
  `cb` float NULL DEFAULT NULL COMMENT '餐补',
  `mq` float NULL DEFAULT NULL COMMENT '满勤',
  `wx` float NULL DEFAULT NULL COMMENT '五险一金',
  `gl` float NULL DEFAULT NULL COMMENT '工龄补贴',
  `gs` float NULL DEFAULT NULL COMMENT '个人所得税',
  `zj` float NULL DEFAULT NULL COMMENT '总计',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of gz
-- ----------------------------
INSERT INTO `gz` VALUES (1, 101, '杜小宇', 5000, 300, 791, 0, 240, 400, 1500, 200, 200, 674.833, 100, 32.205, 6441.96, '2023-03-26 09:53:28');
INSERT INTO `gz` VALUES (2, 1, '若依', 6000, 300, 0, 40, 0, 0, 1500, 200, 200, 816, 0, 70.32, 7273.68, '2023-03-26 09:53:28');

-- ----------------------------
-- Table structure for moehu_user
-- ----------------------------
DROP TABLE IF EXISTS `moehu_user`;
CREATE TABLE `moehu_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `user_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的手机号',
  `user_pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的密码',
  `user_real_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户真实姓名',
  `user_id_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户身份证',
  `user_email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `user_bank_card` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户银行卡',
  `user_sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户性别',
  `user_work` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的职业',
  `user_head_img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户头像',
  `user_nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户默认昵称',
  `user_uid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户申请账号的固定ID，不可修改',
  `user_reg_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '用户注册的时间',
  `user_ip` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户最后一次登录ip',
  `user_birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户出生日期',
  `user_constellation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户的星座',
  `user_autograph` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '这个人很懒，什么都没有！' COMMENT '用户签名',
  `user_iscover` int NOT NULL DEFAULT 0 COMMENT '用户是否接稿',
  `user_issubscribe` int NULL DEFAULT 0 COMMENT '用户是否打开订阅',
  `user_isshop` int NULL DEFAULT 0 COMMENT '用户是否打开小铺',
  `user_ismanuscripts` int NULL DEFAULT 0 COMMENT '用户是否打开约稿',
  `user_online` int NULL DEFAULT NULL COMMENT '用户是否在线',
  `user_iskefu` int NULL DEFAULT 0 COMMENT '用户是否是客服(0 不是 1 是)',
  `user_type` int NULL DEFAULT NULL COMMENT '用户类型（0系统用户 1注册用户 2 家长 3 教练）',
  `class_id` int NULL DEFAULT NULL COMMENT '班级id',
  `child_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '孩子手机号',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10024 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of moehu_user
-- ----------------------------
INSERT INTO `moehu_user` VALUES (22, '18056794700', '123123', NULL, NULL, '.@qq.com', NULL, '通用', NULL, 'https://moehu02.oss-cn-hangzhou.aliyuncs.com/imger/913aee62bb914ba9af93ffc84a957df1-file.jpeg', '有趣的4700', 'a9bf69f0eab2492798c1d7b40b7544d6', '2022-07-04 16:14:14', NULL, '', NULL, '这个人很懒，什么都没有！', 1, 0, 0, 0, 1, 1, 0, 10, NULL);
INSERT INTO `moehu_user` VALUES (10004, '18056794705', '123123', NULL, NULL, NULL, NULL, NULL, NULL, 'https://moehu01.oss-cn-shanghai.aliyuncs.com/img/dfe305b73bf44c718260b4df4b57cec6-1651911149065初始头像.jpg', '123123123', 'a9bf69f0eab2492798c1d7b40b7544d9', '2022-08-16 16:07:27', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, 0, 0, 3, 10, NULL);
INSERT INTO `moehu_user` VALUES (10005, '18056794701', '123123', NULL, NULL, NULL, NULL, NULL, NULL, 'https://moehu01.oss-cn-shanghai.aliyuncs.com/img/dfe305b73bf44c718260b4df4b57cec6-1651911149065初始头像.jpg', '未知用户4701', 'eb2c8ee834094f3ca2b8b7b0f5342e62', '2022-11-13 10:16:05', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 3, 10, NULL);
INSERT INTO `moehu_user` VALUES (10013, '18056794706', '111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '123123', '6154988eea5d4388955baf258fb064ee', '2023-03-03 08:49:21', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 1, 10, NULL);
INSERT INTO `moehu_user` VALUES (10015, '18056794711', '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'duxiaoyu', '17e81ddef3664e2283d38441961b431c', '2023-03-03 09:02:35', NULL, NULL, NULL, '123123123123', 0, 0, 0, 0, NULL, 0, NULL, 9, NULL);
INSERT INTO `moehu_user` VALUES (10016, '18056794779', '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '杜小宇', '735cf4408ad048558d7bf7ef261bbf0b', '2023-03-03 17:25:41', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 0, 10, NULL);
INSERT INTO `moehu_user` VALUES (10017, '18056794768', '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '杜小宇', '23bf9a4006e645979a00d98948a3100f', '2023-03-03 17:26:50', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 0, 10, NULL);
INSERT INTO `moehu_user` VALUES (10018, '18056794713', '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '杜小宇', 'db582999f9494e378d32129ef93bbd36', '2023-03-03 17:27:19', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 0, 10, NULL);
INSERT INTO `moehu_user` VALUES (10019, '18056794789', '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '杜小宇', 'cc83d9a067ff4d42897bd2dfb019e3c8', '2023-03-06 08:32:51', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 1, 10, '18056794700');
INSERT INTO `moehu_user` VALUES (10020, '18056794769', '111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '李老师', 'ae9578b7931247c88eb41d55fa358c83', '2023-03-06 09:11:34', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 3, 10, '');
INSERT INTO `moehu_user` VALUES (10021, '18056794764', '111111', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '杜加急', 'b7b967d8c3c34197845d83d12264bba1', '2023-03-06 09:21:25', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 2, 10, '18056794700');
INSERT INTO `moehu_user` VALUES (10022, '18056794715', '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, '测试001', '828bad176b7e40e2bac1e0b10606ecb4', '2023-03-08 11:25:11', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 1, 10, '');
INSERT INTO `moehu_user` VALUES (10023, '18056794732', '123123', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'ceshi002', '27d2238123894415bcefe0bf5394e858', '2023-03-08 11:26:05', NULL, NULL, NULL, '这个人很懒，什么都没有！', 0, 0, 0, 0, NULL, 0, 1, 10, '');

-- ----------------------------
-- Table structure for sys_clockin
-- ----------------------------
DROP TABLE IF EXISTS `sys_clockin`;
CREATE TABLE `sys_clockin`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  `user_id` int NULL DEFAULT NULL COMMENT '用户id',
  `islate` int NULL DEFAULT NULL COMMENT '是否迟到早退',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_clockin
-- ----------------------------
INSERT INTO `sys_clockin` VALUES (1, '2023-03-23 08:00:00', 1, 0);
INSERT INTO `sys_clockin` VALUES (2, '2023-03-25 08:00:00', 1, 0);

-- ----------------------------
-- Table structure for sys_dept
-- ----------------------------
DROP TABLE IF EXISTS `sys_dept`;
CREATE TABLE `sys_dept`  (
  `dept_id` bigint NOT NULL AUTO_INCREMENT COMMENT '部门id',
  `dept_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '部门名称',
  `leader` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '删除标志（0代表存在 2代表删除）',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10003 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_dept
-- ----------------------------
INSERT INTO `sys_dept` VALUES (10000, '财务', 'cww', '18056794700', '2803042223@qq.com', '0', '', '2023-03-23 14:06:15');
INSERT INTO `sys_dept` VALUES (10001, '开发', 'kf', '18056794711', '123@qq.com', '0', '', '2023-03-23 14:07:13');
INSERT INTO `sys_dept` VALUES (10002, '销售', 'dux03', '18056794705', '456@qq.com', '0', '', '2023-03-23 14:08:00');


-- ----------------------------
-- Table structure for sys_gz
-- ----------------------------
DROP TABLE IF EXISTS `sys_gz`;
CREATE TABLE `sys_gz`  (
  `chidao` float NULL DEFAULT NULL COMMENT '迟到',
  `zaotui` float NULL DEFAULT NULL COMMENT '早退',
  `quanqin` float NULL DEFAULT NULL COMMENT '全勤',
  `fanbu` float NULL DEFAULT NULL COMMENT '饭补',
  `jiaobu` float NULL DEFAULT NULL COMMENT '交通补贴',
  `chaibu` float NULL DEFAULT NULL COMMENT '出差补贴',
  `caibu` float NULL DEFAULT NULL COMMENT '人才补贴',
  `glbu` float NULL DEFAULT NULL COMMENT '工龄补贴',
  `wx` float NULL DEFAULT NULL COMMENT '五险一金',
  `jbbu` float NULL DEFAULT NULL COMMENT '加班补贴'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_gz
-- ----------------------------
INSERT INTO `sys_gz` VALUES (20, 20, 200, 200, 300, 150, 1500, 200, 0, 10);

-- ----------------------------
-- Table structure for sys_leave
-- ----------------------------
DROP TABLE IF EXISTS `sys_leave`;
CREATE TABLE `sys_leave`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '假条id',
  `user_id` int NULL DEFAULT NULL COMMENT '请假人',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请假理由',
  `start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '截至时间',
  `time_num` float NULL DEFAULT NULL COMMENT '请假时长',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int NULL DEFAULT 0 COMMENT '状态 0 待审批 1 通过 2 拒绝',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_leave
-- ----------------------------
INSERT INTO `sys_leave` VALUES (3, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 10, '2023-03-23 17:09:12', 1);
INSERT INTO `sys_leave` VALUES (4, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 8, '2023-03-23 17:09:30', 1);
INSERT INTO `sys_leave` VALUES (5, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 7, '2023-03-23 17:09:32', 0);
INSERT INTO `sys_leave` VALUES (6, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 43, '2023-03-23 17:09:33', 0);
INSERT INTO `sys_leave` VALUES (7, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 20, '2023-03-23 17:09:35', 1);
INSERT INTO `sys_leave` VALUES (8, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 12, '2023-03-23 17:09:41', 0);
INSERT INTO `sys_leave` VALUES (9, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 45, '2023-03-23 17:09:43', 2);
INSERT INTO `sys_leave` VALUES (10, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 36, '2023-03-23 17:09:45', 0);
INSERT INTO `sys_leave` VALUES (11, 101, '事假', '2023-03-23 00:00', '2023-03-24 00:00', 96, '2023-03-23 17:09:46', 0);

-- ----------------------------
-- Table structure for sys_overtime
-- ----------------------------
DROP TABLE IF EXISTS `sys_overtime`;
CREATE TABLE `sys_overtime`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '加班记录id',
  `user_id` int NULL DEFAULT NULL COMMENT '加班用户',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '加班理由',
  `start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '截至时间',
  `time_num` float NULL DEFAULT NULL COMMENT '加班时长',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int NULL DEFAULT 0 COMMENT '状态 0 待审批 1 通过 2 拒绝',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_overtime
-- ----------------------------
INSERT INTO `sys_overtime` VALUES (12, 101, '啊实打实', '2023-03-24 00:00', '2023-03-25 00:00', 24, '2023-03-24 11:51:57', 0);
INSERT INTO `sys_overtime` VALUES (13, 101, '11111', '2023-11-17 10:45', '2023-11-29 14:50', 292, '2023-11-17 10:46:44', 0);

-- ----------------------------
-- Table structure for sys_trip
-- ----------------------------
DROP TABLE IF EXISTS `sys_trip`;
CREATE TABLE `sys_trip`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '加班记录id',
  `user_id` int NULL DEFAULT NULL COMMENT '加班用户',
  `content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '加班理由',
  `start_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '开始时间',
  `end_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '截至时间',
  `time_num` float NULL DEFAULT NULL COMMENT '加班时长',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` int NULL DEFAULT 0 COMMENT '状态 0 待审批 1 通过 2 拒绝',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_trip
-- ----------------------------
INSERT INTO `sys_trip` VALUES (13, 101, '阿松大', '2023-03-24', '2023-03-26', 2, '2023-03-24 13:24:20', 0);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` int NOT NULL AUTO_INCREMENT COMMENT '用户工号',
  `dept_id` int NULL DEFAULT NULL COMMENT '部门ID',
  `login_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录账号',
  `user_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户名称',
  `user_type` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '00' COMMENT '用户类型（00系统用户 01管理员）',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '用户邮箱',
  `phonenumber` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '手机号码',
  `sex` varchar(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '用户性别',
  `age` int NULL DEFAULT NULL COMMENT '用户年龄',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '头像路径',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '密码',
  `salt` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '盐加密',
  `status` int NULL DEFAULT 0 COMMENT '帐号状态（0正常 1停用）',
  `del_flag` int NULL DEFAULT 0 COMMENT '删除标志（0代表存在 2代表删除）',
  `login_ip` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '最后登录IP',
  `login_date` datetime NULL DEFAULT NULL COMMENT '最后登录时间',
  `pwd_update_date` datetime NULL DEFAULT NULL COMMENT '密码最后更新时间',
  `create_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '创建者',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间（入职时间）',
  `xl` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学历',
  `work` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职位',
  `work_age` float NULL DEFAULT NULL COMMENT '工龄',
  `gz` float NULL DEFAULT NULL COMMENT '工资',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, 10000, 'admin', '若依', '11', 'ry@163.com', '15888888888', '男', 25, '', '123123', '111111', 0, 0, '127.0.0.1', '2023-02-17 10:37:01', '2023-02-17 10:37:01', 'admin', '2023-02-17 10:37:01', NULL, NULL, NULL, 6000);
INSERT INTO `sys_user` VALUES (101, 10002, '123123', '杜小宇', '00', '2803042223@qq.com', '18056794700', '男', 30, '', '123123', '', 0, 0, '', NULL, NULL, '', '2023-03-23 15:48:50', '硕士', '开发123', NULL, 5000);

SET FOREIGN_KEY_CHECKS = 1;
