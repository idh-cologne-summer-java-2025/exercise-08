package idh.java.SortAlgorithms;

/**
 * Bitte implementieren sie mindestens eine der naiven und eine der effizienten
 * Sortieralgorithmen (also Merge oder Quick) für generische Typen!
 * 
 * @param <T>
 */
public class GenericSortAlgorithms<T extends Comparable<T>> {

	public void bubbleSort(T[] arr) {

	}
/*
 * Vergleiche < bzw. > und Kopieren oder Tauschen von Variablen müssen durch Methode compareTo vom Interface Comparable ersetzt werden (da student das Interface Comparable implementiert)
 */
	public void selectionSort(T[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < arr.length; j++) { 
				if (arr[j].compareTo(arr[minIdx]) < 0) {  //Interface Comparable benutzen, damit die Methode für generische Arrays (student) funktioniert.
					minIdx = j;
				}
			}
			T tmp = arr[i];
			arr[i] = arr[minIdx];
			arr[minIdx] = tmp;
		}
	}

	
	
	
	public void insertionSort(T[] arr) {

	}

	
	
	
	
	
	public void mergeSort(T[] arr) { 
        mergeSort(arr, 0, arr.length - 1);
    }
	
	public void mergeSort(T[] arr, int startIdx, int endIdx) {
		 if (startIdx >= endIdx) {
	            return;
	        }

	        int midIdx = startIdx + (endIdx - startIdx) / 2;
	        mergeSort(arr, startIdx, midIdx);
	        mergeSort(arr, midIdx + 1, endIdx);
	        merge(arr, startIdx, midIdx, endIdx);

	}
	
	 public void merge(T[] arr, int startIdx, int midIdx, int endIdx) {
	        int leftLen = midIdx - startIdx + 1;
	        int rightLen = endIdx - midIdx;
	        
	        T[] leftArr = (T[]) new Comparable[leftLen];
	        T[] rightArr = (T[]) new Comparable[rightLen];

	        for (int i = 0; i < leftLen; i++) {
	            leftArr[i] = arr[startIdx + i];
	        }
	        for (int i = 0; i < rightLen; i++) {
	            rightArr[i] = arr[midIdx + 1 + i];
	        }

	        int leftArrIdx = 0, rightArrIdx = 0, sortedArrIdx = startIdx;
	        while (leftArrIdx < leftLen && rightArrIdx < rightLen) {
	            if (leftArr[leftArrIdx].compareTo(rightArr[rightArrIdx]) <= 0) {
	                arr[sortedArrIdx++] = leftArr[leftArrIdx++];
	            } else {
	                arr[sortedArrIdx++] = rightArr[rightArrIdx++];
	            }
	        }
	        while (leftArrIdx < leftLen) {
	            arr[sortedArrIdx++] = leftArr[leftArrIdx++];
	        }
	        while (rightArrIdx < rightLen) {
	            arr[sortedArrIdx++] = rightArr[rightArrIdx++];
	        }
	    }
	    

	 
	 
	public void quickSort(T arr) {

	}
}
