package com.taw.tests;

import com.taw.common.elements.Elements;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class UnitTest extends Elements {

    @Ignore
    @Test
    public void test1() {
        String[] a = {"S", "M", "L"};
        System.out.println($.get_index_of(a, "S"));
        System.out.println("Test");
        System.out.println(String.valueOf($.random_full_name()));
        assertThat($.random_full_name()).isEqualTo("Gjore Zaharchev");
    }
}