
--20181017 示例需要准备数据。创建springdata数据库后执行

CREATE TABLE `t_account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `money` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

INSERT INTO `springdata`.`t_account` (`id`, `name`, `money`) VALUES ('1', 'tom', '1000');
INSERT INTO `springdata`.`t_account` (`id`, `name`, `money`) VALUES ('2', 'jack', '1100');
INSERT INTO `springdata`.`t_account` (`id`, `name`, `money`) VALUES ('3', 'rose', '1200');
