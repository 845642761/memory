package org.me.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.me.security.dao.ISecurityDao;
import org.me.security.entity.Permission;
import org.me.security.entity.UserRole;
import org.me.security.service.ISecurityService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

/**
 * 安全 权限service实现类
 * @author: cheng_bo
 * @date: 2015年8月6日 10:49:56
 */
@Service
public class SecurityService implements ISecurityService {

	@Resource
	private ISecurityDao securityDao;
	
	/**
	 * 根据用户Id查找其角色
	 * @author: cheng_bo
	 * @date: 2015年8月6日 10:53:10
	 */
	@Override
	public List<String> getRoles(String strLoginId) {
		if(!StringUtils.hasText(strLoginId)){
			return null;
		}
		List<UserRole> ul=securityDao.getRoles(strLoginId);
		List<String> roles=new ArrayList<String>();
		for (UserRole r : ul) {
			roles.add(r.getStrRoleId());
		}
		return roles;
	}

	/**
	 * 根据roleId查询权限
	 * @author: cheng_bo
	 * @date: 2015年8月6日 11:59:46
	 */
	@Override
	public List<Permission> getPermissions(List<String> roleIds,int nLevel,int nType) {
		if(CollectionUtils.isEmpty(roleIds))
			return null;
		List<Permission> permissions=new ArrayList<Permission>();
		for (String rId : roleIds) {
			List<Permission> p=securityDao.list(rId,nLevel,nType);
			if(p!=null)
				permissions.addAll(p);
		}
		return permissions;
	}

	/**
	 * 根据用户Id查找其权限
	 * @author: cheng_bo
	 * @date: 2015年8月25日 15:22:09
	 */
	@Override
	public List<Permission> getPermissionsByLoginId(String strLoginId,int nLevel,int nType) {
		List<String> roles=getRoles(strLoginId);
		return getPermissions(roles,nLevel,nType);
	}

	/**
	 * 根据条件查找其权限
	 * @author: chengbo
	 * @date: 2015年8月25日 18:20:31
	 */
	@Override
	public List<Permission> getPermissionsByRange(Permission permission) {
		return securityDao.getPermissionsByRange(permission);
	}
}
