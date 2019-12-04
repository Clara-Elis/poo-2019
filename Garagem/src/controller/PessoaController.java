package controller;

import entity.Pessoa;
import model.PessoaModel;

import java.util.List;

public class PessoaController {

    private PessoaModel model;

    public PessoaController() {
        this.model = new PessoaModel();
    }

    public Pessoa cadastrar(Pessoa pessoa){
        return this.model.cadastrar(pessoa);
    }

    public boolean altualizar(Pessoa pessoa){
        return this.model.altualizar(pessoa);
    }

    public boolean excluir(Pessoa pessoa){
        return this.model.excluir(pessoa);
    }

    public List<Pessoa> listar(){
        return this.model.listar();
    }

    public Pessoa buscarPeloNome(String nome){
        return this.model.buscarPeloNome(nome);
    }

}