/*
 Navicat Premium Data Transfer

 Source Server         : mysql-lb.imccp-mysql
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : mysql-lb.imccp-mysql:3306
 Source Schema         : route

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 24/04/2019 16:29:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_route_conf
-- ----------------------------
DROP TABLE IF EXISTS `sys_route_conf`;
CREATE TABLE `sys_route_conf`  (
  `id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键',
  `route_id` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '路由ID',
  `predicates` json NULL COMMENT '断言',
  `filters` json NULL COMMENT '过滤器',
  `uri` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `orders` int(2) NULL DEFAULT 0 COMMENT '排序',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  `del_flag` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '路由配置表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_route_conf
-- ----------------------------
INSERT INTO `sys_route_conf` VALUES ('272527876682829824', 'imccp-user-web', '[{\"args\": {\"_genkey_0\": \"/system/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://imccp-user-web', 0, '2019-04-01 10:55:19', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272529345624559616', 'imccp-security', '[{\"args\": {\"_genkey_0\": \"/securiry/**\"}, \"name\": \"Path\"}]', '[{\"args\": {\"_genkey_0\": \"1\"}, \"name\": \"StripPrefix\"}, {\"args\": {}, \"name\": \"PasswordDecoderFilter\"}, {\"args\": {}, \"name\": \"ValidateCodeGatewayFilter\"}]', 'lb://imccp-security', 0, '2019-04-01 11:01:10', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272529701007937536', 'imccp-loop-management-web', '[{\"args\": {\"_genkey_0\": \"/monitor/loop/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://imccp-loop-management-web', 0, '2019-04-01 11:02:34', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272529835934502912', 'maintain-collection-web', '[{\"args\": {\"_genkey_0\": \"/maintain/collect/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://maintain-collection-web', 0, '2019-04-01 11:03:06', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272529943824584704', 'imccp-storage-web', '[{\"args\": {\"_genkey_0\": \"/monitor/storage/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://imccp-storage-web', 0, '2019-04-01 11:03:32', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272530473611317248', 'imccp-device-web', '[{\"args\": {\"_genkey_0\": \"/monitor/device/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://imccp-device-web', 0, '2019-04-01 11:05:39', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272530549318504448', 'imccp-gb-web', '[{\"args\": {\"_genkey_0\": \"/gb/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://imccp-device-web', 0, '2019-04-01 11:05:57', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272530845792882688', 'imccp-monitor-statistics-web', '[{\"args\": {\"_genkey_0\": \"/statistics/analysis/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://imccp-monitor-statistics-web', 0, '2019-04-01 11:07:07', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272531218599399424', 'imccp-common-service-web', '[{\"args\": {\"_genkey_0\": \"/common/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}]', 'lb://imccp-common-service-web', 0, '2019-04-01 11:08:36', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272531617611927552', 'imccp-servermanagement-web', '[{\"args\": {\"_genkey_0\": \"/serverManagement/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}, {\"args\": {\"_genkey_0\": \"1\"}, \"name\": \"StripPrefix\"}]', 'lb://imccp-servermanagement-web', 0, '2019-04-01 11:10:11', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272531850118975488', 'imccp-alarmservice-web', '[{\"args\": {\"_genkey_0\": \"/alarmManager/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}, {\"args\": {\"_genkey_0\": \"1\"}, \"name\": \"StripPrefix\"}]', 'lb://imccp-alarmservice-web', 0, '2019-04-01 11:11:07', NULL, '0');
INSERT INTO `sys_route_conf` VALUES ('272531950060851200', 'imccp-village-restapi', '[{\"args\": {\"_genkey_0\": \"/cctService/**\"}, \"name\": \"Path\"}]', '[{\"args\": {}, \"name\": \"SwaggerHeaderFilter\"}, {\"args\": {\"_genkey_0\": \"1\"}, \"name\": \"StripPrefix\"}]', 'lb://imccp-village-restapi', 0, '2019-04-01 11:11:31', NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
