package model;

import entity.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioModel {

    private List<Funcionario> bdFuncionario;


    public FuncionarioModel() {
        this.bdFuncionario = new ArrayList<Funcionario>();
    }

    public Funcionario cadastrar(Funcionario funcionario){
        this.bdFuncionario.add(funcionario);

        return funcionario;
    }

    public boolean altualizar(Funcionario funcionario) {
        Funcionario buscaFuncionario = this.buscarPeloId(funcionario.getCodigo());

        int index = this.bdFuncionario.indexOf(buscaFuncionario);

        if( this.bdFuncionario.set(index, funcionario) != null ){
            return true;
        } else {
            return false;
        }
    }

    public boolean excluir(Funcionario funcionario){
        return this.bdFuncionario.remove(funcionario);
    }

    public List<Funcionario> listar(){
        return this.bdFuncionario;
    }

    public Funcionario buscarPeloId(int id){
        for(int i = 0; i< this.bdFuncionario.size(); i++){
            if(this.bdFuncionario.get(i).getCodigo() == id){
                return this.bdFuncionario.get(i);
            }
        }
        return null;
    }

    public Funcionario buscarPeloNome(String nome){
        for(int i = 0; i< this.bdFuncionario.size(); i++){
            if(this.bdFuncionario.get(i).getNome().equals(nome)){
                return this.bdFuncionario.get(i);
            }
        }
        return null;
    }

    public boolean verifica(String cpf){
        for(int i = 0; i< this.bdFuncionario.size(); i++){
            if ((this.bdFuncionario.get(i).getCpf().equals(cpf))){
                return true;
            }
        }
        return false;
    }

}