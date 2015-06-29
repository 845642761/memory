USE memory;

-- 创建留言簿表
DROP TABLE IF EXISTS `mem_note`;
CREATE TABLE `mem_note`(
	strId							VARCHAR(32)		NOT NULL,								-- id（UUID）(查询码)
	strTitle						VARCHAR(32),											-- 标题
	strLoginId						VARCHAR(32),											-- 发起人
	strLoginName					VARCHAR(32),											-- 发起人名称
	tNote							text,													-- 内容
	dtTime							DATETIME,												-- 发起时间
	nState							TINYINT			NOT NULL DEFAULT 0,						-- 状态,0-待审核,1-正常,2-禁用
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;


-- 创建留言簿回复表
DROP TABLE IF EXISTS `mem_noteBack`;
CREATE TABLE `mem_noteBack`(
	nId								int				NOT NULL AUTO_INCREMENT,				-- id
	strId							VARCHAR(32)		NOT NULL,								-- noteId
	tNote							text,													-- 内容
	dtTime							DATETIME,												-- 回复时间
	nState							TINYINT			NOT NULL DEFAULT 0,						-- 状态,0-待审核,1-正常,2-禁用
	PRIMARY KEY(nId),
	UNIQUE(nId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;