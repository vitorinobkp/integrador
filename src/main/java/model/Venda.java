package model;

import java.util.ArrayList;

public class Venda {
	int codigo = 0;
	double preco = 0;
	int quantidade = 0;
	String nome;
	String descricao;
	ArrayList<String> compatibilidadeSoftware;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<String> getCompatibilidadeSoftware() {
		return compatibilidadeSoftware;
	}

	public void setCompatibilidadeSoftware(ArrayList<String> compatibilidadeSoftware) {
		this.compatibilidadeSoftware = compatibilidadeSoftware;
	}

	public CompatibilidadeHardware getCompatibilidadeHardware() {
		return compatibilidadeHardware;
	}

	public void setCompatibilidadeHardware(CompatibilidadeHardware compatibilidadeHardware) {
		this.compatibilidadeHardware = compatibilidadeHardware;
	}

	CompatibilidadeHardware compatibilidadeHardware;

}
