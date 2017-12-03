package fire.common.entity;

import java.util.ArrayList;
import java.util.List;

public class ReportSummary {
	private List<String> Labels=new ArrayList<String>();
	
	private  List<ReportData> DataSet=new ArrayList<ReportData>();
	public List<String> getLabels() {
		return Labels;
	}
	public void setLabels(List<String> listLables) {
		this.Labels = listLables;
	}
	
	public List<ReportData> getDataSet() {
		return DataSet;
	}
	public void setDataSet(List<ReportData> dataSet) {
		DataSet = dataSet;
	}

	
}
