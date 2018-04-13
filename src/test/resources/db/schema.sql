DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL ,
  `mobile` varchar(32) NOT NULL ,
  `nickname` varchar(32) NOT NULL ,
  `avatar` varchar(512) NOT NULL ,
  `birthday` varchar(32) DEFAULT NULL ,
  `gender` varchar(16) NOT NULL ,
  `location` varchar(255) NOT NULL ,
  `is_test` smallint(6)  NOT NULL DEFAULT '0',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `coin_quantity` int(11)  NOT NULL DEFAULT '0',
  `login_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11)  NOT NULL DEFAULT '0',
  `type` smallint(6)  NOT NULL DEFAULT '0',
  `title` varchar(128) NOT NULL ,
  `content` varchar(255) NOT NULL ,
  `action` varchar(512) NOT NULL ,
  `is_read` smallint(6)  NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `expired_time` datetime NOT NULL DEFAULT '9999-01-01 00:00:00',
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `wxpay_transaction`;
CREATE TABLE `wxpay_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` varchar(255) NOT NULL ,
  `out_trade_no` varchar(255) NOT NULL ,
  `content` text NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `alipay_transaction`;
CREATE TABLE `alipay_transaction` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `trade_no` varchar(255) NOT NULL ,
  `out_trade_no` varchar(255) NOT NULL ,
  `content` text NOT NULL,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `administrator`;
CREATE TABLE `administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL ,
  `password` varchar(255) NOT NULL ,
  `username` varchar(255) NOT NULL ,
  `notify_order` smallint(6)  NOT NULL DEFAULT '0',
  `status` smallint(6) NOT NULL DEFAULT '0',
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `system_config`;
CREATE TABLE `system_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL ,
  `value` varchar(255) NOT NULL ,
  `remark` varchar(255) NOT NULL ,
  `created_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) DEFAULT CHARSET=utf8;
