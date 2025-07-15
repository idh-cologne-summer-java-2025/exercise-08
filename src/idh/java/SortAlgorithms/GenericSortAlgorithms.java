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
    	 for (int i = 0; i < arr.length -1; i++) {
         	int minIdx = i;
             for (int j = i + 1; j < arr.length; j++) {
                 if (arr[j].compareTo(arr[minIdx]) < 0) {
                     minIdx = j;
                 }
             }
             T tmp = arr[i];
             arr[i] = arr[minIdx];
             arr[minIdx] = tmp;
         }
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
}
   