package principal;

import view.AutomovelView;
import view.FuncionarioView;
import view.MarcaView;
import view.ModeloView;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Principal m = new Principal();
        m.menuPrincipal();
    }

    public void menuPrincipal(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Garagem 3.0");

        System.out.println("1 - Marca");
        System.out.println("2 - Modelo");
        System.out.println("3 - Automovel");
        System.out.println("4 - Funcionario");
        int op = sc.nextInt();

        switch (op){

            case 1:
                MarcaView marcaView = new MarcaView();
                marcaView.menu();
                break;
            case 2:
                ModeloView modeloView = new ModeloView();
                modeloView.menu();
                break;
            case 3:
                AutomovelView automovelView = new AutomovelView();
                automovelView.menu();
                break;
            case 4:
                FuncionarioView funcionarioView = new FuncionarioView();
                funcionarioView.menu();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                break;

        }
    }

}