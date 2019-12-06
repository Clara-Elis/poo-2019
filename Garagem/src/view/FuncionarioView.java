package view;


import entity.Funcionario;
import principal.Principal;
import controller.FuncionarioController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class FuncionarioView {

    private FuncionarioController controller;

    public FuncionarioView (){
        this.controller = new FuncionarioController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Funcionario");

        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Atualizar");
        System.out.println(" 3 - Excluir");
        System.out.println(" 4 - Listar");
        System.out.println(" 5 - Buscar pelo nome");
        System.out.println(" 0 - Voltar");
        int op = sc.nextInt();

        switch (op){

            case 1:
                int tipoFunc = 0;

                System.out.println("#!# Cadastro de Funcionario #!#");
                System.out.println("Qual o tipo de Funcionario ? [1- Gerente, 2- Badeco, 3-Funcionario Comum]");
                tipoFunc = sc.nextInt();

                if(tipoFunc != 1 && tipoFunc != 2 && tipoFunc != 3){
                    System.out.println("O tipo informado e invalido ou nao existe! Tente novamente.");
                    this.menu();
                }else if(tipoFunc == 1){
                    GerenteView gerenteView = new GerenteView();

                    gerenteView.cadastrar();
                    break;
                }else if(tipoFunc == 2){
                    BadecoView badecoView = new BadecoView();

                    badecoView.menu();
                    break;
                }else{
                    this.cadastrar();
                    break;
                }
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
                Principal principal = new Principal();
                principal.menuPrincipal();
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

        System.out.println("To no Funcionario Comum!");

        Funcionario funcionario = new Funcionario();

        System.out.println("> Informe o nome: ");
        funcionario.setNome(sc.nextLine());

        System.out.println("> Informe o CPF: ");
        funcionario.setCpf(sc.nextLine());

        System.out.println("> Informe o endereco: ");
        funcionario.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        funcionario.setTelefone(sc.nextLine());

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            funcionario.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        funcionario.setCodigo(sci.nextInt());

        System.out.println("> Informe o usuario: ");
        funcionario.setUsuario(sc.nextLine());

        System.out.println("> Informe a senha: ");
        funcionario.setSenha(sc.nextLine());

        System.out.println("> Informe o salario: ");
        funcionario.setSalario(funcionario.calculaSalario(sc.nextFloat()));

        if(controller.cadastrar(funcionario) != null){
            System.out.println("Funcionario cadastrado com sucesso");
        } else {
            System.out.println("ERRO - Não foi possível cadastrar o Funcionário");
        }
    }

    public void altualizar(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("#Atualizar Funcionario");

        System.out.println("> Informe o funcionario a ser atualizado");
        String nome = sc.nextLine();

        Funcionario funcionario = this.controller.buscarPeloNome(nome);

        if(funcionario != null){
            System.out.println("> Funcionario: " + funcionario.getCodigo() + funcionario.getNome() + funcionario.getDt_nascimento() + funcionario.getTelefone()
                    + funcionario.getEndereco() + funcionario.getCpf() + funcionario.getSalario() + funcionario.getUsuario() + funcionario.getSenha());

            System.out.println("> Informe o novo nome: ");
            funcionario.setNome(sc.nextLine());

            System.out.println("> Informe o novo CPF: ");
            funcionario.setCpf(sc.nextLine());

            System.out.println("> Informe o novo endereco: ");
            funcionario.setEndereco(sc.nextLine());

            System.out.println("> Informe o novo telefone: ");
            funcionario.setTelefone(sc.nextLine());

            try {
                System.out.println("> Informe a nova data de nascimento: ");
                String data = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                funcionario.setDt_nascimento(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("> Informe o novo codigo: ");
            funcionario.setCodigo(sci.nextInt());

            System.out.println("> Informe o novo usuario: ");
            funcionario.setUsuario(sc.nextLine());

            System.out.println("> Informe a nova senha: ");
            funcionario.setSenha(sc.nextLine());

            if( this.controller.altualizar(funcionario) == true){
                System.out.println("> Funcionario alterado com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar funcionario!");
            }
        }
    }

    public void excluir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#Excluir Funcionario");

        System.out.println("> Informe o nome do funcionario a ser excluída");
        String nome = sc.nextLine();

        Funcionario funcionario = this.controller.buscarPeloNome(nome);

        if(funcionario != null){

            if( this.controller.excluir(funcionario) ){
                System.out.println("> SUCESSO - Funcionario excluído!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir o funcionario!");
            }


        } else {
            System.out.println("> ERRO - Marca não encontrada!");
        }
    }

    public void listar(){
        List<Funcionario> listaFuncionarios = this.controller.listar();

        if(listaFuncionarios == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Funcionarios");
            for (int i=0; i<listaFuncionarios.size(); i++){
                System.out.println("> "+ listaFuncionarios.get(i).getCodigo() + " - " + listaFuncionarios.get(i).getNome() + " - " + listaFuncionarios.get(i).getTelefone()
                + " - " + listaFuncionarios.get(i).getEndereco() + " - " + listaFuncionarios.get(i).getDt_nascimento());
            }
        }
    }

    public void buscarPeloNome(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Funcionario");

        System.out.println("> Informe o nome do funcionario");
        String nome = sc.nextLine();

        Funcionario funcionario = this.controller.buscarPeloNome(nome);

        if( funcionario != null){
            System.out.println("> Funcionario: " + funcionario.getCodigo() + " - " + funcionario.getNome() + " - " + funcionario.getDt_nascimento() +
                    " - " + funcionario.getTelefone() + " - " + funcionario.getEndereco() + " - " + funcionario.getCpf() + " - " + funcionario.getSalario()
                    + " - " + funcionario.getUsuario() + " - " + funcionario.getSenha());
        } else {
            System.out.println("> ERRO - Funcionario não encontrado!");
        }
    }
}
