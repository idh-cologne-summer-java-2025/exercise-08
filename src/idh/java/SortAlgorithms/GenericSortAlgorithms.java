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
        if (arr == null || arr.length <= 1) return;

        mergeSortRecursive(arr, 0, arr.length - 1);
    }

    private void mergeSortRecursive(T[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortRecursive(arr, left, mid);
            mergeSortRecursive(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(T[] arr, int left, int mid, int right) {
        T[] temp = Arrays.copyOfRange(arr, left, right + 1);

        int i = 0;              
        int j = mid - left + 1; 
        int k = left;           

        while (i <= mid - left && j <= right - left) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        while (i <= mid - left) {
            arr[k++] = temp[i++];
        }

        while (j <= right - left) {
            arr[k++] = temp[j++];
        }
    }


    public void quickSort(T arr) {
        
    }
}
