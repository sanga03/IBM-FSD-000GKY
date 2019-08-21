package code.Assesments.PasswordValidation;

import java.util.Scanner;

public class Main {

	private static Scanner sc;
	public static void main(String[] args) {
		sc= new Scanner(System.in);
		while(true) {
			String p = sc.next();
		if(UserMainCode.checkPassword(p)) {
			System.out.println("Success");
		}else
			System.out.println("Please enter valid one");
		}
	}

}
