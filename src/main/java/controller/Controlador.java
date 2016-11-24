package controller;

import java.util.ArrayList;

import model.CompatibilidadeHardware;
import model.Produto;
import model.ProdutoRules;

public class Controlador {
	ProdutoRules produtoRules = null;

	public Controlador() {
		this.produtoRules = new ProdutoRules();
	}

	public String cadastrarProduto(String nome, String descricao, int quantidade, double preco,
			ArrayList<CompatibilidadeHardware> compHardware, ArrayList<String>compSoftware){
		Produto p = new Produto(preco, quantidade, nome, descricao);
		p.setCompatibilidadeHardware(compHardware);
		p.setCompatibilidadeSoftware(compSoftware);
		String erro = produtoRules.cadastrarProduto(p);
		return erro;
	}
}
