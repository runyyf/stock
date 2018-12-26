-- CREATE DATABASE springboot DEFAULT CHARACTER SET utf8;

DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS stock;

-- 用户表
CREATE TABLE user(
  id BIGINT AUTO_INCREMENT COMMENT '编号',
  username VARCHAR(100) COMMENT '用户名',
  password VARCHAR(100) COMMENT '密码',
  PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;

INSERT INTO user VALUES(1, 'tycoding', '123');
INSERT INTO user VALUES(2, '涂陌', '123');

-- 股票表(5.6数据库版本之后)
CREATE TABLE stock(
  id BIGINT AUTO_INCREMENT COMMENT '编号',
  name VARCHAR(100) COMMENT '名称',
  gid VARCHAR(100) COMMENT '股票代码',
  incre_per VARCHAR(100) COMMENT '涨跌幅百分比',
  increase VARCHAR(100) COMMENT '涨跌额',
  today_start_pri VARCHAR(100) COMMENT '今日开盘价',
  yesterday_end_pri VARCHAR(100) COMMENT '昨日收盘价',
  now_pri VARCHAR(100) COMMENT '当前价格',
  today_max VARCHAR(100) COMMENT '今日最高价',
  today_min VARCHAR(100) COMMENT '今日最低价',
  pic_min_url VARCHAR(300) COMMENT '分时k线图',
  pic_day_url VARCHAR(300) COMMENT '日k线图',
  pic_week_url VARCHAR(300) COMMENT '周k线图',
  pic_month_url VARCHAR(300) COMMENT '月k线图',
  date_created DATETIME NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  date_last_update DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;

-- 5.6之前的版本date不支持CURRENT_TIMESTAMP
CREATE TABLE stock(
  id BIGINT AUTO_INCREMENT COMMENT '编号',
  name VARCHAR(100) COMMENT '名称',
  gid VARCHAR(100) COMMENT '股票代码',
  incre_per VARCHAR(100) COMMENT '涨跌幅百分比',
  increase VARCHAR(100) COMMENT '涨跌额',
  today_start_pri VARCHAR(100) COMMENT '今日开盘价',
  yesterday_end_pri VARCHAR(100) COMMENT '昨日收盘价',
  now_pri VARCHAR(100) COMMENT '当前价格',
  today_max VARCHAR(100) COMMENT '今日最高价',
  today_min VARCHAR(100) COMMENT '今日最低价',
  pic_min_url VARCHAR(300) COMMENT '分时k线图',
  pic_day_url VARCHAR(300) COMMENT '日k线图',
  pic_week_url VARCHAR(300) COMMENT '周k线图',
  pic_month_url VARCHAR(300) COMMENT '月k线图',
  date_created DATETIME  COMMENT '创建时间',
  date_last_update DATETIME COMMENT '更新时间',
  PRIMARY KEY(id)
) CHARSET=utf8 ENGINE=InnoDB;