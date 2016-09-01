package br.com.sast.test;

import org.junit.Test;

import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Perfil;

/**
 * Classe definida para para testar os métodos da classe PerfilDAO.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 31/08/2016
 */

public class PerfilDAOTest {

	@Test
	public void inserir(){
		
		Perfil perfil = new Perfil();
		
		perfil.setCodigo(1);
		perfil.setGerenciarCaixas(2);
		perfil.setNomePerfil("Teste");
		perfil.setGerenciarCargos(3);
		perfil.setGerenciarConfiguracoes(4);
		perfil.setGerenciarFaturas(5);
		perfil.setGerenciarManutencoes(6);
		perfil.setGerenciarMovimentacoes(7);
		perfil.setGerenciarPessoas(8);
		perfil.setGerenciarPlanos(9);
		
		PerfilDAO perf = new PerfilDAO();
		
		perf.inserir(perfil);
		
	}
	
}
