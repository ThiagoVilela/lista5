package entidades;

public class Matricula {
	//Atributos
	private int pontuacao;
	
	//Relações
	private Aluno aluno;
	private Disciplina disciplina;
	
	//Construtores
	public Matricula(Aluno aluno, Disciplina disciplina){
		this.pontuacao = -1;
		this.aluno = aluno;
		this.disciplina = disciplina;
	}
	
	public Matricula(int pontuacao, Aluno aluno, Disciplina disciplina){
		this.pontuacao = pontuacao;
		this.aluno = aluno;
		this.disciplina = disciplina;
	}
	
	//Métodos
	@Override
	public String toString(){
		return "\nMatricula do aluno: " + aluno.getNome() + "\nNúmero de Matrícula: " + aluno.getMatricula() +
				"\nDiscplina: " + disciplina.getNome() + "\nCódigo: " + disciplina.getCodigo();
	}

	//Métodos Acessores
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		if (pontuacao >= 0 && pontuacao <= 100) {
			this.pontuacao = pontuacao;
		} else {
			System.out.println("Pontuação inválida.");
		}
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
