package br.com.amaurymartin.anvisamedicament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.amaurymartin.anvisamedicament.services.MedicamentService;

@SpringBootApplication
public class AnvisaMedicamentApplication implements CommandLineRunner {
	
	@Autowired
	private MedicamentService medicamentService;
	
	public static void main(String[] args) {
		SpringApplication.run(AnvisaMedicamentApplication.class, args);
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		if(this.medicamentService.deleteAll()) System.out.println("\nDados deletados do Banco de Dados");
		else System.out.println("\nProblemas ao tentar deletar os dados do Banco de Dados");
		
		if(this.medicamentService.insertAll()) System.out.println("Dados inseridos no Banco de Dados\n");
		else System.out.println("Problemas ao tentar inserir os dados no Banco de Dados\n");
	}
	
}
