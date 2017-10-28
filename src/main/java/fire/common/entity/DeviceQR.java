package fire.common.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DeviceQR {
	private int Id;
	private Integer DeviceTypeId;
	private String Code;
	private String QRVirtural;
	private Integer IsUsed;
	private Date AddTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Integer getDeviceTypeId() {
		return DeviceTypeId;
	}
	public void setDeviceTypeId(Integer deviceTypeId) {
		DeviceTypeId = deviceTypeId;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getQRVirtural() {
		return QRVirtural;
	}
	public void setQRVirtural(String qRVirtural) {
		QRVirtural = qRVirtural;
	}
	public Integer getIsUsed() {
		return IsUsed;
	}
	public void setIsUsed(Integer isUsed) {
		IsUsed = isUsed;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	public Date getAddTime() {
		return AddTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeviceQR other = (DeviceQR) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DeviceQR [Id=" + Id + ", DeviceTypeId=" + DeviceTypeId + ", Code=" + Code + ", QRVirtural=" + QRVirtural
				+ ", IsUsed=" + IsUsed + ", AddTime=" + AddTime + "]";
	}
	
}
