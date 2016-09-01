package br.com.sast.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
		
		try{
			
			sessao.beginTransaction();
			sessao.save(cargo);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			sessao.close();
		}
		
	} //Fim do método inserir 
	
	@SuppressWarnings("deprecation")
	public Cargo consultar(int codCargo){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Cargo cargo = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Cargo.class);
			consulta.add(Restrictions.eq("codigo", codCargo));
			
			cargo = (Cargo)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return cargo;
		
	}//Fim da classe consultar
	
} //Fim da classe CargoDAO
