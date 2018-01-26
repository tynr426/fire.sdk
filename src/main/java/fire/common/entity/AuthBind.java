package fire.common.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AuthBind implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -856694005944356774L;
	public int Id;
	public int CompanyId;
	public int ManagerId;
	public String UnionId;
	public String OpenId;
	public String NickName;
	public int Sex;
	public String Face;
	public String IntegType;
	public Date AuthoreTime;
	public boolean IsReceiveMsg;
	public Integer Subscribe;
	private String UserName;
	private String Code;
	private String Password;
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	public int getManagerId() {
		return ManagerId;
	}
	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
	public String getUnionId() {
		return UnionId;
	}
	public void setUnionId(String unionId) {
		UnionId = unionId;
	}
	public String getOpenId() {
		return OpenId;
	}
	public void setOpenId(String openId) {
		OpenId = openId;
	}
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int sex) {
		Sex = sex;
	}
	public String getFace() {
		return Face;
	}
	public void setFace(String face) {
		Face = face;
	}
	public String getIntegType() {
		return IntegType;
	}
	public void setIntegType(String integType) {
		IntegType = integType;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	public Date getAuthoreTime() {
		return AuthoreTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setAuthoreTime(Date authoreTime) {
		AuthoreTime = authoreTime;
	}
	public boolean isIsReceiveMsg() {
		return IsReceiveMsg;
	}
	public void setIsReceiveMsg(boolean isReceiveMsg) {
		IsReceiveMsg = isReceiveMsg;
	}
	public Integer getSubscribe() {
		return Subscribe;
	}
	public void setSubscribe(Integer subscribe) {
		Subscribe = subscribe;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String Remark;
	
}
