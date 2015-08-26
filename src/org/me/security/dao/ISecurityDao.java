package org.me.security.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.me.security.entity.Permission;
import org.me.security.entity.UserRole;

/**
 * 安全 权限Dao
 * @author: cheng_bo
 * @date: 2015年8月6日 10:57:24
 */
public interface ISecurityDao {
	public List<UserRole> getRoles(String strLoginId);//根据用户Id查找其角色
	public List<Permission> list(@Param("roleId") String roleId,@Param("nLevel") int nLevel,@Param("nType") int nType);//根据角色Id查找其权限资源
	public List<Permission> getPermissionsByRange(Permission permission);//根据条件查找其权限
}
