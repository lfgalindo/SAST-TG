package br.com.sast.test;

import java.util.Date;

import org.junit.Test;
import br.com.sast.dao.CaixaDAO;
import br.com.sast.dao.PessoaDAO;
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
		PessoaDAO pessoaDAO = new PessoaDAO();
		Caixa caixa = new Caixa();
		
		
		Pessoa pessoa = pessoaDAO.consultar(1);
		
		caixa.setCodigo(2);
		caixa.setDtCriacao(new Date());
		caixa.setPessoa(pessoa);
		caixa.setRemovido(0);
		
		CaixaDAO caixaDAO = new CaixaDAO();
		
		caixaDAO.inserir(caixa);
	}	

}
