package pl.codeleak.samples.springbootjunit5.todo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import pl.codeleak.samples.springbootjunit5.config.JsonPlaceholderApiConfigProperties;

import java.util.List;

public class JsonPlaceholderTaskRepository implements TaskRepository {

    private final RestTemplate restTemplate;
    private final JsonPlaceholderApiConfigProperties properties;

    public JsonPlaceholderTaskRepository(RestTemplate restTemplate, JsonPlaceholderApiConfigProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    @Override
    public Task findOne(Integer id) {
        return restTemplate
                .getForObject("/todos/{id}", Task.class, id);
    }

    @Override
    public List<Task> findAll() {
        return restTemplate
                .exchange("/todos?_sort={sort}&_order={order}&_limit={limit}",
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Task>>() {},
                        properties.getTodoFindAll().getSort(),
                        properties.getTodoFindAll().getOrder(),
                        properties.getTodoFindAll().getLimit())
                .getBody();
    }

    @Override
    public List<Task> findByTitle(String title) {
        return restTemplate
                .exchange("/todos?title_like={title}", HttpMethod.GET, null, new ParameterizedTypeReference<List<Task>>() {}, title)
                .getBody();
    }
}
