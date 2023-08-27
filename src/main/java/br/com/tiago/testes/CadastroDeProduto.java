package br.com.tiago.testes;

import br.com.tiago.dao.ProdutoDao;
import br.com.tiago.modelo.Produto;
import br.com.tiago.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal(800));

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao dao = new ProdutoDao(em);

        em.getTransaction().begin();
        dao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }
}
