/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.dac.projeto.core.repsitory;

import java.util.List;

/**
 *
 * @author jose2
 * @param <T>
 */
public interface RepositorioJPA<T> {

    public void create(T entity);

    public T find(int key ,Class<T> type);

    public List<T> findAll(Class<T> type);

    public T update(T entity);

    public void remove(T entity);

}
