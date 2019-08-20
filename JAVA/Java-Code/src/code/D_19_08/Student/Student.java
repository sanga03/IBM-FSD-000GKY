package code.D_19_08.Student;

import java.util.Comparator;

public class Student implements Comparator<Object> {

	private String name;
	private int id;

	public Student() {

	}

	public Student(String name, int id, Double gpa) {
		super();
		this.name = name;
		this.id = id;
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	private Double gpa;

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		if (s2.gpa == s1.gpa)
			return 0;
		else if (s2.gpa > s1.gpa)
			return -1;
		else
			return 1;
	}
	


	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + ", gpa=" + gpa + "]";
	}

}
