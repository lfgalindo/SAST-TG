package br.com.sast.test;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sast.dao.CargoDAO;
import br.com.sast.domain.Cargo;

/**
 * Classe definida para para testar os métodos da classe CargoDAO.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 01/09/2016
 */

public class CargoDAOTest {
	
	@Ignore
	@Test
	public void inserir(){
		
		Cargo cargo = new Cargo();
		
		cargo.setNome("Programmer");
		cargo.setDescricao("Teste");
		
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.inserir(cargo);
		
	}
	
	@Test
	public void consultar(){
		
		CargoDAO cargoDAO = new CargoDAO();
		
		Cargo cargo = cargoDAO.consultar(1);
		
		System.out.println("Nome do cargo: " + cargo.getNome() + "\nDescricao: " + cargo.getDescricao());
		
	}//Fim do método consultar
	
}
