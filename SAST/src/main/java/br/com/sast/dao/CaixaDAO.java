package br.com.sast.dao;

import org.hibernate.Session;
import br.com.sast.domain.Caixa;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_caixa".
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

public class CaixaDAO {
	
	public void inserir(Caixa caixa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	
        try {
        	sessao.beginTransaction();

            sessao.save(caixa);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
        	sessao.getTransaction().rollback();
            erro.getMessage();
            
        } finally {
            sessao.close();
        }
				
	} // Fim do método inserir
}// Fim da Classe
