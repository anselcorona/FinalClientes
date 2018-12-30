package com.practicafinal.clientes.servicios;

import com.practicafinal.clientes.entidades.Cliente;
import com.practicafinal.clientes.repositorios.ClientePaginacionRepository;
import com.practicafinal.clientes.repositorios.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClientePaginacionRepository clientePaginacionRepository;

    public void crearCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodos(){
        return clienteRepository.findAll();
    }

    public void borrarCliente(Cliente cliente){
        clienteRepository.delete(cliente);
    }

    public Cliente buscarporId(Long id){
        Optional<Cliente> cliente = clienteRepository.findById(id);

        return cliente.orElse(null);
    }

    public List<Cliente> buscarClientePorNombre(String nombre){
        return clienteRepository.findAllByNombre(nombre);
    }

    public List<Cliente> paginacionDeClientes(Pageable pageable)
    {
        return clientePaginacionRepository.findAll(pageable).getContent();
    }

    public long contarClientes(){
        return clienteRepository.count();
    }




}
