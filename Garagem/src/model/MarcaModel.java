package model;

import entity.Marca;

import java.util.ArrayList;
import java.util.List;

public class MarcaModel {

    private List<Marca> bdMarca;


    public MarcaModel() {
        this.bdMarca = new ArrayList<Marca>();
    }

    public Marca cadastrar(Marca marca){

        int id = this.bdMarca.size() + 1;
        marca.setId(id);

        this.bdMarca.add(marca);

        return marca;

    }

    public boolean altualizar(Marca marca){

        Marca buscaMarca = this.buscarPeloId(marca.getId());

        int index = this.bdMarca.indexOf(buscaMarca);

        if( this.bdMarca.set(index, marca) != null ){
            return true;
        } else {
            return false;
        }

    }

    public boolean excluir(Marca marca){
        return this.bdMarca.remove(marca);
    }

    public List<Marca> listar(){
        if(this.bdMarca.isEmpty()){
            return null;
        }else{
            return this.bdMarca;
        }
    }

    public Marca buscarPeloId(int id){
        for(int i = 0; i< this.bdMarca.size(); i++){
            if(this.bdMarca.get(i).getId() == id){
                return this.bdMarca.get(i);
            }
        }
        return null;
    }

    public Marca buscarPeloNome(String nome){
        for(int i = 0; i< this.bdMarca.size(); i++){
            if(this.bdMarca.get(i).getNome().equals(nome)){
                return this.bdMarca.get(i);
            }
        }
        return null;
    }

}