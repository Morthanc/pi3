/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sport_fitness.doa;

/**
 *
 * @author heito
 */
import com.mycompany.spot_fitness.entidade.LoginBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginDAO extends Conexao {

    private Connection con = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    public void cadastrarLogin(LoginBean user) {
        String sql = "insert into Usuarios(nameUser,pasUser) value(?,?)";

        try {
            con = conexao();
            pst = con.prepareStatement(sql);
            pst.setString(1, user.getNameUser());
            pst.setString(2, user.getPasUser());

            pst.executeQuery();
        } catch (SQLException | ClassNotFoundException error) {
            System.out.println(error);
        }
    }

    public boolean selecionarLogin(String nameUser, String pasUser) {
        String sql = "select * from Usuarios";

        try {
            con = conexao();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String user = rs.getString("nameUser");
                if (user.equals(nameUser)) {
                    String password = rs.getString("pasUser");
                    if (password.equals(pasUser)) {
                        return true;
                    }else{
                        JOptionPane.showMessageDialog(null,"Senha incorreta");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"Usuário não cadastrado");
                }
            }
        } catch (SQLException | ClassNotFoundException error) {
            System.out.println(error);
        }
        return false;
    }
}
