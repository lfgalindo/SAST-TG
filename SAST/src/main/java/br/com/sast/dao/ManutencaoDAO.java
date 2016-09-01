package br.com.sast.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Manutencao;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_manutencao".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class ManutencaoDAO {
	
	public void inserir(Manutencao manutencao){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.save(manutencao);
			sessao.beginTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
		}
		
	}//Fim do método inserir
	
	@SuppressWarnings("deprecation")
	public Manutencao consultar(int CodManutencao){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Manutencao manutencao = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Manutencao.class);
			consulta.add(Restrictions.eq("codigo", CodManutencao));
			
			manutencao = (Manutencao)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return manutencao;
		
	}// Fim do método buscar
	

}//Fim da classe
