package Other.MyCodes.Logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class ConvertingObjectToList {

	public static void main(String[] args) {

		List<Integer> intList = Arrays.asList(1,2,3,4,5,6,7,8,9);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", intList);
		
		List<Integer> object = (List)map.get("id");
		System.out.println();
	}

}
