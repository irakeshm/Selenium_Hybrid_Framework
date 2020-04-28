
# 1. Introduction
This Test Automation Framework is a Hybrid Test Automation Framework, designed to automate some UI Test Cases. The framework provides the user with various benefits that help them to develop, execute and report the automation test scripts efficiently. this framework is the combination of one or more frameworks Data-Driven Framework, Page-Object Model pulling from their strengths and trying to mitigate their weaknesses.
• Language: Java
• Automation Library: Selenium WebDriver
• Object Repository: Page-Object Model (Page Factory)
• Build Tool & Project: Maven
• Test Runner Library: TestNG (Parallel Execution also available)
• Reporting: Extent Repots
• Logging: Log4J
• Browsers Supports: Google Chrome, Firefox, Safari, IE
# 2. Framework Architecture
# Check Readme.pdf for more details
# 3. Project File Structure
# Check Readme.pdf for more details
# 4. Test Execution and Result File
TestNG xml files is used to execute the Test cases, even for the parallel execution, we can use the TestNG xml file. We just need to execute the testng.xml file as a “TestNG” project to execute the Test Suits.
After Execution, Test Result file (Extent Report) will be Generated.
# 5. Notes & Assumptions
Notes: dummy user used for execution of Test Cases.
Email Id: amazon.test.users@gmail.com
Password: amazon.com
Name: TestUser
Assumption:
Website view can be different in different location, (for example- for US user on Amazon.com, there is no menu as “Department” available at home screen)
So the Test case executed in this Test runner, is with above user and in India Location.
