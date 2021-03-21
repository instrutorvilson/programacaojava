/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.modelo;

import java.util.Calendar;
import java.sql.Date;
import java.time.Instant;
import java.util.GregorianCalendar;

/**
 *
 * @author vilson.moro
 */
public class Compromisso {

    private Contato contato;
    private Date data;
    private Date hora;
    private String local;
    private String observacao;

    public Compromisso() {

    }

    public Compromisso(Contato contato, Date data, Date hora, String local, String observacao) {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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

}
