package view;

import controller.GerenteController;
import entity.Gerente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class GerenteView {

    private GerenteController controller;

    public GerenteView(){
        this.controller = new GerenteController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Gerente");

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

        Gerente gerente = new Gerente();

        System.out.println("> Informe o nome: ");
        gerente.setNome(sc.nextLine());

        System.out.println("> Informe o CPF: ");
        String cpf = sc.nextLine();

        if(this.controller.verifica(cpf) == true){
            System.out.println("CPF ja cadastrado");
            this.menu();
        }else{
            gerente.setCpf(cpf);
        }

        System.out.println("> Informe o endereco: ");
        gerente.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        gerente.setTelefone(sc.nextLine());

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            gerente.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        gerente.setCodigo(sci.nextInt());

        System.out.println("> Informe o usuario: ");
        gerente.setUsuario(sc.nextLine());

        System.out.println("> Informe a senha: ");
        gerente.setSenha(sc.nextLine());

        System.out.println("> Informe a matricula:");
        gerente.setMatricula(sc.nextLine());

        System.out.println("> Informe o departamento:");
        gerente.setDepartamento(sc.nextLine());

        System.out.println("> Informe o salario: ");
        gerente.setSalario(gerente.calculaSalarioGerente(sc.nextFloat()));

        if(controller.cadastrar(gerente) != null){
            System.out.println("Gerente cadastrado com sucesso");
        } else {
            System.out.println("ERRO - Não foi possível cadastrar o Gerente");
        }
    }

    public void altualizar(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("#Atualizar Gerente");

        System.out.println("> Informe o gerente a ser atualizado: ");
        String nome = sc.nextLine();

        Gerente gerente = this.controller.buscarPeloNome(nome);

        if(gerente != null){
            System.out.println("> Badeco: " + gerente.getCodigo() + " - " + gerente.getNome() + " - " + gerente.getDt_nascimento() +
                    " - " + gerente.getTelefone() + " - " + gerente.getEndereco() + " - " + gerente.getCpf() + " - " + gerente.getSalario()
                    + " - " + gerente.getUsuario() + " - " + gerente.getSenha() + " - " + gerente.getDepartamento());

            System.out.println("> Informe o novo nome: ");
            gerente.setNome(sc.nextLine());

            System.out.println("> Informe o novo CPF: ");
            gerente.setCpf(sc.nextLine());

            System.out.println("> Informe o novo endereco: ");
            gerente.setEndereco(sc.nextLine());

            System.out.println("> Informe o novo telefone: ");
            gerente.setTelefone(sc.nextLine());

            try {
                System.out.println("> Informe a nova data de nascimento: ");
                String data = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                gerente.setDt_nascimento(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("> Informe o novo codigo: ");
            gerente.setCodigo(sci.nextInt());

            System.out.println("> Informe o novo usuario: ");
            gerente.setUsuario(sc.nextLine());

            System.out.println("> Informe a nova senha: ");
            gerente.setSenha(sc.nextLine());

            System.out.println("> Informe o novo departamento:");
            gerente.setDepartamento(sc.nextLine());

            if( this.controller.altualizar(gerente) == true){
                System.out.println("> Gerente alterado com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar Gerente!");
            }
        }
    }

    public void excluir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#Excluir Gerente");

        System.out.println("> Informe o nome do gerente a ser excluído: ");
        String nome = sc.nextLine();

        Gerente gerente = this.controller.buscarPeloNome(nome);

        if(gerente != null){
            if( this.controller.excluir(gerente) ){
                System.out.println("> SUCESSO - Gerente excluído!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir o Gerente!");
            }
        } else {
            System.out.println("> ERRO - Gerente não encontrado!");
        }
    }

    public void listar(){
        List<Gerente> listaGerentes = this.controller.listar();

        if(listaGerentes == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Gerentes");
            for (int i=0; i<listaGerentes.size(); i++){
                System.out.println("> "+ listaGerentes.get(i).getCodigo() + " - " + listaGerentes.get(i).getNome() + " - " + listaGerentes.get(i).getTelefone()
                        + " - " + listaGerentes.get(i).getEndereco() + " - " + listaGerentes.get(i).getDt_nascimento() + " - " + listaGerentes.get(i).getDepartamento());
            }
        }
    }

    public void buscarPeloNome(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Gerente");

        System.out.println("> Informe o nome do gerente: ");
        String nome = sc.nextLine();

        Gerente gerente = this.controller.buscarPeloNome(nome);

        if( gerente != null){
            System.out.println("> Gerente: " + gerente.getCodigo() + " - " + gerente.getNome() + " - " + gerente.getDt_nascimento() +
                    " - " + gerente.getTelefone() + " - " + gerente.getEndereco() + " - " + gerente.getCpf() + " - " + gerente.getSalario()
                    + " - " + gerente.getUsuario() + " - " + gerente.getSenha() + " - " + gerente.getMatricula() + " - " + gerente.getDepartamento());
        } else {
            System.out.println("> ERRO - Gerente não encontrado!");
        }
    }
}
