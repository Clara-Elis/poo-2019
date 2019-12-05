package view;

import principal.Principal;
import controller.GerenteController;

import java.util.Scanner;

public class GerenteView {

    private GerenteController controller;

    public GerenteView (){
        this.controller = new GerenteController();
    }

    public void menuModelo(){

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
        this.menuModelo();
    }

    public void cadastrar(){

    }

    public void altualizar(){

    }

    public void excluir(){

    }

    public void listar(){

    }

    public void buscarPeloNome(){

    }
}
