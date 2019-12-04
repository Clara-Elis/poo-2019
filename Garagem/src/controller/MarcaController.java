package controller;

import entity.Marca;
import model.MarcaModel;

import java.util.List;

public class MarcaController {

    private MarcaModel model;

    public MarcaController() {
        this.model = new MarcaModel();
    }

    public Marca cadastrar(Marca marca){
        return this.model.cadastrar(marca);
    }

    public boolean altualizar(Marca marca){
        return this.model.altualizar(marca);
    }

    public boolean excluir(Marca marca){
        return this.model.excluir(marca);
    }

    public List<Marca> listar(){
        return this.model.listar();
    }

    public Marca buscarPeloNome(String nome){
        return this.model.buscarPeloNome(nome);
    }

}