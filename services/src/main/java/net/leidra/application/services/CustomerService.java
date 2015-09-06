package net.leidra.application.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import net.leidra.application.dtos.CustomerDto;
import net.leidra.application.entities.Customer;
import net.leidra.application.repositories.CustomerRepository;
import net.leidra.application.utils.CustomerConverter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * Created by afuentes on 2/09/15.
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerConverter converter;

    public Optional<CustomerDto> findById(Long id) {
        Assert.notNull(id);
        CustomerDto dto = null;
        Optional<Customer> customer = Optional.ofNullable(repository.findOne(id));
        customer.ifPresent(c -> BeanUtils.copyProperties(c, dto));

        return Optional.ofNullable(dto);
    }
    
    public List<CustomerDto> findAll() {
        List<Customer> cs = repository.findAll();
        List<CustomerDto> dtos = new ArrayList<>();
        cs.parallelStream().forEach(c -> {
        	CustomerDto dto = new CustomerDto();
        	BeanUtils.copyProperties(c, dto);
        	dtos.add(dto);
        });

        return dtos;
    }
    
    public Optional<CustomerDto> save(CustomerDto dto) {
    	Customer c = repository.save(converter.toEntity(dto));
    	return Optional.of(converter.toDto(c));
    }
}