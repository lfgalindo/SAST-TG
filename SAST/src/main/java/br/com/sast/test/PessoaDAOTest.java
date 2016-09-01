package br.com.sast.test;

import java.util.Date;

import org.junit.Test;

import br.com.sast.dao.CargoDAO;
import br.com.sast.dao.PerfilDAO;
import br.com.sast.dao.PessoaDAO;
import br.com.sast.domain.Cargo;
import br.com.sast.domain.Perfil;
import br.com.sast.domain.Pessoa;

/**
 * Classe definida para para testar os métodos da classe PesssoaDAO.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 01/09/2016
 */

public class PessoaDAOTest {

	@Test
	public void inserir(){
		
		PerfilDAO perfilDAO = new PerfilDAO();
		CargoDAO cargoDAO = new CargoDAO();
		Date data = new Date();
	
		Pessoa pessoa = new Pessoa();
		
		Perfil perfil = perfilDAO.consultar(1);
		Cargo cargo = cargoDAO.consultar(1);
		
		pessoa.setNome("LUIZINHO");
		pessoa.setTelefone("99999");
		pessoa.setNascimento(data);
		pessoa.setLogin("LUIZIN");
		pessoa.setEmail("LUIZINHO@NET");
		pessoa.setCpf("88888");
		pessoa.setEndereco("RUA DO LUIZINHO");
		pessoa.setCodigoCargo(cargo);
		pessoa.setCodigoPerfil(perfil);
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.inserir(pessoa);
		
		
	}//Fim do método inserir
	
	@Test
	public void consultar(){
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		Pessoa pessoa = pessoaDAO.consultar(1);
		
		System.out.println("Nome do cargo: " + pessoa.getNome() + "\nDescricao: " + pessoa.getCpf());
		
	}//Fim do método consultar
	
}
