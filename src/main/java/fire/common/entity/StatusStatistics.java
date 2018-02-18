package fire.common.entity;

import java.io.Serializable;

public class StatusStatistics implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8795062428258623431L;
	private int Count;
	private int Status;
	public int getCount() {
		return Count;
	}
	public void setCount(int count) {
		Count = count;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
}
