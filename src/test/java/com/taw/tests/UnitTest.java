package com.taw.tests;

import com.taw.common.elements.Elements;
import org.testng.annotations.Test;

import java.util.Calendar;
import java.util.Date;

public class UnitTest extends Elements {

    @Test
    public void test() {
        for (int i = 0; i < 60; i++) {
            System.out.println(otp.getOTP($("secret.key")));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());
            System.out.println("time: " + calendar.get(Calendar.SECOND));
            System.out.println("remaining: " + otp.getOTPTime());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
