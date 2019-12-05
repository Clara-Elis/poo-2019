package view;

import entity.Marca;
import model.MarcaModel;
import principal.Principal;
import controller.ModeloController;
import entity.Modelo;

import java.util.List;
import java.util.Scanner;

public class ModeloView {

    private ModeloController controller;

    public ModeloView (){
        this.controller = new ModeloController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Modelo");

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

        System.out.println("#Cadastrar Modelo");

        System.out.println("> Informe o id da marca:");
        int nMarca = sci.nextInt();

        System.out.println("> Informe o modelo:");
        String nome = sc.nextLine();

        System.out.println("> Informe o tipo:");
        String tipo = sc.nextLine();

        Modelo modelo = new Modelo();

        modelo.setNome(nome);
        modelo.setTipo(tipo);
        modelo.setMarca_id(nMarca);

        Modelo modeloCadastrado;
        modeloCadastrado = this.controller.cadastrar(modelo);

        if(modeloCadastrado != null){
            System.out.println(" Modelo cadastrado: ID "+ modeloCadastrado.getId());
        } else {
            System.out.println(" Erro ao cadastrar marca!");
        }
    }

    public void altualizar(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Atualizar Modelo");

        System.out.println("> Informe o modelo a ser atualizado");
        String nome = sc.nextLine();

        Modelo modelo = this.controller.buscarPeloNome(nome);

        if( modelo != null){

            System.out.println("> Marca: "+ modelo.getId() + " - " + modelo.getNome() + " - " + modelo.getTipo());

            System.out.println("> Informe o nome atual: ");
            String nomeAtual = sc.nextLine();

            System.out.println("> Informe o tipo atual: ");
            String tipoAtual = sc.nextLine();

            modelo.setNome(nomeAtual);
            modelo.setTipo(tipoAtual);

            if( this.controller.altualizar(modelo) == true){
                System.out.println("> Modelo alterada com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar modelo!");
            }

        } else {
            System.out.println("> Modelo informada não existe!");
        }
    }

    public void excluir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#Excluir Modelo");

        System.out.println("> Informe o modelo a ser excluída");
        String nome = sc.nextLine();

        Modelo modelo = this.controller.buscarPeloNome(nome);

        if(modelo != null){

            if( this.controller.excluir(modelo) ){
                System.out.println("> SUCESSO - Marca excluída!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir a marca!");
            }


        } else {
            System.out.println("> ERRO - Marca não encontrada!");
        }
    }

    public void listar(){
        List<Modelo> listaModelos;
        listaModelos = this.controller.listar();

        if(listaModelos == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Marcas");
            for (int i=0; i<listaModelos.size(); i++){
                System.out.println("> "+ listaModelos.get(i).getId() + " - " + listaModelos.get(i).getNome() + " - " + listaModelos.get(i).getTipo());
            }
        }
    }

    public void buscarPeloNome(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Marca");

        System.out.println("> Informe a marca");
        String nome = sc.nextLine();

        Modelo modelo = this.controller.buscarPeloNome(nome);

        if( modelo != null){
            System.out.println("> Modelo: "+ modelo.getId() + " - " + modelo.getNome() + " - " + modelo.getTipo() + " - " + modelo.getMarca_id());
        } else {
            System.out.println("> ERRO - Modelo não encontrado!");
        }
    }
}
