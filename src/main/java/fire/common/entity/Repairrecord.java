package fire.common.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Repairrecord {
	private int Id;
	private Integer AssignmentId;
	private Integer DeviceId;
	private Integer DeviceTypeId;
	private Integer IsFinish;
	private String Certificate;
	private String Description;
	private Integer Status;
	private Date AddTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Integer getAssignmentId() {
		return AssignmentId;
	}
	public void setAssignmentId(Integer assignmentId) {
		AssignmentId = assignmentId;
	}
	public Integer getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(Integer deviceId) {
		DeviceId = deviceId;
	}
	public Integer getDeviceTypeId() {
		return DeviceTypeId;
	}
	public void setDeviceTypeId(Integer deviceTypeId) {
		DeviceTypeId = deviceTypeId;
	}
	public Integer getIsFinish() {
		return IsFinish;
	}
	public void setIsFinish(Integer isFinish) {
		IsFinish = isFinish;
	}
	public String getCertificate() {
		return Certificate;
	}
	public void setCertificate(String certificate) {
		Certificate = certificate;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
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
		Repairrecord other = (Repairrecord) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Repairrecord [Id=" + Id + ", AssignmentId=" + AssignmentId + ", DeviceId=" + DeviceId
				+ ", DeviceTypeId=" + DeviceTypeId + ", IsFinish=" + IsFinish + ", Certificate=" + Certificate
				+ ", Description=" + Description + ", Status=" + Status + ", AddTime=" + AddTime + "]";
	}
	
}
