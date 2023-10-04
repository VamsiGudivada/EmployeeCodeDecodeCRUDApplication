# EmployeeCodeDecodeCRUDApplication
Dependencies to be added while craeting the project
spring-boot-starter-data-jpa

spring-boot-starter-web

mysql-connector-java

lombok

Application.properties:
server.port=8085

spring.datasource.url= jdbc:mysql://localhost:3306/DemoDB spring.datasource.username=root spring.datasource.password=root spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.show-sql=true spring.jpa.hibernate.ddl-auto=update spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect

In DBever : create new connection with database name as : localhost and multiple DBs will be available. Now create new DB dd name to applicatio.prop file.

create 5 folders - controller , service, repo, dtos, entities

Create entity Employee with @Id @GeneratedValue(strategy = GenerationType.AUTO)

To remove get, set for dto to entity, use map struct:

org.mapstruct mapstruct 1.4.1.Final
	and a plugin . The mapstruct-processor is used to generate the mapper implementation during the build: : 
	
	<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.5.1</version>
<configuration>
    <source>1.8</source>
    <target>1.8</target>
    <annotationProcessorPaths>
        <path>
            <groupId>org.mapstruct</groupId>
            <artifactId>mapstruct-processor</artifactId>
            <version>1.4.2.Final</version>
        </path>
    </annotationProcessorPaths>
</configuration>
	Now create a popluator package and an Employee populator interface. Annotate with @Mapper
	Create poplator instance by : EmployeePopulator INSTANCE = Mappers.getMapper(EmployeePopulator.class);
	
	Ignore extra fields using @Mapping(target = "id", ignore = true)
Now for validations use :
org.hibernate.validator hibernate-validator
	When Spring Boot finds an argument annotated with @Valid, it automatically bootstraps the default JSR 380 implementation — Hibernate Validator — and validates the argument.
When the target argument fails to pass the validation, Spring Boot throws a MethodArgumentNotValidException exception.

Now create @controllerAdvice and @ecxception handler to manage 400 BAD request and not so user riendly mesages on postman

@ResponseStatus(HttpStatus.BAD_REQUEST) @ExceptionHandler(MethodArgumentNotValidException.class) public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) { Map<String, String> errors = new HashMap<>(); ex.getBindingResult().getAllErrors().forEach((error) -> { String fieldName = ((FieldError) error).getField(); String errorMessage = error.getDefaultMessage(); errors.put(fieldName, errorMessage); }); return errors; }
