package com.practicafinal.clientes.controladores;

import com.practicafinal.clientes.entidades.Cliente;
import com.practicafinal.clientes.servicios.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    @GetMapping("/clientes")
    public List<Cliente> clientes() {
        return clienteServices.buscarTodos();
    }

    @GetMapping("/clientes/nombre/{nombre}")
    public List<Cliente> clientesPorNombre(@PathVariable String nombre) {
        return clienteServices.buscarClientePorNombre(nombre);
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.POST, consumes = { "application/json" })
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        clienteServices.crearCliente(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/clientes/devolver")
    public ResponseEntity<Cliente> devolverNuevoCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<>(clienteServices.devolverNuevoCliente(cliente), HttpStatus.OK);
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.PUT, consumes = { "application/json" })
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente) {
        clienteServices.crearCliente(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.DELETE, params = { "id" })
    public ResponseEntity<Cliente> borrarCliente(@RequestParam("id") Long id) {
        Cliente cliente = clienteServices.buscarporId(id);
        clienteServices.borrarCliente(cliente);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/clientes/paginacion", method = RequestMethod.GET, params = { "limit", "offset" })
    public List<Cliente> clientesPaginacion(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        Pageable pageable = PageRequest.of(offset, limit);
        return clienteServices.paginacionDeClientes(pageable);
    }

    @GetMapping("/clientes/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {

        return clienteServices.buscarporId(id);
    }

    @GetMapping("/clientes/cantidad")
    public int contarClientes() {

        return (int) clienteServices.contarClientes();
    }

}
