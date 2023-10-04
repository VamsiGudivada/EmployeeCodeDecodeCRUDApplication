# EmployeeCodeDecodeCRUDApplication
Dependencies to be added while creating the project
spring-boot-starter-data-jpa

spring-boot-starter-web

centralize logging mechanism using spring aop

mysql-connector-java

lombok

Application.properties:
server.port=8085

spring.datasource.url= jdbc:mysql://localhost:3306/employeecrud or using AWS RDS connect directly it to MySQL Workbench with AWS SQL cloud after providing spring.datasource.url= spring.datasource.url = jdbc:mysql://vamsisqldb.cw9qctyhwqsk.us-east-2.rds.amazonaws.com:3306/employeecrud 
spring.datasource.username=root 
spring.datasource.password=Vamsi2210 
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true spring.jpa.hibernate.ddl-auto=update spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect

In DBserver : create a new connection with the database name as localhost and multiple DBs will be available. Now create a new DB dd name to application.prop file.

create 7 folders - controller, dtos, entities, exceptionhandler, service, repo, populator

Create entity Employee with @Id @GeneratedValue(strategy = GenerationType.AUTO)

To remove get, set for dto to entity, use map struct:

org. map struct mapstruct 1.4.1.Final
	and a plugin. The map struct-processor is used to generate the mapper implementation during the build: 
	Now create a popluator package and an Employee populator interface. Annotate with @Mapper
	Create populator instance by : EmployeePopulator INSTANCE = Mappers.getMapper(EmployeePopulator.class);
	
	Ignore extra fields using @Mapping(target = "id", ignore = true)
Now for validations use :
org.hibernate.validator hibernate-validator
	When Spring Boot finds an argument annotated with @Valid, it automatically bootstraps the default JSR 380 implementation — Hibernate Validator — and validates the argument.
When the target argument fails to pass the validation, Spring Boot throws a MethodArgumentNotValidException exception.

Now create @controllerAdvice to manage 400 BAD request and not so user friendly mesages on postman

@ResponseStatus(HttpStatus.BAD_REQUEST) @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) { Map<String, String> errors = new HashMap<>(); ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName = ((FieldError) error).getField(); String errorMessage = error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return errors; }
