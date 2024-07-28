# Bitexen UI Automation Case
To run tests on Chrome:

    mvn clean test -P chrome

To run tests on Firefox:

    mvn clean test -P firefox

To run tests locally:

    set isLocal=true on regarding property file under resources/sut-properties directory. 
To run it on Selenium Grid:

    Set isLocal=false on regarding property file under resources/sut-properties directory.

To generate allure report:

    allure serve target/allure-results

or if it gives error (like The BROWSE action is not supported on the current platform!):

    allure generate target/allure-results

It will generate report under allure-report folder in the root of your project
 