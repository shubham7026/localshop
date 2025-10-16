package com.localshop.customer.mapper;

import com.localshop.customer.entity.UserEntity;
import com.localshop.customer.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;


@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        implementationName = "MapUserEntityToUser",
        implementationPackage = "com.localshop.customer.mapper"
)
public interface IMapUserEntityToUser {
    User map (UserEntity userEntity);
}
