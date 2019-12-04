package model;

import entity.Automovel;

import java.util.ArrayList;
import java.util.List;

public class AutomovelModel {

    private List<Automovel> bdAutomovel;


    public AutomovelModel() {
        this.bdAutomovel = new ArrayList<Automovel>();
    }

    public Automovel cadastrar(Automovel automovel){
        return null;
    }

    public boolean altualizar(Automovel automovel){
        return false;
    }

    public boolean excluir(Automovel automovel){
        return false;
    }

    public List<Automovel> listar(){
        return null;
    }

    public Automovel buscarPeloId(int id){
        return null;
    }

    public Automovel buscarPeloNome(String nome){
        return null;
    }

}