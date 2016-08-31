package br.com.sast.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.sast.domain.Cargo;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_cargo".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class CargoDAO {
	
	public void inserir(Cargo cargo){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Transaction transacao = null;
		
		try{
			
			transacao = sessao.beginTransaction();
			sessao.save(cargo);
			transacao.commit();
			
		}catch(RuntimeException erro){
			
			if(transacao != null){
				transacao.rollback();
			}
			
			throw erro;
			
		}finally{
			sessao.close();
		}
		
	} //Fim do método inserir 
	
} //Fim da classe CargoDAO
