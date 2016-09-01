package br.com.sast.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
	
	@SuppressWarnings("deprecation")
	public Perfil consultar(int codPerfil){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Perfil perfil = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Perfil.class);
			consulta.add(Restrictions.eq("codigo", codPerfil));
			
			perfil = (Perfil)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return perfil;
		
	}
	
	
} // Fim da classe
