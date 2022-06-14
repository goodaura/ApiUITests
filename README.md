Hi there. You can see my learning projects of test automation. 

# API tests
For API tests I use Rest Assured library. 
      
# apiReqres
Api tests for https://reqres.in/

Api autotests using Pojo classes and Specification for the RestAssured library.

# UI tests
I use Page Object pattern, so in main/java directory you can see pages and constants, in test derictory you can see tests and resources. To call latest chromedriver I use webdrivermanager dependency.


# appleinsider
UI tests for https://appleinsider.ru/ with Selenide.

Tests:
- Href from first article after searching "Чем iPhone 13 отличается от iPhone 12" contains "iphone-12";
- Button "Предыдущая" ("Previous") is not visible on main page;
- Button "Предыдущая" ("Previous") is visible after click to button "Следующая" ("Next"). 

# demoqa
UI tests for https://demoqa.com/ with Selenide.

Tests: 
- Finding book "Pocket Guide Book" and checking fields "ISBN", "Title", "Sub title", "Total pages" on book page;
- Check error message after try to register without reCapture.


