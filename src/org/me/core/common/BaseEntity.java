package org.me.core.common;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.util.StringUtils;

/**
 * @description: 基类
 * @author: cheng_bo
 * @date: 2015年7月3日 11:58:42
 */
public abstract class BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	
	public BaseEntity() {
		id=getId();
		if(!StringUtils.hasText(id)){
			UUID uuid=UUID.randomUUID();
			id=uuid.toString().replace("-", "");
		}
	}
	public abstract String getId();
	public abstract void setUUId(String id);
}
