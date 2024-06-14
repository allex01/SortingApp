package com.example.SortingApp;
import java.util.List;

public class BubbleSort {

	public static List<Integer> bubbleSort(List<Integer> array) {
		for(int i=0;i<array.size()-1;i++) {
			boolean swapped=false;
			for(int j=0;j<array.size()-i-1;j++) {
				if(array.get(j)>array.get(j+1)) {
					int temp = array.get(j);
					array.set(j, array.get(j+1));
					array.set(j+1,temp);
					swapped=true;
				}
			}
			if(!swapped) {
				break;
			}
		}
			
		return array;
	}

}
