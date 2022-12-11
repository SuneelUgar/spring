* OAUTH 2.0

Octa server  (oAuth2 Playground) - https://www.oauth.com/
https://www.oauth.com/playground/user-info

Grant types
1) Authorization code
2) Implicit Grant flow
3) Password Grant flow
4) Client Credential Grant Flow
5) Refresh type grant Flow (Refresh token will be used to extend expiry)

OpenID Connect : (ID token)
IAM (Identity and Access Management)
-------------------------------------------------------------------------------
* Maven dependencies
  <dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-oauth2-client</artifactId>
  </dependency>
-----------------------------------------------------------------
Project Configurations:

spring.security.oauth2.client.registration.github.client-id=b8eefa1e56a2666530ec
spring.security.oauth2.client.registration.github.client-secret=38c66cc43b7301540dbdef139bdde393dc2bc92e


