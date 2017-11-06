package fire.common.entity;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class WeiXinAccessTokenModel {
	/// <summary>
		/// 接口调用凭证
		/// </summary>
		public String access_token;
		/// <summary>
		/// access_token接口调用凭证超时时间，单位（秒）
		/// </summary>
		public int expires_in;
		/// <summary>
		/// 用户刷新access_token
		/// </summary>
		public String refresh_token;
		/// <summary>
		/// 授权用户唯一标识
		/// </summary>
		public String openid;
		/// <summary>
		/// 用户授权的作用域，使用逗号（,）分隔
		/// </summary>
		public String scope;
		public String getAccess_token() {
			return access_token;
		}
		public void setAccess_token(String access_token) {
			this.access_token = access_token;
		}
		public int getExpires_in() {
			return expires_in;
		}
		public void setExpires_in(int expires_in) {
			this.expires_in = expires_in;
			setExpireDate();
		}
		private Date ExpireDate;
	
		public Date getExpireDate() {
			return ExpireDate;
		}
		/*过期时间*/
		public void setExpireDate() {
			
			Date date=new   Date();//取时间
			
		    Calendar   calendar   =   new   GregorianCalendar(); 
		    calendar.setTime(date); 
		    calendar.add(calendar.MINUTE, expires_in);//把日期往后增加一年.整数往后推,负数往前移动
		    ExpireDate= calendar.getTime();
		}
		/*是否过期*/
		public boolean IsExpired(){
			Date date=new   Date();
			return date.getTime()>getExpireDate().getTime();
		}
		public String getRefresh_token() {
			return refresh_token;
		}
		public void setRefresh_token(String refresh_token) {
			this.refresh_token = refresh_token;
		}
		public String getOpenid() {
			return openid;
		}
		public void setOpenid(String openid) {
			this.openid = openid;
		}
		public String getScope() {
			return scope;
		}
		public void setScope(String scope) {
			this.scope = scope;
		}
		public WeiXinAccessTokenModel() {
		}
		
}
