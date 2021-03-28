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


public class Contato {
    private String nome;
    private String email;
    private String fone;

    public Contato() {
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
    
}
