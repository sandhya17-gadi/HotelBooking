#Author:Sandhya Gadi
@HotelBookingForm

Feature: HotelBooking Form

Scenario: check title
Description: when user is on hotel booking page user will check
wheteher title matches or not
Given  User is on the Registration page
Then check title of the page

Scenario: check user fIrst name
Description:when user enters invalid fist name user should get an error message
Given User is on the Registration page
When User enters invalid first name
|7yu7|
|1234|
|sa|
|sanb123|
Then user should get an error message




Scenario: check user invalid last name
Description:when user enters invalid last name user should get an error message
Given User is on the Registration page
When User enters invalid last name
|last_name1|
|s|
|san|
| |
|213sa|
|san|
Then user should get an error message


Scenario Outline: check user invalid mobileno
Description:when user enters invalid mobileno user should get an error message
Given User is on the Registration page
When User enters invalid <mobileno>
Then user should get an error message
Examples: 
         |mobileno|
         |1234|
         |987|
         |1234567891|
         |99122233|
         
         
         
Scenario: check user city drop down list
Description:when user clicks on drop down user should able to get the city name
Given User is on the Registration page
When User clicks drop down list
Then user should get the city name

          
          





