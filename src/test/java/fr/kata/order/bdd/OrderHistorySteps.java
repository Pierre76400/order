package fr.kata.order.bdd;

import fr.kata.order.application.dto.OrderDto;
import fr.kata.order.application.service.OrderService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OrderHistorySteps {

    private Long customerId;
    private Date dateOrder;

    private List<OrderDto> orderHistory;

    @Autowired
    private OrderService orderService;

    @Given("customer with id {long} and date {string}")
    public void customerWithIdAndDate(Long id, String dateStr) throws ParseException {
        this.customerId = id;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        this.dateOrder = dateFormat.parse(dateStr);


        System.out.println("Client ID: " + id + ", Date: " + dateOrder);
    }

    @When("the customer requests their order history")
    public void theCustomerRequestsTheirOrderHistory() {
        orderHistory= orderService.getOrderHistory(customerId, dateOrder);
    }

    @Then("the customer should see a list of their orders")
    public void theCustomerShouldSeeAListOfTheirOrders() {
        assertTrue(orderHistory.size() > 0);
    }
}
