package br.com.tiago.testes;

import br.com.tiago.dao.CategoriaDao;
import br.com.tiago.dao.ProdutoDao;
import br.com.tiago.modelo.Categoria;
import br.com.tiago.modelo.Produto;
import br.com.tiago.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi redmi", "Muito legal", new BigDecimal(800), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
