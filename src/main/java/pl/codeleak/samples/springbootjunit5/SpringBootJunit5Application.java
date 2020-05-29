package pl.codeleak.samples.springbootjunit5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import pl.codeleak.samples.springbootjunit5.config.JsonPlaceholderApiConfigProperties;

@SpringBootApplication
@EnableConfigurationProperties(JsonPlaceholderApiConfigProperties.class)
public class SpringBootJunit5Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootJunit5Application.class, args);
    }

}
