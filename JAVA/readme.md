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