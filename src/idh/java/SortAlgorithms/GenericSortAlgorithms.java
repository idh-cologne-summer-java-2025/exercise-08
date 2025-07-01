package idh.java.SortAlgorithms;

/** Bitte implementieren sie mindestens eine der naiven 
 * und eine der effizienten Sortieralgorithmen (also Merge oder Quick) 
 * für generische Typen!
 * @param <T> 
 */
public class GenericSortAlgorithms <T extends Comparable<T>>{
	
	public void bubbleSort(T[] arr) {
		int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0) {
                    // Swap arr[j+1] and arr[j]
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp; }
            }
        }
    }

    public void selectionSort(T[] arr) {
        
    }

    public void insertionSort(T[] arr) {
        
    }
    
    public void mergeSort(T arr) {
        
    }

    public void quickSort(T arr) {
        
    }
}
