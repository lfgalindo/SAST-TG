package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Empresa;
import br.com.sast.util.HibernateUtil;

/**
 * Requisito Funcional 03 (Configurações Gerais) Classe definida para mapear a
 * entidade "tb_empresa" e seus atributos.
 * 
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com>
 * @since 11/09/2016
 */

public class EmpresaDAO {

	public void inserir(Empresa empresa) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.save(empresa);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}

	} // Fim do método inserir

	@SuppressWarnings("deprecation")
	public Empresa buscar(Integer codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Empresa.class);

			consulta.add(Restrictions.eq("codigoEmpresa", codigo));

			Empresa resultado = (Empresa) consulta.uniqueResult();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;

		} finally {
			sessao.close();

		}
	} // Fim do método buscar
	
	
	//Método para listar todos os registros de empresas do banco.
		@SuppressWarnings({"deprecation", "unchecked"})
		public List<Empresa> listar(){
			
			Session sessao = HibernateUtil.getSessionFactory().openSession();
			
			try{
				
				Criteria consulta = sessao.createCriteria(Empresa.class);
				
				consulta.addOrder(Order.asc("codigoEmpresa"));
				
				List<Empresa> resultado = consulta.list();
				
				return resultado;
				
			}catch(RuntimeException erro){
				
				throw erro;
				
			}finally{
				
				sessao.close();
				
			}
			
		}//Fim do método listar

	public void excluir(Empresa empresa) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.delete(empresa);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}
	} // Fim do método Excluir

	public void editar(Empresa empresa) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.update(empresa);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}
	} // Fim do método Editar
	
	//Método para consultar um registro no banco
	@SuppressWarnings("deprecation")
	public Empresa consultar(int codEmpresa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Empresa empresa = null;
		
		try{

			Criteria consulta = sessao.createCriteria(Empresa.class);
			consulta.add(Restrictions.eq("codigo", codEmpresa));
			
			empresa = (Empresa)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return empresa;
		
	}//Fim da classe consultar

}
