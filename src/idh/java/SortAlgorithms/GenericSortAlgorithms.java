package idh.java.SortAlgorithms;

public class GenericSortAlgorithms<T extends Comparable<T>> {

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

    public void quickSort(T[] arr) {
        quickSortWirth(arr, 0, arr.length - 1);
    }

    private void quickSortWirth(T[] arr, int l, int r) {
        int i = l;
        int j = r;
        T x = arr[(l + r) / 2];

        do {
            while (arr[i].compareTo(x) < 0) i++;
            while (arr[j].compareTo(x) > 0) j--;

            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        } while (i <= j);

        if (l < j) quickSortWirth(arr, l, j);
        if (i < r) quickSortWirth(arr, i, r);
    }

    public void selectionSort(T[] arr) {
        // Noch leer
    }

    public void mergeSort(T[] arr) {
        // Noch leer
    }
}

