Feature: Book Flight and Accommodation in lastminute.com.au

Scenario Outline: Search flight and accommodation for specific dates and book

Given The user is in lastminute homepage as logged in member
When User search for flights and accommodation <from> <to> <checkIn> and <checkOut>
And User Added filters <mealPlan> <amenity> <cancellationOption>
And User selected <roomType> <bedType> room
And User Selected flights
Then User proceeds to Checkout with Passenger details <p1Title> <p1Mobile> <p1Gender> <p1DOB> <p2Title> <p2firstName> <p2LastName> <p2Gender> <p2DOB>
And Payment details <cardNumber> <expiry> <cvc>
And Billing Address details <address1> <city> <postCode> <state> and complete booking


Examples:
| from | to  | checkIn     | checkOut    | mealPlan  | amenity | cancellationOption | roomType | bedType | p1Title | p1Mobile   | p1Gender | p1DOB      | p2Title | p2firstName | p2LastName | p2Gender | p2DOB      | cardNumber       | expiry  | cvc | address1 | city   | postCode | state |
| SYD  | BNE | 04-May-2023 | 06-May-2023 | Breakfast | Pool    | refundable         | Superior | King    | Mr.     | 0491578888 | Male     | 01-01-1991 | Ms.     | TestUserFN  | TestUserLN | Female   | 01-12-1991 | 4111111111111111 | 12-2025 | 123 | Street   | Sydney | 2000     | NSW   |