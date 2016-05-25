package entidades;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class Teste {

	public static void main(String[] args) {
		
		Calendar d = Calendar.getInstance();
		System.out.println("Data/Hora atual: "+d.getTime()); 
		System.out.println("Ano: "+d.get(Calendar.YEAR)); 
		System.out.println("Mês: "+d.get(Calendar.MONTH)); 
		System.out.println("Dia do Mês: "+d.get(Calendar.DAY_OF_MONTH));
		
		Calendar c = Calendar.getInstance(); 
		c.set(2013, Calendar.FEBRUARY, 28); 
		Date data = c.getTime(); System.out.println("Data atual sem formatação: "+data); 
		//Formata a data 
		DateFormat formataData = DateFormat.getDateInstance(); 
		System.out.println("Data atual com formatação: "+ formataData.format(data)); 
		//Formata Hora 
		DateFormat hora = DateFormat.getTimeInstance(); 
		System.out.println("Hora formatada: "+hora.format(data)); 
		//Formata Data e Hora 
		DateFormat dtHora = DateFormat.getDateTimeInstance(); 
		System.out.println(dtHora.format(data));
		
		//ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		Date testando = new Date();
		System.out.println("VALENDO! " + testando);
		//alunos.add(2012,"Thiago",testando);
		
		
		
		
		
		//Teste
		StringBuilder cabecalho = new StringBuilder("Backup realizado em ");
		
		Calendar dataAtual = Calendar.getInstance();
		cabecalho.append(dataAtual.get(Calendar.DAY_OF_MONTH) + " de ");
		
		switch (dataAtual.get(Calendar.MONTH)) {
			case 1: cabecalho.append("Janeiro de ");break;
			case 2: cabecalho.append("Fevereiro de ");break;
			case 3: cabecalho.append("Março de ");break;
			case 4: cabecalho.append("Abril de ");break;
			case 5: cabecalho.append("Maio de ");break;
			case 6: cabecalho.append("Junho de ");break;
			case 7: cabecalho.append("Julho de ");break;
			case 8: cabecalho.append("Agosto de ");break;
			case 9: cabecalho.append("Setembro de ");break;
			case 10: cabecalho.append("Outubro de ");break;
			case 11: cabecalho.append("Novembro de ");break;
			case 12: cabecalho.append("Dezembro de ");break;
			default: cabecalho.append("Erro mês de ");break;
		}
		
		cabecalho.append(dataAtual.get(Calendar.YEAR) + " às ");
		
		Date asd = dataAtual.getTime();
		DateFormat horaAtual = DateFormat.getTimeInstance();
		cabecalho.append(horaAtual.format(asd));
		
		System.out.println(cabecalho.toString());
	}
}