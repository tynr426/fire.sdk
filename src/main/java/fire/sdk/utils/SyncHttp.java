package fire.sdk.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;


public class SyncHttp {
	
	
    /** 
     * 发送GET请求 
     *  
     * @param url 
     *            目的地址 
     * @param parameters 
     *            请求参数，Map类型。 
     * @return 远程响应结果 
     */  
    public static String sendGet(String url, Map<String, String> parameters) { 
        String result="";
        BufferedReader in = null;// 读取响应输入流  
        StringBuffer sb = new StringBuffer();// 存储参数  
        String params = "";// 编码之后的参数
        try {
            // 编码请求参数  
            if(parameters.size()==1){
                for(String name:parameters.keySet()){
                    sb.append(name).append("=").append(
                            java.net.URLEncoder.encode(parameters.get(name),  
                            "UTF-8"));
                }
                params=sb.toString();
            }else{
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8")).append("&");  
                }  
                String temp_params = sb.toString();  
                params = temp_params.substring(0, temp_params.length() - 1);  
            }
            String full_url = url + "?" + params; 
            System.out.println(full_url); 
            // 创建URL对象  
            java.net.URL connURL = new java.net.URL(full_url);  
            // 打开URL连接  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // 设置通用属性  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // 建立实际的连接  
            httpConn.connect();  
            // 响应头部获取  
            Map<String, List<String>> headers = httpConn.getHeaderFields();  
            // 遍历所有的响应头字段  
            for (String key : headers.keySet()) {  
                System.out.println(key + "\t：\t" + headers.get(key));  
            }  
            // 定义BufferedReader输入流来读取URL的响应,并设置编码方式  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), "UTF-8"));  
            String line;  
            // 读取返回的内容  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }
        return result ;
    }  
  
    /** 
     * 发送POST请求 
     *  
     * @param url 
     *            目的地址 
     * @param parameters 
     *            请求参数，Map类型。 
     * @return 远程响应结果 
     */  
    public static String sendPost(String url, Map<String, String> parameters) {  
        String result = "";// 返回的结果  
        BufferedReader in = null;// 读取响应输入流  
        PrintWriter out = null;  
        StringBuffer sb = new StringBuffer();// 处理请求参数  
        String params = "";// 编码之后的参数  
        try {  
            // 编码请求参数  
            if (parameters.size() == 1) {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8"));  
                }  
                params = sb.toString();  
            } else {  
                for (String name : parameters.keySet()) {  
                    sb.append(name).append("=").append(  
                            java.net.URLEncoder.encode(parameters.get(name),  
                                    "UTF-8")).append("&");  
                }  
                String temp_params = sb.toString();  
                params = temp_params.substring(0, temp_params.length() - 1);  
            }  
            // 创建URL对象  
            java.net.URL connURL = new java.net.URL(url);  
            // 打开URL连接  
            java.net.HttpURLConnection httpConn = (java.net.HttpURLConnection) connURL  
                    .openConnection();  
            // 设置通用属性  
            httpConn.setRequestProperty("Accept", "*/*");  
            httpConn.setRequestProperty("Connection", "Keep-Alive");  
            httpConn.setRequestProperty("User-Agent",  
                    "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");  
            // 设置POST方式  
            httpConn.setDoInput(true);  
            httpConn.setDoOutput(true);  
            // 获取HttpURLConnection对象对应的输出流  
            out = new PrintWriter(httpConn.getOutputStream());  
            // 发送请求参数  
            out.write(params);  
            // flush输出流的缓冲  
            out.flush();  
            // 定义BufferedReader输入流来读取URL的响应，设置编码方式  
            in = new BufferedReader(new InputStreamReader(httpConn  
                    .getInputStream(), "UTF-8"));  
            String line;  
            // 读取返回的内容  
            while ((line = in.readLine()) != null) {  
                result += line;  
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } finally {  
            try {  
                if (out != null) {  
                    out.close();  
                }  
                if (in != null) {  
                    in.close();  
                }  
            } catch (IOException ex) {  
                ex.printStackTrace();  
            }  
        }  
        return result;  
    }  
	  /** 
	   * 日志  
	   */  
	  private static Logger log = Logger.getLogger("http");  
	  
	     
	  /** 
	   * 采取post方式提交序列化后的object对象 </br> 
	   * 另请参考：java.io.ObjectInputStream/ObjectOutputStream 
	   * @param requestUrl 请求地址 
	   * @param connTimeoutMills 设置连接主机超时，单位：毫秒 
	   * @param readTimeoutMills 设置从主机读取数据超时，单位：毫秒 
	   * @param serializedObject 序列化后的object对象 
	   *  
	   * @return remoteHttp返回的结果 
	   */  
	  public static String httpPostSerialObject(String requestUrl, int connTimeoutMills,  
	                        int readTimeoutMills, Object serializedObject) throws Exception    
	  {  
	    HttpURLConnection httpUrlConn = null;  
	    InputStream inputStream = null;  
	    InputStreamReader inputStreamReader = null;  
	    BufferedReader bufferedReader = null;  
	    ObjectOutputStream oos = null;  
	    StringBuffer buffer = new StringBuffer();  
	    try  
	    {  
	      URL url = new URL(requestUrl);  
	      httpUrlConn = (HttpURLConnection)url.openConnection();  
	      // 设置content_type=SERIALIZED_OBJECT  
	      // 如果不设此项,在传送序列化对象时,当WEB服务默认的不是这种类型时可能抛java.io.EOFException  
	      httpUrlConn.setRequestProperty("Content-Type","application/x-java-serialized-object");  
	      httpUrlConn.setConnectTimeout(connTimeoutMills);  
	      httpUrlConn.setReadTimeout(readTimeoutMills);  
	      // 设置是否向httpUrlConn输出，因为是post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false  
	      httpUrlConn.setDoOutput(true);  
	      // 设置是否从httpUrlConn读入，默认情况下是true  
	      httpUrlConn.setDoInput(true);  
	      // 不使用缓存     
	      httpUrlConn.setUseCaches(false);  
	  
	      // 设置请求方式，默认是GET  
	      httpUrlConn.setRequestMethod("POST");  
	      httpUrlConn.connect();  
	  
	      if (serializedObject != null)  
	      {  
	        // 此处getOutputStream会隐含的进行connect，即：如同调用上面的connect()方法，     
	        // 所以在开发中不调用上述的connect()也可以，不过建议最好显式调用  
	        // write object(impl Serializable) using ObjectOutputStream  
	        oos = new ObjectOutputStream(httpUrlConn.getOutputStream());  
	        oos.writeObject(serializedObject);  
	        oos.flush();  
	        // outputStream不是一个网络流，充其量是个字符串流，往里面写入的东西不会立即发送到网络，   
	        // 而是存在于内存缓冲区中，待outputStream流关闭时，根据输入的内容生成http正文。所以这里的close是必须的  
	        oos.close();  
	      }  
	      // 将返回的输入流转换成字符串  
	      // 无论是post还是get，http请求实际上直到HttpURLConnection的getInputStream()这个函数里面才正式发送出去  
	      inputStream = httpUrlConn.getInputStream();//注意，实际发送请求的代码段就在这里   
	      inputStreamReader = new InputStreamReader(inputStream, "UTF-8");  
	      bufferedReader = new BufferedReader(inputStreamReader);  
	  
	      String str = null;  
	      while ((str = bufferedReader.readLine()) != null)  
	      {  
	        buffer.append(str);  
	      }  
	    }  
	    catch (Exception e)  
	    {  
	      //log.error(requestUrl + " error ", e);  
	      throw e;  
	    }  
	    finally  
	    {  
	      try  
	      {  
	    	  bufferedReader.close();
	    	  inputStreamReader.close();
	    	  inputStream.close();
	    	  oos.close();
	        if (httpUrlConn != null)  
	        {  
	          httpUrlConn.disconnect();  
	        }  
	      }  
	      catch (Exception e)  
	      {  
	        //log.error(e);  
	      }  
	    }  
	    return buffer.toString();  
	  }  

}
