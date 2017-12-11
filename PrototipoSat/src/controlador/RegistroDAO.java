/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Conexion.DBConexion;
import java.io.File;
import java.io.FileInputStream;
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
public class RegistroDAO {
    
   DBConexion conn;
   Registro user;
    private static PreparedStatement pState = null;

    Connection conexion;
    Statement st;

    public RegistroDAO() {
        conn = new DBConexion();
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

    public boolean guardarRegistro(Registro candidato){
        String insert = "INSERT  INTO REGISTRO(MATRICULA ,CONTRASENA) values(?,?)";
        
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
            
            ps = conexion.prepareStatement(insert);
            
            ps.setString(1, candidato.getMat());
            ps.setString(2, candidato.getCont());
                                 
            
            
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(RegistroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                ps.close();
               
            } catch (Exception ex) {
                Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
    
    
    public int ValidarIngreso(String nombre,String pass) {
       int resultado=0;
       String sql2 = "SELECT * FROM REGISTRO WHERE MATRICULA = '" + nombre + "'"+" AND "+"CONTRASENA = '"+pass+"'";
       Connection conect = null; 
       try {
           
            
            conect=conn.getConexion();
            Statement consulta = conect.createStatement();
           ResultSet rs= consulta.executeQuery(sql2);
            if(rs.next()){

            resultado=1;

        }
//            consulta.executeQuery(sql);
           
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return resultado;
    }
    
    
}
