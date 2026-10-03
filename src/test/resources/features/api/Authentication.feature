Feature: Login API

  @api @smoke @allure.label.epic:API_Automation @allure.label.feature:Authentication
  Scenario: Register kemudian login menggunakan akun baru
    Given user baru melakukan register
    When user melakukan register melalui API
    Then register berhasil dengan status code 201
    When user login menggunakan akun yang baru didaftarkan
    Then login berhasil dengan status code 200
    And response success bernilai true

  @api @smoke @allure.label.epic:API_Automation @allure.label.feature:Authentication
  Scenario: Register kemudian login dan logout menggunakan akun baru
    Given user baru melakukan register
    When user melakukan register melalui API
    Then register berhasil dengan status code 201
    When user login menggunakan akun yang baru didaftarkan
    Then login berhasil dengan status code 200
    And response success bernilai true
    When user melakukan logout melalui API
    Then logout berhasil dengan status code 200

  @api @allure.label.epic:API_Automation @allure.label.feature:Authentication
  Scenario: Login menggunakan password yang salah
    Given user baru melakukan register
    When user melakukan register melalui API
    Then register berhasil dengan status code 201
    When user login menggunakan password yang salah
    Then login gagal dengan status code 401
    And response success bernilai false