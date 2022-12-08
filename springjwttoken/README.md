* Maven dependencies
  <dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-api</artifactId>
  <version>0.11.1</version>
  </dependency>
  <dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-impl</artifactId>
  <version>0.11.1</version>
  <scope>runtime</scope>
  </dependency>
  <dependency>
  <groupId>io.jsonwebtoken</groupId>
  <artifactId>jjwt-jackson</artifactId>
  <version>0.11.1</version>
  <scope>runtime</scope>
  </dependency>

Project Configurations:

protected void configure(HttpSecurity http) throws Exception {
http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
config.setAllowedHeaders(Collections.singletonList("*"));

1) Write JWTTokenGeneratorFilter.java
2) Write JWTTokenValidatorFilter.java
