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

        automovel.setId(this.bdAutomovel.size() + 1);

        this.bdAutomovel.add(automovel);
        return automovel;
    }

    public boolean altualizar(Automovel automovel) {
        Automovel buscaAutomovel = this.buscarPeloId(automovel.getId());

        int index = this.bdAutomovel.indexOf(buscaAutomovel);

        if( this.bdAutomovel.set(index, automovel) != null ){
            return true;
        } else {
            return false;
        }
    }

    public boolean excluir(Automovel automovel){
        return this.bdAutomovel.remove(automovel);
    }

    public List<Automovel> listar(){
        return this.bdAutomovel;
    }

    public Automovel buscarPeloId(int id){
        for(int i = 0; i< this.bdAutomovel.size(); i++){
            if(this.bdAutomovel.get(i).getId() == id){
                return this.bdAutomovel.get(i);
            }
        }
        return null;
    }

    public Automovel buscarPelaPlaca(String placa){
        for(int i = 0; i< this.bdAutomovel.size(); i++){
            if(this.bdAutomovel.get(i).getPlaca().equals(placa)){
                return this.bdAutomovel.get(i);
            }
        }
        return null;
    }

    public boolean verifica(String placa){
        for(int i = 0; i< this.bdAutomovel.size(); i++){
            if ((this.bdAutomovel.get(i).getPlaca().equals(placa))){
                return true;
            }
        }
        return false;
    }
}