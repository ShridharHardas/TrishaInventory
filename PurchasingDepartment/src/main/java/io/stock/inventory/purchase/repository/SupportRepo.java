package io.stock.inventory.purchase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.stock.inventory.purchase.model.Support;

@Repository
public interface SupportRepo extends JpaRepository<Support, Integer>{

}
