package org.me.security.service;

import java.util.List;

import org.me.security.entity.Permission;
/**
 * 安全 权限service
 * @author: cheng_bo
 * @date: 2015年8月6日 10:49:56
 */
public interface ISecurityService {
	public List<String> getRoles(String strLoginId);//根据用户Id查找其角色
	public List<Permission> getPermissionsByLoginId(String strLoginId,int nLevel,int nType);//根据用户Id查找其权限
	public List<Permission> getPermissions(List<String> roleIds,int nLevel,int nType);//根据角色Id查找其权限
	public List<Permission> getPermissionsByRange(Permission permission);//根据条件查找其权限
}