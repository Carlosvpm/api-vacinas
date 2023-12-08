package Controle;

import java.util.ArrayList;

public class Aplicacao {
	private int qtdPopulacao = 0;
	private int qtdTiposDeVacinas = 0;
	private int pessoasVacinadas = 0;
	private ArrayList<Vacina> vacinas;
	private ArrayList<Pessoa> pessoas;
	
	public Aplicacao(int qtdPopulacao) {
		vacinas = new ArrayList<Vacina>();
		pessoas = new ArrayList<Pessoa>();
		this.qtdPopulacao = qtdPopulacao;
	}
	
	public void adicionarVacina(Vacina vacina) {
		vacinas.add(vacina);
		setQtdTiposDeVacinas(getQtdTiposDeVacinas() + 1);
	}
	
	public void editarVacina(int index, Vacina vacina) {
		index--;
		vacinas.set(index, vacina);
		System.out.println("A vacina da " + vacina.getNome() + " foi editado com sucesso");
	}
	
	public void excluirVacina(int index) {
		index--;
		vacinas.remove(index);
		System.out.println("A vacina da " + vacinas.get(index).getNome() + " foi excluido");
	}
	
	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
		setQtdPopulacao(getQtdPopulacao() + 1);
	}
	
	public void editarPessoa(int index, Pessoa pessoa) {
		index--;
		pessoas.set(index, pessoa);
		System.out.println(pessoa.getNome() + " foi editado com sucesso");
	}
	
	public void listarVacinas() {
		int v = 1;
		System.out.println("\n-> "+ vacinas.size() +" tipos de vacinas");
		for (Vacina vacina : vacinas) 
			if(vacina instanceof Vacina) {
				System.out.println("id: "+ v +"\t| Nome: " +((Vacina) vacina).getNome() + "\t| Descri��o: " + ((Vacina) vacina).getDescricao() + "\t| Quantidade: " + ((Vacina) vacina).getQtdVacinas() + " \t| Faixa Et�ria: " + ((Vacina) vacina).getfaixaEtariaInicio() + " � " + ((Vacina) vacina).getfaixaEtariaFim());
				v++;
			}
		System.out.println("");
	}
	
	public void listarPessoas() {
		int p = 1;
		System.out.println("\n-> "+ pessoas.size() +" Pessoas (Popula��o)");
		for (Pessoa pessoa : pessoas)
			if(pessoa instanceof Pessoa) {
				System.out.println("id: "+p+" \t| Nome: " + ((Pessoa) pessoa).getNome() + "\t| Idade: " + ((Pessoa) pessoa).getIdade() + " anos \t| Bairro: " + ((Pessoa) pessoa).getBairro());
				p++;
			}
		System.out.println("");
	}
	
	public int getQtdPopulacao() {
		return this.qtdPopulacao;
	}
	
	public void setQtdPopulacao(int qtd) {
		this.qtdPopulacao = qtd;
	}
	
	public int getQtdTotalVacinas() {
		int qtd = 0, i = 0;
		for (Vacina vacina : vacinas)
			if(vacina instanceof Vacina) {
				qtd = vacinas.get(i).getQtdVacinas() + qtd;
				i++;
			}
		return qtd;
	}
	
	public int getQtdTiposDeVacinas() {
		return this.qtdTiposDeVacinas;
	}
	
	public void setQtdTiposDeVacinas(int qtd) {
		this.qtdTiposDeVacinas = qtd;
	}

	public int getPessoasVacinadas() {
		return pessoasVacinadas;
	}
	
	public void setPessoasVacinadas(int qtd) {
		this.pessoasVacinadas = qtd;
	}
	
	public void vacinar(int indexPessoa, int indexVacina) {
		indexPessoa--;
		indexVacina--;
		if (pessoas.get(indexPessoa).getIdade() >= vacinas.get(indexVacina).getfaixaEtariaInicio() && pessoas.get(indexPessoa).getIdade() <= vacinas.get(indexVacina).getfaixaEtariaFim()) { // Para continuar, tem que se encaixar na faixa de idade!	
			/* S� pode vacinar se existir vacinas, e se o restante que falta para ser 
			 * vacinado for menor ou igual a quantidade de pessoas n�o vacinadas */
			if (vacinas.get(indexVacina).getQtdVacinas() >= 1 && 1 <= vacinas.get(indexVacina).getPessoasNaoVacinadas()) {
				vacinas.get(indexVacina).setPessoasVacinadas(1 + vacinas.get(indexVacina).getPessoasVacinadas());
				vacinas.get(indexVacina).setQtdVacinas(vacinas.get(indexVacina).getQtdVacinas() - 1);
				
				setPessoasVacinadas(getPessoasVacinadas() + 1); // Incremento mais 1 para pessoas vacinadas
				
				System.out.println(pessoas.get(indexPessoa).getNome() + " com "+ pessoas.get(indexPessoa).getIdade() +" anos, foi vacinado com a vacina " + vacinas.get(indexVacina).getNome());
			} else if (vacinas.get(indexVacina).getQtdVacinas() == 0) {
				System.out.println("fail: n�o � poss�vel vacinar " + pessoas.get(indexPessoa).getNome() + ", pois n�o tem vacina dispon�vel");
			}else {
				System.out.println("fail: n�o � poss�vel vacinar " + pessoas.get(indexPessoa).getNome() + ", pois n�o tem vacina dispon�vel");
			}
		} else {
			System.out.println("fail: n�o � poss�vel vacinar, a idade de "+ pessoas.get(indexPessoa).getNome() +" n�o se encaixa dentro da faixa et�ria!");
		}
	}
	
	public void getPainelDadosVacina(int index) {
		index--; // Decrementa o index com -1, pois o arrayList come�a com 0
		
		if (vacinas.size() > index) {
			System.out.println("\n--------------------------------------------------------------------------");
			System.out.println("---> Vacina "+ vacinas.get(index).getNome() + "\t --> Faixa et�ria: " + vacinas.get(index).getfaixaEtariaInicio() + " anos � "+ vacinas.get(index).getfaixaEtariaFim() + " anos");
			System.out.println("--------------------------------------------------------------------------");
			System.out.println("Total de Vacinas:\t" + vacinas.get(index).getQtdVacinas() + "\t| Popula��o:\t\t\t" + getQtdPopulacao());
			System.out.println("Pessoas vacinadas:\t" + vacinas.get(index).getPessoasVacinadas() + "\t| Pessoas n�o vacinadas:\t" + vacinas.get(index).getPessoasNaoVacinadas());
			System.out.println("Vacinados:\t\t" + vacinas.get(index).getPorcengemVacinados() + "%" + "\t| N�o vacinados:\t\t" + vacinas.get(index).getPorcengemNaoVacinados() + "%");
			System.out.println("--------------------------------------------------------------------------");
		} else System.out.println("fail: esse painel n�o existe");
	}
	

	public void getPainelGeral() {
		System.out.println("\n--------------------------------------------------------------------------");
		System.out.println("---> Relat�rio Geral");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("---> Popula��o: "+ getQtdPopulacao() + " pessoas" + "\t---> Pessoas vacinadas: "+ getPessoasVacinadas() + " pessoas");
		System.out.println("---> Vacinas: "+ getQtdTiposDeVacinas() + " tipos" + "\t\t---> Quantidade de vacinas: "+ getQtdTotalVacinas());
		System.out.println("--------------------------------------------------------------------------");
	}
}
