package model;

import entity.Gerente;

import java.util.ArrayList;
import java.util.List;

public class GerenteModel {

    private List<Gerente> bdGerente;


    public GerenteModel() {
        this.bdGerente = new ArrayList<Gerente>();
    }

    public Gerente cadastrar(Gerente gerente){

        this.bdGerente.add(gerente);
        return gerente;
    }

    public boolean altualizar(Gerente gerente) {
        Gerente buscaGerente = this.buscarPeloId(gerente.getCodigo());

        int index = this.bdGerente.indexOf(buscaGerente);

        if( this.bdGerente.set(index, gerente) != null ){
            return true;
        } else {
            return false;
        }
    }

    public boolean excluir(Gerente gerente){
        return this.bdGerente.remove(gerente);
    }

    public List<Gerente> listar(){
        return this.bdGerente;
    }

    public Gerente buscarPeloId(int id){
        for(int i = 0; i< this.bdGerente.size(); i++){
            if(this.bdGerente.get(i).getCodigo() == id){
                return this.bdGerente.get(i);
            }
        }
        return null;
    }

    public Gerente buscarPeloNome(String nome){
        for(int i = 0; i< this.bdGerente.size(); i++){
            if(this.bdGerente.get(i).getNome().equals(nome)){
                return this.bdGerente.get(i);
            }
        }
        return null;
    }

    public boolean verifica(String cpf){
        for(int i = 0; i< this.bdGerente.size(); i++){
            if ((this.bdGerente.get(i).getCpf().equals(cpf))){
                return true;
            }
        }
        return false;
    }

}