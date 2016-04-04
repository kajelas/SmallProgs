package algorithm.sort.quick;

import java.util.Arrays;
import java.util.List;

public class QuickSortAlgorithm {
	public static void sort(List<String> list) {
		sortRecursion(list, 0, list.size());
	}
	
	private static void sortRecursion(List<String> list, int start, int end) {
		int keyPos = start;
		int i = start,j = end - 1;
		
		while (i < j) {
			for (;j > keyPos; j--) {
				if (list.get(j).compareTo(list.get(keyPos)) < 0) {
					swapValue(list,j,keyPos);
					keyPos = j;
					break;
				}
			}
			
			for (;i < keyPos; i++) {
				if (list.get(i).compareTo(list.get(keyPos)) > 0) {
					swapValue(list,i,keyPos);
					keyPos = i;
					break;
				}
			}
		}
		
		if (keyPos > start)
			sortRecursion(list, start, keyPos);
		
		if (keyPos + 1 < end)
			sortRecursion(list, keyPos + 1, end);
	}
	
	private static void swapValue(List<String> list, int i, int j) {
		String temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public static void main(String[] args) {
		String[] input = {"3","8","4","2","1","7","5","6","9"};
		List<String> inputList = Arrays.asList(input);
		QuickSortAlgorithm.sort(inputList);
		System.out.println(inputList.toString());
	}
}
