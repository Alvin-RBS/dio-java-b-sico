package dio.lab.designpatterns.spring.service;

import dio.lab.designpatterns.spring.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Iterable <Cliente> buscarTodos();
    Cliente buscarPorId (Long id);
    void inserir (Cliente cliente);
    void atualizar(Long id, Cliente cliente);
    void deletar (Long id);
}
