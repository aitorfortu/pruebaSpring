package org.afortuna.simexamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.afortuna.simexamen.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
