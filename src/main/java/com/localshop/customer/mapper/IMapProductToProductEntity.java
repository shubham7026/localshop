package com.localshop.customer.mapper;

import com.localshop.customer.enttity.ProductEntity;
import com.localshop.customer.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        implementationName = "MapProductToProductEntity",
        implementationPackage = "com.localshop.customer.mapper"
)
public interface IMapProductToProductEntity {
    ProductEntity map(Product product);
}
