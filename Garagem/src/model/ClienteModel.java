package model;

import entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteModel {

    private List<Cliente> bdCliente;


    public ClienteModel() {
        this.bdCliente = new ArrayList<Cliente>();
    }

    public Cliente cadastrar(Cliente cliente){
        return null;
    }

    public boolean altualizar(Cliente cliente){
        return false;
    }

    public boolean excluir(Cliente cliente){
        return false;
    }

    public List<Cliente> listar(){
        return null;
    }

    public Cliente buscarPeloId(int id){
        return null;
    }

    public Cliente buscarPeloNome(String nome){
        return null;
    }

}