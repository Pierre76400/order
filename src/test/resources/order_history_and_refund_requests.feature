Feature: Order History and Refund Requests

  As a customer
  I want to view my order history
  So that I can request refunds for specific products

  Scenario: Customer views order history
    Given customer with id "1" and date "2019-01-01"
    When the customer requests their order history
    Then the customer should see a list of their orders

  Scenario: Customer submits a refund request
    Given customer with id "1" has an order with id "1001" containing a product with id "1001"
    When the customer submits a refund request for the product
      | orderId  | 1001    |
      | productId| 1001    |
      | reason   | Produit cassé |
      | imageUrl | preuve.jpg |
    Then a refund request should be created
    And the refund request should contain the evidence provided