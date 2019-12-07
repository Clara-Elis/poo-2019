package controller;

import entity.Gerente;
import model.GerenteModel;

import java.util.List;

public class GerenteController {

    private GerenteModel model;

    public GerenteController() {
        this.model = new GerenteModel();
    }

    public Gerente cadastrar(Gerente gerente){
        return this.model.cadastrar(gerente);
    }

    public boolean altualizar(Gerente gerente){
        return this.model.altualizar(gerente);
    }

    public boolean excluir(Gerente gerente){
        return this.model.excluir(gerente);
    }

    public List<Gerente> listar(){
        return this.model.listar();
    }

    public Gerente buscarPeloNome(String nome){
        return this.model.buscarPeloNome(nome);
    }

    public boolean verifica(String cpf){
        return this.model.verifica(cpf);
    }
}