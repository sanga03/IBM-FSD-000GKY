package code.D_19_08.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Main_List {
	public static void main(String[] args) {
		
		
		List<String> l =new ArrayList<String>();

		
		Vectors v= new Vectors();
		v.putVector();
		Enumeration<String> e = v.getVector();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
}
