package io.stock.inventory.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.stock.inventory.supplier.entity.Supplier;

@Repository
public interface SupplierRepo extends JpaRepository<Supplier,Long>{

}
