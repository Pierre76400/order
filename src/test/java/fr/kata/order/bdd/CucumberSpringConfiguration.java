package fr.kata.order.bdd;

import fr.kata.order.OrderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = OrderApplication.class)
public class CucumberSpringConfiguration {
}
