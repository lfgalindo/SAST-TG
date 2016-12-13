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
 * @since 06/11/2016
 */

public class FuncionarioDAOTest {
	
	@Ignore
	@Test
	public void inserir(){
		
		Funcionario funcionario = new Funcionario();
		
		PerfilDAO perfilDAO = new PerfilDAO();
		
		Perfil perfil = perfilDAO.buscar(3);
		
		CargoDAO cargoDAO = new CargoDAO();
		
		Cargo cargo = cargoDAO.consultar(12);
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		funcionario.setBairro("Vila Santa Tereza");
		funcionario.setCidade("Chavantes");
		funcionario.setComplemento("Casa");
		funcionario.setCpf("44568786819");
		funcionario.setEmail("guihms1@gmail.com");
		funcionario.setEndereco("Rua José de Souza Carvalho");
		funcionario.setEstadoCivil("Solteiro");
		funcionario.setEstado("SP");
		funcionario.setLogin("gui");
		funcionario.setNascimento(new Date());
		funcionario.setNumero("06");
		funcionario.setRg("469823734");
		funcionario.setSenha("teste");
		funcionario.setTelefone("996440052");
		funcionario.setNome("Luís Guilherme Fernandes Ferreira");
		funcionario.setCodigoPerfil(perfil);
		funcionario.setCodigoCargo(cargo);
		funcionario.setDataAdmissao(new Date());
		funcionario.setDataDemissao(new Date());
		funcionario.setFormacao("ENSINO TÉCNICO DE NIVEL MÉDIO");
		
		funcionarioDAO.inserir(funcionario);
		
	}//fim do método inserir
	
	@Ignore
	@Test
	public void consultar(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Funcionario funcionario = funcionarioDAO.consultar(13);
		
		System.out.println("Nome do funcionario: " + funcionario.getNome() + "\nTelefone: " + funcionario.getTelefone());
		
	}//Fim do método consultarF
	
	@Ignore
	@Test
    public void listar(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        List<Funcionario> resultado = funcionarioDAO.listar();
        
        for(Funcionario funcionario : resultado){
            System.out.println(funcionario);
        }
    }
	
	@Ignore
	@Test
    public void editar(){

        Integer codigo = 20;

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Funcionario resultado = funcionarioDAO.consultar(codigo);
        
        System.out.println("Funcionario encontrado " + resultado);
        
        resultado.setNome("LUIZINHO GALINDO");
        
<<<<<<< HEAD
        funcionarioDAO.editar(resultado, true);
=======
        funcionarioDAO.editar(resultado,false);
>>>>>>> 06c6cbb62ae117abd22102b5733eada3dd8af917
        
        System.out.println("Funcionário Editado: " + resultado);
    }
	
	@Ignore
    @Test
    public void excluir(){
        
		Integer codigo = 20;

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        Funcionario resultado = funcionarioDAO.consultar(codigo);
        
        funcionarioDAO.excluir(resultado);
        
        System.out.println("Funcionário excluído " + resultado);
        
    }
	
}
