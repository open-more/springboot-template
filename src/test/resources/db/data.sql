BEGIN;

INSERT INTO `user` VALUES (1, 'test-uuid-adsfasd-4444-aaaa', '13520664663', 'michael', 'http://www.baidu.com', '1994/12/14', 'male', 'beijing', 1, 10, 1000, '2017-08-05 22:54:07', '2017-08-05 22:54:07', '2017-08-05 22:54:07');
INSERT INTO `user` VALUES (2, 'test-uuid-aaaabbbcc-5555-aaaa', '13520664664', 'tangpan', 'http://www.baidu.com', '1994/12/14', 'female', 'beijing', 1, 10, 10, '2017-08-05 22:54:07', '2017-08-05 22:54:07', '2017-08-05 22:54:07');
INSERT INTO `message` VALUES (1, 1, 10, '测试消息标题1','测试消息内容1','http://www.qq.com', 0, '2017-08-05 22:14:07', '2017-08-05 22:14:07');
INSERT INTO `message` VALUES (2, 1, 10, '测试消息标题2','测试消息内容2','http://www.qq.com', 10, '2017-08-05 22:24:07', '2017-08-05 22:24:07');
INSERT INTO `message` VALUES (3, 1, 20, '测试消息标题3','测试消息内容3','http://www.qq.com', 0, '2017-08-05 22:34:07', '2017-08-05 22:34:07');
INSERT INTO `message` VALUES (4, 2, 10, '测试消息标题4','测试消息内容4','http://www.qq.com', 10, '2017-08-05 22:44:07', '2017-08-05 22:44:07');
INSERT INTO `message` VALUES (5, 2, 10, '测试消息标题5','测试消息内容5','http://www.qq.com', 10, '2017-08-05 22:54:07', '2017-08-05 22:54:07');
INSERT INTO `message` VALUES (6, 2, 20, '测试消息标题6','测试消息内容6','http://www.qq.com', 0, '2017-08-05 23:54:07', '2017-08-05 23:54:07');

INSERT INTO `administrator` VALUES (1, 'michaeltang@openmore.org', 'e10adc3949ba59abbe56e057f20f883e', 'Michael', 10, 10, '2017-08-04 22:54:07', '2017-08-09 16:36:50');

INSERT INTO `system_config` VALUES (1, 'appversion','1.0','http://www.qq.com','2017-08-05 23:54:07', '2017-08-05 23:54:07');
INSERT INTO `system_config` VALUES (2, 'appip','192.168.1.1','http://www.qq.com','2017-08-05 23:54:07', '2017-08-05 23:54:07');
COMMIT;