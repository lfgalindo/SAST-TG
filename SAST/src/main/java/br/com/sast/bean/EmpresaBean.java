package br.com.sast.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sast.dao.EmpresaDAO;
import br.com.sast.domain.Empresa;
import br.com.sast.util.TreatString;
import br.com.sast.util.Util;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

@ManagedBean
@ViewScoped
public class EmpresaBean {

    private Empresa empresa;
    private List<Empresa> empresas;
    private Integer codigo;

    ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    String basePath = ctx.getRealPath("/");

    String txtPath = basePath + "Backup";

    public void novo() {
        empresa = new Empresa();
    }

    public void salvar() {

        Boolean salvar = Boolean.TRUE;

        if (!Util.isCNPJValid(getEmpresa().getCnpj())) {
            getEmpresa().setCnpj("");
            Messages.addGlobalWarn("CNPJ inválido!");
            salvar = Boolean.FALSE;
        }
        if (!TreatString.isEmailValid(getEmpresa().getEmail())) {
            getEmpresa().setEmail("");
            Messages.addGlobalWarn("E-mail inválido!");
            salvar = Boolean.FALSE;
        }

        if (salvar) {
            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresaDAO.inserir(empresa);
            Messages.addGlobalInfo("Empresa inserida com sucesso!");
            novo();
        }
    }

    public void listar() {
        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresas = empresaDAO.listar();
    }

    public void buscar() {
        EmpresaDAO empresaDAO = new EmpresaDAO();
        //empresa = empresaDAO.buscar(codigo);
        empresa = empresaDAO.buscar();
    }

    public void backup() throws InterruptedException {
        try {
            
            Date now = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");

            String strFilename = dateFormat.format(now);

            String command = "C:\\xampp\\mysql\\bin\\mysqldump -uroot -p  --add-drop-database -B sast -r " + "\"" + txtPath + "\\" + strFilename + "_sast.sql\"";

            System.err.println(command + "\n" + txtPath);
                    
            Process p = Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+command);
            
            int processComplete = p.waitFor();
            
            if(processComplete == 0) {
                Messages.addGlobalInfo("Backup Gerado com sucesso");
            } else {
                Messages.addGlobalWarn("Nao foi possível a geraçao do Backup, entre em contato com o Administrador");
            }

        } catch (IOException ex) {
            Messages.addGlobalWarn("erro" + ex.getMessage());
        }
    }

    public void editar() {
        Boolean salvar = Boolean.TRUE;

        if (!Util.isCNPJValid(getEmpresa().getCnpj())) {
            getEmpresa().setCnpj("");
            Messages.addGlobalWarn("CNPJ inválido!");
            salvar = Boolean.FALSE;
        }
        if (!TreatString.isEmailValid(getEmpresa().getEmail())) {
            getEmpresa().setEmail("");
            Messages.addGlobalWarn("E-mail inválido!");
            salvar = Boolean.FALSE;
        }

        if (salvar) {

            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresaDAO.editar(empresa);
            Messages.addGlobalInfo("Empresa editada com sucesso!");
        }
    }

    public void excluir() {
        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.excluir(empresa);
        Messages.addGlobalInfo("Empresa excluída com sucesso!");
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
}
