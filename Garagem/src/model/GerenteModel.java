package model;

import entity.Gerente;

import java.util.ArrayList;
import java.util.List;

public class GerenteModel {

    private List<Gerente> bdCliente;


    public GerenteModel() {
        this.bdCliente = new ArrayList<Gerente>();
    }

    public Gerente cadastrar(Gerente gerente){
        return null;
    }

    public boolean altualizar(Gerente gerente){
        return false;
    }

    public boolean excluir(Gerente gerente){
        return false;
    }

    public List<Gerente> listar(){
        return null;
    }

    public Gerente buscarPeloId(int id){
        return null;
    }

    public Gerente buscarPeloNome(String nome){
        return null;
    }
}