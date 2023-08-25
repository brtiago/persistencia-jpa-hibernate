package br.com.tiago.testes;

import br.com.tiago.modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;

public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("Xiaomi redmi");
        celular.setDescricao("Muito legal");
        celular.setPreco(new BigDecimal(800));

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("loja");
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}
