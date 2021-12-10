/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import entidades.CorreoElectronico;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author parra
 */
public class CorreoDaoImplFichero implements CorreoDao{
    private List<CorreoElectronico> list;
    private String directorio;
    
    public CorreoDaoImplFichero(String directorio) throws FileNotFoundException
    {
       this.directorio = directorio;
       this.read();
    }
    private void read() throws FileNotFoundException //Metodo que lee el fichero
    {
        list = new ArrayList<>();           //Arra
        CorreoElectronico correoElec;
        
        String fecha = null, from = null, subject = null;
        File doc = new File(directorio); //"C:\\mbox-short.txt"
        Scanner obj = new Scanner(doc);
        
        while (obj.hasNextLine())
        {
            String linea = obj.nextLine(); //
            if((fecha!=null)&&(from!=null)&&(subject!=null))
            { 
                if(match(linea,"--"))
                {
                    correoElec = new CorreoElectronico();
                    correoElec.setIdCorreo(0);
                    correoElec.setRemitente(from);
                    correoElec.setFecha(fecha);
                    correoElec.setAsunto(subject);
                    list.add(correoElec);
                    fecha=null;
                    from=null;
                    subject=null;
                }
                continue;
            }
        
            if(this.match(linea, "Date:"))
            {
                fecha= linea.substring(6);
            }
            
            if(this.match(linea, "From:"))
            {
                from = linea.substring(6);
            } 
            
            if(this.match(linea, "Subject:"))
            {
                subject = linea.substring(8);
            } 
        }
    }
    
    
   
    
    private boolean match(String cadena,String exp)
    {
        Pattern pat = Pattern.compile(exp);
        Matcher mat = pat.matcher(cadena);
        if(mat.find())
            return true;
        
        return false;
    }

    @Override
    public List<CorreoElectronico> list() {
        return list;
    }

    @Override
    public boolean save(CorreoElectronico correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
