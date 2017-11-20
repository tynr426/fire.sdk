package fire.proxy.service;

import java.util.Map;

import org.json.JSONObject;

import fire.common.entity.DeviceResult;
import fire.modules.entity.FormatType;
import fire.modules.entity.ResultResponse;
import fire.sdk.utils.HttpRequestUtils;
import fire.sdk.utils.JsonResult;
import fire.sdk.utils.JsonUtils;
import fire.sdk.utils.SyncHttp;

public class ProxyBase {

	private int FK_Id;



	public int getFK_Id() {
		return FK_Id;
	}

	public void setFK_Id(int fK_Id) {
		FK_Id = fK_Id;
	}

	public ProxyBase(){

	}
	private String Action;

	public ProxyBase(int _FK_Id){

		this.FK_Id=_FK_Id;
	}
	private String _ApiUrl = "http://127.0.0.1/fire/Route";

	public String get_ApiUrl() {
		if(_ApiUrl.isEmpty())
		{
			_ApiUrl ="";

			if (!_ApiUrl.endsWith("/")) //如果最后面没有加上
			{
				_ApiUrl += "/";
			}
			return _ApiUrl += "Route.do";
		}
		return _ApiUrl;
	}

	public void set_ApiUrl(String _ApiUrl) {
		this._ApiUrl = _ApiUrl;
	}


	/// <summary>
	/// 获取远程字符串.
	///  Author:   XP-PC/Shaipe
	///  Created:  09-29-2015
	/// </summary>
	/// <param name="className">类名称.</param>
	/// <param name="actionName">动作名称.</param>
	/// <param name="parameters">参数.</param>
	/// <param name="format">获取数据格式.</param>
	/// <param name="requestMethod">请求方式.</param>
	/// <returns>System.String.</returns>
	public String GetString(String className, String actionName, Map<String, String> parameters, FormatType format, String version, String requestMethod)
	{
		String url = GetUrl(className, actionName, format, version),

				content = "";


		if (requestMethod.toLowerCase() == "POST")
		{
			content = HttpRequestUtils.sendHttpPost(url, parameters);
		}
		else
		{
			content = HttpRequestUtils.sendHttpPost(url, parameters);
		}

		return content;
	}


	/// <summary>
	/// 通过post方式获取数据并返回Dictionary格式数据.
	/// </s
	/// <summary>
	/// 获取远程字符串.
	/// </summary>
	/// <param name="className">类名称.</param>
	/// <param name="actionName">动作名称.</param>
	/// <param name="parameters">参数.</param>
	/// <param name="format">获取数据格式.</param>
	/// <param name="requestMethod">获取数据的请求方式.</param>
	/// <returns>
	/// IResultResponse
	/// </returns>
	public JsonResult GetResponse(String className, String actionName, Map<String, Object> parameters)
	{
		return GetResponse(className, actionName, parameters,FormatType.Binary,"2.0","Post");

	}


	/// <summary>
	/// 获取远程字符串.
	/// </summary>
	/// <param name="className">类名称.</param>
	/// <param name="actionName">动作名称.</param>
	/// <param name="parameters">参数.</param>
	/// <param name="format">获取数据格式.</param>
	/// <param name="requestMethod">获取数据的请求方式.</param>
	/// <returns>
	/// IResultResponse
	/// </returns>
	public JsonResult GetResponse(String className, String actionName, Map<String, Object>  parameters, FormatType format, String version, String requestMethod)
	{
		String url = GetUrl(className, actionName, format, version),

				content = "";


		if (requestMethod.toLowerCase() == "POST")
		{
			content = HttpRequestUtils.sendHttpPost(url, parameters);
		}
		else
		{
			content = HttpRequestUtils.sendHttpPost(url, parameters);
		}
		if(content==null||content.isEmpty()){
			return new JsonResult(new Exception("远程服务器报错"));
		}
		try {
			return JsonUtils.JSONToObj(content, JsonResult.class);

		} catch (Exception e) {
			return new JsonResult(e);
			// TODO: handle exception
		}


	}
	/// <summary>
	/// 获取方法.
	/// </summary>
	/// <param name="className">Name of the class.</param>
	/// <param name="actionName">Name of the action.</param>
	/// <returns></returns>
	public String GetMethod(String className, String actionName)
	{
		return String.format("method=%1$s.%2$s", className, actionName);
	}

	/// <summary>
	/// 获取调用的Url.
	///  Author:   XP-PC/Shaipe
	///  Created:  09-29-2015
	/// </summary>
	/// <param name="className">类名.</param>
	/// <param name="actionName">动作名.</param>
	/// <param name="format">数据格式.</param>
	/// <returns>System.String.</returns>
	public String GetUrl(String className, String actionName, FormatType format, String version)
	{
		String url = get_ApiUrl() + "?%1$s&fk_id=%2$s&v=%3$s&format=%4$s";
		url = String.format(url, GetMethod(className, actionName), FK_Id, version, format.toString());

		return url;
	}

	public  JsonResult httpPostSerialObject(String className, String actionName,Object serializedObject){
		String content="";
		try {
			content=SyncHttp.httpPostSerialObject(GetUrl(className,actionName,FormatType.Binary,"1.0"), 1000, 100000, serializedObject);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(content==null||content.isEmpty()){
			return new JsonResult(new Exception("远程服务器报错"));
		}
		try {
			return JsonUtils.JSONToObj(content, JsonResult.class);

		} catch (Exception e) {
			return new JsonResult(e);
			// TODO: handle exception
		}
	}

}
