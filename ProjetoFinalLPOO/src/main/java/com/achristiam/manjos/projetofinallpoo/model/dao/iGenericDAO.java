/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.dao;

import java.util.List;

/**
 *
 * @author allainnc
 */
public interface iGenericDAO<T> {
    void save(T object);
    T listOne(String pkname, int pkValue, Class clazz);
    T listOne(Long pkValue, Class clazz);
    List listAll(Class clazz);
    void update(T object);
    void delete(T object);
}
