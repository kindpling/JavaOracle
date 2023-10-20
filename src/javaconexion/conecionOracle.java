
package javaconexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public final class conecionOracle {
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Connection conn = null;
    private String url, user, pass;
    

    public conecionOracle() {
        conectar();
    }
    public void conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver"); //Driver
            url = "jdbc:oracle:thin:@localhost:1521:bdc";
            user = "HR";
            pass = "12345";
            conn = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null,"te conectaste");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"error, no se puede conectar");
        }
    }
    public void consultarBaseDeDatos(String consultaSQL) {
        try {
            ps = conn.prepareStatement(consultaSQL);
            rs = ps.executeQuery();

            // muestra los resultados 
            while (rs.next()) {
                String resultado = rs.getString("country_name");
                System.out.println(resultado); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage());
        } finally {
            // cierra los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}