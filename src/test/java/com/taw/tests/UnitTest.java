package com.taw.tests;

import com.taw.common.elements.Elements;
import org.testng.annotations.Test;

public class UnitTest extends Elements {

    @Test
    public void test() {
        for (int i = 0; i < 60; i++) {
            System.out.println(otp.getOTP($("secret.key")));
            wait.sleep(1000);
            System.out.println(otp.getOTPRemainingTime());

        }
    }
}
