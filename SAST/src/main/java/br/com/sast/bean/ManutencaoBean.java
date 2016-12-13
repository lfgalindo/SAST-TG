package br.com.sast.bean;

/**
 * Classe definida para controlar a comunição entre a classe ManutencaoDAO e sua
 * Interface Web
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since Classe criada em 25/10/2016
 */
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.omnifaces.util.Messages;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.dao.ManutencaoDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.Funcionario;
import br.com.sast.domain.Manutencao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omnifaces.util.Faces;

@ManagedBean
@ViewScoped
public class ManutencaoBean {

    private Manutencao manutencao;
    private List<Manutencao> manutencoes;
    private Integer codigo;

    //Chaves estrangeiras
    private List<Cliente> clientes;
    private List<Funcionario> funcionarios;

    //GETS & SETS
    public Manutencao getManutencao() {
        return manutencao;
    }

    public void setManutencao(Manutencao manutencao) {
        this.manutencao = manutencao;
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(List<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    //MÉTODOS CRUD
    //método que prepara a tela para inserir um novo registro.
    public void novo() {

        manutencao = new Manutencao();

        //chaves estrangeiras
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        clientes = clienteDAO.listar();
        funcionarios = funcionarioDAO.listar();

    }//fim do método novo.

    //método para inserir um novo registro no banco.
    public void salvar() {

        ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
        manutencaoDAO.inserir(manutencao);

        Messages.addGlobalInfo("Manutenção inserida com sucesso!");
        
        novo();

    }//fim do método salvar.

    //método para listar todos os registros do banco.
    public void listar() {

        ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
        manutencoes = manutencaoDAO.listar();

    }//fim do método listar
    
    public void listarManutencoesFuncionario() {
        ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
        manutencoes = manutencaoDAO.listarManutencoesFuncionario(codigo);
    }

    //método para buscar um registro específico no banco.
    public void buscar() {

        ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
        manutencao = manutencaoDAO.consultar(codigo);

        //chaves estrangeiras
        ClienteDAO clienteDAO = new ClienteDAO();
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        clientes = clienteDAO.listar();
        funcionarios = funcionarioDAO.listar();

    }//fim do método buscar

    //método para editar um registro específico no banco.
    public void editar() {

        ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
        manutencaoDAO.editar(manutencao);

        Messages.addGlobalInfo("Manutenção editada com sucesso!");

    }//fim do método editar.

    //método para excluir um registro específico no banco.
    public void excluir() {

        ManutencaoDAO manutencaoDAO = new ManutencaoDAO();
        manutencaoDAO.excluir(manutencao);

        Messages.addGlobalInfo("Manutenção excluída com sucesso!");

        try {
            Faces.redirect("manutencaoListar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fim do método excluir.

}
