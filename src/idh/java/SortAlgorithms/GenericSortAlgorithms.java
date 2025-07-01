package idh.java.SortAlgorithms;

/**
 * Generische Implementierungen gängiger Sortieralgorithmen.
 * <p>
 * In dieser Klasse finden sich sowohl ein "naiver" Algorithmus
 * (Insertion‑Sort) als auch zwei der effizienteren Varianten
 * (Merge‑Sort und Quick‑Sort). Alle Methoden arbeiten auf Feldern
 * beliebiger Objekttypen, solange diese das Interface
 * {@link java.lang.Comparable} implementieren.
 * </p>
 *
 * @param <T> Typ, der sortiert werden soll. Muss {@code Comparable} sein.
 */
public class GenericSortAlgorithms<T extends Comparable<? super T>> {

    /* ----------------------------------------------------------- */
    /* Naiver Algorithmus                                          */
    /* ----------------------------------------------------------- */

    /**
     * Insertion‑Sort: Gut geeignet für kleine oder bereits fast
     * vorsortierte Felder. Stabil und in‑place, aber im Worst‑Case
     * O(n²).
     *
     * @param arr das zu sortierende Feld
     */
    public void insertionSort(T[] arr) {
        if (arr == null) return;

        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];              // aktuelles Element (Hole‑In‑Hand)
            int j = i - 1;

            /* Solange linkes Nachbarelement größer ist, nach rechts schieben */
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;            // Lücke schließen
        }
    }

    /* ----------------------------------------------------------- */
    /* Weitere einfache Algorithmen (optional)                     */
    /* ----------------------------------------------------------- */

    /** Bubble‑Sort: Einfach, aber langsam (O(n²)). */
    public void bubbleSort(T[] arr) {
        if (arr == null) return;
        boolean swapped;
        int n = arr.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    swap(arr, i - 1, i);
                    swapped = true;
                }
            }
            n--; // größtes Element liegt nun am Ende; dort nicht mehr prüfen
        } while (swapped);
    }

    /** Selection‑Sort: Wählt jeweils das kleinste Element und setzt es nach vorn. */
    public void selectionSort(T[] arr) {
        if (arr == null) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) swap(arr, i, min);
        }
    }

    /* ----------------------------------------------------------- */
    /* Effizienter Algorithmus #1 – Merge‑Sort                      */
    /* ----------------------------------------------------------- */

    /**
     * Merge‑Sort: Teilt das Feld rekursiv in zwei Hälften und führt diese
     * anschließend sortiert zusammen. Garantierte Laufzeit O(n log n),
     * benötigt jedoch zusätzlichen Speicher proportional zur Feldgröße.
     *
     * @param arr das zu sortierende Feld
     */
    public void mergeSort(T[] arr) {
        if (arr == null || arr.length < 2) return;
        @SuppressWarnings("unchecked")
        T[] aux = (T[]) new Comparable[arr.length]; // Hilfsarray
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    /* --- rekursive Hilfsmethode --- */
    private void mergeSort(T[] arr, T[] aux, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(arr, aux, lo, mid);
        mergeSort(arr, aux, mid + 1, hi);
        merge(arr, aux, lo, mid, hi);
    }

    /* --- verschmelzt zwei bereits sortierte Teilbereiche --- */
    private void merge(T[] arr, T[] aux, int lo, int mid, int hi) {
        // 1) kompletten Bereich in Hilfsarray kopieren
        System.arraycopy(arr, lo, aux, lo, hi - lo + 1);

        int i = lo;      // Zeiger im linken Teil
        int j = mid + 1; // Zeiger im rechten Teil
        int k = lo;      // aktuelle Schreibposition im Originalarray

        // 2) Solange beide Teilbereiche Elemente enthalten
        while (i <= mid && j <= hi) {
            if (aux[i].compareTo(aux[j]) <= 0) {
                arr[k++] = aux[i++];
            } else {
                arr[k++] = aux[j++];
            }
        }
        // 3) Rest des linken Teilbereichs kopieren (rechter Rest ist schon an Ort und Stelle)
        while (i <= mid) {
            arr[k++] = aux[i++];
        }
    }

    /* ----------------------------------------------------------- */
    /* Effizienter Algorithmus #2 – Quick‑Sort                      */
    /* ----------------------------------------------------------- */

    /**
     * Quick‑Sort mit Lomuto‑Partitionierung. Durchschnittlich O(n log n),
     * im schlechtesten Fall O(n²). In‑place, daher speichereffizient.
     */
    public void quickSort(T[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    /* --- rekursiver Teil --- */
    private void quickSort(T[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    /* --- Partitionierung nach Lomuto --- */
    private int partition(T[] arr, int lo, int hi) {
        T pivot = arr[hi]; // letztes Element als Pivot
        int i = lo;        // Grenze < Pivot
        for (int j = lo; j < hi; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i;
    }

    /* ----------------------------------------------------------- */
    /* Hilfsmethode                                                */
    /* ----------------------------------------------------------- */

    private void swap(T[] arr, int i, int j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
