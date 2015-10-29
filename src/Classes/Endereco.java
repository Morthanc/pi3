/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Mauricio
 */
public class Endereco {
    
    String connectionUrl = "jdbc:sqlserver://localhost:1433;\" +\n"
            + "      \"databaseName=QuadrilhaDeMorte;user=usuarioDB;password=1234";

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String cidade;
    private String estado;

    public Endereco() {
    }

    
    
    public Endereco(String logradouro, String bairro, String cep, String numero, String cidade, String estado) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    
    
    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the bairro
     */
    public String getComplemento() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setComplemento(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to fset
     */
    
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the 
     */
    
    // André esteve aqui!! Paz de Cristo!
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean fivouBonito(){
    try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

                Connection conn = DriverManager.getConnection(connectionUrl);

                System.out.println("Conexão obtida com sucesso.");

                PreparedStatement psEndereco = conn.prepareStatement("INSERT INTO dbo.Endereco (logradouro, bairro, numero, cep, cidade,estado)"
                        + "VALUES (?, ?, ?, ?, ?, ?)");
                psEndereco.setString(1, getLogradouro());
                psEndereco.setString(2, getComplemento());
                psEndereco.setString(3, getNumero());
                psEndereco.setString(4, getCep());
                psEndereco.setString(5, getCidade());
                psEndereco.setObject(6, getEstado());

                int result2 = psEndereco.executeUpdate();

                return true;
            } catch (SQLException ex) {
                
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
                return false;
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
                return false;
            }
    }
    
}
