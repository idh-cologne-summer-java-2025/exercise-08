package idh.java.SortAlgorithms;

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
	            T key = arr[i];
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
	        int n1 = mid - left + 1;
	        int n2 = right - mid;

	        T[] leftArr = (T[]) new Comparable[n1];
	        T[] rightArr = (T[]) new Comparable[n2];

	        for (int i = 0; i < n1; i++) leftArr[i] = arr[left + i];
	        for (int j = 0; j < n2; j++) rightArr[j] = arr[mid + 1 + j];

	        int i = 0, j = 0, k = left;

	        while (i < n1 && j < n2) {
	            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
	                arr[k++] = leftArr[i++];
	            } else {
	                arr[k++] = rightArr[j++];
	            }
	        }

	        while (i < n1) arr[k++] = leftArr[i++];
	        while (j < n2) arr[k++] = rightArr[j++];
	    }
	
    public void quickSort(T arr) {
        
    }
}
