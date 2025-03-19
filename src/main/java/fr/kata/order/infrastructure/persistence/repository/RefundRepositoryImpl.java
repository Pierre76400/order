package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.domain.model.Refund;
import fr.kata.order.domain.repository.RefundRepository;
import fr.kata.order.infrastructure.persistence.entity.OrderProductEntity;
import fr.kata.order.infrastructure.persistence.entity.RefundEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class RefundRepositoryImpl implements RefundRepository {

    private final RefundEntityRepository refundEntityRepository;

    private final OrderProductEntityRepository orderProductEntityRepository;

    public RefundRepositoryImpl(RefundEntityRepository refundEntityRepository, OrderProductEntityRepository orderProductEntityRepository) {
        this.refundEntityRepository = refundEntityRepository;
        this.orderProductEntityRepository = orderProductEntityRepository;
    }

    @Override
    public void createRefund(Refund refund) {
        RefundEntity refundEntity = new RefundEntity();

        refundEntity.setNumRefund(refund.getNumRefund());
        refundEntity.setDescription(refund.getDescription());
        refundEntity.setPicture(refund.getPicture());

        Optional<OrderProductEntity> orderProduct = orderProductEntityRepository.findById(refund.getIdOrderProduct());

        if (orderProduct.isEmpty()) {
            throw new IllegalArgumentException("Order not found");
        }
        OrderProductEntity orderProductEntity = orderProduct.get();
        refundEntity.setOrderProductEntity(orderProductEntity);

        refundEntityRepository.save(refundEntity);
    }

}
