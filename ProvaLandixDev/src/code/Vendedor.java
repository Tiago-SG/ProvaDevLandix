package code;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Vendedor extends Pessoa{
	
	private int codPrecos;
	private SimpleDateFormat nascimento;
	
	public Vendedor(int codigo, String nome, int codPrecos, String nascimento) {
		super.setCodigo(codigo);
		super.setNome(nome);
		this.setCodPrecos(codPrecos);
		this.setNascimento(nascimento);
	}
	
	public int getCodPrecos() {
		return codPrecos;
	}
	public void setCodPrecos(int codPrecos) {
		this.codPrecos = codPrecos;
	}
	public SimpleDateFormat getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = Adapter.data(nascimento);
	}
}
		
		
