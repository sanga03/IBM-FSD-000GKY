package code.Assesments.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		List<Employee> employeeList = new ArrayList<Employee>();
		String name;
		String department;
		String date;
		Date dateOfJoining = new Date();
		int age;
		int salary;
		int numberEmployee;
		Employee empl = new Employee();
//		Collections.sort(employeeList,new AgeComparator());
		System.out.println("Enter No of Employees:");
		numberEmployee = sc.nextInt();
		for (int i = 0; i < numberEmployee; i++) {
			System.out.println("Enter Details of Employee " + (i + 1));
			name = sc.next();
			department = sc.next();
			date = sc.next();
			try {
				dateOfJoining = new SimpleDateFormat("dd/MM/yyyy").parse(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			age = sc.nextInt();
			salary = sc.nextInt();
			empl = new Employee(empl, name, department, dateOfJoining, age, salary);
			employeeList.add(empl);
		}

		System.out.println("1.Sort employees by salary\r\n" + "2.Sort employees by age and by date of joining\r\n"
				+ "Enter your choice\r\n");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			EmployeeBO.PrintEmployee(employeeList);
			break;
		case 2:
//			List<Employee> l = new ArrayList<Employee>();
//			l.addAll(employeeList);
			Collections.sort(employeeList,new AgeComparator());
//			employeeList.clear();
//			employeeList.addAll(l);
			EmployeeBO.PrintEmployee(employeeList);
			break;
		default:
			break;
		}
	}

}
