package entity;

import java.util.Date;

public class Automovel {
    private int id;
    private String cor;
    private Date ano_fabricacao;
    private Date ano_modelo;
    private String chassi;
    private String placa;
    private float quilometragem;
    private float valor;
    private int modelo_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getAno_fabricacao() {
        return ano_fabricacao;
    }

    public void setAno_fabricacao(Date ano_fabricacao) {
        this.ano_fabricacao = ano_fabricacao;
    }

    public Date getAno_modelo() {
        return ano_modelo;
    }

    public void setAno_modelo(Date ano_modelo) {
        this.ano_modelo = ano_modelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getModelo_id() {
        return modelo_id;
    }

    public void setModelo_id(int modelo_id) {
        this.modelo_id = modelo_id;
    }
}
