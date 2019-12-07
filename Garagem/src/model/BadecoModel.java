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

        this.bdBadeco.add(badeco);
        return badeco;
    }

    public boolean altualizar(Badeco badeco) {
        Badeco buscaBadeco = this.buscarPeloId(badeco.getCodigo());

        int index = this.bdBadeco.indexOf(buscaBadeco);

        if( this.bdBadeco.set(index, badeco) != null ){
            return true;
        } else {
            return false;
        }
    }

    public boolean excluir(Badeco badeco){
        return this.bdBadeco.remove(badeco);
    }

    public List<Badeco> listar(){
        return this.bdBadeco;
    }

    public Badeco buscarPeloId(int id){
        for(int i = 0; i< this.bdBadeco.size(); i++){
            if(this.bdBadeco.get(i).getCodigo() == id){
                return this.bdBadeco.get(i);
            }
        }
        return null;
    }

    public Badeco buscarPeloNome(String nome){
        for(int i = 0; i< this.bdBadeco.size(); i++){
            if(this.bdBadeco.get(i).getNome().equals(nome)){
                return this.bdBadeco.get(i);
            }
        }
        return null;
    }

    public boolean verifica(String cpf){
        for(int i = 0; i< this.bdBadeco.size(); i++){
            if ((this.bdBadeco.get(i).getCpf().equals(cpf))){
                return true;
            }
        }
        return false;
    }
}