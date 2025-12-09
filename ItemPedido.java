// GRASP: Information Expert (Especialista na Informação)
// Esta classe sabe o preço do produto e a quantidade, logo,
// ELA deve ser responsável por calcular o subtotal da linha.
public class ItemPedido {
    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public String toString() {
        return quantidade + "x " + produto.getNome() + " (R$ " + getSubtotal() + ")";
    }
}
