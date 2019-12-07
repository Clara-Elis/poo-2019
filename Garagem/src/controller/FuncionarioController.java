package controller;

import entity.Funcionario;
import model.FuncionarioModel;

import java.util.List;

public class FuncionarioController {

    private FuncionarioModel model;

    public FuncionarioController() {
        this.model = new FuncionarioModel();
    }

    public Funcionario cadastrar(Funcionario funcionario){
        return this.model.cadastrar(funcionario);
    }

    public boolean altualizar(Funcionario funcionario){
        return this.model.altualizar(funcionario);
    }

    public boolean excluir(Funcionario funcionario){
        return this.model.excluir(funcionario);
    }

    public List<Funcionario> listar(){
        return this.model.listar();
    }

    public Funcionario buscarPeloNome(String nome){
        return this.model.buscarPeloNome(nome);
    }

    public boolean verifica(String cpf){
        return this.model.verifica(cpf);
    }
}