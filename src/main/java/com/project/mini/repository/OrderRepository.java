package com.project.mini.repository;

import com.project.mini.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("SELECT o from Order o WHERE o.registrationId like ?1")
    Order getOrderByRegistrationId(String uuid);

    @Query("select o from Order o WHERE o.customerName like %?1%")
    List<Order> getAllOrderByCustomerName(String customerName);
}
