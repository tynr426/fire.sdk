package fire.common.entity;



public class DeviceNumSummary {
	//设备名
	private String Name;
	//设备总数
	private int DeviceNum;
	//故障数量
	private int FailureNum;
	//已整改数量
	private int RectifiedNum;
	//未完成整改数量
	private int UnRectifiedNum;
	
//	private Date StartTime;
//	private Date EndTime;
//	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
//	public Date getStartTime() {
//		return StartTime;
//	}
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	public void setStartTime(Date startTime) {
//		StartTime = startTime;
//	}
//	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
//	public Date getEndTime() {
//		return EndTime;
//	}
//	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	public void setEndTime(Date endTime) {
//		EndTime = endTime;
//	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getDeviceNum() {
		return DeviceNum;
	}
	public void setDeviceNum(int deviceNum) {
		DeviceNum = deviceNum;
	}
	public int getFailureNum() {
		return FailureNum;
	}
	public void setFailureNum(int failureNum) {
		FailureNum = failureNum;
	}
	public int getRectifiedNum() {
		return RectifiedNum;
	}
	public void setRectifiedNum(int rectifiedNum) {
		RectifiedNum = rectifiedNum;
	}
	public int getUnRectifiedNum() {
		return FailureNum-RectifiedNum;
	}
	public void setUnRectifiedNum(int unRectifiedNum) {
		UnRectifiedNum = unRectifiedNum;
	}
	
}
