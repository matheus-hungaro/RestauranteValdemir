// GRASP: Creator (Criador)
// A Mesa contém o Pedido. Quando ocupamos a mesa, ELA cria o Pedido.
public class Mesa {
    private int numero;
    private Pedido pedidoAtual;
    private boolean ocupada;

    public Mesa(int numero) {
        this.numero = numero;
        this.ocupada = false;
    }

    public void ocuparMesa() {
        this.ocupada = true;
        this.pedidoAtual = new Pedido(); // Mesa CRIA o Pedido
    }

    public void liberarMesa() {
        this.ocupada = false;
        this.pedidoAtual = null;
    }

    public Pedido getPedidoAtual() {
        return pedidoAtual;
    }

    public int getNumero() { return numero; }
    public boolean isOcupada() { return ocupada; }
}
