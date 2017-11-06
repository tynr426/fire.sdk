package fire.sdk.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.util.URLEncoder;
import org.json.JSONObject;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import fire.common.entity.AuthBind;
import fire.common.entity.WeiXinAccessTokenModel;
import fire.common.entity.WeiXinErrorMsg;


public class WebPageOAuth {
	private static final String GET_ACCESS_TOKEN="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%1$s&secret=%2$s&code=%3$s&grant_type=authorization_code";
	private static final String GET_CODE_URL="https://open.weixin.qq.com/connect/oauth2/authorize?appid=%1$s&redirect_uri=%2$s&response_type=code&scope=snsapi_userinfo&state=%3$s#wechat_redirect";
	private static final String GET_REFRESH_CODE="https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=%1$s&grant_type=refresh_token&refresh_token=%2$s";
	private static final String GET_USER_INFO="https://api.weixin.qq.com/sns/userinfo?access_token=%1$s&openid=%2$s&lang=zh_CN";
	private static final String GET_INFO=" https://api.weixin.qq.com/cgi-bin/user/info?access_token=%1$s&openid=%2$s&lang=zh_CN";
	//1.用户同意授权，获取code
	public static String getCodeUrl(String appId,String state,String rediect_url){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest(); 
	
		URLEncoder urlEncode = new URLEncoder();
		return String.format(GET_CODE_URL, appId,urlEncode.encode(rediect_url),state);	
	}
	//2.通过code换取网页授权access_token
	public static JsonResult getAccessToken(String appId,String secret,String code){
		String url =String.format(GET_ACCESS_TOKEN, appId,secret,code);
		String resultStr =HttpRequestUtils.sendHttpPost(url, "");
		
		if (resultStr.contains("errcode")){
			WeiXinErrorMsg error=JsonUtils.JSONToObj(resultStr, WeiXinErrorMsg.class);
			return new JsonResult(1,error,"error");
		}
		else{
			WeiXinAccessTokenModel entity=JsonUtils.JSONToObj(resultStr, WeiXinAccessTokenModel.class);
			return new JsonResult(entity);
		}
	}
	@Cacheable(value ="wechat_token",key="#wechat_token",condition="#wechat_token.IsExpired")
	//3.刷新access_token
	public static JsonResult getAccessToken(String appId,String refresh_token){
		String url =String.format(GET_REFRESH_CODE,appId,refresh_token);
		String resultStr =HttpRequestUtils.sendHttpPost(url, "");
		if (resultStr.contains("errcode")){
			WeiXinErrorMsg error=JsonUtils.JSONToObj(resultStr, WeiXinErrorMsg.class);
			return new JsonResult(1,error,"error");
		}
		else{
			WeiXinAccessTokenModel entity=JsonUtils.JSONToObj(resultStr, WeiXinAccessTokenModel.class);
			return new JsonResult(entity);
		}
	}
	
	//4.拉取用户信息
	public static JsonResult getUserInfo(String access_token,String openid){
		String url =String.format(GET_USER_INFO,access_token,openid);
		String resultStr =HttpRequestUtils.sendHttpPost(url, "");
		JSONObject jsonObject = new JSONObject(resultStr);
		if (jsonObject.has("errcode")){
			WeiXinErrorMsg error=JsonUtils.JSONToObj(resultStr, WeiXinErrorMsg.class);
			return new JsonResult(1,error,"error");
		}
		else{
			AuthBind entity=new AuthBind();
			entity.setOpenId(jsonObject.getString("openid"));
			entity.setNickName(jsonObject.getString("nickname"));
			entity.setSex(jsonObject.getInt("sex"));
			entity.setFace(jsonObject.getString("headimgurl"));
			entity.setUnionId(jsonObject.getString("unionId"));		
			return new JsonResult(entity);
		}
	}
	//.5获取用户基本信息（包括UnionID机制）
	public static JsonResult getInfo(String access_token,String openid){
		String url =String.format(GET_INFO,access_token,openid);
		String resultStr =HttpRequestUtils.sendHttpPost(url, "");
		JSONObject jsonObject = new JSONObject(resultStr);
		if (jsonObject.has("errcode")){
			WeiXinErrorMsg error=JsonUtils.JSONToObj(resultStr, WeiXinErrorMsg.class);
			return new JsonResult(1,error,"error");
		}
		else{
			AuthBind entity=new AuthBind();
			entity.setOpenId(jsonObject.getString("openid"));
			entity.setNickName(jsonObject.getString("nickname"));
			entity.setSex(jsonObject.getInt("sex"));
			entity.setFace(jsonObject.getString("headimgurl"));
			entity.setUnionId(jsonObject.getString("unionId"));	
			entity.setSubscribe(jsonObject.getInt("subscribe"));
			return new JsonResult(entity);
		}
	}
}
