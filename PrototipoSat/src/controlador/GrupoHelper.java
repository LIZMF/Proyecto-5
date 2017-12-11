/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Conexion.DBConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOM
 */
public class GrupoHelper {
    
    DBConexion conn;
    Candidato user;
    private static PreparedStatement pState = null;

    Connection conexion;
    Statement st;
    
    public GrupoHelper(){
        conn =new DBConexion();
        
        user=null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            String bDatos = "jdbc:oracle:thin:@localhost:1521:XE";
            conexion = DriverManager.getConnection(bDatos, "system", "oracle");
            st = conexion.createStatement();
            System.out.println("En linea");
        } catch (Exception ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    
    
    public String InsertarMienbroAlGrupo(String boleta, int id_grupo) {
        String insert = "INSERT INTO DETALL_GRUPOS (ID_GRUPO, NUM_BOLETA) VALUES(?,?)";  
   
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
           
            ps = conexion.prepareStatement(insert);
            
            ps.setInt(1, id_grupo);
            ps.setString(2, boleta);       
            
            
            ps.executeUpdate();
            conexion.commit();
            return "SE AGREGO CORRECTAMENTE A LA BASE DE DATOS";
        } catch (Exception ex) {
            Logger.getLogger(GrupoHelper.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR: NO SE AGREGO CORRECTAMENTE";
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
                Logger.getLogger(GrupoHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public String InsertarGrupo(int  grupo) {
        
        String insert = "INSERT INTO GRUPOS (ID_GRUPO) VALUES(?)";  
   
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
            
            ps = conexion.prepareStatement(insert);
            
            ps.setInt(1, grupo);       
                        
            ps.executeUpdate();
         conexion.commit();
            return "SE AGREGO CORRECTAMENTE A LA BASE DE DATOS";
        } catch (Exception ex) {
            Logger.getLogger(GrupoHelper.class.getName()).log(Level.SEVERE, null, ex);
            return "ERROR: NO SE AGREGO CORRECTAMENTE";
        } finally {
            try {
                ps.close();
            } catch (Exception ex) {
                Logger.getLogger(GrupoHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    public ResultSet VerGrupos() {
        try {
            Connection accesoBD = conn.getConexion();
            String sql = "SELECT * FROM GRUPOS";
            Statement consulta = accesoBD.createStatement();
            return consulta.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(GrupoHelper.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    
    }
    
   
    public int numeroGrupos( ) {
        try {
            Connection accesoBD = conn.getConexion();
            String sql = "SELECT COUNT(*) AS NUMGRUP FROM GRUPOS";
            Statement consulta = accesoBD.createStatement();
            ResultSet resultado = consulta.executeQuery(sql);
            if (resultado.next()) {
                return resultado.getInt("NUMGRUP");
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(GrupoHelper.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    
    
}
