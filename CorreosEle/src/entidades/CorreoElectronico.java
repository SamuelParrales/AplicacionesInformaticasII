/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author parra
 */
public class CorreoElectronico {
    private int idCorreo;
    private String remitente;
    private String fecha;
    private String asunto;

    public CorreoElectronico(int idCorreo, String remitente, String Fecha, String Asunto) {
        this.idCorreo = idCorreo;
        this.remitente = remitente;
        this.fecha = fecha;
        this.asunto = asunto;
    }
    
    public CorreoElectronico()
    {
        
    }

    public int getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(int idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String Fecha) {
        this.fecha = Fecha;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String Asunto) {
        this.asunto = Asunto;
    }
    
}
