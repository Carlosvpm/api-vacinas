package Controle;

/**
 * @author Isaque V�ras
 *
 */ 
public class Main {
	public static void main(String[] args) {
		//int populacao = 10;
		Aplicacao app = new Aplicacao(0);
		
		// Criando pessoas
		Pessoa p1 = new Pessoa("Isaque V�ras", 41, "Tejubana");
		Pessoa p2 = new Pessoa("Ismael V�ras", 45, "Centro");
		Pessoa p3 = new Pessoa("Davi V�ras", 17, "Iracema");
		Pessoa p4 = new Pessoa("Rebeca V�ras", 13, "Tejubana");
		Pessoa p5 = new Pessoa("Murilo Pinheiro", 5, "Tejubana");
		
		// Adicionar uma pessoa na cidade
		app.addPessoa(p1);
		app.addPessoa(p2);
		app.addPessoa(p3);
		app.addPessoa(p4);
		app.addPessoa(p5);
		
		app.listarPessoas();
		
		// 1� Vacina
		Vacina va = new Vacina(app.getQtdPopulacao());
		va.setQtdVacinas(2);
		va.setNome("Pfizer");
		va.setDescricao("Vacina contra o corona");
		va.setfaixaEtariaInicio(10);
		va.setfaixaEtariaFim(20);
		app.adicionarVacina(va);
		
		// 2� Vacina
		Vacina va1 = new Vacina(app.getQtdPopulacao());
		va1.setQtdVacinas(10);
		va1.setNome("Coronav");
		va1.setDescricao("Vacina contra o corona");
		va1.setfaixaEtariaInicio(40);
		va1.setfaixaEtariaFim(60);
		app.adicionarVacina(va1);
		
		// 3� Vacina
		Vacina va2 = new Vacina(app.getQtdPopulacao());
		va2.setQtdVacinas(20);
		va2.setNome("Cripe");
		va2.setDescricao("Vacina contra a gripe");
		va2.setfaixaEtariaInicio(1);
		va2.setfaixaEtariaFim(60);
		
		app.adicionarVacina(va2);
		app.listarVacinas();
		
		// Passando a pessoa e a vacina
		va.vacinar(p1, va1); 	// Vacinar uma pessoa em espec�fico
		va.vacinar(p2, va1); 	// Vacinar uma pessoa em espec�fico
		va.vacinar(p3, va); 	// Vacinar uma pessoa em espec�fico
		va.vacinar(p4, va); 	// Vacinar uma pessoa em espec�fico
		va.vacinar(p1, va1);	// Vacinar uma pessoa em espec�fico
		va.vacinar(p1, va1); 	// Vacinar uma pessoa em espec�fico
		
		Vacina vacina = new Vacina(app.getQtdPopulacao());
		vacina.setQtdVacinas(44);
		vacina.setNome("Isaque");
		vacina.setDescricao("Vacina contra o isaque");
		vacina.setfaixaEtariaInicio(44);
		vacina.setfaixaEtariaFim(45);
		
		app.editarVacina(2, vacina);
		app.listarVacinas();

		app.getPainelDadosVacina(1);
		app.getPainelDadosVacina(2);
		app.getPainelDadosVacina(3);
	}
}
