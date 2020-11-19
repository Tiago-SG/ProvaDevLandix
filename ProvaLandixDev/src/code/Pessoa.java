package code;

public abstract class Pessoa {
	private int codigo;
	private String nome;

	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pessoa find(int codigo) {
		if(codigo<100) {
		for(Pessoa p : Dados.getDadosVendedor()) {
			if (p.getCodigo() == codigo) {
				return p;
			}
		}
		}else {
		for(Pessoa p : Dados.getDadosCliente()) {
			if(p.getCodigo() == codigo) {
				return p;
			}
		}
		}
		return null;
	}
}