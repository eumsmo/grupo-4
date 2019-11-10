/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dn;

import javafx.beans.property.SimpleStringProperty;

public class DescartadoLista {
   
    private final SimpleStringProperty ACERVO;
    private final SimpleStringProperty OPERADOR;
    private final SimpleStringProperty DATA;
    private final SimpleStringProperty MOTIVO;
 //   private final SimpleStringProperty ;
 
   public DescartadoLista(String ACERVO, String DATA,String OPERADOR, String MOTIVO) {
  
       this.ACERVO = new SimpleStringProperty(ACERVO);
        this.OPERADOR =  new SimpleStringProperty(OPERADOR);
        this.DATA = new SimpleStringProperty(DATA);
        this.MOTIVO =  new SimpleStringProperty(MOTIVO);
    }

  

    public String getOPERADOR() {
        return OPERADOR.get();
    }

    public String getDATA() {
        return DATA.get();
    }

   
    public String getACERVO() {
        return ACERVO.get();
    }

    public String getMOTIVO() {
        return MOTIVO.get();
    }
    

    
  
        
}
