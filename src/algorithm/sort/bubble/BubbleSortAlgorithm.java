package algorithm.sort.bubble;

import java.util.Arrays;
import java.util.List;

public class BubbleSortAlgorithm {
	public static void sort(List<String> unsortedList) {
//Ë«listÊµÏÖ
//		List<String> resultList = new ArrayList<String>();
//		for (String item : unsortedList) {
//			if (resultList.isEmpty())
//				resultList.add(item);
//			else {
//				boolean isAdded = false;
//				for (int index = 0; index < resultList.size();index++) {
//					if (item.compareTo(resultList.get(index)) < 0) {
//						resultList.add(index, item);
//						isAdded = true;
//						break;
//					}
//				}
//				if (!isAdded)
//					resultList.add(item);
//			}
//		}
		
		String temp;
		for (int i = 0; i < unsortedList.size();i++) {
			for (int j = i + 1; j < unsortedList.size();j++) {
				if (unsortedList.get(j).compareTo(unsortedList.get(i)) < 0) {
					temp = unsortedList.get(i);
					unsortedList.set(i, unsortedList.get(j));
					unsortedList.set(j, temp);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] input = {"3","4","2","1","7","5","6","8","9","10","11","12"};
		List<String> inputList = Arrays.asList(input);
		BubbleSortAlgorithm.sort(inputList);
		System.out.println(inputList.toString());
	}
}
