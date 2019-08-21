package code.Assesments.Employee;

import java.util.Date;

public class Employee implements Comparable<Object> {
	private int id;
	private String name;
	private String department;
	private Date dateOfJoining;
	private int age;
	private int salary;
	private static int count;
	static {
		count = 1;
	}

	public Employee() {

	}

	public Employee(Employee emp, String name, String department, Date dateOfJoining, int age, int salary) {
		super();
		if (emp.getId() != 0)
			this.id = emp.getId() + 1;
		else
			this.id = 1;
		this.name = name;
		this.department = department;
		this.dateOfJoining = dateOfJoining;
		this.age = age;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Object o) {
		Employee emp = (Employee) o;
		if (this.getSalary() == emp.getSalary())
			return 0;
		else if (this.getSalary() > emp.getSalary())
			return 1;
		else
			return -1;
	}

	@Override
	public String toString() {
		String sfmt;
		sfmt=String.format("%-15s %-30s %-30s %-10s %-10s\n", id, name, department, dateOfJoining, age, salary);
		return sfmt;
	}

}
