package net.leidra.application.repositories;

import net.leidra.application.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by afuentes on 2/09/15.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
