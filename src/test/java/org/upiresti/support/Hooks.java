package org.upiresti.support;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.setUp();
        System.out.println("Driver berhasil dibuat");
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }
}