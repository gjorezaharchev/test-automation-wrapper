package com.taw.common.emails;

import com.taw.common.Global;
import org.testng.annotations.Test;

import java.io.IOException;

public class MailSlurp extends Global {

    public String authenticate(){
        System.out.println($string("mailSlurpAPIKey"));
        String command = String.format("curl -H x-api-key:%s -X POST https://api.mailslurp.com/inboxes", $string("mailSlurpAPIKey"));
        //String command = String.format("curl -X GET -H x-api-key:461e538e3e32172ed3833d917e964191131af397d42806cf020d892e20dcbcb9 https://api.mailslurp.com/user/info -H 'accept: */*'");
       // String command = String.format("curl -v -X 'GET' 'https://api.mailslurp.com/emails?page=0&size=20&sort=ASC&unreadOnly=false&apiKey=%s'",$string("mailSlurpAPIKey"));
        //System.out.println(command);
        Process process;
        String response = null;
        try {
            process = Runtime.getRuntime().exec(command);
            StringBuilder sb = new StringBuilder();
            for (int ch; (ch = process.getInputStream().read()) != -1; ) {
                sb.append((char) ch);
            }
            for (int ch; (ch = process.getErrorStream().read()) != -1; ) {
                sb.append((char) ch);
            }
            response = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return response;
    }

    public String readEmailHeaderAndBody(){

        String command = String.format("curl -v -X 'GET' 'https://api.mailslurp.com/emails?page=0&size=20&sort=ASC&unreadOnly=false&apiKey=%s'",$string("mailSlurpAPIKey"));
        System.out.println(command);
        Process process;
        String response = null;
        try {
            process = Runtime.getRuntime().exec(command);
            StringBuilder sb = new StringBuilder();
            for (int ch; (ch = process.getInputStream().read()) != -1; ) {
                sb.append((char) ch);
            }
            response = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response);
        return response;
    }

    @Test
    public void test(){
        System.out.println(authenticate() );
    }
}
