
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tss
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            String url = "jdbc:mariadb://localhost:3306";

            try(Connection connection = DriverManager.getConnection(url, "tss", "root")){
            System.out.println("Connessione ok...");
            connection.setCatalog("DBscuola");
            Statement cmd = connection.createStatement();
            
            try ( ResultSet rs = cmd.executeQuery("select * from t_corsi")) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1));
                }
            }
                String createTable = "CREATE TABLE `DBscuola`.`new_table` (\n"
                        + "  `id` INT NOT NULL,\n"
                        + "  PRIMARY KEY (`id`))";
                cmd.executeUpdate(createTable);
            }
        } catch (SQLException ex) {
            System.out.println("Errore..." + ex);
        }
    }

}
