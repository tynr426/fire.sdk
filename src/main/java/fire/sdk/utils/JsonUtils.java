package fire.sdk.utils;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	  public static<T> T JSONToObj(String jsonStr,Class<T> obj) {
		    T t = null;
		    try {
		      ObjectMapper objectMapper = new ObjectMapper();
		      t = objectMapper.readValue(jsonStr,
		          obj);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		    return t;
		  }
		  /**
		   * 将实体POJO转化为JSON
		   * @param obj
		   * @return
		   * @throws JSONException
		   * @throws IOException
		   */
	  public static<T> String objectToJson(T obj) {
		    ObjectMapper mapper = new ObjectMapper(); 
		    // Convert object to JSON string 
		    String jsonStr = "";
		    try {
		       jsonStr = mapper.writeValueAsString(obj);
		    } catch (IOException e) {
		     ;
		    }
		   return jsonStr;
		  }
}
