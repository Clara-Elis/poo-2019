package model;

import entity.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendaModel {

    private List<Venda> bdVenda;


    public VendaModel() {
        this.bdVenda = new ArrayList<Venda>();
    }

    public Venda cadastrar(Venda venda){

        int id = this.bdVenda.size() + 1;
        venda.setCod_venda(id);

        this.bdVenda.add(venda);

        return venda;
    }

    public boolean altualizar(Venda venda){

        Venda buscaVenda = this.buscarPeloId(venda.getCod_venda());

        int index = this.bdVenda.indexOf(buscaVenda);

        if( this.bdVenda.set(index, venda) != null ){
            return true;
        } else {
            return false;
        }

    }

    public boolean excluir(Venda venda){
        return this.bdVenda.remove(venda);
    }

    public List<Venda> listar(){
        return this.bdVenda;
    }

    public Venda buscarPeloId(int id){
        for(int i = 0; i< this.bdVenda.size(); i++){
            if(this.bdVenda.get(i).getCod_venda() == id){
                return this.bdVenda.get(i);
            }
        }
        return null;
    }

    public Venda buscarPeloCod(int cod){
        for(int i = 0; i< this.bdVenda.size(); i++){
            if(this.bdVenda.get(i).getCod_venda() == cod){
                return this.bdVenda.get(i);
            }
        }
        return null;
    }

}