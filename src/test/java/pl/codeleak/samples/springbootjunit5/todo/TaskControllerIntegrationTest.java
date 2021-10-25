package pl.codeleak.samples.springbootjunit5.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void findsTaskById() {
        // act
        var task = restTemplate.getForObject("http://localhost:" + port + "/tasks/1", Task.class);

        // assert
        assertThat(task)
                .extracting(Task::id, Task::title, Task::completed, Task::userId)
                .containsExactly(1, "Hagamos que falle", false, 1);
    }
}
