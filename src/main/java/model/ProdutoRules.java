package model;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ProdutoDAO;

public class ProdutoRules {
	ProdutoDAO produtoDao;
	
	public ProdutoRules() {
		this.produtoDao = new ProdutoDAO();
	}

	public String validarCadastro(Produto produto) {
		if (produto.codigo <= 0) {
			return "Código não informado.";
		}
		if (produto.nome == null || produto.nome.equals("")) {
			return "Produto não pode ficar vazio.";
		}
		if (produto.preco <= 0) {
			return "Valor Obrigatório";
		}
		if (produto.quantidade <= 0) {
			return "Informe a quantidade.";
		}
		if (produto.compatibilidadeSoftware == null || produto.compatibilidadeSoftware.size() <= 0) {
			return "Informe ao menos uma compatibilidade de Software.";
		}
		if (validarCompatibilidadeHardware(produto)) {
			return "Informe ao menos uma compatibilidade de HardWare.";
		}
		return null;
	}

	public boolean validarCompatibilidadeHardware(Produto produto) {
		boolean valido = true;
		if (produto.compatibilidadeHardware.slot == null || produto.compatibilidadeHardware.slot.equals("")) {
			valido = false;
		} else if (produto.compatibilidadeHardware.modelo == null
				|| produto.compatibilidadeHardware.modelo.equals("")) {
			valido = false;
		} else if (produto.compatibilidadeHardware.encapsulamento == null
				|| produto.compatibilidadeHardware.encapsulamento.equals("")) {
			valido = false;
		}
		return valido;
	}
	
	public String cadastrarProduto(Produto p){
		String erro = validarCadastro(p);
		if(validarCadastro(p).equals("")){
			erro = produtoDao.cadastrarProduto(p);
			if(!erro.equals("")){
				return "Erro ao realizar cadastro: " + erro;
			} else {
				return "Cadastro realizado com sucesso.";
			}
		} else {
			return erro;
		}
	}
	
	public ArrayList<Produto> buscarTodos(){
		try {
			return produtoDao.buscarTodos();
		} catch (SQLException e) {
			return null;
		}
	}
}
