package br.com.sast.test;

import java.util.List;

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
	

	@Test
	public void inserir(){
		
		Cargo cargo = new Cargo();
		
		cargo.setNome("Programmer");
		cargo.setDescricao("Teste");
		
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.inserir(cargo);
		
	}
	
	@Ignore
	@Test
	public void consultar(){
		
		CargoDAO cargoDAO = new CargoDAO();
		
		Cargo cargo = cargoDAO.consultar(1);
		
		System.out.println("Nome do cargo: " + cargo.getNome() + "\nDescricao: " + cargo.getDescricao());
		
	}//Fim do método consultar
	
	@Ignore
	@Test
    public void listar(){
		
		CargoDAO cargoDAO = new CargoDAO();

        List<Cargo> resultado = cargoDAO.listar();
        
        for(Cargo cargo : resultado){
            System.out.println(cargo);
        }
    }
	
	@Ignore
	@Test
    public void editar(){

        Integer codigo = 1;

        CargoDAO cargoDAO = new CargoDAO();

        Cargo resultado = cargoDAO.consultar(codigo);
        
        System.out.println("Objeto encontrado " + resultado);
        
        resultado.setNome("Developer");
        
        cargoDAO.editar(resultado);
        
        System.out.println("Objeto Editado: " + resultado);
    }
	
	@Ignore
    @Test
    public void excluir(){
        Integer codigo = 1;

        CargoDAO cargoDAO = new CargoDAO();
        
        Cargo resultado = cargoDAO.consultar(codigo);
        
        System.out.println("Objeto excluído " + resultado);
        
        cargoDAO.excluir(resultado);
    }
	
}
