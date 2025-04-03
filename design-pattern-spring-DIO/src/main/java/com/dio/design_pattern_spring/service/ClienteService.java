package com.dio.design_pattern_spring.service;

import com.dio.design_pattern_spring.model.Cliente;
import org.springframework.stereotype.Service;

// Interfacce que define o padrão Strategy no dominio de cliente.
// Assim podemos ter multiplas implementações dessa mesma interface;

@Service
public interface ClienteService {

    Iterable<Cliente> buscarTodos();

    Cliente buscarPorId(Long id);

    void inserir (Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
