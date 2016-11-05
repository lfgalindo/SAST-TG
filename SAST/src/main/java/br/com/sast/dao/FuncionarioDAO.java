package br.com.sast.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Funcionario;
import br.com.sast.util.HibernateUtil;
import br.com.sast.util.Util;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Classe definida para realizar a persistência na entidade "tb_funcionario".
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */
public class FuncionarioDAO {

    //Método para inserir dados no banco
    public void inserir(Funcionario funcionario) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        String senhaSemCriptografia = funcionario.getSenha();

        try {

            sessao.beginTransaction();
            // Criptografando senha
            SimpleHash hash = new SimpleHash("md5", funcionario.getSenha());
            funcionario.setSenha(hash.toHex());
            sessao.save(funcionario);
            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
            funcionario.setSenha(senhaSemCriptografia);
            sessao.getTransaction().rollback();
            erro.getMessage();

        } finally {

            sessao.close();

        }

    }//Fim do método inserir

    //Método para listar os registros do banco
    @SuppressWarnings({"deprecation", "unchecked"})
    public List<Funcionario> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Funcionario.class);
                        
            consulta.addOrder(Order.asc("codigo"));

            return consulta.list();

        } catch (RuntimeException erro) {

            throw erro;

        } finally {

            sessao.close();

        }

    }//Fim do método listar

    //Método para buscar um registro do banco.
    @SuppressWarnings("deprecation")
    public Funcionario consultar(int codFunc) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        Funcionario pessoa = null;

        try {

            Criteria consulta = sessao.createCriteria(Funcionario.class);

            consulta.add(Restrictions.eq("codigo", codFunc));

            pessoa = (Funcionario) consulta.uniqueResult();

        } catch (RuntimeException erro) {

            erro.getMessage();

        } finally {

            sessao.close();

        }

        return pessoa;

    }// Fim da classe consultar

    //Método para editar um registro do banco
    public void editar(Funcionario funcionario) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        String senhaSemCriptografia = funcionario.getSenha();

        try {
            sessao.beginTransaction();
            // Criptografando senha
            SimpleHash hash = new SimpleHash("md5", funcionario.getSenha());
            funcionario.setSenha(hash.toHex());
            sessao.update(funcionario);
            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
            funcionario.setSenha(senhaSemCriptografia);
            sessao.getTransaction().rollback();
            erro.getMessage();

        } finally {

            sessao.close();

        }

    }//Fim do método editar

    //Método para excluir um registro do banco
    public void excluir(Funcionario funcionario) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            sessao.beginTransaction();
            sessao.delete(funcionario);
            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {

            sessao.getTransaction().rollback();
            erro.getMessage();

        } finally {

            sessao.close();

        }

    }//Fim do método excluir

    //Método para autenticar um funcionário cadastrado no banco.
    @SuppressWarnings("deprecation")
    public Funcionario autenticar(String login, String senha) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {

            Criteria consulta = sessao.createCriteria(Funcionario.class);

            consulta.add(Restrictions.eq("login", login));
            SimpleHash hash = new SimpleHash("md5", senha);
            consulta.add(Restrictions.eq("senha", hash.toHex()));

            Funcionario resultado = (Funcionario) consulta.uniqueResult();

            return resultado;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            sessao.close();
        }
    }//Fim do método autenticar

} //Fim da classe FuncionárioDAO
