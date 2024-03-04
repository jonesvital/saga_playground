package org.example.saga;

import jakarta.persistence.EntityManagerFactory;
import org.example.entity.Cliente;
import org.example.provider.ClienteProvider;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;

import java.util.List;

public class SagaExecutor {

    private final ClienteProvider clienteProvider;

    public SagaExecutor(ClienteProvider clienteProvider){
        this.clienteProvider = clienteProvider;
    }
    public void compensate(Cliente cliente){
        Session session = HibernateUtils.getSession();
        EntityManagerFactory emf = session.getEntityManagerFactory();

        AuditReader reader = AuditReaderFactory.get(emf.createEntityManager());

        List<Number> revNumbers = reader.getRevisions(Cliente.class, cliente.getId());
        Cliente prev_client = reader.find(Cliente.class, cliente.getId(), revNumbers.get(revNumbers.size() - 2));

        this.clienteProvider.atualizarCliente(prev_client);

    }

}
