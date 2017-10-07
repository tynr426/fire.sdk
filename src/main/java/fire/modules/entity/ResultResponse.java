package fire.modules.entity;

import java.lang.reflect.Type;

public class ResultResponse {

	//类型
	private Type ContentType;
	public Type getContentType() {
		return ContentType;
	}

	public void setContentType(Type contentType) {
		ContentType = contentType;
	}
//格式化类型
	public FormatType getFormatType() {
		return FormatType;
	}

	public void setFormatType(FormatType formatType) {
		FormatType = formatType;
	}
//内容
	public Object getContent() {
		return Content;
	}

	public void setContent(Object content) {
		Content = content;
	}

	public Boolean getSuccess() {
		return Success;
	}

	public void setSuccess(Boolean success) {
		Success = success;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getStackTrace() {
		return StackTrace;
	}

	public void setStackTrace(String stackTrace) {
		StackTrace = stackTrace;
	}


	private FormatType FormatType;

	private Object Content;

	private Boolean Success;

	private String Code;

	private String Message;

	private String StackTrace;

	public ResultResponse SetCode(String code) {
	       Code = code;
	        return this;
	 }

    /// <summary>
    /// 获得成功结果
    /// </summary>
    /// <param name="content">The content.</param>
    /// <param name="type">The type.</param>
    /// <returns>
    /// IResultResponse
    /// </returns>
    public static ResultResponse GetSuccessResult(Object content, Type type)
    {
        return GetSuccessResult(content, "成功", type);
    }
    /// <summary>
    /// 获得成功结果
    /// </summary>
    /// <param name="content">内容数据.</param>
    /// <param name="message">The message.</param>
    /// <param name="type">The type.</param>
    /// <returns>
    /// IResultResponse
    /// </returns>
    public static ResultResponse GetSuccessResult(Object content, String message, Type type)
    {
        if (type == null)
        {
            type = content.getClass();
        }
        ResultResponse response= new ResultResponse();
        response.setContentType(type);
        response.setContent(content);
        response.setMessage(message);
        response.setCode("200");
        response.setSuccess(true);
        return response;
    
   
    }

    /// <summary>
    /// 获得失败结果
    /// </summary>
    /// <param name="content"></param>
    /// <returns></returns>
    public static ResultResponse ExceptionResult(Object content)
    {
        return ExceptionResult(content, "失败");
    }

    /// <summary>
    /// 获得失败结果
    /// </summary>
    /// <param name="content"></param>
    /// <param name="message"></param>
    /// <returns></returns>
    public static ResultResponse ExceptionResult(Object content, String message)
    {
         ResultResponse response= new ResultResponse();
        
            response.setContent(content);
            response.setMessage(message);
            response.setCode("500");
            response.setSuccess(false);
        return response;
    }

    /// <summary>
    ///  返回异常结果.
    /// </summary>
    /// <param name="content">返回内容.</param>
    /// <param name="ex">异常对象.</param>
    /// <returns>ECF.IResultResponse.</returns>
    public static ResultResponse ExceptionResult(Object content, Exception ex)
    {
    	 ResultResponse response= new ResultResponse();
         
         response.setContent(content);
         if(ex!=null){
         response.setMessage(ex.getMessage());
         response.setStackTrace(ex.getStackTrace().toString());
         }
         response.setCode("500");
         response.setSuccess(false);
         return response;
    }


    /// <summary>
    /// 转换为Json,默认情况
    /// </summary>
    /// <returns>
    /// System.String
    /// </returns>

	@Override
	public String toString() {
		return "ResultResponse [ContentType=" + ContentType + ", FormatType=" + FormatType + ", Content=" + Content
				+ ", Success=" + Success + ", Code=" + Code + ", Message=" + Message + ", StackTrace=" + StackTrace
				+ "]";
	}

}
