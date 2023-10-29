package com.nightfury.springbootrestapi.utils.mapper.config;

import org.mapstruct.*;

@MapperConfig(componentModel = MappingConstants.ComponentModel.SPRING,
        collectionMappingStrategy = CollectionMappingStrategy.TARGET_IMMUTABLE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MapStructConfig {
}
