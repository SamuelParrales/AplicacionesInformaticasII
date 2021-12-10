/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author parra
 */
public class SqlConnectionDb {
   protected Connection connection;  //objeto de conexion
   
    public SqlConnectionDb() 
    {
        this.open();        //llama al metodo que se implementa abajo
    }
 
    
    public Connection open() {   //implementacion del metodo abstracto que abre bd
        Global global = new Global(); //Objeto que captura los datos para conectar a la base de datos
        
        String urlDatos = global.getURL();
        String username = global.getUSER();
        String pass = global.getPASS();
        try{
            Class.forName(global.getDRIVER());
            this.connection = DriverManager.getConnection(urlDatos,username, pass);  //subindice 0: nombre bd. paremtro 1: usr; parametro 2: clave.. llega en constructor
        } catch (Exception e){
            e.printStackTrace();
        }
        return this.connection;     //devuelve la conexion q es atributo declarada en superclase
    }
   
   public ResultSet query(String query){ //metodo para recibir un query y ejecutar
       Statement st;        //objeto para ejecutar las querys
       ResultSet rs = null;  //tabla para contener los datos que se generen. Incia con Null
       
       try{
           st = connection.createStatement();
           rs = st.executeQuery(query);     //ejecutar la query
       } catch (SQLException e){
           e.printStackTrace();
       }
       return rs;           //devuelve el resultSet
   }
   
   public boolean execute(String query){ //metodo para ejecutar query
       Statement st;        //objeto para ejecutar las querys
       boolean save = true;  //bandera indicadora de exito en la ejecución
       
       try{
           st = connection.createStatement();
           st.executeUpdate(query);     //ejecutar la query
       } catch (SQLException e){
           save = false;
           e.printStackTrace();
       }
       return save;           //devuelve bandera
   }
   
   public boolean close(){     //metodo para cerrar la conexion
       boolean ok = true;
       
       try{
           connection.close();  //cierra la conexion
       } catch (Exception e) {
           ok = false;          //cambia bandera
           e.printStackTrace(); //error
       }
       return ok;           //devuelve bandera indicadora de cierre bd
   }
}
