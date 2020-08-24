package com.taw.tests;

import org.testng.annotations.Test;

public class UnitTest {

    @Test
    public void test() {
       /* for (int i = 0; i < 60; i++) {
            System.out.println(otp.getOTP($("secret.key")));
            wait.sleep(1000);
            System.out.println(otp.getOTPRemainingTime());

        }*/
        Solution s = new Solution();
        s.solution(1);
    }
}

class Solution {
    public void solution(int N) {
        while (N > 0) {
            System.out.print(N % 10);
            N = N / 10;
        }
    }
}
