package view;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

import code.Cliente;
import code.Dados;
import code.Vendedor;

import javax.swing.JComboBox;
import javax.swing.JList;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;

public class viewMenu implements ItemListener, ActionListener{

	JFrame frame;
	public String listaClientes = "";
	JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewMenu window = new viewMenu();
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
	public viewMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblVendedores = new JLabel("Vendedores:");
		lblVendedores.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVendedores.setBounds(168, 22, 99, 14);
		frame.getContentPane().add(lblVendedores);
		
		JComboBox vendedores = new JComboBox();
		for (Vendedor vend : Dados.getDadosVendedor()) {
			vendedores.addItem(vend.getCodigo()+","+vend.getNome());
		}
		vendedores.setSelectedItem(null);
		vendedores.setBounds(106, 47, 192, 20);
		frame.getContentPane().add(vendedores);
		vendedores.addItemListener(this);
		
		JLabel lblClientes = new JLabel("Clientes:");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblClientes.setBounds(168, 78, 71, 14);
		frame.getContentPane().add(lblClientes);
		
		JButton btnGerenciarVendedor = new JButton("Gerenciar Vendedor");
		btnGerenciarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Botão funcionando");
				ViewCadastroVendedor cv = new ViewCadastroVendedor();
				cv.initialize();
				cv.frame.setVisible(true);
				frame.setVisible(false);
				}
		});
		btnGerenciarVendedor.setBounds(26, 214, 163, 23);
		frame.getContentPane().add(btnGerenciarVendedor);
		
		JButton btnCriarCliente = new JButton("Gerenciar Cliente");
		btnCriarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewCadastroCliente cc = new ViewCadastroCliente();
				cc.initialize();
				cc.frame.setVisible(true);
				frame.setVisible(false);
			}
		});
		btnCriarCliente.setBounds(232, 214, 172, 23);
		frame.getContentPane().add(btnCriarCliente);
		
		label = new JLabel();
		label.setBounds(26, 103, 378, 28);
		frame.getContentPane().add(label);
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		String[] op = (arg0.getItem() + "").split(",");
		String s = "";
		for(Cliente c : Dados.getDadosCliente()) {
			if((c.getVendedor()+"").equals(op[0])) {
				s = s + c.getNome() +", ";
			}
		}
		label.setText(s);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	}
}

