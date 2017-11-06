package fire.common.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DeviceQRResult extends DeviceQR{
	private String Name;
	private String Model;
	private Date UseTime;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	public Date getUseTime() {
		return UseTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setUseTime(Date useTime) {
		UseTime = useTime;
	}
	@Override
	public String toString() {
		return "DeviceQRResult [Name=" + Name + ", Model=" + Model + ", UseTime=" + UseTime + ", getBatch()="
				+ getBatch() + ", getId()=" + getId() + ", getDeviceId()=" + getDeviceId() + ", getDeviceTypeId()="
				+ getDeviceTypeId() + ", getCode()=" + getCode() + ", getQRVirtural()=" + getQRVirtural()
				+ ", getIsUsed()=" + getIsUsed() + ", getAddTime()=" + getAddTime() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + "]";
	}
	
	
}
