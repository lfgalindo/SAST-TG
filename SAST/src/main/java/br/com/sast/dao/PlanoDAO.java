package br.com.sast.dao;

import org.hibernate.Session;
import br.com.sast.domain.Plano;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_plano".
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

public class PlanoDAO {
	
	public void inserir(Plano plano){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	
        try {
        	sessao.beginTransaction();

            sessao.save(plano);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
        	sessao.getTransaction().rollback();
            erro.getMessage();
            
        } finally {
            sessao.close();
        }
				
	} // Fim do método inserir
}//Fim da Classe
