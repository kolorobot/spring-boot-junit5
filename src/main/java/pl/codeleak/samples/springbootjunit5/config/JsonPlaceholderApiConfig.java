package pl.codeleak.samples.springbootjunit5.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import pl.codeleak.samples.springbootjunit5.todo.JsonPlaceholderTaskRepository;
import pl.codeleak.samples.springbootjunit5.todo.TaskRepository;

@Configuration
public class JsonPlaceholderApiConfig {

    private final JsonPlaceholderApiConfigProperties properties;

    public JsonPlaceholderApiConfig(JsonPlaceholderApiConfigProperties properties) {
        this.properties = properties;
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplateBuilder()
                .rootUri(properties.getRootUri())
                .build();
    }

    @Bean
    TaskRepository taskRepository(RestTemplate restTemplate, JsonPlaceholderApiConfigProperties properties) {
        return new JsonPlaceholderTaskRepository(restTemplate, properties);
    }
}
