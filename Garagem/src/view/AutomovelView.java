package view;

import controller.AutomovelController;
import entity.Automovel;
import principal.Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AutomovelView {

    private AutomovelController controller;

    public AutomovelView(){
        this.controller = new AutomovelController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Automovel");

        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Atualizar");
        System.out.println(" 3 - Excluir");
        System.out.println(" 4 - Listar");
        System.out.println(" 5 - Buscar pela placa");
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
                this.buscarPelaPlaca();
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

        Automovel automovel = new Automovel();

        System.out.println("> Informe o id do modelo: ");
        automovel.setModelo_id(sci.nextInt());

        System.out.println("> Informe a cor: ");
        automovel.setCor(sc.nextLine());

        try {
            System.out.println("> Informe o ano de fabricacao: ");
            String anoFab = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(anoFab);
            automovel.setAno_fabricacao(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("> Informe o ano do modelo: ");
            String anoMod = sc.nextLine();
            Date dt = new SimpleDateFormat("yyyy").parse(anoMod);
            automovel.setAno_modelo(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o chassi: ");
        automovel.setChassi(sc.nextLine());

        System.out.println("> Informe a placa: ");
        String placa = sc.nextLine();

        if(this.controller.verifica(placa)){
            System.out.println("Placa ja cadastrada!");
            this.menu();
        }else{
            automovel.setPlaca(placa);
        }

        System.out.println("> Informe a quilometragem: ");
        automovel.setQuilometragem(sci.nextFloat());

        System.out.println("> Informe o valor: ");
        automovel.setValor(sci.nextFloat());

        if(controller.cadastrar(automovel) != null){
            System.out.println("Automovel cadastrado com sucesso");
        } else {
            System.out.println("ERRO - Não foi possível cadastrar o Automovel");
        }
    }

    public void altualizar(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("#Atualizar Automovel");

        System.out.println("> Informe o automovel a ser atualizado: ");
        String placa = sc.nextLine();

        Automovel automovel = this.controller.buscarPelaPlaca(placa);

        if(automovel != null){
            System.out.println("> Automovel: " + automovel.getId() + " - " + automovel.getPlaca() + " - " + automovel.getCor() +
                    " - " + automovel.getQuilometragem() + " - " + automovel.getValor() + " - " + automovel.getChassi());

            System.out.println("> Informe a nova cor: ");
            automovel.setCor(sc.nextLine());

            System.out.println("> Informe o novo valor: ");
            automovel.setValor(sci.nextFloat());

            System.out.println("> Informea nova quilometragem: ");
            automovel.setQuilometragem(sci.nextFloat());


            if( this.controller.altualizar(automovel) == true){
                System.out.println("> Automovel alterado com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar automovel!");
            }
        }
    }

    public void excluir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#Excluir Automovel");

        System.out.println("> Informe a placa do automovel a ser excluído: ");
        String placa = sc.nextLine();

        Automovel automovel = this.controller.buscarPelaPlaca(placa);

        if(automovel != null){
            if( this.controller.excluir(automovel) ){
                System.out.println("> SUCESSO - Automovel excluído!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir o Automovel!");
            }
        } else {
            System.out.println("> ERRO - Automovel não encontrado!");
        }
    }

    public void listar(){
        List<Automovel> listaAutomoveis = this.controller.listar();

        if(listaAutomoveis == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Automoveis");
            for (int i=0; i<listaAutomoveis.size(); i++){
                System.out.println("> "+ listaAutomoveis.get(i).getId() + " - " + listaAutomoveis.get(i).getPlaca() + " - " +
                        listaAutomoveis.get(i).getAno_fabricacao() + " - " + listaAutomoveis.get(i).getAno_modelo() + " - " +
                        listaAutomoveis.get(i).getValor());
            }
        }
    }

    public void buscarPelaPlaca(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Automovel");

        System.out.println("> Informe a placa do automovel: ");
        String placa = sc.nextLine();

        Automovel automovel = this.controller.buscarPelaPlaca(placa);

        if( automovel != null){
            System.out.println("> Automovel: " + automovel.getId() + " - " + automovel.getPlaca() + " - " + automovel.getChassi() +
                    " - " + automovel.getCor() + " - " + automovel.getAno_modelo() + " - " + automovel.getAno_fabricacao() + " - "
                    + automovel.getQuilometragem() + " - " + automovel.getValor() + " - " + automovel.getModelo_id());
        } else {
            System.out.println("> ERRO - Automovel não encontrado!");
        }
    }
}
