package model;

public class Produto {
	int codigo = 0;
	double preco = 0;
	int quantidade = 0;
	String compativelWindows;
	String compativelLinux;
	String compativelMac;
	String outros;
	String nome;
	String descricao;
	String compativelSocket;
	String compativelSlot;
	String categoria;

	public Produto() {
		this.codigo = 0;
		this.preco = 0;
		this.quantidade = 0;
		this.compativelWindows = null;
		this.compativelLinux = null;
		this.compativelMac = null;
		this.outros = null;
		this.nome = null;
		this.descricao = null;
		this.compativelSocket = null;
		this.compativelSlot = null;
		this.categoria = null;
	}


	public Produto(int codigo, double preco, int quantidade, String compativelWindows, String compativelLinux,
			String compativelMac, String outros, String nome, String descricao, String compativelSocket,
			String compativelSlot, String categoria) {
		super();
		this.codigo = codigo;
		this.preco = preco;
		this.quantidade = quantidade;
		this.compativelWindows = compativelWindows;
		this.compativelLinux = compativelLinux;
		this.compativelMac = compativelMac;
		this.outros = outros;
		this.nome = nome;
		this.descricao = descricao;
		this.compativelSocket = compativelSocket;
		this.compativelSlot = compativelSlot;
		this.categoria = categoria;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getCompativelWindows() {
		return compativelWindows;
	}

	public void setCompativelWindows(String compativelWindows) {
		this.compativelWindows = compativelWindows;
	}

	public String getCompativelLinux() {
		return compativelLinux;
	}

	public void setCompativelLinux(String compativelLinux) {
		this.compativelLinux = compativelLinux;
	}

	public String getCompativelMac() {
		return compativelMac;
	}

	public void setCompativelMac(String compativelMac) {
		this.compativelMac = compativelMac;
	}

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCompativelSocket() {
		return compativelSocket;
	}

	public void setCompativelSocket(String compativelSocket) {
		this.compativelSocket = compativelSocket;
	}

	public String getCompativelSlot() {
		return compativelSlot;
	}

	public void setCompativelSlot(String compativelSlot) {
		this.compativelSlot = compativelSlot;
	}

	public String getCategoria() {
		return categoria;
	}
}
