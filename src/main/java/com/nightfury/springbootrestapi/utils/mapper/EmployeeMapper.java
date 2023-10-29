package com.nightfury.springbootrestapi.utils.mapper;

import com.nightfury.springbootrestapi.dto.EmployeeDTO;
import com.nightfury.springbootrestapi.entity.Employee;
import com.nightfury.springbootrestapi.utils.mapper.config.MapStructConfig;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public abstract class EmployeeMapper {

    public abstract Employee toEntity(EmployeeDTO dto);

    public abstract EmployeeDTO toDTO(Employee entity);
}
