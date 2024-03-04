package org.example.provider;

import org.example.dto.ClienteDTO;
import org.example.entity.Cliente;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;

public class ClienteProvider {

    public void criarCliente(ClienteDTO clienteDto){

        Cliente cliente = new Cliente();
        cliente.setNome(clienteDto.getNome());
        cliente.setEmail(clienteDto.getEmail());
        cliente.setTelefone(clienteDto.getTelefone());

        Session session = HibernateUtils.getSession();

        session.getTransaction().begin();
        session.persist(cliente);
        session.getTransaction().commit();
    }

}
