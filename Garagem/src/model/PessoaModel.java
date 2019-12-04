package model;

import entity.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaModel {

    private List<Pessoa> bdCliente;


    public PessoaModel() {
        this.bdCliente = new ArrayList<Pessoa>();
    }

    public Pessoa cadastrar(Pessoa pessoa){
        return null;
    }

    public boolean altualizar(Pessoa pessoa){
        return false;
    }

    public boolean excluir(Pessoa pessoa){
        return false;
    }

    public List<Pessoa> listar(){
        return null;
    }

    public Pessoa buscarPeloId(int id){
        return null;
    }

    public Pessoa buscarPeloNome(String nome){
        return null;
    }
}