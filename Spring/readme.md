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

### Model view Controller
![alt image](https://static.javatpoint.com/sppages/images/spring-web-model-view-controller.png)

	Front controller known as DispatcherServlet(part of Spring framework)
	We will create Model Object View Templates and Controller
#### Controller
	contains Buisness logic
	handle the request
	store/retrive data
	place data in model
	send appropriate view template
#### Model
	contains data
	store/retrive via backend
	use spring bean
	place your data in model
#### view
	supports view template 
	jsp and servlets
	tymeleaf goofer

### Spring MVC Configuration
#### Add Configuration file (WEB-INF/web.xml) 
	configure spring MVC Dispatcher Servlet

	<servlet>
	<servlet-name>dispatcher</servlet-name>
	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	<init-param>
	<param-name>contextConfigLocation</param-name>
	<param-value>/WEB-INF/spring-mvc-demo-sevlet.xml</param-value>
	</init-param>
	<load-on-startup>1</>
	</sevlet>
	
	Set up the URL mapping to Spring MVC Dispatcher Servlet
	<servlet-mapping >
	<servlet-name>dispatcher</servlet-name>
	<url-pattern>/</url-pattern>

### Development Process
	create controller class
	define controller model

	</servlet-maping>
	
#### Add Configuration file (WEB-INF/spring-mvc-demo-sevlet.xml)
	add Support for spring companent scanning

	<beans>
	<context:component-scan base-package="org.fsd.springdemo">
	</beans>

	add support for conversion formatting and validation
		
		<mvc:annotaion-driven/>

	configure spring MVC View Resolver
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/view/"/>
		<property name="suffix" value=".jsp"/>
		</bean>



#### Spring MVC Form Tags:
	form Tag 	

	<%@ taglib prefix="form" uri="http://springframework.org/tags/form" %>

#### Hibernet Spring MVC
	<bean id="sessionFactory" class="org.springframework.com.hibernate5.LocalSessionFactorBean">
	<bean property name="dataSorce" ref="myDataSource">
	<bean property name="packagesToScan" value="com.example.base"
	dependency:
		sevlet -4.0.1
		jstl  - 1.2
		web mvc - 5.1.9
		hiberbate - Core --5.4.1,ORM -- 5.4.4,validator engine --6.0.4
		spring transaction 5.1.9
		lombok  -- 1.18.8
		java annotaion -- 1.3.2
		C3P0	-- 0.9

#### Representaional State Transfer
	over HTTP
		POST
		GET
		PUT
		DELETE

#### AbstractAnnotationConfigDispatcherServletInitializerherConfiguration
			public class Myinitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}

}

### 10-09-19
	CRM services - - Customer Services -- customer Dao -- database

	pom.xml
	all java config
	config for database connection
	hibernate entity class
	doa
	services

### [Spring Boot](https://howtodoinjava.com/spring-boot2)
	Spring Boot is a Spring framework module which provides RAD (Rapid Application 
	Development) feature to the Spring framework. It is highly dependent on 
	the starter templates feature which is very powerful and works flawlessly

	With Spring boot, to create MVC application all you need to import is 
	spring-boot-starter-web dependency.

	
	you do not need to provide version information into child dependencies

	Autoconfiguration is enabled with @EnableAutoConfiguration annotation. Spring 
	boot auto configuration scans the classpath, finds the libraries in the 
	classpath and then attempt to guess the best configuration for them, and 
	finally configure all such beans.

	Spring boot applications always include tomcat as embedded server dependency. 
	It means you can run the Spring boot applications from the command prompt 
	without needling complex server infrastructure.

#### H2 database
	inmemory database for Spring 
	no need to create table scheme 
	auto binded with @Entity

	jdbc:h2:mem:testdb
	org.h2.Driver

#### [Thymeleaf](https://www.thymeleaf.org/doc/tutorials/2.1/usingthymeleaf.html)
	Thymeleaf is a Java XML/XHTML/HTML5 template engine that can work both in web 
	and non-web environments. It is better suited for serving XHTML/HTML5 at the 
	view layer of MVC-based web applications, but it can process any XML file even 
	in offline environments. It provides full Spring Framework integration.


	included in html by
	<html lang="en" xmlns:th="http://www.thymeleaf.org">
	then use th namespace
	<th:foreach>
[example 1](./soccer-bootstrap-h2/src/main/resources/templates/league/list.html)
[example 2](./soccer-bootstrap-h2/src/main/resources/templates/league/add-form.html)
onApplicationEvent


INGREDENT:
	ID
	AMOUNT
	DESC
	RECIPE_ID
	UOM_ID

RECIPE
	ID
	COOKTIME
	DESC
	DIFFICULTY
	PREP-TIME
	SERVING
	SOURCE
	URL
	NOTES-ID
	DIRECTION
	
NOTES
	ID
	RECIPE-NOTES
	RECIPE-ID