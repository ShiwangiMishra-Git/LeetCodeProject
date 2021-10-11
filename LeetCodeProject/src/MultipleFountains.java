import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MultipleFountains {

	public MultipleFountains() {
		// TODO Auto-generated constructor stub

		// Smiler to pour water problem- here there are multiple fountains and water is
		// flowing from top to bottom we need to find out safe place to stand.

		// sort the fountains with height and check one by one what will be submerged by
		// them and mark them (including fountain and land both).

		// atlast we will get the safe places to stand

		// build the list

		// sort the list

	}

	public Integer[] safePlaceToStand(Integer[] heights, Integer[] fountains) {
		// heights : heights of places [3,2,3,4,6,4,1,2,3,1,1,4,5,4,2,3,2,1]
		// fountains: places of fountains [1,5,7,14,15]
		// Fountains with heights

		// {1,2,3,4,5}
		int[] safeArr;

		//Arrays.sort(heights, Collections.reverseOrder());

		List<Integer> heightslist = Arrays.asList(heights);
		List<Integer> fountainslist = Arrays.asList(fountains);

		// hashmap (sorted by value) of key value pair - key = index and value = height
		Map<Integer, Integer> fountainsMap = fountainslist.stream()
				.collect(Collectors.toMap(x -> x, x -> heightslist.get(x)));

		LinkedList<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(fountainsMap.entrySet());

		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		HashMap<Integer, Integer> sortedFountainsMap = new LinkedHashMap<Integer, Integer>();
		for (Iterator<Entry<Integer, Integer>> it = list.iterator(); it.hasNext();) {
			Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) it.next();
			sortedFountainsMap.put(entry.getKey(), entry.getValue());
		}

		Set<Integer> fullset = new HashSet<>(
				Stream.iterate(0, n -> n + 1).limit(heights.length - 1).collect(Collectors.toList()));
		Set<Integer> submergedset = new HashSet<Integer>();

		int submergedcount = 0;
		int remainingfountainsCount = fountains.length;

		boolean leftdone = false;
		boolean rightdone = false;

		for (Map.Entry<Integer, Integer> mapElement : sortedFountainsMap.entrySet()) {
			
			int left = mapElement.getKey() - 1;
			int right = mapElement.getKey() + 1;

			if (!leftdone && !rightdone) {
				
				while (!leftdone //all covered in the left
						&& left >= 0 && // same as left done ()may be redundant can use  just one
						submergedcount < heights.length //all got submerged
						&& remainingfountainsCount > 0 // fountains got over
						&& heights[left] <= mapElement.getValue()) {
					submergedset.add(mapElement.getKey());
					if(submergedset.add(left))
					{
					submergedcount++;
					}
					
					if(sortedFountainsMap.get(left)!=null)
					{
						remainingfountainsCount--;
					}
					
					if (left == 0) {
						//if i reached till left then left is covered
						leftdone = true;
					}
					left--;
				}

				while (!rightdone && right < heights.length && submergedcount < heights.length
						&& remainingfountainsCount > 0 && heights[right] <= mapElement.getValue()) {
					submergedset.add(mapElement.getKey());
					if(submergedset.add(right))
					{
					submergedcount++;
					}
					if(sortedFountainsMap.get(right)!=null)
					{
						remainingfountainsCount--;
					}
					if (right == heights.length - 1) {
						rightdone = true;
					}
					
					right++;
				}
			}

		}
		
		fullset.removeAll(submergedset);
		return fullset.toArray(new Integer[0]);
	}
	
	public static void main(String[] args)
	{
		
		Integer[] arr=new MultipleFountains().safePlaceToStand(new Integer[]{3,2,3,4,6,4,1,2,3,1,1,4,5,4,2,3,2,1},new Integer[]{1,5,7,14,15});
		
		for(Integer i:arr)
		{
			System.out.println(i);
		}
	}

}
