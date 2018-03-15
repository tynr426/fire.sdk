package fire.common.entity;

import java.io.Serializable;

public class ScanInfo  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1060272669395830277L;
	private String Code;
	private Integer DeviceTypeId;
	private Integer DeviceId;
	private Integer ToManagerId;
	public Integer getToManagerId() {
		return ToManagerId;
	}
	public void setToManagerId(Integer toManagerId) {
		ToManagerId = toManagerId;
	}

	private Integer AssignmentId;
	private String AssignmentDes;
	private Integer CheckStatus;
	public Integer getCheckStatus() {
		return CheckStatus;
	}
	public void setCheckStatus(Integer checkStatus) {
		CheckStatus = checkStatus;
	}
	
	private Integer CompanyId;
	public Integer getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(Integer companyId) {
		CompanyId = companyId;
	}
	public String getAssignmentDes() {
		return AssignmentDes;
	}
	public void setAssignmentDes(String assignmentDes) {
		AssignmentDes = assignmentDes;
	}
	private String Model;
	private String DeviceTypeName;
	protected Integer Buildings;
	protected Integer Floor;
	protected String Position;
	protected String Passageway;
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public Integer getDeviceTypeId() {
		return DeviceTypeId;
	}
	public void setDeviceTypeId(Integer deviceTypeId) {
		DeviceTypeId = deviceTypeId;
	}
	public Integer getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(Integer deviceId) {
		DeviceId = deviceId;
	}
	public Integer getAssignmentId() {
		return AssignmentId;
	}
	public void setAssignmentId(Integer assignmentId) {
		AssignmentId = assignmentId;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getDeviceTypeName() {
		return DeviceTypeName;
	}
	public void setDeviceTypeName(String deviceTypeName) {
		DeviceTypeName = deviceTypeName;
	}
	public Integer getBuildings() {
		return Buildings;
	}
	public void setBuildings(Integer buildings) {
		Buildings = buildings;
	}
	public Integer getFloor() {
		return Floor;
	}
	public void setFloor(Integer floor) {
		Floor = floor;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getPassageway() {
		return Passageway;
	}
	public void setPassageway(String passageway) {
		Passageway = passageway;
	}
	public String getPositionDetail() {
		String temp="";
		if(Buildings!=null&&Buildings!=0){
			temp+=Buildings+"栋";
		}
		if(Floor!=null){
		temp+=Floor+"楼";
		}
		if(Position!=null){
		if(Position.equals("east")){
			temp+="东";
		}else if(Position.equals("west")){
			temp+="西";
		}else if(Position.equals("south")){
			temp+="南";
		}else if(Position.equals("north")){
			temp+="北";
		}
		}
		if(Passageway!=null){
		if(Passageway.equals("1")){
			temp+="安全出口";
		}
		}
		return temp;
	}
}
