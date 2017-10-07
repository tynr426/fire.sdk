package fire.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import fire.modules.entity.FormatType;
import fire.proxy.service.ProxyBase;
@Controller
public class TestCase {
	@RequestMapping("/logintest.do")
	public void testHttp(){
		Map<String, String> map = new HashMap<String, String>();   
		map.put("Code", "tyn");
		 map.put("UserName", "zhangsan");    
		 map.put("Password", "111111");  
		
		String str=new ProxyBase(1).GetString("", "", map, FormatType.Json, "2.0", "POST");
		
		
	}
}
