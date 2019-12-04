package model;

import entity.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaModel {

    private List<Venda> bdCliente;


    public VendaModel() {
        this.bdCliente = new ArrayList<Venda>();
    }

    public Venda cadastrar(Venda venda){
        return null;
    }

    public boolean altualizar(Venda venda){
        return false;
    }

    public boolean excluir(Venda venda){
        return false;
    }

    public List<Venda> listar(){
        return null;
    }

    public Venda buscarPeloId(int id){
        return null;
    }

    public Venda buscarPeloNome(String nome){
        return null;
    }
}