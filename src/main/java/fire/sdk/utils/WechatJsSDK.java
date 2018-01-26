package fire.sdk.utils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class WechatJsSDK {
	private static final String GET_ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%1$s&secret=%2$s";

	private static final String GET_JSAPI_TICKET="https://api.weixin.qq.com/cgi-bin/ticket/getticket?type=jsapi&access_token=%1$s";

	private static final String GET_JSAPI_MEDIA="https://api.weixin.qq.com/cgi-bin/media/get?access_token=%1$s&media_id=%2$s";
	
	
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
		String key="WechatConstants";
		String token="";
		Cache obj= CacheUtils.getCacheInfo(key);
		if(obj==null){
			String url =String.format(GET_ACCESS_TOKEN, APPID,APPSECRET);
			String resultStr =HttpRequestUtils.sendHttpPost(url, "");

			try {
				JSONObject jsonObject = new JSONObject(resultStr);
				token = jsonObject.getString("access_token");

				Cache c = new Cache();
				c.setValue(token);
				c.setTimeOut(7000*1000);
				c.setExpired(false);
				CacheUtils.putCache(key, c);

			} catch (JSONException e) {
				// e.printStackTrace();
			}
			return token;
		}
		else{
			return obj.getValue().toString();
		}
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
	/*
	 * 获取临时素材
	 */
	public static InputStream getMedia(String APPID, String APPSECRET,String mediaId) {

	    String access_token = getAccessToken(APPID,APPSECRET);
	    String url = String.format(GET_JSAPI_MEDIA, access_token,mediaId);
	    
	
	       InputStream is = null;
	       try {
	           URL urlGet = new URL(url);
	           HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
	           http.setRequestMethod("GET"); // 必须是get方式请求
	           http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	           http.setDoOutput(true);
	           http.setDoInput(true);
	           http.connect();
	           // 获取文件转化为byte流
	           is = http.getInputStream();
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	    return is;
	}

}