package fire.common.entity;

public class CheckDeviceResult extends CheckDevice{
	private String Name;
	private String Model;
	private String StatusDes;
	public String getStatusDes(){
		if(Status==0){
			StatusDes= "正常";
		}else
		if(Status==1){
			StatusDes= "待整改";
		}
		else if(Status==2){
			StatusDes= "已整改";
		}
		return StatusDes;
	}
	private String SeverityLevelDes;
	public String getSeverityLevelDes(){
	
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
