package Controle;

/**
 * @author Isaque V�ras
 */
public class Vacina extends Aplicacao {
	private int qtdVacinas = 0;
	private String nome;
	private String descricao;
	 
	private int faixaEtariaInicio = 0;
	private int faixaEtariaFim = 0;
	private int porcentagemVacinados = 0;
	private int porcentagemNaoVacinados = 0;
	private int pessoasVacinadas = 0;
	private int pessoasNaoVacinadas = 0;

	public Vacina(int qtdPopulacao) {
		super(qtdPopulacao);
	}
	 
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setDescricao(String desc) {
		this.descricao = desc;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public int getQtdVacinas() {
		return this.qtdVacinas;
	}
	
	public void setQtdVacinas(int qtd) {
		this.qtdVacinas = qtd;
	}
	
	public int getPorcentagemVacinasExistente() {
		return 1;
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
	
	public void setPessoasVacinadas(Vacina vacina, int pessoas) {
		this.pessoasVacinadas = pessoas;
	}
	
	public int getPessoasNaoVacinadas() {
		pessoasNaoVacinadas = getQtdPopulacao() - getPessoasVacinadas();
		return this.pessoasNaoVacinadas;
	}
	
	public void vacinar(Pessoa pessoa, Vacina vacina) {
		if (pessoa.getIdade() >= vacina.getfaixaEtariaInicio() && pessoa.getIdade() <= vacina.getfaixaEtariaFim()) { // Para continuar, tem que se encaixar na faixa de idade!	
			/* S� pode vacinar se existir vacinas, e se o restante que falta para ser 
			 * vacinado for menor ou igual a quantidade de pessoas n�o vacinadas */
			if (vacina.getQtdVacinas() >= 1 && 1 <= vacina.getPessoasNaoVacinadas()) {
				vacina.setPessoasVacinadas(vacina, 1 + vacina.getPessoasVacinadas());
				vacina.setQtdVacinas(vacina.getQtdVacinas() - 1);
				
				System.out.println(pessoa.getNome() + " com "+ pessoa.getIdade() +" anos, foi vacinado com a vacina " + vacina.getNome());
			} else if (vacina.getQtdVacinas() == 0) {
				System.out.println("fail: n�o � poss�vel vacinar " + pessoa.getNome() + ", pois n�o tem vacina dispon�vel");
			}else {
				//vacina.setPessoasVacinadas(vacina, 1 + vacina.getPessoasVacinadas());
				System.out.println("fail: n�o � poss�vel vacinar " + pessoa.getNome() + ", pois n�o tem vacina dispon�vel");
			}
		} else {
			System.out.println("fail: n�o � poss�vel vacinar, a idade de "+ pessoa.getNome() +" n�o se encaixa dentro da faixa et�ria!");
		}
	}
	
	public void getPainelDados() {
		System.out.println("\n--------------------------------------------------------------------------");
		System.out.println("---> Vacina "+ getNome() + "\t | Faixa et�ria: " + getfaixaEtariaInicio() + " anos � "+ getfaixaEtariaFim() + " anos");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Total de Vacinas:\t" + getQtdVacinas() + "\t| Popula��o:\t\t\t" + getQtdPopulacao());
		System.out.println("Pessoas vacinadas:\t" + getPessoasVacinadas() + "\t| Pessoas n�o vacinadas:\t" + getPessoasNaoVacinadas());
		System.out.println("Vacinados:\t\t" + getPorcengemVacinados() + "%" + "\t| N�o vacinados:\t\t" + getPorcengemNaoVacinados() + "%");
		System.out.println("--------------------------------------------------------------------------");
	}
}
