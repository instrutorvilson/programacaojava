/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.modelo;

import java.sql.Connection;
import java.util.Calendar;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Instant;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.ConectaDB;

/**
 *
 * @author vilson.moro
 */
public class Compromisso {

    private Contato contato;
    private String data;
    private String hora;
    private String local;
    private String observacao;
    
    public boolean salvar(){
        try {
            String sql = "insert into compromisso"
                    +"(contatoId,data, hora, local, observacao)"
                    +"values(?,?,?,?,?)";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, this.contato.getId());
            stm.setString(2, data);
            stm.setString(3, hora);
            stm.setString(4, local);
            stm.setString(5, observacao);
            stm.execute();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    public Compromisso() {

    }

    public Compromisso(Contato contato, String data, String hora, String local, String observacao) {
        this.contato = contato;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.observacao = observacao;
    }

    
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

   
    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Compromisso{" + "contato=" + contato + ", data=" + data + ", hora=" + hora + ", local=" + local + ", observacao=" + observacao + '}';
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    

}
