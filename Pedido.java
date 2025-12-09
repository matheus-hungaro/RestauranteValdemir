import java.util.ArrayList;
import java.util.List;

// GRASP: Information Expert & High Cohesion
// O Pedido detém a lista de itens, então ELE deve calcular o total.
public class Pedido {
    private List<ItemPedido> itens;
    private boolean fechado;

    public Pedido() {
        this.itens = new ArrayList<>();
        this.fechado = false;
    }

    // GRASP: Low Coupling (Baixo Acoplamento)
    // O Pedido recebe o objeto ItemPedido já pronto ou os dados para criar um.
    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotalItens() {
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal(); // Delega o cálculo da linha para o item
        }
        return total;
    }

    // A lógica de negócio dos 10% fica aqui (Especialista)
    public double calcularTotalComServico() {
        return calcularTotalItens() * 1.10;
    }

    // INOVAÇÃO: O Rachador de Conta
    public String racharConta(int numeroDePessoas) {
        if (numeroDePessoas <= 0) return "Número de pessoas inválido.";
        
        double totalFinal = calcularTotalComServico();
        double valorPorPessoa = totalFinal / numeroDePessoas;
        
        return String.format("Total: R$ %.2f | Pessoas: %d | Cada um paga: R$ %.2f", 
                             totalFinal, numeroDePessoas, valorPorPessoa);
    }
    
    public List<ItemPedido> getItens() { return itens; }
}
