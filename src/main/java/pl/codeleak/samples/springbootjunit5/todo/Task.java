package pl.codeleak.samples.springbootjunit5.todo;

import com.fasterxml.jackson.annotation.JsonProperty;

record Task(@JsonProperty("id")Integer id,
            @JsonProperty("title")String title,
            @JsonProperty("userId")Integer userId,
            @JsonProperty("completed")boolean completed) {
}