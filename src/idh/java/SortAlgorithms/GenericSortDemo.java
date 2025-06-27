package idh.java.SortAlgorithms;

import java.util.Arrays;

public class GenericSortDemo {

	public static void main(String[] args) {
		Student[] studis = new Student[10];
		studis[0] = new Student("Kain Adamson", 1234567);
		studis[1] = new Student("Abel Adamson", 1234568);
		studis[2] = new Student("Debora Elonstochter", 1234565);
		studis[3] = new Student("Jakob Isaakson", 1234584);
		studis[4] = new Student("Maria Joachimtochter", 1234570);
		studis[5] = new Student("Abel Adamson", 1234911);
		studis[6] = new Student("Rahel Adamson", 1234510);
		studis[7] = new Student("Ela Elonstochter", 1234512);
		studis[8] = new Student("Jakob Harnal", 1234522);
		studis[9] = new Student("Thomas Joachimtochter", 1234123);
		
		GenericSortAlgorithms<Student> gsa = new GenericSortAlgorithms<Student>();
		
		//Nicht vergessen, Array vor jedem Aufruf neu zu kopieren! Bsp mit insertionSort:
		Student[] toProcess = Arrays.copyOf(studis, studis.length);
		gsa.insertionSort(toProcess);
		System.out.println("Insertion Sort Ergebnis:");
		System.out.println(Arrays.toString(toProcess));
		
		toProcess = Arrays.copyOf(studis, studis.length);
		// nächster Algorithmus
		gsa.quickSort(toProcess);
		System.out.println("\nQuicksort Ergebnis: ");
		System.out.println(Arrays.toString(toProcess));
		
		toProcess = Arrays.copyOf(studis, studis.length);
		// nächster Algorithmus
		gsa.bubbleSort(toProcess);
		System.out.println("\nbubbleSort Ergebnis: ");
		System.out.println(Arrays.toString(toProcess));
		
		toProcess = Arrays.copyOf(studis, studis.length);
		// nächster Algorithmus
		gsa.selectionSort(toProcess);
		System.out.println("\nQuicksort Ergebnis: ");
		System.out.println(Arrays.toString(toProcess));
		
	}

}
