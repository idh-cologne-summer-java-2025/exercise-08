package idh.java.SortAlgorithms;

/** Bitte implementieren sie mindestens eine der naiven 
 * und eine der effizienten Sortieralgorithmen (also Merge oder Quick) 
 * für generische Typen!
 * @param <T> 
 */

public class GenericSortAlgorithms<T extends Comparable<T>> {
//--- S = Same as the session code, ? = a change from the session code (for the array e.g), ! = New additions. ------------------
	
    // S: Structure of the outer loops remains the same as original bubble sort.
    // ?: Comparison and swapping is updated to compareTo() and T.
    public void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {                  // S: Same loop
            for (int j = 0; j < arr.length - 1 - i; j++) {          // S: Same loop
                if (arr[j].compareTo(arr[j + 1]) > 0) {             // ?: Use compareTo() instead of > (> 0 is to check if the returned value of compareTo() is
                    T tmp = arr[j];                                 // ?: Use generic type T
                    arr[j] = arr[j + 1];                            // S: Same swap logic
                    arr[j + 1] = tmp;                               
                }
            }
        }
    }

    // S: Control structure is the same as in the normal selection sort.
    // ?: Comparison and swapping updated again.
    public void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {                  // S: Same outer loop
            int minIdx = i;                                         // S: Same initialization
            for (int j = i + 1; j < arr.length; j++) {              // S: Same inner loop
                if (arr[j].compareTo(arr[minIdx]) < 0) {            // ?: Use compareTo instead of < again
                    minIdx = j;
                }
            }
            T tmp = arr[i];                                         // ?: Use T instead of int
            arr[i] = arr[minIdx];                                   // S: Same swap logic
            arr[minIdx] = tmp;
        }
    }

    // S: Loop and shifting structure is dame to the normal insertion sort
    // ?: Comparisons and key storage adjusted for generic types
    public void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {                      // S: Same loop
            T key = arr[i];                                         // ?: Use T instead of an int
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {           // ?: compareTo() instead of >
                arr[j + 1] = arr[j];                                // S: Shifting remains the same
                j--;
            }
            arr[j + 1] = key;                                       // S: Insert key
        }
    }

    // S: Recursive structure same as integer-based merge sort.
    // ? + ! : Generic type added and new array creation adjusted (tricky).
    public void mergeSort(T[] arr) {
        if (arr == null || arr.length < 2) return;                  // S: Same base case
        mergeSort(arr, 0, arr.length - 1);                          // S: Same call structure
    }

    private void mergeSort(T[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;                             // S: Base case same
        int midIdx = startIdx + (endIdx - startIdx) / 2;            // S: Same midpoint calc
        mergeSort(arr, startIdx, midIdx);                           // S: Recurse left
        mergeSort(arr, midIdx + 1, endIdx);                         // S: Recurse right
        merge(arr, startIdx, midIdx, endIdx);                       // S: Merge step
    }

    private void merge(T[] arr, int startIdx, int midIdx, int endIdx) {
        int n1 = midIdx - startIdx + 1;                             // S: Same size calculation
        int n2 = endIdx - midIdx; 
        
        /* !: Java doesn't allow generic array creation directly. 
         * like, T[] leftArr = new T[n1] gives a compile error, bc T doesn´t really exist before sth is implemented.  
         * This is kind of a workaround I got from the Java Forum. 
         * It´s basically a simple Type cast. 
         * We make a new array Instance of the current Object type (e.g a Comparable type in this case specifically)
         * and turn that into an T array. Eclipse will mark this as unsafe bc the code can
         * only be verified to work at compilation (bc of the Generic). 
         * But it´s alright here, for the Student class . I couldn´t find a better workaround yet.
         *  */   
		T[] leftArr = (T[]) new Comparable[n1];                     // !: Create using Comparable
        T[] rightArr = ((T[]) new Comparable[n2]); 
        
        for (int i = 0; i < n1; i++) {                              // S: Copy loop same
            leftArr[i] = arr[startIdx + i];
        }
        for (int i = 0; i < n2; i++) {                              // S: Copy loop same
            rightArr[i] = arr[midIdx + 1 + i];
        }
        int i = 0, j = 0, k = startIdx;                             // S: Merge of the indexes same
        while (i < n1 && j < n2) {                                  // S: Same Merging logic
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {           // ?: compareTo() instead of <
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
        while (i < n1) {                                            // S: Copy remaining left
            arr[k++] = leftArr[i++];
        }
        while (j < n2) {                                            // S: Copy remaining right
            arr[k++] = rightArr[j++];
        }
    }
    
    // ?: Entry point: same as original but uses T[]
    public void quickSort(T[] arr) {
    	quickSortWirth(arr, 0, arr.length - 1);                   // S: Same logic
    }

    // !: Wirth-style QuickSort adapted to generics
    private void quickSortWirth(T[] arr, int l, int r) {
        int i = l;
        int j = r;                   
        T x = arr[(l + r) / 2];                                      // ?: Pivot value now of type T
        do {                                   
            while (arr[i].compareTo(x) < 0)                          // ?: Use compareTo for comparisons
                i++;
            while (x.compareTo(arr[j]) < 0)
                j--;
            if (i <= j) {
                T w = arr[i];                                        // ?: Swap by using generic temp
                arr[i] = arr[j];
                arr[j] = w;
                i++;
                j--;
            }
        } while (i <= j);
        if (l < j)                                                  // S: Recursive calls stay the same
            quickSortWirth(arr, l, j);
        if (i < r)
            quickSortWirth(arr, i, r);
    }
}
