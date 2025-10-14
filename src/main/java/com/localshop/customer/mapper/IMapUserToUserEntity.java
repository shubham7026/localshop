package com.localshop.customer.mapper;

import com.localshop.customer.enttity.UserEntity;
import com.localshop.customer.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.WARN,
        implementationName = "MapUserToUserEntity",
        implementationPackage = "com.localshop.customer.mapper"
)
public interface IMapUserToUserEntity {
    UserEntity map(User user);
}
