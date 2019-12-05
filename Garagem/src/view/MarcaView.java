package view;

import principal.Principal;
import controller.MarcaController;
import entity.Marca;

import java.util.List;
import java.util.Scanner;

public class MarcaView {

    private MarcaController controller;

    public MarcaView() {
        this.controller = new MarcaController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Marca");

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

        System.out.println("#Cadastrar Marca");

        System.out.println("> Informe a marca");
        String nome = sc.nextLine();

        Marca marca = new Marca();
        marca.setNome(nome);

        Marca marcaCadastrada;
        marcaCadastrada = this.controller.cadastrar(marca);

        if(marcaCadastrada != null){
            System.out.println(" Marca cadastrada: ID "+ marcaCadastrada.getId());
        } else {
            System.out.println(" Erro ao cadastrar marca!");
        }
    }

    public void altualizar(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Atualizar marca");

        System.out.println("> Informe a marca a ser atualizada");
        String nome = sc.nextLine();

        Marca marca = this.controller.buscarPeloNome(nome);

        if( marca != null){

            System.out.println("> Marca: "+ marca.getId() + " - " +marca.getNome() );

            System.out.println("> Informe o nome atual: ");
            String nomeAtual = sc.nextLine();

            marca.setNome(nomeAtual);

            if( this.controller.altualizar(marca) == true){
                System.out.println("> Marca alterada com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar marca!");
            }

        } else {
            System.out.println("> Marca informada não existe!");
        }

    }

    public void excluir(){

        Scanner sc = new Scanner(System.in);
        System.out.println("#Atualizar marca");

        System.out.println("> Informe a marca a ser excluída");
        String nome = sc.nextLine();

        Marca marca = this.controller.buscarPeloNome(nome);

        if(marca != null){

            if( this.controller.excluir(marca) ){
                System.out.println("> SUCESSO - Marca excluída!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir a marca!");
            }


        } else {
            System.out.println("> ERRO - Marca não encontrada!");
        }

    }

    public void listar(){
        List<Marca> listaMarcas;
        listaMarcas = this.controller.listar();

        if(listaMarcas == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Marcas");
            for (int i=0; i<listaMarcas.size(); i++){
                System.out.println("> "+ listaMarcas.get(i).getId() + " - " +listaMarcas.get(i).getNome() );
            }
        }
    }

    public void buscarPeloNome(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Marca");

        System.out.println("> Informe a marca");
        String nome = sc.nextLine();

        Marca marca = this.controller.buscarPeloNome(nome);

        if( marca != null){
            System.out.println("> Marca: "+ marca.getId() + " - " +marca.getNome() );
        } else {
            System.out.println("> ERRO - Marca não encontrada!");
        }
    }
}