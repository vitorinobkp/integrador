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

}
