# JAVA -- FSD 
[12-08-19](./JAVA_12-08/src/com)
## jvm 
instruction set
register set
class file format

## memory
	stack  (local variables)
	heap (instance variables)
	garbage collection
mermory area
fatal error reporting

### high precision timing support
		multi threading

# JRE
	compile
	test.java --> test.class(byte code)

	load hard disk , network and other source

	class loader(loads nessary classes)->bytecode varifier(verify for mermory leaks and assign) -> interpreter(to interpert line by line, generates os executable file) -> runtime(executiion) -> hardware


# JIT(just intime compiler)
	compile
	test.java --> test.class(byte code)

	load hard disk , network and other source

	class loader(loads nessary classes)->bytecode varifier(verify for mermory leaks and assign) -> 
		## interpreter(to interpert line by line, generates os executable file) -> runtime(executiion) -> hardware
		## JIT code generator

	-> Hardware


## java commands
	javap -c class name gives the bytecode
	jvisualvm
	jconsole -- visulaise the jvm
	javap java.lang.String (gives the methods of class)


# Garbage collection
	deallocate the memory
	checks and frees the memory which is not needed
	can very dreamatically across jvm implemantation

if one class is compiles where another class is called it is aitomatically called

# OOP

# Abstraction:-
	hiding the data (only methods and instruction to access)
	function: write an algorithm once to used in many sitautoins
	object : group related set of attributes and behaviors into class
	framework and APIs:
	class is blueprint for object:

# OOP KEY FEATURES

## Encapsualtion
	protacting data
## Inheritance
	multiple inheritance is not supported virual method invocation (interfaces )
## Polyomrphism
	same function name but different functonality  based on arguments

```
 <modifier>* class <class name>{
 	<attribute_declaration>*
 	<cunstructor_declaration>*
 	<method_declaration>*

 }
```

## [orphan object](./JAVA_12-08/src/com/example/MyDate.java)
` new MyDate().creteDate(8,10,2013)`

method hooking :- calling impicit cunstructor

[constructor chaining](./JAVA_12-08/src/com/example/MyDate.java)
` this(10)`

## [Inheritance](./JAVA_12-08/src/com/employee/)
concept of child class(sub class) inheriting from parent class
	```
		public class Person(){
			protected String name;
		}
		public class Man extends Person(){
			private String mustache;
	}
	```
Dynamic Method Despaching
	```
	Person p=null;
	p=new Student()
	p=new Employee() #can only be accesible which are common on parent and child class (overridden)
	p.getClass().getName() // gives the name of class package.ClassName
	```
	@Override
		same method name as parent but different functionality with the child    
	constructors cannot be overridden but can be called using super

## must implement
	constructor
	parametarised constructor
	setter and getters

## [java.lang.object](./JAVA_12-08/src/com/account/Account.java)
	super class of all classes
	methods:	
			toString:-
			   public String toString(){
			   	return "custum";
			   }
			equals:-
				public boolean equals(Object obj){
					Point p = (Point)obj;
					if(this.x==p.x && this.y==p.y)
					return true;
					else return false;
				}
				p1.equals(p2)

			hashCode:-
					returns the same hash if contents are same
					is called whenever equals method is called 

			wait
			notify
			notifyAll


## [static](./JAVA_12-08/src/com/product/Main_prod.java)
static block
```	
	static{

		//static var initialization
	}
```
## no -name block
```
	{
		// acts as constructor
		// initialization of insatance var
	}
```

## final
	blank final variable 
		` private static final double TAX;`
	final varialbes are denoted in CAPS_AND_UNDERSCORE
	final var val cannot be changed
	final methods cannot be override
	final class cannot be inhereted

## [Array](./JAVA_13_08/src/com/Array/Array_Builder.java)
	 autoboxing :int to integer 
	 private int arr[] // as good as Integer arr[] = new Integer[lenght]
	 autounboxing:Integer to int
	 int[m][n]
	 if n is same --- 2d array
	 if int[0][m]
	 	int[1][n] then irregur / jagged array
 ```
  Product[] p = new Product[5];
  //or Product p[]={}
  p[0]=new Book();
  p[0]=new TV();
  p[0]=new Mp3();
  for(Product pro:p){
  	Sys.out(p.getClass().getName())
  }
  ```


[13-08-19](./JAVA_13_08/src/com)
## [Abstract class](./JAVA_13_08/src/com/abstrat)
	Abstract methods:- 
			only has the declaration not the implementation

			public abstract void methodName();

	is class which contains one or more abstract methods
	if any (concrete class)class extends abstract class has to implement all abstract methods
 
## [Interface](./JAVA_13_08/src/com/interfac)
	by deafult all methods are abstract
	run time actual onject instance is associated with the interface type
	supports multiple inheritance
## [Singelton class](./JAVA_13_08/src/com/singelton/Main_singleton.java)
	only one object of class is accessable and used

## variable arguments
```	
	public int add(int... var){
		int sum=0;
		for(int i:var){
			sum+=i;
		}
		return sum;
	}
```
14-08-19

## [Exception](./Java-Code/src/code/D_14_08/Exception/Exception_Main.java)
	unexpected sitautation happens at runtime  
	Exception Handeling:- handling the unexpected sitatuation

![alt image](http://www.artima.com/javaseminars/modules/Exceptions/images/BWThrowableFamily.gif)

Serializale interface:
	marker interface doesnt have any abstract methods
	and tells garbage collection not to collect data 

## [Enum](./Java-Code/src/code/D_14_08/Enum/Main_Enum.java)
	An enum is a special "class" that represents a group of constants (unchangeable variables, like final variables).

## Collections
	can store only objects (elements)
	Collection:-spacific ordering
	Set:-unordered collection ; no duplicates
	List:- order collection ; duplicates allowed

		 	Hash table 	Resizable Array 	` Tree 	    LL 				HT+LL
	set 	HashSet			---		 		TreeSet						LinkedHashSet
	List 					ArrayList						LinkedList			
	Deque					ArrayDeque						LinkedList
	Map 	 HashMap 							TreeMap						LinkedHashMap

	these collections can store combination of any type of objects but by 
	Using Genereric
	Set<String> set = new HashSet()<String>
	we make sure it only stores perticular type of Objects


## [Set](./Java-Code/src/code/D_14_08/Set/SetCollection.java) 
	Set doesn't hold duplicate values

[19/08/19](./Java-Code/src/code/D_19_08)
## [List](./Java-Code/src/code/D_19_08/Card/MainCard.java)      [Read](https://www.geeksforgeeks.org/list-interface-java-examples/)

	List a = new ArrayList();
	List b = new LinkedList();
	List c = new Vector(); 
	List d = new Stack(); 

## [Vector](./Java-Code/src/code/D_19_08/List/Vectors.java)

## [Comparable](./Java-Code/src/code/D_19_08/Student/Student.java)
	interface which helps in ordering of collections 
	have to override compareTo()
	used on unordered collection(Set)

# JDBC
	its an api 
	defines a set of java interfaces which are implemented by vendor sacific jdbc driver
	majority - java.sql
	datbase already comes with the driver but we have to set up driver for our application 

## register jdbc to application
	goto java project -> properties --> add java build path --> mysql/ other connector
	then import those jdbc drivers 
	incase of mysql -- > com.sql.cj.jdbc...

	driverManager
	DatabseMetadata

## [jdbc examples](./Java-Code/src/code/D_19_08/jdbc/jdbc_demo.java)
	driver
	connection
	statements
	st.executeQuery() return result set
	prepared statement ( ? -> placeholders)
	pst.setInt(1,value); (1 -- column )
	pst.executeUpdate() returns count of rows updated
	resultSet

## [20/08/19](./Java-Code/src/code/D_20_08)
	CRUD operations 
	Crete,Read,Update and delete operations in mysql

example -- [employee services using mysql](./Java-Code/src/code/D_20_08/EmployeSql/MainEmp.java)

### Database Metadata
	has all the details about connection and driverManager
	DatabaseMetaData mdata = conn.getMetaData();
	mdata.getUrl()
	mdata.getUserName()
	mdata.getDriverName()
	mdata.getMajorVersion()

### ResultSetMetaData
	rMetaData.getCoulmnCount
	rMetaData.getColumnLabel(1)

## Thread
	Threads are Virtual CPU
	has three parts:
		CPU
		Code
		Data
Thread LifeCycle

![alt image](https://t1.daumcdn.net/cfile/tistory/2157A74C57F48D8B32)
	
	class can implement Runnable which has to override run method
#### [example](./Java-Code/src/code/D_20_08/Thread/MainThread.java)
###  Common Thread functions
	Thread sleep --  forcefull transition to block state
	Thread yeild -- ready to go to wait state
	Thread isAlive -- true if alive (runnin or waiting state)
	Thread join -- brings back the thread from waiting state to runnable state
	Thread Throws Interrupted Exception


## [Synchronization](./Java-Code/src/code/D_20_08/ThreadSync/MainThreadSync.java)
![alt image](https://html2-f.scribdassets.com/29sfe6c1s05h4ien/images/463-34429d581e.jpg)


## [Swing](./Java-Code/src/code/D_21_08/swing)
	Architicture
		Model - View - Controller
	package
		javax.swing
					.border
					.event
					.*
	throws HeadlessException -- (if not supported by os)
	flowLayout -- (puts the component one after another)
	Delegation Pattern
	event -- > event Listener --> event Handler

[22/08/19](./Java-Code/src/code/D_22_08/)
## I/O streams
	java.lang.io
	Stream 				ByteStream				Character Stream
	Source Stream 		InputStream					reader
	Sink streams        OutputStream				writer

	InputStream:
	int read()
	int read(bytes[] buff)
	int read(bytes[],int offset,int length)
	void close()
	int available()
	long skip(long n)
	boolean markSupported()
	void mark(int readlimit)
	void reset()

	OutputStream:
	void write(int c)
	void write(bytes[] buff,int c)
	void write()
	void flush()
	void close()

	Node Streams

	type 		character 				Byte

	File      	FileReader				FileInputStream
				FileWriter				FileOutputStream

	Memory  	CharArrayReader			ByteArrayInputStream
	Array  		CharArrayWriter			ByteArrayOutputStream

	Memory  	StringReader
	Str			StringWriter()					N/A

	Pipe 		PipedReader				PipedInputStream
				PipedWriter 			PipedOutputStream


#### [File input Output](./Java-Code/src/code/D_22_08/FileIO/MainFileIO.java)
#### [JFrame File input Output](./Java-Code/src/code/D_22_08/FileIO/FrameWR/MainWR.java)
#### [Buffer Reader Writer](./Java-Code/src/code/D_22_08/FileIO/Buffer/SimpleEncrypt.java)
#### [Employee db integrate with file](./Java-Code/src/code/D_22_08/FileIO/EmployeeDB/MainEmployee.java)


## [Serializable](./Java-Code/src/code/D_22_08/Serilizable/EmployeeSerialized.java)
	transient -- (ignore the object)

[23/08/19](./Java-Code/src/code/D_23_08)

### [Networking](./Java-Code/src/code/D_23_08/Networking/)
	socket:- software abstraction for input or output medium of communication
			 communtication channel that enable you to transfer through perticular port
			 an endpoint for communication between two machines
			 java performs low-level networking throuh sockets
	java.net
		ServerSocket
		MultiSocket
		Socket

[26-08-19](./Java-Code/src/code/D_26_08)


### [Networking](./Java-Code/src/code/D_26_08/Networking/MultiCast)

## [Junit testing](./Java-Code/src/code/D_26_08/JunitTesting)
	it is a unit testing development
	test driven development
		is a software development technique that invoves repeatedly writing test cases

## web application
	html over http
	cgi
	servlets
	jsp
	xml
	struts
	javaserver faces 


## [servlet](./Servlet_demo/src/code/D_28_08_19/servlet/Soccer_list.java)
	is java component that executes on server
	process http
	genereate http response
	web container is spacial
### http request
![alt image](https://www.ntu.edu.sg/home/ehchua/programming/webprogramming/images/HTTP_RequestMessageExample.png)
![alt image](http://www.tcpipguide.com/free/diagrams/httpresponse.png)

### web.xml
	<servlet>
	<display-name>
	<servlet-name>
	<servlet-class>package.classname
	</servlet>

	<servlet-mapping>
	<servlet-name>
	<url-pattern>
	</servlet-mapping>
abstraction  --  	RequestDispatcher -- follows previous request(get or post)
### [Controller](./EmployeeWebCRUD/src/code/D_28_08/Controll/AddEmployee.java)
	* A servlet which acts as a processing unit which makes descion to forward to spacific page
[[1]](./EmployeeWebCRUD/src/code/D_28_08/Controll/doDelete.java)[[2]](./EmployeeWebCRUD/src/code/D_28_08/Controll/ViewList.java)

### [Filter](./EmployeeWebCRUD/src/code/D_28_08/Filter/AdminFilter.java)
	*  called for every request and response 
	*  acts as a gateway
### [28/29-08-19 - Employee web CRUD](./EmployeeWebCRUD/src)
### [jsp](./EmployeeWebCRUD/WebContent/index.jsp)
	* An sevlet approach to embed in html
	* scriplet   defined in  <%    %>
	* directives  <@page import="j"> 
	* expression   <%=request.getParameter("name")%> only used to print
	* expression  language: ${}
	* to include java core to tag <% taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<c:if test="${fn:length(param.username)>0}">
			<%@include file="resp.jsp"%>  || <jsp:include page="resp.jsp"/>
		</c:if>
	
[[1]](./Servlet_demo/WebContent/form-view.jsp) [[2]](./EmployeeWebCRUD/WebContent/name.jsp)

### Cookie
	Cookie c = new Cookie("yourname",name);
	response.addCookie(c);

	Cookie[] allCookies = request.getCookies();
	if(allCookies[i].getName().equals("yourname")){
		name = allCookies[i].getValue();
	}


[30-08-19]

### Hibernate
	* ORM tool Object Relational Maping
	
	* Java class -- > Hibernate -->Database Table

	* Hibernate uses JDBC for all database communication
#### Java Annotation
	step 1: Map class to database table
	@Entity
	@Table(name="student")// table name
	public class Student"
	{

	}
	step 2: Map fields to database column
	@Entity
	@Table(name="student")// table name
	public class Student"
	{
		@Id
		@Column(name="id")
		int id;
	}

### one to one hibernate
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name="instructor_detail_id")

### Two key player

#### SessionFactory
	reads the hibernate config file creates session objects
	heavy object only create once in your app
#### Session
	wraps a JDBC connection main object used to save/retrive objects
	short-lived object retrived from sessionFactory

## MAVEN
	1-> Developer --> maven POM(Project object model)
	2-> Check local repo
	3-> get from remote repo
	4-> Save to local repo
	5-> Build and run

	G -group ID   Name of compony,group,org
	A - Archive Type  name for this project
	V- Version   a spacific release version like 1.0  2.0

	<groupId>com.mycode</groupid>
	<artifactId>mycoolapp</artifactId>
	<version>1.0FINAL</version>

	Directory Structute:
		appName:
			pom.xml
			src
				main
					java --- code
					resources	--- properties/config file
					webapp	--- jsp/web config and other web assets
				test   --- unit testing and properties
					java
					resources
			target --- destination dir for compiled code created by maven 

		org.apache.maven.archtype

### pom conf for web hibernet maven
	servlet
	mysql
	hibernet
	jstl
	lombok


### Entity LifeCycle
	Detatch -- if entity is not associated with hibernet
	Merge -- if instance is detached from session then merge will reattach to session
	Persist --  transition new instances to manage state
	Remove -- Transistion managed entity to be removed next flush/commit
	Refresh

	@OneToOne(cascade-CascadeType.ALL)
	@JoinColumn("instructo_detail_id")

     By Directional
	@OneToOne(mappedBy="instructor_detail_id")

