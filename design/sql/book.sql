USE memory;

-- 创建账单类型表
DROP TABLE IF EXISTS `mem_bookType`;
CREATE TABLE `mem_bookType`(
	nId								int				NOT NULL AUTO_INCREMENT,							-- id
	strLoginId						VARCHAR(50)		NOT NULL,											-- 用户id（字母小写）
	strName							VARCHAR(32)		NOT NULL,											-- 名称
	PRIMARY KEY(nId,strLoginId),
	UNIQUE(nId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;

-- 创建账单表
DROP TABLE IF EXISTS `mem_books`;
CREATE TABLE `mem_books`(
	nId								int				NOT NULL AUTO_INCREMENT,							-- id
	strLoginId						VARCHAR(50)		NOT NULL,											-- 用户id
	nTypeId							int				NOT NULL,											-- 账单类型
	fMoney							float			NOT NULL,											-- 消费
	strNote							VARCHAR(200),														-- 备注
	strAddress						VARCHAR(100),														-- 地点
	dtTime							DATETIME		NOT NULL,											-- 消费时间:yyyy-mm-dd HH:mm:ss
	PRIMARY KEY(nId,strLoginId),
	UNIQUE(nId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;