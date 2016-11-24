package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Produto;

public class ProdutoDAO {
	ConexaoDB conexao;
	public ProdutoDAO() {
		conexao = new ConexaoDB();
	}
	
	public String cadastrarProduto(Produto produto){
		try{
			String sql = null;
			sql = "insert into produtos(nome, descricao, quantidade, preco) "
					+ "values('_nome', '_descricao', _quantidade, _preco)";
			sql.replaceAll("_nome", produto.getNome()).
			replaceAll("_descricao", produto.getDescricao()).
			replaceAll("_quantidade", String.valueOf(produto.getQuantidade())).
			replaceAll("_preco", String.valueOf(produto.getPreco()));
			conexao.executeSQL(sql);
			return "";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String atualizarProduto(Produto produto){
		try{
			String sql = null;
			sql = "update produtos set"
					+ "nome = _nome,"
					+ "descricao = _descricao,"
					+ "quantidade = _quantidade,"
					+ "preco = _preco";
			sql.replaceAll("_nome", produto.getNome()).
			replaceAll("_descricao", produto.getDescricao()).
			replaceAll("_quantidade", String.valueOf(produto.getQuantidade())).
			replaceAll("_preco", String.valueOf(produto.getPreco()));
			conexao.executeSQL(sql);
			return "";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String excluirProduto(int id){
		try{
			String sql = null;
			sql = "DELETE FROM PRODUTOS WHERE ID = " + String.valueOf(id);
			conexao.executeDelete(sql);
			return "";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public ArrayList<Produto> buscarTodos() throws SQLException {
		
		ResultSet rs = conexao.executeConsulta("SELECT * FROM PRODUTOS");
		ArrayList<Produto> lstProduto = new ArrayList<Produto>();
		
		int id;
		String nome;
		String descricao;
		int quantidade;
		double preco;
		while (rs.next()) {
			id = rs.getInt(1);
			nome = rs.getString(2);
			descricao = rs.getString(3);
			quantidade = rs.getInt(4);
			preco = rs.getDouble(5);
			Produto p = new Produto( preco, quantidade, nome, descricao);
			lstProduto.add(p);
		}
		return lstProduto;
	}
	
	public Produto buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM PRODUTOS WHERE ID = " + String.valueOf(id);
		ResultSet rs = conexao.executeConsulta(sql);
		Produto p = null;
		String nome;
		String descricao;
		int quantidade;
		double preco;
		while (rs.next()) {
			id = rs.getInt(1);
			nome = rs.getString(2);
			descricao = rs.getString(3);
			quantidade = rs.getInt(4);
			preco = rs.getDouble(5);
			p = new Produto(preco, quantidade, nome, descricao);
			p.setCodigo(id);
		}
		return p;
	}
	
	public Produto buscarPorNome(String nomeProduto) throws SQLException {
		String sql = "SELECT * FROM PRODUTOS WHERE nome = " + nomeProduto;
		ResultSet rs = conexao.executeConsulta(sql);
		Produto p = null;
		int id;
		String nome;
		String descricao;
		int quantidade;
		double preco;
		while (rs.next()) {
			id = rs.getInt(1);
			nome = rs.getString(2);
			descricao = rs.getString(3);
			quantidade = rs.getInt(4);
			preco = rs.getDouble(5);
			p = new Produto(preco, quantidade, nome, descricao);
			p.setCodigo(id);
		}
		return p;
	}
}
