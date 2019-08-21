package code.Assesments.Employee;

import java.util.Comparator;

public class AgeComparator implements Comparator<Object> {

	@Override
	public int compare(Object o01, Object o02) {
		Employee o1 = (Employee)o01;
		Employee o2 = (Employee)o02;
		if (o1.getAge() == o2.getAge()) {
			if (o1.getDateOfJoining() == o2.getDateOfJoining())
				return 0;
			else if (o1.getDateOfJoining().before(o2.getDateOfJoining()))
					return 1;

			else
				return -1;
		} else if (o1.getAge() > o2.getAge())
			return 1;
		else
			return -1;

	}

}
