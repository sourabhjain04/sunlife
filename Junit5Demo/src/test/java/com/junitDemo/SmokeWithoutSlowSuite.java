package com.junitDemo;


import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages("com.junitDemo")
@IncludeTags( "smoke")
@ExcludeTags("slow")
public class SmokeWithoutSlowSuite {
}
