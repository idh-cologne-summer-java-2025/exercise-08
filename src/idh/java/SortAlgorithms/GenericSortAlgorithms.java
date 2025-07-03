package idh.java.SortAlgorithms;

/** Bitte implementieren sie mindestens eine der naiven 
 * und eine der effizienten Sortieralgorithmen (also Merge oder Quick) 
 * für generische Typen!
 * @param <T> 
 */
public class GenericSortAlgorithms <T extends Comparable<T>>{
	
	public void bubbleSort(T[] arr) {
		int count = arr.length -1;
		while (count >= 0) {
			for (int i = 0; i < count; i++) {
				if(arr[i].compareTo(arr[i+1]) > 0) {
					T zwischen = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = zwischen;
				}
			}
			count--;
		}
    }

    public void selectionSort(T[] arr) {
        
    }

    public void insertionSort(T[] arr) {
        
    }
    
    public T[] mergeSort(T[] arr) {
    	if (arr.length > 1) {
		    int mitte = (int)(arr.length / 2);
		    T[] l = (T[]) Array.newInstance(defaultValue.getClass(), size);;// = new T[mitte]; //ab hier funktionert der weitere Code nicht, keine Ahnung, wie man hier einen neuen Generic erstellen kann, welcher jeweils die Hälfte des ursprünglichen darstellt
		    for(int i = 0; i <= mitte-1; i++) {
		      l[i] = arr[i];
		    }
		    T[] r;
		    for(int i = mitte; i <= arr.length-1; i++) {
		    	r[i - mitte] = arr[i];
		    }
		    l = mergeSort(l);
		    r = mergeSort(r);
		    return verschmelze(l, r);
    	  	}
    	else return arr;  
    }


	private T[] verschmelze(T[] l, T[] r) {
		T[] neul;
		int indexl = 0;
		int indexr = 0;
		int indexergebnis = 0;
		while (indexl < l.length && indexr < r.length) {
			if (l[indexl].compareTo(r[indexr]) < 0) {
				neul[indexergebnis] = l[indexl];
				indexl += 1;
			} 
			else {
				neul[indexergebnis] = r[indexr];
				indexr += 1;
			}
			indexergebnis += 1;
		}
		while (indexl < l.length) {
			neul[indexergebnis] = l[indexl];
			indexl += 1;
			indexergebnis += 1;
		}
		while (indexr < r.length) {
			neul[indexergebnis] = r[indexr];
			indexr += 1;
			indexergebnis += 1;
		}
		return neul;
		}

    public void quickSort(T arr) {
        
    }
}
