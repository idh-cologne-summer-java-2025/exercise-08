package idh.java.SortAlgorithms;

/** Bitte implementieren sie mindestens eine der naiven 
 * und eine der effizienten Sortieralgorithmen (also Merge oder Quick) 
 * für generische Typen!
 * @param <T> 
 */
public class GenericSortAlgorithms <T extends Comparable<T>>{
	
	public void bubbleSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public void selectionSort(T[] arr) {
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

    /*
    public void insertionSort(T[] arr) {

    }
    
    public void mergeSort(T arr) {
    	
    }
*/
    
    public void quickSort(T[] arr) {
    	quickSortWirth(arr, 0, arr.length - 1);
    }

    public void quickSortWirth(T[] arr, int l, int r) {
        int i = l;
        int j = r;
        T x = arr[(l + r) / 2];
        T w;
        do {
            while (arr[i].compareTo(x) < 0)
                i++;
            while (x.compareTo(arr[i]) < 0)
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
