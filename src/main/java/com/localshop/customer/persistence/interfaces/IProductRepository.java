package com.localshop.customer.persistence.interfaces;

import com.localshop.customer.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductEntity, String> {
}
