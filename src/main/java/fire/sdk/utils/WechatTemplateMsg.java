package fire.sdk.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import fire.common.entity.WechatSendAttr;


public class WechatTemplateMsg {
	private static final String SEND_MESSAGE="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%1$s";

	private String _appId;
	private String _secret;
	private String _url;
	public WechatTemplateMsg(String appId,String secret,String url){
		this._appId=appId;
		this._secret=secret;
		this._url=url;

	}
	public  JsonResult Send(String openId,String title,String assignmentType,String positionDetail,String severityLevel,String description,String checkDate,String remark){
		Map<String, Object> map=new HashMap<String,Object>();
		map.put("touser",openId);
		map.put("template_id","dsiVatQX4ZMDwo2F-euTkQBo1ZtG0L1A8AXour8JS4k");
		map.put("url",_url); 
		Map<String,WechatSendAttr> attr=new HashMap<String,WechatSendAttr>();
		attr.put("first", new WechatSendAttr(title));
		attr.put("keyword1", new WechatSendAttr(assignmentType));
		attr.put("keyword2", new WechatSendAttr(positionDetail));
		attr.put("keyword3", new WechatSendAttr(severityLevel));
		attr.put("keyword4", new WechatSendAttr(description));
		attr.put("keyword5", new WechatSendAttr(checkDate));
		attr.put("remark", new WechatSendAttr(remark));
		map.put("data", attr);
		return Send(map);
	}
	public JsonResult Send(Map<String, Object> map){

		String token=WechatJsSDK.getAccessToken(_appId, _secret,false);
		String url=String.format(SEND_MESSAGE, token);
		String resultStr =HttpRequestUtils.sendHttpPost(url,JsonUtils.objectToJson(map));
		JSONObject jsonObject = new JSONObject(resultStr);
		if (resultStr.contains("errcode")){
			return new JsonResult(-1,new Throwable((String) jsonObject.get("errmsg")));
		}
		else{

			return new JsonResult((String)jsonObject.getString("msgid"));
		}
	}
}
