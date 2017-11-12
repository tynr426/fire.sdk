package fire.common.entity;

public class MenuRelation {
	private int Id;
	private Integer CompanyId;
	private Integer ManagerId;
	private String MenuIds;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Integer getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(Integer companyId) {
		CompanyId = companyId;
	}
	public Integer getManagerId() {
		return ManagerId;
	}
	public void setManagerId(Integer managerId) {
		ManagerId = managerId;
	}
	public String getMenuIds() {
		return MenuIds;
	}
	public void setMenuIds(String menuIds) {
		MenuIds = menuIds;
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
		MenuRelation other = (MenuRelation) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	
	
}
