package org.me.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

/**
 * dateUtils
 * @author cheng_bo
 * @date 2015年6月9日 14:12:23
 */
public class DateUtils {
	private Logger logger = Logger.getLogger(DateUtils.class);
	
	private SimpleDateFormat sdf;
	
	public DateUtils() {
		if(sdf==null){
			sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
	}

	/**
	 * 格式化时间
	 * @author cheng_bo
	 * @date 2015年6月9日 14:16:03
	 */
	public Date forMatDate(String strDate) {
		if(StringUtils.isEmpty(strDate)){
			logger.error("strDate is null");
			return null;
		}
		try {
			return sdf.parse(strDate);
		} catch (ParseException e) {
			logger.error("DateUtils.forMatDate error:"+e.getMessage());
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}
