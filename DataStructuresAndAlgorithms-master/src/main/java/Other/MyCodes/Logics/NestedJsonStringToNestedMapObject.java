//package Other.MyCodes.Logics;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//
//import com.google.gson.Gson;
//
//public class NestedJsonStringToNestedMapObject {
//
//	public static Map<String, Object> nestedJsonStringToNestedMapObject(String jsonString) {
//		Gson gson = new Gson();
//		
//		if(jsonString.startsWith("'") && jsonString.endsWith("'"))
//			jsonString = jsonString.substring(1, jsonString.length()-1);
//		
//		HashMap<String, Object> mapObject = gson.fromJson(jsonString, HashMap.class);
//		
//		for(Entry<String, Object> nestedObject : mapObject.entrySet()) {
//			String nestedObjectValue = nestedObject.getValue() != null ? nestedObject.getValue().toString() : "";
//			if(nestedObjectValue.startsWith("{") && nestedObjectValue.endsWith("}")) {
//				Map<String, Object> nestedJsonObject = nestedJsonStringToNestedMapObject(nestedObjectValue);
//				mapObject.put(nestedObject.getKey(), nestedJsonObject);
//			}
//		}
//		return mapObject;
//	}
//	
//	
//	public static void main(String[] args) {
//
//		String str = "{\"customLine.active\":true,\"customLine.startDate\":\"2018-09-26T22:44:09\",\"customLine.companyVariantHierarchyName\":\"Motorcycles Clutches And Accessories\",\"customLine.webDescription\":\"{\\\"customLine.id\\\":2}\",\"customLine.id\":2}";
//		
//		Map<String, Object> map = nestedJsonStringToNestedMapObject(str);
//		System.out.println();
//	}
//
//}
