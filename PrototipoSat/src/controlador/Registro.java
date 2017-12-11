/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author TOM
 */
public class Registro {
    public String mat;
    public String cont;

    public Registro(String mat, String cont) {
        this.mat = mat;
        this.cont = cont;
    }
    
    
    /**
     * @return the mat
     */
    public String getMat() {
        return mat;
    }

    /**
     * @param mat the mat to set
     */
    public void setMat(String mat) {
        this.mat = mat;
    }

    /**
     * @return the cont
     */
    public String getCont() {
        return cont;
    }

    /**
     * @param cont the cont to set
     */
    public void setCont(String cont) {
        this.cont = cont;
    }
    
    
    
}
