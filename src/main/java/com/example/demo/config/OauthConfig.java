package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.nio.charset.Charset;
import java.util.ArrayList;

@EnableOAuth2Client
@Configuration
public class OauthConfig {

    @Value("${oauth.resource:http://localhost:9530/api/v1.2}")
    private String baseUrl;
    @Value("${oauth.authorize:http://localhost:9530/api/v1.2/oauth/authorize}")
    private String authorizeUrl;
    @Value("${oauth.token:http://localhost:9530/api/v1.2/oauth/token}")
    private String tokenUrl;

    @Bean
    protected OAuth2ProtectedResourceDetails resource() {
        final String clientId = "guest";
        final String clientSecret = "sZEJ^9E]ekjj.{vc";
        final String grantType = "client_credentials";

        ClientCredentialsResourceDetails resource;
        resource = new ClientCredentialsResourceDetails();
        resource.setAccessTokenUri(tokenUrl);
        resource.setClientId(clientId);
        resource.setClientSecret(clientSecret);
        resource.setGrantType(grantType);
        return resource;
    }

    @Bean
    public OAuth2RestOperations restTemplate() {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext(atr));
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(baseUrl));

        // header
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json; charset=UTF-8"));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
