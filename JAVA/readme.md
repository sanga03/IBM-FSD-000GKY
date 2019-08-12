# jvm 

instruction set
register set
class file format

## memory
	stack
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


## javap -c class name gives the bytecode

jvisualvm
jconsole -- visulaise the jvm


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

# [Inheritance](./JAVA_12-08/src/com/employee/)
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
	```
	@Override
		same method name as parent but different functionality with the child

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