package com.project.mini.repository;

import com.project.mini.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Query("SELECT o from Order o WHERE o.registrationId = ?1")
    Order getOrderByRegistrationId(UUID uuid);

    @Query("select o from Order o WHERE o.customerName %?1%")
    List<Order> getAllOrderByCustomerName(String customerName);
}
