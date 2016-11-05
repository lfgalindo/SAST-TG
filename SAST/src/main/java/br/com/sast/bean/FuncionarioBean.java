package br.com.sast.bean;

import br.com.sast.dao.FuncionarioDAO;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.sast.domain.Cargo;
import br.com.sast.domain.Funcionario;
import br.com.sast.domain.Perfil;
import br.com.sast.util.Util;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import org.omnifaces.util.Messages;

@ManagedBean
@SessionScoped
public class FuncionarioBean {

    private static String PAGINA_FUNCIONARIO_LISTAR = "funcionarioListar.xhtml";
    
    private Funcionario funcionarioPesquisa;
    private Funcionario funcionarioEdicao;
    private FuncionarioDAO funcionarioDAO;
    
    private List<Funcionario> funcionarios;
    private Integer codigo;

    // Chaves estrangeiras
    private List<Perfil> perfis;
    private List<Cargo> cargos;

    private Boolean exibirResultado;

    public String iniciarProcesso() {
        inicializarPesquisa();
        return PAGINA_FUNCIONARIO_LISTAR;
    }
    
    public void pesquisar() {
        if(getFuncionarioDAO().listar().isEmpty()){
            Messages.addGlobalWarn("Nenhum registro encontrado.", FacesMessage.SEVERITY_WARN);
        } 
    }

    private void inicializarPesquisa() {
        setFuncionarios(getFuncionarioDAO().listar());
        setExibirResultado(Boolean.FALSE);
        setFuncionarioPesquisa(new Funcionario());
        setFuncionarioDAO(new FuncionarioDAO());
    }

    public Funcionario getFuncionarioPesquisa() {
        return funcionarioPesquisa;
    }

    public void setFuncionarioPesquisa(Funcionario funcionarioPesquisa) {
        this.funcionarioPesquisa = funcionarioPesquisa;
    }

    public Funcionario getFuncionarioEdicao() {
        return funcionarioEdicao;
    }

    public void setFuncionarioEdicao(Funcionario funcionarioEdicao) {
        this.funcionarioEdicao = funcionarioEdicao;
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

    public Boolean getExibirResultado() {
        return exibirResultado;
    }

    public void setExibirResultado(Boolean exibirResultado) {
        this.exibirResultado = exibirResultado;
    }

    public FuncionarioDAO getFuncionarioDAO() {
        return funcionarioDAO;
    }

    public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
        this.funcionarioDAO = funcionarioDAO;
    }

}
