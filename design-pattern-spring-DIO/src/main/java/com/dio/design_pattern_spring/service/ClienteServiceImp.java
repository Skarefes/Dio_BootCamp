package com.dio.design_pattern_spring.service;

import com.dio.design_pattern_spring.model.Cliente;
import com.dio.design_pattern_spring.model.Endereco;
import com.dio.design_pattern_spring.repository.ClienteRepository;
import com.dio.design_pattern_spring.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImp implements ClienteService{
    //Singleton = injeta os componentes do spring com o @Autowired
    //Strategy = Implementar os médtodos definidos na interface
    //Facade = Abstrair integraçoes com subsistemas, provendo uma interface simples

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Cliente cliente) {
        //Verifica se o Enderedo do Cliente ja existe
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(
                ()-> {
                    //Caso nao exista, integrar com o ViaCEP e persistir o retorno
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });
        cliente.setEndereco(endereco);
        //Inserir Cliente, vinculado o Endereco (novo ou existente)
        cliente = clienteRepository.save(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente) {
        //Busca Lciente por Id, caso exista
        Optional<Cliente> clienteBd = clienteRepository.findById(id);
        if (clienteBd.isPresent()){
            salvarClienteComCep(cliente);
        }
    }

    private void salvarClienteComCep(Cliente cliente) {
        //Verifica se o Enderedo do Cliente ja existe
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(
                ()-> {
                    //Caso nao exista, integrar com o ViaCEP e persistir o retorno
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });
        cliente.setEndereco(endereco);
        //Inserir Cliente, vinculado o Endereco (novo ou existente)
        cliente = clienteRepository.save(cliente);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id );
    }
}
