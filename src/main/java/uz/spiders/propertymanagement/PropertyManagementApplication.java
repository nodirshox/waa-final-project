package uz.spiders.propertymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.OAuth2Constants;

@SpringBootApplication
@EnableJms
public class PropertyManagementApplication {
	@Value("${keycloak.auth-server-url}")
	private String authKeycloakUrl;

	@Bean
	protected Keycloak keycloakAdminInstance() {
		return KeycloakBuilder.builder().serverUrl(authKeycloakUrl).realm("master")
				.grantType(OAuth2Constants.PASSWORD)
				.username("admin").password("123456").clientId("spring-boot").build();
	}


	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementApplication.class, args);
	}

}
