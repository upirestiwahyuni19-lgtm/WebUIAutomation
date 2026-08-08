Feature: Login User

  Background:
    Given user berada di halaman login

  @positive
  Scenario: Login dengan username dan password yang benar
    When user memasukkan username "standard_user"
    And user memasukkan password "secret_sauce"
    And user menekan tombol login
    Then user berhasil login

  @negative
  Scenario: Login dengan username dan password yang salah
    When user memasukkan username "wrong_user"
    And user memasukkan password "wrong_password"
    And user menekan tombol login
    Then muncul pesan error login

  @boundary
  Scenario: Login dengan username kosong
    When user memasukkan username ""
    And user memasukkan password "secret_sauce"
    And user menekan tombol login
    Then muncul pesan error login

  @boundary
  Scenario: Login dengan username sangat panjang
    When user memasukkan username "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    And user memasukkan password "secret_sauce"
    And user menekan tombol login
    Then muncul pesan error login