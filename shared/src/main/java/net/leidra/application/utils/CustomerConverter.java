package net.leidra.application.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import net.leidra.application.dtos.CustomerDto;
import net.leidra.application.entities.Customer;

@Service
public class CustomerConverter {
	
	public Customer toEntity(CustomerDto dto) {
		Customer entity = new Customer();
		BeanUtils.copyProperties(dto,  entity);
		return entity;
	}

	public CustomerDto toDto(Customer entity) {
		CustomerDto dto = new CustomerDto();
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}
}
