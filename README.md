# Clipboard Automation Task

**Dependencies**

For this project to run, you would need to install below 3 dependencies on your machine:

- **[Java 11](https://openjdk.java.net/projects/jdk/11/)** (as the core programming language)
- **[Maven 3.8.5](https://maven.apache.org/download.cgi)** (for dependency management)
- **[Google Chrome latest version](https://www.google.com/chrome/?brand=CHBD&gclid=Cj0KCQjwr-SSBhC9ARIsANhzu15P0PA-n9Zp4NpxKaOHVGtBD1TZQH0HlQQE6hUfsOFAU1nf-Rzdlf4aAoTJEALw_wcB&gclsrc=aw.ds)** (browser to run your tests)

> If your JAVA_HOME is set to anything other than JDK 11, you would need to update the path. Else your project
> will not run. Also, do remember to set the correct JDK settings in your IDE. 

**Getting Started**

*choices file path:* src/main/resources/choices.conf

**APP_ENV:** Choose develop or staging environment file to run the test cases. Currently both are having same data.

**HOST"** This config field will let tests run in local or remote docket containers. 
*host.localhost* -> Thil config will run tests in our local machine.
*host.docker.selenium.grid* -> Thil config will run tests in remote docker containers.

**BROWSER:** This config field will let us run the tests in the given browser.

**HEADLESS:** This config field will let us run the tests in Headless mode if the value is *true*.

**Unit Tests Class:** src/test/java/TestSandbox.java

**Amazon Tests Class:** src/test/java/AmazonTests.java

**Run Tests from console:**
- Clone the project from git
- Update choices.conf file to run tests in local machine.
- Navigate to project folder where pom.xml is located.
- Execute the following command to run the test cases from console: *mvn clean test*

**Run Tests in IDE:**
- Import the project into IDE
- Update choices.conf file to run tests in local machine.
- Open AmazonTests class and run the tests using JUnit

**Run Tests in Docker:**

*Dockerfile Path:*  /ui-framework/UIFramework2.Dockerfile
- Install latest docker into your machine from **[Docker Download](https://www.docker.com/products/docker-desktop/)**
- Test cases execution instructions are mentioned at the top of the above Dockerfile path. Please kindly follow the instructions and execute the cases.


*docker-compose.yml file:* /ui-framework/docker-compose.yml
- Install latest docker into your machine from **[Docker Download](https://www.docker.com/products/docker-desktop/)**
- Docker containers spin up instructions are provided at top of the above mentioned docker-compose.yml file.
- Update the choices config **HOST** field value to **host.docker.selenium.grid** to run the tests in containers.
- Run the tests cases as per your choice by following instructions in **Run Tests from console:** or **Run Tests in IDE:**

# Note: 
Sometimes I was having chrome browser launch issues in containers. I tried many solutions to fix this like browser options and OS permissions etc. But none of them worked properly.
## Success!
