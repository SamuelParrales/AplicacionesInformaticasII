/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import Dao.CorreoDaoImplFichero;
import Dao.CorreoDao;
import Dao.CorreoDaoImplPg;
import entidades.CorreoElectronico;
import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author parra
 */
public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
       
        CorreoDao ficheroDao = new CorreoDaoImplFichero("C:\\mbox-short.txt");      //Objeto que permiten acceder a los datos del fichero
        CorreoDao PgDao = new CorreoDaoImplPg(); //Objeto que permite acceder a los datos de la base de datos
        List<CorreoElectronico> lista = ficheroDao.list();      //Lee los correos electronicos
    
        int loops = lista.size();
        
        for(int i =0;i<loops;i++)       //Se insertan los correos electronicos en la base de datos
        {
            CorreoElectronico correo = lista.get(i);
            PgDao.save(correo);
        }
        
        
    }
}
