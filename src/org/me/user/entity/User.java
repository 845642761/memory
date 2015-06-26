package org.me.user.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * user
 * @author cheng_bo
 * @date:2015年5月21日 17:43:29
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String strLoginId;					// 登录id（字母小写）
	private String strName;						// 姓名
	private int nSex;							// 性别, 0-未填写,1-男,2-女
	private String strMobile;					// 手机号
	private String strPhone;					// 紧急联系人
	private String strEmail;					// 邮箱
	private String strQQ;						// QQ
	private String strWeChar;					// 微信
	private String strProvinceCode;				// 所属省id
	private String strProvinceName;				// 所属省名称
	private String strCityCode;					// 所属城市id
	private String strCityName;					// 所属城市id
	private Date dtBirthday;					// 出生日期:yyyy-mm-dd HH:mm:ss
	private String strAddress;					// 地址
	private String strHeadURL;					// 头像
	private Date dtCreateTime;					// 注册时间:yyyy-mm-dd HH:mm:ss
	private Date dtUpdateTime;					// 修改时间:yyyy-mm-dd HH:mm:ss
	
	public User() {
	}
	
	public int getnSex() {
		return nSex;
	}

	public void setnSex(int nSex) {
		this.nSex = nSex;
	}

	public String getStrPhone() {
		return strPhone;
	}

	public void setStrPhone(String strPhone) {
		this.strPhone = strPhone;
	}

	public String getStrEmail() {
		return strEmail;
	}

	public void setStrEmail(String strEmail) {
		this.strEmail = strEmail;
	}

	public String getStrQQ() {
		return strQQ;
	}

	public void setStrQQ(String strQQ) {
		this.strQQ = strQQ;
	}

	public String getStrWeChar() {
		return strWeChar;
	}

	public void setStrWeChar(String strWeChar) {
		this.strWeChar = strWeChar;
	}

	public String getStrProvinceCode() {
		return strProvinceCode;
	}

	public void setStrProvinceCode(String strProvinceCode) {
		this.strProvinceCode = strProvinceCode;
	}

	public String getStrProvinceName() {
		return strProvinceName;
	}

	public void setStrProvinceName(String strProvinceName) {
		this.strProvinceName = strProvinceName;
	}

	public String getStrCityCode() {
		return strCityCode;
	}

	public void setStrCityCode(String strCityCode) {
		this.strCityCode = strCityCode;
	}

	public String getStrCityName() {
		return strCityName;
	}

	public void setStrCityName(String strCityName) {
		this.strCityName = strCityName;
	}

	public String getStrHeadURL() {
		return strHeadURL;
	}

	public void setStrHeadURL(String strHeadURL) {
		this.strHeadURL = strHeadURL;
	}

	public String getStrLoginId() {
		return strLoginId;
	}

	public void setStrLoginId(String strLoginId) {
		this.strLoginId = strLoginId;
	}

	public String getStrMobile() {
		return strMobile;
	}

	public void setStrMobile(String strMobile) {
		this.strMobile = strMobile;
	}

	public Date getDtBirthday() {
		return dtBirthday;
	}

	public void setDtBirthday(Date dtBirthday) {
		this.dtBirthday = dtBirthday;
	}

	public String getStrAddress() {
		return strAddress;
	}

	public void setStrAddress(String strAddress) {
		this.strAddress = strAddress;
	}

	public Date getDtCreateTime() {
		return dtCreateTime;
	}

	public void setDtCreateTime(Date dtCreateTime) {
		this.dtCreateTime = dtCreateTime;
	}

	public Date getDtUpdateTime() {
		return dtUpdateTime;
	}

	public void setDtUpdateTime(Date dtUpdateTime) {
		this.dtUpdateTime = dtUpdateTime;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}
}
