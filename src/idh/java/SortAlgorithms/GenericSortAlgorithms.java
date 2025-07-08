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
    T anchor = arr[0]; 
    T temp;
    for(int i = 0; i<arr.length;i++) {
    	if(anchor.compareTo(arr[i])>0) {
    		temp = arr[i];
    		anchor = arr[i];
    		temp = anchor;
    		this.selectionSort(arr);
    		
    	}
    }
    }

    public void insertionSort(T[] arr) {
        
    }
    
    public void mergeSort(T arr) {
        
    }

    public void quickSort(T arr) {
        
    }
}
