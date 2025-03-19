Feature: Order History and Refund Requests

  As a customer
  I want to view my order history
  So that I can request refunds for specific products

  Scenario: Customer views order history
    Given customer with id 1000 and date "06/06/2024"
    When the customer requests their order history
    Then the customer should see a list of their orders

  Scenario: Customer submits a refund request
    Given customer with id 1000 has an order with num 1001 containing a product with num 1001
    When the customer submits a refund request for the product
      | orderNum  | 1000    |
      | productNum| 1000    |
      | description   | Produit cassé |
      | picture | preuve.jpg |
    Then a refund request should be created
    And the refund request should contain the evidence provided