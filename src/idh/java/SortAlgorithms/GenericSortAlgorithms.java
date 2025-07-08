package idh.java.SortAlgorithms;

import java.util.Arrays;

/** Bitte implementieren sie mindestens eine der naiven 
 * und eine der effizienten Sortieralgorithmen (also Merge oder Quick) 
 * für generische Typen!
 * @param <T> 
 */
public class GenericSortAlgorithms <T extends Comparable<T>>{
	
	public void bubbleSort(T[] arr) {

    }

    public void selectionSort(T[] arr) {
        
    }

    public void insertionSort(T[] arr) {
    	 for (int i = 1; i < arr.length; i++) {
			 T key  = arr[i];
	            int j = i - 1; 
	            while (j >= 0 && arr[j].compareTo(key) > 0) {
	                arr[j + 1] = arr[j];
	                j--;
	            }
	            arr[j + 1] = key;
		 }
    }
    
    public void mergeSort(T[] arr) {
    	 if (arr == null || arr.length < 2) return;
         mergeSortRecursive(arr, 0, arr.length - 1);
    }
    
    private void mergeSortRecursive(T[] arr, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSortRecursive(arr, left, mid);
        mergeSortRecursive(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }
    private void merge(T[] arr, int left, int mid, int right) {
        T[] temp = Arrays.copyOf(arr, arr.length);
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                temp[k++] = arr[i++];
            } else {
            	 temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int l = left; l <= right; l++) {
            arr[l] = temp[l];
        }
    }     

    public void quickSort(T arr) {
        
    }
}
