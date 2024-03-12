package com.taw.common.elements;

import org.openqa.selenium.JavascriptExecutor;

public class Interactions extends ElementBase{

    public void changeAttributeValue(String jsLocator, String attributeName, String attributeValue){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document."+jsLocator+".setAttribute('"+attributeName+"', '"+attributeValue+"')");

    }


}
