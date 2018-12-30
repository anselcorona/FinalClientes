package com.practicafinal.clientes.repositorios;

import com.practicafinal.clientes.entidades.Cliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * ClientePaginacionRepository
 */
public interface ClientePaginacionRepository extends PagingAndSortingRepository<Cliente, Long>{

    Page<Cliente> findAll(Pageable pageable);

    
}