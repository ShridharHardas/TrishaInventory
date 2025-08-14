package io.stock.inventory.purchase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.stock.inventory.purchase.model.PurchasingDept;

@Repository
public interface PurchaseRepo extends JpaRepository<PurchasingDept, Long>{

}
