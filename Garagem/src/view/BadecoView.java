package view;


import controller.BadecoController;
import entity.Badeco;
import entity.Funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BadecoView {

    private BadecoController controller;

    public BadecoView(){
        this.controller = new BadecoController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Badeco");

        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Atualizar");
        System.out.println(" 3 - Excluir");
        System.out.println(" 4 - Listar");
        System.out.println(" 5 - Buscar pelo nome");
        System.out.println(" 0 - Voltar");
        int op = sc.nextInt();

        switch (op){

            case 1:
                this.cadastrar();
                break;
            case 2:
                this.altualizar();
                break;
            case 3:
                this.excluir();
                break;
            case 4:
                this.listar();
                break;
            case 5:
                this.buscarPeloNome();
                break;
            case 0:
                FuncionarioView funcionarioView = new FuncionarioView();
                funcionarioView.menu();
                break;
            default:
                System.out.println("Opcao invalida, tente novamente!");
                break;

        }
        this.menu();
    }

    public void cadastrar(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        Badeco badeco = new Badeco();

        System.out.println("> Informe o nome: ");
        badeco.setNome(sc.nextLine());

        System.out.println("> Informe o CPF: ");
        badeco.setCpf(sc.nextLine());

        System.out.println("> Informe o endereco: ");
        badeco.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        badeco.setTelefone(sc.nextLine());

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            badeco.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        badeco.setCodigo(sci.nextInt());

        System.out.println("> Informe o usuario: ");
        badeco.setUsuario(sc.nextLine());

        System.out.println("> Informe a senha: ");
        badeco.setSenha(sc.nextLine());

        System.out.println("> Informe a funcao:");
        badeco.setFuncao(sc.nextLine());

        System.out.println("> Informe o salario: ");
        badeco.setSalario(badeco.calculaSalarioBadeco(sc.nextFloat()));

        if(controller.cadastrar(badeco) != null){
            System.out.println("Badeco cadastrado com sucesso");
        } else {
            System.out.println("ERRO - Não foi possível cadastrar o Badeco");
        }
    }

    public void altualizar(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("#Atualizar Funcionario");

        System.out.println("> Informe o badeco a ser atualizado");
        String nome = sc.nextLine();

        Badeco badeco = this.controller.buscarPeloNome(nome);

        if(badeco != null){
            System.out.println("> Badeco: " + badeco.getCodigo() + " - " + badeco.getNome() + " - " + badeco.getDt_nascimento() +
                    " - " + badeco.getTelefone() + " - " + badeco.getEndereco() + " - " + badeco.getCpf() + " - " + badeco.getSalario()
                    + " - " + badeco.getUsuario() + " - " + badeco.getSenha() + " - " + badeco.getFuncao());

            System.out.println("> Informe o novo nome: ");
            badeco.setNome(sc.nextLine());

            System.out.println("> Informe o novo CPF: ");
            badeco.setCpf(sc.nextLine());

            System.out.println("> Informe o novo endereco: ");
            badeco.setEndereco(sc.nextLine());

            System.out.println("> Informe o novo telefone: ");
            badeco.setTelefone(sc.nextLine());

            try {
                System.out.println("> Informe a nova data de nascimento: ");
                String data = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                badeco.setDt_nascimento(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("> Informe o novo codigo: ");
            badeco.setCodigo(sci.nextInt());

            System.out.println("> Informe o novo usuario: ");
            badeco.setUsuario(sc.nextLine());

            System.out.println("> Informe a nova senha: ");
            badeco.setSenha(sc.nextLine());

            System.out.println("> Informe a nova funcao: ");
            badeco.setFuncao(sc.nextLine());

            if( this.controller.altualizar(badeco) == true){
                System.out.println("> Badeco alterado com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar Badeco!");
            }
        }
    }

    public void excluir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#Excluir Badeco");

        System.out.println("> Informe o nome do badeco a ser excluído: ");
        String nome = sc.nextLine();

        Badeco badeco = this.controller.buscarPeloNome(nome);

        if(badeco != null){
            if( this.controller.excluir(badeco) ){
                System.out.println("> SUCESSO - Badeco excluído!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir o Badeco!");
            }
        } else {
            System.out.println("> ERRO - Badeco não encontrado!");
        }
    }

    public void listar(){
        List<Badeco> listaBadecos = this.controller.listar();

        if(listaBadecos == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Badecos");
            for (int i=0; i<listaBadecos.size(); i++){
                System.out.println("> "+ listaBadecos.get(i).getCodigo() + " - " + listaBadecos.get(i).getNome() + " - " + listaBadecos.get(i).getTelefone()
                        + " - " + listaBadecos.get(i).getEndereco() + " - " + listaBadecos.get(i).getDt_nascimento() + " - " + listaBadecos.get(i).getFuncao());
            }
        }
    }

    public void buscarPeloNome(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Badeco");

        System.out.println("> Informe o nome do badeco: ");
        String nome = sc.nextLine();

        Badeco badeco = this.controller.buscarPeloNome(nome);

        if( badeco != null){
            System.out.println("> Badeco: " + badeco.getCodigo() + " - " + badeco.getNome() + " - " + badeco.getDt_nascimento() +
                    " - " + badeco.getTelefone() + " - " + badeco.getEndereco() + " - " + badeco.getCpf() + " - " + badeco.getSalario()
                    + " - " + badeco.getUsuario() + " - " + badeco.getSenha() + " - " + badeco.getFuncao());
        } else {
            System.out.println("> ERRO - Badeco não encontrado!");
        }
    }
}
