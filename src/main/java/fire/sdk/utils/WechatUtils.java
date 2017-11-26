package fire.sdk.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import fire.common.entity.WeChatAccount;
import fire.proxy.service.ProxyBase;

public class WechatUtils {  
	public static String accessToken = null;  
	public static String sign(String url,WeChatAccount wca) {  
		accessToken = WechatJsSDK.getAccessToken(wca.getAppId(), wca.getSecret());  
		String jsapi_ticket = WechatJsSDK.getJSAPITicket(accessToken);


		Map<String, Object> ret = new HashMap<String, Object>();  
		String nonce_str = create_nonce_str();  
		String timestamp = create_timestamp();  

		String signature = "";  

		String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + nonce_str+ "&timestamp=" + timestamp + "&url=" + url;

		System.out.println("sign="+sign);  

		try  
		{  
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");  
			crypt.reset();  
			crypt.update(sign.getBytes("UTF-8"));
			
			signature =byteToStr(crypt.digest()); 
			System.out.println("sign="+signature);
		}
		catch (NoSuchAlgorithmException e)  
		{  
			e.printStackTrace();  
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   

		ret.put("url", url);  
		ret.put("jsapi_ticket", jsapi_ticket);  
		ret.put("nonceStr", nonce_str);  
		ret.put("timestamp", timestamp);  
		ret.put("signature", signature);  
		ret.put("appId", wca.getAppId());  


		JSONObject json = new JSONObject(ret); 
		return json.toString();  
	}  

	/**
	 * 将字节数组转换为十六进制字符串
	 * @param digest
	 * @return
	 */
	private static String byteToStr(byte[] digest) {
		// TODO Auto-generated method stub
		String strDigest = "";
		for(int i = 0; i < digest.length; i++){
			strDigest += byteToHexStr(digest[i]);
		}
		return strDigest;
	}

	/**
	 * 将字节转换为十六进制字符串
	 * @param b
	 * @return
	 */
	private static String byteToHexStr(byte b) {
		// TODO Auto-generated method stub
		char[] Digit = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(b >>> 4) & 0X0F];
		tempArr[1] = Digit[b & 0X0F];

		String s = new String(tempArr);
		return s;
	}
	/** 
	 * 随机加密 
	 * @param hash 
	 * @return 
	 */  
	private static String byteToHex(final byte[] hash) {  
		Formatter formatter = new Formatter();  
		for (byte b : hash)  
		{  
			formatter.format("%02x", b);  
		}  
		String result = formatter.toString();  
		formatter.close();  
		return result;  
	}  

	/** 
	 * 产生随机串--由程序自己随机产生 
	 * @return 
	 */  
	private static String create_nonce_str() {  
		return UUID.randomUUID().toString();  
	}  

	/** 
	 * 由程序自己获取当前时间 
	 * @return 
	 */  
	private static String create_timestamp() {  
		return Long.toString(System.currentTimeMillis() / 1000);  
	}
	@Cacheable(value=  "wechat")
	public static WeChatAccount GetWechatAccount(){
		JsonResult result= new ProxyBase().httpPostSerialObject("company.social", "getWeChatAccount",null);
		return JsonUtils.JSONToObj(JsonUtils.objectToJson(result.getData()),WeChatAccount.class)	;
	}
	@CacheEvict(value =  "wechat")
	public static void RemoveWechatAccount(){

	}
	/*判断是否微信浏览器*/
	public static boolean IsWxBrowser(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 

		String ua = request.getHeader("user-agent")  
				.toLowerCase();  
		if (ua.indexOf("micromessenger") > 0) {// 是微信浏览器  
			return true;  
		}  
		return false;
	}
}  