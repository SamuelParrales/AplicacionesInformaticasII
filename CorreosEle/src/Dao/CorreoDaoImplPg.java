/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import accesodatos.SqlConnectionDb;
import entidades.CorreoElectronico;
import java.util.List;


/**
 *
 * @author parra
 */
public class CorreoDaoImplPg implements CorreoDao{
    SqlConnectionDb conn;
    
    public boolean save(CorreoElectronico correo) {
       this.conn = new SqlConnectionDb();
       boolean save = true;        //bandera para indicar si se almacenaron los cambios
        
        try {
            if (correo.getIdCorreo() == 0) {  //es cero cuando se esta ingresando un registro nuevo: ver inicializac'on del atributo 
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql
                sql.append("insert into \"CorreoElectronico\" (remitente,fecha,asunto) Values (");
                sql.append("'"+correo.getRemitente()+"',");      //crear la cadena de conexion
                sql.append("'"+correo.getFecha()+"',");      //crear la cadena de conexion
                sql.append("'"+correo.getAsunto()+"'").append(")");      //crear la cadena de conexion
                
                this.conn.execute(sql.toString());      //ejecuta la query
            } else {   //es un registro previamente existente: estamos actualizando
                StringBuilder sql = new StringBuilder();   //para crear la sentencia sql

//                sql.append("UPDATE articulo SET codigo = '").append(articulo.getCodigo());
//                sql.append("', descripcion = '").append(articulo.getDescripcion());      //crear la cadena de conexion
//                sql.append("', stockactual = '").append(articulo.getStockactual());      //crear la cadena de conexion
//                sql.append("', stockminimo = '").append(articulo.getStockminimo());      //crear la cadena de conexion
//                sql.append("', tipo = '").append(articulo.getTipo());      //crear la cadena de conexion
//                sql.append("', fechacaducidad = '").append(articulo.getFechacaducidad()).append("' WHERE idarticulo = ").append(articulo.getIdarticulo());      //crear la cadena de conexion

/*                sql.append("UPDATE \"articulo\" SET \"codigo\" = \'").append(articulo.getCodigo());
                sql.append("\', \"descripcion\" = ").append(articulo.getDescripcion());      //crear la cadena de conexion
                sql.append(", \"stockactual\" = ").append(articulo.getStockactual());      //crear la cadena de conexion
                sql.append(", \"stockminimo\" = ").append(articulo.getStockminimo());      //crear la cadena de conexion
                sql.append(", \"tipo\" = ").append(articulo.getTipo());      //crear la cadena de conexion
                sql.append(", \"fechacaducidad\" = '").append(articulo.getFechacaducidad()).append("' WHERE \"idarticulo\" = ").append(articulo.getIdarticulo());      //crear la cadena de conexion   */
                this.conn.execute(sql.toString());      //ejecuta la query
            }
            save = true;                                //cambia estado de bandera
        } catch(Exception e){
            
        } finally {
            this.conn.close();      //cerrar la conexion
        }
        return save; 
    }

    @Override
    public List<CorreoElectronico> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

}
