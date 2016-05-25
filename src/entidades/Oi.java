package entidades;

import java.util.ArrayList;
import java.util.Scanner;

public class Oi {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//Fiz tudo nesse método, porque não consegui fazer separado sem dar erro no buffer de leitura
		System.out.println("Digite o código da disciplina: ");
		int codigoDisciplina = in.nextInt();
		in.nextLine();
		
		System.out.println("Digite o nome da disciplina: ");
		String nomeDisciplina = in.nextLine();

		
		System.out.println("Digite a carga horária da disciplina: ");
		int cargaHoraria = in.nextInt();
		
		in.close();
		
		ArrayList<Disciplina> disciplina = new ArrayList<Disciplina>();
		Disciplina disciplinaConteudo = new Disciplina(codigoDisciplina, nomeDisciplina, cargaHoraria);
		disciplina.add(disciplinaConteudo);
		
		Professor professor = new Mestre(55555,"Professor Mestre", 8500, disciplina, "Mestre");
		
		ArrayList<Professor> professores = new ArrayList<Professor>();
		professores.add(professor);
		
		System.out.println(professores.get(0).getSalario());
	}
}
