### 04-09-2019

## Spring

	popular framework for building java application
	developed by rod jhonson 
	initially simpler and lightweight alternative to J2EE
	provides large number of helper classes

	IOC --- inversion of Control
	DI -- dependency Injuction 

### Goals
	java pojo
	di to promote loose coupling
	AOP

## Core Container
![alt image](https://docs.spring.io/spring/docs/4.2.x/spring-framework-reference/html/images/spring-overview.png)
	testing unit,integration,mock 


### inversion of  control
	The approach of outsourcing the construction and management of objects
## [Spring development process](./spring_demo_maven)
### 1-> [configure your beans](./spring_demo_maven/)
		create bean package and add classes
### 2 -> create spring container
		
	create springConfig (applicationContext.xml) with <bean name="coach" class"package.bean.CricCoach"></bean>
### 3 -> retrive beans from spring container
		import org.springframework.context.support.ClassPathXmlApplicationContext;
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext('applicationContext.xml')
		Coach coach = context.getBean("coach",CricCoach.class)


### [Bean Life Cycle](https://i2.wp.com/www.dineshonjava.com/wp-content/uploads/2012/06/Spring-Bean-Life-Cycle.jpg?w=530&ssl=1)
	init is called first and distroy is called

### Spring develoment methods
#### [XML](#spring-development-process)
#### Annotation(./spring_demo_annotation/src/main/java/applicationContext.xml)
	use xml to set context 
	<context:component-scan base-package="org.fsd.spring_demo_annotation.bean"></context:component-scan>
	then use annotation 
	@Component --- equ to  <bean name="coach" class"package.bean.CricCoach"></bean>
	@Value		-- equ to  passing throug constructor
	@AutoWired -- equ to ref

#### java source(./spring_demo_annotation/src/main/java/org/fsd/spring_demo_annotation/bean/CoachConfig.java)
	use AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoachConfig.class);
	to set context

