/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.controller;

import com.achristiam.manjos.projetofinallpoo.model.dao.ConexaoHibernate;
import javax.persistence.EntityManager;

/**
 *
 * @author Giuvane
 */
public class SistemaController {
    public static void iniciarSistema()
    {
        EntityManager manager = ConexaoHibernate.getInstance();
    }
}
