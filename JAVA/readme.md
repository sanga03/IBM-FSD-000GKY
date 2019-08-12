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