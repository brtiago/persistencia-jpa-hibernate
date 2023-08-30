package br.com.tiago.modelo;

import jakarta.persistence.Entity;

@Entity
public class Informatica extends Produto{
    private String marca;
    private Integer modelo;

    public Informatica() {
    }

    public Informatica(String autor, Integer numeroDePaginas) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getModelo() {
        return modelo;
    }

    public void setModelo(Integer modelo) {
        this.modelo = modelo;
    }
}
