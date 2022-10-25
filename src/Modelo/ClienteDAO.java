
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    
    public boolean RegistrarCliente(Cliente c1){
        String sql = "INSERT INTO clientes (dni, nombre, telefono, direccion, razon) VALUES(?,?,?,?,?)";
        
        try{
            con = cn.getConection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, c1.getDni());
            ps.setString(2, c1.getNombre());
            ps.setInt(3, c1.getTelefono());
            ps.setString(4, c1.getDireccion());
            ps.setString(5, c1.getRazon());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }finally{
            try{
                con.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    
    
    
}
