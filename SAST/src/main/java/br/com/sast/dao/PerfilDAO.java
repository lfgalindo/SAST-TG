package br.com.sast.dao;

import org.hibernate.Session;
import br.com.sast.domain.Perfil;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_perfil".
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

public class PerfilDAO {
	
	public void inserir(Perfil perfil){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	
        try {
        	sessao.beginTransaction();

            sessao.save(perfil);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
        	sessao.getTransaction().rollback();
            erro.getMessage();
            
        } finally {
            sessao.close();
        }
				
	} // Fim do método inserir
	
} // Fim da classe
