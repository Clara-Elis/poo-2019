package model;

import entity.Modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloModel {

    private List<Modelo> bdCliente;


    public ModeloModel() {
        this.bdCliente = new ArrayList<Modelo>();
    }

    public Modelo cadastrar(Modelo modelo){
        return null;
    }

    public boolean altualizar(Modelo modelo){
        return false;
    }

    public boolean excluir(Modelo modelo){
        return false;
    }

    public List<Modelo> listar(){
        return null;
    }

    public Modelo buscarPeloId(int id){
        return null;
    }

    public Modelo buscarPeloNome(String nome){
        return null;
    }
}