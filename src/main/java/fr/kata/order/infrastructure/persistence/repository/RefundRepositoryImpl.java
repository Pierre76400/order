package fr.kata.order.infrastructure.persistence.repository;

import fr.kata.order.domain.model.Refund;
import fr.kata.order.domain.repository.RefundRepository;
import fr.kata.order.infrastructure.persistence.entity.OrderProductEntity;
import fr.kata.order.infrastructure.persistence.entity.RefundEntity;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

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

        OrderProductEntity orderProductEntity = orderProductEntityRepository.findById(refund.getIdOrderProduct()).get();
        refundEntity.setOrderProductEntity(orderProductEntity);

        refundEntityRepository.save(refundEntity);
    }

}
