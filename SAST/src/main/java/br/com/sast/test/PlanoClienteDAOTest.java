package br.com.sast.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.PlanoClienteDAO;
import br.com.sast.dao.PlanoDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.Plano;
import br.com.sast.domain.PlanoCliente;

/**
 * Classe definida para para testar os métodos da classe PlanoClienteDAO.
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 10/10/2016
 */
public class PlanoClienteDAOTest {

    @Ignore
    @Test
    public void inserir() {

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = clienteDAO.consultar(3);

        PlanoDAO planDAO = new PlanoDAO();

        Plano plan = planDAO.buscar(7);

        PlanoCliente planCli = new PlanoCliente();

        PlanoClienteDAO planCliDAO = new PlanoClienteDAO();

        planCli.setCodigoCliente(cliente);
        planCli.setCodigoPlano(plan);

        planCliDAO.inserir(planCli);

    }// Fim do método incluir

    @Ignore
    @Test
    public void consultar() {

        PlanoClienteDAO planCliDAO = new PlanoClienteDAO();

        PlanoCliente planCli = planCliDAO.consultar(8);

        System.out.println("Código do plano do cliente: " + planCli.getCodigo());

    }//Fim do método consultar

    @Ignore
    @Test
    public void listar() {

        PlanoClienteDAO planCliDAO = new PlanoClienteDAO();

        List<PlanoCliente> resultado = planCliDAO.listar();

        for (PlanoCliente planCli : resultado) {
            System.out.println(planCli);
        }

    }// Fim do método listar

    @Ignore
    @Test
    public void editar() {

        Integer codigo = 9;

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente cliente = clienteDAO.consultar(10);

        PlanoClienteDAO planCliDAO = new PlanoClienteDAO();

        PlanoCliente resultado = planCliDAO.consultar(codigo);

        System.out.println("PlanoCliente encontrado: " + resultado);

        resultado.setCodigoCliente(cliente);

        planCliDAO.editar(resultado);

        System.out.println("PlanoCliente Editado: " + resultado);

    }//Fim do método editar

    @Ignore
    @Test
    public void excluir() {

        Integer codigo = 9;

        PlanoClienteDAO planCliDAO = new PlanoClienteDAO();

        PlanoCliente resultado = planCliDAO.consultar(codigo);

        planCliDAO.excluir(resultado);

        System.out.println("PlanoCliente excluído: " + resultado);

    }

}
