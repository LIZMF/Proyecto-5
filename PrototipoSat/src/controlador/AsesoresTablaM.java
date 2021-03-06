/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author TOM
 */
public class AsesoresTablaM extends  AbstractTableModel implements TableModelListener {
    
      ArrayList<Asesores> lista;
    String[] encabezados;
    
    public AsesoresTablaM()
    {
        lista  = new ArrayList<Asesores>();
        encabezados = new String[6];
        encabezados[0] = "CORREO_ELECTRONICO";
        encabezados[1] = "NOMBRE";
        encabezados[2] = "APELL_PATERNO";
        encabezados[3] = "APELL_MATERNO";
        encabezados[4] = "CUBICULO";
        encabezados[5] ="HORARIO_ASESORIAS";
    }
    
    
    public AsesoresTablaM(ArrayList<Asesores> lista)
    {
        this();
        this.lista = lista;
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return encabezados.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex >= 0 && columnIndex < encabezados.length)
            return encabezados[columnIndex];
        
        return "Sin Nombre";
    }

    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Asesores user = lista.get(rowIndex);
        
        switch(columnIndex)
        {
            case 0: return  user.email;
            case 1: return  user.nombre;
            case 2: return  user.apellidoP;
            case 3: return  user.apellidoM;
            case 4: return  user.cubiculo;
            case 5:return user.horarioAsesorias;
            
            default: return "Non emplementar";
        }
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        if (rowIndex<0 && columnIndex< 0)
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
        Asesores user = lista.get(rowIndex);
        
        switch(columnIndex)
        {
            case 0:  user.email = (String)aValue;
                     break;
            case 1: user.nombre = (String)aValue;
                     break;
            case 2: user.apellidoP  = (String)aValue;
                     break;
            case 3: user.apellidoM = (String)aValue;
                     break;
            case 4: user.cubiculo = (String)aValue;
                     break;
            case 5: user.horarioAsesorias =(String)aValue;
                    break;
            
        }
        
    }

           @Override
    public void tableChanged(TableModelEvent e) {
       
    }
}
