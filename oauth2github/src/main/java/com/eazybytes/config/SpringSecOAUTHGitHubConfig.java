package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecOAUTHGitHubConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((auth) -> {
            try {
                auth.anyRequest().authenticated().and().oauth2Login();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        return http.build();

    }

/*    private ClientRegistration clientRegistration() {
        return
                CommonOAuth2Provider.GITHUB.getBuilder("github").clientId(
                                "b8eefa1e56a2666530ec")
                        .clientSecret("38c66cc43b7301540dbdef139bdde393dc2bc92e").build();
    }


    *//*
     * private ClientRegistration clientRegistration() { ClientRegistration cr =
     * ClientRegistration.withRegistrationId("github").clientId(
     * "3c9be97074f067e78e75")
     * .clientSecret("ab313f7ade3d79e06c192ca80cf152c43cb5d916").scope(new String[]
     * { "read:user" })
     * .authorizationUri("https://github.com/login/oauth/authorize")
     * .tokenUri("https://github.com/login/oauth/access_token").userInfoUri(
     * "https://api.github.com/user")
     * .userNameAttributeName("id").clientName("GitHub")
     * .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
     * .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}").build
     * (); return cr; }
     *//*


    @Bean
    public ClientRegistrationRepository clientRepository() {
        ClientRegistration clientReg = clientRegistration();
        return new InMemoryClientRegistrationRepository(clientReg);
    }*/

}
