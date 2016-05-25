package entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Aplicacao {
	//Atributos
	private BD bd = new BD();
	//------------------------------------------------Aluno---------------------------------------------------------------------
	//Método Inclui Aluno-------------------------------------------------------------------------------------------------------
	public void incluirAluno(){	
		this.bd.getAlunos().add(this.montaAluno());
		//System.out.println(this.bd.getAlunos().get(0));
	}
	
	//Métodos Inclui Aluno - Monta o objeto a ser adicionado
	public Aluno montaAluno(){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o número de matrícula: ");
		int matricula = in.nextInt();
		in.nextLine();
		
		System.out.println("Digite o nome do aluno: ");
		String nome = in.nextLine();
		
		Date dataNascimento = this.montaData();
		
		in.close();
		
		Aluno aluno = new Aluno(matricula, nome, dataNascimento);
		System.out.println("Sucesso criando aluno!");
		return aluno;
	}
	
	//Método Inclui Aluno - Converte a data formatada pro tipo genérico
	public Date montaData(){
		String dataFinal = recebeData();
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			
			Date date = data.parse(dataFinal);
			return date;
			
		} catch (ParseException e) {
			
			e.printStackTrace();
			return null;
			
		}
	}
	
	//Método Inclui Aluno - Recebe a data digitada pelo usuário
	public String recebeData(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o dia do nascimento: ");
		int dia = in.nextInt();
		
		System.out.println("Digite o mês do nascimento: ");
		int mes = in.nextInt();
		
		System.out.println("Digite o ano do nascimento: ");
		int ano = in.nextInt();
		
		String dataMontada = dia + "/" + mes + "/" + ano;
		
		in.close();
		return dataMontada;	
	}
	
	//Método Excluir Aluno-------------------------------------------------------------------------------------------------------
	public void excluirAluno(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o número de matrícula do aluno: ");
		int matriculaAluno = in.nextInt();
		in.close();
		
		boolean encontrou = false;
		
		for (int i = 0; i < this.bd.getAlunos().size(); i++) {
			
			if ( matriculaAluno == this.bd.getAlunos().get(i).getMatricula() ) {
				this.bd.getAlunos().remove(this.bd.getAlunos().get(i));
				encontrou = true;
			}
		}
		
		if (encontrou == true) {
			System.out.println("Aluno excluído com sucesso.");
		} else {
			System.out.println("Aluno não encontrado, portanto não foi possível sua remoção.");
		}
	}
	
	//Método Listar Aluno--------------------------------------------------------------------------------------------------------
	public void listarAlunos(){
		
		boolean encontrou = false;
		
		for (int i = 0; i < this.bd.getAlunos().size(); i++) {
			System.out.println(this.bd.getAlunos().get(i));
			encontrou = true;
		}
		
		if (!encontrou) {
			System.out.println("Nenhum aluno cadastrado.");
		}
		
	}
	
	//------------------------------------------------Professor------------------------------------------------------------------
	//Método Incluir Professor---------------------------------------------------------------------------------------------------
	public void incluirProfessor(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o CPF do professor: ");
		long cpf = in.nextLong();
		in.nextLine();
		
		System.out.println("Digite o nome do professor: ");
		String nome = in.nextLine();
		
		System.out.println("Este professor é Mestre ou Doutor: ");
		String tese = in.nextLine();
		
		System.out.println("Digite o salário do professor: ");
		double salario = in.nextDouble();
		in.nextLine();
		
		//Fiz tudo nesse método, porque não consegui fazer separado sem dar erro no buffer de leitura
		System.out.println("Digite o código da disciplina: ");
		int codigoDisciplina = in.nextInt();
		in.nextLine();
		
		System.out.println("Digite o nome da disciplina: ");
		String nomeDisciplina = in.nextLine();
		
		System.out.println("Digite a carga horária da disciplina: ");
		int cargaHoraria = in.nextInt();
		in.nextLine();
		in.close();
		
		ArrayList<Disciplina> disciplina = new ArrayList<Disciplina>();
		Disciplina disciplinaConteudo = new Disciplina(codigoDisciplina, nomeDisciplina, cargaHoraria);
		disciplina.add(disciplinaConteudo);
		
		Professor professor = null;
		
		if(tese.equals("Mestre") || tese.equals("mestre")){
			professor = new Mestre(cpf, nome, salario, disciplina, tese);
		} else if(tese.equals("Doutor") || tese.equals("Doutor")){
			professor = new Doutor(cpf, nome, salario, disciplina, tese);
		} else {
			System.out.println("Erro ao identificar o tipo de professor!");
		}
			
		this.bd.getProfessores().add(professor);
		//System.out.println(this.bd.getProfessores().get(0));
	}
	
	//Método Excluir Professor---------------------------------------------------------------------------------------------------
	public void excluirProfessor(){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o CPF do professor que deseja excluir: ");
		long cpf = in.nextLong();
		in.close();
		
		boolean entrou = false;
		
		for (int i = 0; i < this.bd.getProfessores().size(); i++) {
			if (cpf == this.bd.getProfessores().get(i).getCpf()) {
				this.bd.getProfessores().remove(this.bd.getProfessores().get(i));
				entrou = true;
			}
		}
		
		if (entrou) {
			System.out.println("Sucesso ao excluir o professor.");
		} else if(!entrou){
			System.out.println("Professor não encontrado!");
		} else {
			System.out.println("Erro de sistema.");
		}
		
	}
	
	//Método Listar Professor----------------------------------------------------------------------------------------------------
	public void listarProfessor(){
		boolean entrou = false;
		
		for (int i = 0; i < this.bd.getProfessores().size(); i++) {
			System.out.println(this.bd.getProfessores().get(i));
			entrou = true;
		}
		
		if (!entrou) {
			System.out.println("Nenhum professor cadastrado.");
		}
	}
	
	//------------------------------------------------Disciplina-----------------------------------------------------------------
	//Método Incluir Disciplina--------------------------------------------------------------------------------------------------
	public void incluirDisciplina(){
		this.bd.getDisciplinas().add(this.montaDisciplina());
		//System.out.println(this.bd.getDisciplinas().get(0));
	}
	
	//Método Incluir Disciplina - Monta uma disciplina pra ser add
	public Disciplina montaDisciplina(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o código da disciplina: ");
		int codigoDisciplina = in.nextInt();
		in.nextLine();
		
		System.out.println("Digite o nome da disciplina: ");
		String nomeDisciplina = in.nextLine();
		
		System.out.println("Digite a carga horária da disciplina: ");
		int cargaHoraria = in.nextInt();
		in.nextLine();
		in.close();
		
		Disciplina disciplina = new Disciplina(codigoDisciplina,nomeDisciplina,cargaHoraria);
		return disciplina;
	}
	
	//Método Excluir Disciplina--------------------------------------------------------------------------------------------------
	public void excluirDisciplina(){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o código da disciplina que deseja excluir: ");
		int codigo = in.nextInt();
		in.close();
		
		boolean entrou = false;
		
		for (int i = 0; i < this.bd.getDisciplinas().size(); i++) {
			if (codigo == this.bd.getDisciplinas().get(i).getCodigo()) {
				this.bd.getDisciplinas().remove(this.bd.getDisciplinas().get(i));
				entrou = true;
			}
		}
		
		if (entrou) {
			System.out.println("Sucesso ao excluir a disciplina.");
		} else if(!entrou){
			System.out.println("Disciplina não encontrada!");
		} else {
			System.out.println("Erro de sistema.");
		}
		
	}
	
	//Método Lista Disciplinas---------------------------------------------------------------------------------------------------
	public void listarDisciplinas(){
		boolean entrou = false;
		
		for (int i = 0; i < this.bd.getDisciplinas().size(); i++) {
			System.out.println(this.bd.getDisciplinas().get(i));
			entrou = true;
		}
		
		if (!entrou) {
			System.out.println("Nenhuma disciplina cadastrada.");
		}
	}
	
	//Matricular Aluno Disciplina--------------------------------Matricula-------------------------------------------------------
	public void matricularAlunoDisciplina(){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o número de matrícula do aluno: ");
		int matriculaAluno = in.nextInt();
		in.nextLine();
		
		boolean encontrou = false;
		
		Aluno aluno = null;
		for (int i = 0; i < this.bd.getAlunos().size(); i++) {
			
			if ( matriculaAluno == this.bd.getAlunos().get(i).getMatricula() ) {
				aluno = this.bd.getAlunos().get(i);
				encontrou = true;
				break;
			}
			
		}
		
		if(encontrou){
			System.out.println("Digite o código da disciplina: ");
			int codigo = in.nextInt();
			in.nextLine();
			in.close();
			
			boolean entrou = false;
			
			Disciplina disciplina = null;
			for (int i = 0; i < this.bd.getDisciplinas().size(); i++) {
				if (codigo == this.bd.getDisciplinas().get(i).getCodigo()) {
					disciplina = this.bd.getDisciplinas().get(i);
					entrou = true;
				}
			}
			
			if(entrou){
				Matricula matricula = new Matricula(aluno,disciplina);
				this.bd.getMatriculas().add(matricula);
			} else{
				System.out.println("Erro ao encontrar a disciplina.");
			}
		} else {
			System.out.println("Erro ao encontrar aluno.");
		}
	}
	
	//Inserir Nota MATRICULA-----------------------------------------------------------------------------------------------------
	public void inserirNotaMatricula(){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o número de matrícula do aluno: ");
		int matriculaAluno = in.nextInt();
		in.nextLine();
		
		boolean encontrou = false;
		
		Aluno aluno = null;
		for (int i = 0; i < this.bd.getAlunos().size(); i++) {
			
			if ( matriculaAluno == this.bd.getAlunos().get(i).getMatricula() ) {
				aluno = this.bd.getAlunos().get(i);
				encontrou = true;
				break;
			}
			
		}
		
		if(encontrou){
			System.out.println("Digite o código da disciplina: ");
			int codigo = in.nextInt();
			in.nextLine();
			
			boolean entrou = false;
			
			Disciplina disciplina = null;
			for (int i = 0; i < this.bd.getDisciplinas().size(); i++) {
				if (codigo == this.bd.getDisciplinas().get(i).getCodigo()) {
					disciplina = this.bd.getDisciplinas().get(i);
					entrou = true;
				}
			}
			
			if(entrou){
				System.out.println("Digite a nota desejada: ");
				int nota = in.nextInt();
				in.nextLine();
				in.close();
				
				for (int i = 0; i < this.bd.getMatriculas().size(); i++) {
					if (aluno.getMatricula() == this.bd.getMatriculas().get(i).getAluno().getMatricula() && 
						disciplina.getCodigo() == this.bd.getMatriculas().get(i).getDisciplina().getCodigo()){
						
							this.bd.getMatriculas().get(i).setPontuacao(nota);
							if(nota>=0 && nota<60){
								System.out.println("Aluno Reprovado.");
							} else if(nota>= 60 && nota<=100){
								System.out.println("Aluno Aprovado.");
							} else{
								System.out.println("Erro na nota.");
							}

					}
				}
				Matricula matricula = new Matricula(aluno,disciplina);
				this.bd.getMatriculas().add(matricula);
				
			} else{
				System.out.println("Erro ao encontrar a disciplina.");
			}
		} else {
			System.out.println("Erro ao encontrar aluno.");
		}
	}

	//Exibir Disciplinas Aluno
	public void listaDisciplinasAluno(){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o número de matrícula do aluno: ");
		int matriculaAluno = in.nextInt();
		in.nextLine();
		in.close();
		
		boolean encontrou = false;
		
		for (int i = 0; i < this.bd.getAlunos().size(); i++) {
			
			if ( matriculaAluno == this.bd.getAlunos().get(i).getMatricula() ) {
				System.out.println(this.bd.getAlunos().get(i));
				encontrou = true;
				break;
			}
			
		}
		
		if (!encontrou) {
			System.out.println("Aluno não encontrado.");
		}
	}
	
	//Exibir Disciplinas Professor
	public void listaDisciplinasProfessor(){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o CPF do professor: ");
		long cpf = in.nextLong();
		in.nextLine();
		in.close();
		
		boolean encontrou = false;
		
		for (int i = 0; i < this.bd.getProfessores().size(); i++) {
			
			if ( cpf == this.bd.getProfessores().get(i).getCpf() ) {
				System.out.println(this.bd.getProfessores().get(i));
				encontrou = true;
				break;
			}
			
		}
		
		if (!encontrou) {
			System.out.println("Professor não encontrado.");
		}
	}
	
	//Exibe Backup do BD
	public void exibeBackup(){
		System.out.println(this.bd.gerarBackup());
	}
	
	//Métodos Acessores
	public BD getBd() {
		return bd;
	}

	public void setBd(BD bd) {
		this.bd = bd;
	}
	
	//Main
	public static void main(String[] args) {
		
	}
}
