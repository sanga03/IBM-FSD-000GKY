package code.Assesments.Employee;

import java.util.List;
import java.util.Set;

public class EmployeeBO {
public static void PrintEmployee(List<Employee> emp) {
	System.out.printf("\n%-15s %-30s %-30s %-10s %-10s\n", "id", "name", "department", "dateOfJoining", "age", "salary");
	for(Employee e:emp) {
		System.out.println(e);
	}
}


}
