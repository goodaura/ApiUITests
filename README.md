Hi there. You can see my learning projects. 

I use Page Object pattern, so in main/java directory you can see pages and constants, in test derictory you can see tests and resources. 

# Structure

main

java
- constants
  - AppleinsiderConstants
- pages
  - appleinsider
    - AppleinsiderMainPage
    - AppleinsiderSearchPage

test

java
- appleinsider
  - AppleinsiderTest
- base
  - BaseTest
  - 
resourses
- allure.properties
      
      
# AppleinsiderUITest 
UI tests for https://appleinsider.ru/ with Selenide.

Tests:
- Href from first article after searching "Чем iPhone 13 отличается от iPhone 12" contains "iphone-12";
- Button "Предыдущая" ("Previous") is not visible on main page;
- Button "Предыдущая" ("Previous") is visible after click to button "Следующая" ("Next"). 
