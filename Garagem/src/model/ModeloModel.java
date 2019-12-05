package model;

import entity.Modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloModel {

    private List<Modelo> bdModelo;


    public ModeloModel() {
        this.bdModelo = new ArrayList<Modelo>();
    }

    public Modelo cadastrar(Modelo modelo){
        int id = this.bdModelo.size() + 1;
        modelo.setId(id);

        this.bdModelo.add(modelo);

        return modelo;
    }

    public boolean altualizar(Modelo modelo){
        Modelo buscaModelo = this.buscarPeloId(modelo.getId());

        int index = this.bdModelo.indexOf(buscaModelo);

        if( this.bdModelo.set(index, modelo) != null ){
            return true;
        } else {
            return false;
        }
    }

    public boolean excluir(Modelo modelo){
        return this.bdModelo.remove(modelo);
    }

    public List<Modelo> listar(){
        return this.bdModelo;
    }

    public Modelo buscarPeloId(int id){
        for(int i = 0; i< this.bdModelo.size(); i++){
            if(this.bdModelo.get(i).getId() == id){
                return this.bdModelo.get(i);
            }
        }
        return null;
    }

    public Modelo buscarPeloNome(String nome){
        for(int i = 0; i< this.bdModelo.size(); i++){
            if(this.bdModelo.get(i).getNome().equals(nome)){
                return this.bdModelo.get(i);
            }
        }
        return null;
    }
}