package pl.codeleak.samples.springbootjunit5.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class TaskController {

    private final TaskRepository taskRepository;

    TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks/{id}")
    Task findOne(@PathVariable Integer id) {
        return taskRepository.findOne(id);
    }

    @GetMapping("/tasks")
    List<Task> findAll() {
        return taskRepository.findAll();
    }

    @GetMapping(value = "/tasks", params = "title")
    List<Task> findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }
}
