package fire.common.entity;

import java.math.BigDecimal;
import java.util.List;

public class AssignmentSummary {
	//设备名
	private String Name;
	//完成数量
	private int CompleteCount;
	//任务数量
	private int AssignmentCount;
	//完成百分比
	private BigDecimal CompletePercent;
	
	private int Month;
	
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public List<String> getLabels() {
		return Labels;
	}
	public void setLabels(List<String> labels) {
		Labels = labels;
	}
	private List<String> Labels;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCompleteCount() {
		return CompleteCount;
	}
	public void setCompleteCount(int completeCount) {
		CompleteCount = completeCount;
	}
	public int getAssignmentCount() {
		return AssignmentCount;
	}
	public void setAssignmentCount(int assignmentCount) {
		AssignmentCount = assignmentCount;
	}
	public BigDecimal getCompletePercent() {
		return CompletePercent;
	}
	public void setCompletePercent(BigDecimal completePercent) {
		CompletePercent = completePercent;
	}
	
}
