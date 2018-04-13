SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;
-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `mobile` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `nickname` varchar(32) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `avatar` varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `birthday` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL DEFAULT '',
  `gender` varchar(16) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `location` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `is_test` smallint(6) unsigned NOT NULL DEFAULT '0',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `coin_quantity` int(11) unsigned NOT NULL DEFAULT '0',
  `login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT  COMMENT '用户表';

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL DEFAULT '0',
  `type` smallint(6) unsigned NOT NULL DEFAULT '0',
  `title` varchar(128) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `action` varchar(512) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `is_read` smallint(6) unsigned NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expired_time` datetime NOT NULL DEFAULT '9999-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT  COMMENT '消息表';

DROP TABLE IF EXISTS `wxpay_transaction`;
CREATE TABLE `wxpay_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `out_trade_no` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `trade_index` (`out_trade_no`, `transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT  COMMENT '微信支付交易表';

DROP TABLE IF EXISTS `alipay_transaction`;
CREATE TABLE `alipay_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_no` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `out_trade_no` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `trade_index` (`out_trade_no`, `trade_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT  COMMENT '支付宝支付交易表';

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `notify_order` smallint(6) unsigned NOT NULL DEFAULT '0',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT  COMMENT '后台管理员表';

DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `value` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `remark` varchar(255) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci ROW_FORMAT=COMPACT  COMMENT '系统配置表';


SET FOREIGN_KEY_CHECKS = 1;

INSERT INTO `user` VALUES (1, 'test-uuid-adsfasd-4444-aaaa', '13520664663', 'michael', 'http://www.baidu.com', '1994/12/14', 'male', 'beijing', 1, 10, 1000, '2017-08-05 22:54:07', '2017-08-05 22:54:07', '2017-08-05 22:54:07');
INSERT INTO `user` VALUES (2, 'test-uuid-aaaabbbcc-5555-aaaa', '13520664664', 'tangpan', 'http://www.baidu.com', '1994/12/14', 'female', 'beijing', 1, 10, 10, '2017-08-05 22:54:07', '2017-08-05 22:54:07', '2017-08-05 22:54:07');

INSERT INTO `message` VALUES (1, 1, 10, '测试消息标题1','测试消息内容1','http://www.qq.com', 0, '2017-08-05 22:14:07', '2017-08-05 22:14:07');
INSERT INTO `message` VALUES (2, 1, 10, '测试消息标题2','测试消息内容2','http://www.qq.com', 10, '2017-08-05 22:24:07', '2017-08-05 22:24:07');
INSERT INTO `message` VALUES (3, 1, 20, '测试消息标题3','测试消息内容3','http://www.qq.com', 0, '2017-08-05 22:34:07', '2017-08-05 22:34:07');
INSERT INTO `message` VALUES (4, 2, 10, '测试消息标题4','测试消息内容4','http://www.qq.com', 10, '2017-08-05 22:44:07', '2017-08-05 22:44:07');
INSERT INTO `message` VALUES (5, 2, 10, '测试消息标题5','测试消息内容5','http://www.qq.com', 10, '2017-08-05 22:54:07', '2017-08-05 22:54:07');
INSERT INTO `message` VALUES (6, 2, 20, '测试消息标题6','测试消息内容6','http://www.qq.com', 0, '2017-08-05 23:54:07', '2017-08-05 23:54:07');

INSERT INTO `administrator` VALUES (1, 'michaeltang@openmore.org', 'e10adc3949ba59abbe56e057f20f883e', 'Michael', 10, 10, '2017-08-04 22:54:07', '2017-08-09 16:36:50');


-- INSERT INTO `user` VALUES (2, 'testuser2', 'auth_key2', 'password_hash2', 'password_reset_token2', 'aa@openmore.org', 10, 0, 0);
-- INSERT INTO `user` VALUES (3, 'testuser3', 'auth_key3', 'password_hash3', 'password_reset_token3', 'bb@openmore.org', 10, 0, 0);
-- INSERT INTO `user` VALUES (4, 'testuser4', 'auth_key4', 'password_hash4', 'password_reset_token4', 'cc@openmore.org', 10, 0, 0);
-- INSERT INTO `user` VALUES (5, 'testuser5', 'auth_key5', 'password_hash5', 'password_reset_token5', 'dd@openmore.org', 10, 0, 0);
-- INSERT INTO `user` VALUES (6, 'testuser6', 'auth_key6', 'password_hash6', 'password_reset_token6', 'ee@openmore.org', 10, 0, 0);


