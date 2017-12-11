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
public class DetalleGrupo {
    String idGrupo;
     String asesor;
    String numBoleta;

    public DetalleGrupo(String idGrupo, String asesor, String numBoleta) {
        this.idGrupo = idGrupo;
        this.asesor = asesor;
        this.numBoleta = numBoleta;
    }
    
    
    
    
    /**
     * @return the idGrupo
     */
    public String getIdGrupo() {
        return idGrupo;
    }

    /**
     * @param idGrupo the idGrupo to set
     */
    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }

    /**
     * @return the asesor
     */
    public String getAsesor() {
        return asesor;
    }

    /**
     * @param asesor the asesor to set
     */
    public void setAsesor(String asesor) {
        this.asesor = asesor;
    }

    /**
     * @return the numBoleta
     */
    public String getNumBoleta() {
        return numBoleta;
    }

    /**
     * @param numBoleta the numBoleta to set
     */
    public void setNumBoleta(String numBoleta) {
        this.numBoleta = numBoleta;
    }
    
    
    
}
