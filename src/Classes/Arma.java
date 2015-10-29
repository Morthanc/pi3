/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio
 * @author Uriel
 */
@XmlRootElement(name = "Arma")
public class Arma {

    String connectionUrl = "jdbc:sqlserver://localhost:1433;\" +\n"
            + "      \"databaseName=QuadrilhaDeMorte;user=usuarioDB;password=1234";
    
    private String nome;
    private String tipo;
    private String calibre;
    private String capacidade;
    private String comprimentoTotal;
    private String fabricante;
    private int quantidade;

    public Arma() {
        
    }

    public Arma(String nome, String tipo, String calibre, String capacidade, String comprimentoTotal, String fabricante, int quantidade) {
        this.nome = nome;
        this.tipo = tipo;
        this.calibre = calibre;
        this.capacidade = capacidade;
        this.comprimentoTotal = comprimentoTotal;
        this.fabricante = fabricante;
        this.quantidade = quantidade;
    }

    /**
     * @return the nome
     */
    @XmlElement
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    @XmlElement
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the calibre
     */
    @XmlElement
    public String getCalibre() {
        return calibre;
    }

    /**
     * @param calibre the calibre to set
     */
    public void setCalibre(String calibre) {
        this.calibre = calibre;
    }

    /**
     * @return the capacidade
     */
    @XmlElement
    public String getCapacidade() {
        return capacidade;
    }

    /**
     * @param capacidade the capacidade to set
     */
    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    /**
     * @return the comprimentoTotal
     */
    @XmlElement
    public String getComprimentoTotal() {
        return comprimentoTotal;
    }

    /**
     * @param comprimentoTotal the comprimentoTotal to set
     */
    public void setComprimentoTotal(String comprimentoTotal) {
        this.comprimentoTotal = comprimentoTotal;
    }

    /**
     * @return the fabricante
     */
    @XmlElement
    public String getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    /**
     * @return the quantidade
     */
    @XmlElement
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public boolean ficoTudoBunito() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            Connection conn = DriverManager.getConnection(connectionUrl);

            System.out.println("Conexão obtida com sucesso.");

            PreparedStatement ps = conn.prepareStatement("INSERT INTO dbo.Produtos (nome, tipo, calibre, capacidade, comprimento, fabricante, quantidade)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, getNome()); // atribui o valor que usuário coloca a coluna NOME
            ps.setObject(2, getTipo()); // idem, na coluna tipo
            ps.setObject(3, getCalibre());
            ps.setObject(4, getCapacidade());
            ps.setObject(5, getComprimentoTotal());
            ps.setString(6, getFabricante());
            ps.setObject(7, getQuantidade());

            int result = ps.executeUpdate();
            
            
           return true;
        } catch (SQLException ex) {

            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | HeadlessException e) {
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
            
            return false;
        }
    }

}
