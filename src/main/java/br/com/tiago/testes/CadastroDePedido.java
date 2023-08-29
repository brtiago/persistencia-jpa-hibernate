package br.com.tiago.testes;

import br.com.tiago.dao.CategoriaDao;
import br.com.tiago.dao.ClienteDao;
import br.com.tiago.dao.PedidoDao;
import br.com.tiago.dao.ProdutoDao;
import br.com.tiago.modelo.*;
import br.com.tiago.util.JPAUtil;
import jakarta.persistence.EntityManager;

import java.math.BigDecimal;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        Produto produto = produtoDao.buscarPorId(1l);
        Cliente cliente = clienteDao.buscarPorId(1l);


        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);


    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Produto celular = new Produto("Xiaomi redmi", "Muito legal", new BigDecimal(800), celulares);
        Cliente cliente = new Cliente("Rodrigo", "12345");

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }
}
