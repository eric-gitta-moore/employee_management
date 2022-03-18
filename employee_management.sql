/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 127.0.0.1:3306
 Source Schema         : employee_management

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 18/03/2022 21:04:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for em_attachment
-- ----------------------------
DROP TABLE IF EXISTS `em_attachment`;
CREATE TABLE `em_attachment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '路径',
  `comment` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` datetime NULL DEFAULT NULL COMMENT '创建者',
  `update_by` datetime NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '附件表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for em_corporate_information
-- ----------------------------
DROP TABLE IF EXISTS `em_corporate_information`;
CREATE TABLE `em_corporate_information`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corporate_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实体租户名称（企业名称）（企业全称）',
  `corporate_contact_person_name` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业联系人（企业管理员）',
  `tenants_number` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '实体租户编号',
  `operations_status` enum('sign_out','enable','pause') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'enable' COMMENT '运营状态',
  `review_status` enum('verified','not_approved','pending_reward') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'pending_reward' COMMENT '审核状态 ',
  `time_efficiency_start` datetime NULL DEFAULT NULL COMMENT '时效,开始',
  `time_efficiency_end` datetime NULL DEFAULT NULL COMMENT '时效,结束',
  `logo` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业logo',
  `industry` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '所属行业',
  `legal_entity` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业法人',
  `contact_phone` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业联系人电话',
  `summary` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '企业简介',
  `certificate_for_uniform_social_credit_code` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '统一社会信用代码',
  `business_license` int(11) NULL DEFAULT NULL COMMENT '企业工商营业执照（三证合一），图片',
  `legal_entity_identity_card` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业法人身份证号',
  `legal_entity_identity_card_img_positive` int(11) NULL DEFAULT NULL COMMENT '企业法人身份证，正面（国徽），图片',
  `legal_entity_identity_card_img_rear` int(11) NULL DEFAULT NULL COMMENT '企业法人身份证，反面（人像），图片',
  `contact_person_identity_card_img_positive` int(11) NULL DEFAULT NULL COMMENT '企业联系人身份证号，正面（国徽），图片',
  `contact_person_identity_card_img_rear` int(11) NULL DEFAULT NULL COMMENT '企业联系人身份证号，反面（人像），图片',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` int(11) NULL DEFAULT NULL COMMENT '创建者',
  `update_by` int(11) NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业信息管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_corporate_information
-- ----------------------------
INSERT INTO `em_corporate_information` VALUES (1, 'XXX信息科技有限公司', '张三', 'JH-20210001', 'enable', 'verified', '2021-09-10 00:00:00', '2099-12-31 23:59:59', NULL, '电子信息', '边姝妍', '13659630009', '企业简介是介绍公司什么时间成立、住所地、规模、经营范围、法定代表 人、有何特点等等。所谓简介，也就是让他人通过您写的简介能了解你们公司的 一些基本情况，或者您想要重点介绍你们公司的哪一方面的情况。', '913101175821220588', NULL, '632323190605266240', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for em_corporate_user_account
-- ----------------------------
DROP TABLE IF EXISTS `em_corporate_user_account`;
CREATE TABLE `em_corporate_user_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `corporate_id` int(11) NULL DEFAULT NULL COMMENT '所属企业（关联企业信息管理表）',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '常用手机号',
  `corporate_user_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业用户编号',
  `status` enum('sign_out','enable','pause') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'enable' COMMENT '状态(enable:启用,paus:暂停,sign_out:注销)',
  `type` enum('admin','user') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'user' COMMENT '类型(admin:企业管理员,user:企业用户)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '创建者',
  `update_by` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '企业用户账号管理' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_corporate_user_account
-- ----------------------------

-- ----------------------------
-- Table structure for em_department
-- ----------------------------
DROP TABLE IF EXISTS `em_department`;
CREATE TABLE `em_department`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `superior_department` int(11) NULL DEFAULT NULL COMMENT '上级部门id,0为顶级部门',
  `owner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '负责人',
  `comment` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` datetime NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '部门表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_department
-- ----------------------------

-- ----------------------------
-- Table structure for em_employee
-- ----------------------------
DROP TABLE IF EXISTS `em_employee`;
CREATE TABLE `em_employee`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `sex` enum('male','female') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `job` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '职务',
  `status` enum('formal','on_trial','quit','pending_resignation') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态(formal:正式,on_trial:试用,quit:离职,pending_resignation:待离职)',
  `entry_time` datetime NULL DEFAULT NULL COMMENT '入职时间',
  `departure_time` datetime NULL DEFAULT NULL COMMENT '离职时间',
  `avatar` int(11) NULL DEFAULT NULL COMMENT '头像（附件表ID）',
  `employee_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工编号',
  `department_id` int(11) NULL DEFAULT NULL COMMENT '所属部门id',
  `management_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理范围',
  `post` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '岗位',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类型',
  `regular_time` datetime NULL DEFAULT NULL COMMENT '转正时间',
  `comment` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建者',
  `update_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_employee
-- ----------------------------

-- ----------------------------
-- Table structure for em_person_user_account
-- ----------------------------
DROP TABLE IF EXISTS `em_person_user_account`;
CREATE TABLE `em_person_user_account`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '常用手机号',
  `corporate_user_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '企业用户编号',
  `status` enum('sign_out','enable','pause') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'enable' COMMENT '状态(enable:启用,paus:暂停,sign_out:注销)',
  `type` enum('user') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'user' COMMENT '类型(user:个人用户)',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '创建者',
  `update_by` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '个人用户账号' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_person_user_account
-- ----------------------------

-- ----------------------------
-- Table structure for em_product_orders
-- ----------------------------
DROP TABLE IF EXISTS `em_product_orders`;
CREATE TABLE `em_product_orders`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '产品名称',
  `package_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐名称',
  `package_version` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '套餐版本',
  `active_time` datetime NULL DEFAULT NULL COMMENT '开通时间',
  `payment` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付方式',
  `order_status` enum('wait_to_pay','paid') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'wait_to_pay' COMMENT '订单状态',
  `subscription_status` enum('inactive','pending_manual_activate','auto_activate') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'inactive' COMMENT '产品开通状态',
  `amount_paid` decimal(10, 2) NULL DEFAULT NULL COMMENT '实付金额',
  `coupon_amount` decimal(10, 2) NULL DEFAULT NULL COMMENT '优惠金额',
  `package_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '套餐价格',
  `time_efficiency_start` datetime NULL DEFAULT NULL COMMENT '套餐时效，开始',
  `time_efficiency_end` datetime NULL DEFAULT NULL COMMENT '套餐时效，结束',
  `invoice_status` enum('unbilled','invoiced') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'unbilled' COMMENT '发票状态',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` datetime NULL DEFAULT NULL COMMENT '创建者',
  `update_by` datetime NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品订单' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_product_orders
-- ----------------------------

-- ----------------------------
-- Table structure for em_product_review
-- ----------------------------
DROP TABLE IF EXISTS `em_product_review`;
CREATE TABLE `em_product_review`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `corporate_id` int(11) NULL DEFAULT NULL COMMENT '企业id',
  `product_order_id` int(11) NULL DEFAULT NULL COMMENT '产品订单id',
  `submit_reason` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '开通理由',
  `manifest_file` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '证明文件，可能有N个（用|分开）',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `create_by` datetime NULL DEFAULT NULL COMMENT '创建者',
  `update_by` datetime NULL DEFAULT NULL COMMENT '更新者',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品提交审核' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of em_product_review
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
