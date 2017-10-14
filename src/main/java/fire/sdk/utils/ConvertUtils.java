package fire.sdk.utils;

public class ConvertUtils {
	public static int toInt(String str){
		int re=0;
		try {
			re=Integer.valueOf(str).intValue();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return re;
	}
}
