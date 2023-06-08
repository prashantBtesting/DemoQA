package utils;

import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public PageObjectManager POM;
    public TestBase base;
public  TestContextSetup() throws IOException {
    base= new TestBase();
    POM =new PageObjectManager(base.initializeDriver());
}
}
