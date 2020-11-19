package code;

import java.text.SimpleDateFormat;

public class Adapter {
	public static SimpleDateFormat data(String dataTxt) {
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		return data;
	}
	public static String dateString(SimpleDateFormat data) {
		SimpleDateFormat dia = new SimpleDateFormat("dd");
		SimpleDateFormat mes = new SimpleDateFormat("MM");
		SimpleDateFormat ano = new SimpleDateFormat("yyyy");
		String sd = data.format(dia)+"/"+data.format(mes)+"/"+data.format(ano);
		return sd;
	}

}
