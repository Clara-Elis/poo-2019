package view;

import controller.ClienteController;
import entity.Cliente;
import principal.Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ClienteView {

    private ClienteController controller;

    public ClienteView(){
        this.controller = new ClienteController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Cliente");

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

        Cliente cliente = new Cliente();

        System.out.println("> Informe o nome: ");
        cliente.setNome(sc.nextLine());

        System.out.println("> Informe o CPF: ");
        String cpf = sc.nextLine();

        if(this.controller.verifica(cpf) == true){
            System.out.println("CPF ja cadastrado");
            this.menu();
        }else{
            cliente.setCpf(cpf);
        }

        System.out.println("> Informe o endereco: ");
        cliente.setEndereco(sc.nextLine());

        System.out.println("> Informe o telefone: ");
        cliente.setTelefone(sc.nextLine());

        try {
            System.out.println("> Informe a data de nascimento: ");
            String data = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
            cliente.setDt_nascimento(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o codigo: ");
        cliente.setCodigo(sci.nextInt());

        if(controller.cadastrar(cliente) != null){
            System.out.println("Cliente cadastrado com sucesso");
        } else {
            System.out.println("ERRO - Não foi possível cadastrar o Cliente");
        }
    }

    public void altualizar(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("#Atualizar Cliente");

        System.out.println("> Informe o cliente a ser atualizado: ");
        String nome = sc.nextLine();

        Cliente cliente = this.controller.buscarPeloNome(nome);

        if(cliente != null){
            System.out.println("> Cliente: " + cliente.getCodigo() + " - " + cliente.getNome() + " - " + cliente.getDt_nascimento() +
                    " - " + cliente.getTelefone() + " - " + cliente.getEndereco() + " - " + cliente.getCpf());

            System.out.println("> Informe o novo nome: ");
            cliente.setNome(sc.nextLine());

            System.out.println("> Informe o novo CPF: ");
            String cpf = sc.nextLine();

            if(this.controller.verifica(cpf) == true){
                System.out.println("CPF ja cadastrado");
                this.menu();
            }else{
                cliente.setCpf(cpf);
            }

            System.out.println("> Informe o novo endereco: ");
            cliente.setEndereco(sc.nextLine());

            System.out.println("> Informe o novo telefone: ");
            cliente.setTelefone(sc.nextLine());

            try {
                System.out.println("> Informe a nova data de nascimento: ");
                String data = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                cliente.setDt_nascimento(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("> Informe o novo codigo: ");
            cliente.setCodigo(sci.nextInt());

            if( this.controller.altualizar(cliente) == true){
                System.out.println("> Cliente alterado com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar Cliente!");
            }
        }
    }

    public void excluir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#Excluir Cliente");

        System.out.println("> Informe o nome do cliente a ser excluído: ");
        String nome = sc.nextLine();

        Cliente cliente = this.controller.buscarPeloNome(nome);

        if(cliente != null){
            if( this.controller.excluir(cliente) ){
                System.out.println("> SUCESSO - Cliente excluído!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir o Cliente!");
            }
        } else {
            System.out.println("> ERRO - Cliente não encontrado!");
        }
    }

    public void listar(){
        List<Cliente> listaClientes = this.controller.listar();

        if(listaClientes == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Clientes");
            for (int i=0; i<listaClientes.size(); i++){
                System.out.println("> "+ listaClientes.get(i).getCodigo() + " - " + listaClientes.get(i).getNome() + " - " + listaClientes.get(i).getTelefone()
                        + " - " + listaClientes.get(i).getEndereco() + " - " + listaClientes.get(i).getDt_nascimento());
            }
        }
    }

    public void buscarPeloNome(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Cliente");

        System.out.println("> Informe o nome do cliente: ");
        String nome = sc.nextLine();

        Cliente cliente = this.controller.buscarPeloNome(nome);

        if( cliente != null){
            System.out.println("> Cliente: " + cliente.getCodigo() + " - " + cliente.getNome() + " - " + cliente.getDt_nascimento() +
                    " - " + cliente.getTelefone() + " - " + cliente.getEndereco() + " - " + cliente.getCpf());
        } else {
            System.out.println("> ERRO - Cliente não encontrado!");
        }
    }
}
