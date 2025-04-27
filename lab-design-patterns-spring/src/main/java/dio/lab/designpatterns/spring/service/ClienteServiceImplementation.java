package dio.lab.designpatterns.spring.service;

import dio.lab.designpatterns.spring.model.Cliente;
import dio.lab.designpatterns.spring.model.Endereco;
import dio.lab.designpatterns.spring.model.RepositorioCliente;
import dio.lab.designpatterns.spring.model.RepositorioEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImplementation implements ClienteService{

    @Autowired
    private RepositorioCliente repositorioCliente;
    @Autowired
    private RepositorioEndereco repositorioEndereco;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return repositorioCliente.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional <Cliente> cliente = repositorioCliente.findById(id);
        return (Cliente) cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        salvarClienteComCep(cliente);
    }

    private void salvarClienteComCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = (Endereco) repositorioEndereco.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            repositorioEndereco.save(novoEndereco);
            return novoEndereco;
    });
        cliente.setEndereco(endereco);
        repositorioCliente.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

        Optional <Cliente> clienteBD = repositorioCliente.findById(id);
        if(clienteBD.isPresent()){
            salvarClienteComCep(cliente);
        }

    }

    @Override
    public void deletar(Long id) {

        repositorioCliente.deleteById(id);

    }
}
