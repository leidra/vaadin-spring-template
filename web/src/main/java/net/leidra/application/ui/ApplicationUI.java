package net.leidra.application.ui;

import java.util.List;

import net.leidra.application.dtos.CustomerDto;
import net.leidra.application.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@SpringUI
@Theme("valo")
public class ApplicationUI extends UI {
	private static final long serialVersionUID = 5447519978234023729L;

	@Autowired
	private CustomerService service;
	
    @Override
    protected void init(VaadinRequest request) {
    	List<CustomerDto> dtos = service.findAll();
        setContent(new Label(dtos.stream().map(CustomerDto::getName).findFirst().orElse("No customer found")));
    }
}
