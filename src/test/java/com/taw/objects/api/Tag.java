
package com.taw.objects.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Tag {

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

        public Tag.Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Tag.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Tag build() {
            Tag tag = new Tag();
            tag.id = id;
            tag.name = name;
            return tag;
        }

    }

}
