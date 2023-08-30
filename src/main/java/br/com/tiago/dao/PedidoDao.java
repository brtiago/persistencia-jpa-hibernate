package br.com.tiago.dao;

import br.com.tiago.modelo.Pedido;
import br.com.tiago.modelo.Produto;
import br.com.tiago.vo.RelatorioDeVendasVo;
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

    public BigDecimal valorTotalVendido() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p";
        return em.createQuery(jpql, BigDecimal.class)
                .getSingleResult();
    }

    public List<Pedido> buscarTodos() {
        String jpql = "SELECT p FROM Pedido p";
        return em.createQuery(jpql, Pedido.class).getResultList();
    }

    public List<RelatorioDeVendasVo> relatorioDeVendasVo() {
        String jpql = "SELECT new br.com.tiago.vo.RelatorioDeVendasVo("
                + "produto.nome, "
                + "SUM(item.quantidade) as quantidadeTotal, "
                + "MAX(pedido.data)) "
                + "FROM Pedido pedido "
                + "JOIN pedido.itens item "
                + "JOIN item.produto produto "
                + "GROUP BY produto.nome "
                + "ORDER BY quantidadeTotal DESC";

        return em.createQuery(jpql, RelatorioDeVendasVo.class).getResultList();
    }



}
