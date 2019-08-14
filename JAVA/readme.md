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

## Exception
	unexpected sitautation happens at runtime  
	Exception Handeling:- handling the unexpected sitatuation