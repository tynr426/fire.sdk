package fire.common.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RepairrecordResult extends Repairrecord{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4371635278911112541L;
	private String Name;
	private String Model;
	private Integer CompanyId;
	private Integer ToManagerId;
	public Integer getToManagerId() {
		return ToManagerId;
	}
	public void setToManagerId(Integer toManagerId) {
		ToManagerId = toManagerId;
	}
	private Integer AssignmentId;
	private Integer AssignmentStatus;
	public Integer getAssignmentStatus() {
		return AssignmentStatus;
	}
	public void setAssignmentStatus(Integer assignmentStatus) {
		AssignmentStatus = assignmentStatus;
	}
	private Date PredictTime;
	public Integer getAssignmentId() {
		return AssignmentId;
	}
	public void setAssignmentId(Integer assignmentId) {
		AssignmentId = assignmentId;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	public Date getPredictTime() {
		return PredictTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setPredictTime(Date predictTime) {
		PredictTime = predictTime;
	}
	@JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
	public Date getAssignmentAddTime() {
		return AssignmentAddTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setAssignmentAddTime(Date assignmentAddTime) {
		AssignmentAddTime = assignmentAddTime;
	}
	public String getAssignmentRemark() {
		return AssignmentRemark;
	}
	public void setAssignmentRemark(String assignmentRemark) {
		AssignmentRemark = assignmentRemark;
	}
	private Date AssignmentAddTime;
	private String AssignmentRemark;
	public Integer getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(Integer companyId) {
		CompanyId = companyId;
	}
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
}
