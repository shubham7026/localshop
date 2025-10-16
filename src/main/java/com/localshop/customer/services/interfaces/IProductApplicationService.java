package com.localshop.customer.services.interfaces;

import com.localshop.customer.enttity.ProductEntity;
import com.localshop.customer.model.Product;

import java.util.List;

public interface IProductApplicationService {
    void addProduct(List<Product> products);
}
