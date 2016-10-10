package br.com.sast.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sast.dao.CargoDAO;
import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Cargo;
import br.com.sast.domain.Funcionario;
import br.com.sast.domain.Perfil;

/**
 * Classe definida para para testar os métodos da classe FuncionarioDAO.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 10/10/2016
 */

public class FuncionarioDAOTest {
		
		@Ignore
		@Test
		public void inserir(){
			
			Funcionario func = new Funcionario();
			
			PerfilDAO perfilDAO = new PerfilDAO();
			
			Perfil perfil = perfilDAO.buscar(1);
			
			CargoDAO cargoDAO = new CargoDAO();
			
			Cargo cargo = cargoDAO.consultar(2);
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			
			func.setBairro("Vila Santa Tereza");
			func.setCidade("Chavantes");
			func.setComplemento("Casa");
			func.setCpf("44568786819");
			func.setDataAdmissao(new Date());
			func.setDataDemissao(null);
			func.setEmail("guihms1@gmail.com");
			func.setEndereco("Rua José de Souza Carvalho");
			func.setEstadoCivil("Solteiro");
			func.setFormacao("Técnico em Informática.");
			func.setEstado("SP");
			func.setLogin("guihms1");
			func.setNascimento(new Date());
			func.setNumero("06");
			func.setRg("469823732");
			func.setSenha("senha");
			func.setTelefone("996440052");
			func.setNome("Luís Guilherme Fernandes Ferreira");
			func.setCodigoPerfil(perfil);
			func.setCodigoCargo(cargo);
			
			funcionarioDAO.inserir(func);
			
		}//Fim do método incluir
		
		@Ignore
		@Test
		public void consultar(){
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			
			Funcionario funcionario = funcionarioDAO.consultar(13);
			
			System.out.println("Nome do cliente: " + funcionario.getNome() + "\nTelefone: " + funcionario.getTelefone());
			
		}//Fim do método consultar
		
		@Ignore
		@Test
	    public void listar(){
			
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	        List<Funcionario> resultado = funcionarioDAO.listar();
	        
	        for(Funcionario funcionario : resultado){
	            System.out.println(funcionario);
	        }
	    }
		
		@Test
	    public void editar(){

	        Integer codigo = 14;

	        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

	        Funcionario resultado = funcionarioDAO.consultar(codigo);
	        
	        System.out.println("Funcionario encontrado " + resultado);
	        
	        resultado.setNome("LUIZINHO GALINDO");
	        
	        funcionarioDAO.editar(resultado);
	        
	        System.out.println("Funcionario Editado: " + resultado);
	    }
		
}
