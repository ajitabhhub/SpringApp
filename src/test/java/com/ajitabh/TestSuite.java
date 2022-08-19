package com.ajitabh;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SelectPackages({"com.ajitabh.repositories", "com.ajitabh.entities"})
@SelectClasses( GreetingTest.class )
@Suite
@SuiteDisplayName("A demo Test Suite")
public class TestSuite {
}
