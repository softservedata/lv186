**********************************************
			Info
**********************************************	

This library supports creating HTML reports for test automation projects that use JUnit or TestNG for test execution.

**********************************************
			Requirements
**********************************************	

1. AspectJ v.1.8.2 
2. JUnit v.4.9 or above for JUnit based projects OR TestNG for TestNG based projects

**********************************************
			Installation
**********************************************		

1. Add support for weaving the aspects from af.reporting library. To do so in a Maven project you will have to modify your pom.xml. See example pom.xml in ".\_example_files" directory.

2. Annotate your Business Methods (page Object`s public methods) with @ServiceReport annotation. 

3. Alter your test classes (hopefully only your test superclass). See a JUnit example in ".\_example_files\JunitTests.java" and TestNG example in ".\_example_files\TestNGTests.java".

**********************************************
			Configuration
**********************************************	

See ".\_example_files\JunitTests.java" or ".\_example_files\TestNGTests.java" file
and the constructor of TraceMethodCallsAspect class