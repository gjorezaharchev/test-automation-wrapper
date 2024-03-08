
package com.taw.objects.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Category {

    @Expose
    private Long id;
    @Expose
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private Long id;
        private String name;

        public Category.Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Category.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Category build() {
            Category category = new Category();
            category.id = id;
            category.name = name;
            return category;
        }

    }

}
