package view;

import entity.Venda;
import principal.Principal;
import controller.VendaController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VendaView {

    private VendaController controller;

    public VendaView (){
        this.controller = new VendaController();
    }

    public void menu(){

        Scanner sc = new Scanner(System.in);

        System.out.println("#Menu Venda");

        System.out.println(" 1 - Cadastrar");
        System.out.println(" 2 - Atualizar");
        System.out.println(" 3 - Excluir");
        System.out.println(" 4 - Listar");
        System.out.println(" 5 - Buscar codigo");
        System.out.println(" 6 - Relatorio");
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
                this.buscarPeloCod();
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

        Venda venda = new Venda();

        try {
            System.out.println("> Informe a data de venda: ");
            String anoFab = sc.nextLine();
            Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(anoFab);
            venda.setData_venda(dt);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("> Informe o nome do vendedor: ");
        venda.setNome_vendedor(sc.nextLine());

        System.out.println("> Informe o nome do cliente: ");
        venda.setNome_cliente(sc.nextLine());

        System.out.println("> Informe a placa do automovel:");
        venda.setPlaca(sc.nextLine());

        System.out.println("> Informe a comissao: ");
        venda.setComissao(sci.nextFloat());

        if(controller.cadastrar(venda) != null){
            System.out.println("Venda cadastrada com sucesso");
        } else {
            System.out.println("ERRO - Não foi possível cadastrar a Venda");
        }
    }

    public void altualizar(){
        Scanner sc = new Scanner(System.in);
        Scanner sci = new Scanner(System.in);

        System.out.println("#Atualizar Venda");

        System.out.println("> Informe o codigo da venda: ");
        int cod = sc.nextInt();

        Venda venda = this.controller.buscarPeloCod(cod);

        if(venda != null){
            System.out.println("> Venda: " + venda.getCod_venda() + " - " + venda.getNome_vendedor() + " - "
                    + venda.getNome_cliente() + " - " + venda.getData_venda());

            System.out.println("> Informe o novo nome do vendedor: ");
            venda.setNome_vendedor(sc.nextLine());

            System.out.println("> Informe o novo nome do cliente: ");
            venda.setNome_cliente(sc.nextLine());

            try {
                System.out.println("> Informe a nova data da venda: ");
                String anoFab = sc.nextLine();
                Date dt = new SimpleDateFormat("dd/MM/yyyy").parse(anoFab);
                venda.setData_venda(dt);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            }

            if( this.controller.altualizar(venda) == true){
                System.out.println("> Venda alterado com sucesso");
            } else {
                System.out.println("> Erro interno ao alterar venda!");
            }
        }
    }

    public void excluir(){
        Scanner sc = new Scanner(System.in);
        System.out.println("#Excluir venda");

        System.out.println("> Informe o codigo da veda a ser excluída: ");
        int cod = sc.nextInt();

        Venda venda = this.controller.buscarPeloCod(cod);

        if(venda != null){
            if( this.controller.excluir(venda) ){
                System.out.println("> SUCESSO - Venda excluída!");
            } else {
                System.out.println("> ERRO INTERNO - Não foi possível excluir o Venda!");
            }
        } else {
            System.out.println("> ERRO - Venda não encontrado!");
        }
    }

    public void listar(){
        List<Venda> listaVendas = this.controller.listar();

        if(listaVendas == null){
            System.out.println("#Lista vazia");
            this.menu();
        }else{
            System.out.println("#Lista de Vendas");
            for (int i=0; i<listaVendas.size(); i++){
                System.out.println("> " + + listaVendas.get(i).getCod_venda() + " - " + listaVendas.get(i).getData_venda() + " - "
                        + listaVendas.get(i).getNome_vendedor() + " - " + listaVendas.get(i).getNome_cliente());
            }
        }
    }

    public void buscarPeloCod(){
        Scanner sc = new Scanner(System.in);

        System.out.println("#Busca de Venda");

        System.out.println("> Informe o codigo da venda: ");
        int cod = sc.nextInt();

        Venda venda = this.controller.buscarPeloCod(cod);

        if( venda != null){
            System.out.println("> Venda: " + venda.getData_venda() + " - " + venda.getNome_vendedor() + " - "
                    + venda.getNome_cliente() + " - " + venda.getPlaca() + " - " + venda.getComissao());
        } else {
            System.out.println("> ERRO - Venda não encontrado!");
        }
    }
}
