/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.projeto.core.repsitory;

import java.util.Collections;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@Stateless
@Local(RepositorioJPA.class)
public class RepositorioJPAImpl<T> implements RepositorioJPA<T> {
    
    @PersistenceContext(unitName = "iprojeto_PU")
    private EntityManager manager;

    @Override
    public void create(T entity) {
        manager.persist(entity);
    }

    @Override
    public T find(int key, Class<T> type) {
      return manager.find(type, key);
    }

    @Override
    public List<T> findAll(Class<T> type) {
       Query query;
        query = manager.createQuery("Select e from " + type.getName() + " as e", type);
        List resultado = query.getResultList();
        if (!resultado.isEmpty()) {
            return resultado;
        }
        return Collections.EMPTY_LIST;
    }

    @Override
    public T update(T entity) {
       return manager.merge(entity);
    }

    @Override
    public void remove(T entity) {
        manager.remove(entity);
    }
    
}
