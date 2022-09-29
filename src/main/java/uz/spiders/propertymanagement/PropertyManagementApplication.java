package uz.spiders.propertymanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.OAuth2Constants;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@SpringBootApplication
@EnableJms
public class PropertyManagementApplication {
	@Value("${aws.s3.access_key}")
	private String accessKey;
	@Value("${aws.s3.secret_key}")
	private String secretKey;
	@Value("${aws.zone}")
	private String zone;
	@Value("${keycloak.auth-server-url}")
	private String authKeycloakUrl;

	@Bean
	protected Keycloak keycloakAdminInstance() {
		return KeycloakBuilder.builder().serverUrl(authKeycloakUrl).realm("waa-property")
				.grantType(OAuth2Constants.PASSWORD)
				.username("admin").password("123456").clientId("waa-property-client").build();
	}

	@Bean
	public AmazonS3 s3() {

		AWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);
		return AmazonS3ClientBuilder
				.standard()
				.withRegion(zone)
				.withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
				.build();

	}

	public static void main(String[] args) {
		SpringApplication.run(PropertyManagementApplication.class, args);
	}

}
