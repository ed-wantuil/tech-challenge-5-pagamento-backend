Feature: Tests Api Customer

  Background:
    * url applicationUrl
    Given path '/'

  Scenario: Testando a atualizacao do pagamento
    And path "order/update-payment-status-webhook"
    And request {"id": "2d0c39b6-1dba-4825-a7c7-9e8378950832", "paymentStatus": "PAID"}
    And header Content-Type = 'application/json'
    When method POST
    Then status 200

  Scenario: Testando a busca de um pedido pelo id
    And path "order/find-by-id"
    And param id = "39341acf-e277-4285-9910-52e5f0961248"
    And header Content-Type = 'application/json'
    When method GET
    Then status 200
    And match response.customerId == "846024fa-be87-408c-91e8-e812008eb424"
    And match response.created == "2024-05-01"
    And match response.amount == 10.0
