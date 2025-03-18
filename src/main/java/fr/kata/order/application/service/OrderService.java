package fr.kata.order.application.service;

import fr.kata.order.application.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    public List<OrderDto> getOrderHistory(Long customerId, Date date){
        return null;
    }
}
