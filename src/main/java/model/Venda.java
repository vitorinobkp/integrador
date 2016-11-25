package model;

import java.util.ArrayList;

public class Venda {
	ArrayList<ItemVenda> lstItemVenda;
	int codigo;

	public ArrayList<ItemVenda> getLstItemVenda() {
		return lstItemVenda;
	}

	public void setLstItemVenda(ArrayList<ItemVenda> lstItemVenda) {
		this.lstItemVenda = lstItemVenda;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Venda(ArrayList<ItemVenda> lstItemVenda, int codigo) {
		this.lstItemVenda = lstItemVenda;
		this.codigo = codigo;
	}
	
	

}
