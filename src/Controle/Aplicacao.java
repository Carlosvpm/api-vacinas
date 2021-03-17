package Controle;

/**
 * @author Isaque V�ras
 *
 */
public class Aplicacao extends Vacina {
	private int qtdPopulacao = 0;
	private int faixaEtariaInicio = 0;
	private int faixaEtariaFim = 0;
	private int porcentagemVacinados = 0;
	private int porcentagemNaoVacinados = 0;
	private int pessoasVacinadas = 0;
	private int pessoasNaoVacinadas = 0;
	
	public Aplicacao(int qtdVacinas) {
		setQtdVacinas(qtdVacinas);
	}
	
	public void vacinar(int qtdPessoas, int idade) {
		// Para continuar, tem que se encaixar na faixa de idade!
		if (idade >= getfaixaEtariaInicio() && idade <= getfaixaEtariaFim()) {
			
			/* S� pode vacinar se existir vacinas, e se o restante que falta para ser 
			 * vacinado for menor ou igual a quantidade de pessoas n�o vacinadas */
			if (getQtdVacinas() > 0 && qtdPessoas <= getPessoasNaoVacinadas()) {
				setPessoasVacinadas(qtdPessoas + getPessoasVacinadas());
				setQtdVacinas(getQtdVacinas() - qtdPessoas);
			} else {
				System.out.println("fail: a quantidade de pessoas informada utrapassa a quantidade de vacinas dispon�veis ");
			}
		} else {
			System.out.println("fail: n�o � poss�vel vacinar, a idade n�o se encaixa dentro da faixa et�ria!");
		}
	}

	public int getQtdPopulacao() {
		return this.qtdPopulacao;
	}
	
	public void setQtdPopulacao(int qtd) {
		this.qtdPopulacao = qtd;
	}

	public int getfaixaEtariaInicio() {
		return this.faixaEtariaInicio;
	}
	
	public void setfaixaEtariaInicio(int faixa) {
		this.faixaEtariaInicio = faixa;
	}

	public int getfaixaEtariaFim() {
		return this.faixaEtariaFim;
	}
	
	public void setfaixaEtariaFim(int faixa) {
		this.faixaEtariaFim = faixa;
	}

	public int getPorcengemVacinados() {		
		porcentagemVacinados = (100 * getPessoasVacinadas()) / getQtdPopulacao();
		return this.porcentagemVacinados;
	}
	
	public int getPorcengemNaoVacinados() {
		porcentagemNaoVacinados = 100 - getPorcengemVacinados();
		return this.porcentagemNaoVacinados;
	}
	
	public int getPessoasVacinadas() {
		return this.pessoasVacinadas;
	}
	
	public void setPessoasVacinadas(int pessoas) {
		this.pessoasVacinadas = pessoas;
	}
	
	public int getPessoasNaoVacinadas() {
		pessoasNaoVacinadas = getQtdPopulacao() - getPessoasVacinadas();
		return this.pessoasNaoVacinadas;
	}
	
	public void getPainelDados() {
		System.out.println("----------------------------- Painel -------------------------------------");
		System.out.println("\t\tFaixa et�ria: " + getfaixaEtariaInicio() + " anos � "+ getfaixaEtariaFim() + " anos");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Total de Vacinas:\t" + getQtdVacinas() + "\t| Popula��o:\t\t\t" + getQtdPopulacao());
		System.out.println("Pessoas vacinadas:\t" + getPessoasVacinadas() + "\t| Pessoas n�o vacinadas:\t" + getPessoasNaoVacinadas());
		System.out.println("Vacinados:\t\t" + getPorcengemVacinados() + "%" + "\t| N�o vacinados:\t\t" + getPorcengemNaoVacinados() + "%");
		System.out.println("--------------------------------------------------------------------------");
	}
}
