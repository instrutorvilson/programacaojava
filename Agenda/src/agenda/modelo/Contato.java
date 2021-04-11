/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda.modelo;

import utils.ConectaDB;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Contato {
    private int id;
    private String nome;
    private String email;
    private String fone;

    public Contato() {
    }

    public Contato(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Contato(String nome, String email, String fone) {
        this.nome = nome;
        this.email = email;
        this.fone = fone;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }      
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    @Override
    public String toString() {
        return "Contato{" + "nome=" + nome + ", email=" + email + ", fone=" + fone + '}';
    }
    
    public boolean salvar(){
        try {
            //conectar ao banco
            Connection con = ConectaDB.getConexao();
            //montar sql
            String sql = "insert into contato(nome, fone, email)"
                    + "values(?,?,?)";
            //envia sql para o banco de dados
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.nome);
            stm.setString(2, this.fone);
            stm.setString(3, this.email);
            stm.execute();            
        } catch (SQLException ex) {
            System.out.println("Erro: " + ex.getMessage());
            return false;
        }
        return true;
    }
    
    public ResultSet getAll(){
        ResultSet rs = null;
        try {
            String sql = "select codcontato, nome from contato";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            rs =  stm.executeQuery();
        } catch (SQLException ex) {
           System.out.println("Erro: " + ex.getMessage());
        }
        return rs;
    }
    
    public static Contato getById(int id){
        Contato contato = null;
        try {
            String sql = "select * from contato " +
                    "where codcontato = ?";
            Connection con = ConectaDB.getConexao();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs =  stm.executeQuery();
            if(rs.next()){
                contato = new Contato();
                contato.setId(rs.getInt("codcontato"));
                contato.setNome(rs.getString("nome"));
                contato.setFone(rs.getString("fone"));
                contato.setEmail(rs.getString("email"));                
            }
            
        } catch (SQLException ex) {
            //
        }        
        return contato;
    } 

    
    
}
