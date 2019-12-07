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

        this.bdCliente.add(cliente);
        return cliente;
    }

    public boolean altualizar(Cliente cliente) {
        Cliente buscaCliente = this.buscarPeloId(cliente.getCodigo());

        int index = this.bdCliente.indexOf(buscaCliente);

        if( this.bdCliente.set(index, cliente) != null ){
            return true;
        } else {
            return false;
        }
    }

    public boolean excluir(Cliente cliente){
        return this.bdCliente.remove(cliente);
    }

    public List<Cliente> listar(){
        return this.bdCliente;
    }

    public Cliente buscarPeloId(int id){
        for(int i = 0; i< this.bdCliente.size(); i++){
            if(this.bdCliente.get(i).getCodigo() == id){
                return this.bdCliente.get(i);
            }
        }
        return null;
    }

    public Cliente buscarPeloNome(String nome){
        for(int i = 0; i< this.bdCliente.size(); i++){
            if(this.bdCliente.get(i).getNome().equals(nome)){
                return this.bdCliente.get(i);
            }
        }
        return null;
    }

    public boolean verifica(String cpf){
        for(int i = 0; i< this.bdCliente.size(); i++){
            if ((this.bdCliente.get(i).getCpf().equals(cpf))){
                return true;
            }
        }
        return false;
    }
}