package com.ibm.EmployeeMavenHibernetCRUD;

import java.util.Scanner;

import com.ibm.EmployeeMavenHibernetCRUD.model.EmployeeModel;
import com.ibm.EmployeeMavenHibernetCRUD.services.EmployeeServices;


public class App {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		EmployeeServices employeeServices = new EmployeeServices();
		int ch;
		String c = "n";
		do {
			System.out.println("Enter Choice \n 1:Add Employee \n2:get Employee by id\n3: get all employees"
					+ "\n4:update Employee\n5:delete employee \n6:exit");
			ch = sc.nextInt();

			switch (ch) {

			case 1:
				System.out.println("Name:");
				String name = sc.next();
				System.out.println("Password:");
				String password = sc.next();
				System.out.println("Email:");
				String email = sc.next();
				System.out.println("Country:");
				String country = sc.next();
				EmployeeModel empd = new EmployeeModel(name, email, password, country);
				employeeServices.addEmployee(empd);
				break;
			case 2:
				int id = sc.nextInt();
				System.out.println(employeeServices.getEmployee(id));
				break;
			case 3:
				for (EmployeeModel e : employeeServices.getEmployees()) {
					System.out.println(e);
				}
				break;
			case 4:
				int id2= sc.nextInt();
				EmployeeModel ed = employeeServices.getEmployee(id2);
				System.out.println("\nwhat you want to update:\n1:name\n2:pass\n3:email\n4:country\n");
				int ch1=sc.nextInt();
				switch(ch1) {
				case 1:ed.setName(sc.next());
				break;
				case 2:ed.setPassword(sc.next());
				break;
				case 3:ed.setEmail(sc.next());
				break;
				case 4:ed.setCountry(sc.next());
				break;
				default:break;
				}
				employeeServices.updateEmployee(ed);
				break;
			case 5:
				int id1 = sc.nextInt();
				employeeServices.deleteEmployee(employeeServices.getEmployee(id1));
			default:
				break;
			}
			System.out.println("do you want to continue(y/n)");

			c = sc.next();
		} while (c.equals("y") || c.equals("Y"));
	}

}
