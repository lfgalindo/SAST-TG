package br.com.sast.bean;

import br.com.sast.dao.CargoDAO;
import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Cargo;
import br.com.sast.domain.Funcionario;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import br.com.sast.domain.Perfil;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omnifaces.util.Faces;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private Integer codigo;

    //Chaves estrangeiras
    private List<Perfil> perfis;
    private List<Cargo> cargos;

    //MÉTODOS CRUD
    //método que prepara a tela para inserir novo registro.
    public void novo() {

        funcionario = new Funcionario();

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        funcionarios = funcionarioDAO.listar();

        //chave estrangeira.
        PerfilDAO perfilDAO = new PerfilDAO();
        CargoDAO cargoDAO = new CargoDAO();

        //chave estrangeira.
        perfis = perfilDAO.listar();
        cargos = cargoDAO.listar();

    }

    //método para inserir um novo registro no banco.
    public void salvar() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.inserir(funcionario);

        Messages.addGlobalInfo("Funcionário inserido com sucesso!");

        novo();

    }//fim do método salvar

    //método para listar todos os registros do banco.
    public void listar() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarios = funcionarioDAO.listar();

    }//fim do método listar.

    //método para buscar um registro específico no banco.
    public void buscar() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionario = funcionarioDAO.consultar(codigo);

        PerfilDAO perfilDAO = new PerfilDAO();
        perfis = perfilDAO.listar();

        CargoDAO cargoDAO = new CargoDAO();
        cargos = cargoDAO.listar();

    }//fim do método buscar

    //método para editar um registro específico no banco.
    public void editar() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.editar(funcionario);

        Messages.addGlobalInfo("Funcionário editado com sucesso!");
        buscar();

    }//fim do método editar

    //método para excluir um registro específico no banco.
    public void excluir() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.excluir(funcionario);

        Messages.addGlobalInfo("Funcionário deletado com sucesso!");

        try {
            Faces.redirect("funcionarioListar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fim do método excluir

    //GETS & SETS
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

}
