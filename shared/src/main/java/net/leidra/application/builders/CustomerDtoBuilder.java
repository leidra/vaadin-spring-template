package net.leidra.application.builders;

import org.springframework.stereotype.Component;
import net.leidra.application.dtos.CustomerDto;

@Component
public class CustomerDtoBuilder {
	private CustomerDto dto = new CustomerDto();
	
	public CustomerDtoBuilder withId(Long id) {
		dto.setId(id);
		
		return this;
	}
	
	public CustomerDtoBuilder withName(String name) {
		dto.setName(name);
		
		return this;
	}
	
	public CustomerDto build() {
		return dto;
	}
}
