package fire.common.entity;

import java.io.Serializable;
import java.util.List;

public class DeviceResult extends Device  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7980232114754736119L;
	private String Name;
	private String Code;
	private String PositionDetail;
	public String getPositionDetail() {
		if(Buildings!=0){
			PositionDetail+=Buildings+"栋";
		}
		PositionDetail+=Floor+"楼";
		if(Position.equals("east")){
			PositionDetail+="东";
		}else if(Position.equals("west")){
			PositionDetail+="西";
		}else if(Position.equals("south")){
			PositionDetail+="南";
		}else if(Position.equals("north")){
			PositionDetail+="北";
		}
		if(Passageway.equals("1")){
			PositionDetail+="安全出口";
		}
		return PositionDetail;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	private List<DeviceParameterValue> list;
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<DeviceParameterValue> getList() {
		return list;
	}

	public void setList(List<DeviceParameterValue> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "DeviceResult [Name=" + Name + ", list=" + list + ", getCompanyId()=" + getCompanyId() + ", getId()="
				+ getId() + ", getDeviceTypeId()=" + getDeviceTypeId() + ", getModel()=" + getModel()
				+ ", getManufacturer()=" + getManufacturer() + ", getSpec()=" + getSpec() + ", getUseTime()="
				+ getUseTime() + ", getAddTime()=" + getAddTime() + ", getBuildings()=" + getBuildings()
				+ ", getFloor()=" + getFloor() + ", getPosition()=" + getPosition() + ", getPassageway()="
				+ getPassageway() + ", getDetail()=" + getDetail() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + "]";
	}
	
}
