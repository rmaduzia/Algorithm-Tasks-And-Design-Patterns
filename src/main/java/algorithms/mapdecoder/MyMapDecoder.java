package algorithms.mapdecoder;

import java.util.HashMap;
import java.util.Map;

public class MyMapDecoder implements MapDecoder {

	@Override
	public Map<String, String> decode(String s) {

		Map<String, String> resultMap = new HashMap<>();

		if (s == null) {
			return null;
		} else if (s.isBlank()) {
			return resultMap;
		}

		String[] arrayOfValues = s.split("&");

		for (String content : arrayOfValues) {
			String[] values = content.split("=");

			if (values.length == 2) {
				resultMap.put(values[0], values[1]);
			}else if (content.charAt(0) == '='){
				resultMap.put("", content.split("=")[0]);
			} else if (content.charAt(content.length()-1) == '=') {
				resultMap.put(content.substring(0, content.length()-1), "");
			}
			else {
				throw new IllegalArgumentException("Bad Arguments: " + s);
			}
		}

		return resultMap;
	}
}
