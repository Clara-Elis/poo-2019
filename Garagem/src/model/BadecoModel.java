package model;

import entity.Badeco;

import java.util.ArrayList;
import java.util.List;

public class BadecoModel {

    private List<Badeco> bdBadeco;


    public BadecoModel() {
        this.bdBadeco = new ArrayList<Badeco>();
    }

    public Badeco cadastrar(Badeco badeco){
        return null;
    }

    public boolean altualizar(Badeco badeco){
        return false;
    }

    public boolean excluir(Badeco badeco){
        return false;
    }

    public List<Badeco> listar(){
        return null;
    }

    public Badeco buscarPeloId(int id){
        return null;
    }

    public Badeco buscarPeloNome(String nome){
        return null;
    }

}