package idh.java.SortAlgorithms;

public class GenericSortAlgorithms<T extends Comparable<T>> {

    public void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void mergeSort(T[] arr) {
        if (arr.length <= 1) return;
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private void mergeSortHelper(T[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(T[] arr, int left, int mid, int right) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        T[] leftArray = (T[]) new Comparable[size1];
        T[] rightArray = (T[]) new Comparable[size2];

        for (int i = 0; i < size1; ++i)
            leftArray[i] = arr[left + i];
        for (int j = 0; j < size2; ++j)
            rightArray[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < size1 && j < size2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                arr[k++] = leftArray[i++];
            } else {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < size1) {
            arr[k++] = leftArray[i++];
        }

        while (j < size2) {
            arr[k++] = rightArray[j++];
        }
    }

    // Nicht implementierte Algorithmen
    public void bubbleSort(T[] arr) {}
    public void selectionSort(T[] arr) {}
    public void quickSort(T[] arr) {}
}
