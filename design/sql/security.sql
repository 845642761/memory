USE memory;

-- 创建用户-角色对应表
DROP TABLE IF EXISTS `mem_userRole`;
CREATE TABLE `mem_userRole`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strLoginId						VARCHAR(50)		NOT NULL,											-- 用户id
	strRoleId						VARCHAR(32)		NOT NULL,											-- 角色Id
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;

-- 创建角色表
DROP TABLE IF EXISTS `mem_role`;
CREATE TABLE `mem_role`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strName							VARCHAR(32)		NOT NULL,											-- 角色名称
	strDescription					VARCHAR(100)	NOT NULL,											-- 角色描述
	nState							TINYINT			NOT NULL DEFAULT 0,									-- 状态:0-正常,1-禁用
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;

-- 创建权限表
DROP TABLE IF EXISTS `mem_permission`;
CREATE TABLE `mem_permission`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strName							VARCHAR(32)		NOT NULL,											-- 权限名称
	strPId							VARCHAR(32),														-- 父级 
	nLevel							INT				NOT NULL,											-- 级别
	strPermission					VARCHAR(100),														-- 权限标识
	strDescription					VARCHAR(200)	NOT NULL,											-- 权限描述
	nType							TINYINT			NOT NULL DEFAULT 0,									-- 类型:0-菜单,1-按钮
	nState							TINYINT			NOT NULL DEFAULT 0,									-- 状态:0-正常,1-禁用
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;

-- 创建角色-权限对应表
DROP TABLE IF EXISTS `mem_rolePermission`;
CREATE TABLE `mem_rolePermission`(
	strId							VARCHAR(32)		NOT NULL,											-- 主键Id
	strRoleId						VARCHAR(32)		NOT NULL,											-- 角色Id
	strPermissionId					VARCHAR(32)		NOT NULL,											-- 权限id
	PRIMARY KEY(strId),
	UNIQUE(strId)
)
ENGINE=INNODB
DEFAULT CHARACTER SET=utf8;