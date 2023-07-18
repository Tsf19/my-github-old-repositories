package Other.MyCodes.Logics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class LeafNodeOfFlatTable {

	public void fun(Integer pid, List<FlatTableVo> list, List<Integer> leafNodes) {

		List<Integer> childNodesList = new ArrayList<>();
		for(FlatTableVo nodes : list) {
			if(pid == nodes.getParentId() && !nodes.getIsLowest())
				childNodesList.add(nodes.getId());
			else if(pid == nodes.getParentId() && nodes.getIsLowest() && !leafNodes.contains(nodes.getId()))
				leafNodes.add(nodes.getId());
		}

		if(childNodesList.isEmpty())
			return;
		
		for(Integer cid : childNodesList) {
			fun(cid, list, leafNodes);
		}

	}

	public static void main(String[] args) {

		//FlatTable(Integer id, Integer parentId, Boolean isLowest)
		List<FlatTableVo> list = Arrays.asList(
				new FlatTableVo(25, null, false),
				new FlatTableVo(26, 25, false),
				new FlatTableVo(27, 25, false),
				new FlatTableVo(28, 25, false),
				new FlatTableVo(29, 26, false),
				new FlatTableVo(30, 29, false),
				new FlatTableVo(31, 30, true),
				new FlatTableVo(32, 30, true),
				new FlatTableVo(33, 29, false),
				new FlatTableVo(34, 33, true),
				new FlatTableVo(35, 33, true),
				new FlatTableVo(36, 33, true),
				new FlatTableVo(37, 28, true),
				new FlatTableVo(38, 28, true));
		//leaf nodes : 31, 32, 34, 35, 36, 37, 38

		LeafNodeOfFlatTable object = new LeafNodeOfFlatTable();
		List<Integer> leafNodes = new ArrayList<>();

		Integer pid = null;
		for(FlatTableVo nodes : list) {
			if(nodes.getParentId() == null) {
				pid =nodes.getId();
				break;
			}
		}
		if(pid != null)
			object.fun(pid, list, leafNodes);
		
		System.out.println(leafNodes);

	}

}
