package br.com.tiago.testes;

import br.com.tiago.dao.CategoriaDao;
import br.com.tiago.dao.ProdutoDao;
import br.com.tiago.modelo.Categoria;
import br.com.tiago.modelo.Produto;
import br.com.tiago.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;
import java.util.List;

public class CadastroDeProduto {
    public static void main(String[] args) {
        cadastrarProduto();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        //Produto p = produtoDao.buscarPorId(1l);
        //System.out.println(p.getPreco());

        //List<Produto> todos = produtoDao.buscarTodos();
        //todos.forEach(p2 -> System.out.println(p2.getNome()));

        //List<Produto> todos = produtoDao.buscarPorNome("Xiaomi redmi");
        //todos.forEach(p2 -> System.out.println(p2.getNome()));

        //List<Produto> todos = produtoDao.buscarPorNomeDaCategoria("CELULARES");
        //todos.forEach(p2 -> System.out.println(p2.getNome()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("Xiaomi redmi");
        System.out.println("Preco do Produto: " + precoDoProduto);


    }

    private static void cadastrarProduto() {
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
