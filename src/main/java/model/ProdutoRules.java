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
		if (produto.getNome() == null || produto.getNome().equals("")) {
			return "O nome do produto é um camo obrigatório.";
		}
		if (produto.getDescricao() == null || produto.getDescricao().equals("")) {
			return "A descrição do produto é obrigatoria.";
		}
		if (produto.getPreco() <= 0) {
			return "Informe o valor do produto.";
		}
		if (produto.getQuantidade() <= 0) {
			return "Informe a quantidade de itens.";
		}
		if (produto.getCompativelLinux().equals("") && produto.getCompativelWindows().equals("")
				&& produto.getCompativelMac().equals("")) {
			return "Seleciona ao menos uma compatibilidade de Software.";
		}
		if(produto.getCompativelSlot().equals("") && produto.getCompativelSocket().equals("")){
			return "Selecione tipo de Slot e modelo de Socket.";
		}
		if(produto.getCategoria().equals("")){
			return "Selecione a categoria.";
		}
		return "";
	}

	public boolean validarCompatibilidadeHardware(Produto produto) {
		return false;
	}

	public String cadastrarProduto(Produto p) {
		String erro = validarCadastro(p);
		try{
		if (erro.equals("")) {
			erro = produtoDao.cadastrarProduto(p);
			if (!erro.equals("")) {
				return "Erro ao realizar cadastro: " + erro;
			} else {
				return "Cadastro realizado com sucesso.";
			}
		} else {
			return erro;
		} 
		} catch (Exception e) {
			return "Falha ao cadastrar, "+ e.getMessage();
		}
	}
	
	public String atualizarProduto(Produto p){
		String erro = validarCadastro(p);
		try{
			if (erro.equals("")) {
				erro = produtoDao.atualizarProduto(p);
				if (!erro.equals("")) {
					return "Erro ao salvar produto: " + erro;
				} else {
					return "Produto atualizado com sucesso.";
				}
			} else {
				return erro;
			} 
			} catch (Exception e) {
				return "Falha ao salvar produto, "+ e.getMessage();
			}
	}

	public ArrayList<Produto> buscarTodos() {
		try {
			return produtoDao.buscarTodos();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Produto> buscarProdutosPorNome(String nome){
		try {
			return produtoDao.buscarPorNome(nome);
		} catch (Exception e) {
			return null;
		}
	}
	
	public Produto buscarProduto(int codigo, String nome){
		try{
			return produtoDao.buscarProduto(codigo, nome);
		}catch(SQLException e){
			return null;
		}
	}

	public boolean excluirProduto(int codigo) {
		return produtoDao.excluirProduto(codigo) == "";
	}
}
