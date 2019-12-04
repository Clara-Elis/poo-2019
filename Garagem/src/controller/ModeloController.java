package controller;

import entity.Modelo;
import model.ModeloModel;

import java.util.List;

public class ModeloController {

    private ModeloModel model;

    public ModeloController() {
        this.model = new ModeloModel();
    }

    public Modelo cadastrar(Modelo modelo){
        return this.model.cadastrar(modelo);
    }

    public boolean altualizar(Modelo modelo){
        return this.model.altualizar(modelo);
    }

    public boolean excluir(Modelo modelo){
        return this.model.excluir(modelo);
    }

    public List<Modelo> listar(){
        return this.model.listar();
    }

    public Modelo buscarPeloNome(String nome){
        return this.model.buscarPeloNome(nome);
    }

}