package code.D_28_08.Model;

public class User {
private String name;
private String password;
public User(String name, String password) {
	super();
	this.name = name;
	this.password = password;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User() {
	super();
}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return this.password+this.name;
}

}
