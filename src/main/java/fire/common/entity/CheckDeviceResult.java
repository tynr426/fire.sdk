package fire.common.entity;

import java.util.ArrayList;
import java.util.List;

public class CheckDeviceResult extends CheckDevice{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6246664343346676036L;
	private String Name;
	private String Model;
	private String StatusDes;
	private String Detail;
	private List<DeviceCheckParameterValue> list = new ArrayList<DeviceCheckParameterValue>();
	
	public String getStatusDes(){
		if(Status==0){
			StatusDes= "正常";
		}else
		if(Status==1){
			StatusDes= "待指派";
		}
		else if(Status==2){
			StatusDes= "待整改";
		}
		else if(Status==3){
			StatusDes= "已整改";
		}
		return StatusDes;
	}
	public List<DeviceCheckParameterValue> getList() {
		return list;
	}
	public void setList(List<DeviceCheckParameterValue> list) {
		this.list = list;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	private String SeverityLevelDes;
	public String getSeverityLevelDes(){
	if(SeverityLevel==null) return SeverityLevelDes="无异常";
		switch(SeverityLevel){
			case 0:SeverityLevelDes="无异常"; break;
			case 1:SeverityLevelDes="一般"; break;
			case 2:SeverityLevelDes="比较严重"; break;
			case 3:SeverityLevelDes="特别严重"; break;
			}
		return SeverityLevelDes;
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
