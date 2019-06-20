/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.achristiam.manjos.projetofinallpoo.model.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author allainnc
 */
public class ParseDate {
    public static Date parseDate(String date) {
     try {
         return new SimpleDateFormat("dd/MM/yyyy").parse(date);
     } catch (ParseException e) {
         System.out.println("Erro");
         return null;
     }
  }
}
