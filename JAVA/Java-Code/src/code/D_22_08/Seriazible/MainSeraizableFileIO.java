package code.D_22_08.Seriazible;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainSeraizableFileIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileOutputStream out = new FileOutputStream("employee.out");
			ObjectOutputStream oout = new ObjectOutputStream(out);
			oout.writeObject(new EmployeeSerialized(1, "sangamesh", "biradar", 2871317));
			oout.flush();
			
			FileInputStream in = new FileInputStream("Employee.out");
			ObjectInputStream iin = new ObjectInputStream(in);
			System.out.println((EmployeeSerialized)iin.readObject());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
