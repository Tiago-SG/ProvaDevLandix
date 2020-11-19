package view;

import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import code.Adapter;
import code.Dados;
import code.Vendedor;
import code.Events;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButtonMenuItem;

public class ViewCadastroVendedor extends Events{

	JFrame frame;
	private JTextField txtNome;
	private JTextField txtCodigo;
	private JTextField txtPreco;
	private JTextField txtDdmmaaaa;
	private JFormattedTextField dateField;
	private Object btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewCadastroVendedor window = new ViewCadastroVendedor();
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
	public ViewCadastroVendedor() {
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
		
		JComboBox vendedores = new JComboBox();
		vendedores.addItem("00,Criar Vendedor");
		for (Vendedor vend : Dados.getDadosVendedor()) {
			vendedores.addItem(vend.getCodigo()+","+vend.getNome());
		}
		vendedores.setBounds(81, 50, 244, 20);
		frame.getContentPane().add(vendedores);
		vendedores.addItemListener(this);
		
		JLabel lblEscolhaUmVendedor = new JLabel("Escolha um vendedor para editar ou clique em");
		lblEscolhaUmVendedor.setBounds(94, 11, 267, 14);
		frame.getContentPane().add(lblEscolhaUmVendedor);
		
		JLabel lblcadastrarVendedorPara = new JLabel("\"Cadastrar vendedor\" para cadastrar um novo vendedor.");
		lblcadastrarVendedorPara.setBounds(71, 25, 324, 14);
		frame.getContentPane().add(lblcadastrarVendedorPara);
		
		txtNome = new JTextField();
		txtNome.setBounds(131, 102, 279, 20);
		frame.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(18, 102, 86, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel();
		lblCodigo.setBounds(33, 81, 46, 14);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblNome = new JLabel();
		lblNome.setBounds(183, 81, 46, 14);
		frame.getContentPane().add(lblNome);
		
		txtPreco = new JTextField();
		txtPreco.setBounds(18, 145, 111, 20);
		frame.getContentPane().add(txtPreco);
		txtPreco.setColumns(10);
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		dateField = new JFormattedTextField(format);
		dateField.setText("dd/mm/aaaa");
		dateField.setBounds(163, 145, 133, 20);
		frame.getContentPane().add(dateField);
		dateField.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setBounds(163, 127, 133, 14);
		frame.getContentPane().add(lblDataDeNascimento);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(40, 178, 89, 23);
		frame.getContentPane().add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setVisible(true);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cod.equals("00")) {
					JOptionPane.showMessageDialog(null, "Escolha um vendedor para excluir");
				}else {
					int excluir = JOptionPane.showConfirmDialog(null,"quer mesmo deletar esse Vendedor?","Remove Vendedor",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
					if (excluir == JOptionPane.YES_OPTION) {
						String apaga = Dados.getVend(Integer.parseInt(cod)).getCodigo()+","+Dados.getVend(Integer.parseInt(cod)).getNome();
						vendedores.removeItem(apaga);
					}
				}
			}
		});
		btnExcluir.setBounds(40, 212, 89, 23);
		frame.getContentPane().add(btnExcluir);
		
		JButton btnGerenciarClientes = new JButton("Gerenciar Clientes");
		btnGerenciarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Botão funcionando");
				ViewCadastroCliente cc = new ViewCadastroCliente();
				cc.initialize();
				cc.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnGerenciarClientes.setBounds(222, 178, 188, 23);
		frame.getContentPane().add(btnGerenciarClientes);
		
		JLabel lblCodigoVendedor = new JLabel("Codigo Vendedor");
		lblCodigoVendedor.setBounds(18, 81, 97, 14);
		frame.getContentPane().add(lblCodigoVendedor);
		
		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setBounds(131, 81, 46, 14);
		frame.getContentPane().add(lblNome_1);
		
		JLabel lblCodTabelaDe = new JLabel("Cod. tab. Preços");
		lblCodTabelaDe.setBounds(18, 127, 111, 14);
		frame.getContentPane().add(lblCodTabelaDe);
		
		JButton btnMenuInicial = new JButton("Menu inicial");
		btnMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewMenu vm = new viewMenu();
				vm.initialize();
				vm.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnMenuInicial.setBounds(222, 212, 188, 23);
		frame.getContentPane().add(btnMenuInicial);
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				Dados.criarVendedor(Integer.parseInt(txtCodigo.getText()),
						txtNome.getText(),
						Integer.parseInt(txtPreco.getText()),
						txtDdmmaaaa.getText());
				System.out.println(Integer.parseInt(txtCodigo.getText()));
				System.out.println(txtNome.getText());
				System.out.println(Integer.parseInt(txtPreco.getText()));
				System.out.println(txtDdmmaaaa.getText());
				*/
				String novo = txtCodigo.getText() + "," + txtNome.getText();
				vendedores.addItem(novo);
				JOptionPane.showMessageDialog(null, "Vendedor adicionado com sucesso.");
			}
		});
			
		}
	
	String cod = "00";
	public void itemStateChanged(ItemEvent eventoItem){
		String[] op = (eventoItem.getItem() + "").split(",");
		if(op[0].equals("00")) {
			cod = "00";
			this.txtCodigo.setEditable(true);
			this.txtCodigo.setText("");
			this.txtNome.setText("");
			this.txtPreco.setText("");
			this.dateField.setText("dd/mm/aaaa");
			
		} else {
			cod = op[0];
			Vendedor v = Dados.getVend(Integer.parseInt(op[0]));
			this.txtCodigo.setEditable(false);
			this.txtCodigo.setText(op[0]);
			this.txtNome.setText(v.getNome());
			this.txtPreco.setText(v.getCodPrecos()+"");
			this.dateField.setText(v.getNascimento()+"");
		}
		
	}
} 

