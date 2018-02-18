package fire.common.entity;

public class AuthBindResult extends AuthBind{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1166073859997877079L;
	private String ManagerName;
	private String UserName;
	public String getManagerName() {
		return ManagerName;
	}
	public void setManagerName(String managerName) {
		ManagerName = managerName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
}
