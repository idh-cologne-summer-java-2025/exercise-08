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
            while (j >= 0 && arr[j].compareTo(key)>0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public void mergeSort(T[] arr) {
        
    }

    public void quickSort(T[] arr) {
    	quickSortWirth(arr, 0, arr.length - 1);
    }

    public void quickSortWirth(T arr[], int l, int r) {
        int i, j;
        T x;
        T w;
        i = l;
        j = r;
        x = arr[(l + r) / 2];
        do {
            while (arr[i].compareTo(x)<0)
                i++;
            while (x.compareTo(arr[j])<0)
                j--;
            if (i <= j) {
                w = arr[i];
                arr[i] = arr[j];
                arr[j] = w;
                i++;
                j--;
            }
        } while (i <= j);
        if (l < j)
            quickSortWirth(arr, l, j);
        if (i < r)
            quickSortWirth(arr, i, r);
    }
    
  
}
