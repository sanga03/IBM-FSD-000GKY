package code.D_14_08.Exception;

import java.util.Scanner;

public class Exception_Main {

	public static void main(String[] args) {
//	int sum =0;
//		for(String a:args) {
//		 try {
//			 sum += Integer.parseInt(a);
//		} catch (NumberFormatException nfe) {
//			// TODO: handle exception
//			System.err.println("Number Format exception");
//		}
//		 catch(ArrayIndexOutOfBoundsException ae) {
//			 System.err.println("Out of Bound");
//		 }
//		 catch(Exception e) {
//			 System.err.println("Global Exception");
//		 }
//		 finally {
//			 System.out.println("final block called");
//		 }
//		}
		final int Ln = 5;
		Scanner scanner = new Scanner(System.in);
		Person p[] = new Person[Ln];
		Person main = new Person();
		int count = 0;
		do {
			System.out.println("------------User " + (count + 1) + " ---------------------");
			p[count] = new Person();
			try {
				String fname;
				System.out.print("First Name:");
				fname = scanner.next();
				System.out.println();
				System.out.print("Last Name:");
				String lname = scanner.next();
				p[count] = main.createPerson(fname, lname);
				for (int t = 0; t < count; t++) {
//			p[t].display();
//			p[count].display();
					if (p[t].equalsPerson(p[count])) {
						System.out.println("Insert Success");
					}
				}
			} catch (Person_Exception e) {

				System.err.println(e);
				System.out.println("please try again");
				count--;
			} catch (PersonEqualsException on) {
				System.err.println(on);
				System.out.println("please try again");
				count--;
			}
			count++;
		} while (count < Ln);

//      	try {
//		Person p1=p.createPerson("Na", "name");
//		p1.display();
//	} catch (Person_Exception e) {
//		// TODO Auto-generated catch block
//		System.err.println(e);
//	}
	}

}
