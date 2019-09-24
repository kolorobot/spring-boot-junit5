package pl.codeleak.samples.springbootjunit5.todo;

import java.util.List;

public interface TaskRepository {

    Task findOne(Integer id);

    List<Task> findAll();

    List<Task> findByTitle(String title);
}
