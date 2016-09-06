package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Cargo;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_cargo".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class CargoDAO {
	
	//Método para inserir dados no banco
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
	
	
	//Método para listar todos os registros de cargos do banco.
	@SuppressWarnings({"deprecation", "unchecked"})
	public List<Cargo> listar(){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(Cargo.class);
			
			consulta.addOrder(Order.asc("codigo"));
			
			List<Cargo> resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método listar
	
	
	//Método para consultar um registro no banco
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
	
	//Método para editar um registro do banco.
	public void editar(Cargo cargo){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.update(cargo);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método editar
	
	//Método para excluir um registro do banco.
	public void excluir(Cargo cargo){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.delete(cargo);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		
	}//Fim do método excluir
	
	
} //Fim da classe CargoDAO
