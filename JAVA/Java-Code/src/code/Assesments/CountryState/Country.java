package code.Assesments.CountryState;

import java.util.Collections;
import java.util.List;

public class Country {
private String name;
private List<State> sList;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<State> getsList() {
	return sList;
}
public void setsList(List<State> sList) {
	this.sList = sList;
}
public Country() {
	super();
}
public Country(String name) {
	super();
	this.name = name;
}
public void addState(String state) {
	sList.add(new State(state));
	
}

public List<State> getStateList(){
//	Collections.sort(sList,new State());
	return sList;
}


}
