package br.com.tiago.dao;

import br.com.tiago.modelo.Cliente;
import br.com.tiago.modelo.Pedido;
import br.com.tiago.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }

}
