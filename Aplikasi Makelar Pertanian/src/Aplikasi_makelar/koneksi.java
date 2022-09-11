/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi_makelar;

/**
 *
 * @author Sherlock
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class koneksi {
    private static Connection KoneksiDatabase;
    
    public static Connection getKoneksi() throws SQLException {
      
        try {
            String DB ="jdbc:mysql://localhost:3306/makelar_tani";
            String user="root";
            String pass="";
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            KoneksiDatabase = (Connection) DriverManager.getConnection(DB,user,pass);
            System.out.println("Berhasil Terhubung");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Tidak ada koneksi","Error",
            JOptionPane.INFORMATION_MESSAGE);
            System.err.println(e.getMessage());
            System.exit(0);
        }
         return KoneksiDatabase;
    }


    
 public static void main(String[] args) throws SQLException {
    getKoneksi();
        // TODO code application logic here
    }
}
