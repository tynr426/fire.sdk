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
	private String PositionDetail="";
	public String getPositionDetail() {
		String temp="";
		if(Buildings!=null&&Buildings!=0){
			temp+=Buildings+"栋";
		}
		if(Floor!=null){
		temp+=Floor+"楼";
		}
		if(Position.equals("east")){
			temp+="东";
		}else if(Position.equals("west")){
			temp+="西";
		}else if(Position.equals("south")){
			temp+="南";
		}else if(Position.equals("north")){
			temp+="北";
		}
		if(Passageway.equals("1")){
			temp+="安全出口";
		}
		return temp;
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

}
