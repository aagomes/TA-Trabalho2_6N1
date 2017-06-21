package br.edu.ifsul.controle;

import br.edu.ifsul.dao.OrientadorDAO;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "controleSetor")
@SessionScoped
public class ControleSetor implements Serializable {
    
    @EJB
    private OrientadorDAO dao;

    public ControleSetor(){
        
    }
    
    public OrientadorDAO getDao() {
        return dao;
    }

    public void setDao(OrientadorDAO dao) {
        this.dao = dao;
    }

}
