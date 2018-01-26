package fire.common.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Assignment {
	private int Id;
	private Integer CompanyId;
	private Integer FromManagerId;
	private Integer ToManagerId;
	private Integer CheckId;
	private Date PredictTime;
	private Date AddTime;
	private String Remark;
	private String Title;
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	private Integer Status;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Integer getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(Integer companyId) {
		CompanyId = companyId;
	}
	public Integer getFromManagerId() {
		return FromManagerId;
	}
	public void setFromManagerId(Integer fromManagerId) {
		FromManagerId = fromManagerId;
	}
	public Integer getToManagerId() {
		return ToManagerId;
	}
	public void setToManagerId(Integer toManagerId) {
		ToManagerId = toManagerId;
	}
	public Integer getCheckId() {
		return CheckId;
	}
	public void setCheckId(Integer checkId) {
		CheckId = checkId;
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
	public Date getAddTime() {
		return AddTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public void setAddTime(Date addTime) {
		AddTime = addTime;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
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
		Assignment other = (Assignment) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Assignment [Id=" + Id + ", CompanyId=" + CompanyId + ", FromManagerId=" + FromManagerId
				+ ", ToManagerId=" + ToManagerId + ", CheckId=" + CheckId + ", PredictTime=" + PredictTime
				+ ", AddTime=" + AddTime + ", Remark=" + Remark + ", Status=" + Status + "]";
	}
	
}
