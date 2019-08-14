package code.D_14_08.Exception;

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

   Person p = new Person();
      	try {
		Person p1=p.createPerson("Na", "name");
		p1.display();
	} catch (Person_Exception e) {
		// TODO Auto-generated catch block
		System.err.println(e);
	}
	}

}
