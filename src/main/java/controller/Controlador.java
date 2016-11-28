package controller;

import model.Produto;
import model.ProdutoRules;

public class Controlador {
	ProdutoRules produtoRules = null;

	public Controlador() {
		this.produtoRules = new ProdutoRules();
	}
	
	public String cadastrarProduto(int codigo, double preco, int quantidade, String compativelWindows, String compativelLinux,
			String compativelMac, String outros, String nome, String descricao, String compativelSocket,
			String compativelSlot, String categoria){
		Produto p = new Produto( codigo,  preco,  quantidade,  compativelWindows,  compativelLinux,
				 compativelMac,  outros,  nome,  descricao,  compativelSocket,
				 compativelSlot,  categoria);
		if(produtoRules.validarCadastro(p).equals("")){
			return produtoRules.cadastrarProduto(p);
		} else {
			return null;
		}
	}
	
	public Produto buscarProduto(int codigo, String nome){
		codigo = codigo < 0 ? 0 : codigo;
		nome = nome == null ? "" : nome;
		return produtoRules.buscarProduto(codigo, nome);
	}

	public boolean excluirProduto(int codigo) {
		return produtoRules.excluirProduto(codigo);
	}
}
