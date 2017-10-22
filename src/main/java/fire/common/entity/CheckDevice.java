package fire.common.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CheckDevice {
	private int Id;
	private Integer DeviceId;
	private Integer DeviceTypeId;
	private Integer CompanyId;
	private Integer ManagerId;
	private String ManagerName;
	private String Description;
	private String Certificate;
	private Integer SeverityLevel;
	private Date AddTime;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public Integer getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(Integer companyId) {
		CompanyId = companyId;
	}
	public Integer getManagerId() {
		return ManagerId;
	}
	public void setManagerId(Integer managerId) {
		ManagerId = managerId;
	}
	public String getManagerName() {
		return ManagerName;
	}
	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getCertificate() {
		return Certificate;
	}
	public void setCertificate(String certificate) {
		Certificate = certificate;
	}
	public Integer getSeverityLevel() {
		return SeverityLevel;
	}
	public void setSeverityLevel(Integer severityLevel) {
		SeverityLevel = severityLevel;
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
		CheckDevice other = (CheckDevice) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Checkdevice [Id=" + Id + ", DeviceId=" + DeviceId + ", DeviceTypeId=" + DeviceTypeId + ", CompanyId="
				+ CompanyId + ", ManagerId=" + ManagerId + ", ManagerName=" + ManagerName + ", Description="
				+ Description + ", Certificate=" + Certificate + ", SeverityLevel=" + SeverityLevel + ", AddTime="
				+ AddTime + "]";
	}
	
}
