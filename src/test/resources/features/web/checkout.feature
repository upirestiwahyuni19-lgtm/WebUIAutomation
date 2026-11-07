
@web @e2e
Feature: End to End Checkout

  Scenario: User berhasil melakukan checkout
    Given user berada di halaman login
    When user memasukkan username "standard_user"
    And user memasukkan password "secret_sauce"
    And user menekan tombol login
    Then user berhasil login
    And user menambahkan Sauce Labs Backpack ke cart
    And user membuka shopping cart
    And user melakukan checkout
    And user mengisi informasi checkout
    And user menyelesaikan order
    Then order berhasil dibuat
