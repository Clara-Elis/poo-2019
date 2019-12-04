import view.MarcaView;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        m.menuPrincipal();
    }

    public void menuPrincipal(){

        Scanner sc = new Scanner(System.in);

        System.out.println("Garagem 3.0");

        System.out.println(" 1 - Marca");
        int op = sc.nextInt();

        switch (op){

            case 1:
                MarcaView marcaView = new MarcaView();
                marcaView.menuMarca();
                break;
            default:
                break;

        }
    }

}