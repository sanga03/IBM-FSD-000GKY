package code.D_20_08.EmployeSql.model;

import java.io.Serializable;

public class Employee implements Serializable{

private static final long serialVersionUID = 1L;
private int id;
private String firstName;
private String lastName;
private int salary;

public Employee(int id, String firstName, String lastName, int salary) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.salary = salary;
}
public Employee() {
	super();
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
