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
			sql = "insert into produtos(nome, descricao, quantidade, preco, compativel_Windows,"
					+ "compativel_Linux, compativel_Mac, compativel_Outros, compativel_Socket,"
					+ "compativel_Slot, categoria) "
					+ "values('_nome', '_descricao', _quantidade, _preco, '_compativel_Windows',"
					+ "'_compativel_Linux', '_compativel_Mac', '_compativel_Outros', '_compativel_Socket',"
					+ "'_compativel_Slot', '_categoria')";
			sql = sql.replaceAll("_nome", produto.getNome());
			sql = sql.replaceAll("_descricao", produto.getDescricao());
			sql = sql.replaceAll("_quantidade", String.valueOf(produto.getQuantidade()));
			sql = sql.replaceAll("_preco", String.valueOf(produto.getPreco()));
			sql = sql.replaceAll("_compativel_Windows", produto.getCompativelWindows());
			sql = sql.replaceAll("_compativel_Linux", produto.getCompativelLinux());
			sql = sql.replaceAll("_compativel_Mac", produto.getCompativelMac());
			sql = sql.replaceAll("_compativel_Outros", produto.getOutros());
			sql = sql.replaceAll("_compativel_Socket", produto.getCompativelSocket());
			sql = sql.replaceAll("_compativel_Slot", produto.getCompativelSlot());
			sql = sql.replaceAll("_categoria", produto.getCategoria());
			
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
		
		while (rs.next()) {
			Produto p = new Produto();
			p.setCodigo(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setDescricao(rs.getString(3));
			p.setQuantidade(rs.getInt(4));
			p.setPreco(rs.getDouble(5));
			p.setCompativelWindows(rs.getString(6));
			p.setCompativelLinux(rs.getString(7));
			p.setOutros(rs.getString(8));
			p.setCompativelSocket(rs.getString(9));
			p.setCompativelMac(rs.getString(10));
			p.setCompativelSlot(rs.getString(11));
			p.setCategoria(rs.getString(12));
			lstProduto.add(p);
		}
		return lstProduto;
	}
	
	public Produto buscarPorId(int id) throws SQLException {
		String sql = "SELECT * FROM PRODUTOS WHERE ID = " + String.valueOf(id);
		ResultSet rs = conexao.executeConsulta(sql);
		Produto p = null;
		while (rs.next()) {
			p = new Produto();
			p.setCodigo(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setDescricao(rs.getString(3));
			p.setQuantidade(rs.getInt(4));
			p.setPreco(rs.getDouble(5));
			p.setCompativelWindows(rs.getString(6));
			p.setCompativelLinux(rs.getString(7));
			p.setOutros(rs.getString(8));
			p.setCompativelSocket(rs.getString(9));
			p.setCompativelMac(rs.getString(10));
			p.setCompativelSlot(rs.getString(11));
			p.setCategoria(rs.getString(12));
		}
		return p;
	}
	
	public Produto buscarPorNome(String nomeProduto) throws SQLException {
		String sql = "SELECT * FROM PRODUTOS WHERE nome = " + nomeProduto;
		ResultSet rs = conexao.executeConsulta(sql);
		Produto p = null;
		while (rs.next()) {
			p = new Produto();
			p.setCodigo(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setDescricao(rs.getString(3));
			p.setQuantidade(rs.getInt(4));
			p.setPreco(rs.getDouble(5));
			p.setCompativelWindows(rs.getString(6));
			p.setCompativelLinux(rs.getString(7));
			p.setOutros(rs.getString(8));
			p.setCompativelSocket(rs.getString(9));
			p.setCompativelMac(rs.getString(10));
			p.setCompativelSlot(rs.getString(11));
			p.setCategoria(rs.getString(12));
		}
		return p;
	}
	
	public Produto buscarProduto(int codigo, String nomeProduto) throws SQLException {
		String sql = "SELECT * FROM PRODUTOS WHERE 1=1 ";
		if(codigo > 0){
			sql+= " AND id = " + codigo;
		}
		if(!nomeProduto.equals("")){
			sql+= " AND nome like '%" + nomeProduto + "%'";
		}
		ResultSet rs = conexao.executeConsulta(sql);
		Produto p = null;
		while (rs.next()) {
			p = new Produto();
			p.setCodigo(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setDescricao(rs.getString(3));
			p.setQuantidade(rs.getInt(4));
			p.setPreco(rs.getDouble(5));
			p.setCompativelWindows(rs.getString(6));
			p.setCompativelLinux(rs.getString(7));
			p.setOutros(rs.getString(8));
			p.setCompativelSocket(rs.getString(9));
			p.setCompativelMac(rs.getString(10));
			p.setCompativelSlot(rs.getString(11));
			p.setCategoria(rs.getString(12));
		}
		return p;
	}
}
