package by.novacom.exercise.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Created by byaxe on 4/5/16.
 */
public abstract class GenericAbstractDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED,unitName = "APU")
    protected EntityManager entityManager;
}
