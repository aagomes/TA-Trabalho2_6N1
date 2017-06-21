package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Orientador;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class OrientadorDAO<T> extends DAOGenerico<Orientador> implements Serializable {

    public OrientadorDAO() {
        super();
        super.setClassePersistente(Orientador.class);
        super.setOrdem("nome");        
    }
 
    public Orientador getObjectById(String nome) throws Exception {
        Orientador obj = (Orientador) super.getEm().find(super.getClassePersistente(), nome);
        obj.getPublicacoes().size();
        return obj;
    }       
    
}
