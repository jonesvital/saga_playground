package org.example.saga;

import org.example.dto.ClienteDTO;
import org.example.repository.ClienteRepository;

public class SagaExecutor {

    private ClienteRepository clienteRepository;

    public SagaExecutor(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }


    public void compensate(ClienteDTO cliente){
        this.clienteRepository.deletarCliente(cliente);
    }

}
