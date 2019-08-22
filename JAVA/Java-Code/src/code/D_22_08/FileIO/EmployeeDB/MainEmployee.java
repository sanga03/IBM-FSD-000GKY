package code.D_22_08.FileIO.EmployeeDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import code.D_20_08.EmployeSql.model.Employee;
import code.D_20_08.EmployeSql.services.EmployeeServiceImplementation;

public class MainEmployee {

	public static void main(String[] args) {
		try {
			BufferedReader in = new BufferedReader(new FileReader("employee.ser"));
			String line;
			while(((line=in.readLine())!=null)) {
				String[] empData = line.split(" ");
				for(String a:empData) {
					System.out.println(a);
				}
				System.out.println(empData.length);
				int id= Integer.parseInt((empData[0]));
				Employee emp = new Employee(id, empData[1], empData[2], Integer.parseInt((empData[3])));
				EmployeeServiceImplementation employeeServiceImplementation = new EmployeeServiceImplementation();
				employeeServiceImplementation.createEmployee(emp);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
