package com.nightfury.springbootrestapi.service;

import com.nightfury.springbootrestapi.dto.EmployeeDTO;
import com.nightfury.springbootrestapi.entity.Employee;
import com.nightfury.springbootrestapi.exception.type.AppException;
import com.nightfury.springbootrestapi.exception.type.ValidationException;
import com.nightfury.springbootrestapi.repository.EmployeeRepository;
import com.nightfury.springbootrestapi.utils.AppConstants;
import com.nightfury.springbootrestapi.utils.mapper.EmployeeMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeMapper mapper;

    @Autowired
    private EmployeeRepository repository;

    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        try {
            Employee entity = mapper.toEntity(dto);
            return mapper.toDTO(repository.save(entity));
        } catch (ValidationException v) {
            throw v;
        } catch (Exception e) {
            throw new AppException(e.getLocalizedMessage(), AppConstants.DELETE_EMPLOYEE.name());
        }
    }

    public EmployeeDTO getEmployeeById(Long empId) {
        try {
            return repository.findById(empId)
                    .map(mapper::toDTO)
                    .orElseThrow(() -> new ValidationException(
                            "Given employee id :" + empId + " not exist in the DB",
                            "APP_001",
                            AppConstants.DELETE_EMPLOYEE.name()));
        } catch (ValidationException v) {
            throw v;
        } catch (Exception e) {
            throw new AppException(e.getLocalizedMessage(), AppConstants.DELETE_EMPLOYEE.name());
        }
    }

    public List<EmployeeDTO> getEmployeeList() {
        try {
            return repository.findAll()
                    .stream()
                    .map(mapper::toDTO)
                    .collect(Collectors.toList());
        } catch (ValidationException v) {
            throw v;
        } catch (Exception e) {
            throw new AppException(e.getLocalizedMessage(), AppConstants.DELETE_EMPLOYEE.name());
        }
    }

    public EmployeeDTO updateEmployee(Long empId, EmployeeDTO detailsToBeUpdated) {
        try {
            if(repository.existsById(empId)) {
                Employee updatedDetails = mapper.toEntity(detailsToBeUpdated);
                return mapper.toDTO(repository.save(updatedDetails));
            } else {
                throw new ValidationException(
                        "Given employee id :" + empId + " not exist in the DB",
                        "APP_001",
                        AppConstants.DELETE_EMPLOYEE.name());
            }
        } catch (ValidationException v) {
            throw v;
        } catch (Exception e) {
            throw new AppException(e.getLocalizedMessage(), AppConstants.DELETE_EMPLOYEE.name());
        }
    }

    public void deleteEmployee(Long empId) {
        try {
            if(repository.existsById(empId)) {
                repository.deleteById(empId);
            } else {
                throw new ValidationException(
                        "Given employee id :" + empId + " not exist in the DB",
                        "APP_001",
                        AppConstants.DELETE_EMPLOYEE.name());
            }
        } catch (ValidationException v) {
            throw v;
        } catch (Exception e) {
            throw new AppException(e.getLocalizedMessage(), AppConstants.DELETE_EMPLOYEE.name());
        }
    }
}
