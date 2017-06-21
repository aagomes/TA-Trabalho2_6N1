package br.edu.ifsul.controle;


import br.edu.ifsul.dao.AlunoDAO;
import br.edu.ifsul.dao.OrientadorDAO;
import br.edu.ifsul.modelo.Orientador;
import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "controleAluno")
@SessionScoped
public class ControleAluno implements Serializable {

    @EJB
    private AlunoDAO<Aluno> dao;
    private Aluno objeto;
    @EJB
    private OrientadorDAO<Orientador> daoOrientador;
    private Boolean editando;
    
    public ControleAluno(){
        editando = false;
    }
    
    public String listar(){
        editando = false;
        return "/privado/aluno/listar?faces-redirect=true";
    }

    public void novo(){
        objeto = new Aluno();
        editando = true;
    }
    
    public void alterar(Integer id){
        try {
            objeto = dao.getObjectById(id);
            editando = true;
        } catch (Exception e){
            Util.mensagemErro("Erro ao recuperar objeto: "+
                    Util.getMensagemErro(e));
        }
    }

    public void excluir(Integer id){
        try {
            objeto = dao.getObjectById(id);
            dao.remove(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e){
            Util.mensagemErro("Erro ao remover objeto: "+
                    Util.getMensagemErro(e));
        }
    }    
    
    public void salvar(){
        try {
            if (objeto.getId() == null){
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
            editando = false;
        } catch (Exception e){
            Util.mensagemErro("Erro ao persistir objeto: " + 
                    Util.getMensagemErro(e));
        }
    }    

    public AlunoDAO<Aluno> getDao() {
        return dao;
    }

    public void setDao(AlunoDAO<Aluno> dao) {
        this.dao = dao;
    }

    public Aluno getObjeto() {
        return objeto;
    }

    public void setObjeto(Aluno objeto) {
        this.objeto = objeto;
    }

    public OrientadorDAO<Orientador> getDaoOrientador() {
        return daoOrientador;
    }

    public void setDaoOrientador(OrientadorDAO<Orientador> daoOrientador) {
        this.daoOrientador = daoOrientador;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }
}
