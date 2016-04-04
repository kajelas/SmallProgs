package algorithm.sort.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortAlgorithm {
	
	public static void main(String[] args) {
		String[] input = {"3","4","2","1","7","5","6"};
		List<String> inputList = Arrays.asList(input);
		System.out.println(MergeSortAlgorithm.sort(inputList));
	}
	
	public static List<String> sort(List<String> list) {
		List<List<String>> resultList = new ArrayList<List<String>>();
		for (String item : list) {
			resultList.add(Arrays.asList(new String[]{item}));
		}
		return mergeSort(resultList);
	}
	
	private static List<String> mergeSort(List<List<String>> list) {
		List<List<String>> resultList = new ArrayList<List<String>>();
		for (int i = 0; i < list.size();i = i + 2) {
			if (i != list.size() - 1)
				resultList.add(merge(list.get(i), list.get(i+1)));
			else
				resultList.add(list.get(i));
		}
		
		if (resultList.size() > 1)
			return mergeSort(resultList);
		else
			return resultList.get(0);
	}
	
	private static List<String> merge(List<String> list1, List<String> list2) {
		int i=0,j=0;
		List<String> resultList = new ArrayList<String>();
		while (resultList.size() < list1.size()+list2.size()) {
			if (i >= list1.size() && j < list2.size()) {
				resultList.add(list2.get(j));
				j++;
			} else if (i < list1.size() && j >= list2.size()) {
				resultList.add(list1.get(i));
				i++;
			} else if (i < list1.size() && j < list2.size()) {
				if (list1.get(i).compareTo(list2.get(j)) < 0) {
					resultList.add(list1.get(i));
					i++;
				} else {
					resultList.add(list2.get(j));
					j++;
				}
			}
		}
		
		return resultList;
	}
}
