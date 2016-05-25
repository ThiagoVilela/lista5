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
	//M�todo Inclui Aluno-------------------------------------------------------------------------------------------------------
	public void incluirAluno(){	
		this.bd.getAlunos().add(this.montaAluno());
		//System.out.println(this.bd.getAlunos().get(0));
	}
	
	//M�todos Inclui Aluno - Monta o objeto a ser adicionado
	public Aluno montaAluno(){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o n�mero de matr�cula: ");
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
	
	//M�todo Inclui Aluno - Converte a data formatada pro tipo gen�rico
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
	
	//M�todo Inclui Aluno - Recebe a data digitada pelo usu�rio
	public String recebeData(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o dia do nascimento: ");
		int dia = in.nextInt();
		
		System.out.println("Digite o m�s do nascimento: ");
		int mes = in.nextInt();
		
		System.out.println("Digite o ano do nascimento: ");
		int ano = in.nextInt();
		
		String dataMontada = dia + "/" + mes + "/" + ano;
		
		in.close();
		return dataMontada;	
	}
	
	//M�todo Excluir Aluno-------------------------------------------------------------------------------------------------------
	public void excluirAluno(){
		
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o n�mero de matr�cula do aluno: ");
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
			System.out.println("Aluno exclu�do com sucesso.");
		} else {
			System.out.println("Aluno n�o encontrado, portanto n�o foi poss�vel sua remo��o.");
		}
	}
	
	//M�todo Listar Aluno--------------------------------------------------------------------------------------------------------
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
	//M�todo Incluir Professor---------------------------------------------------------------------------------------------------
	public void incluirProfessor(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o CPF do professor: ");
		long cpf = in.nextLong();
		in.nextLine();
		
		System.out.println("Digite o nome do professor: ");
		String nome = in.nextLine();
		
		System.out.println("Este professor � Mestre ou Doutor: ");
		String tese = in.nextLine();
		
		System.out.println("Digite o sal�rio do professor: ");
		double salario = in.nextDouble();
		in.nextLine();
		
		//Fiz tudo nesse m�todo, porque n�o consegui fazer separado sem dar erro no buffer de leitura
		System.out.println("Digite o c�digo da disciplina: ");
		int codigoDisciplina = in.nextInt();
		in.nextLine();
		
		System.out.println("Digite o nome da disciplina: ");
		String nomeDisciplina = in.nextLine();
		
		System.out.println("Digite a carga hor�ria da disciplina: ");
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
	
	//M�todo Excluir Professor---------------------------------------------------------------------------------------------------
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
			System.out.println("Professor n�o encontrado!");
		} else {
			System.out.println("Erro de sistema.");
		}
		
	}
	
	//M�todo Listar Professor----------------------------------------------------------------------------------------------------
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
	//M�todo Incluir Disciplina--------------------------------------------------------------------------------------------------
	public void incluirDisciplina(){
		this.bd.getDisciplinas().add(this.montaDisciplina());
		//System.out.println(this.bd.getDisciplinas().get(0));
	}
	
	//M�todo Incluir Disciplina - Monta uma disciplina pra ser add
	public Disciplina montaDisciplina(){
		Scanner in = new Scanner(System.in);
		
		System.out.println("Digite o c�digo da disciplina: ");
		int codigoDisciplina = in.nextInt();
		in.nextLine();
		
		System.out.println("Digite o nome da disciplina: ");
		String nomeDisciplina = in.nextLine();
		
		System.out.println("Digite a carga hor�ria da disciplina: ");
		int cargaHoraria = in.nextInt();
		in.nextLine();
		in.close();
		
		Disciplina disciplina = new Disciplina(codigoDisciplina,nomeDisciplina,cargaHoraria);
		return disciplina;
	}
	
	//M�todo Excluir Disciplina--------------------------------------------------------------------------------------------------
	public void excluirDisciplina(){
		Scanner in = new Scanner(System.in);
		System.out.println("Digite o c�digo da disciplina que deseja excluir: ");
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
			System.out.println("Disciplina n�o encontrada!");
		} else {
			System.out.println("Erro de sistema.");
		}
		
	}
	
	//M�todo Lista Disciplinas---------------------------------------------------------------------------------------------------
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
		System.out.println("Digite o n�mero de matr�cula do aluno: ");
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
			System.out.println("Digite o c�digo da disciplina: ");
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
		System.out.println("Digite o n�mero de matr�cula do aluno: ");
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
			System.out.println("Digite o c�digo da disciplina: ");
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
		System.out.println("Digite o n�mero de matr�cula do aluno: ");
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
			System.out.println("Aluno n�o encontrado.");
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
			System.out.println("Professor n�o encontrado.");
		}
	}
	
	//Exibe Backup do BD
	public void exibeBackup(){
		System.out.println(this.bd.gerarBackup());
	}
	
	//M�todos Acessores
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
