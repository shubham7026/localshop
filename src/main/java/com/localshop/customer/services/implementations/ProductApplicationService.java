package com.localshop.customer.services.implementations;

import com.localshop.customer.enttity.ProductEntity;
import com.localshop.customer.mapper.IMapProductToProductEntity;
import com.localshop.customer.model.Product;
import com.localshop.customer.persistence.interfaces.IProductRepository;
import com.localshop.customer.services.interfaces.IProductApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductApplicationService implements IProductApplicationService {

    @Autowired
    private IProductRepository productRepository;

    @Autowired
    private IMapProductToProductEntity mapProductToProductEntity;

    @Override
    public void addProduct(List<Product> products) {
        List<ProductEntity> entities = products.stream()
                .map(product -> mapProductToProductEntity.map(product))
                        .toList();
        log.debug("saving products: {}", entities);
        productRepository.saveAll(entities);
    }
}
