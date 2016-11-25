package model;

public class ItemVenda {
	Produto produto;
	int quantidade;
	double preco;
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getPreco() {
		return produto.getPreco() * this.quantidade;
	}	
}
