/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
@SuppressWarnings("serial")
public class TableModelProduto extends AbstractTableModel {

	private ArrayList<Produto> listaDeProdutos;
	private String[] colunas = { "ID", "Nome", "Descrição", "Quantidade", "Preço" };
	public TableModelProduto() {
		listaDeProdutos = new ArrayList<Produto>();
	}

	public void addProduto(Produto pProduto) {
		this.listaDeProdutos.add(pProduto);
		fireTableDataChanged();
	}

	public void removerProduto(int rowIndex) {
		this.listaDeProdutos.remove(rowIndex);
		fireTableDataChanged();
	}

	public void refresh() {
		fireTableDataChanged();
	}

	public Produto getProduto(int rowIndex) {
		return this.listaDeProdutos.get(rowIndex);
	}

	@Override
	public int getRowCount() {
		return this.listaDeProdutos.size();
	}

	@Override
	public int getColumnCount() {
		return colunas.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return this.listaDeProdutos.get(rowIndex).getCodigo();
		case 1:
			return this.listaDeProdutos.get(rowIndex).getNome();
		case 2:
			return this.listaDeProdutos.get(rowIndex).getDescricao();
		case 3:
			return this.listaDeProdutos.get(rowIndex).getQuantidade();
		case 4:
			return this.listaDeProdutos.get(rowIndex).getPreco();
		default:
			return this.listaDeProdutos.get(rowIndex);
		}
	}

	@Override
	public String getColumnName(int columnIndex) {
		return this.colunas[columnIndex];
	}
}
