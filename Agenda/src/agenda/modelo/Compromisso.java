/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.modelo;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import utils.ConectaDB;
import java.sql.ResultSet;

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
    
    public ResultSet getFilterByLocal(String filtro){
        ResultSet rs = null;
        try {
            String sql = "select c.data, c.hora,c.local,"
                    + " c.observacao, ct.nome"
                    + " from compromisso c, contato ct"
                    + " where c.idcontato = ct.codcontato "
                   + " and local like '%" + filtro+ "%'";
           // Connection con = ConectaDB.getConexao();
           // PreparedStatement stm = con.prepareStatement(sql);
            PreparedStatement stm = ConectaDB.getConexao().prepareStatement(sql);
            rs = stm.executeQuery();            
        } catch (SQLException ex) {
           throw new RuntimeException(ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet getFilterByName(String filtro){
        ResultSet rs = null;
        try {
            String sql = "select c.data, c.hora,c.local,"
                    + " c.observacao, ct.nome"
                    + " from compromisso c, contato ct"
                    + " where c.idcontato = ct.codcontato "
                   + " and nome like '%" + filtro+ "%'";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);            
            rs = stm.executeQuery();            
        } catch (SQLException ex) {
           throw new RuntimeException(ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet getAll(String dataInicio, String dataFim){
        ResultSet rs = null;
        try {
            String sql = "select c.data, c.hora,c.local,"
                    + " c.observacao, ct.nome"
                    + " from compromisso c, contato ct"
                    + " where c.idcontato = ct.codcontato "
                    + " and data between ? and ?";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, dataInicio);
            stm.setString(2, dataFim);
            rs = stm.executeQuery();            
        } catch (SQLException ex) {
           throw new RuntimeException(ex.getMessage());
        }
        return rs;
    }
    
    public ResultSet getAll(){
        ResultSet rs = null;
        try {
            String sql = "select c.data, c.hora,c.local,"
                    + " c.observacao, ct.nome"
                    + " from compromisso c, contato ct"
                    + " where c.idcontato = ct.codcontato";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();            
        } catch (SQLException ex) {
           throw new RuntimeException(ex.getMessage());
        }
        return rs;
    }
    public boolean salvar(){
        try {
            String sql = "insert into compromisso"
                    +"(idcontato,data, hora, local, observacao)"
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
