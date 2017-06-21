package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Aluno;
import java.io.Serializable;
import javax.ejb.Stateful;

@Stateful
public class AlunoDAO<T> extends DAOGenerico<Aluno> implements Serializable {

    public  AlunoDAO(){
        super();
        super.classePersistente = Aluno.class;
    }
            
}
