package pl.codeleak.samples.springbootjunit5.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskControllerIntegrationTestWithMockBeanTest {

    @LocalServerPort
    private int port;

    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void findsTaskById() {

        // arrange
        var taskToReturn = new Task();
        taskToReturn.setId(1);
        taskToReturn.setTitle("delectus aut autem");
        taskToReturn.setCompleted(true);
        taskToReturn.setUserId(1);

        when(taskRepository.findOne(1)).thenReturn(taskToReturn);

        // act
        var task = restTemplate.getForObject("http://localhost:" + port + "/tasks/1", Task.class);

        // assert
        assertThat(task)
                .extracting(Task::getId, Task::getTitle, Task::isCompleted, Task::getUserId)
                .containsExactly(1, "delectus aut autem", true, 1);
    }
}