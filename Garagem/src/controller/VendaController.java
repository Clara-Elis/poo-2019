package controller;

import entity.Venda;
import model.VendaModel;

import java.util.List;

public class VendaController {

    private VendaModel model;

    public VendaController() {
        this.model = new VendaModel();
    }

    public Venda cadastrar(Venda venda){
        return this.model.cadastrar(venda);
    }

    public boolean altualizar(Venda venda){
        return this.model.altualizar(venda);
    }

    public boolean excluir(Venda venda){
        return this.model.excluir(venda);
    }

    public List<Venda> listar(){
        return this.model.listar();
    }

    public Venda buscarPeloCod(int cod){
        return this.model.buscarPeloCod(cod);
    }

}