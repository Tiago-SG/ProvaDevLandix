package code;

public class Cliente extends Pessoa {
	
	private String tipoPessoa;
	private double limiteCredito;
	private int codV;
	
	public Cliente(int codigo, String nome, String tipoPessoa, double limiteCredito, int codVendedor) {
		super.setCodigo(codigo);
		super.setNome(nome);
		this.setTipoPessoa(tipoPessoa);
		this.setLimiteCredito(limiteCredito);
		this.setVendedor(codVendedor);
	}
	
	public String getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(String tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public double getLimiteCredito() {
		return limiteCredito;
	}
	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	public int getVendedor() {
		return codV;
	}
	public void setVendedor(int codVendedor) {
		this.codV = codVendedor;
	}
}
