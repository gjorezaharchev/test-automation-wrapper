package com.taw.objects.api;

import com.github.javafaker.Cat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Pet {

    int id;
    Category category;
    String name;
    String[] photoUrls;
    List<Tags> tags;
    String status;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Category{
        int id;
        String name;
    }
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public static class Tags{
        int id;
        String name;
    }
}
