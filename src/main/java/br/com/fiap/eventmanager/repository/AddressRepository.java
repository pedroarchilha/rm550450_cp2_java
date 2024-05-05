package br.com.fiap.eventmanager.repository;

import br.com.fiap.eventmanager.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
