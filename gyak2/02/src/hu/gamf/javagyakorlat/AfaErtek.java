/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.gamf.javagyakorlat;

/**
 *
 * @author 4-11-3-Hallgato
 */
public enum AfaErtek {
 
    _27(new Double(27)),
    _15(new Double(15));
    
    private Double ertek;
    private AfaErtek(Double ertek) {    
        this.ertek = ertek;
    }
    
    public Double getErtek(){
        return ertek;
    }
    
     public static AfaErtek getEnum(String keresendo){
         return getEnum(Double.valueOf(keresendo));
    }
     public static AfaErtek getEnum(Double keresendo){
       for(AfaErtek afaErtek : values()){
           
           if(afaErtek.getErtek().equals(keresendo)){
               return afaErtek;
           }
       }
       throw new IllegalArgumentException("Hiba Történt, nem megfelelő enum érték");
    }
}
