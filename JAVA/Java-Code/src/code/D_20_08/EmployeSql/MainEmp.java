package code.D_20_08.EmployeSql;

import java.util.List;
import java.util.Scanner;

import code.D_20_08.EmployeSql.model.Employee;
import code.D_20_08.EmployeSql.services.EmployeeServiceImplementation;

public class MainEmp {
	private static EmployeeServiceImplementation serve;
	private static Scanner sc;

	public static void main(String[] args) {
		serve = new EmployeeServiceImplementation();
		sc = new Scanner(System.in);
		int choice = 0, id, salary;
		String firstName, lastName;
		Employee emp = null;
		do {

			System.out.println(
					"\n1:Insert\n2:List Employee\n3:Update Employee\n4:Delete Employee\n5:get Details of Employee by Id\n0:exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.print("\nEMployee ID: ");
				id = sc.nextInt();
				System.out.print("Employee First Name: ");
				firstName = sc.next();
				System.out.print("Employee Last Name: ");
				lastName = sc.next();
				System.out.print("Employee Salary: ");
				salary = sc.nextInt();
				serve.createEmployee(new Employee(id, firstName, lastName, salary));
				break;

			case 2:
				List<Employee> list = serve.getEmployee();
				for (Employee e : list) {
					System.out.printf("\n%d\t%s\t%s\t%s", e.getId(), e.getFirstName(), e.getLastName(), e.getSalary());
				}
				break;

			case 3:
				System.out.println("enter Details for updation");
				System.out.print("EMployee ID: ");
				id = sc.nextInt();
				if(serve.updateEmployee(new Employee(id, "", "", 0))) {
				System.out.print("Employee First Name: ");
				firstName = sc.next();
				System.out.print("Employee Last Name: ");
				lastName = sc.next();
				System.out.print("Employee Salary: ");
				salary = sc.nextInt();
				emp = new Employee(id, firstName, lastName, salary);
				if (serve.updateEmployee(emp)) {
					System.out.println("Update Succcess");
				} else {
					System.out.println("please check id");
				}
				}else {
					System.out.println("please check id");
				}
				break;
			case 4:
				System.out.print("EMployee ID: ");
				id = sc.nextInt();
				if (serve.deleteEmployee(id)) {
					System.out.println("Delete Succcess");
				} else {
					System.out.println("please check id");
				}
				break;
			case 5:
				System.out.print("EMployee ID: ");
				id = sc.nextInt();
				emp = serve.getEmployeeById(id);
				if (emp.getId() != 0) {
					System.out.printf("\n%d\t%s\t%s\t%s", emp.getId(), emp.getFirstName(), emp.getLastName(),
							emp.getSalary());

				} else {
					System.out.println("please check id");
				}
				break;
			case 0:
				System.out.println("Exiting !!!");
				System.exit(0);
				break;

			default:
				System.out.println("Enter valid choice .. .");
				break;
			}

		} while (choice != 0);
	}

}
