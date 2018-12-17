package com.practicafinal.clientes.repositorios;

import com.practicafinal.clientes.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByNombre(String nombre);
    List<Cliente> findAllByTelefono(String telefono);

    @Query(value = "select * from Cliente a offset(:offset) limit(:limit)", nativeQuery = true)
    List<Cliente> buscarClientesPorPaginacion(@Param("offset") int offset, @Param("limit") int limit);
}
