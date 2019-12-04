package controller;

import entity.Badeco;
import model.BadecoModel;

import java.util.List;

public class BadecoController {

    private BadecoModel model;

    public BadecoController() {
        this.model = new BadecoModel();
    }

    public Badeco cadastrar(Badeco badeco){
        return this.model.cadastrar(badeco);
    }

    public boolean altualizar(Badeco badeco){
        return this.model.altualizar(badeco);
    }

    public boolean excluir(Badeco badeco){
        return this.model.excluir(badeco);
    }

    public List<Badeco> listar(){
        return this.model.listar();
    }

    public Badeco buscarPeloNome(String nome){
        return this.model.buscarPeloNome(nome);
    }
}