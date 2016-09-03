package br.com.sast.test;

import java.util.Date;
import org.junit.Test;
import br.com.sast.dao.CaixaDAO;
import br.com.sast.domain.Caixa;
import br.com.sast.domain.Pessoa;

/**
 * Classe definida para para testar os métodos da classe CaixaDAO.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 31/08/2016
 */

public class CaixaDAOTest {
	
	@Test
	public void inserir(){
		Date date = new Date();
		//PessoaDAO pessoaDAO = new PessoaDAO();
		Caixa caixa = new Caixa();
		
		Pessoa pessoa = null;
		
		caixa.setCodigo(1);
		caixa.setDtCriacao(date);
		caixa.setPessoa(pessoa);
		caixa.setRemovido(1);
		
		CaixaDAO caixaDAO = new CaixaDAO();
		
		caixaDAO.inserir(caixa);
	}	

}
