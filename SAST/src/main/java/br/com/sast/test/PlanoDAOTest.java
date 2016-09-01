package br.com.sast.test;

import org.junit.Test;

import br.com.sast.dao.PlanoDAO;
import br.com.sast.domain.Plano;

/**
 * Classe definida para para testar os métodos da classe PlanoDAO.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 31/08/2016
 */

public class PlanoDAOTest {

	@Test
	public void inserir(){
		
		Plano plano = new Plano();
		
		plano.seDescricao("testedesc");
		plano.setCodigo(1);
		plano.setGarantia(40);
		plano.setTipoConexao("Fibra");
		plano.setValor(79.90);
		plano.setVelocidade(3500);
		
		PlanoDAO planoDAO = new PlanoDAO();
		
		planoDAO.inserir(plano);
	}
}
