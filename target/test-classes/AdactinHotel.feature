Feature: To verify the Adactin Hotels Bookings

  @Sanity
  Scenario Outline: To verify the Adactin Hotels Booking confirmation
    Given user enters into the Adcatin Hotels LoginPage
    And user enters the "<Username>" , "<Password>" and click the login button
    And user enters the search hotel "<Location>" , "<Hotels>" , "<Room Type>" and "<Rooms>"
    And user enters and check the date "<Check In Date>" and "<Check Out Date>"
    And user enters the "<Adults>" and "<Children>"
    When user click the search button
    Then user verify the search results

    #And user click the Reset button
    Examples: 
      | Username     | Password | Location    | Hotels         | Room Type | Rooms | Check In Date | Check Out Date | Adults | Children |
      | DharmaEswari | JD56FA1 | Los Angeles | Hotel Sunshine | Standard  |     4 | 10/09/2023    | 11/09/2023     |      1 |        1 |

  #| DharmaEswari | REJD@651969 | London      | Hotel Creek    | Double       |     5 | 12/09/2023    | 14/09/2023     |      2 |        2 |
  #| DharmaEswari | REJD@651969 | New York    | Hotel Hervey   | Deluxe       |     6 | 14/09/2023    | 16/09/2023     |      3 |        3 |
  #| DharmaEswari | REJD@651969 | Paris       | Hotel Cornice  | Super Deluxe |     7 | 16/09/2023    | 18/09/2023     |      4 |        4 |
  #| DharmaEswari | REJD@651969 | Melbourne   | Hotel Creek    | Double       |     8 | 18/09/2023    | 20/09/2023     |      5 |        4 |
  Scenario Outline: To verify the Adactin Hotels Booking confirmation with invalid credentials
    Given user enters into the Adcatin Hotels LoginPage
    And user enters the "<Username>" , "<Password>" and click the login button
    And user enters the search hotel "<Location>" , "<Hotels>" , "<Room Type>" and "<Rooms>"
    And user enters and check the date "<Check In Date>" and "<Check Out Date>"
    And user enters the "<Adults>" and "<Children>"
    When user click the search button
    Then user verify the search results

    #And user click the Reset button
    Examples: 
      | Username     | Password   | Location    | Hotels         | Room Type | Rooms | Check In Date | Check Out Date | Adults | Children |
      | DharmaEswari | REJD@65196 | Los Angeles | Hotel Sunshine | Standard  |     4 | 10/09/2023    | 11/09/2023     |      1 |        1 |
