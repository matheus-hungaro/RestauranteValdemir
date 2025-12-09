import java.util.ArrayList;
import java.util.List;

public class Cardapio {
    private List<Produto> produtos;

    public Cardapio() {
        produtos = new ArrayList<>();
        // 10 Itens criados pelo "Chef" Valdemir
        produtos.add(new Produto(1, "Feijoada Completa", 45.00));
        produtos.add(new Produto(2, "Moqueca Capixaba", 60.00));
        produtos.add(new Produto(3, "Torresmo de Rolo", 25.00));
        produtos.add(new Produto(4, "Caipirinha de Limão", 15.00));
        produtos.add(new Produto(5, "Cerveja Gelada (600ml)", 12.00));
        produtos.add(new Produto(6, "Pudim de Leite", 10.00));
        produtos.add(new Produto(7, "Água com Gás", 5.00));
        produtos.add(new Produto(8, "Suco de Laranja", 8.00));
        produtos.add(new Produto(9, "Prato Feito (PF)", 22.00));
        produtos.add(new Produto(10, "Cafezinho", 3.00));
    }

    public Produto buscarProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) return p;
        }
        return null;
    }
    
    public List<Produto> getProdutos() { return produtos; }
}
