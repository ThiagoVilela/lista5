package entidades;

import java.util.ArrayList;

public class Mestre extends Professor{
	//Atributos
	private String tituloDissertacao;
	
	//Construtores
	public Mestre(long cpf, String nome, double salario, ArrayList<Disciplina> disciplinas, String tituloDissertacao) {
		super(cpf, nome, salario, disciplinas);
		this.tituloDissertacao = tituloDissertacao;
	}
	
	//M�todos
	@Override
	public String toString(){
		if (disciplinas.size() > 1) {
			StringBuilder resposta = new StringBuilder("\nProfessor: " + nome + "\nCPF: " + 
					cpf + "\nSal�rio: " + salario + "\nTitulo Dissertacao: "+ tituloDissertacao + "\nLeciona Disciplina: ");
			
			for (int i = 0; i < disciplinas.size(); i++) {
				resposta.append("\nNome: " + disciplinas.get(i).getNome());
			}
			return resposta.toString();
		} else{
			return "\nProfessor: " + nome + "\nCPF: " + cpf + "\nSal�rio: " + salario + 
					"\nTitulo Dissertacao: "+ tituloDissertacao + "\nLeciona Disciplina: " + disciplinas.get(0).getNome();
		}
	}

	//M�todos Acessores
	public String getTituloDissertacao() {
		return tituloDissertacao;
	}

	public void setTituloDissertacao(String tituloDissertacao) {
		this.tituloDissertacao = tituloDissertacao;
	}
	
	
}
