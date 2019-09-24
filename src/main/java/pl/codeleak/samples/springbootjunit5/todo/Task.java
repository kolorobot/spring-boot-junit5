package pl.codeleak.samples.springbootjunit5.todo;

import com.fasterxml.jackson.annotation.JsonProperty;

class Task {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String title;

    @JsonProperty
    private Integer userId;

    @JsonProperty
    private boolean completed = false;

    Integer getId() {
        return id;
    }

    void setId(Integer id) {
        this.id = id;
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    Integer getUserId() {
        return userId;
    }

    void setUserId(Integer userId) {
        this.userId = userId;
    }

    boolean isCompleted() {
        return completed;
    }

    void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
