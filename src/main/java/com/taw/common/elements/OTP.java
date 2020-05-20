package com.taw.common.elements;

import com.warrenstrange.googleauth.GoogleAuthenticator;

import java.util.Calendar;
import java.util.Date;

public class OTP {
    public GoogleAuthenticator gAuth = new GoogleAuthenticator();

    public int getOTP(String secretKey) {
        int code = gAuth.getTotpPassword(secretKey);
        return code;
    }

    public int getOTPTime() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int sec = calendar.get(Calendar.SECOND);

        if (sec >= 30) {
            sec = 60 - sec;
        } else {
            sec = 30 - sec;
        }
        return sec;
    }
}
