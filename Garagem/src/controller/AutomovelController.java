package controller;

import entity.Automovel;
import model.AutomovelModel;

import java.util.List;

public class AutomovelController {

    private AutomovelModel model;

    public AutomovelController() {
        this.model = new AutomovelModel();
    }

    public Automovel cadastrar(Automovel automovel){
        return this.model.cadastrar(automovel);
    }

    public boolean altualizar(Automovel automovel){
        return this.model.altualizar(automovel);
    }

    public boolean excluir(Automovel automovel){
        return this.model.excluir(automovel);
    }

    public List<Automovel> listar(){
        return this.model.listar();
    }

    public Automovel buscarPelaPlaca(String placa){
        return this.model.buscarPelaPlaca(placa );
    }

    public boolean verifica(String placa){
        return this.model.verifica(placa);
    }
}