
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `administrator`
-- ----------------------------
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `username` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `notify_order` smallint(6) unsigned NOT NULL DEFAULT '0',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='后台管理员表';

-- ----------------------------
--  Records of `administrator`
-- ----------------------------
BEGIN;
INSERT INTO `administrator` VALUES ('1', 'michaeltang@openmore.org', 'e10adc3949ba59abbe56e057f20f883e', 'MichaelTang2', '10', '10', '2017-08-31 20:39:16', '2017-08-31 21:04:10');
COMMIT;

-- ----------------------------
--  Table structure for `alipay_transaction`
-- ----------------------------
DROP TABLE IF EXISTS `alipay_transaction`;
CREATE TABLE `alipay_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `out_trade_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `trade_index` (`out_trade_no`,`trade_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='支付宝支付交易表';

-- ----------------------------
--  Table structure for `message`
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL DEFAULT '0',
  `type` smallint(6) unsigned NOT NULL DEFAULT '0',
  `title` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `action` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `is_read` smallint(6) NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expired_time` datetime NOT NULL DEFAULT '9999-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=373 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='消息表';

-- ----------------------------
--  Records of `message`
-- ----------------------------
BEGIN;
INSERT INTO `message` VALUES
  ('1', '1', '20', '作品已卖出', '你的作品已经卖出，收入200金币！', '', '0', '2017-10-18 11:48:44', '9999-01-01 00:00:00'),
  ('2', '1', '10', '测试消息标题2', '测试消息内容2', 'http://www.qq.com', '0', '2017-08-05 22:24:07', '2017-08-05 22:24:07'),
  ('4', '2', '10', '测试消息标题4', '测试消息内容4', 'http://www.qq.com', '10', '2017-08-05 22:44:07', '2017-08-05 22:44:07'),
  ('5', '2', '10', '测试消息标题5', '测试消息内容5', 'http://www.qq.com', '10', '2017-08-05 22:54:07', '2017-08-05 22:54:07'),
  ('6', '2', '20', '测试消息标题6', '测试消息内容6', 'http://www.qq.com', '0', '2017-08-05 23:54:07', '2017-08-05 23:54:07');
COMMIT;

-- ----------------------------
--  Table structure for `system_config`
-- ----------------------------
DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `value` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `remark` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='系统配置表';

BEGIN;
INSERT INTO `system_config` VALUES
  ('1', 'app_config', '{"exhibition_price":1000,"auction_rate":10}', 'remark', '2017-11-16 20:07:14', '2017-11-16 20:07:14');
COMMIT;

-- ----------------------------
--  Table structure for `third_authorizations`
-- ----------------------------
DROP TABLE IF EXISTS `third_authorizations`;
CREATE TABLE `third_authorizations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL DEFAULT '0',
  `third_uid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `third_party` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `wechat_unionid` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=253 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='订单状态表';

-- ----------------------------
--  Records of `third_authorizations`
-- ----------------------------
BEGIN;
INSERT INTO `third_authorizations` VALUES
  ('1', '3', '5c1b0323-52d5-45aa-9bf1-c118f53208fe', 'qq', '', '2017-08-07 00:00:46', '2017-08-08 11:28:34'),
  ('2', '4', '963050eb-b331-46a0-8a9d-78632b946b68', 'qq', '', '2017-08-07 00:22:26', '2017-08-07 00:22:26'),
  ('3', '5', '4aa71cd6-7505-43dd-b2c9-52596e33e55e', 'qq', '', '2017-08-07 00:24:14', '2017-08-07 00:24:14'),
  ('4', '6', '555c9562-e4a2-4ee1-a431-91dbed44897d', 'qq', '', '2017-08-07 00:29:51', '2017-08-07 00:29:51'),
  ('5', '7', '50a36b42-a237-4e8c-85d5-82a3862756f4', 'qq', '', '2017-08-07 00:35:38', '2017-08-07 00:35:38'),
  ('6', '8', 'b4b87727-e0cb-46a1-9e0d-fb7714570e18', 'qq', '', '2017-08-07 00:36:42', '2017-08-07 00:36:42');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `mobile` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `nickname` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `avatar` varchar(512) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `birthday` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '',
  `gender` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `location` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `is_test` smallint(6) NOT NULL DEFAULT '0',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `coin_quantity` int(11) unsigned NOT NULL DEFAULT '0',
  `login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=327 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='用户表';

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES
  ('1', 'aisdjfajsfijasfj', '13520664663', 'MichaelTang', 'http://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTJdy57U40RXkqPjGvYP7z1Rm5HwiczCQOalX9eTmS04CACmWIu5oXlPzTIicrcmXqfrn6kIrbgP28Jg/0', 'akldsjf', 'alkdjsflkj', 'asdklfjl', '1', '10', '1764', '2017-10-28 08:22:54', '2017-08-05 22:54:07', '2017-10-28 08:22:29'),
  ('2', 'adhsfuihwqiluhfi', '132139819238', 'aksjdf', 'http://photo.avatar.com', 'asdlkjf', 'alsdkjflk', 'sdlkfj', '1', '10', '0', '2017-08-05 22:54:24', '2017-08-05 22:54:24', '2017-08-17 10:57:53'),
  ('3', 'd0e4f8fb-4f6f-4319-9a3e-5f239cc77dc3', '', 'testuserZUQGKZ', '', '', '', '', '0', '0', '0', '2017-08-08 11:15:08', '2017-08-07 00:00:46', '2017-08-07 00:00:46'),
  ('4', 'bb86849f-fa72-4ba3-87a1-72ec0a5cbf22', '', 'testuser22QPG3', '', '', '', '', '0', '0', '0', '2017-08-07 00:22:26', '2017-08-07 00:22:26', '2017-08-07 00:22:26'),
  ('5', '0d2349e0-1d4c-4688-bd6e-307c47bfdddd', '', 'testuserHWULMB', '', '', '', '', '0', '0', '0', '2017-08-07 00:24:13', '2017-08-07 00:24:13', '2017-08-07 00:24:13'),
  ('6', 'd38ad1bf-e56f-4f91-a50b-272bd63390cf', '', 'testuserH6NL7V', '', '', '', '', '0', '0', '0', '2017-08-07 00:29:51', '2017-08-07 00:29:51', '2017-08-07 00:29:51'),
  ('7', 'ef4d374f-7503-48a0-a59e-b62b3c1b04da', '', 'testuserTKUH4N', '', '', '', '', '0', '0', '0', '2017-08-07 00:35:38', '2017-08-07 00:35:38', '2017-08-07 00:35:38'),
  ('8', '306bc2c6-dd17-44a3-90df-ed9e9ae62303', '', 'testuserZCCTML', '', '', '', '', '0', '0', '0', '2017-08-07 00:36:42', '2017-08-07 00:36:42', '2017-08-07 00:36:42');
COMMIT;

-- ----------------------------
--  Table structure for `wxpay_transaction`
-- ----------------------------
DROP TABLE IF EXISTS `wxpay_transaction`;
CREATE TABLE `wxpay_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `out_trade_no` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '',
  `content` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `trade_index` (`out_trade_no`,`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='微信支付交易表';

SET FOREIGN_KEY_CHECKS = 1;

