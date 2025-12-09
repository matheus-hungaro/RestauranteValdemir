import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ValdemirController sistema = new ValdemirController();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n--- RESTAURANTE DO VALDEMIR ---");
            System.out.println("1. Ver Cardápio");
            System.out.println("2. Abrir Mesa");
            System.out.println("3. Fazer Pedido");
            System.out.println("4. Fechar Conta (e Rachar)");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            
            int opcao = scanner.nextInt();
            
            if (opcao == 0) break;
            
            switch (opcao) {
                case 1:
                    System.out.println("--- CARDÁPIO ---");
                    for (Produto p : sistema.getCardapio().getProdutos()) {
                        System.out.println(p.getId() + ". " + p.getNome() + " - R$ " + p.getPreco());
                    }
                    break;
                case 2:
                    System.out.print("Número da Mesa (1-50): ");
                    int m = scanner.nextInt();
                    System.out.println(sistema.abrirMesa(m));
                    break;
                case 3:
                    System.out.print("Número da Mesa: ");
                    int mPed = scanner.nextInt();
                    System.out.print("ID do Produto: ");
                    int idProd = scanner.nextInt();
                    System.out.print("Quantidade: ");
                    int qtd = scanner.nextInt();
                    System.out.println(sistema.adicionarPedido(mPed, idProd, qtd));
                    break;
                case 4:
                    System.out.print("Número da Mesa para fechar: ");
                    int mFecha = scanner.nextInt();
                    System.out.print("Dividir em quantas pessoas? (1 para não dividir): ");
                    int pessoas = scanner.nextInt();
                    System.out.println(sistema.fecharConta(mFecha, pessoas));
                    break;
            }
        }
    }
}