package code.D_19_08.List;
import java.util.Enumeration;
import java.util.Vector;
public class Vectors {
	private Vector<String> v ;
	public void putVector() {
	v=new Vector<String>();
	v.add("as");
	v.add("asdda");
	}
	
	
	public Enumeration<String> getVector(){
	Enumeration<String> em= v.elements();
	return em;
	}

	
	
}
