package org.example.repository;

import jakarta.persistence.Query;
import org.example.dto.ClienteDTO;
import org.example.entity.Cliente;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;

public class ClienteRepository {

    public void deletarCliente(ClienteDTO cliente){
        Session session = HibernateUtils.getSession();

        try {
            String hql = "from Cliente where (nome = :nome) and (email = :email) and (telefone = :telefone)";


            session.getTransaction().begin();

            Query query = session.createQuery(hql);
            query.setParameter("nome", cliente.getNome());
            query.setParameter("email", cliente.getEmail());
            query.setParameter("telefone", cliente.getTelefone());

            Cliente result = (Cliente) query.getSingleResult();

            session.delete(result);
            session.getTransaction().commit();
        }catch (Exception e){
            HibernateUtils.closeSession();
        }

    }


}
