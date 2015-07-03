USE memory;

-- 创建系统菜单表
DROP TABLE IF EXISTS `mem_menu`;
CREATE TABLE `mem_menu`(
	strId							VARCHAR(32)		NOT NULL,								-- id（UUID）(查询码)
	strPid							VARCHAR(32)		NOT NULL,								-- 父级id
	strName							VARCHAR(32)     NOT NULL,								-- 名称
	nLevel							INT				NOT NULL,								-- 级别
	strURL							VARCHAR(300)	NOT NULL,								-- url
	nStatus							TINYINT			NOT NULL DEFAULT 0,						-- 状态 : 0:开启  1:关闭
	nHasChild						TINYINT			NOT NULL DEFAULT 0,						-- 是否有子级: 0:无  1:有
	dtCreateTime					DATETIME		NOT NULL,								-- 创建时间:yyyy-mm-dd HH:mm:ss
	dtUpdateTime					DATETIME		NOT NULL,								-- 修改时间:yyyy-mm-dd HH:mm:ss
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;