package algorithm.sort.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortAlgorithm2 {
    public static void mergeSort(List<String> list, int start, int end) {
    	int mid = (start + end) / 2;
    	if (start < end) {
    		mergeSort(list, start, mid);
    		mergeSort(list,mid+1,end);
    		merge(list, start, mid, end);
    	}
    }
  
    public static void merge(List<String> list,int start, int mid, int end) {
    	List<String> tempList = new ArrayList<String>();
    	int i = start;
    	int j = mid + 1;
    	while (i <= mid && j <= end) {
    		if (list.get(i).compareTo(list.get(j)) < 0) {
    			tempList.add(list.get(i++));
    		} else {
    			tempList.add(list.get(j++));
    		}
    	}
    	
    	while (i <= mid) {
    		tempList.add(list.get(i++));
    	}
    	
    	while (j <= end) {
    		tempList.add(list.get(j++));
    	}
    	
    	for (int k = start; k <= end; k++) {
    		list.set(k, tempList.get(k - start));
    	}
    }
      
    // 归并排序的实现  
    public static void main(String[] args) {   
		String[] input = {"3","4","2","1","7","5","6"};
		List<String> inputList = Arrays.asList(input);
		MergeSortAlgorithm2.mergeSort(inputList,0,inputList.size()-1);
		System.out.println(inputList.toString());
    }  
} 
