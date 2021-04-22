## How to run:
Run command in terminal: 

> mvn clean install -Dmaven.test.skip=true

> mvn clean test -Dapp.url="https://www.company-name.com" -Dbrowser="chrome"

Command for report: 

>mvn allure:serve

## Dependencies:
- Java
- Maven
- Selenium WebDriver
- JUNIT5
- SLF4J
- Lombok
- Allure
- WebDriverManager
