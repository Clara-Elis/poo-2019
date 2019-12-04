package model;

import entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioModel {

    private List<Funcionario> bdCliente;


    public FuncionarioModel() {
        this.bdCliente = new ArrayList<Funcionario>();
    }

    public Funcionario cadastrar(Funcionario funcionario){
        return null;
    }

    public boolean altualizar(Funcionario funcionario){
        return false;
    }

    public boolean excluir(Funcionario funcionario){
        return false;
    }

    public List<Funcionario> listar(){
        return null;
    }

    public Funcionario buscarPeloId(int id){
        return null;
    }

    public Funcionario buscarPeloNome(String nome){
        return null;
    }

}