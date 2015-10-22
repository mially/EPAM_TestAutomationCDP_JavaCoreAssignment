package com.epam.cdpWeek2project.managers;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        PlayroomManagerTest.class,
        ToysManagerTest.class
})
public class ManagersTestSuite {
    @BeforeClass
    public static void setUpClass() {
        System.out.println("\nLet's test!\n");

    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("\nTired of testing...\n");
    }

}
