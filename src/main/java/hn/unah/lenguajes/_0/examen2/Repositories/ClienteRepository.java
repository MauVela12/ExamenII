package hn.unah.lenguajes._0.examen2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hn.unah.lenguajes._0.examen2.Entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
    
}
