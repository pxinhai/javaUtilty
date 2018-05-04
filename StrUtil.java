package baseportal.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StrUtil {

	public static final String EMPTY="";
	
	public static String filterInvalidChars(String value) {
		return value.replaceAll("[^a-zA-Z0-9\u4E00-\u9FA5]", "");
	}

	public static String removeAllHtmlFlag(String src){
		Pattern p_html = Pattern.compile("<[^>]+>", Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(src);
		return m_html.replaceAll(EMPTY);
	}

	public static String removeHtmlFlagA(String src){
		Pattern p_html = Pattern.compile("<a.*href[^>]*>", Pattern.CASE_INSENSITIVE);
		Matcher m_html = p_html.matcher(src);
		String rVal=m_html.replaceAll(EMPTY);

		p_html = Pattern.compile("</a>", Pattern.CASE_INSENSITIVE);
		m_html=p_html.matcher(rVal);
		rVal=m_html.replaceAll(EMPTY);

		return rVal;
	}


	public static boolean isBlank(String str) {
		int strLen;
		if (str == null || (strLen = str.length()) == 0) {
			return true;
		}
		for (int i = 0; i < strLen; i++) {
			if ((Character.isWhitespace(str.charAt(i)) == false)) {
				return false;
			}
		}
		return true;
	}

	public static Date parseDate(String src,String pattern){
		if(src==null || src.isEmpty()) return null;
	SimpleDateFormat format=new SimpleDateFormat(pattern);
		try {
			return format.parse(src);
		} catch (ParseException e) {
			Map<String,String> map =new TreeMap<>();
			map.put("src",src);
			LogUtil.warn("parseDate",e,map);
			return null;
		}
	}

	public static Integer parseInteger(String src){
		if(src==null || src.isEmpty()){
			return null;
		}
		try {
			return  Integer.parseInt(src.trim());
		}catch (NumberFormatException ex){
			LogUtil.info("parseInteger",ex.getMessage());
			return null;
		}
	}

	public static Double parseDouble(String src){
		if(src==null || src.isEmpty()){
			return null;
		}
		try {
			return  Double.parseDouble(src.trim());
		}catch (NumberFormatException ex){
			LogUtil.info("parseDouble",ex.getMessage());
			return null;
		}
	}

}
