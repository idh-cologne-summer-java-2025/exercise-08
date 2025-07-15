package idh.java.SortAlgorithms;

import java.util.Arrays;

/**
 * Implementierung von generischen Sortieralgorithmen für Typen,
 * die das Comparable-Interface implementieren.
 * @param <T> Der Typ der zu sortierenden Elemente.
 */
public class GenericSortAlgorithms<T extends Comparable<T>> {

    public void bubbleSort(T[] arr) {
        // Nicht implementiert, da InsertionSort als naiver Algorithmus gewählt wurde.
    }

    public void selectionSort(T[] arr) {
        // Nicht implementiert, da InsertionSort als naiver Algorithmus gewählt wurde.
    }

    /**
     * Implementierung des naiven Insertion-Sort-Algorithmus.
     * Er durchläuft das Array und fügt jedes Element an der korrekten Position
     * im bereits sortierten Teil des Arrays ein.
     */
    public void insertionSort(T[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i]; // Das aktuelle Element, das eingefügt werden soll
            int j = i - 1;

            // Verschiebe Elemente des sortierten Teils (arr[0...i-1]),
            // die größer als der 'key' sind, eine Position nach rechts.
            // Statt arr[j] > key wird arr[j].compareTo(key) > 0 verwendet.
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void mergeSort(T[] arr) {
        // Nicht implementiert, da QuickSort als effizienter Algorithmus gewählt wurde.
    }
    
    /**
     * Implementierung des effizienten Quick-Sort-Algorithmus.
     * Dies ist die Startmethode, die den rekursiven Aufruf anstößt.
     */
    public void quickSort(T[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSortRecursive(arr, 0, arr.length - 1);
    }
    
    /**
     * Die rekursive Kernmethode für QuickSort.
     * @param arr Das zu sortierende Array.
     * @param low Der Startindex des zu sortierenden Teil-Arrays.
     * @param high Der Endindex des zu sortierenden Teil-Arrays.
     */
    private void quickSortRecursive(T[] arr, int low, int high) {
        if (low < high) {
            // pi ist der Partitionierungsindex, arr[pi] ist jetzt an der richtigen Stelle.
            int pi = partition(arr, low, high);

            // Sortiere die Elemente getrennt vor und nach der Partition
            quickSortRecursive(arr, low, pi - 1);
            quickSortRecursive(arr, pi + 1, high);
        }
    }

    /**
     * Diese Methode wählt das letzte Element als Pivot, platziert dieses
     * an seiner korrekten Position im sortierten Array und platziert alle
     * kleineren Elemente links und alle größeren rechts vom Pivot.
     * @return Der Index der Partition (des Pivots).
     */
    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high]; // Das Pivot-Element
        int i = (low - 1); // Index des kleineren Elements

        for (int j = low; j < high; j++) {
            // Wenn das aktuelle Element kleiner oder gleich dem Pivot ist.
            // Statt arr[j] <= pivot wird arr[j].compareTo(pivot) <= 0 verwendet.
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                // Tausche arr[i] und arr[j]
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Tausche das Pivot-Element (arr[high]) mit dem Element an Position i+1
        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}