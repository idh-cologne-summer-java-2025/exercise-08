package idh.java.SortAlgorithms;

/** Bitte implementieren sie mindestens eine der naiven 
 * und eine der effizienten Sortieralgorithmen (also Merge oder Quick) 
 * für generische Typen!
 * @param <T> 
 */
public class GenericSortAlgorithms <T extends Comparable<T>>{
	
	public void bubbleSort(T[] arr) {
	        int n = arr.length;
	        boolean getauscht;

	        for (int i = 0; i < n - 1; i++) {
	            getauscht = false;
	            for (int j = 0; j < n - 1 - i; j++) {
	                if (arr[j].compareTo( arr[j + 1])>0) {
	                    // Tausche arr[j] und arr[j+1]
	                    T temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                    getauscht = true;
	                }
	            }
	            if (!getauscht) {
	                break;
	            }
	        }
	    }

        	
       
       
    

    public void selectionSort(T[] arr) {
        
    }

    public void insertionSort(T[] arr) {
        
    }
    
    public void mergeSort(T arr) {
        
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
        T pivot = arr[high];  // letztes Element als Pivot
        int i = low - 1;       // Index des kleineren Elements

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // tausche arr[i] und arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // tausche arr[i+1] und arr[high] (Pivot an richtige Stelle)
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

}
