package fire.common.entity;

public class Menu {
	private int Id;
	private Integer ParentId;
	private String MenuName;
	private String Link;
	private String CssClass;
	private String Icon;
	private String Src;
	private Integer Layer;
	private Integer Reorder;
	private String Target;
	private Integer Status;
	private String Remark;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Integer getParentId() {
		return ParentId;
	}
	public void setParentId(Integer parentId) {
		ParentId = parentId;
	}
	public String getMenuName() {
		return MenuName;
	}
	public void setMenuName(String menuName) {
		MenuName = menuName;
	}
	public String getLink() {
		return Link;
	}
	public void setLink(String link) {
		Link = link;
	}
	public String getCssClass() {
		return CssClass;
	}
	public void setCssClass(String cssClass) {
		CssClass = cssClass;
	}
	public String getIcon() {
		return Icon;
	}
	public void setIcon(String icon) {
		Icon = icon;
	}
	public String getSrc() {
		return Src;
	}
	public void setSrc(String src) {
		Src = src;
	}
	public Integer getLayer() {
		return Layer;
	}
	public void setLayer(Integer layer) {
		Layer = layer;
	}
	public Integer getReorder() {
		return Reorder;
	}
	public void setReorder(Integer reorder) {
		Reorder = reorder;
	}
	public String getTarget() {
		return Target;
	}
	public void setTarget(String target) {
		Target = target;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
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
		Menu other = (Menu) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Menu [Id=" + Id + ", ParentId=" + ParentId + ", MenuName=" + MenuName + ", Link=" + Link + ", CssClass="
				+ CssClass + ", Icon=" + Icon + ", Src=" + Src + ", Layer=" + Layer + ", Reorder=" + Reorder
				+ ", Target=" + Target + ", Status=" + Status + ", Remark=" + Remark + "]";
	}
	
}
