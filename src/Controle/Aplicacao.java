package Controle;

import java.util.ArrayList;

/**
 * @author Isaque V�ras
 */
public class Aplicacao {
	private int qtdPopulacao = 0;
	private ArrayList<Vacina> vacinas;
	private ArrayList<Pessoa> pessoas;
	 
	Vacina va = null;
	
	public Aplicacao(int qtdPopulacao) {
		vacinas = new ArrayList<Vacina>();
		pessoas = new ArrayList<Pessoa>();
		this.qtdPopulacao = qtdPopulacao;
	}
	
	public void adicionarVacina(Vacina vacina) {
		vacinas.add(vacina);
	}
	
	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
		setQtdPopulacao(getQtdPopulacao() + 1);
	}
	
	public void listarVacinas() {
		System.out.println("-> Vacinas");
		for (Vacina vacina : vacinas) 
			if(vacina instanceof Vacina) System.out.println("Nome: " +((Vacina) vacina).getNome() + "\t| Descri��o: " + ((Vacina) vacina).getDescricao() + "\t| Quantidade: " + ((Vacina) vacina).getQtdVacinas() + " \t| Faixa Et�ria: " + ((Vacina) vacina).getfaixaEtariaInicio() + " � " + ((Vacina) vacina).getfaixaEtariaFim());
	}
	
	public void listarPessoas() {
		System.out.println("-> "+ pessoas.size() +" Pessoas (Popula��o)");
		for (Pessoa pessoa : pessoas) 
			if(pessoa instanceof Pessoa) System.out.println("Nome: " + ((Pessoa) pessoa).getNome() + "\t| Idade: " + ((Pessoa) pessoa).getIdade() + " \t| Bairro: " + ((Pessoa) pessoa).getBairro());
	}
	
	public int getQtdPopulacao() {
		return this.qtdPopulacao;
	}
	
	public void setQtdPopulacao(int qtd) {
		this.qtdPopulacao = qtd;
	}
}
