package br.com.sast.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Pessoa;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_pessoa".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class PessoaDAO {
	
	public void inserir(Pessoa pessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.save(pessoa);
			sessao.beginTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método inserir
	
	@SuppressWarnings("deprecation")
	public Pessoa consultar(int codCli){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Pessoa pessoa = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Pessoa.class);
			
			consulta.add(Restrictions.eq("codigo", codCli));
			
			pessoa = (Pessoa)consulta.uniqueResult();
			
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return pessoa;
		
	}// Fim da classe consultar

} //Fim da classe PessoaDAO
