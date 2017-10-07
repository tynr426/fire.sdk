package fire.modules.entity;

import java.lang.reflect.Type;

public class RequestData {

	private Type ContentType;

	private Object Content;

	public Type getContentType() {
		return ContentType;
	}

	public void setContentType(Type contentType) {
		ContentType = contentType;
	}

	public Object getContent() {
		return Content;
	}

	public void setContent(Object content) {
		Content = content;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	private String Action;
   	 /// <summary>
    /// Initializes a new instance of the <see cref="RequestData"/> class.
    /// </summary>
    public RequestData() { }

    /// <summary>
    /// Initializes a new instance of the <see cref="RequestData"/> class.
    /// </summary>
    /// <param name="action">The action.</param>
    /// <param name="content">The content.</param>
    public RequestData(String action, Object content)
    {
        Content = content;
        if (content != null)
            ContentType = content.getClass();
        Action = action;
    }

    /// <summary>
    /// 获取请求数据
    /// </summary>
    /// <param name="action">动作.</param>
    /// <param name="content">内容.</param>
    /// <returns>
    /// IRequestData
    /// </returns>
    public static RequestData GetData(String action, Object content)
    {
        RequestData rdata = new RequestData();
        rdata.Content = content;
        rdata.Action = action;
        rdata.ContentType = content.getClass();
        return rdata;
    }
}
