package entity;

import interfaces.IFuncionario;

public class Badeco extends Funcionario implements IFuncionario {

    private String funcao;
    private float salario;

    public String getFuncao() {
        return funcao;
    }

    @Override
    public float getSalario() {
        return salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float calculaSalarioBadeco() {
        return salario * 0.8f;
    }

    public float calculaSalarioBadeco(float salario) {
        return salario * 0.8f;
    }
}
