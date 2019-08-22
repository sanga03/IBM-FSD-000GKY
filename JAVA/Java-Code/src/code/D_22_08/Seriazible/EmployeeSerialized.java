package code.D_22_08.Seriazible;

import java.io.Serializable;

public class EmployeeSerialized implements Serializable {
	
	private static final long serialVersionUID = -3411585783840813421L;
	private int id;
	private String firstName;
	private String lastName;
	private transient int  salary;

	
	@Override
	public String toString() {
		return "EmployeeSerialized [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary="
				+ salary + "]";
	}

	public EmployeeSerialized() {
		super();
	}

	public EmployeeSerialized(int id, String firstName, String lastName, int salary) {
	
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
}
