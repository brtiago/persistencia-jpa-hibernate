package br.com.tiago.dao;

import br.com.tiago.modelo.Pedido;
import br.com.tiago.modelo.Produto;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }

}
