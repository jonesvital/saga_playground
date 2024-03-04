package org.example.provider;

import org.example.entity.Cliente;
import org.example.utils.HibernateUtils;
import org.hibernate.Session;

public class ClienteProvider {

    public void salvarCliente(Cliente cliente){

        Session session = HibernateUtils.getSession();

        if(!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }

        session.persist(cliente);
        session.getTransaction().commit();
    }

    public void atualizarCliente(Cliente cliente){

        Session session = HibernateUtils.getSession();

        if(!session.getTransaction().isActive()) {
            session.getTransaction().begin();
        }

        session.merge(cliente);
        session.getTransaction().commit();
    }

}
