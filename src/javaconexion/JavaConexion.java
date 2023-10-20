
package javaconexion;


public class JavaConexion {

    public static void main(String[] args) {
    conecionOracle conexion = new conecionOracle();
    String consultaSQL = "select * from countries where country_name like 'A%'";
    conexion.consultarBaseDeDatos(consultaSQL);
    }
}




