package fire.common.entity;

import java.io.Serializable;

public class DeviceCheckParameterValue implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4273263748499454629L;
	private int Id;
	private int CheckId;
	private int ParameterId;
	private String Value;
	private String Description;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getCheckId() {
		return CheckId;
	}
	public void setCheckId(int checkId) {
		CheckId = checkId;
	}
	public int getParameterId() {
		return ParameterId;
	}
	public void setParameterId(int parameterId) {
		ParameterId = parameterId;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
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
		DeviceCheckParameterValue other = (DeviceCheckParameterValue) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
}
