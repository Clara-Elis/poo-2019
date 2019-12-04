package controller;

import entity.Cliente;
import model.ClienteModel;

import java.util.List;

public class ClienteController {

    private ClienteModel model;

    public ClienteController() {
        this.model = new ClienteModel();
    }

    public Cliente cadastrar(Cliente cliente){
        return this.model.cadastrar(cliente);
    }

    public boolean altualizar(Cliente cliente){
        return this.model.altualizar(cliente);
    }

    public boolean excluir(Cliente cliente){
        return this.model.excluir(cliente);
    }

    public List<Cliente> listar(){
        return this.model.listar();
    }

    public Cliente buscarPeloNome(String nome){
        return this.model.buscarPeloNome(nome);
    }
}