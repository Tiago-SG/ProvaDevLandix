package code;

import java.util.ArrayList;

public class Dados {
	
	ArrayList<Vendedor> vendedores;
	ArrayList<Cliente> clientes;
	
	public static ArrayList<Vendedor> getDadosVendedor() {
		ArrayList<Vendedor> vendedores = new ArrayList<>();
		vendedores.add(new Vendedor(1,"João Ferreira",5674,"22/09/1995"));
		vendedores.add(new Vendedor(2,"Marcela Jesus",3611,"12/01/2000"));
		vendedores.add(new Vendedor(3,"Ana Lucia",8901,"12/04/1980"));
		vendedores.add(new Vendedor(4,"Arlindo Nogueira",3434,"30/05/1988"));

		return vendedores;
	}
	
	public static Vendedor getVend(int codigo){
		for (Vendedor vend : Dados.getDadosVendedor()) {
			if (vend.getCodigo() == codigo){
				return vend;					
			}
		}
		return null;
	}
	
	public static ArrayList<Cliente> getDadosCliente() {
		ArrayList<Cliente> clientes = new ArrayList<>();
		clientes.add(new Cliente(101,"Maria Antonia", "PF",2000,1));
		clientes.add(new Cliente(102,"Ednaldo Cesar", "PF",60000,4));
		clientes.add(new Cliente(103,"Marcos Guilherme", "PF",1000,2));
		clientes.add(new Cliente(104,"MegaLed", "PJ",5000,2));
		clientes.add(new Cliente(105,"EuroPaes", "PJ",10000,2));
		clientes.add(new Cliente(106,"Carlos Terra", "PF",1590,1));
		clientes.add(new Cliente(107,"Casa Grande Construtora", "PJ",50000,3));
		
		return clientes;
		
	}
	public static Cliente getCli(int codigo){
		for (Cliente cli : Dados.getDadosCliente()) {
			if (cli.getCodigo() == codigo){
				return cli;					
			}
		}
		return null;
	}
	
	public void apagarVendedor(int index) {
		this.getDadosVendedor().remove(index);
	}
	public static void criarVendedor(int codigo, String nome, int codPrecos, String data) {
		getDadosVendedor().add(new Vendedor(codigo,nome,codPrecos,data));
	}
	public void apagarCliente(int index) {
		this.getDadosCliente().remove(index);
	}
	public void criarCliente(int codigo, String nome, String tipo, double limite, int codVen) {
		this.getDadosCliente().add(new Cliente(codigo,nome,tipo,limite,codVen));
	}


}
