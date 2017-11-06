package fire.common.entity;

public class WeiXinErrorMsg {
	/// <summary>
		/// 错误编号
		/// </summary>
		public int errcode;
		public int getErrcode() {
			return errcode;
		}
		public void setErrcode(int errcode) {
			this.errcode = errcode;
		}
		public String getErrmsg() {
			return errmsg;
		}
		public void setErrmsg(String errmsg) {
			this.errmsg = errmsg;
		}
		/// <summary>
		/// 错误提示消息
		/// </summary>
		public String errmsg; 
}
