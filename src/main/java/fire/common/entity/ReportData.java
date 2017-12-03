package fire.common.entity;

import java.util.ArrayList;
import java.util.List;

public class ReportData {
	private String Label;
	private List<Integer> Data=new ArrayList<Integer>();
	public String getLabel() {
		return Label;
	}
	public List<Integer> getData() {
		return Data;
	}
	public void setData(List<Integer> data) {
		Data = data;
	}
	public void setLabel(String label) {
		Label = label;
	}
}
