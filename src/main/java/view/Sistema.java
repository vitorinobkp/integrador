package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controlador;
import model.Produto;

import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Sistema {

	private JFrame frmPiEstoque;
	private JLabel lblControleDeEstoque;
	private JTextField txtCodigo;
	private JTextField txtProduto;
	private JTextField txtQuantidade;
	private JTextField txtVendasCodigo;
	private JTextField txtVendasProduto;
	private JTable tabelaItensVendas;
	private JTable tabelaVendas;
	private JTextField txtCadastroDescricao;
	private JTextField txtPreco;
	private JPanel pnlCopatSoft;
	private JCheckBox chkLinux;
	private JCheckBox chkWindows;
	private JCheckBox chkMacOS;
	private JComboBox cbModelo;
	private JComboBox cbSlot;
	private JComboBox cbCategoria;
	private JButton btnExcluir;
	private JButton btnSalvar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema window = new Sistema();
					window.frmPiEstoque.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Sistema() {
		initialize();
	}
	
	private void exluirProduto(int codigo){
		Controlador ctrl = new Controlador();
		if(codigo > 0){
			if(ctrl.excluirProduto(codigo)){
				JOptionPane.showMessageDialog(null, "Produto excluído com sucesso");
			}else{
				JOptionPane.showMessageDialog(null, "Falha ao excluir produto.");
			}
		}
	}
	private void buscarProduto(int codigo, String text) {
		Controlador ctrl = new Controlador();
		Produto p = ctrl.buscarProduto(codigo, text);
		if (p != null) {
			txtCodigo.setText(String.valueOf(p.getCodigo()));
			txtCadastroDescricao.setText(p.getDescricao());
			txtPreco.setText("R$" + String.valueOf(p.getPreco()));
			txtProduto.setText(p.getNome());
			txtQuantidade.setText(String.valueOf(p.getQuantidade()));
			chkLinux.setSelected(p.getCompativelLinux().equals("S"));
			chkMacOS.setSelected(p.getCompativelMac().equals("S"));
			chkWindows.setSelected(p.getCompativelWindows().equals("S"));
			cbCategoria.setSelectedItem(p.getCategoria());
			cbModelo.setSelectedItem(p.getCompativelSocket());
			cbSlot.setSelectedItem(p.getCompativelSlot());
			btnExcluir.setEnabled(true);
		}else{
			btnExcluir.setEnabled(false);
			limparTela();
		}

	}
	
	private void limparTela(){
		txtCadastroDescricao.setText("");
		txtPreco.setText("R$");
		txtProduto.setText("");
		txtQuantidade.setText("");
		chkLinux.setSelected(false);
		chkMacOS.setSelected(false);
		chkWindows.setSelected(false);
		cbCategoria.setSelectedIndex(0);
		cbModelo.setSelectedIndex(0);
		cbSlot.setSelectedIndex(0);
		btnExcluir.setEnabled(false);
	}

	private void initialize() {
		frmPiEstoque = new JFrame();
		frmPiEstoque.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Downloads\\Guj-logo-1.png"));
		frmPiEstoque.setTitle("PI - Estoque");
		frmPiEstoque.setBounds(100, 100, 591, 502);
		frmPiEstoque.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPiEstoque.getContentPane().setLayout(null);

		lblControleDeEstoque = new JLabel("Controle de Estoque");
		lblControleDeEstoque.setBounds(133, 11, 275, 53);
		lblControleDeEstoque.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblControleDeEstoque.setHorizontalAlignment(SwingConstants.CENTER);
		frmPiEstoque.getContentPane().add(lblControleDeEstoque);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 70, 552, 345);
		frmPiEstoque.getContentPane().add(tabbedPane);

		JPanel pnlCadastro = new JPanel();
		tabbedPane.addTab("Cadastro", null, pnlCadastro, null);
		pnlCadastro.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo: ");
		lblCdigo.setBounds(10, 11, 46, 14);
		pnlCadastro.add(lblCdigo);

		txtCodigo = new JTextField();
		txtCodigo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {

				int codigo = -1;
				try {
					if(!txtCodigo.getText().equals(""))
						codigo = Integer.parseInt(txtCodigo.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Código informado inválido.");
					return;
				}
				buscarProduto(codigo, null);
			}
		});
		txtCodigo.setBounds(95, 8, 134, 20);
		pnlCadastro.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(10, 36, 70, 14);
		pnlCadastro.add(lblProduto);

		JLabel lblPreo = new JLabel("Pre\u00E7o: ");
		lblPreo.setBounds(10, 61, 46, 14);
		pnlCadastro.add(lblPreo);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(10, 86, 70, 14);
		pnlCadastro.add(lblQuantidade);

		pnlCopatSoft = new JPanel();
		pnlCopatSoft.setBorder(new TitledBorder(null, "Compatibilidade de Software", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnlCopatSoft.setBounds(369, 11, 168, 100);
		pnlCadastro.add(pnlCopatSoft);
		pnlCopatSoft.setLayout(null);

		chkLinux = new JCheckBox("GNU/Linux");
		chkLinux.setBounds(6, 21, 97, 23);
		pnlCopatSoft.add(chkLinux);

		chkWindows = new JCheckBox("Windows");
		chkWindows.setBounds(6, 47, 97, 23);
		pnlCopatSoft.add(chkWindows);

		chkMacOS = new JCheckBox("MacOS");
		chkMacOS.setBounds(6, 73, 97, 23);
		pnlCopatSoft.add(chkMacOS);

		JPanel CompatHard = new JPanel();
		CompatHard.setBorder(new TitledBorder(null, "Compatibilidade de Hardware", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		CompatHard.setBounds(369, 122, 168, 113);
		pnlCadastro.add(CompatHard);
		CompatHard.setLayout(null);

		cbModelo = new JComboBox();
		cbModelo.setEditable(true);
		cbModelo.setModel(new DefaultComboBoxModel(
				new String[] { "Selec. o modelo socket", "Socket 1156", "Socket 1155", "Socket 1150", "Socket 775" }));
		cbModelo.setBounds(10, 22, 148, 20);
		CompatHard.add(cbModelo);

		cbSlot = new JComboBox();
		cbSlot.setEditable(true);
		cbSlot.setModel(new DefaultComboBoxModel(new String[] { "Selec. modelo de slot", "DDR2", "DDR3", "DDR4" }));
		cbSlot.setBounds(10, 53, 148, 20);
		CompatHard.add(cbSlot);

		cbCategoria = new JComboBox();
		cbCategoria.setEditable(true);
		cbCategoria.setModel(new DefaultComboBoxModel(
				new String[] { "Selec. a categoria", "Processador", "Memoria DRAM", "Placa M\u00E3e", "Outros" }));
		cbCategoria.setBounds(10, 84, 148, 20);
		CompatHard.add(cbCategoria);

		txtProduto = new JTextField();
		txtProduto.setBounds(95, 33, 134, 20);
		pnlCadastro.add(txtProduto);
		txtProduto.setColumns(10);

		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o: ");
		lblDescricao.setBounds(10, 108, 70, 14);
		pnlCadastro.add(lblDescricao);

		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(95, 83, 264, 20);
		pnlCadastro.add(txtQuantidade);
		txtQuantidade.setColumns(10);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador ctrl = new Controlador();
				String compatWindows = chkWindows.isSelected() ? "S" : "N";
				String compatLinux = chkLinux.isSelected() ? "S" : "N";
				String compatMac = chkMacOS.isSelected() ? "S" : "N";
				String outros = chkMacOS.isSelected() ? "S" : "N";
				String erro = ctrl.cadastrarProduto(Integer.valueOf(0), Double.parseDouble(txtPreco.getText()),
						Integer.valueOf(txtQuantidade.getText()), compatWindows, compatLinux, compatMac, outros,
						String.valueOf(txtProduto.getText()), String.valueOf(txtCadastroDescricao.getText()),
						cbModelo.getSelectedItem().toString(), cbSlot.getSelectedItem().toString(),
						cbCategoria.getSelectedItem().toString());
				JOptionPane.showMessageDialog(null, erro);
			}
		});
		btnSalvar.setBounds(95, 283, 89, 23);
		pnlCadastro.add(btnSalvar);

		btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo = Integer.parseInt(txtCodigo.getText());;
				try{
					if(codigo > 0)
						codigo = Integer.parseInt(txtCodigo.getText());
				}catch (Exception er) {
					JOptionPane.showMessageDialog(null, "Código digitado inválido");
					return;
				}
				exluirProduto(codigo);
			}

		});
		btnExcluir.setBounds(270, 283, 89, 23);
		pnlCadastro.add(btnExcluir);

		JButton btnCadastroPesquisarCod = new JButton("Pesquisar");
		btnCadastroPesquisarCod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int codigo = -1;
				try {
					if(!txtCodigo.getText().equals(""))
						codigo = Integer.parseInt(txtCodigo.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Código informado inválido.");
					return;
				}
				buscarProduto(codigo, txtProduto.getText());
			}
		});
		btnCadastroPesquisarCod.setBounds(251, 7, 108, 23);
		pnlCadastro.add(btnCadastroPesquisarCod);

		txtCadastroDescricao = new JTextField();
		txtCadastroDescricao.setBounds(95, 108, 264, 164);
		pnlCadastro.add(txtCadastroDescricao);
		txtCadastroDescricao.setColumns(10);

		txtPreco = new JTextField();
		txtPreco.setBounds(95, 58, 134, 20);
		pnlCadastro.add(txtPreco);
		txtPreco.setColumns(10);

		JPanel pnlVendas = new JPanel();
		tabbedPane.addTab("Vendas", null, pnlVendas, null);
		pnlVendas.setLayout(null);

		JPanel pnlProduto = new JPanel();
		pnlProduto.setBorder(new TitledBorder(null, "Produto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlProduto.setBounds(10, 11, 527, 153);
		pnlVendas.add(pnlProduto);
		pnlProduto.setLayout(null);

		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(10, 24, 51, 14);
		pnlProduto.add(lblNewLabel);

		txtVendasCodigo = new JTextField();
		txtVendasCodigo.setBounds(59, 21, 86, 20);
		pnlProduto.add(txtVendasCodigo);
		txtVendasCodigo.setColumns(10);

		JLabel lblProduto_1 = new JLabel("Produto: ");
		lblProduto_1.setBounds(155, 24, 65, 14);
		pnlProduto.add(lblProduto_1);

		txtVendasProduto = new JTextField();
		txtVendasProduto.setBounds(202, 21, 188, 20);
		pnlProduto.add(txtVendasProduto);
		txtVendasProduto.setColumns(10);

		JButton btnVendasPesquisar = new JButton("Pesquisar");
		btnVendasPesquisar.setBounds(400, 20, 109, 23);
		pnlProduto.add(btnVendasPesquisar);

		tabelaVendas = new JTable();
		tabelaVendas.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "New column", "New column", "New column",
						"New column", "New column", "New column", "C\u00F3digo", "Produto", "Descri\u00E7\u00E3o" }));
		tabelaVendas.setBounds(10, 54, 499, 88);
		pnlProduto.add(tabelaVendas);

		JPanel pnlItensVendas = new JPanel();
		pnlItensVendas.setBorder(
				new TitledBorder(null, "Itens da Venda", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlItensVendas.setBounds(10, 189, 527, 103);
		pnlVendas.add(pnlItensVendas);
		pnlItensVendas.setLayout(null);

		tabelaItensVendas = new JTable();
		tabelaItensVendas.setBounds(10, 21, 499, 72);
		pnlItensVendas.add(tabelaItensVendas);

		JButton btnVendasFinalizar = new JButton("Finalizar Venda");
		btnVendasFinalizar.setBounds(413, 293, 106, 23);
		pnlVendas.add(btnVendasFinalizar);

		JButton btnVendasAdicionar = new JButton("Adicionar");
		btnVendasAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnVendasAdicionar.setBounds(413, 164, 106, 23);
		pnlVendas.add(btnVendasAdicionar);

		JPanel pnlRelatorios = new JPanel();
		tabbedPane.addTab("Relat\u00F3rios", null, pnlRelatorios, null);
		pnlRelatorios.setLayout(null);

		JButton btnRelatorioVendas = new JButton("Relat\u00F3rio de Vendas");
		btnRelatorioVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRelatorioVendas.setBounds(10, 11, 164, 23);
		pnlRelatorios.add(btnRelatorioVendas);

		JButton btnRelatorioClientes = new JButton("Relat\u00F3rio de Clientes");
		btnRelatorioClientes.setBounds(184, 11, 164, 23);
		pnlRelatorios.add(btnRelatorioClientes);

		JButton button = new JButton("Relat\u00F3rio de Clientes");
		button.setBounds(358, 11, 164, 23);
		pnlRelatorios.add(button);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(473, 426, 89, 23);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frmPiEstoque.getContentPane().add(btnSair);
	}
}