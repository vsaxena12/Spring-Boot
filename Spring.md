# Spring Boot

## History of Spring Deployment and Configuration

Current (Spring Boot)
	- You package your application as a fat JAR (includes all dependencies + embedded Tomcat).
	- Example:

java -jar MyApp.jar

MyApp.jar -> MyCode + Tomcat Embedded Server
```

```
	- The JAR includes:
	- Your code (MyCode)
	- Spring Boot starter dependencies
	- Embedded servlet container (e.g., Tomcat, Jetty, or Undertow)

Past (Traditional Spring Framework)
	- You packaged your application as a WAR (.war = Web Application Archive).
	- You deployed the WAR to an external application server (e.g., Apache Tomcat, JBoss, WebLogic).

```
Tomcat server -> deploy MyApp.war -> serves your web app
```

Configuration Differences

XML-Based Configuration (Old)
	- Spring beans and dependencies were defined in XML files:

```
<bean id="myService" class="com.example.MyService">
    <property name="repository" ref="myRepository"/>
</bean>
```

	- These XML files were loaded via ApplicationContext:

```
ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
```

Java-Based Configuration (Modern)
	- Introduced with Spring 3+
	- Uses @Configuration and @Bean:
```
@Configuration
public class AppConfig {
    @Bean
    public MyService myService() {
        return new MyService(myRepository());
    }
}
```

Component Scanning + Annotations (Spring Boot style)
	- Uses annotations like @Component, @Service, @Repository, and @Autowired
	- Spring Boot automatically scans classes using @ComponentScan

## Spring

Spring is a dependency injection framework. 

### Bean

A Bean is just a Java object that is managed by the Spring IoC container

```
@Component
public class Engine {
    public String type() {
        return "V8";
    }
}
```

### DI

Dependency Injection is the process where Spring injects one bean into another rather than you manually instantiating it.

DI is the process of injecting one bean into another bean.

Types of DI:
	- Constructor Injection
	- Setter Injection
	- Field Injection

```
@Component
public class Car {

    private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        System.out.println("Starting with engine: " + engine.type());
    }
}
```

### Autowiring 

Tells Spring to automatically resolve and inject a matching bean.

You use @Autowired to let Spring know where to inject.

```
@Component
public class Garage {

    @Autowired
    private Car car;

    public void open() {
        car.start();
    }
}
```

A. Autowiring by:
- @Primary
- By Name - how does it work??
- @Qualifier? 



### Inversion of Control (IoC)

IoC is a design principle where the control of object creation and wiring is inverted — instead of the class instantiating its dependencies, the container provides them.

In Spring, you don’t create new objects — Spring creates and wires them for you.


### IoC Container

The IoC Container is the part of Spring that:
	- Creates beans
	- Manages their lifecycle
	- Injects dependencies
	- Resolves scopes, proxies, etc.

It reads configuration (via annotations, Java config, or XML) and builds the object graph.

### ApplicationContext

ApplicationContext is the central interface to access Spring’s IoC container.

It provides methods like getBean() and manages the full bean lifecycle.

```
ApplicationContext context =
    new AnnotationConfigApplicationContext(AppConfig.class);

Car car = context.getBean(Car.class);
car.start();
```


## Constructor Injection vs Setter Injection vs Field Injection

### Constructor Injection

```
@Component
public class BinarySearchImpl {

    private final ISortAlgo arraySort;

    @Autowired
    public BinarySearchImpl(ISortAlgo arraySort) {
        this.arraySort = arraySort;
    }
}
```
- The dependency is required
- You want to enforce immutability
- You want better support for unit testing
- You prefer final fields (better thread-safety, no nulls)


### Setter Injection
```
@Component
public class BinarySearchImpl {

    private ISortAlgo arraySort;

    @Autowired
    public void setArraySort(ISortAlgo arraySort) {
        this.arraySort = arraySort;
    }
}
```
- The dependency is optional
- You need to change the dependency after object creation (rare in DI)
- The bean has circular dependencies (constructor injection won’t work directly)

### Field Injection

```
@Autowired
private ISortAlgo arraySort;
```

- Hard to test — can’t inject mock dependencies without using reflection or frameworks like Mockito
- Not visible what the dependencies are — constructor injection makes them obvious
- Breaks immutability — can’t mark fields final
- Violates DI principles — you can’t instantiate the class manually without Spring


## Hibernate/ JPA

- Framework for persisting/ saving Java Objects in a Database
- Handles all the low-level SQL
- Minimizes the amount of JDBS code you have to develop
- Object-to-relational Mapping (ORM)
  
JPA - Jakarta Persistance API which just an interface where as Hibernata is the implementation.

CRUD Apps
- Create objects
- Read objects
- Update objects
- Delete objects

Hibernate/JPA - uses JDBC for all database communications. 


