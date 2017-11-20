package fire.sdk.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class WechatJsSDK {
	private static final String GET_ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%1$s&secret=%2$s";
	
	private static final String GET_JSAPI_TICKET="https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=%1$s";
	
	/**
	 * 获取access_token，然后jsapi_ticket
	 */
	public  static String getAccessToken_ticket(String path,String appId,String appSecret) {
		String access_token = null; // access_token
		String atime = null;// 获取时间
		String a_expires_in = null;// 有效时间(s)
		String ticket = null;// jsapi_ticket
		String ttime = null;// 得到时间
		String t_expires_in = null;// 有效时间(s)
		String access_tokenStr = WechatJsSDK.getAccessToken(appId,appSecret);
		if (access_tokenStr != null
				&& access_tokenStr.indexOf("access_token") != -1) {
			try {
				JSONObject jsonObject = new JSONObject(access_tokenStr);
				access_token = jsonObject.getString("access_token");
				a_expires_in = jsonObject.getString("expires_in");
				atime = System.currentTimeMillis()+"";
			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}
		if (access_token != null && !access_token.equals("")) {
			String ticketStr = WechatJsSDK.getJSAPITicket(access_token);
			// System.out.println("ticketStr:" + ticketStr);
			if (ticketStr != null && ticketStr.indexOf("ticket") != -1) {
				try {
					JSONObject jsonObject = new JSONObject(ticketStr);
					ticket = jsonObject.getString("ticket");
					t_expires_in = jsonObject.getString("expires_in");
					ttime = System.currentTimeMillis()+"";
				} catch (JSONException e) {
					// e.printStackTrace();
				}
			}
		}
		String result = null;
		if (ticket != null && !ticket.equals("")) {
			result = "{\"access_token\":\"" + access_token
					+ "\",\"a_expires_in\":\"" + a_expires_in
					+ "\",\"atime\":\"" + atime + "\",\"ticket\":\"" + ticket
					+ "\",\"t_expires_in\":\"" + t_expires_in
					+ "\",\"ttime\":\"" + ttime + "\"}";
			
		}
		return result;
	}
	public static String getAccessToken(String APPID, String APPSECRET) {

		String url =String.format(GET_ACCESS_TOKEN, APPID,APPSECRET);
		String resultStr =HttpRequestUtils.sendHttpPost(url, "");
		String token="";
		try {
			JSONObject jsonObject = new JSONObject(resultStr);
			token = jsonObject.getString("access_token");
			
		} catch (JSONException e) {
			// e.printStackTrace();
		}
		return token;

	}


	/**
	 * 根据access_token获取ticket { "errcode":0, "errmsg":"ok", "ticket":
	 * "bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA"
	 * , "expires_in":7200 }
	 * 
	 * @param access_token
	 * @return
	 */
	public static String getJSAPITicket(String access_token) {
		String url = String.format(GET_JSAPI_TICKET, access_token);
		String access_tokenStr = HttpRequestUtils.sendHttpPost(url, "");
		if (access_tokenStr != null
				&& access_tokenStr.indexOf("ticket") != -1) {
			try {
				JSONObject jsonObject = new JSONObject(access_tokenStr);
			    return 	access_token = jsonObject.getString("ticket");
				
			} catch (JSONException e) {
				// e.printStackTrace();
			}
		}
		return "";
	}
	
}