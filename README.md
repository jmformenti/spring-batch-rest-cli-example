# spring-batch-rest-cli-example

This is an example how you implement a Spring batch job once and execute it via command line or REST Api without any change in job source code.

## modules

 * **batch-core** implements a simple Spring batch job, *computePi*, which calculates Pi number with more or less precision in function of *count* parameter. You could implement more jobs here.
 * **batch-cli** execute jobs via command line using Spring Boot.
 * **batch-rest** execute jobs via REST Api using [spring-batch-rest](https://github.com/chrisgleissner/spring-batch-rest) and Spring Boot.
