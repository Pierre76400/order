package fr.kata.order.application.service;

import fr.kata.order.application.dto.OrderDto;
import fr.kata.order.domain.model.Order;
import fr.kata.order.domain.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class OrderService {

    public static final int NB_YEARS_HISTORY_AUTHORIZE = 1;
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public List<OrderDto> getOrderHistory(Long customerId, LocalDate date){
        if(date.isBefore(LocalDate.now().minusYears(NB_YEARS_HISTORY_AUTHORIZE))){
            throw new IllegalArgumentException("Date should not be more than one year");
        }

        return orderRepository.getOrdersByCustomerIdAndDate(customerId, date).stream()
                .map(order -> mapToDto(order))
                .toList();
    }

    private static OrderDto mapToDto(Order order) {
        OrderDto orderDto = new OrderDto();

        orderDto.setId(order.getNumOrder());
        orderDto.setFirstName(order.getCustomer().getFirstName());
        orderDto.setLastName(order.getCustomer().getLastName());
        orderDto.setOrderDate(order.getDateOrder().toString());
        orderDto.setOrderAmount(order.getTotalPrice());

        return orderDto;
    }
}
