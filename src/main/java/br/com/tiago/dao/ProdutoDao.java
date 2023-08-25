package br.com.tiago.dao;

import br.com.tiago.modelo.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDao {
    private EntityManager em;

    public ProdutoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Produto produto) {
        this.em.persist(produto);
    }
}
