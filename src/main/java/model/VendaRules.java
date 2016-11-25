package model;

public class VendaRules {
	public String validarCadastro(Produto produto) {
		if (produto.codigo <= 0) {
			return "Código não informado.";
		}
		if (produto.nome == null || produto.nome.equals("")) {
			return "Produto não pode ficar vazio.";
		}
		return null;
	}
}
