
package com.taw.objects.api;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class PetStore {

    @Expose
    private Category category;
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private List<String> photoUrls;
    @Expose
    private String status;
    @Expose
    private List<Tag> tags;

    public Category getCategory() {
        return category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public String getStatus() {
        return status;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public static class Builder {

        private Category category;
        private Long id;
        private String name;
        private List<String> photoUrls;
        private String status;
        private List<Tag> tags;

        public PetStore.Builder withCategory(Category category) {
            this.category = category;
            return this;
        }

        public PetStore.Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public PetStore.Builder withName(String name) {
            this.name = name;
            return this;
        }

        public PetStore.Builder withPhotoUrls(List<String> photoUrls) {
            this.photoUrls = photoUrls;
            return this;
        }

        public PetStore.Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public PetStore.Builder withTags(List<Tag> tags) {
            this.tags = tags;
            return this;
        }

        public PetStore build() {
            PetStore petStore = new PetStore();
            petStore.category = category;
            petStore.id = id;
            petStore.name = name;
            petStore.photoUrls = photoUrls;
            petStore.status = status;
            petStore.tags = tags;
            return petStore;
        }

    }

}
