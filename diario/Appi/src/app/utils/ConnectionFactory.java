package app.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    Connection con;

    public ConnectionFactory() {
        try {
            Class.forName("com.mysql.jdbc.Drver");
        } catch (ClassNotFoundException e) {
            System.err.println("Erro ao carregar o driver");
        }
    }

    public static Connection getConnection() throws SQLException {
        String driver, url, usuario, senha;

        driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost/";
        usuario = "root";
        senha = "";
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
       Connection conexao =  DriverManager.getConnection("jdbc:mysql://localhost:3306/diario","root",""); 
       return conexao;

     /*   try {
            Class.forName(driver);
            return DriverManager.getConnection(url + database + "?useTimezone=true&serverTimezone=UTC&useSSL=false", usuario, senha);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver não encontrado: " + e);
            return null;
        } catch (SQLException e) {
            System.err.println("Falha ao conectar ao banco de dados: " + e);
            return null;
        }*/
    }
    
    /*public static Connection getDiario() {
        return getConnection("diario");
    }

    public static Connection getBiblioteca() {
        return getConnection("biblioteca");
    }*/
}
