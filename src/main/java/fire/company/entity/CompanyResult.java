package fire.company.entity;


public class CompanyResult extends Company{
	private String UserName;
	private String Password;
	private int CompanyId;
	private int ManagerId;
	private String NickName;
	public String getNickName() {
		return NickName;
	}
	public void setNickName(String nickName) {
		NickName = nickName;
	}
	public String getFace() {
		return Face;
	}
	public void setFace(String face) {
		Face = face;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getMobile() {
		return Mobile;
	}
	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	private String Face;
	private String Email;
	private String Mobile;
	public int getManagerId() {
		return ManagerId;
	}
	public void setManagerId(int managerId) {
		ManagerId = managerId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getCompanyId() {
		return CompanyId;
	}
	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}
	private String Token;
	public String getToken() {
		return Token;
	}
	public void setToken(String token) {
		Token = token;
	}
	@Override
	public String toString() {
		return "CompanyResult [UserName=" + UserName + ", Password=" + Password + ", CompanyId=" + CompanyId
				+ ", ManagerId=" + ManagerId + ", getId()=" + getId() + ", getName()=" + getName() + ", getCode()="
				+ getCode() + ", getLogo()=" + getLogo() + ", getIntro()=" + getIntro() + ", getIndustry()="
				+ getIndustry() + ", getProvince()=" + getProvince() + ", getCity()=" + getCity() + ", getArea()="
				+ getArea() + ", getAddress()=" + getAddress() + ", getPassed()=" + getPassed() + ", getStatus()="
				+ getStatus() + ", getReorder()=" + getReorder() + ", getAddTime()=" + getAddTime() + ", getRemark()="
				+ getRemark() + ", getLevelId()=" + getLevelId() + ", getTel()=" + getTel() + ", getSN()=" + getSN()
				+ ", getAtten()=" + getAtten() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + "]";
	}
}