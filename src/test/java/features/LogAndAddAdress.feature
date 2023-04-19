Feature: Poprawne logowanie oraz dodanie adresu
  Scenario Outline: Logowanie do aplikacji za pomocą poprawnych danych oraz dodanie adresu
    Given Uzytkownik znajduje sie na stronie glownej aplikacji
    When Uzytkownik wybiera opcje SignIn
    And Uzytkownik wpisuje poprawny adres "<email>" oraz "<haslo>" po czym zatwierdza logowanie
    And Po przeniesieniu uzytkownik klika AddNewAdress
    Then Uzupełnia dane "<alias>", "<adress>", "<city>", "<zipcode>", "<country>", "<phone>" oraz sprawdza poprawnosc zapisu
    Examples:
    |email|haslo|alias|adress|city|zipcode|country|phone|
    |bardzolosowedane@wp.pl|bardzolosowehaslo123!|Adres1|Polna 2|Brzesko|54-007|United Kingdom|123456789|

