package pl.codeleak.samples.springbootjunit5.todo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import pl.codeleak.samples.springbootjunit5.config.JsonPlaceholderApiConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import(JsonPlaceholderApiConfig.class)
class TaskControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void findsTaskById() throws Exception {
        mockMvc.perform(get("/tasks/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"title\":\"delectus aut autem\",\"userId\":1,\"completed\":false}"));
    }
}