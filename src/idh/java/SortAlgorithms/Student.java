package idh.java.SortAlgorithms;

public class Student implements Comparable<Student>{
	private String name;
	private int matrikelNummer;


	public String getName() {
		return name;
	}
	
	public int getMatrikelNummer() {
		return matrikelNummer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(String name, int mNum) {
		super();
		this.name = name;
		this.matrikelNummer = mNum;
	}

	@Override
	public String toString() {
		return matrikelNummer + ": " + name;
	}

	@Override
	public boolean equals(Object o) {
		if (! (o instanceof Student))
			return false;
		Student s = (Student) o;
		return this.matrikelNummer == s.matrikelNummer;
	}
	
	@Override
	public int hashCode() {
		return matrikelNummer;
	}

	@Override
	public int compareTo(Student o) {
		return this.matrikelNummer - o.matrikelNummer;
	}
	
}
