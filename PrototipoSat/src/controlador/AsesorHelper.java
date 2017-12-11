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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TOM
 */
public class AsesorHelper {
    
    DBConexion conn;
    private static PreparedStatement pState = null;

    Connection conexion;
    Statement st;

    public AsesorHelper(){
          conn = new DBConexion();
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
    
    
     public boolean guardarAsesor(Asesores asesor){
        String insert = "INSERT  INTO ASESORES(NOMBRE,APELL_PATERNO,APELL_MAT,CUBICULO,EMAIL ,HORARIO) values(?,?,?,?,?,?)";
        
        PreparedStatement ps = null;
        try {
            conexion.setAutoCommit(false);
            
            ps = conexion.prepareStatement(insert);
            
            ps.setString(1, asesor.getNombre());
            ps.setString(2, asesor.getApellidoP());
            ps.setString(3, asesor.getApellidoM());
            ps.setString(4, asesor.getCubiculo());
            ps.setString(5, asesor.getEmail());
            ps.setString(6,asesor.getHorarioAsesorias());
           
            
            ps.executeUpdate();
            conexion.commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally{
            try {
                ps.close();
                
            } catch (Exception ex) {
                Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
   
     
     
 public ArrayList<Asesores> GetAsesores()
    {
        ArrayList<Asesores> lista = new ArrayList<Asesores>();
        
         Statement sent = conn.getStatement();
        if (sent == null)
            return lista;
        
        String strSQL = "SELECT NOMBRE,APELL_PATERNO,APELL_MAT,CUBICULO,EMAIL,HORARIO FROM ASESORES";
        try
        {
            ResultSet rs = sent.executeQuery(strSQL);
            
            //Si exite solo un empleado con el nombre dado
            while (rs.next())
            {
                
                String nombre = rs.getString("NOMBRE");
                String apPaterno = rs.getString("APELL_PATERNO");
                String apMaterno=rs.getString("APELL_MAT");
                String cubiculo=rs.getString("CUBICULO");
                String email=rs.getString("EMAIL");
                String horario=rs.getString("HORARIO");
                
                
                Asesores user = new Asesores(nombre, apPaterno, apMaterno,cubiculo, email, horario);
                
                
                user.nombre = nombre;
                user.apellidoP =apPaterno ;
                user.apellidoM = apMaterno;
                user.cubiculo=cubiculo;
                user.email=email;
                user.horarioAsesorias=horario;
                               
                lista.add(user);
            }
                        
        }
        catch(SQLException e)
        {
                System.out.println("ERROR: " + e.getMessage());
        }
        
        return lista;
    }

     
     
    
}
