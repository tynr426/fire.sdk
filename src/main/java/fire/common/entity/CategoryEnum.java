package fire.common.entity;

import java.io.Serializable;

public class CategoryEnum implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3596705657778362419L;
	private int Id;
	private String EnumDesc;
	private Integer EnumValue;
	private String EnumName;
	private Integer ParentValue;
	private Integer Reorder;
	private Integer Status;
	private Integer Layer;
	private String EnumType;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getEnumDesc() {
		return EnumDesc;
	}
	public void setEnumDesc(String enumDesc) {
		EnumDesc = enumDesc;
	}
	public Integer getEnumValue() {
		return EnumValue;
	}
	public void setEnumValue(Integer enumValue) {
		EnumValue = enumValue;
	}
	public String getEnumName() {
		return EnumName;
	}
	public void setEnumName(String enumName) {
		EnumName = enumName;
	}
	public Integer getParentValue() {
		return ParentValue;
	}
	public void setParentValue(Integer parentValue) {
		ParentValue = parentValue;
	}
	public Integer getReorder() {
		return Reorder;
	}
	public void setReorder(Integer reorder) {
		Reorder = reorder;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public Integer getLayer() {
		return Layer;
	}
	public void setLayer(Integer layer) {
		Layer = layer;
	}
	public String getEnumType() {
		return EnumType;
	}
	public void setEnumType(String enumType) {
		EnumType = enumType;
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
		CategoryEnum other = (CategoryEnum) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
}
