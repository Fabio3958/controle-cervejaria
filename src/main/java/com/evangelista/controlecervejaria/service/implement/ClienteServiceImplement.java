package com.evangelista.controlecervejaria.service.implement;

import com.evangelista.controlecervejaria.model.Cliente;
import com.evangelista.controlecervejaria.repository.ClienteRepository;
import com.evangelista.controlecervejaria.service.ClienteService;
import com.evangelista.controlecervejaria.service.ViaCep.Endereco;
import com.evangelista.controlecervejaria.service.ViaCep.ViaCepService;
import com.evangelista.controlecervejaria.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImplement implements ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ViaCepService viaCepService;

    @Override
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        Optional<Cliente> client = clienteRepository.findById(id);
        return client.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
    }

    @Override
    public void save(Cliente cliente) {
        Endereco endereco = viaCepService.getEndereco(cliente.getCep());
        cliente.setCidadeCliente(endereco.getLocalidade());
        cliente.setBairroCliente(endereco.getBairro());
        cliente.setLogradouroCliente(endereco.getLogradouro());
        cliente.setComplementoCliente((endereco.getComplemento()));
        clienteRepository.save(cliente);
    }

    @Override
    public void update(Long id, Cliente cliente) {
        Optional<Cliente> existentClient = clienteRepository.findById(id);
        if (existentClient.isPresent())
            clienteRepository.save(cliente);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
