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
import br.com.sast.util.TreatString;
import br.com.sast.util.Util;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omnifaces.util.Faces;

@ManagedBean
@ViewScoped
public class FuncionarioBean {

    private Funcionario funcionario;
    private List<Funcionario> funcionarios;
    private Integer codigo;
    private Funcionario funcionarioAuxiliar;

    //Chaves estrangeiras
    private List<Perfil> perfis;
    private List<Cargo> cargos;

    private Date dataAtual;
    private Date dataDemissao;

    //MÉTODOS CRUD
    //método que prepara a tela para inserir novo registro.
    public void novo() {

        Calendar calendar = Calendar.getInstance();
        setDataDemissao(calendar.getTime());

        calendar.add(Calendar.YEAR, -16);
        setDataAtual(calendar.getTime());

        funcionario = new Funcionario();
        funcionarioAuxiliar = new Funcionario();

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

        Boolean salvar = Boolean.TRUE;

        if (!Util.isCPFValid(getFuncionario().getCpf())) {
            getFuncionario().setCpf("");
            Messages.addGlobalWarn("CPF inválido!");
            salvar = Boolean.FALSE;
        }
        if (!TreatString.isEmailValid(getFuncionario().getEmail())) {
            getFuncionario().setEmail("");
            Messages.addGlobalWarn("E-mail inválido!");
            salvar = Boolean.FALSE;
        }

        if (salvar) {

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

            if (Util.isNotNull(funcionarioDAO.buscarRgExistente(getFuncionario().getRg()))) {
                Messages.addGlobalWarn("RG já existente!");
            } else if (Util.isNotNull(funcionarioDAO.buscarCpfExistente(getFuncionario().getCpf()))) {
                Messages.addGlobalWarn("CPF já existente!");
            } else {
                funcionarioDAO.inserir(funcionario);

                Messages.addGlobalInfo("Funcionário inserido com sucesso!");

                novo();
            }

        }

    }//fim do método salvar

    //método para listar todos os registros do banco.
    public void listar() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarios = funcionarioDAO.listar();

    }//fim do método listar.

    //método para buscar um registro específico no banco.
    public void buscar() {

        this.funcionarioAuxiliar = new Funcionario();

        Calendar calendar = Calendar.getInstance();
        setDataDemissao(calendar.getTime());

        calendar.add(Calendar.YEAR, -15);
        setDataAtual(calendar.getTime());

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionario = funcionarioDAO.consultar(codigo);

        this.funcionarioAuxiliar.setSenha(getFuncionario().getSenha());
        this.funcionarioAuxiliar.setCpf(getFuncionario().getCpf());
        this.funcionarioAuxiliar.setRg(getFuncionario().getRg());
        getFuncionario().setSenha("");

        PerfilDAO perfilDAO = new PerfilDAO();
        perfis = perfilDAO.listar();

        CargoDAO cargoDAO = new CargoDAO();
        cargos = cargoDAO.listar();

    }//fim do método buscar

    //método para editar um registro específico no banco.
    public void editar() {

        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        Boolean salvar = Boolean.TRUE;

        if (!Util.isCPFValid(getFuncionario().getCpf())) {
            getFuncionario().setCpf("");
            Messages.addGlobalWarn("CPF inválido!");
            salvar = Boolean.FALSE;
        }
        if (!TreatString.isEmailValid(getFuncionario().getEmail())) {
            getFuncionario().setEmail("");
            Messages.addGlobalWarn("E-mail inválido!");
            salvar = Boolean.FALSE;
        }

        if (!funcionarioAuxiliar.getCpf().equals(funcionario.getCpf())) {
            if (Util.isNotNull(funcionarioDAO.buscarCpfExistente(getFuncionario().getCpf()))) {
                Messages.addGlobalWarn("CPF já existente!");
                salvar = Boolean.FALSE;
            }
        }
        
        if(!funcionarioAuxiliar.getRg().equals(funcionario.getRg())){
            if (Util.isNotNull(funcionarioDAO.buscarRgExistente(getFuncionario().getRg()))) {
                Messages.addGlobalWarn("RG já existente!");
                salvar = Boolean.FALSE;
            }
        }

        if (salvar) {

            Boolean senhaNova = Boolean.TRUE;

            if (TreatString.isBlank(getFuncionario().getSenha())) {
                getFuncionario().setSenha(this.funcionarioAuxiliar.getSenha());
                senhaNova = Boolean.FALSE;
            }

            funcionarioDAO.editar(funcionario, senhaNova);

            Messages.addGlobalInfo("Funcionário editado com sucesso!");
            buscar();

        }

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

    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    public Date getDataDemissao() {
        return dataDemissao;
    }

    public void setDataDemissao(Date dataDemissao) {
        this.dataDemissao = dataDemissao;
    }

}
