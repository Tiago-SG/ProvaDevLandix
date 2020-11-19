package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import code.Cliente;
import code.Dados;
import code.Events;
import code.Vendedor;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class ViewCadastroCliente{

	JFrame frame;
	public JTextField txtCod;
	public JTextField txtNome;
	public String cod = "000";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroCliente window = new ViewCadastroCliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewCadastroCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox clientes = new JComboBox();
		clientes.addItem("000, Cadastrar Cliente");
		for (Cliente c : Dados.getDadosCliente()) {
			clientes.addItem(c.getCodigo()+","+c.getNome());
		}
		clientes.setBounds(10, 51, 235, 20);
		frame.getContentPane().add(clientes);
		
		
		JLabel lblEscolhaUmCliente = new JLabel("Escolha um cliente para editar ou clique em");
		lblEscolhaUmCliente.setBounds(68, 11, 261, 14);
		frame.getContentPane().add(lblEscolhaUmCliente);
		
		JLabel lblcadastrarClientePara = new JLabel("\"Cadastrar cliente\" para cadastrar um novo cliente");
		lblcadastrarClientePara.setBounds(56, 25, 302, 14);
		frame.getContentPane().add(lblcadastrarClientePara);
		
		JLabel lblCodigoCliente = new JLabel("Codigo Cliente");
		lblCodigoCliente.setBounds(20, 82, 86, 14);
		frame.getContentPane().add(lblCodigoCliente);
		
		txtCod = new JTextField();
		txtCod.setBounds(20, 98, 86, 20);
		frame.getContentPane().add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(150, 82, 46, 14);
		frame.getContentPane().add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(150, 98, 256, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblTipoDePessoa = new JLabel("Tipo de Pessoa");
		lblTipoDePessoa.setBounds(20, 129, 109, 14);
		frame.getContentPane().add(lblTipoDePessoa);
		
		
		
		JRadioButton rdbtnPessoaJuridica = new JRadioButton("Pessoa Jurídica");
		rdbtnPessoaJuridica.setBounds(20, 172, 124, 23);
		frame.getContentPane().add(rdbtnPessoaJuridica);
		
		JLabel lblLimiteDeCrdito = new JLabel("Limite de cr\u00E9dito");
		lblLimiteDeCrdito.setBounds(150, 129, 95, 14);
		frame.getContentPane().add(lblLimiteDeCrdito);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(150, 154, 95, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblVendedor = new JLabel("Vendedor");
		lblVendedor.setBounds(268, 129, 77, 14);
		frame.getContentPane().add(lblVendedor);
		
		JComboBox vendedores = new JComboBox();
		vendedores.setBounds(268, 154, 138, 20);
		for (Vendedor vend : Dados.getDadosVendedor()) {
			vendedores.addItem(vend.getCodigo()+","+vend.getNome());
		}
		vendedores.setSelectedItem(null);
		frame.getContentPane().add(vendedores);
		
		JRadioButton rdbtnPessoaFsica = new JRadioButton("Pessoa F\u00EDsica");
		rdbtnPessoaFsica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPessoaFsica.isSelected()) {
				rdbtnPessoaJuridica.setSelected(false);;
				}
			}
		});
		rdbtnPessoaJuridica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnPessoaJuridica.isSelected()) {
					rdbtnPessoaFsica.setSelected(false);
				}
			}
		});
		rdbtnPessoaFsica.setBounds(20, 150, 109, 23);
		frame.getContentPane().add(rdbtnPessoaFsica);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String novo = txtCod.getText()+","+txtNome.getText();
				clientes.addItem(novo);
				JOptionPane.showMessageDialog(null, "Cliente Adicionado");
			}
		});
		btnSalvar.setBounds(10, 204, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cod.equals("000")) {
					JOptionPane.showMessageDialog(null, "Escolha um cliente para excluir");
				}else {
					int excluir = JOptionPane.showConfirmDialog(null,"quer mesmo deletar esse Cliente?","Remove Cliente",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if (excluir == JOptionPane.YES_OPTION) {
						String apaga = Dados.getCli(Integer.parseInt(cod)).getCodigo()+","+Dados.getCli(Integer.parseInt(cod)).getNome();
						clientes.removeItem(apaga);
					}
				}
			}
		});
		btnExcluir.setBounds(109, 204, 89, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnGerenciarVendedores = new JButton("Gerenciar Vendedores");
		btnGerenciarVendedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroVendedor cv = new ViewCadastroVendedor();
				cv.initialize();
				cv.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnGerenciarVendedores.setBounds(235, 185, 171, 23);
		frame.getContentPane().add(btnGerenciarVendedores);
		
		JButton btnMenuInicial = new JButton("Menu Inicial");
		btnMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewMenu vm = new viewMenu();
				vm.initialize();
				vm.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnMenuInicial.setBounds(235, 228, 171, 23);
		frame.getContentPane().add(btnMenuInicial);	
		
;
		clientes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String[] op = (e.getItem() + "").split(",");
				if(op[0].equals("000")) {
					cod = "000";
					txtCod.setEditable(true);
					txtCod.setText("");
					txtNome.setText("");
					rdbtnPessoaFsica.setSelected(false);
					rdbtnPessoaJuridica.setSelected(false);
					spinner.setValue(0);
				}else {
					cod = op[0];
					Cliente c = Dados.getCli(Integer.parseInt(op[0]));
					txtCod.setEditable(false);
					txtCod.setText(c.getCodigo()+"");
					txtNome.setText(c.getNome());
					if(c.getTipoPessoa().equals("PJ")) {
						rdbtnPessoaJuridica.setSelected(true);
						rdbtnPessoaFsica.setSelected(false);
					}else {
						rdbtnPessoaFsica.setSelected(true);
						rdbtnPessoaJuridica.setSelected(false);
					}
					spinner.setValue(c.getLimiteCredito());
					vendedores.setSelectedItem(c.getVendedor()+","+Dados.getVend(c.getVendedor()).getNome());
					System.out.println(c.getVendedor()+","+Dados.getVend(c.getVendedor()).getNome());
				}
			}
		});
					
	}
}
