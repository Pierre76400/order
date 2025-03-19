package fr.kata.order.bdd;

import fr.kata.order.application.service.RefundService;
import fr.kata.order.infrastructure.persistence.entity.RefundEntity;
import fr.kata.order.infrastructure.persistence.repository.RefundEntityRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class RefundCreateSteps {

    private Long customerId;
    private Long orderNum;
    private Long productNum;

    private String description;
    private String picture;

    @Autowired
    private RefundService refundService;

    @Autowired
    private RefundEntityRepository refundEntityRepository;

    @Given("customer with id {long} has an order with num {long} containing a product with num {long}")
    public void customerHasOrderWithProduct(Long customerId, Long orderId, Long productId) {
        //Les données sont déja initialisées via le script SQL de test data.sql
    }

    @When("the customer submits a refund request for the product")
    public void customerSubmitsRefundRequest(DataTable table) {
        Map<String, String> data = table.asMap(String.class, String.class);

        this.orderNum = Long.parseLong(data.get("orderNum"));
        this.productNum = Long.parseLong(data.get("productNum"));
        this.description = data.get("description");
        this.picture = data.get("picture");

        refundService.createRefund(1l, orderNum, productNum, description, picture);
    }

    @Then("a refund request should be created")
    public void refundRequestShouldBeCreated() {
        List<RefundEntity> refunds= refundEntityRepository.findAll();
        assertEquals(1, refunds.size());
    }

    @Then("the refund request should contain the evidence provided")
    public void refundRequestShouldContainEvidence() {

        List<RefundEntity> refunds= refundEntityRepository.findAll();
        assertEquals(1, refunds.size());

        RefundEntity refundRequest = refunds.get(0);
        assertEquals(description, refundRequest.getDescription(), "Refund description does not match.");
        assertEquals(picture, refundRequest.getPicture(), "Refund picture does not match.");
    }
}
