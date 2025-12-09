import java.util.ArrayList;
import java.util.List;

// GRASP: Controller (Controlador)
// Recebe eventos da UI (Main) e coordena Mesa e Pedido.
public class ValdemirController {
    private List<Mesa> mesas;
    private Cardapio cardapio;

    public ValdemirController() {
        this.cardapio = new Cardapio();
        this.mesas = new ArrayList<>();
        // Cria as 50 mesas
        for (int i = 1; i <= 50; i++) {
            mesas.add(new Mesa(i));
        }
    }

    public Mesa buscarMesa(int numero) {
        if (numero < 1 || numero > 50) return null;
        return mesas.get(numero - 1);
    }

    public String abrirMesa(int numeroMesa) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa == null) return "Mesa inexistente.";
        if (mesa.isOcupada()) return "Mesa já está aberta!";
        
        mesa.ocuparMesa();
        return "Mesa " + numeroMesa + " aberta com sucesso.";
    }

    public String adicionarPedido(int numeroMesa, int idProduto, int quantidade) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa == null || !mesa.isOcupada()) return "Mesa fechada ou inválida.";

        Produto prod = cardapio.buscarProduto(idProduto);
        if (prod == null) return "Produto não encontrado.";

        // Cria o item e adiciona ao pedido da mesa
        ItemPedido item = new ItemPedido(prod, quantidade);
        mesa.getPedidoAtual().adicionarItem(item);
        
        return quantidade + "x " + prod.getNome() + " adicionado.";
    }

    public String fecharConta(int numeroMesa, int numeroPessoasDivisao) {
        Mesa mesa = buscarMesa(numeroMesa);
        if (mesa == null || !mesa.isOcupada()) return "Erro na mesa.";

        Pedido pedido = mesa.getPedidoAtual();
        String resumo = "=== CONTA MESA " + numeroMesa + " ===\n";
        
        for (ItemPedido i : pedido.getItens()) {
            resumo += i.toString() + "\n";
        }
        
        resumo += "Subtotal: R$ " + pedido.calcularTotalItens() + "\n";
        resumo += "Serviço (10%): R$ " + (pedido.calcularTotalItens() * 0.10) + "\n";
        resumo += "TOTAL FINAL: R$ " + pedido.calcularTotalComServico() + "\n";
        
        // Aplica a inovação
        if (numeroPessoasDivisao > 1) {
            resumo += "\n[RACHANDO A CONTA]\n" + pedido.racharConta(numeroPessoasDivisao);
        }

        mesa.liberarMesa(); // Limpa a mesa
        return resumo;
    }
    
    public Cardapio getCardapio() { return cardapio; }
}