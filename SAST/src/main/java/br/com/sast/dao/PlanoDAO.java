package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.sast.domain.Plano;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_plano".
 *
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */
public class PlanoDAO {

    // Método que fará a persistência no banco para inserir um plano
    public void inserir(Plano plano) {

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

    // Método que fará a persistência no banco para listar todos os planos armazenados
    @SuppressWarnings({"deprecation", "unchecked"})
    public List<Plano> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Plano.class);

            consulta.addOrder(Order.asc("codigo"));

            List<Plano> resultado = consulta.list();

            return resultado;

        } catch (RuntimeException erro) {
            throw erro;

        } finally {
            sessao.close();

        }
    } // Fim do método listar

    // Método que fará a persistência no banco para buscar um determinado plano
    @SuppressWarnings("deprecation")
    public Plano buscar(Integer codigo) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(Plano.class);

            consulta.add(Restrictions.eq("codigo", codigo));

            Plano resultado = (Plano) consulta.uniqueResult();

            return resultado;

        } catch (RuntimeException erro) {
            throw erro;

        } finally {
            sessao.close();

        }
    } // Fim do método buscar

    // Método que fará a persistência no banco para excluir um plano
    public void excluir(Plano plano) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            sessao.beginTransaction();

            sessao.delete(plano);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
            sessao.getTransaction().rollback();
            erro.getMessage();

        } finally {
            sessao.close();
        }
    } // Fim do método Excluir

    // Método que fará a persistência no banco para editar um plano
    public void editar(Plano plano) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            sessao.beginTransaction();

            sessao.update(plano);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
            sessao.getTransaction().rollback();
            erro.getMessage();

        } finally {
            sessao.close();
        }
    } // Fim do método Editar
}//Fim da Classe
