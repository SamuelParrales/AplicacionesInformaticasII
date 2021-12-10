/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
import entidades.CorreoElectronico;
import java.util.List;

/**
 *
 * @author parra
 */
public interface CorreoDao {
    public List<CorreoElectronico> list();    //prototipo metodo listar desde pgsql
    public boolean save (CorreoElectronico correo);   //prototipo metodo guardar en pgsql
}
