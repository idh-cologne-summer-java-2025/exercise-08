package idh.java.SortAlgorithms;

/** Bitte implementieren sie mindestens eine der naiven 
 * und eine der effizienten Sortieralgorithmen (also Merge oder Quick) 
 * für generische Typen!
 * @param <T> 
 */
public class GenericSortAlgorithms <T extends Comparable<T>>{
	
	public void bubbleSort(T[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j].compareTo(arr[j + 1]) > 0) {
                    // Swap arr[j] and arr[j + 1]
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo( arr[min_idx]) < 0) {
                    min_idx = j;
                }
            }

            T temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
        }
    }

    public void insertionSort(T[] arr) {
        for(int i = 1; i < arr.length; i++) {
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
        if (arr.length < 2) return;
        
        int mid = arr.length / 2;
        
        // Create properly typed arrays using reflection
        @SuppressWarnings("unchecked")
        T[] left = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), mid);
        @SuppressWarnings("unchecked")
        T[] right = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), arr.length - mid);
        
        // Copy elements to left and right arrays
        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);
        
        // Recursively sort both halves
        mergeSort(left);
        mergeSort(right);
        
        // Merge the sorted halves
        merge(arr, left, right);
    }
    
    private void merge(T[] arr, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        
        // Merge elements from left and right arrays in sorted order
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        
        // Copy remaining elements from left array
        while (i < left.length) {
            arr[k++] = left[i++];
        }
        
        // Copy remaining elements from right array
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public T[] quickSort(T[] arr) {
        if (arr == null || arr.length < 2) return arr; // Array is already sorted or empty

        T pivot = arr[0]; // Choose the pivot
        int leftIndex = 0; // Start from the first element
        int rightIndex = arr.length - 1; // Start from the last element
        
        // Use Array.newInstance to create properly typed arrays
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), arr.length);
        
        for(int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(pivot) < 0) {
                temp[leftIndex++] = arr[i]; // Elements less than pivot go to the left
            } else if(arr[i].compareTo(pivot) > 0) {
                temp[rightIndex--] = arr[i]; // Elements greater than or equal to pivot go to the right
            } else {
                System.out.println("Elemente mit gleichem Wert werden nicht sortiert: " + arr[i]);
            }
        }

        int highlength = arr.length - leftIndex - 1;
        
        // Create properly typed arrays
        @SuppressWarnings("unchecked")
        T[] low = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), leftIndex);
        @SuppressWarnings("unchecked")
        T[] high = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), highlength);

        for(int i = 0; i < leftIndex; i++) {
            low[i] = temp[i]; // Fill the low array
        }
        for(int i = 0; i < highlength; i++) {
            high[i] = temp[leftIndex + 1 + i]; // Fill the high array
        }

        low = quickSort(low); // Recursively sort the low array
        high = quickSort(high); // Recursively sort the high array

        for(int i = 0; i < leftIndex; i++) {
            arr[i] = low[i]; // Copy sorted low array back to original array
        }
        arr[leftIndex] = pivot; // Place the pivot in the middle
        for(int i = 0; i < highlength; i++) {
            arr[leftIndex + 1 + i] = high[i]; // Copy sorted high array back to original array
        }

        return arr; // Return the sorted array
    }
}
