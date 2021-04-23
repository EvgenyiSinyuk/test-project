## How to run:
Run command in terminal: 

> mvn clean install -Dmaven.test.skip=true

> mvn clean test -DsiteUrl="https://www.company-name.com" -Dbrowser="chrome"

Command for report: 

>mvn allure:serve

##Properties in application.properties
- siteUrl - url of application under test
- browser - browser name which will be used for test run

## Dependencies:
- Java
- Maven
- Selenium WebDriver
- JUNIT5
- SLF4J
- Lombok
- Allure
- WebDriverManager

