package fire.common.entity;

import java.util.ArrayList;
import java.util.List;

public class AssignmentResult extends Assignment{
	private String Name;
	private String Description;
	private Integer DeviceTypeId;
	private List<Repairrecord> list=new ArrayList<Repairrecord>();
	private String DeviceType;
	private Integer CheckStatus;
	public Integer getCheckStatus() {
		return CheckStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		CheckStatus = checkStatus;
	}
	public String getDeviceType() {
		return DeviceType;
	}
	public List<Repairrecord> getList() {
		return list;
	}
	public void setList(List<Repairrecord> list) {
		this.list = list;
	}
	public void setDeviceType(String deviceType) {
		DeviceType = deviceType;
	}
	public Integer getDeviceTypeId() {
		return DeviceTypeId;
	}
	public void setDeviceTypeId(Integer deviceTypeId) {
		DeviceTypeId = deviceTypeId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
}
