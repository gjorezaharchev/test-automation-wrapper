package com.taw.common.drivers;

import com.taw.common.Global;


/**
 * @author Gjore.Zaharchev
 */
public class SetUp extends Global {


    public void setBrowser() {
        switch (browser) {
            case CHROME:
                new Chrome().browser();
                break;
            case IE:
                new IE().browser();
                break;
            case FIREFOX:
                new Firefox().browser();
                break;
            case SAFARI:
                new Safari().browser();
                break;
            case EDGE:
                new Edge().browser();
                break;
            case ANDROID:
                new Android().android();
                break;
            case IOS:
                new IOS().iosDriver();
                break;
            case HTMLUNIT:
                new HTMLUnit().browser();
                break;
            case WINDOWS:
                new Windows().windowsDriver();
                break;
            case MAC:
                new MAC().macDriver();
                break;
            default:
                //System.err.println("You are using an unsupported platform/browser!!!");
                break;
        }
    }
}
