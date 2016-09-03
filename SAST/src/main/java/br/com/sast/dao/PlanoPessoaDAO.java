package br.com.sast.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.PlanoPessoa;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_planopessoa".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class PlanoPessoaDAO {

	public void inserir(PlanoPessoa planopessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.save(planopessoa);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método inserir
	
	@SuppressWarnings("deprecation")
	public PlanoPessoa consultar(int codPlanoPessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		PlanoPessoa planopessoa = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(PlanoPessoa.class);
			consulta.add(Restrictions.eq("codigo", codPlanoPessoa));
			
			planopessoa = (PlanoPessoa)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return planopessoa;
		
	}
	
}//Fim da classe
