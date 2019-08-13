package com.singelton;

public class Messaging {
	private String message;
private static Messaging messaging;
	private Messaging(String message) {
		
		this.message = message;
	}
	
	private Messaging() {
		super();
	}
	
public static Messaging getMessObj() {
if(messaging==null) {	
	messaging = new Messaging();
	
}
return messaging;
}

public static Messaging getMessObj(String name) {
if(messaging==null) {	
	messaging = new Messaging(name);	
}
messaging.message=name;
return messaging;
}

@Override
public String toString() {
	return "Messaging [message=" + message + "]";
}


}
