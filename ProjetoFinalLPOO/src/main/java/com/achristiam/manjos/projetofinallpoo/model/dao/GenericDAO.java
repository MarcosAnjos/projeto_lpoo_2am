/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author allainnc
 */
public class GenericDAO<T> implements iGenericDAO<T>{

    EntityManager manager;

    public GenericDAO() {
        manager = ConexaoHibernate.getInstance();
    }
   
    
    @Override
    public void save(T object) {
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
        System.out.println(object.getClass().getSimpleName() + " Salvo com sucesso");
    }

    @Override
    public T listOne(String pkName, int pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getSimpleName() + " t WHERE " 
                + pkName + " = " + pkValue;
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        
        return (T)obj;
    }
    
    @Override
    public T listOne(String pkName, String pkValue, Class clazz) {
        String jpql = "SELECT t FROM " + clazz.getSimpleName() + " t WHERE " 
                + pkName + " = " + "'" +pkValue+ "'";
        Query query = this.manager.createQuery(jpql);
        Object obj;
        try {
            obj = query.getSingleResult();
        }
        catch (javax.persistence.NoResultException ex){
            obj = null;
        }  
        
        return (T)obj;
    }

    @Override
    public List listAll(Class clazz) {
      String jpql = "SELECT t FROM " + clazz.getSimpleName() + " t";
      Query query = manager.createQuery(jpql);
      List<T> objs = query.getResultList();
      return objs;
    }

    @Override
    public void update(T object) {
        manager.getTransaction().begin();
        manager.persist(object);
        manager.getTransaction().commit();
        System.out.println(object.getClass().getSimpleName() + " Atualizado com sucesso");
    }

    @Override
    public void delete(T object) {
        manager.getTransaction().begin();
        manager.remove(object);
        manager.getTransaction().commit();
        System.out.println(object.getClass().getSimpleName() + " Removido com sucesso");
    }
    
    @Override
    public T listOne(Long pkValue, Class clazz) {
        manager.getTransaction().begin();
        Object obj = manager.getReference(clazz, pkValue);
        manager.getTransaction().commit();
        return (T) obj;
    }
    
}
