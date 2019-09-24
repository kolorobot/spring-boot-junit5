package pl.codeleak.samples.springbootjunit5.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties(prefix = "json-placeholder")
public class JsonPlaceholderApiConfigProperties {

    @NotBlank
    private String rootUri;

    private TodoFindAll todoFindAll;

    public String getRootUri() {
        return rootUri;
    }

    public void setRootUri(String rootUri) {
        this.rootUri = rootUri;
    }

    public TodoFindAll getTodoFindAll() {
        return todoFindAll;
    }

    public void setTodoFindAll(TodoFindAll todoFindAll) {
        this.todoFindAll = todoFindAll;
    }

    public static class TodoFindAll {

        private String sort;
        private String order;
        private int limit;

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }
    }
}
